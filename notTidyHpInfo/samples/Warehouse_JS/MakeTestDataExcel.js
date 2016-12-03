/****************************************************************************
 * テストデータ作成ツール
 ***************************************************************************/

/****************************************************************************
 * グローバル定数（IEではconstは未定義なので、仕方なくvarを使う）
 ***************************************************************************/
/** DB仕様書定義：テーブル一覧シート */
var CST_DB_SHIYOSYO_TBLLIST = "テーブル一覧"; // テーブル一覧シート名
var CST_DB_SHIYOSYO_TBLLIST_R_X = 4;		// テーブル一覧の論理名列
var CST_DB_SHIYOSYO_TBLLIST_B_X = 5;		// テーブル一覧の物理名列
var CST_DB_SHIYOSYO_TBLLIST_START_Y = 4; 	// テーブル一覧の開始行
/** DB仕様書定義：書くテーブルシート */
var CST_DB_SHIYOSYO_TBLS_CM_B_X = 3; 		// テーブルカラム物理名列
var CST_DB_SHIYOSYO_TBLS_CM_B_START_Y = 8; 	// テーブルカラム物理名開始行
/** デフォルト値のレコード数 */
var CST_DEF_DATA_CNT = 50; 	


/****************************************************************************
 * グローバルオブジェクト
 ***************************************************************************/
// WSHオブジェクト
var wsh = new ActiveXObject("WScript.Shell");
// Excelオブジェクトを取得(Excelの起動)
var ExcelApp = new ActiveXObject( "Excel.Application" );
// アプリケーションShell
var objShell = WScript.CreateObject("Shell.Application")
//  ログファイル関連の操作を提供するオブジェクトを取得
var fs = new ActiveXObject( "Scripting.FileSystemObject" );
var logfile = fs.OpenTextFile( 
	("LOG"+comDateFormat(new Date(), "yyyyMMddHHmmssfff")+".txt"), 2, true );
// DB仕様書オブジェクト
var dbSpecificationsBook = null;


/****************************************************************************
 * @ 実行ポイント
 ***************************************************************************/
function main()
{
	try
	{
		/** Excelアプリケーションを表示 */
		ExcelApp.Visible = true;
		// ファイル選択ダイアログ
		var tempfile = selectfile("エクセルファイル(*.xlsm),*.xlsm","DB仕様書選択");
		// DB設計書テンプレート
		wlog("ファイル取得");
	    if(tempfile==false){
			WScript.Echo("ファイルは選択されなかったみたいだ……。");
			return;
	    }
		// テンプレートファイル作成
		MakeTemplate_FromDBspecs(tempfile);
		wlog("ファイル取得");
		// フォルダ選択ダイアログ
		//WScript.Echo(selectdir());
		// エクセル開始
		//excel_start();
	} catch( e ) {
		alert( e );  // バグの内容をダイアログで表示する
	}finally{
		// ログファイル後始末
		wlog("PROC END");
		logfile.Close();
		logfile = null;
		//  Excelを終了
		ExcelApp.Quit();
		wlog("PROC END");
		//  オブジェクトを解放
		ExcelApp = null;
	}
}
main();


/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// ▼ ここから↓は、ビジネスロジック
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

/****************************************************************************
 * テンプレートファイル作成
 * @param tile DB仕様書ファイルパス
 ***************************************************************************/
function MakeTemplate_FromDBspecs(file)
{
	try
	{
		wlog("MakeTemplate_FromDBspecs() -> " + file);

		/** DB仕様書のオブジェクト取得 */
		var dbSpecBook = ExcelApp.Workbooks.Open(file);

		/** テーブル一覧リストのシートを取得 */
	    var wsTables = dbSpecBook.Worksheets(CST_DB_SHIYOSYO_TBLLIST);

		/** 出力用Bookの作成 */
		var outTmpBook = ExcelApp.Workbooks.Add();

		/** テーブル一一覧のテーブル名毎に処理する  */
		for(var y=CST_DB_SHIYOSYO_TBLLIST_START_Y ; ; y++)
		{
			/** セルの終端判定 */
			var value = wsTables.Cells(y, CST_DB_SHIYOSYO_TBLLIST_B_X);
			if(value != value +"")
			{
				break;
			}

			/** テーブル物理名でのシート作成 */
			outTmpBook.Worksheets.Add(
				outTmpBook.Worksheets(outTmpBook.Worksheets.Count)).Name
					= value;

			/** DB仕様書のテーブル定義シートオブジェクトを取得 */
			var wsTbl = dbSpecBook.Worksheets(
				wsTables.Cells(y, CST_DB_SHIYOSYO_TBLLIST_R_X).Value);
			wlog("MakeTemplate_FromDBspecs() 2");

			/** シート内の全セルの属性を文字列にする */
			outTmpBook.Worksheets(outTmpBook.Worksheets.Count).Activate
			outTmpBook.Worksheets(outTmpBook.Worksheets.Count).Cells.Select
			wlog("MakeTemplate_FromDBspecs() 3");

			/** 各テーブルのカラム物理名とデフォルトデータを格納 */
			for(var yy=CST_DB_SHIYOSYO_TBLS_CM_B_START_Y ; ; yy++)
			{
				/** セルの終端判定 */
				var value2 = wsTbl.Cells(yy, CST_DB_SHIYOSYO_TBLS_CM_B_X);
				wlog("MakeTemplate_FromDBspecs() 4 > " + value2);
				if(value2 != value2 +"")
				{
				//	wlog("MakeTemplate_FromDBspecs() 4 > break;");
					break;
				}

				/** カラム物理名を取得して、出力シートの一行目に張る */
				outTmpBook.Worksheets(
					wsTables.Cells(y, 5).Value).Cells(1, yy - 7).Value
						= value2.Value.toUpperCase();
				wlog("MakeTemplate_FromDBspecs() 5 > ");
				/** デフォルト値を設置する CST_DEF_DATA_CNT */
				for(var i=1 ; i < CST_DEF_DATA_CNT ; i++)
				{
					outTmpBook.Worksheets(
						wsTables.Cells(y, 5).Value).Cells(1 + i, yy - 7).Value
							= makeDefaultData(wsTbl.Cells(yy, 4).Value);
				//	wlog("MakeTemplate_FromDBspecs() 6 > " + yy);
				//	wlog("MakeTemplate_FromDBspecs() 6 > " + wsTbl.Cells(yy, 4).Value);
				}
			}
		}
		wlog("MakeTemplate_FromDBspecs() loop end");
	    /** bookの保存 */
		outTmpBook.Close(true);
	} catch( e ) {
		alert( e );  // バグの内容をダイアログで表示する
	}
}

/****************************************************************************
 * テンプレートファイル作成
 * @param データ型
 * @return tile デフォルトデータ
 ***************************************************************************/
function makeDefaultData(type)
{
	switch( true )
	{
	/** 文字列 */
	case /VARCHAR*/.test(type.toUpperCase()) : 
		return("A");
	/** 数値 */
    case /NUMBER*/.test(type.toUpperCase()) : 
    	return("0");
	/** 時刻 */
    case /TIMESTAMP*/.test(type.toUpperCase()) :
    	return("2014-05-07 10:00:00");
	/** 日付 */
    case /DATE*/.test(type.toUpperCase()) : 
    	return("2014-05-07 10:00:00");
	/** 上記以外 */
     default : 
    	return("0");
    }
}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// ▼ ここから↓は、共通処理(ダイアログ関連)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * ファイル選択ダイアログ
 * @param filter ファイル選択フィルタ
 * @param tile ダイアログタイトル
 * @return 取得ファイルパス
 ***************************************************************************/
function selectfile(filter,title)
{
    /** ファイル選択ダイアログを開く */
    var tmpFileName = ExcelApp.GetOpenFilename(filter,1,title,false);
	return(tmpFileName);
}

/****************************************************************************
 * フォルダ選択ダイアログ
 ***************************************************************************/
function selectdir() {
	var folder = objShell.BrowseForFolder(0, "フォルダ選択", 0);
	if (folder == null) return;
	var path = folder.Self.Path;
	return path;
}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// ▼ ここから↓は、共通処理(ログ関連)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * ログ出力
 * @param str 出力メッセージ
 ***************************************************************************/
function wlog(str)
{
	if(logfile!=null)
	{
		logfile.WriteLine(
			comDateFormat(new Date(),
			 "yyyy/MM/dd HH:mm:ss.fff") + " >> " + str);
	}
}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// ▼ ここから↓は、共通処理(日付操作)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * [機能]	ゼロパディングを行います
 * [引数]	value	対象の文字列
 * 			length	長さ
 * [戻値]	結果文字列
 ***************************************************************************/
function comPadZero(value, length){
	return new Array(length - ('' + value).length + 1).join('0') + value;
}

/****************************************************************************
 * [機能]	日付オブジェクトから文字列に変換します
 * [引数]	date	対象の日付オブジェクト
 * 			format	フォーマット
 * [戻値]	フォーマット後の文字列
 ***************************************************************************/
function comDateFormat(date, format)
{
	var result = format;
	var f;
	var rep;
	var yobi = new Array('日', '月', '火', '水', '木', '金', '土');
	f = 'yyyy';
	if ( result.indexOf(f) > -1 ) {
		rep = date.getFullYear();
		result = result.replace(/yyyy/, rep);
	}
	f = 'MM';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMonth() + 1, 2);
		result = result.replace(/MM/, rep);
	}
	f = 'ddd';
	if ( result.indexOf(f) > -1 ) {
		rep = yobi[date.getDay()];
		result = result.replace(/ddd/, rep);
	}
	f = 'dd';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getDate(), 2);
		result = result.replace(/dd/, rep);
	}
	f = 'HH';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getHours(), 2);
		result = result.replace(/HH/, rep);
	}
	f = 'mm';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMinutes(), 2);
		result = result.replace(/mm/, rep);
	}
	f = 'ss';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getSeconds(), 2);
		result = result.replace(/ss/, rep);
	}
	f = 'fff';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMilliseconds(), 3);
		result = result.replace(/fff/, rep);
	}
	return result;

}
/****************************************************************************
 * エクセル開始 と 終了
 ***************************************************************************/
function excel_start()
{
	//  Excelアプリケーションを表示
	ExcelApp.Visible = true;

	//  新しいブックを追加し、1シート目を取得
	var book = ExcelApp.Workbooks.Add();
	var sheet = book.Worksheets( 1 );

	//  セルに値を設定
	sheet.Range( "A1" ).Value = "あ";
	sheet.Cells(4, 3).Value = "う";
	WScript.Sleep( 1000 );

	//  A1のセルの値をメッセージボックスで表示
	WScript.Echo( "A1=" + sheet.Range("A1").Value );
	//  背景色を赤色に設定
	ExcelApp.Range( "A1" ).Interior.ColorIndex = 3
	WScript.Sleep( 1000 );

	//  行が4、列が3のセルの値をメッセージボックスで表示
	WScript.Echo( "行4, 列3=" + sheet.Cells(4, 3).Value );
	WScript.Sleep( 1000 );

	//  Excel関数のSum関数を呼び出す
	var anser = ExcelApp.WorksheetFunction.Sum( 10, 5, 8 );
	WScript.Echo( "10 + 5 + 8 = " + anser );
	WScript.Sleep( 1000 );

	// 既存のxlsxファイルを開く
	//var book = ExcelApp.Workbooks.Open("G:/repos/svn/crnwl/E_製造・単体テスト/E04_単体テスト仕様兼結果報告書/02_物件配信基盤/01_バッチ機能設計(常駐)/03_テストデータ/物件配信基盤反映/【店舗】掲載停止/【店舗】掲載停止_データパターン.xlsx");
	//WScript.Sleep( 1000 );

	//  ブックを閉じる
	//book.Close(true);   // 保存する
	book.Close(false);  // 保存しない

	//  Excelを終了
	ExcelApp.Quit();
	WScript.Echo("終了");
	//  オブジェクトを解放
	ExcelApp = null;
}

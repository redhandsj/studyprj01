//  
//  Excel操作
//  
//  　Excelの起動と終了。
//  
/****************************************************************************
 * グローバルオブジェクト取得
 ***************************************************************************/
// WSHオブジェクト
var wsh = new ActiveXObject("WScript.Shell");
// Excelオブジェクトを取得(Excelの起動)
var ExcelApp = new ActiveXObject( "Excel.Application" );
// アプリケーションShell
var objShell = WScript.CreateObject("Shell.Application")

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

/****************************************************************************
 * フォルダ選択ダイアログ
 ***************************************************************************/
function selectdir() {
	var folder = objShell.BrowseForFolder(0, "フォルダ選択", 0);
	if (folder == null) return;
	var path = folder.Self.Path;
	return path;
}


/****************************************************************************
 * ファイル選択ダイアログ
 ***************************************************************************/
function selectfile()
{
	var tmpFileName = objShell..GetOpenFilename(
		FileFilter:="エクセルファイル(*.xlsx),*.xlsx", FilterIndex:=1,
		Title:="デフォルトデータテンプレート", MultiSelect:=False);

//	var dialog = WScript.CreateObject("InternetExplorer.Application");
//	dialog.Filter = "Text Files|*.txt|Csv Files|*.csv|All Files|*.*";
//	dialog.InitialDir = ".";
//	if (!dialog.ShowOpen()) {
//		WScript.Echo("ファイルは選択されなかったみたいだ……。");
//		WScript.Quit();
//	}
	WScript.Echo("選択したのはこれか？\n\"" + tmpFileName + "\"");
}

/****************************************************************************
 * @ 実行
 ***************************************************************************/
// ファイル選択ダイアログ
selectfile();
// フォルダ選択ダイアログ
//WScript.Echo(selectdir());
// エクセル開始
//excel_start();



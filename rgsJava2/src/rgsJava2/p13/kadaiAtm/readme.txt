//=======================================================します==============じあ======
// 銀行ATM仕様
//===========================================================================
問題

★ 概要
 - ３種類の銀行を扱うATMがあります、ユーザを認識するカードを入れて（プログラム起動・銀行名・ユーザ名入力操作を指す）
   から預金引出・預金入金・残高表示・他銀行振込を行うまでの流れを画面で表示すること。

★ 要求仕様
 - 各銀行には以下の固有要素がります
   - 銀行名
     - 銀行固有の名称（※同名は禁止）
   - 手数料
     - 引出時に必要な手数料（固定）
   - 営業時間（固定）
     - 開店から閉店の時間
   - 他銀行振込手数料
     - 他銀行振込時に必要な手数料（固定）

 - 操作
   - プログラムは以下の操作を起動毎に一度だけ行う。

   - ATMプログラムを起動
     - プログラム起動日時を表示
     - 銀行名入力
       - 銀行が存在しない場合は、「そのような銀行はありません」として終了。
       - プログラム起動時間が、営業時間外、または、土日祝日である場合は、「営業時間ではありません。」と表示して終了
       - 営業時間内の場合のみ、以下の処理に続く。

     - ユーザ名入力
       - 銀行・ユーザ名の組み合せが存在しない場合は、「そのような口座はありません」として終了。

     - 操作（1:口座作成、2:残高照会、3:引出、4:預金、5:終了）
       - (1,2,3,4,5)以外が入力された場合は、「1 - 5 を入力して下さい」と表示し、再入力。

       - 操作が「1:口座作成」の場合
         - 既に口座が存在する場合、「既に口座が存在します。」と表示して終了
         - 指定されたユーザ名で、口座を作成（預金額０円でJSONファイルに保存）して終了

       - 操作が「2:残高照会」の場合
          - 口座がない場合、「口座がありません。作成して下さい」と表示して終了
          - 指定された銀行・ユーザで検索し、預金残高を表示して終了

       - 操作が「3:引出」の場合
          - 口座がない場合、「口座がありません。作成して下さい」と表示して終了
          - 引出金額を入力
            - 数字以外が入力された場合は、「数字を入力して下さい」と表示し、再入力。
            - 指定された銀行・ユーザで検索し、「手数料＋引出額」＞ 残高の場合、「残高が不足しています。」と表示して再入力。
            - 指定された銀行・ユーザで検索し、預金残高から「手数料＋引出額」を引いて保存して終了

       - 操作が「4:預金」の場合
          - 口座がない場合、「口座がありません。作成して下さい」と表示して終了
          - 預金金額を入力
            - 数字以外が入力された場合は、「数字を入力して下さい」と表示し、再入力。
            - 指定された銀行・ユーザで検索し、預金残高に預金金額を足して保存存して終了

       - 操作が「5:他銀行振込」の場合
          - 振り込み先の銀行を入力
             - 銀行が存在しない場合は、「そのような銀行はありません」として終了
          - 振込先ユーザ名を入力
             - 銀行・ユーザ名の組み合せが存在しない場合は、「そのような口座はありません」として終了。
          - 振り込み額を入力
            - 数字以外が入力された場合は、「数字を入力して下さい」と表示し、再入力。
            - 振込手数料＋振込金額が、残高を上回っている場合は、「残高が不足しています。」と表示して再入力。
            - 振込手数料＋振込金額を振込元の口座の残高から引いて保存、かつ、振込金額を振込先口座の残高に保存して終了

       - 操作終了時に「ありがとうございました。○○様：残高△△」で、○○にユーザ名、△△に残高を表示してプログラム終了


★ 設計仕様
 - 銀行のベースクラスを作成し、各銀行がそれを継承する形で設計して下さい。
   - 各銀行のデータ（営業時間や手数料など）変更時も、呼出し側の変更が不要であるように設計して下さい。
   - 排他やスレッド等の考慮は不要です。

 - 口座データは、JSON形式でファイルとして保存（ファイル保存位置は任意）
   - 例（口座データ）
      [
        { "g" : "銀行名", "u" : "ユーザ名", "m" : "預金残高" },
        { "g" : "銀行名", "u" : "ユーザ名", "m" : "預金残高" },
        { "g" : "銀行名", "u" : "ユーザ名", "m" : "預金残高" }
      ]


★ その他
 - JSONの取り扱いのライブラリは任意です
   - 例えば、こんなのあります：jackson-core
     - ダウンロード
       - https://github.com/FasterXML/jackson-core/wiki
     - サンプル
       - http://so-zou.jp/software/tech/programming/java/package/json/jackson.htm


★ 追加
 - 預金上限設定
 - ドル変換
 - 入出金履歴
 -





★ 機能
 - 口座開口登録
   - 預金者
     - 同名チェック
   - 預金入金
 - カード（預金者認証）
   - 引出
   - 預金
   - 残高照会
 - データ保存は、csvで保存



★ 銀行種別
 (銀行名：営業時間：手数料：振込手数料)
 - A銀行：8:30 - 23:00：100円：250円
 - B銀行：8:30 - 17:00：100円：250円
 - C銀行：9:30 - 18:30：100円：250円


★ 起動時オプション
 - 銀行：
 - ユーザ名：
 - 操作（口座開口、残高照会、引出、預金）
 -





//===========================================================================
★ JSON参考
 - http://qiita.com/tag1216/items/12d92662fd1ea25329c9

★ jackson-core
 - ダウンロード
   - https://github.com/FasterXML/jackson-core/wiki
 - サンプル
   - http://so-zou.jp/software/tech/programming/java/package/json/jackson.htm






G:\works\repos\git\redhandsj\studyprj01\studyprj01\rgsJava2\src\rgsJava2\p13\kadaiAtm\KadaiAtmMain.java




//===========================================================================




//		if (args.length > 0) {
//
//			for(String a:args){
//				System.out.println(a);
//			}
//
//		}else{
//			System.out.println("次の引数を入力して下さい。");
//			System.out.println("KadaiAtmMain (1) (2) (3)");
//			System.out.println("(1) 銀行名");
//			System.out.println("(2) 預金者名");
//			System.out.println("(3) 操作（1:口座開口登録、2:残高照会、3:引出、4:預金）");
//		}
//		return;



//		String script = "{ \"key1\" : \"val1\", \"key2\" : \"val2\", \"key3\" : { \"ckey1\" : \"cval1\", \"ckey2\" : [ \"cval2-1\", \"cval2-2\" ] } }";
//
//		ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
////        ScriptEngineManager manager = new ScriptEngineManager();
////        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        // ScriptEngine の eval に JSON を渡す時は、括弧で囲まないと例外が発生します。
//        // eval はセキュリティ的には好ましくないので、安全であることが不明なデータを扱うことは想定していません。
//        // 外部ネットワークと連携するプログラムで使用しないでください。
//        Object obj = null;
//		try {
//			obj = engine.eval(String.format("(%s)", script));
//		} catch (ScriptException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return;
//		}
//        // Rhino は、jdk1.6,7までの JavaScript エンジン。
//		// jdk1.8は「jdk.nashorn.api.scripting.NashornScriptEngine」
//        Map<String, Object> map = null;
//		try {
//			map = jsonToMap(obj, engine.getClass().getName().equals("jdk.nashorn.api.scripting.NashornScriptEngine"));
//		} catch (Exception e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return;
//		}
//        System.out.println(map.toString());




//===============================================================================




    @SuppressWarnings("rawtypes")
	static Map<String, Object> jsonToMap(Object obj, boolean rhino) throws Exception {
        // Nashorn の場合は isArray で obj が配列かどうか判断できますが、特に何もしなくても配列番号をキーにして値を取得し Map に格納できるので、ここでは無視しています。
        // Rhino だとインデックスを文字列として指定した場合に値が返ってこないようなので、仕方なく処理を切り分けました。
        // 実際は HashMap なんか使わずに自分で定義したクラス（配列はそのオブジェクトの List プロパティ）にマップすることになると思うので、動作サンプルとしてはこんなもんでよろしいかと。
        boolean array = rhino ? Class.forName("sun.org.mozilla.javascript.internal.NativeArray").isInstance(obj) : false;
        Class scriptObjectClass = Class.forName(rhino ? "sun.org.mozilla.javascript.internal.Scriptable" : "jdk.nashorn.api.scripting.ScriptObjectMirror");
        // キーセットを取得
        Object[] keys = rhino ? (Object[])obj.getClass().getMethod("getIds").invoke(obj) : ((java.util.Set)obj.getClass().getMethod("keySet").invoke(obj)).toArray();
        // get メソッドを取得
        Method method_get = array ? obj.getClass().getMethod("get", int.class, scriptObjectClass) : (rhino ? obj.getClass().getMethod("get", Class.forName("java.lang.String"), scriptObjectClass) : obj.getClass().getMethod("get", Class.forName("java.lang.Object")));
        Map<String, Object> map = new HashMap<String, Object>();
        for (Object key : keys) {
            Object val = array ? method_get.invoke(obj, (Integer)key, null) : (rhino ? method_get.invoke(obj, key.toString(), null) : method_get.invoke(obj, key));
            if (scriptObjectClass.isInstance(val)) {
                map.put(key.toString(), jsonToMap(val, rhino));
            } else {
                map.put(key.toString(), val.toString()); // サンプルなので、ここでは単純に toString() してますが、実際は val の型を有効に活用した方が良いでしょう。
            }
        }
        return map;
    }
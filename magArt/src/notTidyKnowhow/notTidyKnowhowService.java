/**
 *
 */
package notTidyKnowhow;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;


/**
 * 未整頓のノウハウが、Java8で使えるか？
 */
public class notTidyKnowhowService {
	//=======================================================================
	/**
	 * List1 メーラー起動
	 * @exception http://www.atmarkit.co.jp/fdotnet/dotnettips/211startmail/startmail.html
	 */
	private void list01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// Desktopオブジェクトの取得
	    Desktop desktop = Desktop.getDesktop();
	    // 改行
	    final String newLine = "%0D%0A";
	    // 空白
	    final String space = "%20";
	    // 件名
	    String Subject = "サブジェクト";
	    // 本文
//	    String body = "○○県知事殿\n"
//	    		+ "\n"
//	    		+ "通知者：\n";
	    String body = "○○殿"+ space + "○○様"+ newLine;
	    //String uri = "mailto:java-net@java.sun.com?cc=java-net@java.sun.com&bcc=java-net@java.sun.com&subject=＜件名＞&body=＜本文＞";
	    String uri = "mailto:?subject="+ Subject + "&body=" + body;
	    try {
	        // メーラーの起動
	        desktop.mail(new URI(uri));
	    } catch (URISyntaxException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	//=======================================================================
	/**
	 * List2 ランダム文字列
	 */
	private void list02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// ランダム
		// こっちで文字列は指定できないので、英数字だけとか、記号のみでの文字列をランダム生成したい場合は使えないので注意。
        for (int i = 0; i < 100; i++) {
        	System.out.printf("[%03d]UUID.randomUUID()：%s\n",i,UUID.randomUUID().toString());
        }


//        // ランダム
//		Random r = new java.util.Random();
//        double x, min = 1, max = 0;
//        for (int i = 0; i < 1024; i++) {
//            r.setSeed(i);
//            x = r.nextDouble();
//            if (x > max)
//                max = x;
//            if (x < min)
//                min = x;
//        }
//        System.out.println("Random ： Min=" + min + " Max=" + max);
//
//		// ランダム
//        SecureRandom sr = new java.security.SecureRandom();
//        min = 1;
//        max = 0;
//        for (int i = 0; i < 1024; i++) {
//            sr.setSeed(i);
//            x = sr.nextDouble();
//            if (x > max){
//                max = x;
//            }
//            if (x < min){
//                min = x;
//            }
//        }
//        BigDecimal bigMin = new BigDecimal(min).setScale(16,BigDecimal.ROUND_HALF_UP);
//        System.out.println("SecureRandom：Min=" + bigMin + " Max=" + max);

	}
	//=======================================================================
	/**
	 * List3 ディレクトリ作成
	 */
	private void list03(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String testpath = "G:/tmps/test";
		if (!testpath.endsWith(File.separator)) {
			testpath += File.separator;
		}

		//File newdir = new File("G:\\tmps\\test\\" + UUID.randomUUID().toString());
//		try {
			//File newdir = new File(new URI("file:/G:/tmps/test/" + UUID.randomUUID().toString()));
			File newdir = new File(testpath + UUID.randomUUID().toString());
			newdir.mkdir();
			System.out.println("パス【toString()】：" + newdir.toString());
			System.out.println("パス【toURI()】：" + newdir.toURI());
			System.out.println("パス【toPath()】：" + newdir.toPath());
			System.out.println("作成成功？：" + newdir.isDirectory());
//		} catch (URISyntaxException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
	}
	//=======================================================================
	/**
	 * List4 文字列のreplace
	 */
	private void list04(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");
	    // 発注機関名区切
//	    String[] ws = hattyuuKikan.split("　");
//	    String hattyuuKikanString = "";
//		for(String w : ws){
//			hattyuuKikanString += space + space + w + newLine;
//		}

		// 空白
	    final String space = "%20";

	    String before = "あ　い　う　え　お";
		System.out.println("before：" + before);
		before = before.replaceAll("　", space);
		System.out.println("after：" + before);
	}
	//=======================================================================
	/**
	 * List5 Vector
	 */
	private void list05(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Vector<Integer> vec = new Vector<Integer>(); //デフォルトでは要素の格納可能数は10です
        // Vector<Integer> vec = new Vector<Integer>(128); //指定可能

        // 要素を追加すると必要に応じて自動拡張
        System.out.println(vec.capacity());
        System.out.println(vec.size());
        System.out.println(vec.isEmpty());

        // 要素の追加および取得
        for(int i=0; i<20; ++i) vec.add(i);
        System.out.println(vec);
        System.out.println(vec.get(8));

        // 要素を追加すると必要に応じて自動拡張
        System.out.println(vec.capacity());
        System.out.println(vec.size());
        System.out.println(vec.isEmpty());

        // Enumerationを利用した走査
        Enumeration<Integer> e = vec.elements();
        while(e.hasMoreElements()) {
            Integer val = e.nextElement();
            System.out.println(val);
        }
	}
	//=======================================================================
	/**
	 * List6 java.sql.Date
	 */
	private void list06(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		java.sql.Date sqlNow = new java.sql.Date(System.currentTimeMillis());
		System.out.println("sqlNow：" + sqlNow.toString());

	}
	//=======================================================================
	/**
	 * List7 文字列の判定
	 */
	private void list07(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");
	    // 発注機関名区切
//	    String[] ws = hattyuuKikan.split("　");
//	    String hattyuuKikanString = "";
//		for(String w : ws){
//			hattyuuKikanString += space + space + w + newLine;
//		}
		final String PDF_SAISIGEN_K	= "saisei_k";
		final String PDF_SAISIGEN_K17	= "saisei_tsuika_k";

	    String f1 = "saisei_tsuika_k.txt";
	    String f2 = "saisei_k.txt";
	    String f3 = "aaaaaaa.txt";

	    if(f1 != null && f1.startsWith(PDF_SAISIGEN_K17)){
		    System.out.println("PDF_SAISIGEN_K17 f1 一致");
	    }
	    if(f2 != null && f2.startsWith(PDF_SAISIGEN_K17)){
		    System.out.println("PDF_SAISIGEN_K17 f1 一致");
	    }

	    if(f1 != null && f1.startsWith(PDF_SAISIGEN_K)){
		    System.out.println("PDF_SAISIGEN_K17 f2 一致");
	    }
	    if(f2 != null && f2.startsWith(PDF_SAISIGEN_K)){
		    System.out.println("PDF_SAISIGEN_K f2 一致");
	    }

	    if((f1 != null && f1.startsWith(PDF_SAISIGEN_K17)) || (f1 != null && f1.startsWith(PDF_SAISIGEN_K))){
		    System.out.println("f1 どちらかが 一致");
	    }
	    if((f2 != null && f2.startsWith(PDF_SAISIGEN_K17)) || (f2 != null && f2.startsWith(PDF_SAISIGEN_K))){
		    System.out.println("f2 どちらかが 一致");
	    }
	    if((f3 != null && f3.startsWith(PDF_SAISIGEN_K17)) || (f3 != null && f3.startsWith(PDF_SAISIGEN_K))){
		    System.out.println("f3 どちらかが 一致");
	    }
	}
	//=======================================================================
	/**
	 * List8 システムプロパティ
	 */
	private void list08(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// カレントディレクトリのパスを取得します。
	    //System.out.println("ディレクトリ： " + System.getProperty("user.dir"));
	    // システムプロパティの一覧を表示します。
	    Properties props = System.getProperties();
	    props.list(System.out);
	}
	//=======================================================================
	/**
	 * List9 文字列から日付フォーマット変換
	 * @memo 途中
	 */
	private void list09(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		 // 変換対象の日付文字列
        String dateStr = "2016-09-15 16:03:40";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        // Date型変換
        try {
			Date formatDate = sdf.parse(dateStr);
	        System.out.println("formatDate：" + formatDate.toString());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//=======================================================================
	/**
	 * List10 翌月の月末計算
	 */
	private void list10(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");

		final String strDate = "2016/08/04";

	    int yyyy = Integer.parseInt(strDate.substring(0,4));
	    int MM = Integer.parseInt(strDate.substring(5,7));
	    int dd = Integer.parseInt(strDate.substring(8,10));
	    Calendar cal = Calendar.getInstance();
	    // カレンダーに日付をセット
	    cal.set(yyyy,MM-1,dd);
	    // 月を翌月にする
	    cal.add(Calendar.MONTH, 1);

		// 末日を取得
		String ymd = String.valueOf(cal.get(Calendar.YEAR)) + "/"
				+ String.valueOf(cal.get(Calendar.MONTH)+1) + "/"
				+ String.valueOf(cal.getActualMaximum(Calendar.DATE));
	    System.out.println("ymd : " + ymd);
	    try {
			System.out.println("yyyy年MM月dd日 : " + sdf2.format((sdf1.parse(ymd))));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	//=======================================================================
	/**
	 * List11 翌月の月末計算２
	 */
	private void list11(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");

		final Date inDate = new Date();

		//-----------------------------------------------------
	    Calendar cal = Calendar.getInstance();
	    // カレンダーに日付をセット
	    cal.setTime(inDate);
	    // 月を翌月にする
	    cal.add(Calendar.MONTH, 1);

		// 末日を取得
		String ymd = String.valueOf(cal.get(Calendar.YEAR)) + "/"
				+ String.valueOf(cal.get(Calendar.MONTH)+1) + "/"
				+ String.valueOf(cal.getActualMaximum(Calendar.DATE));
		//-----------------------------------------------------

		System.out.println("ymd : " + sdf1.format(cal.getTime()));
		System.out.println("yyyy年MM月dd日 : " + sdf2.format(cal.getTime()));

	}

	//=======================================================================
	/**
	 * List12 日付の比較
	 */
	private void list12(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		 try {
			 // 日付1を「2014/01/02」に設定します
			 Date date1 = DateFormat.getDateInstance().parse("2016/10/04");

			 // 日付2を「2014/02/03」に設定します
//			 Date date2 = DateFormat.getDateInstance().parse("2014/02/03");

//			 // 2つの日付を比較し、結果によってメッセージを変えます
//			 int diff = date1.compareTo(new Date());
//			 if (diff == 0) {
//				 System.out.println("日付1と日付2は同じです");
//			 } else if (diff > 0) {
//				 System.out.println("日付1は日付2より未来の日付です");
//			 } else {
//				 System.out.println("日付1は日付2より過去の日付です");
//			 }


			 // 日時1を「2014/01/02 11:22:33」に設定します
			 Calendar cal1 = Calendar.getInstance();
			 cal1.setTime(date1);
			 cal1.add(Calendar.DAY_OF_MONTH, 1);
			 // 日時2を「2014/02/03 22:33:44」に設定します
			 Calendar cal2 = Calendar.getInstance();
			 cal2.setTime(new Date());

			 // 2つの日時を比較し、結果によってメッセージを変えます
			 int diffCal = cal1.compareTo(cal2);
			 if (diffCal == 0) {
				 System.out.println("日時1と日時2は同じです");
			 } else if (diffCal > 0) {
				 System.out.println("日時1は日時2より未来の日時です");
			 } else {
				 System.out.println("日時1は日時2より過去の日時です");
			 }
		 } catch (ParseException e) {
			 System.out.println(e);
		 }
	}
	//=======================================================================
	/**
	 * List12 日付の単純なフォーマット
	 */
	private void list13(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println(sdf.format(new Date()));

		Date date = new Date();
        System.out.println(date.toString());
	}

 	//=======================================================================
   	/**
   	 * List14 Java8のnullチェック
   	 */
   	private void list14(){
   		String field = "",msg="";
		Optional<String> fieldChk = Optional.ofNullable(field);
		Optional<String> msgChk = Optional.ofNullable(msg);
		// fieldとmsgがnullでない場合のみ実行
		fieldChk.ifPresent(str1 -> msgChk.ifPresent(str2 -> {
			System.out.println("nullじゃない");
		}));
		System.out.println("処理完了");
		return;
	}


	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// メーラー起動
		// this.list01();
		// ランダム文字列
		//this.list02();
		// ディレクトリ作成
		//this.list03();
		// 文字列のrepalce
		//this.list04();
		// Vector
		//this.list05();
		// Vector
		//this.list06();
		// 文字列の判定
		//this.list07();
		// システムプロパティ
		//this.list08();
		// 文字列から日付フォーマット変換
		//this.list09();
		// 翌月の月末計算１
		//this.list10();
		// 翌月の月末計算２
		//this.list11();
		// 日付の比較
		//this.list12();
		// 日付単純なフォーマット
		//this.list13();
		// Java8のnullチェック
		this.list14();
	}
}

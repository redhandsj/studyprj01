/**
 *
 */
package notTidyKnowhow;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
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
		this.list07();
	}
}

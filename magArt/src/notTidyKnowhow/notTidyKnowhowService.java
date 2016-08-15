/**
 *
 */
package notTidyKnowhow;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;


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

		//File newdir = new File("G:\\tmps\\test\\" + UUID.randomUUID().toString());
		try {
			File newdir = new File(new URI("file:/G:/tmps/test/" + UUID.randomUUID().toString()));
			newdir.mkdir();
			System.out.println("パス【toString()】：" + newdir.toString());
			System.out.println("パス【toURI()】：" + newdir.toURI());
			System.out.println("パス【toPath()】：" + newdir.toPath());
			System.out.println("作成成功？：" + newdir.isDirectory());
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
		this.list03();
	}
}

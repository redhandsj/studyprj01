/**
 *
 */
package magArt.againNowJava.pointOfRef;

import java.util.ArrayList;
import java.util.List;

/**
 * リファクタリングの要点
 * @author h-dodo
 *
 */
public class pointOfRef {

	/**
	 * エントリポイント
	 * @param args
	 */
	public static void main(String[] args) {
		//-------------------------------------------------------------------
		// 総称型
		//-------------------------------------------------------------------
		pointOfRef001();
		pointOfRef002();


	}
	//=======================================================================
	/**
	 * List1 Java5以前のListの使用
	 */
	private static void pointOfRef001(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// オブジェクト作成
		List list = new ArrayList();
		// 文字列追加
		list.add("Hello");
		list.add("world");
		// メソッドで値を取得
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	//=======================================================================
	/**
	 * List2 総称型を利用してListを使用
	 */
	private static void pointOfRef002(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// オブジェクト作成
		List<String> list = new ArrayList<String>();
		// 文字列追加
		list.add("Hello");
		list.add("world");
		// メソッドで値を取得
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}


}

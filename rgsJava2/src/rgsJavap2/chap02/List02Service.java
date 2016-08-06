/**
 *
 */
package rgsJavap2.chap02;

import java.time.Instant;
import java.util.Date;

/**
 * List02　第2章　日付と時間の取り扱い
 */
public class List02Service {
	//=======================================================================
	/**
	 * List02_01 Date型のおさらい
	 */
	private void list02_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Date now = new Date();
		System.out.println("now：" + now);
		System.out.println("getTime：" + now.getTime());
		Date past = new Date(1316622225935L);
		System.out.println("past：" + past);
	}
	//=======================================================================
	/**
	 * List02_02 InstantおよびZonedDateTimeの利用例
	 */
	private void list02_02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 現在日時を取得
		Instant il = Instant.now();
		//



	}





	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 2.1 基本的な文字列操作
		this.list02_01();
		// 2.2 従来型APIが抱える課題
		this.list02_02();




	}
}

/**
 *
 */
package rgsJavap2.chap02;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Practice02　第2章　日付と時間の取り扱い 練習問題
 */
public class Practice02Service {
	//=======================================================================
	/**
	 * Practice02_01 練習問題２－１
	 */
	private void practice02_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 現在の100日後の日付
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 100);
		System.out.println( (new SimpleDateFormat("西暦 yyyy年 MM 月 dd 日")).format(c.getTime()) );
	}
	//=======================================================================
	/**
	 * Practice01_02 練習問題１－２
	 */
	private void practice02_02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 現在の100日後の日付
		System.out.println(LocalDate.now().plusDays(100).format(DateTimeFormatter.ofPattern("西暦 yyyy年 MM 月 dd 日")));
	}
	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		this.practice02_01();
		this.practice02_02();
	}
}

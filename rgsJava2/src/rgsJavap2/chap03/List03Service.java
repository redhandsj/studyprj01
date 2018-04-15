/**
 *
 */
package rgsJavap2.chap03;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * List03　第3章　コレクション
 */
public class List03Service {
	//=======================================================================
	/**
	 * List03_01
	 */
	private void list03_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// intは追加でないので、内部でIntegerに変換されている
		List<Integer> points = new ArrayList<>();
		points.add(10);
		points.add(80);
		points.add(75);
		points.stream().forEach(p -> System.out.println("要素：" + p));
	}
	//=======================================================================
	/**
	 * List03_02
	 */
	private void list03_02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// イテレータ
		List<Integer> points = new ArrayList<>();
		points.add(10);
		points.add(80);
		points.add(75);
		Iterator<Integer> it = points.iterator();

	}
	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 3.1 コレクションとは
		this.list03_01();
		// 3.2 ArrayListの使い方
		this.list03_02();




	}
}

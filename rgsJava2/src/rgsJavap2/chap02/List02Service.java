/**
 *
 */
package rgsJavap2.chap02;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
		// Instantとlong値との相互変換
		Instant i2 = Instant.ofEpochMilli(31920291332L);
		long l = i2.toEpochMilli();

		// ZonedDateTime の生成
		ZonedDateTime z1 = ZonedDateTime.now();
		// 東京時間 2014年1月2日3時4分5秒6ナノ秒
		ZonedDateTime z2 = ZonedDateTime.of(2014, 1,2,3,4,5,6,ZoneId.of("Asia/Tokyo"));

		// InstantとZonedDateTimeの相互変換
		Instant i3 = z2.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

		// ZonedDateTime の利用
		System.out.println("東京：" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		System.out.println("ロンドン：" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());

		// 瞬間の判定では、equals()ではなく、isEqual()を使用する
		if(z2.isEqual(z3)){
			System.out.println("同じ");
		}
	}

	//=======================================================================
	/**
	 * List02_03 LocalDateTimeの利用例
	 */
	private void list02_03(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// LocalDateTime の利用
		LocalDateTime l1 = LocalDateTime.now();
		LocalDateTime l2 = LocalDateTime .of(2014, 1,1,9,5,0,0);
		// LocalDateTime と ZonedDateTime の相互変換
		ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
		LocalDateTime l3 = z1.toLocalDateTime();
	}

	//=======================================================================
	/**
	 * List02_04 各種日時クラスのメソッド利用例
	 */
	private void list02_04(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 文字列からLocalDateを生成
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate d = LocalDate.parse("2011/08/21",f);

		// 1000日後を計算する
		d = d.plusDays(1000);
		System.out.println("1000日後は、" + d.format(f));

		// 現在日付と比較
		LocalDate now = LocalDate.now();
		if(now.isAfter(d)){
			System.out.println("nowは d より新しい");
		}
	}
	//=======================================================================
	/**
	 * List02_05 Period クラスの利用例
	 */
	private void list02_05(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		LocalDate d1 = LocalDate.of(2012, 1, 1);
		LocalDate d2 = LocalDate.of(2012, 1, 4);

		// 3日間を表すPeriodを２通りの方法で生成
		Period p1 = Period.ofDays(3);
		Period p2 = Period.between(d1, d2);

		// d2 のさらに３日後を計算
		LocalDate d3 = d2.plus(p2);
	}

	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 2.1 基本的な文字列操作
		this.list02_01();
		// 2.2 従来型APIが抱える課題
		// Time API
		this.list02_02();
		this.list02_03();
		this.list02_04();
		this.list02_05();




	}
}

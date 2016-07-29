/**
 *
 */
package magArt.againNowJava.lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *List4 関数型インターフェイスの定義
 */
@FunctionalInterface
interface BiInitFunction{
	int apply(int x, int y);
}

/**
 * ラムダ式
 */
public class LambdaExpressionService {
	//=======================================================================
	/**
	 * List1 ラムダ式のサンプル
	 */
	private void list01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");
		// twice というラムダ式を代入
		Function<Integer,Integer> twice = x -> x * 2;
		// mapメソッドの引数にラムダ式を使う
		IntStream.range(0, 10).map(x -> x * 2);
	}
	//=======================================================================
	/**
	 * List5 ラムダ式の変数への代入<br>
	 * List6 ラムダ式の処理の実行<br>
	 */
	private void list05_06(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		BiInitFunction func = (x,y)-> x + y;
		System.out.println(func.apply(1, 2));
	}

	//=======================================================================
	/**
	 * List7 List<E>に追加されたメソッドの利用例
	 */
	private void list07(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,10,7,3,9,8,6,1));
		// 3で割り切れる要素は削除
		list.removeIf(x -> x % 3 == 0 );
		// 全要素を２倍する
		list.replaceAll(x -> x * 2);
		// リスト内容を降順に
		list.sort((v1,v2) -> v2 - v1);
		// リスト内容を表示
		list.forEach(x -> System.out.println(x));
	}

	//=======================================================================
	/**
	 * List8 Map<K,V>に追加されたメソッドの利用例
	 */
	private void list08(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Map<String,Integer> fruits = new HashMap<>();
		fruits.put("りんご", 120);
		fruits.put("みかん", 90);
		fruits.put("ばなな", 60);
		// 果物の値段をすべて10% UP
		fruits.replaceAll((k,v) -> (int) Math.round(v * 1.1));
		// マップ内容を表示
		fruits.forEach((k,v) -> System.out.printf("%s は %d 円です。\n",k,v));
	}

	//=======================================================================
	/**
	 * List9 Map<K,V>に追加されたメソッドの利用例２
	 */
	private void list09(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Map<String,Integer> fruits = new HashMap<>();
		fruits.put("りんご", 120);
		fruits.put("みかん", 90);
		fruits.put("ばなな", 60);
		// ぶどうが存在しない場合、200円で追加
		fruits.computeIfAbsent("ぶどう", k -> 200);
		// ばななが存在したら半額にする
		fruits.computeIfPresent("ばなな", (k,v) -> v / 2);
		// りんごが存在したら、20円値上げ、存在しない場合は、130円で追加
		fruits.compute("りんご", (k,v) -> { return ((v != null) ? (v + 20) : 130); });
		// みかんが存在しないければ、100円で追加。存在した場合は、現在の値と100円の大きい方の値に設定
		fruits.merge("みかん", 100, (v1,v2) -> Math.max(v1, v2));
		// マップ内容を表示
		fruits.forEach((k,v) -> System.out.printf("%s は %d 円です。\n",k,v));
	}

	//=======================================================================
	/**
	 * List10 for文による記述例
	 */
	private void list10(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<String> employees = new ArrayList<>(Arrays.asList("総務部","開発部","営業部","管理部"));
		List<String> names = new ArrayList<>();
		for(String e : employees){
			// 条件により抽出
			if("開発部".equals(e)){
				names.add("第二"+e);
			}
		}
		employees.forEach(x -> System.out.println("employees：" + x));
		names.forEach(x -> System.out.println("names：" + x));
	}

	//=======================================================================
	/**
	 * List11 Stream APIによる記述例
	 */
	private void list11(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<String> employees = new ArrayList<>(Arrays.asList("総務部","開発部","営業部","管理部"));

		List<String> names = employees.stream()
				.filter(e -> "開発部".equals(e))
				.map(e -> "第二"+e)
				.collect(Collectors.toList());

		employees.forEach(x -> System.out.println("employees：" + x));
		names.forEach(x -> System.out.println("names：" + x));
	}

	//=======================================================================
	/**
	 * List12 ストリームの生成
	 */
	private void list12(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");


	}

	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// ラムダ式
		this.list01();
		this.list05_06();
		// コレクションクラスの新しいメソッド
		this.list07();
		this.list08();
		this.list09();
		// Stream API
		this.list10();
		this.list11();

	}

}

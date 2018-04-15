/**
 *
 */
package magArt.againNowJava.lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
	 * List12 ストリームの生成（Stream<T>）
	 */
	private void list12(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(5,4,2,10,7,3,9,8,6,1);
		// List<T> からストリームに変換
		Stream<Integer> stream1 = list.stream();
		// 数値の羅列からストリームを生成
		Stream<Integer> stream2 = Stream.of(1,2,3,4,5);

		stream1.forEach(x -> System.out.println("stream1：" + x));
		stream2.forEach(x -> System.out.println("stream2：" + x));
	}

	//=======================================================================
	/**
	 * List13 ストリームの生成（IntStream）
	 */
	private void list13(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 配列からストリームに変換
		IntStream stream3 = Arrays.stream(new int[]{1,2,3});
		// 数値の範囲を指定してストリーム生成
		IntStream stream4 = IntStream.range(0, 100);

		stream3.forEach(x -> System.out.println("stream3：" + x));
		stream4.forEach(x -> System.out.println("stream4：" + x));
	}

	//=======================================================================
	/**
	 * List14 中間操作
	 */
	private void list14(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(5,4,2,10,7,3,9,8,6,1);
		// 中間操作（この時点では、フィルタリングできてない）
		Stream<Integer> intStream = list.stream().filter(x -> x % 2 == 0);
		// 終端操作（この時点でフィルタリングされる）
		intStream.forEach(x -> System.out.println("intStream：" + x));
	}

	//=======================================================================
	/**
	 * List15 filterの利用
	 */
	private void list15(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		// データ絞り込み
		list.stream()
			.filter(x -> x < 5)
			.filter(x -> x % 2 == 0)
			.forEach(x -> System.out.println("list：" + x));
	}

	//=======================================================================
	/**
	 * List16 mapの利用
	 */
	private void list16(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(1,2,3,4,5);
		// データ加工
		list.stream()
			.map(x -> x * x)
			.forEach(x -> System.out.println("list：" + x));
	}

	//=======================================================================
	/**
	 * List17 distinctの利用
	 */
	private void list17(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(1,1,2,3,3,3,4,4,6);
		// 重複削除
		list.stream()
			.distinct()
			.forEach(x -> System.out.println("list：" + x));
	}

	//=======================================================================
	/**
	 * List18 peekの利用
	 */
	private void list18(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Integer> list = Arrays.asList(1,3,5);
		// フィルター確認
		list.stream()
			.peek(x -> System.out.printf("before filter: %d\n", x))
			.filter(x -> x < 3)
			.peek(x -> System.out.printf("after filter: %d\n", x))
			.collect(Collectors.toList());
	}

	//=======================================================================
	/**
	 * List20 サンプルコード用の社員クラス
	 */
	private List<Employee> list20(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("スミス","部長","開発部",54));
		employees.add(new Employee("ジョンソン","平社員","営業部",29));
		employees.add(new Employee("ウィリアムズ","課長","開発部",41));
		employees.add(new Employee("ブラウン","主任","開発部",34));
		employees.add(new Employee("ジョーンズ","部長","人事部",52));
		employees.add(new Employee("ミラー","平社員","マーケティング部",24));
		return employees;
	}

	//=======================================================================
	/**
	 * List21 forEachの利用
	 */
	private void list21(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		this.list20().stream()
			.filter(e -> "部長".equals(e.role))
			.forEach(x -> System.out.println("employees：" + x.name));
	}

	//=======================================================================
	/**
	 * List22 Collectの利用(Collectors.toList)
	 */
	private void list22(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// List<T>インスタンスに変換
		this.list20().stream().map(e -> e.name)	.collect(Collectors.toList());
	}

	//=======================================================================
	/**
	 * List23 Collectの利用(Collectors.joining)
	 */
	private void list23(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 結果をカンマで結合する
		System.out.println(this.list20().stream().map(e -> e.name).collect(Collectors.toList()));
	}

	//=======================================================================
	/**
	 * List24 Collectの利用(Collectors.groupingBy)
	 */
	private void list24(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 部署ごとにグルーピング
		this.list20().stream()
			.collect(Collectors.groupingBy(e -> e.dept))
			.forEach((dept,es) -> {
				System.out.println(dept);
				es.forEach(e -> System.out.printf(" - %s\n", e.name));
			});
	}

	//=======================================================================
	/**
	 * List25 Collectの利用(Collectors.summarizing)
	 */
	private void list25(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 集計結果を取得する
		IntSummaryStatistics summary = this.list20().stream().collect(Collectors.summarizingInt(e -> e.age));
		System.out.printf("社員数  ：%d\n",summary.getCount());
		System.out.printf("最低年齢：%d\n",summary.getMin());
		System.out.printf("最高年齢：%d\n",summary.getMax());
		System.out.printf("合計年齢：%d\n",summary.getSum());
		System.out.printf("平均年齢：%f\n",summary.getAverage());
	}

	//=======================================================================
	/**
	 * List26 anyMatch / allMatch の利用例
	 */
	private void list26(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		if(this.list20().stream().anyMatch(e -> "営業部".equals(e.dept))){
			System.out.println("社員の中に営業部の人が少なくとも１人います");
		}
		if(this.list20().stream().allMatch(e -> e.age > 22)){
			System.out.println("社員は全員２２歳以上です");
		}
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
		this.list12();
		this.list13();
		this.list14();
		this.list15();
		this.list16();
		this.list17();
		this.list18();
		// 終端操作
		this.list21();
		this.list22();
		this.list23();
		this.list24();
		this.list25();
		this.list26();
	}
}


/**
 * List19 社員クラス
 */
class Employee {
	/**
	 * 名前
	 */
	String name;
	/**
	 * 役職
	 */
	String role;
	/**
	 * 部署
	 */
	String dept;
	/**
	 * 年齢
	 */
	Integer age;
	/**
	 * コンストラクタ
	 * @param name 名前
	 * @param role 役職
	 * @param dept 部署
	 * @param age 年齢
	 */
	Employee(final String name,final String role,final String dept,final Integer age){
		this.name = name;
		this.role = role;
		this.dept = dept;
		this.age = age;
	}
}

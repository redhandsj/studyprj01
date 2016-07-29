/**
 *
 */
package magArt.againNowJava.pointOfRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 実処理
 *
 */
class PointOfRefService {
	//=======================================================================
	/**
	 * List1 Java5以前のListの使用
	 */
	private void pointOfRefProc001(){
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
	private void pointOfRefProc002(){
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
	//=======================================================================
	/**
	 * List7 Pairクラスの利用
	 */
	private void pointOfRefProc003(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// オブジェクト作成
		GenTypePair2<Integer,String> pair = new GenTypePair2<Integer,String>(1,"foo");
		// メソッドで値を取得
		System.out.println(pair.getLeft());
		System.out.println(pair.getRight());
	}
	//=======================================================================
	/**
	 * List8 ダイヤモンドオペレータの利用
	 * <ul>
	 * <li> new の <> 内部は省略可能
	 * </ul>
	 */
	private void pointOfRefProc004(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// オブジェクト作成
		GenTypePair2<Integer,String> pair = new GenTypePair2<>(1,"foo");
		// メソッドで値を取得
		System.out.println(pair.getLeft());
		System.out.println(pair.getRight());
	}
	//=======================================================================
	/**
	 * List12 総称型を用いたメソッドの呼び出し<br>
	 * List13 型指定で総称型を用いたメソッドの呼び出し
	 */
	private void pointOfRefProc005(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String[] ary = new String[]{"foo","bar","bazz"};
		// List12
		System.out.println(this.getMiddle(ary));
	}

	//=======================================================================
	/**
	 * List14 Listの使用例<br>
	 */
	private void pointOfRefProc006(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 宣言
		List<String> list = new ArrayList<>();
		// 末尾に要素追加["foo"]
		list.add("foo");
		// ０番目に要素を挿入["bar","foo"]
		list.add(0, "bar");
		System.out.println(list.get(0));

		// １番目を削除
		list.remove(1);
		System.out.println(list.size());

	}

	//=======================================================================
	/**
	 * List15 Setの使用例<br>
	 */
	private void pointOfRefProc007(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");


		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		// 追加、setは重複を持たないので、["a","b","c"] となる
		s1.addAll(Arrays.asList("a","b","c","b"));
		// ["b","c","d"] となる
		s2.addAll(Arrays.asList("b","c","d"));
		// s1 と s2 の共通要素を s1 に格納 ["b","c"]
		s1.retainAll(s2);
		// aを含むか？
		System.out.println(s1.contains("a"));
		// bを含むか？
		System.out.println(s1.contains("b"));
		// イテレータでアクセス
		for(Iterator<String> it = s1.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}

	//=======================================================================
	/**
	 * List16 Mapの使用例<br>
	 */
	private void pointOfRefProc008(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Map<String, String> map = new HashMap<>();
		map.put("SUNDAY", "日曜日");
		map.put("MONDAY", "月曜日");
		map.put("TUESDAY", "火曜日");
		map.put("WEDNESDAY", "水曜日");
		map.put("THURSDAY", "木曜日");
		map.put("FRIDAY", "金曜日");
		map.put("SATURDAY", "土曜日");
		System.out.println(map.get("SUNDAY"));
		System.out.println(map.get("SOMEDAY"));
	}

	//=======================================================================
	/**
	 * List20 配列による順次アクセス<br>
	 */
	private void pointOfRefProc009(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String[] ary = new String[]{"foo","bar","bazz"};
		for(int i=0;i<ary.length; i++){
			System.out.println(ary[i]);
		}
	}

	//=======================================================================
	/**
	 * List21 Listのインデックスによる順次アクセス<br>
	 */
	private void pointOfRefProc010(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<String> list  = Arrays.asList("foo","bar","bazz");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}

	}

	//=======================================================================
	/**
	 * List22 IteratorによるListの順次アクセス<br>
	 */
	private void pointOfRefProc011(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		List<String> list  = Arrays.asList("foo","bar","bazz");
		for(Iterator<String> it = list.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}

	//=======================================================================
	/**
	 * List23 Mapのキーによる順次アクセス<br>
	 */
	private void pointOfRefProc012(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");


		Map<String, String> map = new HashMap<>();
		map.put("SUNDAY", "日曜日");
		map.put("MONDAY", "月曜日");
		map.put("TUESDAY", "火曜日");
		map.put("WEDNESDAY", "水曜日");
		map.put("THURSDAY", "木曜日");
		map.put("FRIDAY", "金曜日");
		map.put("SATURDAY", "土曜日");
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
			System.out.println(map.get(it.next()));
		}
	}

	//=======================================================================
	/**
	 * List24 Mapのエントリによる順次アクセス<br>
	 */
	private void pointOfRefProc013(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Map<String, String> map = new HashMap<>();
		map.put("SUNDAY", "日曜日");
		map.put("MONDAY", "月曜日");
		map.put("TUESDAY", "火曜日");
		map.put("WEDNESDAY", "水曜日");
		map.put("THURSDAY", "木曜日");
		map.put("FRIDAY", "金曜日");
		map.put("SATURDAY", "土曜日");
		for(Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();){
			Map.Entry<String, String> e = it.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

	//=======================================================================
	/**
	 * List25 Mapのエントリによる順次アクセス（拡張forループ版）<br>
	 */
	private void pointOfRefProc014(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Map<String, String> map = new HashMap<>();
		map.put("SUNDAY", "日曜日");
		map.put("MONDAY", "月曜日");
		map.put("TUESDAY", "火曜日");
		map.put("WEDNESDAY", "水曜日");
		map.put("THURSDAY", "木曜日");
		map.put("FRIDAY", "金曜日");
		map.put("SATURDAY", "土曜日");
		for(Map.Entry<String, String> e : map.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

	//=======================================================================
	/**
	 * List27 配列による順次アクセス（拡張forループ版）<br>
	 */
	private void pointOfRefProc015(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String[] ary = new String[]{"foo","bar","bazz"};
		for(String s : ary){
			System.out.println(s);
		}
	}

	enum Week{
		SUNDAY,
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY
	}


	//=======================================================================
	/**
	 * List34 列挙型でのコンストラクタのとｓメソッド<br>
	 */
	enum WeekName {
		SUNDAY("SUN"),
		MONDAY("MON"),
		TUESDAY("TUE"),
		WEDNESDAY("WED"),
		THURSDAY("THU"),
		FRIDAY("FRI"),
		SATURDAY("SAT");
		final private String abbr;
		WeekName(String abbr){ this.abbr = abbr; }
		public String getAbbr(){ return this.abbr; }
	}
	private void pointOfRefProc016(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");
		System.out.println(WeekName.FRIDAY.getAbbr());
	}

	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 総称型
		//this.pointOfRefProc001();
		//this.pointOfRefProc002();
		//this.pointOfRefProc003();
		//this.pointOfRefProc004();
		//this.pointOfRefProc005();
		// コレクション API
		//this.pointOfRefProc006();
		//this.pointOfRefProc007();
		//this.pointOfRefProc008();
		//this.pointOfRefProc009();
		//this.pointOfRefProc010();
		//this.pointOfRefProc011();
		//this.pointOfRefProc012();
		//this.pointOfRefProc013();
		//this.pointOfRefProc014();
		//this.pointOfRefProc015();
		// 列挙型
		this.pointOfRefProc016();
	}
	//=======================================================================
	// 以下はサブクラス等
	//=======================================================================

	//=======================================================================
	// 以下はサブメソッド
	//=======================================================================
	/**
	 * List11 中央値を取得する簡単なメソッド
	 * <ul>
	 * <li>
	 * </ul>
	 */
	private <T> T getMiddle(T[] args){
		return args[args.length/2];
	}

	/**
	 * List17 単語の出現頻度をカウント
	 */
	private Map<String, Integer> getFrequency(String[] words){
		Map<String, Integer> map = new HashMap<>();
		for(String w : words){
			Integer cnt = map.get(w);
			if(cnt == null){
				cnt = 0;
			}
			map.put(w, cnt++);
		}
		return map;
	}

	/**
	 * List19 単語の出現頻度をカウント（getOrDefault版）
	 */
	private Map<String, Integer> getFrequencyDef(String[] words){
		Map<String, Integer> map = new HashMap<>();
		for(String w : words){
			Integer cnt = map.getOrDefault(w,0);
			map.put(w, cnt++);
		}
		return map;
	}
}


/**
 *
 */
package rgsJavap2.chap01;

import java.util.Optional;

/**
 * List01　第1章　文字列の操作
 */
public class List01Service {
	//=======================================================================
	/**
	 * List01_01 文字列調査をメソッドを利用した例
	 */
	private void list01_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String s1 = "スッキリJava";  String s2 = "Java";
		String s3="java";
		if (s2.equals(s3)) {
			System.out.println("s2とs3は等しい");
		}
		if (s2.equalsIgnoreCase(s3)) {
			System.out.println("s2とs3はケースを区別しなければ等しい");
		}
		System.out.println("s1の長さは" + s1.length() + "です");    /* 全角文字も半角文字も1文字としてカウント */
		if (s1.isEmpty()) {                                         /* length() == 0より意味が直感的 */
			System.out.println("s1は空文字です");
		}
	}
	//=======================================================================
	/**
	 * List01_02　文字列検索メソッドを利用した例
	 */
	private void list01_02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String s1 = "Java and JavaScript";
		if(s1.contains("Java")) {
			System.out.println("文字列s1は、Javaを含んでいます");
		}
		if(s1.endsWith("Java")) {
			System.out.println("文字列s1は、Javaが末尾にあります");
		}
		System.out.println("文字列s1で最初にJavaが登場する位置は" +
				s1.indexOf("Java"));
		System.out.println("文字列s1で最後にJavaが登場する位置は" +
				s1.lastIndexOf("Java"));
	}
	//=======================================================================
	/**
	 * List01_03 文字切り出しメソッドを利用した例
	 */
	private void list01_03(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String s1 = "Java Programing";
		System.out.println("文字列s1の3文字目以降は" +
				s1.substring(3));            // ⇒ a Programing
		System.out.println("文字列s1の3～8文字目以降は" +
				s1.substring(3, 8));         // ⇒ a Prog
	}
	//=======================================================================
	/**
	 * List01_04　StringBuilderを利用し文字列を１万回連結する
	 */
	private void list01_04(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10000; i++) {
			sb.append("Java");      /* (1)バッファにJavaを追加 */
			//System.out.println("i = " + i);
		}
		System.out.println(sb.toString());   /* (2)完成した連結済み文字列を取り出す */

	}
	//=======================================================================
	/**
	 * List01_05 正当なプレイヤー名であるかを判定するメソッド
	 */
	private void list01_05(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		System.out.println(isValidPlayerName(null));
		System.out.println(isValidPlayerName(""));
		System.out.println(isValidPlayerName("aaaaaaaa"));
		System.out.println(isValidPlayerName("00000000"));
		System.out.println(isValidPlayerName("d0000000"));
		System.out.println(isValidPlayerName("ZZZZZZZZ"));

	}
	/**
	 * 名前判定
	 * @param name 判定名
	 * @return 判定結果
	 * <ul>
	 * <li> true  : OK
	 * <li> false : NG
	 * </ul>
	 */
	private boolean isValidPlayerName(final String name) {
		if(name == null || name.length() != 8) {                /* 文字数が8文字であること */
			return false;
		}
		char first = name.charAt(0);
		if(!(first >= 'A' && first <= 'Z')) {   /* 最初の1文字はA～Z */
			return false;
		}
		for(int i = 1; i < 8; i++) {
			char c = name.charAt(i);
			if(!((c >= 'A' && c <= 'Z') || (c >= '0' && first <= '9'))) {
				return false;                   /* 以降の文字はA～Zか0～9 */
			}
		}
		return true;
	}
	//=======================================================================
	/**
	 * List01_06 文字列パターンを用いたプレイヤー名のチェック
	 */
	private void list01_06(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		System.out.println(isValidPlayerNameMatch(null));
		System.out.println(isValidPlayerNameMatch(""));
		System.out.println(isValidPlayerNameMatch("aaaaaaaa"));
		System.out.println(isValidPlayerNameMatch("00000000"));
		System.out.println(isValidPlayerNameMatch("d0000000"));
		System.out.println(isValidPlayerNameMatch("ZZZZZZZZ"));
	}
	/**
	 * 名前判定
	 * @param name 判定名
	 * @return 判定結果
	 * <ul>
	 * <li> true  : OK
	 * <li> false : NG
	 * </ul>
	 */
	private boolean isValidPlayerNameMatch(final String name) {
		// 値をラップする
		Optional<String> nameOpt = Optional.ofNullable(name);
		// nullの場合は空文字とする
		return nameOpt.orElse("").matches("[A-Z][A-Z0-9]{7}");
	}
	//=======================================================================
	/**
	 * List01_07 Split()メソッドを使った文字列の分割
	 */
	private void list01_07(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String s = "abc,def:ghi";
		String[] ws = s.split("[,:]");
		for(String w : ws){
			System.out.print(w + "->");
		}
		System.out.println("");
	}
	//=======================================================================
	/**
	 * List01_08 replaceAll()メソッドを使った文字列の置換
	 */
	private void list01_08(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		String s = "abc,def:ghi";
		System.out.println(s.replaceAll("[beh]", "X"));
	}
	//=======================================================================
	/**
	 * List01_09 キャラクター状態１人分の表示のためのコード
	 */
	private void list01_09(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		final String FORMAT = "%8s %6s 所持金%,5d";
		System.out.println(String.format(FORMAT, "aaaa","bbbbb",200));
	}


	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 1.2 基本的な文字列操作
		this.list01_01();
		this.list01_02();
		this.list01_03();
		// 1.3  文字列の連結
		this.list01_04();
		// 1.4 正規表現の活用
		this.list01_05();
		this.list01_06();
		this.list01_07();
		this.list01_08();
		// 1.5 文字列の書式整形
		this.list01_09();



	}
}

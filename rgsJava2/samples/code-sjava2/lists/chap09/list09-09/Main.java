public class Main {
	public static void main(String[] args) {
		Hero h = new Hero();		// この指示によりインスタンスが生まれ、
									// さらにコンストラクタの働きでHPに100が代入される
		System.out.println(h.hp);	// すでにhpには100が代入されているので、
									// 画面に「100」と表示される
	}
}

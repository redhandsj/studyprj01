public class Main {
	public static void main(String[] args) {
		Hero h1 = new Hero("ミナト");	// 文字列引数があるのでコンストラクタ1が呼び出される
		System.out.println(h1.name);	// 画面に「ミナト」と表示される

		Hero h2 = new Hero();		// 引数ないのでコンストラクタ2が呼び出される
		System.out.println(h2.name);	// 画面に「名無しさん」と表示される
	}
}

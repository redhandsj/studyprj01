public class Main {
	public static void main(String[] args) {
		Hero h = new Hero("ミナト");	// こう書いておけばコンストラクタには「ミナト」が渡される
		System.out.println(h.hp);		// 100と表示される
		System.out.println(h.name);	// ミナトと表示される
	}
}

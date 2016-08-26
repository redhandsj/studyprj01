public class Main {
	// 1つ目のaddメソッド
	public static int add(int x, int y) {
		return x + y;
	}
	// 2つ目のaddメソッド
	public static int add(int x, int y, int z) {
		return x + y + z;
	}
	public static void main(String[] args){
		System.out.println("引数が2つ。10+20=" + add(10, 20));					// 1つ目のaddメソッドが呼びだされる
		System.out.println("引数が3つ。10+20+30=" + add(10, 20, 30));			// 2つ目のaddメソッドが呼びだされる
	}
}

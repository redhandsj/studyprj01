public class Main {
	public static void main(String[] args){
		int x = 100;
		int y = 10;
		add();
	}
	public static void add(){
		int ans = x + y;		// ここで使用するつもり（エラー）
		System.out.println(x + "+" + y + "=" + ans);
	}
}
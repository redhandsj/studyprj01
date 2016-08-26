public class Main {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt("三");// APIリファレンスから送出例外を調べる
		} catch (NumberFormatException e) {
			System.out.println("例外NumberFormatExceptionをcatchしました");
		}
	}
}

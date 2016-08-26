import java.util.Date;

public class Main {
	public void printAnything(Object o) {
		// 何型でもいいから、引数を1つ受け取り画面に表示
		System.out.println(o.toString());
	}

	public static void main(String[] args) {
		Date d = new Date();
		new Main().printAnything(d);
	}
}

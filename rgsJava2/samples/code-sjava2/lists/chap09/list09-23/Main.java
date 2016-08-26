public class Main {
	public static void main(String[] args) {
		Hero.setRandomMoney();
		System.out.println(Hero.money);	// ランダムな金額が表示
		Hero h1 = new Hero();
		System.out.println(h1.money);	// 同じ額を表示
	}
}

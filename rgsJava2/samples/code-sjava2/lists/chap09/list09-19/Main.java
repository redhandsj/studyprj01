public class Main {
	public static void main(String[] args) {
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		System.out.println(h1.hp);		// インスタンスh1の箱hpを表示
		System.out.println(Hero.money);		// クラスHeroの箱hpを表示
	}
}

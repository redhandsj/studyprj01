public class Main {
	public static void main(String[] args) {
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		Thief t1 = new Thief();
		Wizard w1 = new Wizard();
		Wizard w2 = new Wizard();

		// 冒険開始！
		// まず宿屋に泊まる
		h1.setHp(h1.getHp() + 50);
		h2.setHp(h2.getHp() + 50);
		t1.setHp(t1.getHp() + 50);
		w1.setHp(w1.getHp() + 50);
		w2.setHp(w2.getHp() + 50);
	}
}

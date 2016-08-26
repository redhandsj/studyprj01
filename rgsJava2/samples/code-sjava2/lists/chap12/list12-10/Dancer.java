public class Dancer extends Character {
	public void dance() {
		System.out.println(this.name + "は情熱的に踊った");
	}
	public void attack(Matango m) {		/* 「詳細未定のattack()」を上書く */
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に3ポイントのダメージ");
		m.hp -= 3;
	}
}

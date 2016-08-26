public class Hero extends Character {
	public void atack(Matango m) {		/* attackのtが一文字足りず
										オーバーライドになっていない! */
		System.out.println(this.name + "の攻撃！");
		System.out.println("敵に10ポイントのダメージをあたえた！");
		m.hp -= 10;
	}
}

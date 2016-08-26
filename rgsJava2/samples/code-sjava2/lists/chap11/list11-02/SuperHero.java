public class SuperHero {		/* クラス名を書き換えた */
	private String name;
	private int hp;	
	private boolean flying;		/* flyingフィールドを追加 */

	public void attack(Matango m){
		System.out.println(this.name + "の攻撃！");
		m.hp -= 5;
		System.out.println("5ポイントのダメージをあたえた!");
	}

	public void run() {
		System.out.println(this.name + "は逃げ出した！");
	}
	
	public void fly(){				/* flyを追加 */
		this.flying = true;
		System.out.println("飛び上がった！");
	}

	public void land(){				/* landを追加 */
		this.flying = false;
		System.out.println("着地した！");
	}

}

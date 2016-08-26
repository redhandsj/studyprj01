public class SuperHero extends Hero {	
	private boolean flying;		
	public void fly(){			
		this.flying = true;
		System.out.println("飛び上がった！");
	}
	public void land(){			
		this.flying = false;
		System.out.println("着地した！");
	}
	public void run() {
		System.out.println("撤退した");
	}
	public void attack(Matango m){		/* 一回目の攻撃 */
		System.out.println(this.name + "の攻撃！");
		m.hp -= 5;
		System.out.println("5ポイントのダメージをあたえた!");
		
		if(this.flying) {				/* 二回目の攻撃 */
			System.out.println(this.name + "の攻撃！");
			m.hp -= 5;
			System.out.println("5ポイントのダメージをあたえた!");
		}
	}
}

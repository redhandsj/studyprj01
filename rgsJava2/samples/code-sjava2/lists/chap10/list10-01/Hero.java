public class Hero {
	int hp;	
	String name;
	Sword sword;
	static int money;	
	void bye(){
		System.out.println("勇者は別れを告げた");
	}
	void die() {
		System.out.println(this.name + "は死んでしまった！");
		System.out.println("GAME OVERです。");
	}
	void sleep() {		
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
	void attack(Matango m){
		System.out.println(this.name + "の攻撃！");
		System.out.println("お化けキノコ" + m.suffix + "に" + 
				sword.damage + "ポイントのダメージを与えた");
		m.hp -= sword.damage;

		if(m.hp <= 0) {
			System.out.println("お化けキノコ" + m.suffix + "を倒した！");
		} else {
			System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
			this.hp -= 2;
			if(this.hp <= 0) {
				this.die();
			}
		}
	}
	void sit(int sec) {	
		this.hp += sec;		
		System.out.println(this.name + "は、" + sec + "秒すわった！");
		System.out.println("HPが" + sec + "ポイント回復した.");
	}
	void slip() { 		
		this.hp -= 5;
		System.out.println(this.name + "は転んだ！");
		System.out.println("5のダメージ！");
		if(this.hp <= 0) {
			die();
		}
	}
	void run() {	
		System.out.println(this.name + "は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終HPは" + this.hp + "でした");
	}
	static void setRandomMoney() {	
		Hero.money = (int)(Math.random() * 1000);
	}
}

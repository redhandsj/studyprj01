public class Hero {
	int hp;	
	String name;
	Sword sword;
	
	void attack(){
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に5ポイントのダメージをあたえた！");
	}
	
	void sleep() {		/* 眠る(sleepメソッド) */
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
			/* 何秒座るか引数で受け取る */
	void sit(int sec) {	/* 座る(sitメソッド) */
		this.hp += sec;		/* 座る秒数だけHPを増やす */
		System.out.println(this.name + "は、" + sec + "秒すわった！");
		System.out.println("HPが" + sec + "ポイント回復した.");
	}
	
	void slip() { 		/* 転ぶ(slipメソッド) */
		this.hp -= 5;
		System.out.println(this.name + "は転んだ！");
		System.out.println("5のダメージ！");
	}
	
	void run() {		/* 逃げる(runメソッド) */
		System.out.println(this.name + "は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終HPは" + this.hp + "でした");
	}
	
	Hero(String name){		// 引数として文字列を1つ受け取る
		this.hp = 100;	
		this.name = name;	// 引数の値でnameフィールドを初期化
	}
}

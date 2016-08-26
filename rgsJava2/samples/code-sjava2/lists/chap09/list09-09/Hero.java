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
	
	// 「このクラスがnewされた直後に自動的に実行される処理」を書いたメソッド
	Hero(){
		this.hp = 100;	// 自分自身のhpフィールドを100で初期化
	}
}

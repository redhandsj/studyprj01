public class Main {
	public static void main(String[] args){
		// 勇者を生成し初期化
		Hero h = new Hero();
		h.name = "ミナト";
		h.hp = 100;
		
		// お化けキノコA(1匹目)を生成し初期化
		Matango m1 = new Matango();
		m1.hp = 50;
		m1.suffix = 'A';
		
		// お化けキノコB(2匹目)を生成し初期化
		Matango m2 = new Matango();
		m2.hp = 48;
		m2.suffix = 'B';
		
		// 消極的な冒険のはじまり
		h.slip();	// 勇者はいきなり転ぶ
		m1.run();	// お化けキノコAが逃げる
		m2.run();	// お化けキノコBも逃げる
		h.run();	// 勇者も逃げる
	}
}
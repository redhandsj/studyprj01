public class Main {
	public static void main(String[] args) {
		// 1.勇者を生成
		Hero h = new Hero();	/* Heroクラスからインスタンスを生成し変数hに入れる */
		
		// 2.フィールドに初期値をセット
		h.name = "ミナト";		/* 変数hの勇者のnameに代入 */
		h.hp = 100;				/* 変数hの勇者のhpに代入 */
		System.out.println("勇者" + h.name + "を生み出し初期化！");
	}
}

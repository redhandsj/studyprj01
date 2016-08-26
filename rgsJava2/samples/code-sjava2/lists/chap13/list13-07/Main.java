public class Main {
	public static void main(String[] args) {
		Character[] party = new Character[5];
		party[0] = new Hero();
		party[1] = new Hero();
		party[2] = new Thief();
		party[3] = new Wizard();
		party[4] = new Wizard();

		// まず宿屋に泊まる
		for(Character c : party) {		// 1名ずつ順に取り出し
			c.setHp(c.getHp() + 50);	// HPを50快復する
		}
	}
}

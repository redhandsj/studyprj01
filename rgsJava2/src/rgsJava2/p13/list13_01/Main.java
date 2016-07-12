/**
 *
 */
package rgsJava2.p13.list13_01;

import rgsJava2.p13.list13_01.monster.DeathBat;
import rgsJava2.p13.list13_01.monster.Goblin;
import rgsJava2.p13.list13_01.monster.Matango;
import rgsJava2.p13.list13_01.monster.Monster;
import rgsJava2.p13.list13_01.monster.Slime;
import rgsJava2.p13.list13_01.party.Character;
import rgsJava2.p13.list13_01.party.Hero;
import rgsJava2.p13.list13_01.party.Thief;
import rgsJava2.p13.list13_01.party.Wizard;

/**
 * アプリ起動
 * @author h-dodo
 */
public class Main {

	/**
	 * エントリポイント
	 * @param args
	 */
	public static void main(String[] args) {
		Life lf = new Wizard();
		System.out.println("-----(1)----------");
		Wizard w = new Wizard();
		Matango m = new Matango();
		w.setName("アサカ");
		w.attack(m);
		w.fireball(m);

		System.out.println("-----(2)----------");
		Character c = w;
		c.attack(m);
		//c.fireball(m); // Character には、fireballがないのでエラー

		// Characterでは曖昧なので、魔法使いと捉え直す
		//Wizard ww = c; // 下位互換の保障がないので、エラーとなる
		// ダウンキャスト防止のチェックを入れる
		if(c instanceof Wizard){
			System.out.println("---チェックOK");
			// OKなら強制的に変換する
			Wizard ww = (Wizard)c;
			ww.fireball(m);
		}

		System.out.println("-----(3)----------");
		Slime s = new Slime();
		Monster mn = new Slime();
		s.run();
		mn.run();

		System.out.println("-----(6)----------");
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		Thief t1 = new Thief();
		Wizard w1 = new Wizard();
		Wizard w2 = new Wizard();

		// 冒険開始！
		// まず宿屋に泊まる
		h1.setHp(h1.getHp() + 50);
		h2.setHp(h2.getHp() + 50);
		t1.setHp(t1.getHp() + 50);
		w1.setHp(w1.getHp() + 50);
		w2.setHp(w2.getHp() + 50);

		System.out.println("-----(7)----------");
		Character[] party = new Character[5];
		party[0] = new Hero();
		party[1] = new Hero();
		party[2] = new Thief();
		party[3] = new Wizard();
		party[4] = new Wizard();

		// まず宿屋に泊まる
		for(Character cc : party) {		// 1名ずつ順に取り出し
			cc.setHp(cc.getHp() + 50);	// HPを50快復する
		}

		System.out.println("-----(10)----------");
		Monster[] monsters = new Monster[3];
		monsters[0] = new Slime();
		monsters[1] = new Goblin();
		monsters[2] = new DeathBat();
		for(Monster mm : monsters) {
			mm.run();
		}



	}

}

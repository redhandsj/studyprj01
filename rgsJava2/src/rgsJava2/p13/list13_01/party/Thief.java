/**
 *
 */
package rgsJava2.p13.list13_01.party;

import rgsJava2.p13.list13_01.monster.Monster;

/**
 * @author h-dodo
 *
 */
public class Thief extends Character {
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * モンスターに攻撃
	 * <ul>
	 * <li> 7ポイントのダメージ
	 * </ul>
	 * @param m 攻撃対象のモンスター
	 * @see rgsJava2.p13.list13_01.party.Character#attack(rgsJava2.p13.list13_01.monster.Matango)
	 */
	@Override
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println("敵に7ポイントのダメージ");
		m.setHp(m.getHp() - 7);
	}
}

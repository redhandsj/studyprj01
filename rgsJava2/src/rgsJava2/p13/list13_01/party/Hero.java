/**
 *
 */
package rgsJava2.p13.list13_01.party;

import rgsJava2.p13.list13_01.monster.Monster;

/**
 * @author h-dodo
 *
 */
public class Hero extends Character {
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * モンスターに攻撃
	 * <ul>
	 * <li> 10ポイントのダメージ
	 * </ul>
	 * @param m 攻撃対象のモンスター
	 * @see rgsJava2.p13.list13_01.party.Character#attack(rgsJava2.p13.list13_01.monster.Matango)
	 */
	@Override
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println("敵に10ポイントのダメージ");
		m.setHp(m.getHp() - 10);
	}
}

/**
 *
 */
package rgsJava2.p13.list13_01.party;

import rgsJava2.p13.list13_01.monster.Monster;

/**
 * 魔法使い
 * <ul>
 * <li>
 * </ul>
 * @author h-dodo
 *
 */
public class Wizard extends Character {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * マジックポイント
	 */
	private int mp;

	//=======================================================================
	// getter/setter
	//=======================================================================
	/**
	 * @return mp
	 */
	public int getMp() {
		return mp;
	}

	/**
	 * @param mp セットする mp
	 */
	public void setMp(int mp) {
		this.mp = mp;
	}

	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * モンスターに攻撃
	 * <ul>
	 * <li> ３ポイントのダメージ
	 * </ul>
	 * @param m 攻撃対象のモンスター
	 * @see rgsJava2.p13.list13_01.party.Character#attack(rgsJava2.p13.list13_01.monster.Matango)
	 */
	@Override
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println("敵に3ポイントのダメージ");
		m.setHp(m.getHp() - 3);
	}

	/**
	 * モンスターに魔法攻撃
	 * <ul>
	 * <li> ２０ポイントのダメージ
	 * <li> ５ポイントのマジックポイント減少
	 * </ul>
	 * @param m 攻撃対象のモンスター
	 */
	public void fireball(Monster m) {
		System.out.println(this.getName() + "は火の玉をはなった！");
		System.out.println("敵に20ポイントのダメージ");
		m.setHp(m.getHp() - 20);
		this.mp -= 5;
	}

}

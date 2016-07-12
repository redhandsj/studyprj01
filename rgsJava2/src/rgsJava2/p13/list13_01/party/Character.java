/**
 *
 */
package rgsJava2.p13.list13_01.party;

import rgsJava2.p13.list13_01.Life;
import rgsJava2.p13.list13_01.monster.Monster;

/**
 * キャラクタ
 * @author RedHands
 *
 */
public abstract class Character implements Life {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * キャラクターの名前
	 */
	private String name;
	/**
	 * Hit Point
	 */
	private int hp;
	//=======================================================================
	// getter/setter
	//=======================================================================
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * @param hp セットする hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * 逃亡
	 */
	public void run(){
		System.out.println(this.name + "は逃げ出した");
	}
	/**
	 * マタンゴへの攻撃
	 * @param m 攻撃固体
	 */
	public abstract void attack(Monster m);

}

/**
 *
 */
package rgsJava2.p13.list13_01.monster;

/**
 * モンスター
 * @author h-dodo
 */
public abstract class Monster {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * Hit Point
	 */
	private int hp;
	/**
	 * モンスター個別認識
	 */
	private char suffix;
	//=======================================================================
	// getter/setter
	//=======================================================================
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
	/**
	 * @return suffix
	 */
	public char getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix セットする suffix
	 */
	public void setSuffix(char suffix) {
		this.suffix = suffix;
	}
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * 逃亡
	 */
	public void run(){
		System.out.println("モンスターは逃げ出した。");
	}
}

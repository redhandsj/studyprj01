/**
 *
 */
package rgsJava2.p13.kadaiAtm.bnks;

/**
 * @author h-dodo
 *
 */
public class Cbank extends Bank {
	/**
	 * コンストラクタ
	 * @param c 手数料
	 */
	public Cbank(int c){
		super();
		this.setName("C");
		this.setCommission(c);
	}
}

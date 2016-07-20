/**
 *
 */
package rgsJava2.p13.kadaiAtm.bnks;

/**
 * @author h-dodo
 *
 */
public class Bbank extends Bank {
	/**
	 * コンストラクタ
	 * @param c 手数料
	 */
	public Bbank(int c){
		super();
		this.setName("B");
		this.setCommission(c);
	}
}

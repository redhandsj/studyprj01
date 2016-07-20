/**
 *
 */
package rgsJava2.p13.kadaiAtm.bnks;

/**
 * A銀行のクラス
 * @author h-dodo
 *
 */
public class Abank extends Bank {
	/**
	 * コンストラクタ
	 * @param c 手数料
	 */
	public Abank(int c){
		super();
		this.setName("A");
		this.setCommission(c);
	}
}

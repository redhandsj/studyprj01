/**
 *
 */
package rgsJava2.p13.kadaiAtm.bnks;

/**
 * 銀行
 * @author h-dodo
 *
 */
public class Bank {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * 銀行名
	 */
	protected String name;
	/**
	 * 手数料
	 */
	protected int commission;
	/**
	 * ユーザ名
	 */
	protected String user;
	/**
	 * 預金額
	 */
	protected int deposit;
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
	 * @return commission
	 */
	public int getCommission() {
		return commission;
	}
	/**
	 * @param commission セットする commission
	 */
	public void setCommission(int commission) {
		this.commission = commission;
	}
	/**
	 * @return user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user セットする user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return deposit
	 */
	public int getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit セットする deposit
	 */
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * 口座作成
	 */
	public void create(){
		// ★存在チェック
		//
	}
	/**
	 * 残高参照
	 */
	public void zan(){

	}
	/**
	 * 入金
	 */
	public void in(){

	}
	/**
	 * 出金
	 */
	public void out(){

	}
}

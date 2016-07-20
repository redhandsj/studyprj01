/**
 *
 */
package rgsJava2.p13.kadaiAtm.data;

import java.util.Optional;

import rgsJava2.p13.kadaiAtm.bnks.Bank;

/**
 * 操作単位
 * @author h-dodo
 *
 */
public class Item {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * 操作
	 */
	private byte operation;
	/**
	 * 銀行情報
	 */
	private Bank bank;
	/**
	 * 入力された入出金金額
	 */
	private int inout;
	//=======================================================================
	// getter/setter
	//=======================================================================
	/**
	 * @return operation
	 */
	public int getOperation() {
		return operation;
	}
	/**
	 * @param operation セットする operation
	 */
	public void setOperation(byte operation) {
		this.operation = operation;
	}
	/**
	 * @return bank
	 */
	public Bank getBank() {
		return bank;
	}
	/**
	 * @param bank セットする bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	/**
	 * @return inout
	 */
	public int getInout() {
		return inout;
	}
	/**
	 * @param inout セットする inout
	 */
	public void setInout(int inout) {
		this.inout = inout;
	}
	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * 銀行登録メソッド
	 * @param bname 銀行名
	 */
	public void setBank(final String bname) {
		this.setBank(Const.bkTranslation(bname));
	}
	/**
	 * 口座作成
	 */
	public void create(){
		Optional<Bank> p = Optional.ofNullable(bank); // 値をラップする
		p.ifPresent(bank -> bank.create()); // 値が存在する場合のみ実行
	}

	/**
	 * 残高参照
	 */
	public void zan(){
		Optional<Bank> p = Optional.ofNullable(bank); // 値をラップする
		p.ifPresent(bank -> bank.zan()); // 値が存在する場合のみ実行
	}
	/**
	 * 入金
	 */
	public void in(){
		Optional<Bank> p = Optional.ofNullable(bank); // 値をラップする
		p.ifPresent(bank -> bank.in()); // 値が存在する場合のみ実行
	}
	/**
	 * 出金
	 */
	public void out(){
		Optional<Bank> p = Optional.ofNullable(bank); // 値をラップする
		p.ifPresent(bank -> bank.out()); // 値が存在する場合のみ実行
	}

}

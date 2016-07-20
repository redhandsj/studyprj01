/**
 *
 */
package rgsJava2.p13.kadaiAtm.data;

import java.util.HashMap;
import java.util.Map;

import rgsJava2.p13.kadaiAtm.bnks.Abank;
import rgsJava2.p13.kadaiAtm.bnks.Bank;
import rgsJava2.p13.kadaiAtm.bnks.Bbank;
import rgsJava2.p13.kadaiAtm.bnks.Cbank;

/**
 * 操作種別
 * @author h-dodo
 *
 */
public class Const {
	//=======================================================================
	// const：操作
	//=======================================================================
	/**
	 * 操作：不正入力
	 */
	final static public byte INPUT_MISS = 0x00;
	/**
	 * 操作：口座作成
	 */
	final static public byte CREATE = 0x01;
	/**
	 * 操作：残高照会
	 */
	final static public byte ZAN = 0x02;
	/**
	 * 操作：入金
	 */
	final static public byte IN = 0x03;
	/**
	 * 操作：出金
	 */
	final static public byte OUT = 0x04;
	//=======================================================================
	// const：銀行一覧
	//=======================================================================
	/**
	 * 銀行名一覧
	 */
	static public Map<String, Bank> banks = new HashMap<String, Bank>();
	static{
		banks.put("A", new Abank(200));
		banks.put("B", new Bbank(100));
		banks.put("C", new Cbank(500));
//		banks.put("D", new Abank());
//		banks.put("E", new Abank());
//		banks.put("F", new Abank());
//		banks.put("G", new Abank());
//		banks.put("H", new Abank());
//		banks.put("I", new Abank());
//		banks.put("J", new Abank());
	}

	//=======================================================================
	// Method
	//=======================================================================
	/**
	 * 操作種別チェック
	 * @param c チェック対象文字列
	 * @return チェック結果
	 */
	public static byte opTranslation(final String c){
		if(c.isEmpty()){
			// 入力が空
			return INPUT_MISS;
		}
		try {
			switch(Integer.parseInt(c.trim())){
			case 1: return CREATE;	// 口座作成
			case 2: return ZAN;		// 残高照会
			case 3: return IN;		// 入金
			case 4: return OUT;		// 出金
			}
		} catch (NumberFormatException nfex) {
			return INPUT_MISS;
		}
		return INPUT_MISS;
	}
	/**
	 * 銀行種別チェック
	 * @param c チェック対象文字列
	 * @return チェック結果
	 */
	public static Bank bkTranslation(final String c){
		if(c.isEmpty()){
			// 入力が空
			return null;
		}
		Bank b = Const.banks.getOrDefault(c,null);
		if(b instanceof Bank){
			return b;
		}
		return null;
	}
}

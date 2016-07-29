/**
 *
 */
package magArt.againNowJava.pointOfRef;

/**
 * リスト5 extends で制限を付けた総称型によるPairクラス
 *
 */
class GenTypePair2<L extends Number, R> {
	/**
	 * L型
	 */
	private L l;

	/**
	 * R型
	 */
	private R r;

	/**
	 * コンストラクタ
	 * @param l
	 * @param r
	 */
	GenTypePair2(final L l, final R r){
		this.l = l;
		this.r = r;
	}
	//=======================================================================
	// getter / setter
	//=======================================================================
	L getLeft(){
		// Number制限されているので、数字であることが保証されている
		System.out.println(l.intValue());
		return l;
	}
	R getRight(){ return r; }
}

/**
 *
 */
package magArt.againNowJava.pointOfRef;

/**
 * リスト4 総称型によるPairクラス
 *
 */
class GenTypePair<L, R> {
	/**
	 *
	 */
	private L l;

	/**
	 *
	 */
	private R r;

	/**
	 * コンストラクタ
	 * @param l
	 * @param r
	 */
	GenTypePair(final L l, final R r){
		this.l = l;
		this.r = r;
	}
	//=======================================================================
	// getter / setter
	//=======================================================================
	L getLeft(){ return l; }
	R getRight(){ return r; }
}

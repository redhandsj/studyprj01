/**
 *
 */
package magArt.againNowJava.pointOfRef;

/**
 * 総称型クラス
 * @author h-dodo
 *
 */
class GenType001<T> {
	/**
	 * 総称型変数
	 */
	private T var;

	/**
	 * @return var
	 */
	public T getVar() {
		return var;
	}

	/**
	 * @param var セットする var
	 */
	public void setVar(T var) {
		this.var = var;
	}

}

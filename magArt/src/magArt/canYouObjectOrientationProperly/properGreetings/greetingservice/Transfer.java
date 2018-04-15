/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingservice;

import java.io.PrintStream;

/**
 * メッセージ出力部分
 */
class Transfer {
	/**
	 * 出力先ストリーム
	 */
	private PrintStream out;

	/**
	 * コンストラクタ
	 */
	Transfer(){
		this.out = System.out;
	}

	/**
	 * 出力
	 * @param msg 出力内容
	 */
	void send(final String msg){
		out.println(msg);
	}
}

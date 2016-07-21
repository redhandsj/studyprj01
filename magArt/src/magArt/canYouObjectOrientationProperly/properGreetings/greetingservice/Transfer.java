/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingservice;

import java.io.PrintStream;

/**
 * メッセージ出力部分
 */
class Transfer {
	private PrintStream out;
	Transfer(){
		this.out = System.out;
	}
	void send(final String msg){
		out.println(msg);
	}
}

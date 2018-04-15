/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingservice;

/**
 * まともな挨拶
 */
class Launcher {

	/**
	 * メイン
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		GreetingService service = new GreetingService();
		service.greeting();
	}
}

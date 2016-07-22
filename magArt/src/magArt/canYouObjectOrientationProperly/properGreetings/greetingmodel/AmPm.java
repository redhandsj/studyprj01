/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel;

/**
 * 午前、午後の判断で挨拶の文言を決める
 */
class AmPm {
	private Clock clock;
	AmPm(){
		this.clock = new Clock();
	}
	String message(){
		return MessageType.valueOf(clock.ampm()).message();
	}
}

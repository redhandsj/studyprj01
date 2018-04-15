/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel;

/**
 * メッセージ種別
 */
enum MessageType {
	am(new MessageAm()),
	pm(new MessagePm());
	private Message msg;
	MessageType(final Message msg){
		this.msg = msg;
	}
	String message(){
		return this.msg.value();
	}
}

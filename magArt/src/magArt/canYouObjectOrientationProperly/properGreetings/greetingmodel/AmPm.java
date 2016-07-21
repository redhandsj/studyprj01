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
		if("am".equals(this.clock.ampm())){
			return "おはようございます";
		}else if("pm".equals(this.clock.ampm())){
			return "こんにちわ";
		}
		return "";
	}
}

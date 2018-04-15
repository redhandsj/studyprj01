/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel;

/**
 * 挨拶代表オブジェクト
 */
public class Greeting {
	private String userName;
	public Greeting(final String userName){
		this.userName = userName;
	}
	public String message(){
		AmPm ampm = new AmPm();
		GreetingFormat format = new GreetingFormat(this.userName, ampm);
		return format.text();
	}
}

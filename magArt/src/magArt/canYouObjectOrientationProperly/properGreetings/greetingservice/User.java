/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingservice;

/**
 * 挨拶の相手
 */
class User {
	private String name;
	User(){
		this.name = System.clearProperty("user.name");
	}
	String name(){
		return this.name;
	}
}

/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingservice;

import magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel.Greeting;

/**
 * 挨拶機能
 */
class GreetingService {
	private User user;
	private Transfer transfer;
	GreetingService(){
		this.user = new User();
		this.transfer = new Transfer();
	}
	void greeting(){
		Greeting greeting = new Greeting(user.name());
		transfer.send(greeting.message());
	}
}

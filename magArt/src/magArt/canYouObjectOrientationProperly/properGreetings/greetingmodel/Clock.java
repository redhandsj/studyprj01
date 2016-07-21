/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel;

import java.util.Calendar;
import java.util.Optional;

/**
 * 午前か午後の判断をする
 *
 */
class Clock {
	private Calendar calendar;
	Clock(){
		this.calendar = Calendar.getInstance();
	}
	String ampm(){
		if(Optional.ofNullable(this.calendar).map(c -> c.get(Calendar.HOUR_OF_DAY) <= 12).get().booleanValue()){
			return "am";
		}
		return "pm";
	}

}

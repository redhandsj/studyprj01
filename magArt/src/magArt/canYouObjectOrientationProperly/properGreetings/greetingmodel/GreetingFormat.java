/**
 *
 */
package magArt.canYouObjectOrientationProperly.properGreetings.greetingmodel;

/**
 * 名前に「さん」を付けたり、挨拶を文として組み立てる
 *
 */
class GreetingFormat {
	private String userName;
	private String msg;
	private static final String template = "%sさん、%s。";
	GreetingFormat(final String userName, final AmPm ampm){
		this.userName = userName;
		this.msg = ampm.message();
	}
	String text(){
		return String.format(template, this.userName, this.msg);
	}


}

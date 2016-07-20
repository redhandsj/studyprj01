/**
 *
 */
package rgsJava2.p09.kadaiProg;

/**
 * テレビ番組録画クラス
 * @author h-dodo
 *
 */
public class Program {
	//=======================================================================
	// variable
	//=======================================================================
	/**
	 * 曜日
	 */
	private String dayOfTheWeek;
	/**
	 * 放送開始時間
	 */
	private String broadcastStartTime;
	/**
	 * 放送時間
	 */
	private float airtime;
	/**
	 * 最大録画時間
	 */
	final static public float maxRecordingTime = 20.0f;
	/**
	 * 最大録画時間
	 */
	static public float totalRecordingTime;
	/**
	 * 放送時間初期値
	 */
	static public float broadcastInitialTime;

}

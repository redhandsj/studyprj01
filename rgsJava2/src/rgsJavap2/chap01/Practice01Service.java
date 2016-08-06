/**
 *
 */
package rgsJavap2.chap01;

import java.util.Optional;

/**
 * Practice01　第1章　文字列の操作 練習問題
 */
public class Practice01Service {
	//=======================================================================
	/**
	 * Practice01_01 練習問題１－１
	 */
	private void practice01_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 連結文字作成
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=100;i++){
			sb.append(i+",");
		}
		System.out.println("連結文字作成：" + sb.toString());

		// 分割した文字列
		String[] ws = sb.toString().split(",");
		for(String w : ws){
			System.out.println("分割：" + w);
		}
	}
	//=======================================================================
	/**
	 * Practice01_02 練習問題１－２
	 */
	private void practice01_02(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		System.out.println("FULL：" + makeFullpath("C:\\aaa\\","zzz.txt"));
		System.out.println("FULL：" + makeFullpath("C:\\bbb","zzz.txt"));
	}
	/**
	 * フルパス作成
	 * @param folder フォルダパス
	 * @param file ファイル名
	 * @return String 作成フルパス文字列
	 */
	private String makeFullpath(final String folder, final String file){
		// 値をラップする
		Optional<String> folderOpt = Optional.ofNullable(folder);
		Optional<String> fileOpt = Optional.ofNullable(file);
		String folderDecision = folderOpt.orElse("");
		String fileDecision = fileOpt.orElse("");
		// 最後尾にセパレータを追加
		if(!folderDecision.endsWith("\\")) folderDecision += "\\";
		return folderDecision + fileDecision;

	}
	//=======================================================================
	/**
	 * Practice01_03 練習問題１－３
	 */
	private void practice01_03(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		// 全ての文字列
		System.out.println("１：" + "aaaa".matches(".*"));
		// 最初の１文字はA、２文字目は数字、３文字目は数字かなし
		System.out.println("２：" + "A3".matches("A\\d{1,2}"));
		// 最初の１文字はU、２～４文字目は英大文字
		System.out.println("３：" + "USER".matches("U[A-Z]{3}"));


	}

	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		this.practice01_01();
		this.practice01_02();
		this.practice01_03();
	}
}

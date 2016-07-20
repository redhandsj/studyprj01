/**
 *
 */
package rgsJava2.p13.kadaiAtm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import rgsJava2.p13.kadaiAtm.data.Const;
import rgsJava2.p13.kadaiAtm.data.Item;

/**
 * 課題ATMメインクラス
 * @author h-dodo
 *
 */
public class KadaiAtmMain {

	/**
	 * エントリポイント
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {

		// JSON例
		String data = "{\"a\":123,\"b\":true,\"c\":\"AAAAAAAAAAA\"}";

		JsonFactory factory = new JsonFactory();
		try {
		    JsonParser parser = factory.createParser(data);
		    while (parser.nextToken() != JsonToken.END_OBJECT) {

		        String name = parser.getCurrentName();
		        JsonToken token = parser.getCurrentToken();
		        String t = null;
		        if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
				    t = parser.getText();
				}
		        System.out.println(name + ":" + token + ":" + t);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}


		// 入力情報
		Item input = new Item();

		// 銀行名入力
		System.out.print("銀行名：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 銀行名で登録する
			input.setBank(br.readLine().trim());
			// http://tomoyamkung.net/2015/10/11/java8_optional_or_else_get/
			Optional.ofNullable(input.getBank()).orElseGet(input.getBank() -> System.out.print("操作（1:口座開口登録、2:残高照会、3:引出、4:預金）："));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// ユーザ名入力
		System.out.print("ユーザ名：");
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input.getBank().setUser(br.readLine().trim());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 操作入力
		System.out.print("操作（1:口座開口登録、2:残高照会、3:引出、4:預金）：");
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input.setOperation(Const.opTranslation(br.readLine().trim()));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 操作分岐
		switch(input.getOperation()){
		case Const.CREATE: input.create(); break;
		case Const.ZAN: input.zan(); break;
		case Const.IN: input.in(); break;
		case Const.OUT: input.out(); break;
		}
	}
}

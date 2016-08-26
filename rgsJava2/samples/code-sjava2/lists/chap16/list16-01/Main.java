import java.io.*;
public class Main{
  public static void main(String[] args) throws Exception {
    String filename = "c:\\test.txt";
    FileReader fr = new FileReader(filename);  //ファイルを開く 	
    char c1 = (char) fr.read();	// 最初の１文字をよむ 
    char c2 = (char) fr.read();	// 次の1文字を読む
    fr.close();	                             // ファイルを閉じる
  }
}  

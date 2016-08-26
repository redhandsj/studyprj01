import java.io.*;
public class Main{
  public static void main(String[] args) throws Exception {
    String filename = "c:\\test.txt";
    FileWriter fw = new FileWriter (filename);  // ファイルを開く 
    fw.write('そ');		// 最初の１文字を書く 
    fw.write ('れ');		// 次の1文字を書く
    fw.close();                  // ファイルを閉じる
  }
}  

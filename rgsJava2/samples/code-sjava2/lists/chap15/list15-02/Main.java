import java.io.*;
public class Main{
  public static void main(String[] args){
    try {
      // FileWriterのコンストラクタは、IOExceptionを発生させる可能性がある
      FileWriter fw = new FileWriter("c:\\data.txt");
    }catch(IOException e) {
      // 例外的状況になった時に備えて記述された代替処理
      System.out.println("エラーが発生しました。");
    }
  }
}

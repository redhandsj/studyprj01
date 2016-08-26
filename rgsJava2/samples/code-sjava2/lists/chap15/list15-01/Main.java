import java.io.*;
public class Main{
  public static void main(String[] args){
    // FileWriterのコンストラクタは、IOExceptionを発生させる可能性があります
    // しかしtry-catchでは囲みません（失敗時にどうするか、考えていない）
    FileWriter fw = new FileWriter("c:\\data.txt");
  }
}

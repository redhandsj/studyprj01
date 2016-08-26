import java.io.*;
public class Main{
  public static void main(String[] args){
    try {			
    		FileWriter fw = new FileWriter("data.txt");
    		fw.write("hello!");		
    		fw.close();
    } catch(Exception e) {		// Exceptionの子孫どれでもキャッチ		
    		System.out.println("なんらかの例外が発生");
    }
  }
}

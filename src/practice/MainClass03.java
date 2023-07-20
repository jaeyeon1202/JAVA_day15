package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass03 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:/최재연/JAVA/practice/test.txt");
		
		FileOutputStream fos = new FileOutputStream(path, true);
		fos.write("test".getBytes());
		fos.close();
		
		FileInputStream fis = new FileInputStream(path);
		
		while(true) {
			int res =fis.read();
			if(res<=0) {
				System.out.println("내용이 없습니다.");
				break;
			}
			System.out.println((char)res);	
		}
		fis.close();
		
		
	}
}

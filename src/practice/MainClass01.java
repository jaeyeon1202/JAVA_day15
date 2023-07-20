package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass01 {
	public static void main(String[] args) throws Exception {
		
		File path = new File("E:\\최재연\\JAVA\\practice/test.txt");
		
		FileOutputStream fos = new FileOutputStream(path);
		
		fos.write(97);
		fos.write('A');
		fos.write("test".getBytes());
		
		
	}
}

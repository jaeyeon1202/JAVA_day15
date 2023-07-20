package practice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainClass04 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:최재연/JAVA/practice/test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		for(char ch='0'; ch<='9';ch++){
			bos.write(ch);
		}
		
		
	}
}

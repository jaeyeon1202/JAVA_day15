package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String path = "E:\\최재연\\JAVA\\practice/";
		System.out.println("파일명 입력: ");
		String name = sc.next();
		path = path +name+".txt";
		
		File filepath = new File(path);
		
		if(filepath.exists()) {
			System.out.println("파일이 존재합니다.");
		}else {
			FileOutputStream fos = new FileOutputStream(filepath);
			System.out.println("파일에 출력할 내용을 입력");
			String msg = sc.next();
			fos.write(msg.getBytes());
			System.out.println("저장되었습니다.");
		}
	}
}

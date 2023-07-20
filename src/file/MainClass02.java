package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		//String path = "E:\\최재연\\JAVA\\test\\test.txt"; // '/'슬러시도 가능
		
		
		//File path = new File("E:\\최재연\\JAVA\\test\\test");
		
		//File path = new File("E:\\최재연\\JAVA\\test");
		//path.mkdir();
		//path.delete();
		//String[] list = path.list();
		//System.out.println(list[0]);
		
		//System.out.println(path.exists()); //파일이 있느면 t, 없으면 f
		
		String path = "E:/최재연/JAVA/test/";
		System.out.println("파일명 입력>>");
		String name = input.next();
		path += name+".txt";
		
		File filepath = new File(path);
		if(filepath.exists()) {
			System.out.println("파일이 존재합니다. 다시...");
		}else {
			FileOutputStream fos = new FileOutputStream(filepath);
			System.out.println("파일에 출력할 내용 입력");
			String msg =input.next();
			fos.write(msg.getBytes());
			System.out.println("저장되었습니다.");
		}
		//FileOutputStream fos = new FileOutputStream(path);
		
		
		
	}
}

package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass05 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:\\최재연\\JAVA\\test/test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeUTF("hello");
		dos.writeInt(12345);
		dos.writeDouble(3.14);
		
		dos.close(); //닫을때는 역순으로 닫는다
		dos.close(); //hello -> 12345 -> 3.14
		dos.close();
		
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		String msg = dis.readUTF();
		int num = dis.readInt();
		double dou = dis.readDouble();
		System.out.println("mas: "+msg);
		System.out.println("num: "+num);
		System.out.println("dou: "+dou);
		
		dis.close();
		dis.close();
		dis.close();
		
	}
}






































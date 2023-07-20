package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

//보조스트림
public class MainClass04 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:\\최재연\\JAVA\\test/test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos); //보조스트림-기본스트림을 바탕으로 만든다
		
		for(char ch='0'; ch<='9';ch++) {
			Thread.sleep(1);
			//fos.write(ch);
			bos.write(ch);//버퍼라는 임시저장소에 저장하겠다.
		}
		
		bos.flush(); //파일로 내용을 보내라, 현재 스트림이 유지되어있는 상태, 다른 데이터를 더 보낼 수 있음
		bos.write('A');
		bos.flush();
		bos.write('B');
		bos.close(); // 내용을 파일로 전송하는건 같지만 스트림이 끊기기 때문에 더 이상 내용을 보낼 수 없다.
	}
}

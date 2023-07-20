
/*
 * package file;
 

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
import java.util.Scanner;



public class FileService {
	
	public final String path="E:/최재연/JAVA/test/member/";
	Scanner input =new Scanner(System.in);
	
	public void writeMember() {
		
		String name, addr;
		int age;
		System.out.println("이름 입력>>");
		name= input.next();
		System.out.println("주소입력>>");
		addr=input.next();
		System.out.println("나이입력>>");
		age=input.nextInt();
		
		FileDTO dto = new FileDTO();
		dto.setName(name); dto.setAddr(addr); dto.setAge(age);
		
		File filePath = new File(path+name+".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos =null;
		ObjectOutputStream oos = null;
		try {
			 fos = new FileOutputStream(filePath);
			 bos = new BufferedOutputStream(fos);
			 oos = new ObjectOutputStream(bos);
			 oos.writeObject(dto);
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
				if(bos!=null) bos.close();
				if(fos!=null) fos.close();
			} catch (Exception e2) {
				
			}
			
		}
	}
	
	public void readMember() {
	      Scanner sc = new Scanner(System.in);
	      int num;
	      System.out.println("1. 목록 보기");
	      System.out.println("2. 특정 목록 보기");
	      System.out.println("3. 모든 사용자 보기");
	      System.out.println(">>> ");
	      num = sc.nextInt();
	      
	      if(num==1) {
	    	  list();
	      }else if(num==2) {
	    	  System.out.println("파일명 입력: ");
	  		  String msg = input.next();
	    	  memberView(msg+".txt");
	      }else {
	    	  allMemberView();
	      }
	}
	
	public String[] list() {
		File file = new File(path);
		String[] fileNames = file.list();
		for(String f : fileNames) {
			System.out.println(f);
		}
		return fileNames;
	}
	
	public void memberView(String msg) {
		//Scanner input = new Scanner(System.in);
		//System.out.println("파일명 입력: ");
		//String msg = input.next();
		
		File file = new File(path+msg);
		FileInputStream fis = null;
		BufferedInputStream bis= null;
		ObjectInputStream ois = null;
		try {
			fis= new FileInputStream(file);
			bis= new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis); 
			
			FileDTO dto = (FileDTO)ois.readObject();
			
			ois.close(); bis.close(); fis.close();
			System.out.println("이름: "+dto.getName());
			System.out.println("주소: "+dto.getAddr());
			System.out.println("나이: "+dto.getAge());
		} catch (Exception e) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}
	}
	
	public void allMemberView() {
		String[] fileNames = list();
		for(String name : fileNames) {
			memberView(name);
		}
	}
	/*
	public void allMemberView(String msg) {
		String[] fileNames = list();
		for(String name : fileNames) {
			
			File file = new File(path+name);
			
			FileInputStream fis = null;
			BufferedInputStream bis= null;
			ObjectInputStream ois = null;
			
			try {
				fis= new FileInputStream(file);
				bis= new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				
				FileDTO dto = (FileDTO)ois.readObject();
				
				ois.close(); bis.close(); fis.close();
				System.out.println("이름: "+dto.getName());
				System.out.println("주소: "+dto.getAddr());
				System.out.println("나이: "+dto.getAge());
			} catch (Exception e) {
			}
		}
	}
	*/
/*
}
*/


package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
	
	public final String path = "C:/test/member/";
	public void writeMember() {
		Scanner input = new Scanner(System.in);
		String name, addr;
		int age;
		System.out.println("이름 입력");
		name = input.next();
		System.out.println("주소 입력");
		addr = input.next();
		System.out.println("나이 입력");
		age = input.nextInt();
		
		FileDTO dto = new FileDTO();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setAge(age);
		
		File filePath = new File(path + name +".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject( dto );
			System.out.println("저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( oos != null ) oos.close();
				if( bos != null ) bos.close();
				if( fos != null ) fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void readMember() {
		Scanner input = new Scanner(System.in);
		int num;
		System.out.println("1.목록 보기");
		System.out.println("2.특정 사용자 보기");
		System.out.println("3.모든 사용자 보기");
		num = input.nextInt();
		if( num == 1) { //목록보기
			list();
		}else if( num == 2 ) { //특정 사용자보기
			System.out.println("파일명 입력");
			String msg = input.next();
			memberView( msg+".txt" );
		}else { //모든 사용자보기
			allMemberView();
		}
	}
	private void allMemberView() {
		String[] fileNames = list();
		/*
		for(String name : fileNames) {
			memberView(name);
		}
		*/
		ArrayList<FileDTO> members = new ArrayList<>();
		
		for(String name : fileNames) {
			File file = new File( path+name );
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				
				FileDTO dto = (FileDTO)ois.readObject();
				members.add(dto);
				
				ois.close(); bis.close(); fis.close();
				
				//System.out.println("이름 : "+dto.getName() );
				//System.out.println("주소 : "+dto.getAddr() );
				//System.out.println("나이 : "+dto.getAge() );
				
			} catch (Exception e) {
				System.out.println("해당 사용자는 존재하지 않습니다");
			}

			System.out.println("------------------");
			System.out.println("이름\t주소\t나이");
			System.out.println("------------------");
			
			for(FileDTO d : members) {
				System.out.print(d.getName()+"\t");
				System.out.print(d.getAddr()+"\t");
				System.out.println(d.getAge() );
				System.out.println("==================");
			}
		}
		
	}
	private void memberView(String msg) {
		//Scanner input = new Scanner(System.in);
		//System.out.println("파일명 입력");
		//String msg = input.next();
		
		File file = new File( path+msg );
		FileInputStream fis = null; //바이트단위로 출력
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			FileDTO dto = (FileDTO)ois.readObject();
			
			ois.close(); bis.close(); fis.close();
			
			System.out.println("이름 : "+dto.getName() );
			System.out.println("주소 : "+dto.getAddr() );
			System.out.println("나이 : "+dto.getAge() );
			
		} catch (Exception e) {
			System.out.println("해당 사용자는 존재하지 않습니다");
		}
	}
	
	private String[] list() {
		File file = new File(path);
		String[] fileNames = file.list();
		for( String f : fileNames ) {
			System.out.println( f );
		}
		return fileNames;
	}
}

































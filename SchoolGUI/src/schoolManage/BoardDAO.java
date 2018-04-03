package schoolManage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDAO {

	List<BoardDTO> boardList = new ArrayList<BoardDTO>();// 게시판
	Scanner sc = new Scanner(System.in);

	BoardDAO() {
		boardList.add(new BoardDTO("자바바", "안녕하세요", "a"));
		boardList.add(new BoardDTO("재미지당", "반가워요반가워요반가워요반가워요반가워요반가워요반가워요반가워요반가워요반가워요", "a"));
		boardList.add(new BoardDTO("힘내라", "고마워고마워고마워고마워고마워고마워고마워고마워고마워고마워" + "고마워고마워고마워고마워", "a"));
	}

	void ShowWriteList(PersonDTO person) {//num은 객체의 인덱스.
		
		
		while (true) {
			ShowList();
			
			System.out.println("(1)글 작성 (2)글 읽기 (3)글 수정 (4)뒤로");
			System.out.print("->");
			String s = sc.nextLine();
			switch(s) {
			case "1":
				BoardWrite(person);
				break;
			case "2":
				Read();
				break;
			case "3":
				CheckIdName(person);
				break;
			case "4":
				return ;
				default :
					System.out.println("1~4 선택");
			}
		}
	}
	
	void ShowList() {
		for (int i = 0; i < boardList.size(); i++) {
			System.out.println((i + 1) + ". 제목 : " + boardList.get(i).getTitle() + "	(작성자 : "
					+ boardList.get(i).getID() + ")");
			System.out.println("--------------------------");
		}
	}
	
	
	
	
	void BoardWrite(PersonDTO person) {//학생이 게시판에 글 남길때
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String write = sc.nextLine();
		boardList.add(new BoardDTO(title,write,person.getID()));
	}
	
//	void BoardWrite(ProfessorDTO professor) {//교수가 게시판에 글 남길때
//		System.out.print("제목 : ");
//		String title = sc.nextLine();
//		System.out.println("내용 : ");
//		String write = sc.nextLine();
//		boardList.add(new BoardDTO(title,write,professor.getID()));
//	}
	
	void Read() {
		System.out.print("글 번호 -> ");
		String ss = sc.nextLine();
		int s = Integer.parseInt(ss);
		System.out.println("--------------------------------------");
		System.out.println("제목 : " + boardList.get(s-1).getTitle() + "	(작성자 : "
				+ boardList.get(s-1).getID() + ")");
		System.out.println("내용 : " + boardList.get(s-1).getWrite());
		System.out.println("--------------------------------------");

	}
	
	void CheckIdName(PersonDTO person) {	//아이디와 이름 매칭
		System.out.print("글 번호 ->");
		String ss = sc.nextLine();
		int s = Integer.parseInt(ss);
		
//		System.out.print("id -> ");
//		String id = sc.nextLine();
		
		System.out.print("비밀번호 -> ");
		String password = sc.nextLine();
		
		if(boardList.get(s-1).getID().equals(person.getID())) {
			if(password.equals((person.getPassword()))) {
				UpdateWrite(s-1);
			}else
				System.out.println("password error");
		}else {
			System.out.println("작성자만 수정 가능.");
		}
		
	}
	
	void UpdateWrite(int s) {
		System.out.println("1.제목 수정 2.내용 수정 ");
		String n = sc.nextLine();
		switch(n) {
		case "1":
			System.out.println("현제 제목 -> " + boardList.get(s).getTitle());
			System.out.print("수정할 제목 -> ");
			String title = sc.nextLine();
			boardList.get(s).setTitle(title);
			System.out.println("수정완료");
			break;
		case "2":
			System.out.print("수정할 내용 -> ");
			String write = sc.nextLine();
			boardList.get(s).setWrite(write);
			System.out.println("수정완료");
			break;
		
		default :
			return ;
		}
	}
	
}

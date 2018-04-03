package schoolManage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDAO {

	List<BoardDTO> boardList = new ArrayList<BoardDTO>();// �Խ���
	Scanner sc = new Scanner(System.in);

	BoardDAO() {
		boardList.add(new BoardDTO("�ڹٹ�", "�ȳ��ϼ���", "a"));
		boardList.add(new BoardDTO("�������", "�ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����ݰ�����", "a"));
		boardList.add(new BoardDTO("������", "����������������������������������������" + "����������������", "a"));
	}

	void ShowWriteList(PersonDTO person) {//num�� ��ü�� �ε���.
		
		
		while (true) {
			ShowList();
			
			System.out.println("(1)�� �ۼ� (2)�� �б� (3)�� ���� (4)�ڷ�");
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
					System.out.println("1~4 ����");
			}
		}
	}
	
	void ShowList() {
		for (int i = 0; i < boardList.size(); i++) {
			System.out.println((i + 1) + ". ���� : " + boardList.get(i).getTitle() + "	(�ۼ��� : "
					+ boardList.get(i).getID() + ")");
			System.out.println("--------------------------");
		}
	}
	
	
	
	
	void BoardWrite(PersonDTO person) {//�л��� �Խ��ǿ� �� ���涧
		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.println("���� : ");
		String write = sc.nextLine();
		boardList.add(new BoardDTO(title,write,person.getID()));
	}
	
//	void BoardWrite(ProfessorDTO professor) {//������ �Խ��ǿ� �� ���涧
//		System.out.print("���� : ");
//		String title = sc.nextLine();
//		System.out.println("���� : ");
//		String write = sc.nextLine();
//		boardList.add(new BoardDTO(title,write,professor.getID()));
//	}
	
	void Read() {
		System.out.print("�� ��ȣ -> ");
		String ss = sc.nextLine();
		int s = Integer.parseInt(ss);
		System.out.println("--------------------------------------");
		System.out.println("���� : " + boardList.get(s-1).getTitle() + "	(�ۼ��� : "
				+ boardList.get(s-1).getID() + ")");
		System.out.println("���� : " + boardList.get(s-1).getWrite());
		System.out.println("--------------------------------------");

	}
	
	void CheckIdName(PersonDTO person) {	//���̵�� �̸� ��Ī
		System.out.print("�� ��ȣ ->");
		String ss = sc.nextLine();
		int s = Integer.parseInt(ss);
		
//		System.out.print("id -> ");
//		String id = sc.nextLine();
		
		System.out.print("��й�ȣ -> ");
		String password = sc.nextLine();
		
		if(boardList.get(s-1).getID().equals(person.getID())) {
			if(password.equals((person.getPassword()))) {
				UpdateWrite(s-1);
			}else
				System.out.println("password error");
		}else {
			System.out.println("�ۼ��ڸ� ���� ����.");
		}
		
	}
	
	void UpdateWrite(int s) {
		System.out.println("1.���� ���� 2.���� ���� ");
		String n = sc.nextLine();
		switch(n) {
		case "1":
			System.out.println("���� ���� -> " + boardList.get(s).getTitle());
			System.out.print("������ ���� -> ");
			String title = sc.nextLine();
			boardList.get(s).setTitle(title);
			System.out.println("�����Ϸ�");
			break;
		case "2":
			System.out.print("������ ���� -> ");
			String write = sc.nextLine();
			boardList.get(s).setWrite(write);
			System.out.println("�����Ϸ�");
			break;
		
		default :
			return ;
		}
	}
	
}

package schoolManage;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//����ȭ �׽�Ʈ��
public class SchoolMain {
	static final String HOST_ID = "test";	//������ id and password
	static final String HOST_PASSWROD = "123";
	
	static Set<String> IDList = new HashSet<String>();
	static StudentDAO student = new StudentDAO();//�л�DAO
	static ProfessorDAO professor = new ProfessorDAO();//����DAO
	static BoardDAO board = new BoardDAO();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		ManagerMethod manager = new ManagerMethod();

		Scanner sc = new Scanner(System.in);
		
		
		String id, password;
		
		
		while(true) {	//ó�� ����ȭ��
			System.out.println("1.�����ڸ�� 2.�л���� 3.������� 4.����");
			String a = sc.nextLine();
			
			switch(a) {
			
			case "1":
				System.out.println("������ ���̵� : ");
				id = sc.nextLine();
				System.out.println("������ ��� : ");
				password = sc.nextLine();
				if(id.equals(HOST_ID) && password.equals(HOST_PASSWROD))
					manager.ManagerView();
				else 
					System.out.println("id or password Error!");
				break;
			case "2":
				System.out.println("���̵� : ");
				id = sc.nextLine();
				System.out.println("��� : ");
				password = sc.nextLine();
				if(student.CheckID(id,password)) {
					student.StudentView();
				}
				break;
			case "3":
				System.out.println("���̵� : ");
				id = sc.nextLine();
				System.out.println("��� : ");
				password = sc.nextLine();
				if(professor.CheckID(id,password)) {
					professor.ProfessorView();
				}
				break;
			case "4":
				System.out.println("���� �Ǿ����ϴ�.");
				return ;
				default :
					System.out.println("�߸� �������ϴ�.");
			}
		}
	}
	

	
	

	
	

	
	

	

}

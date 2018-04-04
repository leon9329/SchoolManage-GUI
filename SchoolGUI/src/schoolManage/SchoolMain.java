package schoolManage;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//동기화 테스트중
public class SchoolMain {
	static final String HOST_ID = "test";	//관리자 id and password
	static final String HOST_PASSWROD = "123";
	
	static Set<String> IDList = new HashSet<String>();
	static StudentDAO student = new StudentDAO();//학생DAO
	static ProfessorDAO professor = new ProfessorDAO();//교수DAO
	static BoardDAO board = new BoardDAO();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		ManagerMethod manager = new ManagerMethod();

		Scanner sc = new Scanner(System.in);
		
		
		String id, password;
		
		
		while(true) {	//처음 메인화면
			System.out.println("1.관리자모드 2.학생모드 3.교수모드 4.종료");
			String a = sc.nextLine();
			
			switch(a) {
			
			case "1":
				System.out.println("관리자 아이디 : ");
				id = sc.nextLine();
				System.out.println("관리자 비번 : ");
				password = sc.nextLine();
				if(id.equals(HOST_ID) && password.equals(HOST_PASSWROD))
					manager.ManagerView();
				else 
					System.out.println("id or password Error!");
				break;
			case "2":
				System.out.println("아이디 : ");
				id = sc.nextLine();
				System.out.println("비번 : ");
				password = sc.nextLine();
				if(student.CheckID(id,password)) {
					student.StudentView();
				}
				break;
			case "3":
				System.out.println("아이디 : ");
				id = sc.nextLine();
				System.out.println("비번 : ");
				password = sc.nextLine();
				if(professor.CheckID(id,password)) {
					professor.ProfessorView();
				}
				break;
			case "4":
				System.out.println("종료 되었습니다.");
				return ;
				default :
					System.out.println("잘못 눌렀습니다.");
			}
		}
	}
	

	
	

	
	

	
	

	

}

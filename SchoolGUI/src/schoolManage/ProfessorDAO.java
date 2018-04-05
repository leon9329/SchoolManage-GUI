package schoolManage;
import java.util.Scanner;
import java.util.Vector;

//professor DAO
public class ProfessorDAO {
	Vector<ProfessorDTO> proList = new Vector<>();
	Scanner sc = new Scanner(System.in);
	int num; // 객체 인덱스

	ProfessorDAO() {
		proList.add(new ProfessorDTO("aa","홍길동", "남", "50", "수학"));
		SchoolMain.IDList.add("aa");
		proList.add(new ProfessorDTO("bb","장발산", "남", "55", "과학"));
		SchoolMain.IDList.add("bb");
		proList.add(new ProfessorDTO("cc","오나미", "여", "53", "영어"));
		SchoolMain.IDList.add("cc");
		proList.add(new ProfessorDTO("dd","김관진", "남", "51", "체육"));
		SchoolMain.IDList.add("dd");
		proList.add(new ProfessorDTO("ee","오수미", "여", "52", "컴퓨터"));
		SchoolMain.IDList.add("ee");
	}

	boolean CheckID(String id, String password) { // 로그인시 id, password 확인
		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getID().equals(id) && proList.get(i).getPassword().equals(password)) {
				System.out.println("로그인 성공!");
				num = i;// 로그인 성공했을 때 stuList index를 num에 저장, 후에 모든 접근은 i로 한다.
				return true;
			}
		}
		System.out.println("로그인 실패");
		return false;
	}

	void ProfessorView() {
		while (true) {
			System.out.println("1.정보 수정 2.지도학생 정보 3.게시판  4.로그아웃 ");
			String s = sc.nextLine();
			switch (s) {
			case "1":
				UpdateProfessor(proList.get(num));
				break;
			case "2":
				break;
			case "3":
				SchoolMain.board.ShowWriteList(proList.get(num));

				break;
			case "4":
				return;
			default:
				System.out.println("1~4번 선택");
			}
		}
	}

	void AddProfessor() { // 교수 추가 메소드

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("성별 : ");
		String sex = sc.nextLine();

		System.out.print("나이 : ");
		String age = sc.nextLine();

		System.out.print("전공 과목 : ");
		String subject = sc.nextLine();

		proList.add(new ProfessorDTO(name, sex, age, subject));
	}

	boolean deleteProfessor() { // 교수 삭제 메소드

		System.out.println("삭제할 교수 이름 : ");
		String name = sc.nextLine();

		System.out.println("삭제할 교수의 교과목 : ");
		String subject = sc.nextLine();

		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getSubject().equals(subject) && proList.get(i).getName().equals(name)) {
				proList.remove(i);
				return true;
			}

		}
		return false;
	}

	void CheckProfessor() { // 교수 수정
		System.out.println("수정할 교수 이름");
		String name = sc.nextLine();
		System.out.println("수정할 교수의 교과목");
		String suject = sc.nextLine();

		for (int i = 0; i < proList.size(); i++) {
			ProfessorDTO professor = proList.get(i);
			if (professor.getName().equals(name) && professor.getSubject().equals(suject)) {
				UpdateProfessor(professor);
				return;
			}
		}
		System.out.println("교수 이름 또는 과목이 잘못되었습니다.");

	}

	void UpdateProfessor(ProfessorDTO professor) {
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1.이름  2.나이 3.전공과목 ");
		String s = sc.nextLine();

		switch (s) {
		case "1":
			System.out.println("새로운 이름: ");
			professor.setName(sc.nextLine());
			System.out.println("수정 완료.");
			break;
		case "2":
			System.out.println("수정할 나이: ");
			professor.setAge(sc.nextLine());
			System.out.println("수정 완료.");
			break;
		case "3":

			System.out.println("새로운 전공: ");
			professor.setSubject(sc.nextLine());
			System.out.println("수정 완료.");
			break;
		default:
			System.out.println("1~3번중 선택하세요.");

		}
	}

	public void ShowProfessors(ProfessorDTO professor) { // 교수 정보 출력
		System.out.println(professor.getName() + "	" + professor.getAge() + "	" + professor.getSex() + "	"
				+ professor.getSubject());
	}

}

package schoolManage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Student DAO
public class StudentDAO {
	ArrayList<StudentDTO> stuList = new ArrayList<StudentDTO>();
	int num; // get에서 얻어온 i값 저장

	StudentDAO() {// 디폴트 학생 + id 디폴트 비번 = 1111
		stuList.add(new StudentDTO("a", "1", "홍길동", "남", "20"));
		SchoolMain.IDList.add("a");
		stuList.add(new StudentDTO("b", "2", "정우성", "남", "26"));
		SchoolMain.IDList.add("b");
		stuList.add(new StudentDTO("c", "3", "김현아", "여", "25"));
		SchoolMain.IDList.add("c");
		stuList.add(new StudentDTO("d", "4", "김지원", "여", "24"));
		SchoolMain.IDList.add("d");
		stuList.add(new StudentDTO("e", "5", "황우석", "여", "23"));
		SchoolMain.IDList.add("e");
	}

	Scanner sc = new Scanner(System.in);

	void StudentView() {
		while (true) {
			System.out.println("1.정보 수정 2.게시판 3.수강신청 4.과목 리스트 5.로그아웃 ");
			String s = sc.nextLine();
			switch (s) {
			case "1":
				SelfUpdateStudent(stuList.get(num));
				break;
			case "2":
				SchoolMain.board.ShowWriteList(stuList.get(num));
				break;
			case "3":
				ApplicationClass(stuList.get(num));
				break;
			case "4":
				ShowSubList(stuList.get(num));
				break;
			case "5":
				return;
			default:
				System.out.println("1~5번 선택하세요");
			}
		}
	}

	/*
	 * boolean CheckID(String id, String password) { // 로그인시 id, password 확인
	 * Iterator<String> iterator = SchoolMain.IDList.iterator(); while
	 * (iterator.hasNext()) { if (id.equals(iterator.next())) { for (int i = 0; i <
	 * stuList.size(); i++) { if (stuList.get(i).getID().equals(id) &&
	 * stuList.get(i).getPassword().equals(password)) {
	 * System.out.println("로그인 성공!"); num = i;// 로그인 성공했을 때 stuList index를 num에 저장,
	 * 후에 모든 접근은 i로 한다. return true; } } System.out.println("비밀번호 오류"); return
	 * false; } else { System.out.println("id가 잘못됬습니다."); return false; } } return
	 * false;
	 * 
	 * }
	 */
	boolean CheckID(String id, String password) { // 로그인시 id, password 확인
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getID().equals(id) && stuList.get(i).getPassword().equals(password)) {
				System.out.println("로그인 성공!");
				num = i;// 로그인 성공했을 때 stuList index를 num에 저장, 후에 모든 접근은 i로 한다.
				return true;
			}
		}
		System.out.println("로그인 실패");
		return false;
	}
	
	void SelfUpdateStudent(StudentDTO student) { // 학생 스스로 정보수정
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1.학번 2.이름 3.나이 4.비밀번호 변경");
		String n = sc.nextLine();
		switch (n) {
		case "1":
			System.out.println("학번 : ");
			student.setClassOf(sc.nextLine());
			System.out.println("수정 완료");
			break;
		case "2":
			System.out.println("이름 : ");
			student.setName(sc.nextLine());
			System.out.println("수정 완료");
			break;
		case "3":
			System.out.println("나이 : ");
			student.setAge(sc.nextLine());
			System.out.println("수정 완료");
			break;

		case "4":
			ChangePassword(student);
			break;
		default:
			System.out.println("1~4번중 선택하세요.");
			break;
		}

	}

	void ChangePassword(StudentDTO student) {
		System.out.println("현재 비밀번호 : ");
		String OldPassword = sc.nextLine();
		if (OldPassword.equals(student.getPassword())) {
			System.out.println("새 비밀번호 : ");
			String NewPassword = sc.nextLine();
			System.out.println("새 비밀번호 확인 : ");
			if (NewPassword.equals(sc.nextLine())) {
				student.setPassword(NewPassword);
				System.out.println("비밀번호 변경완료");
			} else
				System.out.println("새 비밀번호가 일치하지 않습니다.");

		} else
			System.out.println("비밀번호가 틀렸습니다.");

	}

	void AddStudent() { // 학생 추가 메소드

		System.out.print("학번 : ");
		String classOf = sc.nextLine();

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("성별 : ");
		String sex = sc.nextLine();

		System.out.print("나이 : ");
		String age = sc.nextLine();

		stuList.add(new StudentDTO(classOf, name, sex, age));
	}

	boolean deleteStudent() { // 학생 삭제 메소드
		System.out.println("삭제할 학생 학번 : ");
		String classOf = sc.nextLine();
		System.out.println("삭제할 학생 이름 : ");
		String name = sc.nextLine();

		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getClassOf().equals(classOf) && stuList.get(i).getName().equals(name)) {
				stuList.remove(i);
				return true;

			}

		}
		return false;
	}

	void CheckStudent() { // 수정 학생 학번, 이름 확인

		System.out.println("수정할 학생의 학번 : ");
		String classOf = sc.nextLine();
		System.out.println("수정할 학생 이름 : ");
		String name = sc.nextLine();

		for (int i = 0; i < stuList.size(); i++) {
			StudentDTO student = stuList.get(i);
			if (student.getClassOf().equals(classOf) && student.getName().equals(name)) {
				UpdateStudent(student);
				return;
			}
		}
		System.out.println("학번 또는 이름이 잘못됬습니다.");
	}

	void UpdateStudent(StudentDTO student) { // 학생 수정
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1.학번 2.이름 3.성별 4.나이 ");
		String s = sc.nextLine();
		switch (s) {
		case "1":
			System.out.println("새로운 학번: ");
			student.setClassOf(sc.nextLine());
			System.out.println("수정 완료.");
			break;
		case "2":
			System.out.println("새로운 이름: ");
			student.setName(sc.nextLine());
			System.out.println("수정 완료.");
			break;
		case "3":
			if (student.getSex().equals("남"))
				student.setSex("여");
			else
				student.setSex("남");
			System.out.println("수정 완료.");
			break;
		case "4":

			System.out.println("새로운 나이: ");
			student.setAge(sc.nextLine());
			System.out.println("수정 완료.");
			break;

		default:
			System.out.println("1~4번중 선택하세요.");

		}

	}

	void ApplicationClass(StudentDTO student) { // 수강신청
		// SubjectList subList = new SubjectList();
		String[] subject = SubjectList.subjects; // 과목 목록
		List<String> subList = student.subject; // 신청한 과목 리스트
		System.out.println("수강신청을 원하는 과목의 번호를 선택해주세요.");
		System.out.println("---------------------");
		for (int i = 0; i < subject.length; i++) {
			System.out.println((i + 1) + "." + subject[i]);
		}
		System.out.println("수강신청 끝내기 : p");
		System.out.println("---------------------");

		while (true) {
			System.out.print("번호 : ");
			String n = sc.nextLine();

			if (n.equals("p"))
				break;

			int a = Integer.parseInt(n);

			if (a > subject.length) {
				System.out.println("1 ~ " + subject.length + "선택");
				continue;
			}
			boolean overlap = true;

			if (subList.isEmpty()) {
				subList.add(subject[a - 1]); // 과목 리스트가 비어있으면 과목 추가
				System.out.println(subject[a - 1] + "추가.(비어있음)");
			} else {
				for (int i = 0; i < subList.size(); i++) {
					if (subList.get(i).equals(subject[a - 1])) {
						overlap = false;
						System.out.println("중복 됨");
					}
				}
				if (overlap == true) {
					subList.add(subject[a - 1]);
					System.out.println(subject[a - 1] + "추가.");
				}
			}
		}
	}

	void ShowSubList(StudentDTO student) {

		if (!student.subject.isEmpty()) {
			for (int i = 0; i < student.subject.size(); i++) {
				System.out.println((i + 1) + "." + student.subject.get(i));
			}
		} else
			System.out.println("비어있음");
	}

	void showStudent(StudentDTO student) {
		System.out.println(student.getClassOf() + "	" + student.getName() + "	" + student.getSex() + "	"
				+ student.getAge() + "	" + student.subject.size() + "과목");
	}

}
package schoolManage;
import java.util.Scanner;

public class ManagerMethod {

	StudentDAO student = SchoolMain.student;
	ProfessorDAO professor = SchoolMain.professor;
	Scanner sc = new Scanner(System.in);

	void ManagerView() { // �����ڸ�� ȭ��
		while (true) {
			System.out.println("1.�л� ���� 2.���� ���� 3.�α׾ƿ� (������ ���)");
			String n = sc.nextLine();

			switch (n) {
			case "1":
				StudentBoard();
				break;
			case "2":
				ProfessorBoard();
				break;
			case "3":
				return;
			}
		}
	}

	void StudentBoard() {// �����ڰ� �л� ����

		while (true) {
			
			System.out.println("1.�л� �߰� 2.�л� ����Ʈ 3.�л� ���� 4.�л� ���� ���� 5.�ڷ�");
			String n = sc.nextLine();

			switch (n) {
			case "1":
				SchoolMain.student.AddStudent();
				break;
			case "2":
				System.out.println("�й�	�̸�	����	����	����");
				System.out.println("------------------------------------------");
				for (int i = 0; i < student.stuList.size(); i++)
					student.showStudent(student.stuList.get(i));
				System.out.println("------------------------------------------");
				System.out.println();
				break;
			case "3":
				if (student.deleteStudent())
					System.out.println("���� �Ϸ�");
				else
					System.out.println("���� ����");
				break;
			case "4":
				student.CheckStudent();
				break;
			case "5":
				return;
			}
		}

	}

	void ProfessorBoard() {

		while (true) { // �����ڰ� ���� ����
			System.out.println("1.���� �߰� 2.���� ����Ʈ 3.���� ���� 4.������ ���� 5.�ڷ�");
			String n = sc.nextLine();

			switch (n) {
			case "1":
				professor.AddProfessor();
				break;
			case "2":
				System.out.println("�̸�	����	����	����");
				System.out.println("------------------------------");
				for (int i = 0; i < professor.proList.size(); i++)
					professor.ShowProfessors(professor.proList.get(i));
				System.out.println("------------------------------");
				System.out.println();
				break;
			case "3":
				if (professor.deleteProfessor())
					System.out.println("���� �Ϸ�");
				else
					System.out.println("���� ����");
				break;
			case "4":
				professor.CheckProfessor();
				break;
			case "5":
				return;
			}
		}

	}

	static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

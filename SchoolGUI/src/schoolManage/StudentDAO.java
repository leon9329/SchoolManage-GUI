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
	int num; // get���� ���� i�� ����

	StudentDAO() {// ����Ʈ �л� + id ����Ʈ ��� = 1111
		stuList.add(new StudentDTO("a", "1", "ȫ�浿", "��", "20"));
		SchoolMain.IDList.add("a");
		stuList.add(new StudentDTO("b", "2", "���켺", "��", "26"));
		SchoolMain.IDList.add("b");
		stuList.add(new StudentDTO("c", "3", "������", "��", "25"));
		SchoolMain.IDList.add("c");
		stuList.add(new StudentDTO("d", "4", "������", "��", "24"));
		SchoolMain.IDList.add("d");
		stuList.add(new StudentDTO("e", "5", "Ȳ�켮", "��", "23"));
		SchoolMain.IDList.add("e");
	}

	Scanner sc = new Scanner(System.in);

	void StudentView() {
		while (true) {
			System.out.println("1.���� ���� 2.�Խ��� 3.������û 4.���� ����Ʈ 5.�α׾ƿ� ");
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
				System.out.println("1~5�� �����ϼ���");
			}
		}
	}

	/*
	 * boolean CheckID(String id, String password) { // �α��ν� id, password Ȯ��
	 * Iterator<String> iterator = SchoolMain.IDList.iterator(); while
	 * (iterator.hasNext()) { if (id.equals(iterator.next())) { for (int i = 0; i <
	 * stuList.size(); i++) { if (stuList.get(i).getID().equals(id) &&
	 * stuList.get(i).getPassword().equals(password)) {
	 * System.out.println("�α��� ����!"); num = i;// �α��� �������� �� stuList index�� num�� ����,
	 * �Ŀ� ��� ������ i�� �Ѵ�. return true; } } System.out.println("��й�ȣ ����"); return
	 * false; } else { System.out.println("id�� �߸�����ϴ�."); return false; } } return
	 * false;
	 * 
	 * }
	 */
	boolean CheckID(String id, String password) { // �α��ν� id, password Ȯ��
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getID().equals(id) && stuList.get(i).getPassword().equals(password)) {
				System.out.println("�α��� ����!");
				num = i;// �α��� �������� �� stuList index�� num�� ����, �Ŀ� ��� ������ i�� �Ѵ�.
				return true;
			}
		}
		System.out.println("�α��� ����");
		return false;
	}
	
	void SelfUpdateStudent(StudentDTO student) { // �л� ������ ��������
		System.out.println("������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.�й� 2.�̸� 3.���� 4.��й�ȣ ����");
		String n = sc.nextLine();
		switch (n) {
		case "1":
			System.out.println("�й� : ");
			student.setClassOf(sc.nextLine());
			System.out.println("���� �Ϸ�");
			break;
		case "2":
			System.out.println("�̸� : ");
			student.setName(sc.nextLine());
			System.out.println("���� �Ϸ�");
			break;
		case "3":
			System.out.println("���� : ");
			student.setAge(sc.nextLine());
			System.out.println("���� �Ϸ�");
			break;

		case "4":
			ChangePassword(student);
			break;
		default:
			System.out.println("1~4���� �����ϼ���.");
			break;
		}

	}

	void ChangePassword(StudentDTO student) {
		System.out.println("���� ��й�ȣ : ");
		String OldPassword = sc.nextLine();
		if (OldPassword.equals(student.getPassword())) {
			System.out.println("�� ��й�ȣ : ");
			String NewPassword = sc.nextLine();
			System.out.println("�� ��й�ȣ Ȯ�� : ");
			if (NewPassword.equals(sc.nextLine())) {
				student.setPassword(NewPassword);
				System.out.println("��й�ȣ ����Ϸ�");
			} else
				System.out.println("�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");

		} else
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");

	}

	void AddStudent() { // �л� �߰� �޼ҵ�

		System.out.print("�й� : ");
		String classOf = sc.nextLine();

		System.out.print("�̸� : ");
		String name = sc.nextLine();

		System.out.print("���� : ");
		String sex = sc.nextLine();

		System.out.print("���� : ");
		String age = sc.nextLine();

		stuList.add(new StudentDTO(classOf, name, sex, age));
	}

	boolean deleteStudent() { // �л� ���� �޼ҵ�
		System.out.println("������ �л� �й� : ");
		String classOf = sc.nextLine();
		System.out.println("������ �л� �̸� : ");
		String name = sc.nextLine();

		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getClassOf().equals(classOf) && stuList.get(i).getName().equals(name)) {
				stuList.remove(i);
				return true;

			}

		}
		return false;
	}

	void CheckStudent() { // ���� �л� �й�, �̸� Ȯ��

		System.out.println("������ �л��� �й� : ");
		String classOf = sc.nextLine();
		System.out.println("������ �л� �̸� : ");
		String name = sc.nextLine();

		for (int i = 0; i < stuList.size(); i++) {
			StudentDTO student = stuList.get(i);
			if (student.getClassOf().equals(classOf) && student.getName().equals(name)) {
				UpdateStudent(student);
				return;
			}
		}
		System.out.println("�й� �Ǵ� �̸��� �߸�����ϴ�.");
	}

	void UpdateStudent(StudentDTO student) { // �л� ����
		System.out.println("������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.�й� 2.�̸� 3.���� 4.���� ");
		String s = sc.nextLine();
		switch (s) {
		case "1":
			System.out.println("���ο� �й�: ");
			student.setClassOf(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;
		case "2":
			System.out.println("���ο� �̸�: ");
			student.setName(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;
		case "3":
			if (student.getSex().equals("��"))
				student.setSex("��");
			else
				student.setSex("��");
			System.out.println("���� �Ϸ�.");
			break;
		case "4":

			System.out.println("���ο� ����: ");
			student.setAge(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;

		default:
			System.out.println("1~4���� �����ϼ���.");

		}

	}

	void ApplicationClass(StudentDTO student) { // ������û
		// SubjectList subList = new SubjectList();
		String[] subject = SubjectList.subjects; // ���� ���
		List<String> subList = student.subject; // ��û�� ���� ����Ʈ
		System.out.println("������û�� ���ϴ� ������ ��ȣ�� �������ּ���.");
		System.out.println("---------------------");
		for (int i = 0; i < subject.length; i++) {
			System.out.println((i + 1) + "." + subject[i]);
		}
		System.out.println("������û ������ : p");
		System.out.println("---------------------");

		while (true) {
			System.out.print("��ȣ : ");
			String n = sc.nextLine();

			if (n.equals("p"))
				break;

			int a = Integer.parseInt(n);

			if (a > subject.length) {
				System.out.println("1 ~ " + subject.length + "����");
				continue;
			}
			boolean overlap = true;

			if (subList.isEmpty()) {
				subList.add(subject[a - 1]); // ���� ����Ʈ�� ��������� ���� �߰�
				System.out.println(subject[a - 1] + "�߰�.(�������)");
			} else {
				for (int i = 0; i < subList.size(); i++) {
					if (subList.get(i).equals(subject[a - 1])) {
						overlap = false;
						System.out.println("�ߺ� ��");
					}
				}
				if (overlap == true) {
					subList.add(subject[a - 1]);
					System.out.println(subject[a - 1] + "�߰�.");
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
			System.out.println("�������");
	}

	void showStudent(StudentDTO student) {
		System.out.println(student.getClassOf() + "	" + student.getName() + "	" + student.getSex() + "	"
				+ student.getAge() + "	" + student.subject.size() + "����");
	}

}
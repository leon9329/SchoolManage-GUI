package schoolManage;
import java.util.Scanner;
import java.util.Vector;

//professor DAO
public class ProfessorDAO {
	Vector<ProfessorDTO> proList = new Vector<>();
	Scanner sc = new Scanner(System.in);
	int num; // ��ü �ε���

	ProfessorDAO() {
		proList.add(new ProfessorDTO("aa","ȫ�浿", "��", "50", "����"));
		SchoolMain.IDList.add("aa");
		proList.add(new ProfessorDTO("bb","��߻�", "��", "55", "����"));
		SchoolMain.IDList.add("bb");
		proList.add(new ProfessorDTO("cc","������", "��", "53", "����"));
		SchoolMain.IDList.add("cc");
		proList.add(new ProfessorDTO("dd","�����", "��", "51", "ü��"));
		SchoolMain.IDList.add("dd");
		proList.add(new ProfessorDTO("ee","������", "��", "52", "��ǻ��"));
		SchoolMain.IDList.add("ee");
	}

	boolean CheckID(String id, String password) { // �α��ν� id, password Ȯ��
		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getID().equals(id) && proList.get(i).getPassword().equals(password)) {
				System.out.println("�α��� ����!");
				num = i;// �α��� �������� �� stuList index�� num�� ����, �Ŀ� ��� ������ i�� �Ѵ�.
				return true;
			}
		}
		System.out.println("�α��� ����");
		return false;
	}

	void ProfessorView() {
		while (true) {
			System.out.println("1.���� ���� 2.�����л� ���� 3.�Խ���  4.�α׾ƿ� ");
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
				System.out.println("1~4�� ����");
			}
		}
	}

	void AddProfessor() { // ���� �߰� �޼ҵ�

		System.out.print("�̸� : ");
		String name = sc.nextLine();

		System.out.print("���� : ");
		String sex = sc.nextLine();

		System.out.print("���� : ");
		String age = sc.nextLine();

		System.out.print("���� ���� : ");
		String subject = sc.nextLine();

		proList.add(new ProfessorDTO(name, sex, age, subject));
	}

	boolean deleteProfessor() { // ���� ���� �޼ҵ�

		System.out.println("������ ���� �̸� : ");
		String name = sc.nextLine();

		System.out.println("������ ������ ������ : ");
		String subject = sc.nextLine();

		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getSubject().equals(subject) && proList.get(i).getName().equals(name)) {
				proList.remove(i);
				return true;
			}

		}
		return false;
	}

	void CheckProfessor() { // ���� ����
		System.out.println("������ ���� �̸�");
		String name = sc.nextLine();
		System.out.println("������ ������ ������");
		String suject = sc.nextLine();

		for (int i = 0; i < proList.size(); i++) {
			ProfessorDTO professor = proList.get(i);
			if (professor.getName().equals(name) && professor.getSubject().equals(suject)) {
				UpdateProfessor(professor);
				return;
			}
		}
		System.out.println("���� �̸� �Ǵ� ������ �߸��Ǿ����ϴ�.");

	}

	void UpdateProfessor(ProfessorDTO professor) {
		System.out.println("������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.�̸�  2.���� 3.�������� ");
		String s = sc.nextLine();

		switch (s) {
		case "1":
			System.out.println("���ο� �̸�: ");
			professor.setName(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;
		case "2":
			System.out.println("������ ����: ");
			professor.setAge(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;
		case "3":

			System.out.println("���ο� ����: ");
			professor.setSubject(sc.nextLine());
			System.out.println("���� �Ϸ�.");
			break;
		default:
			System.out.println("1~3���� �����ϼ���.");

		}
	}

	public void ShowProfessors(ProfessorDTO professor) { // ���� ���� ���
		System.out.println(professor.getName() + "	" + professor.getAge() + "	" + professor.getSex() + "	"
				+ professor.getSubject());
	}

}

package schoolManage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener {

	JButton btn1 = new JButton("�л� ����");
	JButton btn2 = new JButton("���� ����");
	JButton btn3 = new JButton("����");

	JButton addBtn = new JButton("�߰�");
	JButton delBtn = new JButton("����");
	JButton updateBtn = new JButton("����");

	// JPanel jp = new JPanel();
	// JPanel jp1 = new JPanel();

	// JScrollPane sp;

	// JTable tb;

	// DefaultTableModel dt;

	//
	// String StudentColum[] = { "��ȣ", "�й�", "�̸�", "����", "����", "id" };
	// String professorColum[] = { "��ȣ", "�̸�", "����", "����", "����", "id" };
	// String colum[] = { "��ȣ", "�̸�", "����", "����", "id" };
	// Vector<StudentDTO> stuList = SchoolMain.student.stuList;
	//
	// Vector<ProfessorDTO> proList = SchoolMain.professor.proList;

	public ManagerView() {

		// jp.add(btn1);
		// jp.add(btn2);
		// jp.add(btn3);

		// jp1.add(addBtn);
		// jp1.add(delBtn);
		// jp1.add(updateBtn);

		// add(jp);
		// add(sp, "Center");
		// add(jp1, "South");
		setLayout(new FlowLayout());

		add(btn1);
		add(btn2);
		add(btn3);

		setResizable(false);
		setLocation(770, 300);
		// setSize(500, 300);
		pack();
		setVisible(true);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {
			JFrame stuFrame = new JFrame("�л� ����");
			String StudentColum[] = { "��ȣ", "�й�", "�̸�", "����", "����", "id" };
			Vector<StudentDTO> stuList = SchoolMain.student.stuList;
			String[][] data = new String[100][6];
			DefaultTableModel dt;
			JTable tb;
			JScrollPane sp;

			JPanel jp = new JPanel();

			for (int i = 0; i < stuList.size(); i++) {

				data[i][0] = (i + 1) + "";
				data[i][1] = stuList.get(i).getClassOf();
				data[i][2] = stuList.get(i).getName();
				data[i][3] = stuList.get(i).getSex();
				data[i][4] = stuList.get(i).getAge();
				data[i][5] = stuList.get(i).getID();

			}

			dt = new DefaultTableModel(data, StudentColum) {
				public boolean isCellEditable(int row, int column) {
					return false;// �� ���� �Ұ�
				}
			};
			
			dt = new DefaultTableModel(data, StudentColum);
			tb = new JTable(dt);
//			tb.setEnabled(false);//�� ���� ����. �� ��ü Ŭ���� �ȵ�
			tb.getTableHeader().setReorderingAllowed(false);// �̵� �Ұ�
			tb.getTableHeader().setResizingAllowed(false);// ũ�� ���� �Ұ�
			sp = new JScrollPane(tb);

			jp.add(addBtn);
			jp.add(delBtn);
			jp.add(updateBtn);

			stuFrame.setResizable(false);

			stuFrame.add(sp, "Center");
			stuFrame.add(jp, "South");
			stuFrame.setLocation(500, 100);
			stuFrame.setSize(800, 800);

			stuFrame.setVisible(true);

			addBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

			delBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}
			});
			
			updateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

		} else if (e.getSource() == btn2) {

			// dt = new DefaultTableModel(data, professorColum);

			// for (int i = 0; i < proList.size(); i++) {
			//
			// data[i][0] = (i + 1) + "";
			// data[i][1] = proList.get(i).getName();
			// data[i][2] = proList.get(i).getSex();
			// data[i][3] = proList.get(i).getAge();
			// //data[i][4] = proList.get(i).getSubject();
			// data[i][5] = proList.get(i).getID();
			// }
			// setVisible(true);

		} else if (e.getSource() == btn3) {
			this.dispose();
			SchoolManage sm = new SchoolManage();
		}

	}
}

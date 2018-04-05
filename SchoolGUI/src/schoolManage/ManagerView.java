package schoolManage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener {

	JButton btn1 = new JButton("�л� ����");
	JButton btn2 = new JButton("���� ����");
	JButton btn3 = new JButton("����");
	JButton addBtn = new JButton("�߰�");
	JButton delBtn = new JButton("����");
	JButton updateBtn = new JButton("����");

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	JScrollPane sp;

	JTable tb;

	DefaultTableModel dt;

	String[][] data = new String[100][6];

	String StudentColum[] = { "��ȣ", "�й�", "�̸�", "����", "����", "id" };
	String professorColum[] = { "��ȣ", "�̸�", "����", "����", "����", "id" };
	String colum[] = { "��ȣ", "�̸�", "����", "����", "id" };
	Vector<StudentDTO> stuList = SchoolMain.student.stuList;

	Vector<ProfessorDTO> proList = SchoolMain.professor.proList;

	public ManagerView() {

		dt = new DefaultTableModel(data,colum);
		
		tb = new JTable(dt);
		sp = new JScrollPane(tb);

		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);

		jp1.add(addBtn);
		jp1.add(delBtn);
		jp1.add(updateBtn);

		add(jp, "North");
		// add(sp, "Center");
		add(jp1, "South");

		setResizable(false);
		setLocation(450, 150);
		setSize(1000, 800);
		setVisible(true);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {
			
			
			for (int i = 0; i < stuList.size(); i++) {

				data[i][0] = (i + 1) + "";
				//data[i][1] = stuList.get(i).getClassOf();
				data[i][2] = stuList.get(i).getName();
				data[i][3] = stuList.get(i).getSex();
				data[i][4] = stuList.get(i).getAge();
				data[i][5] = stuList.get(i).getID();
				
			}
			
			setVisible(true);
		} else if (e.getSource() == btn2) {
			
			//dt = new DefaultTableModel(data, professorColum);
			
			for (int i = 0; i < proList.size(); i++) {

				data[i][0] = (i + 1) + "";
				data[i][1] = proList.get(i).getName();
				data[i][2] = proList.get(i).getSex();
				data[i][3] = proList.get(i).getAge();
				//data[i][4] = proList.get(i).getSubject();
				data[i][5] = proList.get(i).getID();
			}
			setVisible(true);

		} else if (e.getSource() == btn3) {
			this.dispose();
			SchoolManage sm = new SchoolManage();
		}

	}
}

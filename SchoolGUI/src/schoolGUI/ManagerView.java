package schoolGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener {

	JTabbedPane tab = new JTabbedPane();
	JTable studentTable, professorTable;
	JScrollPane sp1, sp2;
	JButton insertBtn, deleteBtn, updateBtn, exitBtn;
	JPanel pn, pn2;
	
	Vector<String> column = new Vector<String>();
	Vector<String> stuList = new Vector<String>();
	DefaultTableModel model;

	
	public ManagerView() {
		super("������ ���");

		column.addElement("id");
		column.addElement("�й�");
		column.addElement("�̸�");
		column.addElement("��ȭ��ȣ");
		column.addElement("�ּ�");
		column.addElement("email");
		column.addElement("����");
//		column.addElement("���"");
		
		model = new DefaultTableModel(column, 0);
		
		
		studentTable = new JTable(model);
		professorTable = new JTable();

		sp1 = new JScrollPane(studentTable);
		sp2 = new JScrollPane(professorTable);

		insertBtn = new JButton("�߰�");
		deleteBtn = new JButton("����");
		updateBtn = new JButton("����");
		exitBtn = new JButton("����");
		
		pn = new JPanel();
		pn2 = new JPanel();

		pn.add(insertBtn);
		pn.add(deleteBtn);
		pn.add(updateBtn);

		// pn2.add(lb);

		pn.add(pn2);
		pn.add(exitBtn);

		tab.addTab("�л�", sp1);
		tab.addTab("����", sp2);

		add(tab, "Center");
		add(pn, "South");

		setResizable(false);
		setBounds(450, 100, 1000, 800);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		stuList.addElement("b");
		stuList.addElement("b");
		stuList.addElement("b");
		stuList.addElement("a");
		stuList.addElement("a");
		stuList.addElement("a");
		stuList.addElement("a");
		stuList.addElement("b");
		
		model.addRow(stuList);

		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(insertBtn)) {

		} else if (e.getSource().equals(insertBtn)) {

		} else if (e.getSource().equals(deleteBtn)) {

		} else if (e.getSource().equals(exitBtn)) {

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerView mg = new ManagerView();
	}
}

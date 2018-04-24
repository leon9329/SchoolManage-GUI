package schoolGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener {

	JFrame jf; // �л�,���� �߰���ư ������ �� ��Ÿ���� ���� ������

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String sql;

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	JTabbedPane tab = new JTabbedPane();
	JTable studentTable, professorTable;
	JScrollPane sp1, sp2;
	JButton insertBtn, deleteBtn, updateBtn, exitBtn;
	JPanel pn, pn2;

	Vector<String> column = new Vector<String>();
	Vector<String> column2 = new Vector<String>();
	
	DefaultTableModel model, model2;

	// ---------���� �����ӿ��� ����� ������------------------//
	int size = 8; // textField�� ����. �л��ǰ�� id,�й�,�̸�,��ȭ��ȣ ���
	JTextField tf[] = new JTextField[size];
	JLabel lb[] = new JLabel[size];
	JButton btn1, btn2;// ���������ӿ� ���,��� ��ư
	// -------------------------------------------------//

	public ManagerView() {
		super("������ ���");

		connectDB();// db����

		column.addElement("id");
		column.addElement("�й�");
		column.addElement("�̸�");
		column.addElement("��ȭ��ȣ");
		column.addElement("�ּ�");
		column.addElement("email");
		column.addElement("����");

		column2.addElement("id");
		column2.addElement("name");
		column2.addElement("email");
		column2.addElement("age");
		column2.addElement("address");
		column2.addElement("phone");
		column2.addElement("salary");

		model = new DefaultTableModel(column, 0);
		model2 = new DefaultTableModel(column2, 0);

		studentTable = new JTable(model);
		studentTable.setCellSelectionEnabled(false);

		professorTable = new JTable(model2);
		professorTable.setCellSelectionEnabled(false);

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

		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		showStuList();
		showProList();

	}

	

	public void insertView() {

		String stuColumn[] = { "ID", "�й�", "name", "phone", "address", "email", "major", "password" };
		String proColumn[] = { "ID", "name", "eamil", "age", "address", "phone", "salary", "password" };

		JPanel pn1, pn2, pn3, pn4;

		pn1 = new JPanel(new GridLayout(1, 2));
		pn2 = new JPanel(new GridLayout(8, 1));
		pn3 = new JPanel(new GridLayout(8, 1));
		pn4 = new JPanel();

		if (isStudent()) {

			jf = new JFrame("�л� �߰�");

			for (int i = 0; i < size; i++) {
				lb[i] = new JLabel(stuColumn[i], JLabel.CENTER);
				tf[i] = new JTextField(10);
				pn2.add(lb[i]);
				pn3.add(tf[i]);
			}
		} else {
			jf = new JFrame("���� �߰�");

			for (int i = 0; i < size; i++) {
				lb[i] = new JLabel(proColumn[i], JLabel.CENTER);
				tf[i] = new JTextField(10);
				pn2.add(lb[i]);
				pn3.add(tf[i]);
			}
		}

		btn1 = new JButton("���");
		btn2 = new JButton("���");

		pn4.add(btn1);
		pn4.add(btn2);

		pn1.add(pn2);
		pn1.add(pn3);

		jf.add(pn1);
		jf.add(pn4, "South");
		jf.setResizable(false);
		jf.setBounds(800, 300, 300, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if (e.getSource().equals(insertBtn)) {// �߰�
			insertView();
		} else if (e.getSource().equals(deleteBtn)) {// ����

			String id = JOptionPane.showInputDialog(this, "������ ID");

			try {
				if (isStudent()) {// �л� ���� ���
					if (studentTable.getRowCount() != 0) {
						for (int i = 0; i < studentTable.getRowCount(); i++) {
							if (id.equals(studentTable.getValueAt(i, 0))) {
								int ans = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����Ȯ��",
										JOptionPane.YES_NO_OPTION);
								if (ans == JOptionPane.YES_OPTION) {
									model.removeRow(i);
									JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
								}
							}

						}
					}
				} else if (!isStudent()) {// ���� ���� ���
					if (professorTable.getRowCount() != 0) {
						for (int i = 0; i < professorTable.getRowCount(); i++) {
							if (id.equals(professorTable.getValueAt(i, 0))) {
								int ans = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����Ȯ��",
										JOptionPane.YES_NO_OPTION);
								if (ans == JOptionPane.YES_OPTION) {
									model2.removeRow(i);
									JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
								}
							}
						}
					}
				}
			} catch (NullPointerException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "��� �Ǿ����ϴ�.");
				return;
			}

			delete(id);
			

		} else if (e.getSource().equals(updateBtn)){// ���� ��ư
			
			String position = null;
			String id = JOptionPane.showInputDialog("ID �� �Է��ϼ���");
			
			if(isStudent()) 
				position = "�л�";
			else
				position = "����";
			
				UpdateInfo_manage updateInfo = new UpdateInfo_manage(id,position);
				
				

		} else if (e.getSource().equals(exitBtn)) {// ���� ��ư
			updateShow();
			closeDB();
//			System.exit(0);

		} else if (e.getSource().equals(btn1)) {

			if (tf[0].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[0].getText() + "�� �Է��ϼ���");
			} else if (tf[1].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[1].getText() + "�� �Է��ϼ���");

			} else if (tf[2].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[2].getText() + "�� �Է��ϼ���");

			} else if (tf[3].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[3].getText() + "�� �Է��ϼ���");

			} else if (tf[4].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[4].getText() + "�� �Է��ϼ���");

			} else if (tf[5].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[5].getText() + "�� �Է��ϼ���");

			} else if (tf[6].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[6].getText() + "�� �Է��ϼ���");

			} else if (tf[7].getText().equals("")) {
				JOptionPane.showMessageDialog(this, lb[7].getText() + "�� �Է��ϼ���");

			} else {
				insert();
				jf.setVisible(false);
			}
		} else if (e.getSource().equals(btn2)) {
			jf.setVisible(false);
		}
	}
	
	public void updateShow() {
		if(isStudent()) {
			model.setColumnCount(0);
			
		}else {
			model2.fireTableDataChanged();
		}
	}
	
	public void insert() {
		// id,�й�,�̸�,��ȭ��ȣ,�ּ�,�̸���,����
		// id,name,eamil,age,address,phone,salary,password
		if (isStudent()) {
			sql = "insert into student values(?,?,?,?,?,?,?,?)";
		} else {
			sql = "insert into professor values(?,?,?,?,?,?,?,?)";
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tf[0].getText());
			pstmt.setString(2, tf[1].getText());
			pstmt.setString(3, tf[2].getText());
			pstmt.setString(4, tf[3].getText());
			pstmt.setString(5, tf[4].getText());
			pstmt.setString(6, tf[5].getText());
			pstmt.setString(7, tf[6].getText());
			pstmt.setString(8, tf[7].getText());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "������ �Է� ����");
			}

			String data[] = { tf[0].getText(), tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText(),
					tf[5].getText(), tf[6].getText(), tf[7].getText() };

			if (isStudent())
				model.addRow(data);
			else
				model2.addRow(data);

		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
	}

	public void delete(String id) {

		if (isStudent()) {
			sql = "delete from student where id=?";

		} else if (!isStudent()) {
			sql = "delete from professor where id=?";

		} else {
			JOptionPane.showMessageDialog(this, "�л����ƴϰ� ������ �ƴ�");
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
	}

	public void showStuList() {
	

		sql = "select * from Student";
		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String schoolNum = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				String major = rs.getString(7);

				String data[] = { id, schoolNum, name, phone, address, email, major };
				model.addRow(data);
			}

		} catch (Exception e) {
			e.toString();
		}

	}

	public void showProList() {
		sql = "select * from professor";
		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String age = rs.getString(4);
				String address = rs.getString(5);
				String phone = rs.getString(6);
				String salary = rs.getString(7);

				String data[] = { id, name, email, age, address, phone, salary };
				model2.addRow(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
	}

	public void connectDB() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("driver loading faied");
			e.toString();
		}

		try {
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection failed");
		}
	}
	
	public void closeDB() {
		try {
			if(pstmt != null) {
				pstmt.close();
				System.out.println("pstmt ����");
			}
			if(con != null) {
				con.close();
				System.out.println("connection ����");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public boolean isStudent() {// �л������� Ȯ���ϴ� �޼ҵ�
		boolean result = false;
		if (tab.getSelectedComponent() == tab.getComponent(0))
			result = true;
		else
			result = false;

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerView mg = new ManagerView();
	}
}

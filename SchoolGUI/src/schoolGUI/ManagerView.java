package schoolGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener {

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
	DefaultTableModel model,model2;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(insertBtn)) {
			

		} else if (e.getSource().equals(insertBtn)) {

		} else if (e.getSource().equals(deleteBtn)) {
			String id = JOptionPane.showInputDialog(this, "������ ID");
			delete(id);

		} else if (e.getSource().equals(exitBtn)) {

		}

	}
	
	public void delete(String id) {
		
		if(tab.getSelectedComponent() == tab.getComponent(0)) {
			sql = "delete from student where id=?";
			
		}else if(tab.getSelectedComponent() == tab.getComponent(1)) {
			sql = "delete from professor where id=?";
			
		}else {
			JOptionPane.showMessageDialog(this, "�л����ƴϰ� ������ �ƴ�");
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			
			showStuList();
			showProList();
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		
		
	}
	

	public void showStuList() {
		sql = "select * from Student";
		try {
			pstmt = con.prepareStatement(sql);
//			System.out.println("sql���� �ܰ� ��");
//			pstmt.setString(1, "ms");
//			System.out.println("�Ƶ� ��������� ��");
			rs = pstmt.executeQuery();
//			System.out.println("����ޱ� ����");
			// id,�й�,�̸�,��ȭ��ȣ,�ּ�,����,����
			while (rs.next()) {
				String id = rs.getString(1);
				String schoolNum = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				String major = rs.getString(7);

//				System.out.println(
//						id + ", " + schoolNum + ", " + name + ", " + phone + ", " + address + ", " + email + ", " + major);
				String data[] = { id, schoolNum, name, phone, address, email, major };
				model.addRow(data);
//				System.out.println("add Row ��");
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
			
			while(rs.next()) {
				
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String age = rs.getString(4);
				String address = rs.getString(5);
				String phone = rs.getString(6);
				String salary = rs.getString(7);
				
				String data[] = {id,name,email,age,address,phone,salary};
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerView mg = new ManagerView();
	}
}

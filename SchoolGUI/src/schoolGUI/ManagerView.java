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
		super("관리자 모드");

		connectDB();// db연결

		column.addElement("id");
		column.addElement("학번");
		column.addElement("이름");
		column.addElement("전화번호");
		column.addElement("주소");
		column.addElement("email");
		column.addElement("전공");
		
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

		insertBtn = new JButton("추가");
		deleteBtn = new JButton("삭제");
		updateBtn = new JButton("수정");
		exitBtn = new JButton("종료");

		pn = new JPanel();
		pn2 = new JPanel();

		pn.add(insertBtn);
		pn.add(deleteBtn);
		pn.add(updateBtn);

	

		pn.add(pn2);
		pn.add(exitBtn);

		tab.addTab("학생", sp1);
		tab.addTab("교수", sp2);

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
			String id = JOptionPane.showInputDialog(this, "삭제할 ID");
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
			JOptionPane.showMessageDialog(this, "학생도아니고 교수도 아님");
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
//			System.out.println("sql전송 단계 끝");
//			pstmt.setString(1, "ms");
//			System.out.println("아디 보내기과정 끝");
			rs = pstmt.executeQuery();
//			System.out.println("결과받기 과정");
			// id,학번,이름,전화번호,주소,메일,전공
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
//				System.out.println("add Row 끝");
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

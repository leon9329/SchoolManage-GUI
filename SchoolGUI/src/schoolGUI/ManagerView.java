package schoolGUI;

import java.awt.GridLayout;
import java.awt.JobAttributes;
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

	JFrame jf; // 학생,교수 추가버튼 눌렀을 때 나타나는 서브 프레임

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

	// ---------서브 프레임에서 사용할 변수들------------------//
	int size = 8; // textField의 갯수. 학생의경우 id,학번,이름,전화번호 등등
	JTextField tf[] = new JTextField[size];
	JLabel lb[] = new JLabel[size];
	JButton btn1, btn2;// 서브프레임에 등록,취소 버튼
	// -------------------------------------------------//

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

	public void insert() {
		// id,학번,이름,전화번호,주소,이메일,전공
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
				JOptionPane.showMessageDialog(this, "데이터 입력 성공");
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

	public void insertView() {

		String stuColumn[] = { "ID", "학번", "name", "phone", "address", "email", "major", "password" };
		String proColumn[] = { "ID", "name", "eamil", "age", "address", "phone", "salary", "password" };

		JPanel pn1, pn2, pn3, pn4;

		pn1 = new JPanel(new GridLayout(1, 2));
		pn2 = new JPanel(new GridLayout(8, 1));
		pn3 = new JPanel(new GridLayout(8, 1));
		pn4 = new JPanel();

		if (isStudent()) {

			jf = new JFrame("학생 추가");

			for (int i = 0; i < size; i++) {
				lb[i] = new JLabel(stuColumn[i], JLabel.CENTER);
				tf[i] = new JTextField(10);
				pn2.add(lb[i]);
				pn3.add(tf[i]);
			}
		} else {
			jf = new JFrame("교수 추가");

			for (int i = 0; i < size; i++) {
				lb[i] = new JLabel(proColumn[i], JLabel.CENTER);
				tf[i] = new JTextField(10);
				pn2.add(lb[i]);
				pn3.add(tf[i]);
			}
		}

		btn1 = new JButton("등록");
		btn2 = new JButton("취소");

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
		if (e.getSource().equals(insertBtn)) {
			insertView();
		} else if (e.getSource().equals(deleteBtn)) {

			String id = JOptionPane.showInputDialog(this, "삭제할 ID");

			if (isStudent()) {// 학생 탭일 경우
				if (studentTable.getRowCount() != 0) {
					for (int i = 0; i < studentTable.getRowCount(); i++) {
						try {
							if (id.equals(studentTable.getValueAt(i, 0))) {
								int ans = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제확인",
										JOptionPane.YES_NO_OPTION);
								if (ans == JOptionPane.YES_OPTION) {
									model.removeRow(i);
									JOptionPane.showMessageDialog(this, "삭제되었습니다.");
								}
							}

						} catch (NullPointerException e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(this, "취소 되었습니다.");
							return;
						}
					}
				} else if (!isStudent()) {// 교수 탭일 경우
					if (professorTable.getRowCount() != 0) {
						for (int i = 0; i < professorTable.getRowCount(); i++) {
							if (id.equals(professorTable.getValueAt(i, 0))) {
								int ans = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제확인",
										JOptionPane.YES_NO_OPTION);
								if (ans == JOptionPane.YES_OPTION) {
									model2.removeRow(i);
									JOptionPane.showMessageDialog(this, "삭제되었습니다.");
								}
							}
						}
					}
				}

				delete(id);

			} else if (e.getSource().equals(exitBtn)) {

			}
		} else if (e.getSource().equals(btn1)) {
			for(int i=0; i<size; i++) {
				if(tf[i].getText().equals(""));
					JOptionPane.showMessageDialog(this, lb[i].getText()+"를 입력하세요");
			}
				insert();
				jf.setVisible(false);
			
			
		} else if (e.getSource().equals(btn2)) {
			jf.setVisible(false);
		}

	}

	public void delete(String id) {

		if (isStudent()) {
			sql = "delete from student where id=?";

		} else if (!isStudent()) {
			sql = "delete from professor where id=?";

		} else {
			JOptionPane.showMessageDialog(this, "학생도아니고 교수도 아님");
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

	public boolean isStudent() {// 학생탭인지 확인하는 메소드
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

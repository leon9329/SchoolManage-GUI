package schoolGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateInfo_manage extends JFrame implements ActionListener {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String sql;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	String id; // 수정할 사람 id
	String position;

	int size = 8;

	JFrame jf = new JFrame("수정");

	JTextField tf[] = new JTextField[size - 1]; // 정보 출력 및 수정에 쓰일 텍스트필드,비밀번호는 출력안하기 때문에 size-1

	JButton btn[] = new JButton[size - 1];// 정보 출력 및 수정에 쓰일 버튼, 비밀번호는 출력x
	JButton finishBtn, cancelBtn; // 완료,취소 버튼

	JPanel tfJp[] = new JPanel[size - 1]; // 위에서 만든 textField들 담을 패널
	JPanel btnJp[] = new JPanel[size - 1]; // 위에서 만든 버튼들을 담을 패널
	JPanel lbJp[] = new JPanel[size - 1];// 라벨 담을 패널

	JPanel mainPn, subBtnPn; // JFrame 안에 넣어 둘 메인 패널,완료,취소버튼 담을 패널

	JLabel lb[] = new JLabel[size - 1];// 아래의 컬럼 담을 라벨

	String stuColumn[] = { "id", "학번", "이름", "전화번호", "주소", "email", "전공" };
	String proColumn[] = { "id", "이름", "email", "나이", "주소", "전화번호", "급여" };

	public UpdateInfo_manage(String id, String position) {
		// TODO Auto-generated constructor stub

		this.id = id;
		this.position = position;

		mainPn = new JPanel(new GridLayout(7, 3));
		subBtnPn = new JPanel();

		finishBtn = new JButton("완료");
		cancelBtn = new JButton("취소");

		subBtnPn.add(finishBtn);
		subBtnPn.add(cancelBtn);

		for (int i = 0; i < size - 1; i++) {
			tfJp[i] = new JPanel();
			btnJp[i] = new JPanel();
			lbJp[i] = new JPanel();

			btn[i] = new JButton("수정");

			tf[i] = new JTextField(10);
			tf[i].setEditable(false);

			lb[i] = new JLabel(stuColumn[i], JLabel.CENTER);

			tfJp[i].add(tf[i]);
			btnJp[i].add(btn[i]);
			lbJp[i].add(lb[i]);

			mainPn.add(lbJp[i]);
			mainPn.add(tfJp[i]);
			if (i < 2) {
				mainPn.add(new JLabel(" "));
			} else {
				mainPn.add(btnJp[i]);
			}
		}

		jf.add(subBtnPn, "South");
		jf.add(mainPn, "Center");
		jf.setResizable(false);
		jf.setBounds(700, 300, 400, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		connectDB();
		showInfo();

		for (int i = 0; i < size - 1; i++) {
			btn[i].addActionListener(this);
		}
		finishBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == finishBtn) {
			updateInfo();
			
			for(int i=0; i<size-1; i++)
			{
				tf[i].setEditable(false);
			}
			closeDB();
			jf.setVisible(false);
			

		} else if (e.getSource() == cancelBtn) {
			closeDB();
			jf.setVisible(false);	
			

		} else {
			for (int i = 0; i < size - 1; i++) {
				if (e.getSource() == btn[i]) {
					tf[i].setEditable(true);
					tf[i].setText("");
				}
			}
			
		}
	}
	
	public void closeDB() {
		try {
			if(pstmt.isClosed())
				pstmt.close();
			
			if(con.isClosed())
				con.close();
		} catch (Exception e) {
			e.toString();
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// UpdateInfo_manage uim = new UpdateInfo_manage();
	}

	public void updateInfo() {
		if (position.equals("학생")) {
			sql = "update student set name=?,phone=?,address=?,email=?,major=? where id=?";
			System.out.println("update 학생");
		} else if (position.equals("교수")) {
			sql = "update professor set name=?,email=?,age=?,address=?,phone=? where id=?";
			System.out.println("update 교수");
		} else {
			System.out.println("error");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			for(int i=1;i<size-2;i++) {
				pstmt.setString(i, tf[i+1].getText());
				
			}
			pstmt.setString(6, id);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this, "success");
			}else {
				JOptionPane.showMessageDialog(this, "failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		
	}

	public void showInfo() {
		if (position.equals("학생")) {
			sql = "select * from student where id = ?";
			System.out.println("학생 sql");
		} else if (position.equals("교수")) {
			sql = "select * from professor where id = ?";
			System.out.println("교수 sql");
		} else {
			System.out.println("이도저도 아님");
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			// int i = 0;

			while (rs.next()) {
				// tf[i].setText(rs.getString(i + 1));
				// i++;
				tf[0].setText(rs.getString(1));
				tf[1].setText(rs.getString(2));
				tf[2].setText(rs.getString(3));
				tf[3].setText(rs.getString(4));
				tf[4].setText(rs.getString(5));
				tf[5].setText(rs.getString(6));
				tf[6].setText(rs.getString(7));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connectDB() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.toString();
		}
		try {
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch (Exception e) {
			e.toString();
		}
	}

}

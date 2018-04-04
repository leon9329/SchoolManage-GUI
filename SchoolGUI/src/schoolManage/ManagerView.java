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
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements ActionListener{
	SchoolMain schoolMain;
	
	Container mvContainer = getContentPane();
	
	JButton btn1 = new JButton("학생 관리");
	JButton btn2 = new JButton("교수 관리");
	JButton btn3 = new JButton("종료");
	JButton addBtn = new JButton("추가");
	JButton delBtn = new JButton("삭제");
	JButton updateBtn = new JButton("수정");
	
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	
	JScrollPane sp;

	JTable tb;
	
	DefaultTableModel dt;
	
	Vector<StudentDTO> stuList = SchoolMain.student.stuList;
	
	String colum[] = {"번호","학번","이름","성별","나이","id"};
	String[][] data = {{stuList.get(0).getAge(),stuList.get(0).getClassOf(),stuList.get(0).getName(),stuList.get(0).getName(),stuList.get(0).getName(),stuList.get(0).getName()}};
	public ManagerView(){
//		this.schoolMain = schoolMain;
		
	
//		data[0][0] = stuList.get(0).getAge();
//		data[0][1] = stuList.get(0).getClassOf();
//		data[0][2] = stuList.get(0).getName();
//		data[0][3] = stuList.get(0).getSex();
//		data[0][4] = stuList.get(0).getAge();
//		data[0][5] = stuList.get(0).getID();
		
		dt = new DefaultTableModel(data,colum);
		tb = new JTable(dt);
		sp = new JScrollPane(tb);
		
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		
		jp1.add(addBtn);
		jp1.add(delBtn);
		jp1.add(updateBtn);

		add(jp,"North");
		add(sp, "Center");
		add(jp1, "South");
		
		
		setLocation(450, 150);
		setSize(1000,800);
		setVisible(true);
	
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn1) {
			
		}else if(e.getSource() == btn2){
			
		}else if(e.getSource() == btn3){
			this.dispose();
			SchoolManage sm = new SchoolManage();
		}
			
	}
}

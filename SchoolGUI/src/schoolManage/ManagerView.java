package schoolManage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ManagerView extends JFrame implements ActionListener{
	Container mvContainer = getContentPane();
	JButton btn1 = new JButton("학생 관리");
	JButton btn2 = new JButton("교수 관리");
	JButton btn3 = new JButton("종료");
	JButton addBtn = new JButton("추가");
	JButton delBtn = new JButton("삭제");
	JButton updateBtn = new JButton("수정");
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	JTable tb = new JTable();
	
	ManagerView(){
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		
		jp1.add(addBtn);
		jp1.add(delBtn);
		jp1.add(updateBtn);
		
		mvContainer.add(jp,"North");
		mvContainer.add(tb, "Center");
		mvContainer.add(jp1, "South");
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

package schoolGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ManagerView extends JFrame implements ActionListener{
	
	JTabbedPane tab = new JTabbedPane();
	JTable studentTable,professorTable;
	JScrollPane sp1,sp2;
	JButton insertBtn,deleteBtn,updateBtn,exitBtn;
	JPanel pn,pn2;
	
	
	public ManagerView(){
		super("관리자 모드");
		
		studentTable = new JTable();
		professorTable = new JTable();
		
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
	
//		pn2.add(lb);
		
		pn.add(pn2);
		pn.add(exitBtn);
		
		
		tab.addTab("학생", sp1);
		tab.addTab("교수", sp2);
		
		add(tab,"Center");
		add(pn,"South");
		
		
		setResizable(false);
		setBounds(450, 100, 1000, 800);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(insertBtn)) {
			
		}else if(e.getSource().equals(insertBtn)) {
			
		}else if(e.getSource().equals(deleteBtn)) {
			
		}else if(e.getSource().equals(exitBtn)) {
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerView mg = new ManagerView();
	}
}

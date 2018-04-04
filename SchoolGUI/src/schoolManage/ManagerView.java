package schoolManage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerView extends JFrame implements ActionListener{
	Container mvContainer = getContentPane();
	JButton btn1 = new JButton("切积 包府");
	JButton btn2 = new JButton("背荐 包府");
	JButton btn3 = new JButton("辆丰");
	JPanel jp = new JPanel();
	
	ManagerView(){
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		
		mvContainer.add(jp,"North");
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

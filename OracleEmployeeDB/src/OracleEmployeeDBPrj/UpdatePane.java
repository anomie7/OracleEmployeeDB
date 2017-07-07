package OracleEmployeeDBPrj;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpdatePane extends JPanel implements ActionListener{
	JLabel[] la = new JLabel[5];
	TextField[] tf = new TextField[5];
	JPanel[] jp = new JPanel[6];
	String[] caption = { "사번: ", "사원명: ", "직급: ", "부서: ", "이메일: " };
	JButton okb;
	JButton rsb;
	
	public UpdatePane(){
		setLayout(new GridLayout(6, 1));

		for (int i = 0; i < la.length; i++) {
			jp[i] = new JPanel();
			la[i] = new JLabel(caption[i]);
			jp[i].add(la[i]);
			tf[i] = new TextField(15);
			jp[i].add(tf[i]);
			add(jp[i]);
		}

		jp[5] = new JPanel();
		okb = new JButton("입력");
		rsb = new JButton("다시쓰기");

		jp[5].add(okb);
		jp[5].add(rsb);
		add(jp[5]);
		
		okb.addActionListener(this);
		rsb.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sno;
		String job;
		String sdpt;
		String email;
		JButton btn = (JButton) e.getSource();
		
		if(btn.getText().equals(okb.getText())){
			sno = tf[0].getText();
			job = tf[2].getText();
			sdpt = tf[3].getText();
			email = tf[4].getText();
			
			EmployeeDAO edao = new EmployeeDAO();
			edao.employeeUpdate(sno, job, sdpt, email);
		}
	}
	
}

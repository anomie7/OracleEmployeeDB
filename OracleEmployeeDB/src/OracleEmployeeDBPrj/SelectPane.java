package OracleEmployeeDBPrj;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPane extends JPanel implements ActionListener {
	JLabel[] la = new JLabel[5];
	TextField[] tf = new TextField[5];
	JPanel[] jp = new JPanel[6];
	String[] caption = { "사번: ", "사원명: ", "직급: ", "부서: ", "이메일: " };
	JButton okb;
	JButton rsb;

	public SelectPane() {
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
		okb = new JButton("조회");
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
		JButton btn = (JButton) e.getSource();
		EmployeeDTO edto;
		
		if(btn.getText().equals(okb.getText())){
			//int eno = Integer.parseInt(tf[0].getText());
			String eno = tf[0].getText();
			String ename = tf[1].getText();
			EmployeeDAO edao = new EmployeeDAO();
			
			if(!eno.equals("") && !ename.equals("") ){
				edto = edao.employeeChk(eno, ename);
				
				tf[2].setText(edto.getjobGrade());
				tf[3].setText(edto.getDepartment() + "");
				tf[4].setText(edto.getEmail());
			}else if( !eno.equals("") && ename.equals("") ){
				edto = edao.employeeChkNo(eno);
				tf[1].setText(edto.getName());
				tf[2].setText(edto.getjobGrade());
				tf[3].setText(edto.getDepartment() + "");
				tf[4].setText(edto.getEmail());
			}else if(eno.equals("") && !ename.equals("")){
				edto = edao.employeeChkName(ename);
				tf[0].setText(edto.getNo()+"");
				tf[2].setText(edto.getjobGrade());
				tf[3].setText(edto.getDepartment() + "");
				tf[4].setText(edto.getEmail());
			}
		}else if(btn.getText().equals(rsb.getText())){
			for(int i = 0; i <tf.length; i++){
				tf[i].setText(" ");
			}
		}
		
	}

}

package OracleEmployeeDBPrj;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeletePane extends JPanel implements ActionListener {
	JLabel[] la = new JLabel[2];
	TextField[] tf = new TextField[2];
	JPanel[] jp = new JPanel[3];
	String[] caption = { "사번: ", "사원명: "};
	JButton okb;
	JButton rsb;
	
	public DeletePane(){
		setLayout(new GridLayout(3, 1));
		
		for(int i = 0; i < la.length; i++){
			jp[i] = new JPanel();
			la[i] = new JLabel(caption[i]);
			tf[i] = new TextField(15);
			jp[i].add(la[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		
		jp[2] = new JPanel();
		okb = new JButton("삭제");
		rsb = new JButton("다시쓰기");
		
		okb.addActionListener(this);
		rsb.addActionListener(this);
		
		jp[2].add(okb);
		jp[2].add(rsb);
		add(jp[2]);
		
		
		
		setSize(300, 300);
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sno;
		String name;
		String myac = e.getActionCommand();
		
		if(myac.equals(okb.getText()) ){
			sno = tf[0].getText();
			name = tf[1].getText();
			
			EmployeeDAO edao = new EmployeeDAO();
			edao.employeeDelete(sno, name);
			
		}else if(myac.equals(rsb.getText() ) ){
			for(int i = 0; i < tf.length; i++){
				tf[i].setText(" ");
			}
		}
	}
	
	
}

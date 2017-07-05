package OracleEmployeeDBPrj;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertPane extends JPanel implements ActionListener{
	JLabel[] la = new JLabel[5];
	TextField[] tf = new TextField[5];
	JPanel[] jp = new JPanel[6];
	String[] caption = { "���: ", "�����: ", "����: ", "�μ�: ", "�̸���: " };
	JButton okb;
	JButton rsb;

	public InsertPane() {
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
		okb = new JButton("�Է�");
		rsb = new JButton("�ٽþ���");

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
		EmployeeDAO edao = new EmployeeDAO();
		
		
		if(btn.getText().equals(okb.getText() ) ){
			edao.employeeInsert(tf[0].getText(), tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText());
			System.out.println("�Է¿Ϸ�");
		}else if(btn.getText().equals(rsb.getText())){
			for(int i = 0; i <tf.length; i++){
				tf[i].setText("");
			}
		}
		
	}
	
}

package OracleEmployeeDBPrj;

import javax.swing.JFrame;

public class TestFrame extends JFrame{
	public TestFrame(){
		setTitle("JDBC Oracle ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane( new UpdatePane() );
		
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new DeletePane();
	}

}

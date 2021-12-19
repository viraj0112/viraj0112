import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task extends JPanel{
	JLabel srno;
	JTextField taskName;
	JButton done;
	Boolean status;

	Task(){
		this.setPreferredSize(new Dimension(370,40));
		this.setLayout(new BorderLayout());

		status=false;

		srno= new JLabel();
		srno.setPreferredSize(new Dimension(20,20));
		srno.setHorizontalAlignment(JLabel.CENTER);
		srno.setForeground(new Color(255,255,255));
		srno.setBackground(new Color(54,57,63));
		srno.setOpaque(true);
		this.add(srno,BorderLayout.WEST);

		taskName= new JTextField(" Enter your task");
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(Color.gray);
		taskName.setForeground(new Color(255,255,255));
		taskName.setCaretColor(Color.white);
		taskName.setFont(new Font("Manjari",Font.ITALIC,15));

		this.add(taskName,BorderLayout.CENTER);

		done= new JButton("Done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setBackground(new Color(59,165,93));
		done.setForeground(Color.white);
		this.add(done,BorderLayout.EAST);
	}

	Task(String a, String b){
		this.setPreferredSize(new Dimension(370,40));
		this.setLayout(new BorderLayout());

		if(Integer.parseInt(b)==1)
			status=true;
		else
			status=false;
		
		srno= new JLabel();
		srno.setPreferredSize(new Dimension(20,20));
		srno.setHorizontalAlignment(JLabel.CENTER);
		srno.setForeground(new Color(255,255,255));
		srno.setBackground(new Color(54,57,63));
		srno.setOpaque(true);
		
		taskName= new JTextField(a);
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(Color.gray);
		taskName.setForeground(new Color(255,255,255));

		done= new JButton("done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		done.setBackground(new Color(59,165,93));
		// done.setFocusable(false);
		


		if(status){
			taskName.setBackground(new Color(59,165,93));
			done.setBackground(new Color(86,138,196));
		}

		this.add(srno,BorderLayout.WEST);
		this.add(taskName,BorderLayout.CENTER);
		this.add(done,BorderLayout.EAST);
	}

	public void changeIndex(int num){
		this.srno.setText(num+"");
		this.revalidate();
	}

	public void changeState(){
		taskName.setBackground(new Color(59,165,93));
		done.setBackground(new Color(86,138,196));
		status=true;
	}

	public JButton getDone(){
		return done;
	}

	//for DB
	public String getTaskName(){
		return taskName.getText();

	}

	public boolean getStatus(){
		return status;
	}

	//for DB
	public int getIntStatus(){
		int val = (status) ? 1 : 0;
		return val;
	}

	public JLabel getSrNo(){
		return srno;
	}
}

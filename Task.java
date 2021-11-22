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

		taskName= new JTextField(" Enter task");
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(Color.gray);
		taskName.setForeground(new Color(255,255,255));

		this.add(taskName,BorderLayout.CENTER);

		done= new JButton("done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setBackground(new Color(59,165,93));
		this.add(done,BorderLayout.EAST);
	}

	public void changeIndex(int num){
		this.srno.setText(num+"");
		this.revalidate();
	}

	public void changeState(){
		taskName.setBackground(Color.green);
		status=true;
	}

	public JButton getDone(){
		return done;
	}

	public boolean getStatus(){
		return status;
	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ButtonPanel extends JPanel{
	JButton addTask;
	JButton clear;


	ButtonPanel(){
		this.setPreferredSize(new Dimension(400,60));

		addTask= new JButton("Add new task");
		addTask.setPreferredSize(new Dimension(150,50));
		addTask.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		addTask.setFont(new Font("Manjari",Font.BOLD, 15));
		addTask.setForeground(Color.white);
		addTask.setBackground(new Color(59,165,93));
		addTask.setFocusable(false);
		this.add(addTask);

		this.add(Box.createHorizontalStrut(18));

		clear= new JButton("Clear finished Task");
		clear.setPreferredSize(new Dimension(170,50));
		clear.setBorder(BorderFactory.createEmptyBorder());
		clear.setFont(new Font("Manjari",Font.BOLD,15));
		clear.setForeground(Color.white);
		clear.setBackground(new Color(237,66,69));
		clear.setFocusable(false);
		this.add(clear);
	}

	public JButton getAddTask(){
		return addTask;
	}

	public JButton getClear(){
		return clear;
	}
}
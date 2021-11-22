import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleBar extends JPanel{

	TitleBar(){
		this.setPreferredSize(new Dimension(500,80));
		JLabel titleText= new JLabel("StudentApp");
		titleText.setPreferredSize(new Dimension(300,75));
		titleText.setFont(new Font("Manjari",Font.BOLD, 30));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);
	}
	
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleBar extends JPanel{
	JButton settingButton = new JButton("Setting");
	
	TitleBar(){
		
		this.setPreferredSize(new Dimension(300,55));
		JLabel titleText= new JLabel("FLOWTIME APP");
		titleText.setPreferredSize(new Dimension(300,70));
		titleText.setFont(new Font("Monospaced",Font.ROMAN_BASELINE, 30));
		titleText.setForeground(Color.white);
		titleText.setHorizontalAlignment(JLabel.CENTER);
		titleText.setVerticalAlignment(JLabel.NORTH);
		

		this.add(titleText);
		
		
		settingButton.setBounds(100, 160, 200, 40);
		settingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingButton.setForeground(new Color(255,255,255));
		settingButton.setBackground(new Color(139,156,255));
		settingButton.setFocusable(false);
		this.add(settingButton);
	}
	
	JButton getSettingButton(){
		return settingButton;
	}
}

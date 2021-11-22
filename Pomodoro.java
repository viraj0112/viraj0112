import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.Toolkit;
import java.util.TimerTask;

public class Pomodoro extends JPanel implements ActionListener{

	Toolkit toolkit;

	JPanel pomoControl=new JPanel();
	JButton startButton=new JButton("Start");
	JButton resetButton=new JButton("Reset");
	JButton BreakButton = new JButton("Break");
	JLabel timeLabel= new JLabel();
	JLabel timelabel2 = new JLabel();
	
	// Image img = icon.getImage();
    // {
    //   Image img = icon.getImage();
    //   // instance initializer
    //   {setOpaque(false);}	
    //   public void paintComponent(Graphics graphics) 
    //   {
    //     graphics.drawImage(img, 0, 0, this);
    //     this.paintComponent(graphics);
    //   }
    // };

	JLabel bg=new JLabel();
	int elapsedTime= 0;
	int sec=0;
	int min=0;
	int hours=0;
	boolean started=false;
	String secString= String.format("%02d",sec);
	String minString= String.format("%02d",min);
	String hourString= String.format("%02d",hours);

	String secString1= String.format("%02d",sec);
	String minString1= String.format("%02d",min);
	String hourString1= String.format("%02d",hours);

	Timer timer= new Timer(1000, new ActionListener(){

		public void actionPerformed(ActionEvent e){

			toolkit = Toolkit.getDefaultToolkit();

			elapsedTime+=100000;
			hours=elapsedTime/3600000;
			min=(elapsedTime/60000)%60;
			sec=(elapsedTime/1000)%60;

			secString= String.format("%02d",sec);
			minString= String.format("%02d",min);
			hourString= String.format("%02d",hours);
			timeLabel.setText(hourString+":"+minString+":"+secString);
			
			if(min==25){
				timer.stop();
				toolkit.beep();
				JOptionPane.showConfirmDialog((Component) null,"Times' up.","Task timer finished.", JOptionPane.PLAIN_MESSAGE);
			}

		}

	});

	// Timer timer2 = new Timer(1000, new ActionListener(){
	// 	public void actionPerformed(ActionEvent e){
	// 		elapsedTime+=1000;
	// 		hours=elapsedTime/3600000;
	// 		min=(elapsedTime/60000)%60;
	// 		sec=(elapsedTime/1000)%60;

	// 		secString1= String.format("%02d",sec);
	// 		minString1= String.format("%02d",min);
	// 		hourString1= String.format("%02d",hours);
	// 		timeLabel.setText(hourString1+":"+minString1+":"+secString1);

	// 		if(min==5){
	// 			timer.stop();
	// 			toolkit.beep();
	// 			// JOptionPane.showConfirmDialog((Component) null,"Break time finished.","Break", JOptionPane.PLAIN_MESSAGE);
	// 		}
	// 	}

	// });

	Pomodoro(){
		bg.setIcon(new ImageIcon("bgCircle.jpg"));
		bg.setLayout(null);

		this.setPreferredSize(new Dimension(400,500));
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		// this.setBackground(new Color(54,57,63));
		timeLabel.setText(hourString+":"+minString+":"+secString);
		timeLabel.setPreferredSize(new Dimension(200,100));
		timeLabel.setFont(new Font("MONOSPACED",Font.PLAIN,50));
		// timeLabel.setForeground(new Color(255,255,255));
  		timeLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		timeLabel.setOpaque(false);
  		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		startButton.setPreferredSize(new Dimension(100,50));
		startButton.setFont(new Font("MONOSPACED",Font.PLAIN,20));
		startButton.setFocusable(false);
	  	startButton.setBorder(BorderFactory.createEmptyBorder());
	  	startButton.setForeground(Color.white);
	  	startButton.setBackground(new Color(79,84,92));
		startButton.addActionListener(this);

		resetButton.setPreferredSize(new Dimension(100,50));
		resetButton.setFont(new Font("MONOSPACED",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBorder(BorderFactory.createEmptyBorder());
		resetButton.setForeground(Color.white);
		resetButton.setBackground(new Color(79,84,92));
		// pomoControl.setBackground(new Color(54,57,63));
		
		BreakButton.setPreferredSize(new Dimension(100,50));
		BreakButton.setFont(new Font("MONOSPACED",Font.PLAIN,20));
		BreakButton.setFocusable(false);
	  	BreakButton.setBorder(BorderFactory.createEmptyBorder());
	  	BreakButton.setForeground(Color.white);
	  	BreakButton.setBackground(new Color(79,84,92));
		BreakButton.addActionListener(this);

		this.add(bg,BorderLayout.CENTER);
		this.add(timeLabel,BorderLayout.CENTER);
		pomoControl.add(startButton);
		pomoControl.add(Box.createHorizontalStrut(18));
		pomoControl.add(resetButton);
		pomoControl.add(BreakButton);
		this.add(pomoControl,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton){
			if(started==false){
				started=true;
				startButton.setText("Pause");
				start();
			}
			else{
				started=false;
				startButton.setText("Start");
				stop();
			}
		}
		if(e.getSource()==resetButton) {
		   started=false;
		   startButton.setText("Start");
		   reset();
		}
		if(e.getSource()==BreakButton){
			if(started==false){
				started=true;
				BreakButton.setText("Started");
				start();
			}
			else{
				started=false;
				BreakButton.setText("Finished");
				stop();
			}
		}

	}

	void start(){
		timer.start();
		// timer2.start();
	}

	void stop(){
		timer.stop();
		// timer2.stop();
	}
	

	void reset(){
		timer.stop();
		elapsedTime=0;
		sec =0;
		min=0;
		hours=0;
		secString = String.format("%02d", sec);
		minString = String.format("%02d", min);
		hourString = String.format("%02d", hours);
		timeLabel.setText(hourString+":"+minString+":"+secString);

	}
}
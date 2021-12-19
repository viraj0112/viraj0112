import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;


public class WindowFrame extends JFrame{
	TitleBar title;
	ButtonPanel btnPanel;
	Pomodoro pomodoro;
	List list= new List();
	JButton addTask, done, clear, settingButton;
	JPanel todoPanel= new JPanel();
	JProgressBar progressBar = new JProgressBar(0,100);

	WindowFrame(){
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("FlowTime App");
		this.setPreferredSize(new Dimension(800,650));
		// this.setUndecorated(true);
		this.setBackground(new Color(54,57,63));
		ImageIcon image = new ImageIcon("time.png");
		this.setIconImage(image.getImage());
		this.add(progressBar);
		this.setResizable(false);

		pomodoro=new Pomodoro();
		title=new TitleBar();
		btnPanel=new ButtonPanel();
		todoPanel.setLayout(new BorderLayout());
		todoPanel.setSize(750, 400);
		todoPanel.setBackground(new Color(54,57,63));
		list.setBackground(new Color(54,57,63));
		title.setBackground(new Color(115,135,180));
		btnPanel.setBackground(new Color(54,57,63));
		
		addTask=btnPanel.getAddTask();
		clear= btnPanel.getClear();
		settingButton=title.getSettingButton();
		 

		addListeners();
		JScrollPane scrollTasks=new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTasks.setBackground(new Color(54,57,63));
		scrollTasks.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(title,BorderLayout.NORTH);
		todoPanel.add(scrollTasks,BorderLayout.CENTER);
		todoPanel.add(btnPanel,BorderLayout.SOUTH);
		this.add(todoPanel,BorderLayout.WEST);
		this.add(pomodoro,BorderLayout.CENTER);

		this.setMinimumSize(new Dimension(800,650));
		this.pack();
		this.setVisible(true);
	}

	public void addListeners(){

		addWindowListener(new WindowAdapter()
        {

        	//I am overriding the opening window's function to add the tasks from the DB to the task list
        	public void windowOpened(WindowEvent e)
        	{
        		
        		try{
                	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TempoBoy","root","");
                	Statement stmt=con.createStatement();
                	ResultSet rs=stmt.executeQuery("select * from tasklist");
                	
                	while(rs.next()){
                		Task task=new Task(rs.getString(1), rs.getString(2));
                		
                		list.add(task);
                		list.updateNumbers();

                		task.getDone().addMouseListener(new MouseAdapter(){
							public void mousePressed(MouseEvent e){
								task.changeState();
							}
						});
                	}
                	rs.close();
                	stmt.close();
                   	con.close();
                   	revalidate();
                }catch(SQLException ex){
                	System.out.println("Error:"+ex);
                }



        	}

            //I am overriding the close button's function to save the data in the DB
            public void windowClosing(WindowEvent e)
            {
                try{
                	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TempoBoy","root","");
                	Statement stmt=con.createStatement();

                	Component[] listItems= list.getComponents();
               		stmt.executeUpdate("delete from tasklist");

					for(int i=0;i<(listItems.length);i++){
						if(listItems[i] instanceof Task){
							stmt.executeUpdate("insert into tasklist values('"+((Task)listItems[i]).getTaskName()+"','"+((Task)listItems[i]).getIntStatus()+"')");
							// System.out.println(((Task)listItems[i]).getTaskName()+"\t"+((Task)listItems[i]).getIntStatus());
							}
						}
						stmt.close();
                	con.close();
                }catch(SQLException ex){
                	System.out.println("Error:"+ex);
                }
                e.getWindow().dispose();
            }
        });

		addTask.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				Task task= new Task();
				list.add(task);
				list.updateNumbers();

				task.getDone().addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						task.changeState();
					}
				});
				revalidate();
			}
		});

		settingButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {				
				NewWindow newwindow = new NewWindow();
				try{
					pomodoro.timeoutTime=newwindow.a;
				}catch(Exception ex){
					pomodoro.timeoutTime=25;
				}
			} 
		});

		clear.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent a){
				list.removeTask();
				list.updateNumbers();
				repaint();
			}
		});
		revalidate();
	}

	public static void main(String[] args) {
		new WindowFrame();	
		new JProgressBar();
		
	}
}
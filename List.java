import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class List extends JPanel{
	List(){
		GridLayout layout= new GridLayout(20,1,6,1);
		layout.setVgap(10);
		this.setLayout(layout);
	}

	public void updateNumbers(){
		Component[] listItems= this.getComponents();

		for(int i=0;i<(listItems.length);i++){
			if(listItems[i] instanceof Task){
				((Task)listItems[i]).changeIndex(i+1);
				if(i>=20){
					this.remove((Task)listItems[i]);
				}
			}
		}
	}

	public void removeTask(){
		Component[] listItems= this.getComponents();

		for(int i=0;i<listItems.length;i++){
			if(listItems[i] instanceof Task){
					if(((Task)listItems[i]).getStatus()==true){
					this.remove((Task)listItems[i]);
				};
			}
		}
	}

	public void removeTask1(){
		Component[] listItems= this.getComponents();

		for(int i=0;i<listItems.length;i++){
			if(listItems[i] instanceof Task){
				if(((Task)listItems[i]).getSrNo().getText() == "1"){
					this.remove((Task)listItems[i]);
				};
			}
		}

	}
}
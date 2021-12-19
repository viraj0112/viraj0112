import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NewWindow{
    int a;

    NewWindow(){
        String temp = JOptionPane.showInputDialog(null, "Time(in minutes): ");
        a = Integer.parseInt(temp);
        
        // temp = JOptionPane.showInputDialog(parentComponent, message)
        JOptionPane.showMessageDialog(null, "Timer set to: "+a+" mins");
    }
}

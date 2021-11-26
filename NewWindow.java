import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NewWindow {

    JFrame frame = new JFrame();

    NewWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.dispose();
        String temp;
        temp = JOptionPane.showInputDialog(null, "Time: ");
        int a = Integer.parseInt(temp);
        // temp = JOptionPane.showInputDialog(parentComponent, message)
        JOptionPane.showMessageDialog(null, "Time setted: ");
    }
}

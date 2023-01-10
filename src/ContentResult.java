import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ContentResult extends JFrame {
    JFrame frame = new JFrame();
	private JPanel[] panel = null;
	
	public static void main(String[] args) {
		 new ContentResult();
	    }
	
    public ContentResult(){
        frame.setSize(900, 800);
        frame.setLocationRelativeTo(frame);
        frame.setLayout(new FlowLayout());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(103,105,105) ); 
        panel = addJPanels() ;
       
        frame.add(panel[0]);
        frame.setVisible(true);
    }
    
    
    public JPanel[] addJPanels() {

		 panel = new JPanel[3];
		 for (int i = 0; i < panel.length; i++) 
		 {
	       panel[i] = new JPanel();	 
	      
		 }
		 panel[0].setPreferredSize(new Dimension(800, 760));
		 panel[0].setBackground(new Color(230,230,230,255));
//		 panel[0].set
    	return panel;
    }
}



import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class ProgressBar extends JFrame{

	 public static void main(String[] args) {
		 ProgressBar bar= new ProgressBar(); 
		 bar.progress(); 
	        
	    }
	
	JFrame frame = new JFrame();
	private JProgressBar bar = new JProgressBar();
	private ImageIcon icon = new ImageIcon("loading.png");
	private JLabel imagelabel = null;
	private JLabel label = new JLabel("Please wait, while it calculates");
	private JPanel[] panel = null;
	private Image image= null;
	
	public ProgressBar() {
	frame.setTitle("Loading");
	frame.setSize(500, 435);
	frame.setLocationRelativeTo(frame);
	frame.setLayout(new FlowLayout());
	
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	panel = addPanels();
	frame.setVisible(true);
	
}
	
	
	public JPanel[] addPanels()
	{	imagelabel = new JLabel();
	
		 panel = new JPanel[2];
		 for(int i= 0; i<panel.length; i++) {
			 panel[i] = new JPanel();
			 frame.add(panel[i]);
		 }
		 
		 panel[0].setPreferredSize(new Dimension(500, 260));
		 panel[0].setBackground(new Color(230,230,230,255));
		 panel[1].setPreferredSize(new Dimension(500, 130));
		 panel[1].setBackground(new Color(230,230,230,255));

		 panel[1].setLayout(new GridBagLayout());
//		 panel[1].setPreferredSize(new Dimension(500, 130));
		 bar.setStringPainted(true);
		 bar.setPreferredSize(new Dimension(350, 30));
		 bar.setFont(new Font("TimeRoman", Font.PLAIN, 16));

		
	
		 try 
			{
				image = icon.getImage().getScaledInstance(500, 280, DO_NOTHING_ON_CLOSE);
				icon.setImage(image);
				imagelabel.setIcon(icon);
				panel[0].add(imagelabel);
			}
		catch(Exception e)
			{
				e.getStackTrace();
			}
		 
		 GridBagConstraints gbc = new GridBagConstraints();
		 
		 gbc.gridx = 0;
		 gbc.gridy = 0;
//		 gbc.insets = new Insets(0, 0, 0, 0);
		 label.setFont(new Font("TimeRoman", Font.ITALIC, 16));
		 panel[1].add(label, gbc);
		 
		 gbc.gridx = 0;
		 gbc.gridy = 1;
		 gbc.insets = new Insets(15, 0, 0, 0);
		 panel[1].add(bar, gbc);
		 
		 return panel;
	}
		
	
	public void progress() 
	{
		Runnable runnable = new Runnable() 
		{
			public void run()
			{
				int counter = 0;
				while(counter<=100) 
				{
					bar.setValue(counter);
					try {
						Thread.sleep(150);	
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						counter+=2;
				}
					
				frame.dispose();
				new ContentOutput();		
			}
		};new Thread(runnable).start();
			
	}
	
}

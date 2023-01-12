import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.*;
import java.util.List;

public class Calculator extends JFrame  implements ActionListener{
	
	
	public static void main(String[] args) {
		 new Calculator();
	    }
    Content content = new Content(Content.followers, Content.engagement, Content.numberOfPost, Content.niche, Content.platform);

	
	private JFrame frame = new JFrame();
	private JPanel[] panel = null;
	private JButton calculateButton = null;
	private JProgressBar bar = new JProgressBar(0,100);
//	private JLabel imageLabel = new JLabel();
//	private JPanel panel = new JPanel();
	private ImageIcon[] icon = null;
	private ImageIcon influIG = null;
	private JLabel[] label = null;
	private JLabel[] imageLabel = null;
	private JLabel[]  titleLabel = null;
	private Font[] font = null;
	
	private Image image= null;

	
	
	public Calculator(){
		frame.setSize(1100, 750);
        frame.setLocationRelativeTo(frame);
        frame.setLayout(new FlowLayout());
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(103,105,105) ); 
        // panel = addJPanels(content.getFollowers(), content.getEngagment(), content.getNoPost(),content.niche, content.getPlatform());
        panel = addJPanels();
		frame.add(panel[0]);
        frame.setVisible(true);
	}
	
	//  public JPanel[] addJPanels(long follower, double engagement,int  noOfpost,String niche, String platform) 
	public JPanel[] addJPanels()
	 {  
		 panel = new JPanel[8];
		
		 for (int i = 0; i < panel.length; i++) 
		 {
	       panel[i] = new JPanel();
	      
		 }
		 calculateButton = addButtons();
		 label = addLabels();
		 icon = addsImageIcon();
		 imageLabel = addImageLabels();
		 titleLabel = addTitleLabels();
		 
		 influIG = influencerImage();
		 
		 
		//Background Panel
		 panel[0].setLayout(new BorderLayout());
		 panel[0].setPreferredSize(new Dimension(1065, 700));
		 panel[0].setBackground(new Color(103,105,105));
		 
		 
		 panel[0].add(panel[1], BorderLayout.NORTH);
		 panel[0].add(panel[2], BorderLayout.CENTER);
		 panel[0].add(panel[3], BorderLayout.SOUTH);
		 
		 GridBagConstraints gbc = new GridBagConstraints();
		 
		 
		 //North Panel
		 panel[1].setLayout(new GridBagLayout());
		 panel[1].setPreferredSize(new Dimension(1100,420));
		 panel[1].setBackground(new Color(230,230,230,255));
		 panel[1].setBorder(BorderFactory.createLineBorder(new Color(230,230,230,255), 10));
		
		 //Influencer

		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 imageLabel[4].setIcon(influIG);
		 panel[1].add(imageLabel[4], gbc);
		 
		 
		  gbc.gridx = 0;
		  gbc.gridy = 1;
		//   gbc.insets = new Insets(0,0,0,0);
		  titleLabel[2].setText(content.getInfluencers());
		  panel[1].add(titleLabel[2], gbc);

		 
		 // Center Panel
		 panel[2].setBackground(new Color(245,245,245,255));
//		  panel[2].setPreferredSize(new Dimension(500,20));
//		 panel[2].setBackground(Color.red );

		 panel[2].setLayout(new GridBagLayout());
		 panel[2].setPreferredSize(new Dimension(500,20));
	
		 
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 imageLabel[0].setIcon(icon[1]);
		 panel[2].add(imageLabel[0], gbc); //First Image Label
		 
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 gbc.insets = new Insets(0,0,0,0);
		//  label[0].setText(Long.toString(follower));
		label[0].setText(Long.toString(content.getFollowers()));
		 panel[2].add(label[0], gbc); //follower label
		 
		 gbc.gridx = 1;
		 gbc.gridy = 1;
		//  gbc.insets = new Insets(0,100,0,0);
		 panel[2].add(titleLabel[0], gbc); //follower title
		 
		 
		 
		 //Second		 
		 gbc.gridx = 2;
		 gbc.gridy = 0; 
		 gbc.insets = new Insets(0,100,0,0);
		 imageLabel[1].setIcon(icon[4]);
		 panel[2].add(imageLabel[1], gbc); //second image label

		 gbc.gridx = 3;
		 gbc.gridy = 0;
		 gbc.insets = new Insets(0,0,0,100);
		//  label[1].setText(Double.toString(engagement));
		label[1].setText(Double.toString(content.getEngagment()));
		 panel[2].add(label[1], gbc);// engagement label
		 
		 gbc.gridx = 3;
		 gbc.gridy = 1;
		 panel[2].add(titleLabel[1], gbc);//engagement title Label

		 

		 //Third
		 gbc.gridx = 4;
		 gbc.gridy = 0;
		 gbc.insets = new Insets(0,0,0,0);
		 imageLabel[2].setIcon(icon[3]);
		 panel[2].add(imageLabel[2], gbc); //third image label 

		 gbc.gridx = 5;
		 gbc.gridy = 0;
		 gbc.insets = new Insets(0,0,0,0);
		//  label[2].setText(Integer.toString(noOfpost));
		label[2].setText(Integer.toString(content.getNoPost()));
		 panel[2].add(label[2], gbc); //Post Label

		 gbc.gridx = 5;
		 gbc.gridy = 1;
		 panel[2].add(titleLabel[3], gbc); //Post title label
		 
		
		 //Bottom Panel
		 
		 panel[3].setPreferredSize(new Dimension(900,60));
		 panel[3].setBackground(new Color(14,91,229));
		 panel[3].add(calculateButton);
	        
		 return panel;
	 }
	 
	 public JButton addButtons(){
		 calculateButton  = new JButton("Calculate");    

		 calculateButton .setPreferredSize(new Dimension(125, 50));
		 calculateButton .addActionListener(this);
	     return calculateButton ;
	 }
	 
	 public JLabel[] addLabels() {
		 font = addsFont();
		 String[] labels = {"0", "0","0" };
		 label = new JLabel[labels.length];
		
		 for(int i = 0; i<label.length; i++) {
			 label[i] = new JLabel(labels[i]);
			 label[i].setPreferredSize(new Dimension(100, 100));
			 label[i].setHorizontalAlignment(JLabel.CENTER);
			 label[i].setOpaque(true);
			 label[i].setBackground(new Color(230,230,230,255));
			 label[i].setFont(font[1]);
			 label[i].setForeground(new Color(14,91,229));
		 }
		 return label;
	 }
	 
	 public JLabel[] addImageLabels() {
		 
		 imageLabel = new JLabel[5];
		 for(int i = 0; i<imageLabel.length; i++) {
			 imageLabel[i] = new JLabel();
			 imageLabel[i].setHorizontalAlignment(JLabel.RIGHT);
		 }
		 
		 return imageLabel;
	 }
	 
	 public JLabel[] addTitleLabels() {
		 font = addsFont();
		 String[] labels = {"Followers", "Engagement","Industry", "Number of Post"};
		 titleLabel = new JLabel[labels.length];
		
		 for(int i = 0; i<titleLabel.length; i++) {
			 titleLabel[i] = new JLabel(labels[i]);
			 
			 titleLabel[i].setFont(font[2]);
			 titleLabel[i].setForeground(new Color(14,91,229));
		 }
		 titleLabel[2].setFont(font[0]);
		 titleLabel[2].setOpaque(true);
		 titleLabel[2].setHorizontalAlignment(JLabel.CENTER);
		 titleLabel[2].setForeground(Color.black);
		 titleLabel[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//  titleLabel[2].setPreferredSize(new Dimension(150,35));
		 
		 return  titleLabel;
	 }
	 
	 public ImageIcon[] addsImageIcon() {
	        String[] iconString = {"industry.png", "followers.png", "engagement.png", "post.png", "engage.png"};
	        icon =  new ImageIcon[iconString.length];

	       	try{
					for(int i = 0; i< icon.length; i++) 
					{   
						icon[i] = new ImageIcon(iconString[i]);
						image = icon[i].getImage().getScaledInstance(150, 150, DO_NOTHING_ON_CLOSE);
						icon[i].setImage(image);
					}
	           	}
			catch(Exception e) 
			   	{
	           	System.out.println("Not Image Detected this one");
	    		}
			
	        return icon;
	    }
	 
	 
	 public ImageIcon influencerImage() {
			influIG = new ImageIcon("influencer.png");
			influIG.setImage(influIG.getImage().getScaledInstance(350, 350, DO_NOTHING_ON_CLOSE));
		 return influIG;
	 }

	 
	public Font[] addsFont()
	{
	        font = new Font[3];
	        font[0] = new Font("TimesRoman", Font.ITALIC,20);//Industry
	        font[1] = new Font("TimesRoman", Font.PLAIN, 20);// Label showing numbers 
	        font[2] = new Font("TimesRoman", Font.PLAIN,16);//Title
	
	        return font;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		if(e.getSource()== calculateButton) {
			
			//   ProgressBar bar = new ProgressBar();
			//   bar.progress();			
			  
			  content.caluator(content.getPlatform());
			  System.out.println("Who you are "+ content.getInfluencers());
			  new ContentOutput();	
			  
//			  ContentResult result = new ContentResult();
			  
			  
			 
		}
	}
	
 
}

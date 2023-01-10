import java.awt.*;

import javax.swing.*;
// import javax.swing.event.ChangeEvent;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.event.*;



public class Priculator extends JFrame implements ChangeListener, ActionListener{
	
	public static void main(String[] args) {
    	new Priculator(); 
     
    }
	
	
    JFrame frame = new JFrame();
    private JPanel[] panel = null;
    private static JButton submitButton = null   ;
    private JTextField[] textfield = null;
    private JLabel[] label = null;
    private JLabel[] imageLabel = null;
    private JSlider slider = null;
    private Font[] font = null;
    private JComboBox combo = null;
    private JRadioButton[] radio = null;
    private ImageIcon[] icon = null;
    private  ButtonGroup group =null;
    
//    private JProgressBar bar = new JProgressBar();

    public Priculator(){
        frame.setSize(1235, 786);
        frame.setLocationRelativeTo(frame);
        frame.setLayout(new FlowLayout());
        // frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = addJPanels();
        combo.addActionListener(this);
        

        frame.getContentPane().setBackground(new Color(103,105,105) );
        frame.setVisible(true);
    }

    public JPanel[] addJPanels(){
        panel = new JPanel[8];
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            frame.add(panel[i]);
        }
        label = addsJLabels();
        imageLabel = addsImageLabels();
        textfield = addsTextFields();
        submitButton = addButtons();
        slider = addsSlider();
        combo = addsJComboBox();
        radio =  addsJRadioButton();
        icon = addsImageIcon();
       
       
        panel[0].setPreferredSize(new Dimension(1200, 450)); //Parent Panel Top
        panel[0].setLayout(new BorderLayout());

        panel[0].add(panel[2], BorderLayout.NORTH); //Top Panel at the top
        panel[0].add(panel[3], BorderLayout.CENTER);
        panel[0].add(panel[4], BorderLayout.SOUTH); //Bottom Panel at the top

        
//        panel[2].setBackground(Color.red);
        
//        panel[2].setBackground(new Color(241,242,243));
//        panel[2].add(imageLabel[4]);
//        imageLabel[4].setFont(font[1]);
        

        panel[3].setLayout(new GridBagLayout());
       panel[3].setBackground(new Color(230,230,230,255));
        
        // panel[3].setBackground(new Color(103,105,105));
//		 panel[3].setBorder(BorderFactory.createLineBorder(new Color(230,230,230,255), 10));
        GridBagConstraints gbc = new GridBagConstraints();

       

        
     
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        imageLabel[0].setIcon(icon[3]);
////        gbc.insets = new Insets(0,50,0,0);
//        panel[3].add(imageLabel[0], gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.insets = new Insets(0,0,0,0);
        imageLabel[3].setIcon(icon[2]); // change icon
        panel[3].add(imageLabel[3], gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
//        gbc.insets = new Insets(0,0,0,0);
        imageLabel[2].setIcon(icon[1]); // change icon
        panel[3].add(imageLabel[2], gbc);

        
        //Blue Content Panel
        panel[1].setLayout(new BorderLayout()); //Parent Panel Bottom
        panel[1].setPreferredSize(new Dimension(1200, 260));
        
        panel[1].add(panel[5], BorderLayout.NORTH);
        panel[1].add(panel[6], BorderLayout.CENTER);
        panel[1].add(panel[7], BorderLayout.SOUTH);

/****** Panel 5 ***/
        panel[5].setBackground(new Color(14,91,229));
        
        panel[5].add(radio[0]); //Facebook radio Button

        panel[5].add(radio[1]);//Instagram Radio Button

        panel[5].add(radio[2]); //Tiktom Radio Button

        panel[5].add(radio[3]);//Youtube Radio
        
/****Panel 6 **/
        panel[6].setLayout(new GridBagLayout());
        panel[6].setBackground(new Color(14,91,229));      
        
       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,5);
        panel[6].add(label[0],gbc); //Followers

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,40);
        panel[6].add(textfield[0],gbc); //Followers Textfield
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,5);
        panel[6].add(label[1],gbc); //Engagement
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        // gbc.insets = new Insets(0,0,0,0);
        panel[6].add(textfield[1],gbc); // Engagement Textfield
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        slider.setOpaque(false);
//        gbc.insets = new Insets(0,0,0,40);
        panel[6].add(slider, gbc); //Slider
        
        gbc.gridx = 5;
        gbc.gridy = 0;
         gbc.insets = new Insets(0,40,0,5);
        panel[6].add(label[4], gbc); //Number of Post Label
        
        gbc.gridx = 6;
        gbc.gridy = 0;
         gbc.insets = new Insets(0,0,0,0);
        panel[6].add(textfield[2], gbc); //Number of Post Textfield
        
        
        gbc.gridx = 7;
        gbc.gridy = 0;
         gbc.insets = new Insets(0,40,0,0);
        panel[6].add(label[2],gbc); //Combo box label
        
        gbc.gridx = 8;
        gbc.gridy = 0;
         gbc.insets = new Insets(0,0,0,0);
        panel[6].add(combo,gbc);// Combo box


        panel[7].setBackground(new Color(14,91,229));
        panel[7].setPreferredSize(new Dimension(1220, 75));
        panel[7].add(submitButton);
        
        return panel;
    }
    
    public JButton addButtons(){
        
        submitButton =  new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(125, 45));
        submitButton.addActionListener(this);
        return submitButton;
    }

    public JTextField[] addsTextFields() {
      
        font = addsFont();
    	textfield = new JTextField[3];

        for (int i = 0; i < textfield.length; i++) {
            textfield[i] = new JTextField("1", 6);
            textfield[i].setFont(font[0]);
            textfield[i].setBorder(null);
            // textfield[i].setPreferredSize(new Dimension(300,50));

        }

        textfield[1] = new JTextField("1", 3); 
        textfield[1].setFont(font[0]);
        // textfield[1].setEditable(false);
        
        textfield[2] = new JTextField("1",4);
        textfield[2].setFont(font[0]);
        textfield[2].setBorder(null);
        return textfield;
    }

    public JLabel[] addsJLabels() {
       
        font = addsFont();
        label = new JLabel[6];
        
        String[] labels = {"Followers", "Engagement","Niche", "Priculator", "Number of Post","Platform"};
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel(labels[i]);
            label[i].setForeground(new Color(230,230,230,255));
            label[i].setForeground(new Color(230,230,230,255));
            label[i].setFont(font[0]);
        }
        label[3].setFont(font[4]);
        return label;
    }

    public JLabel[] addsImageLabels() {
        font = addsFont();
        imageLabel = new JLabel[6];
       
        for (int i = 0; i < label.length; i++) {
            imageLabel[i] = new JLabel();
            // imageLabel[i].setForeground(new Color(14,91,229));
        }
        return imageLabel;
    }

    public JSlider addsSlider() {
        font = addsFont();
        slider = new JSlider(slider.HORIZONTAL, 0, 100,0);
        slider.addChangeListener(this);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setForeground(Color.WHITE);
        // slider.
        slider.setPaintTicks(true);
        slider.setFont(font[2]);
        slider.setBackground(Color.WHITE);
        return slider;
    }

    public JComboBox addsJComboBox() 
     {
    	 String[] combos = {"Beauty", "Fashion","Fitness","Health","Lifestyle", "Photography","Travel" };
     
         return combo = new JComboBox(combos);
     }

     public JRadioButton[] addsJRadioButton() 
     {  icon = addsImageIcon() ;
     
        font = addsFont();
        group = new ButtonGroup();
        radio = new JRadioButton [4];
    	 String[] radios = {"Facebook", "Instagram","Tiktok","YouTube" };
        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(radios[i]);
            radio[i].setFont(font[5]);
//            radio[i].setForeground(new Color(14,91,229));
            radio[i].setForeground(new Color(14,91,229));
            radio[i].setOpaque(true);
            radio[i].setBackground(new Color(230,230,230,255));
//            radio[i].setBackground(Color.white);
            radio[i].setPreferredSize(new Dimension(150, 50));
            radio[i].setSelected(true);
            radio[i].setBorder(BorderFactory.createLineBorder(Color.white));
//            radio[i].setBorderPainted(true);
//            radio[i].setFocusPainted(true);
            radio[i].setIconTextGap(5);
            
            
            radio[i].addActionListener(this);      
            group.add(radio[i]);
        }
        
         return radio;
     }



     public ImageIcon[] addsImageIcon() {
        String[] iconString = {"followers.png", "engagement.png","influence.png"};
        label = addsJLabels();
        icon =  new ImageIcon[iconString.length];
        Image image = null;

       try {
           for(int i = 0; i< icon.length; i++) {   
            icon[i] = new ImageIcon(iconString[i]);
            image = icon[i].getImage().getScaledInstance(400, 400, DO_NOTHING_ON_CLOSE);
            icon[i].setImage(image);
           }
           
           }catch(Exception e) {
           System.out.println("Not Image Detected");
        }
    
        return icon;
    }

    public Font[] addsFont(){
        font = new Font[6];
        font[0] = new Font("TimesRoman", Font.BOLD,20);//textfield font
        font[1] = new Font("TimesRoman", Font.ITALIC, 30);//Left Panel Industry
        font[2] = new Font("TimesRoman", Font.PLAIN,10);//SLIDER font
        font[3] = new Font("TimesRoman", Font.ITALIC,22);//Bottom Panel font
        font[4] = new Font("TimesRoman", Font.ITALIC,30);//Bottom Panel title
        font[5] = new Font("TimesRoman", Font.ITALIC,20);//radio
        return font;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
        if(e.getSource() == slider){
            
            textfield[1].setText(Double.toString(slider.getValue()));
        }

        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    	String follow  = textfield[0].getText();
    	String engage = textfield[1].getText();
    	String post = textfield[2].getText();
    	
    	
        if(e.getSource() == submitButton){
        	
        	if(follow.isEmpty()|| engage.isEmpty()|| post.isEmpty() ) {
        		
        		if(follow.isEmpty()) {
        			JOptionPane.showMessageDialog(this, "Follower field is empty");
        		}
        		else if(engage.isEmpty()) {
        			JOptionPane.showMessageDialog(this, "Engagement rate field is empty");
        		}
        		else if(post.isEmpty()) {
        			JOptionPane.showMessageDialog(this, "Number of Post field is empty");
        		}
        		
        		else {
        			JOptionPane.showMessageDialog(this, "Check all fields");
        		}
 
        	}
        	else {
        		
        		long follower  = Long.parseLong(follow); //converting the follower textfield to integer
            	double engagement = Double.parseDouble(engage); //converting the engagement textfield to Double 
            	int noOfpost = Integer.parseInt(post);//converting the post textfield to integer
            	String niche = combo.getSelectedItem().toString();//converting niche to string
            	String platform= null;
            	for (int i = 0; i<radio.length; i++) {
            		if(radio[i].isSelected()) {
            			platform = radio[i].getActionCommand(); //converting radio button to string
//                		platform = radio[i].getText();
            		}
            	}
            	
	        	Content content = new Content(follower, engagement, noOfpost,niche, platform) ;
	        	content.checks();
	        	System.out.println("Followers: "+content.getFollowers()+"\nEngagement: "+content.getEngagment()+"\nPost: "+content.getNoPost()+"\nNiche: "+content.getIndustry()+ "\nPlatform: "+content.getPlatform());
	        	System.out.println();
	        	new Calculator();
//
        	}
        
          
        }
        	
            
    }
}


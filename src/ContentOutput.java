import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentOutput extends JFrame {
    JFrame frame = new JFrame();
	private JPanel[] panel = null;
    private JLabel[] label = null;
    private JLabel[] titleLable = null;
    private ImageIcon[] icon = null;
    private Font[] font = null;


    Content content = new Content(Content.followers, Content.engagement,Content.numberOfPost, Content.niche, Content.platform);
	
	public static void main(String[] args) {
		 new ContentOutput();
	    }
	
    public ContentOutput(){
        frame.setSize(1000, 900);
        frame.setLocationRelativeTo(frame);
        frame.setLayout(new FlowLayout());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(103,105,105) ); 
        panel = addJPanels() ;
       
        frame.add(panel[0]);
        frame.setVisible(true);
    }
    
    
    public JPanel[] addJPanels() {
       
		 panel = new JPanel[8];
		 for (int i = 0; i < panel.length; i++) 
		 {
	       panel[i] = new JPanel();	 
		 }

         label = addsJLabel();
         titleLable =  addsTitleJLabel();
         font =  addFonts();


         
         panel[0].setBackground(new Color(103,105,105)); //Top Panel
         panel[0].setPreferredSize(new Dimension(950,820));
         panel[0].setLayout(new BorderLayout());

         panel[0].add(panel[1], BorderLayout.NORTH);
         panel[0].add(panel[2], BorderLayout.CENTER);
         panel[0].add(panel[3], BorderLayout.SOUTH);
         
		 panel[1].setBackground(new Color(245,245,245,255)); //Top Panel
         panel[1].setPreferredSize(new Dimension(800,75));
         panel[1].setLayout(new GridBagLayout());
         
         GridBagConstraints gbc = new GridBagConstraints();

/**** Top Panel*/
         gbc.gridx = 0;
         gbc.gridy = 0;
         panel[1].add(label[0], gbc); 

    
/**** Center Panel*/
         panel[2].setBackground(new Color(245,245,245,255)); 
        //  panel[2].setBackground(Color.gray); 
         panel[2].setLayout(new GridBagLayout());
        //  panel[2].setPreferredSize(new Dimension(800,50)); 
        //   gbc.insets = new Insets(0,0,30, 0);
       

         gbc.gridx = 0;
         gbc.gridy = 0;
         label[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
         label[1].setPreferredSize(new Dimension(200,50));
         label[1].setText("Niche: " + content.getIndustry());
         label[1].setForeground(Color.BLACK);
         panel[2].add(label[1], gbc); //Niche label

         gbc.gridx = 1;
         gbc.gridy = 1;
         gbc.insets = new Insets(30,0, 0, 0);
         panel[2].add(label[2], gbc); //Posting Image Label

         gbc.gridx = 2;
         gbc.gridy = 1;
         gbc.insets = new Insets(30,0, 0, 30);
         panel[2].add(label[3], gbc); //Post Label output

         gbc.gridx = 2;
         gbc.gridy = 2;
         gbc.insets = new Insets(0,0,0, 0);
         panel[2].add(titleLable[0], gbc); //Post Label title

        //  gbc.gridx = 2;
        //  gbc.gridy = 1;
        //  gbc.insets = new Insets(30,0,0, 0);
        //  panel[2].add(label[4], gbc); //Stories Label

         gbc.gridx = 3;
         gbc.gridy = 1;
         gbc.insets = new Insets(30,0,0, 0);
         panel[2].add(label[4], gbc); //Stories Image Label

         gbc.gridx = 4;
         gbc.gridy = 1;
         panel[2].add(label[5], gbc); //Stories  Label output

         gbc.gridx = 4;
         gbc.gridy = 2;
         gbc.insets = new Insets(0,0,0, 0);
         panel[2].add(titleLable[1], gbc); //Stories Label title

         gbc.gridx = 5;
         gbc.gridy = 1;
         gbc.insets = new Insets(30,30,0, 0);
         panel[2].add(label[6], gbc); //Video Image Label

         gbc.gridx = 6;
         gbc.gridy = 1;
         gbc.insets = new Insets(30,0,0, 0);
         panel[2].add(label[7], gbc); //Video Label output

         gbc.gridx = 6;
         gbc.gridy = 2;
         gbc.insets = new Insets(0,0,0, 0);
         panel[2].add(titleLable[2], gbc); //Post Label title
         
/**** Bottom Panel*/
        //  panel[3].setBackground(new Color(230,230,230,255)); light gray color
         panel[3].setBackground(new Color(14,91,229));
         panel[3].setPreferredSize(new Dimension(800,550));

         Dimension size = new Dimension(275, 200);
         panel[3].setLayout(new GridBagLayout());
         gbc.insets = new Insets(35, 0, 40, 50);

         gbc.gridx = 0;
         gbc.gridy = 0;
         
         panel[4].setPreferredSize(size);
         panel[3].add(panel[4], gbc);

         gbc.gridx = 1;
         gbc.gridy = 0;
         panel[5].setPreferredSize(size);
         panel[3].add(panel[5], gbc);

         gbc.gridx = 0;
         gbc.gridy = 1;
         panel[6].setPreferredSize(size);
         panel[3].add(panel[6], gbc);

         gbc.gridx = 1;
         gbc.gridy = 1;
         panel[7].setPreferredSize(size);
         panel[3].add(panel[7], gbc);


//		 panel[0].set
    	return panel;
    }

    public JLabel[] addsJLabel(){
        font =  addFonts();
        String title = "Based on information provided, these are the estimated Cost";
        String[] labels = {title, "Niche ", "Posting ","p0" ,"Story ", "s0", "video ", "0v", "Facebook", "Instagram", "Tiktok", "YouTube"};
        label = new JLabel[labels.length];
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel(labels[i]);
            label[i].setFont(font[0]);
            label[i].setHorizontalAlignment(JLabel.CENTER);
        }

        Dimension dim = new Dimension(125, 75);
        label[3].setOpaque(true);
        label[3].setBackground(new Color(230,230,230,255));
        label[3].setPreferredSize(dim);

        label[5].setOpaque(true);
        label[5].setBackground(new Color(230,230,230,255));
        label[5].setPreferredSize(dim);

        label[7].setOpaque(true);
        label[7].setBackground(new Color(230,230,230,255));
        label[7].setPreferredSize(dim);
        return label;
    }
    public JLabel[] addsTitleJLabel(){

        font =  addFonts();
        String[] labels = {"Posting ","Story ", "video "};
        titleLable= new JLabel[labels.length];
        for (int i = 0; i < titleLable.length; i++) {
            titleLable[i] = new JLabel(labels[i]);
            titleLable[i].setFont(font[0]);
            titleLable[i].setHorizontalAlignment(JLabel.CENTER);
        }
        return titleLable;
    }

    // public JLabel[] addsImageJLabel(){
       

    //     label = new JLabel[3];
    //     for (int i = 0; i < label.length; i++) {
    //         label[i] = new JLabel();
    //         // label[i].setFont(font[0]);
    //     }
    //     return label;
    // }

    public ImageIcon[] addsImages(){
        icon = new ImageIcon[3];

        String[] imageNames = {"industry.png", "followers.png", "engagement.png", "post.png", "engage.png"};
        
        for (int i = 0; i < icon.length; i++) {
        icon[i] = new ImageIcon(imageNames[i]);
        }
        return icon;
    }

    public Font[] addFonts(){
        font  = new Font[3];
        
        font[0] = new Font("TimesRoman",Font.PLAIN, 22);
        return font;
    }

    

}



package best_travel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class UIStart extends JFrame {

	JLabel lbBack, lbHistory, lbClickRes, lbReset; 
	JTextArea taStandard;
	JScrollPane spINPstd, spTFDirectory; 
	JTextField tfDirectory, tfDistance, tfCityNum, tfRes;
	JButton btnBrowse; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UIStart(); 
	}
	
	public UIStart()
	{
		/************************************/
		/*
		 * set some basic properties for the frame
		 */
		this.setTitle("START");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* this frame could be closed without affecting the program */ 
		this.getContentPane().setLayout(null); /* absolute layout */ 
		this.setLocationRelativeTo(null);   /* the frame will appear center*/
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		
		/*
		 * set icon for the frame
		 */
		Image icon = (new ImageIcon("Images/eicon.png")).getImage(); 
		this.setIconImage(icon);
		
		/*
		 * create panel for the picture of the app
		 */
		JPanel pnPic = new JPanel(); 
		pnPic.setBounds(0, 0, 1000, 202);
		pnPic.setLayout(null);
		pnPic.setBackground(Color.white);
		
		ImageIcon image = new ImageIcon("Images/picmenusmol.jpg");
		JLabel lbImage = new JLabel(image);
		lbImage.setBounds(245, 0, 504, 201);
		pnPic.add(lbImage);
		
		lbBack = new JLabel("back to main menu"); /* click this label go back to main menu */ 
		lbBack.setBounds(10,10, 160, 30);
		pnPic.add(lbBack); 
		lbBack.setFont(new Font("UD Digi Kyokasho NP-B", Font.ITALIC, 14));
		
		lbHistory = new JLabel("go to history"); 
		lbHistory.setBounds(880,10,100,30);
		lbHistory.setFont(new Font("UD Digi Kyokasho NP-B", Font.ITALIC, 14));
		pnPic.add(lbHistory); 
		this.add(pnPic);
		/************************************/
		/*
		 * create input panel
		 */
		JPanel pnINP = new JPanel(); 
		pnINP.setLayout(null);  	/* absolute layout */
			/*
			 * standard INP elements 
			 */
		JLabel lbStandardINP = new JLabel("Please insert your list of distances HERE:"); 
		//lbStandardINP.setFont(new Font("Microsoft Jhenghei UI", Font.BOLD, 20));
		lbStandardINP.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
			/*
			 *  make the label underlined 
			 */
		Font font = lbStandardINP.getFont(); 
		Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();;
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbStandardINP.setFont(font.deriveFont(attributes));
			/****/
		taStandard = new JTextArea("type something here..."); 
		taStandard.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 16));
		taStandard.setWrapStyleWord(true);
		taStandard.setLineWrap(true);
		taStandard.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		spINPstd = new JScrollPane(taStandard); 
			/*
			 * set positions for standard INP elements
			 */
		lbStandardINP.setBounds(10, 10, 350, 20);
		spINPstd.setBounds(45, 40, 900, 80);
		
			/*
			 * File INP elements 
			 */
		JLabel lbFileINP = new JLabel("or Upload your file HERE:");
		lbFileINP.setFont(font.deriveFont(attributes));
		
		tfDirectory = new JTextField("Directory..."); 	/* this text field displayed the directory, so it could not be editable */
		tfDirectory.setEditable(false);
		tfDirectory.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 16));
		tfDirectory.setBackground(Color.white);
		tfDirectory.setBorder(BorderFactory.createLoweredBevelBorder());
		spTFDirectory = new JScrollPane(tfDirectory); /* in case the directory link is too long */ 
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		btnBrowse.setBackground(new Color(135, 206, 235));
			/*
			 * set positions for File INP elements 
			 */
		lbFileINP.setBounds(10, 140, 350, 20);
		spTFDirectory.setBounds(230, 135, 550, 30);
		btnBrowse.setBounds(810, 135, 100, 30);
			/*
			 * input: distance limitation 
			 */
		JLabel lbDistance = new JLabel("Distance Limitation:"); 
		lbDistance.setFont(font.deriveFont(attributes));
		
		tfDistance = new JTextField(); 
		tfDistance.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 16)); 
		tfDistance.setBackground(Color.white);
		//tfDistance.setBorder(BorderFactory.createLoweredBevelBorder());
		
		lbDistance.setBounds(10, 190, 200, 20);
		tfDistance.setBounds(230, 185, 550, 30);
		
			/*
			 * input: number of cities 
			 */
		JLabel lbCityNum = new JLabel("Number of cities:"); 
		lbCityNum.setFont(font.deriveFont(attributes));
		
		tfCityNum = new JTextField(); 
		tfCityNum.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 16)); 
		tfCityNum.setBackground(Color.white);
		
		lbCityNum.setBounds(10, 240, 200, 20);
		tfCityNum.setBounds(230, 235, 550, 30);
		
		/*
		 *  add all of the INP elements into the panel
		 */
		pnINP.add(lbStandardINP); 
		pnINP.add(spINPstd);
		pnINP.add(lbFileINP); 
		pnINP.add(spTFDirectory); 
		pnINP.add(btnBrowse); 
		pnINP.add(lbDistance);
		pnINP.add(tfDistance);
		pnINP.add(lbCityNum); 
		pnINP.add(tfCityNum);
		
		/*
		 * add input panel to the frame
		 */
		pnINP.setBounds(0, 202, 1000, 280);
		pnINP.setBackground(Color.white);
		this.add(pnINP); 
		/************************************/
		/*
		 * create output panel
		 */
		JPanel pnOUT = new JPanel(); 
		pnOUT.setLayout(null); 			/* absolute layout */
		pnOUT.setBackground(Color.white);
		
			/*
			 *  create output elements 
			 */
		font = new Font("Bahnschrift", Font.PLAIN, 20);
		attributes = (Map<TextAttribute, Object>) font.getAttributes();;
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		lbClickRes = new JLabel("click to see result"); 
		lbClickRes.setFont(new Font("Microsoft Jhenghei UI", Font.BOLD, 20));
		lbClickRes.setBounds(330, 0, 180, 40);
		
		JLabel lbRes = new JLabel("The distance chosen by Mary and John: "); 
		lbRes.setFont(font.deriveFont(attributes));
		lbRes.setBounds(10, 40, 500, 40);
		
		tfRes = new JTextField(""); 
		tfRes.setEditable(false);
		tfRes.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));
		tfRes.setBounds(370, 45, 450, 30);
		
		JLabel lbMiles = new JLabel("mile(s)"); 
		lbMiles.setFont(font);
		lbMiles.setBounds(850, 45, 100, 30);
		
		lbReset = new JLabel("reset"); 
		lbReset.setFont(new Font("Microsoft Jhenghei UI", Font.BOLD, 20));
		lbReset.setBounds(550, 0, 300, 40);
		
		
		pnOUT.add(lbReset); 
		pnOUT.add(lbClickRes);
		pnOUT.add(lbRes); 
		pnOUT.add(tfRes); 
		pnOUT.add(lbMiles);
		
		pnOUT.setBounds(0, 470, 1000, 120);
		this.add(pnOUT);
		
		this.getContentPane().setBackground(null);
		
		/**************************************************/
		/*
		 * add event to the elements 
		 */
		StartEvent obj = new StartEvent(this); 
		btnBrowse.addActionListener(obj);
		btnBrowse.addMouseListener(obj);
		lbBack.addMouseListener(obj);
		lbHistory.addMouseListener(obj);
		lbClickRes.addMouseListener(obj);
		lbReset.addMouseListener(obj);
		taStandard.addMouseListener(obj);
		taStandard.addKeyListener(obj);
		this.setVisible(true);
		
	}

}

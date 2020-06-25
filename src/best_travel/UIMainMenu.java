package best_travel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UIMainMenu extends JFrame{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DataBase.createDataBase();
		new UIMainMenu(); 
		
	}
	
	/* 
	 * Create the frame of MainMenu
	 */
	public UIMainMenu()
	{
		/*
		 * set the basic properties of the frame 
		 */
		this.setTitle("Best Travel!");
		/*
		 *  show a prompt when user close the window
		 */
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Best Travel",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		this.setSize(1000,600);
		this.setLayout(null); 	/* set absolute layout */ 

		this.getContentPane().setBackground(Color.white);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);	/* the frame will appear centered */
		/*
		 * create icon for the app
		 */
		Image icon = (new ImageIcon("Images/icon.png")).getImage(); 
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
		
		JLabel lbAbout = new JLabel("About us"); 	/* this will display developers' information */
		lbAbout.setBounds(900, 8, 80, 40);
		lbAbout.setFont(new Font("UD Digi Kyokasho NP-B", Font.BOLD, 16));
		pnPic.add(lbAbout);
		this.add(pnPic); 
		/*
		 * create description panel
		 */
		JPanel pnDescribe = new JPanel(); 
		pnDescribe.setBounds(0, 202, 1000, 200);
		pnDescribe.setLayout(null);
		pnDescribe.setBackground(Color.white);
		
		/*
		 *  the original text is too long -> divide it into 2 parts 
		 *  part 1
		 */ 
		String text1 = "      John and Mary want to travel between a few towns A, B, C ... Mary has on a sheet of paper a list of distances between these towns. John is tired of driving and he says to Mary that he doesn't want to drive more than t miles and he will visit only k towns.";
		JTextArea taDescribe1 = new JTextArea(); 
		taDescribe1.setWrapStyleWord(true);
		taDescribe1.setLineWrap(true);
		taDescribe1.append(text1);
		taDescribe1.setBounds(30, 50, 960, 65);
		taDescribe1.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 16));
		taDescribe1.setEditable(false); 	/* this TextArea cannot be edited */
		/*
		 * part 2
		 */
		String text2 = "      Which distances, hence which towns, they will choose so that the sum of the distances is the biggest possible to please Mary and John?"; 
		JTextArea taDescribe2 = new JTextArea(); 
		taDescribe2.setWrapStyleWord(true);
		taDescribe2.setLineWrap(true);
		taDescribe2.setText(text2);
		taDescribe2.setBounds(30, 140, 960, 50);
		taDescribe2.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 16));
		taDescribe2.setEditable(false); 	/* this TextArea cannot be edited */
		
		pnDescribe.add(taDescribe2);
		pnDescribe.add(taDescribe1);
		this.add(pnDescribe);
		
		/*
		 * create buttons' panel
		 */ 
		JPanel pnButtons = new JPanel(); 
		pnButtons.setLayout(null);
		pnButtons.setBounds(0,400,1000,198);
		pnButtons.setBackground(Color.white);
		
		JButton btnStart = new JButton("START"); 
		btnStart.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnStart.setBackground(new Color(135, 206, 235));
		btnStart.setBounds(100, 30, 155, 75);
		
		JButton btnHistory = new JButton("HISTORY"); 
		btnHistory.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnHistory.setBackground(new Color(135, 206, 235));
		btnHistory.setBounds(415, 30, 155, 75);
		
		JButton btnExit = new JButton("EXIT"); 
		btnExit.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		btnExit.setBackground(new Color(135, 206, 235));
		btnExit.setBounds(725, 30, 155, 75);
		btnExit.setForeground(Color.red);
		
		pnButtons.add(btnStart); 
		pnButtons.add(btnHistory);
		pnButtons.add(btnExit);
		this.add(pnButtons); 
		
		
		/*
		 * Add Mouse Event Listener to the components of the frame
		 */
		MainMenuEvent obj = new MainMenuEvent(this); 
		lbAbout.addMouseListener(obj);	/* add Mouse Clicked Event for label About*/
		btnStart.addMouseListener(obj);
		btnHistory.addMouseListener(obj);
		btnExit.addMouseListener(obj);
		
		this.setVisible(true);
	}
	
}

package best_travel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/*
 * this class will show the information of the dev team
 */
public class AboutUs extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AboutUs();
	}
	
	public AboutUs()
	{
		/*
		 * Set some basic properties of the frame 
		 */
		this.setTitle("About Us");
		this.setSize(750, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	/* this frame could be closed without affecting others */ 
		this.setResizable(false);
		this.setLocationRelativeTo(null); /* this frame will appear centered */ 
		this.getContentPane().setBackground(Color.white);
		this.getContentPane().setLayout(new GridLayout(3,1));
		
		/*
		 * set icon for the frame
		 */
		Image icon = (new ImageIcon("Images/icon.png")).getImage();
		Image newimg = (icon).getScaledInstance(1000, 1000,java.awt.Image.SCALE_SMOOTH);
		this.setIconImage(newimg);
		/*
		 * Show the name of the project on the frame
		 * The name panel will contain logo and name of the project
		 */
		JPanel pnname = new JPanel();  
		pnname.setLayout(new BorderLayout(10,10)); 
		pnname.setBackground(Color.white);
		ImageIcon logo = new ImageIcon("Images/iconsmol.png");
		JLabel lbLogo = new JLabel(logo);
		lbLogo.setSize(logo.getIconWidth()-10, logo.getIconHeight()-10);
		pnname.add(BorderLayout.WEST, lbLogo); 
		
		String Text =  "PROJECT 4: Application Programming" + "\n" + "BEST TRAVEL!"; 
		JTextPane tpProjName = new JTextPane(); 
		tpProjName.setText(Text);
		tpProjName.setEditable(false);
//		tpProjName.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 25));
		tpProjName.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		tpProjName.setForeground(new Color(25, 25, 112));
		/*
		 *  Align the text centered
		 */ 
		StyledDocument style = tpProjName.getStyledDocument();
		SimpleAttributeSet align= new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
		style.setParagraphAttributes(0, style.getLength(), align, false);
		pnname.add(tpProjName);
		this.add(pnname);
		
		
		/*
		 * Add information of the dev team into the frame
		 */
		
		String InfoTeamText ="\n\t" + "18TCLC_NHAT - 18N16 - TEAM 4:" + "\n\t\t" + "- Thai Thi Thu Loan" + "\n\t\t" + "- Tran Xuan Phuc"; 
		JTextPane tpInfoTeam = new JTextPane(); 
		tpInfoTeam.setText(InfoTeamText);
		tpInfoTeam.setEditable(false);
		tpInfoTeam.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		tpInfoTeam.setForeground(Color.black);
		
		this.add(tpInfoTeam);
		/*
		 * Add contacts
		 */
		String textContacts = "\t" + "Contacts" + "\n\t\t" + "- Email: thloanth.dut@gmail.com" + 
							  "\n\t\t" + "- Email: txp.dut@gmail.com" +"\n\t\t" + 
							  "- Address: Danang University of Science and Technology"; 
		JTextPane tpContacts = new JTextPane(); 
		tpContacts.setText(textContacts);
		tpContacts.setEditable(false);
		tpContacts.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		tpContacts.setForeground(Color.black);
		
		this.add(tpContacts);
		
		this.setVisible(true);
	
	}
	


}

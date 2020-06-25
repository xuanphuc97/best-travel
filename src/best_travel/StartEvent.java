package best_travel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class StartEvent implements ActionListener, MouseListener{
	UIStart obj; 
	public StartEvent(UIStart obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Browse")) {
			try {
				JFileChooser c = new JFileChooser(); 
				int rVal = c.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					String filename = c.getSelectedFile().getName(); 
					String dir = c.getCurrentDirectory().toString(); 
					String filePath = dir + "\\" + filename; 
					obj.tfDirectory.setText(filePath); 
				}
				
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		}	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object subobj = e.getSource(); 
		String Text = null; 
		try {
			JLabel sublb = (JLabel)subobj; 
			Text = sublb.getText(); 
		}
		catch (Exception ex) {
			try 
			{
				JTextArea subta = (JTextArea) subobj; 
				obj.taStandard.setText("");
			} catch (Exception e1) {
				//JOptionPane.showMessageDialog(null, e1.toString());
			}
			
		}
		
		if (Text == "back to main menu") {
			new UIMainMenu(); 
			obj.dispose();
		}
		
		if (Text == "go to history")
		{
			new UIHistory(); 
			obj.dispose();
		}
		if (Text == "click to see result")
		{
			/*
			 * Process and calculate the distance
			 */
			
			/*
			 * get all of the input elements and add them to database 
			 */
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			obj.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Object subobj = e.getSource(); 
			try {
				JLabel sublb = (JLabel)subobj; 
				sublb.setForeground(Color.red);
				e.setSource(sublb);
			}
			catch (Exception ex){
				try 
				{
					JButton subbtn = (JButton) subobj;
					subbtn.setBackground(Color.blue);
					e.setSource(subbtn);
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		}
		catch (Exception ex)
		{
			
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object subobj = e.getSource();
		try {
			obj.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			try{
				JLabel sublb = (JLabel)subobj; 
				sublb.setForeground(Color.black);
				e.setSource(sublb);
			}
			catch (Exception ex) {
				try 
				{
					JButton subbtn = (JButton) subobj;
					subbtn.setBackground(new Color(135, 206, 235));
					e.setSource(subbtn);
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
			
		}
		catch (Exception ex)
		{
			
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

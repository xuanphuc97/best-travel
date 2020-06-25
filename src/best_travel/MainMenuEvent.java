package best_travel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class MainMenuEvent implements MouseListener
{
	UIMainMenu obj; 
	public MainMenuEvent(UIMainMenu obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj; 
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		/*
		 * get source of the clicked-object
		 */
		Object subobj = me.getSource(); 
		String Text = null; 
		try {
			JLabel sublb = (JLabel)subobj; 
			Text = sublb.getText(); 
		}
		catch (Exception ex) {
			try 
			{
				JButton subbtn = (JButton) subobj;
				Text = subbtn.getActionCommand();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
			}
			
		}
		/*
		 * button Start: Open UI Start and dispose UI Main Menu Frame
		 */
		if (Text == "START") {
			new UIStart(); 
			obj.dispose();
		}
        /*
         * button History: Open UI History and dispose UI Main Menu Frame
         */
		if (Text == "HISTORY")
		{
			new UIHistory(); 
			obj.dispose();
		}
		/*
		 * button Exit: Show the prompt when clicked 
		 * if user chooses yes -> close the app
		 * if user chooses no -> do nothing
		 */
		if (Text == "EXIT")
		{
			String ObjButtons[] = {"Yes","No"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Best Travel",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	        if(PromptResult==JOptionPane.YES_OPTION)
	        {
	            System.exit(0);
	        }
		}
		/*
		 * Label About us: Show information of the development team
		 */
		if (Text == "About us") {
			new AboutUs();
		}
		
	}

	@Override
	/*
	 *  When the cursor enter an object, it will change into hand_cursor
	 *  if this object is a label, its text's color will change into red
	 *  if this object is a button, its background color will change into light blue
	 */
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		try {
			obj.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Object subobj = me.getSource(); 
			try {
				JLabel sublb = (JLabel)subobj; 
				sublb.setForeground(Color.red);
				me.setSource(sublb);
			}
			catch (Exception e){
				try 
				{
					JButton subbtn = (JButton) subobj;
					subbtn.setBackground(new Color(100, 149, 237));
					me.setSource(subbtn);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		}
		catch (Exception e)
		{
			
		}
	}
	/*
	 * when the cursor move out from an object, they will return to normal appearance 
	 */
	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		Object subobj = me.getSource();
		try {
			obj.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			try{
				JLabel sublb = (JLabel)subobj; 
				sublb.setForeground(Color.black);
				me.setSource(sublb);
			}
			catch (Exception e) {
				try 
				{
					JButton subbtn = (JButton) subobj;
					subbtn.setBackground(new Color(135, 206, 235));
					me.setSource(subbtn);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
			
		}
		catch (Exception e)
		{
			
		}
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
	
}
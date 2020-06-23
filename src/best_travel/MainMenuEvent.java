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
		
		if (Text == "START") {
			new UIStart(); 
			obj.dispose();
		}
		
		if (Text == "HISTORY")
		{
			new UIHistory(); 
			obj.dispose();
		}
		if (Text == "EXIT")
		{
			System.exit(0);
		}
		
		if (Text == "About us") {
			new AboutUs();
		}
		
	}

	@Override
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
					subbtn.setBackground(Color.blue);
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
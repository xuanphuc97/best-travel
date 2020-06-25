package best_travel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class StartEvent implements ActionListener, MouseListener, KeyListener{
	UIStart obj; 
	String[] strlist; 
	List<Integer> list = new ArrayList<Integer>(); 
	int k, t; 
	public StartEvent(UIStart obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj; 
	}
	/*
	 * button browse, get directory of input file 
	 */
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
				if (obj.taStandard.getText().equals("type something here...")) obj.taStandard.setText("");
			} catch (Exception e1) {
				//JOptionPane.showMessageDialog(null, e1.toString());
			}
			
		}
		/*
		 * label 'back to main menu'
		 * when clicked, close ui start, open ui main menu 
		 */
		
		if (Text == "back to main menu") {
			new UIMainMenu(); 
			obj.dispose();
		}
		/*
		 * label 'go to history'
		 * when clicked, show ui history
		 * close ui start
		 */
		if (Text == "go to history")
		{
			new UIHistory(); 
			obj.dispose();
		}
		/*
		 * label 'reset' 
		 * when clicked, reset all of the components
		 */
		if (Text== "reset")
		{
			obj.taStandard.setText("type something here...");
			obj.tfDirectory.setText("Directory...");
			obj.tfCityNum.setText("");
			obj.tfDistance.setText("");
			obj.tfRes.setText("");
		}
		/*
		 * calculate the sum of distances
		 * save the data to the database
		 */
		if (Text == "click to see result")
		{
			/*
			 * Process and calculate the sum of distances
			 */
			String defaut1Text = "type something here..."; 
			String defaultText2 = "Directory..."; 
			if (obj.taStandard.getText().trim().equals("")||obj.taStandard.getText().trim().equals(defaut1Text)) {
				if (obj.tfDirectory.getText().equals(defaultText2))
				{
					JOptionPane.showMessageDialog(null, "You have not inserted your list yet!!!\n Please insert your list.");
					return; 
				}
			}
			/*
			 *  check if user insert the list by file or standard way 
			 *  case1: by standard way
			 */
			if (obj.tfDirectory.getText().equals(defaultText2)) {
				try {
					list.clear();
					strlist = obj.taStandard.getText().trim().split("\\s+"); 
					for (int i=0; i<strlist.length; i++) {
						list.add(Integer.parseInt(strlist[i].trim())); 
					}
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Invalid Input! \n Please re-type the list or insert file of list\n Note: Every number must be separated by a space");
					return; 
				}
			}
			/*
			 * case 2: by file
			 */
			else {
				try{
					File fi = new File(obj.tfDirectory.getText()); 
					FileReader fr = new FileReader(fi); 
					BufferedReader br = new BufferedReader(fr);
					
					list.clear();
					String str; 
					while ((str = br.readLine())!=null) {
						strlist = str.trim().split("\\s+"); 
						for (int i=0; i<strlist.length; i++) {
							list.add(Integer.parseInt(strlist[i].trim())); 
						}
					}
					
					br.close();
					fr.close();
						
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid File Input \n Please use another file or edit your file." );
					 return; 
				}
				
			}
			
			if (obj.tfDistance.getText().trim().isEmpty()||obj.tfCityNum.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You have not inserted distance or/and number of cities!!!\n Please try again.");
				return; 
			}
			try {
				t = Integer.parseInt(obj.tfDistance.getText().trim()); 
				k = Integer.parseInt(obj.tfCityNum.getText().trim()); 
				if (t<0||k<0) throw new Exception(); 
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Invalid Input! \n Please try again\n Note: Distance Limitation and Number of Cities must be positive and integer");
				return; 
			}
			if (t==0||k==0) {
				obj.tfRes.setText("The sum does not exist!");
				return; 
			}
			Integer res = Algo.chooseBestSum(t, k, list); 
			if (res == null) obj.tfRes.setText("Not exist!");
			else obj.tfRes.setText(res + "");
			
			/*****************************************************/
			/*****************************************************/
			/*
			 * get all of the input elements and add them to database 
			 */
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now(); 
			String time = dtf.format(now).toString(); 
			String numlist = ""; 
			for (int i=0; i<list.size(); i++)
			{
				String temp = list.get(i)+""; 
				numlist+=temp + " ";  
			}
			try {
				DataBase.addHistory(time, numlist.trim() , k, t, obj.tfRes.getText());
			}
			catch (Exception ex) {
				// TODO: handle exception
			}
			
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
					subbtn.setBackground(new Color(100, 149, 237));
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
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (obj.taStandard.getText().equals("type something here...")) obj.taStandard.setText("");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

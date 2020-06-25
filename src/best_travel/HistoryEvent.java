package best_travel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryEvent implements ActionListener, MouseListener{
	UIHistory obj; 
	UIStart frameStart; 
	//public int selectedRowInd; 
	public HistoryEvent(UIHistory obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * button Delete/Delete function 
		 */
		if (e.getActionCommand().equals("Delete"))
			try { 
				if (obj.tbHistory.getSelectedRowCount()!=1) {
					JOptionPane.showMessageDialog(null, "Please select one row"); 
					return; 
				}
				DefaultTableModel model = (DefaultTableModel)obj.tbHistory.getModel(); 
				int selectedRowInd = obj.tbHistory.getSelectedRow();
				selectedRowInd = obj.tbHistory.convertRowIndexToModel(selectedRowInd); 
				int id = Integer.parseInt(model.getValueAt(selectedRowInd, 0).toString()); 
				int confirm = JOptionPane.showConfirmDialog(null, "Delete this record?", "Delete record", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirm ==0 ) {
					DataBase.delHistory(id);
					obj.setdatatable();
					JOptionPane.showMessageDialog(null, "Deleted");
				}
			
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		
		/*
		 * button Delete All/ Delete All History function 
		 */
		else if (e.getActionCommand().equals("Delete All"))
			try {
				int confirm = JOptionPane.showConfirmDialog(null, "Delete all of the records?", "Delete all", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirm == 0) {
					DataBase.delAllHistory();
					obj.setdatatable();
					JOptionPane.showMessageDialog(null, "Deleted all!");
				}
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		
		/*
		 * Button back/ Back to main menu 
		 */
		else if (e.getActionCommand().equals("Back"))
			try {
				new UIMainMenu(); 
				obj.dispose();
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex.toString());
			}
	}
	
	/*
	 * Set edit function
	 * When the row is double-clicked, open Frame Start so user can edit the input to make another run 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object subObject = e.getSource(); 
		try {
			JTable meTable = (JTable)subObject; 
			DefaultTableModel model = (DefaultTableModel)meTable.getModel(); 
			int selectedRowInd = meTable.getSelectedRow(); 
			selectedRowInd = meTable.convertRowIndexToModel(selectedRowInd); 
			
			if (e.getClickCount() ==2 && meTable.getSelectedRow()!=-1) {
				frameStart = new UIStart(); 
				frameStart.taStandard.setText("");
				frameStart.taStandard.append(model.getValueAt(selectedRowInd, 2).toString());
				frameStart.tfCityNum.setText(model.getValueAt(selectedRowInd, 3).toString());
				frameStart.tfDistance.setText(model.getValueAt(selectedRowInd, 4).toString());
				obj.dispose();
			}
			
		}
		catch (Exception ex){
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		obj.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Object subobj = e.getSource(); 
		try {
			JButton subBtn = (JButton)subobj; 
			//subBtn.setForeground(Color.red);
			subBtn.setBackground(new Color(100, 149, 237));
			e.setSource(subBtn);
		} catch (Exception ex) {
			
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		obj.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Object subobj = e.getSource(); 
		try {
			JButton subBtn = (JButton)subobj; 
			//subBtn.setForeground(Color.black);
			subBtn.setBackground(new Color(135, 206, 235));
			e.setSource(subBtn);
		} catch (Exception ex) {
			
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

package best_travel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UIHistory extends JFrame{
	/*
	 *  make the table not editable
	 */
	public static JTable tbHistory = new JTable() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	JButton btnDel, btnDelAll, btnBack; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UIHistory(); 
	}
	public UIHistory() {
		// TODO Auto-generated constructor stub
		this.setSize(1000, 600);
		this.setTitle("History");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().setLayout(new BorderLayout(10, 10)); /* BorderLayout */ 
		/*
		 * set icon for the frame
		 */
		Image icon = (new ImageIcon("Images/icon.png")).getImage(); 
		this.setIconImage(icon);
		
		/*
		 * create label for the frame 
		 */
		JLabel lbTitle = new JLabel("HISTORY", JLabel.CENTER); 
		lbTitle.setFont(new Font("UD Digi Kyokasho NP-B", Font.BOLD, 30));
		lbTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		lbTitle.setForeground(Color.red);
		
		this.add(lbTitle, BorderLayout.NORTH); 
		
		
		/*
		 * create table to display users' history
		 */
		JPanel pnProc = new JPanel(); 
		pnProc.setLayout(null);
		JScrollPane scTBHistory = new JScrollPane(tbHistory); 
		
		scTBHistory.setBounds(25, 20, 940, 360);
		
		pnProc.add(scTBHistory); 
		/*
		 * buttons to interact with history
		 */
		Font fontbtn = new Font("Segoe UI Black", Font.PLAIN, 20); 
		Color colorbtn = new Color(135, 206, 235); 
		btnDel = new JButton("Delete");
		btnDel.setFont(fontbtn);
		btnDel.setBackground(colorbtn);
		
		btnDelAll = new JButton("Delete All"); 
		btnDelAll.setFont(fontbtn);
		btnDelAll.setBackground(colorbtn);
		
		btnBack = new JButton("Back"); 
		btnBack.setFont(fontbtn);
		btnBack.setBackground(colorbtn);
		
		btnDel.setBounds(25, 410, 200, 50);
		btnDelAll.setBounds(280, 410, 200, 50);
		btnBack.setBounds(865, 410, 100, 50);
		
		pnProc.add(btnDel); 
		pnProc.add(btnDelAll); 
		pnProc.add(btnBack); 
		
		setdatatable();
		this.add(pnProc, BorderLayout.CENTER); 
		
		/*
		 * add events 
		 */
		HistoryEvent obj = new HistoryEvent(this); 
		btnDel.addActionListener(obj);
		btnDelAll.addActionListener(obj);
		btnBack.addActionListener(obj);
		tbHistory.addMouseListener(obj);
		btnDel.addMouseListener(obj);
		btnDelAll.addMouseListener(obj);
		btnBack.addMouseListener(obj);
		this.setVisible(true);	
		
	}
	
	/*
	 * adjust the size of the table 
	 */
	public static void edittable() {
		tbHistory.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
		tbHistory.setFont(new Font("Arial", Font.PLAIN, 15));
	//	tbHistory.getTableHeader().setPreferredSize(new Dimension(100, 30));
		tbHistory.setRowHeight(30);
		tbHistory.getColumnModel().getColumn(0).setMaxWidth(50);
		tbHistory.getColumnModel().getColumn(1).setMaxWidth(200);
		tbHistory.getColumnModel().getColumn(2).setMaxWidth(200);
		tbHistory.getColumnModel().getColumn(3).setMaxWidth(180);
		tbHistory.getColumnModel().getColumn(4).setMaxWidth(200);
		tbHistory.getColumnModel().getColumn(5).setMaxWidth(120);
	}
	
	/*
	 * add data into the table using database
	 */
	public static void setdatatable() {
		String[] data = {"ID", "Time", "List of data", "Number of cities", "Distance Limitation", "Output"};
		DefaultTableModel model = new DefaultTableModel(data,0); 
		tbHistory.setModel(model);
		
		try {
			ResultSet rs = DataBase.getAllHistory();
			while (rs.next())
			{
				model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
			edittable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}

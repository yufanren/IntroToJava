import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;


public class JDBCInterface extends JFrame {

	private JPanel controlPanel;
	private JTextArea textQueryArea;
	private JTextField lastNameQuery, lnField, fnField, agField, ctField;
	private JButton queryButton, insertButton;
	
	private Connection conn;
	private PreparedStatement queryStmtLastName, queryStmtAll, queryStmtInsert;
	private List<JTextField> insertList;
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 500;
	final int AREA_ROWS = 20;
	final int AREA_COLUMNS = 40;
   
   public JDBCInterface() {

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:assignment.db");
			queryStmtLastName = conn.prepareStatement("Select * from People WHERE Last = ?");
			queryStmtAll = conn.prepareStatement("Select * from People;");
			queryStmtInsert = conn.prepareStatement("Insert into People (Last, First, Age, City) values (?, ?, ?, ?);");
			
		} catch (SQLException e) {
			System.err.println("Connection error: " + e);
			System.exit(1);
		}
		
	   createControlPanel();
	   queryButton.addActionListener(new QueryButtonListener());

	   textQueryArea = new JTextArea(
	            AREA_ROWS, AREA_COLUMNS);
	   textQueryArea.setEditable(false);
	   
	   /* scrollPanel is optional */
	   JScrollPane scrollPane = new JScrollPane(textQueryArea);
	   JPanel textPanel = new JPanel();
	   textPanel.add(scrollPane);
	   this.add(textPanel, BorderLayout.CENTER);
	   this.add(controlPanel, BorderLayout.NORTH);

	   insertList = List.of(lnField, fnField, agField, ctField);
   }
   
   private JPanel createControlPanel() {
	   
	   /* you are going to have to create a much more fully-featured layout */
	   
	   controlPanel = new JPanel();
	   controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
	   
	   JPanel inputPanel = new JPanel();
	   JLabel lbl = new JLabel("Last Name:");
	   inputPanel.add(lbl);
	   lastNameQuery = new JTextField(10);
	   inputPanel.add(lastNameQuery);
	   
	   JPanel buttonPanel = new JPanel();
	   queryButton = new JButton("Execute Query");
	   buttonPanel.add(queryButton);

	   JPanel originalControlPanel = new JPanel(new GridLayout(1, 2));
	   originalControlPanel.add(inputPanel);
	   originalControlPanel.add(buttonPanel);

		 controlPanel.add(createExtraPanel());
	   controlPanel.add(originalControlPanel);
	   
	   return controlPanel;

   }

   private JPanel createExtraPanel() {

   	JPanel extraPanel = new JPanel(new GridLayout(3, 2));

   	JPanel lastnamePanel = new JPanel();
   	JLabel lnLabel = new JLabel("Last Name:");
   	lastnamePanel.add(lnLabel);
   	lnField = new JTextField(10);
   	lastnamePanel.add(lnField);
   	extraPanel.add(lastnamePanel);

   	JPanel firstnamePanel = new JPanel();
   	JLabel fnLabel = new JLabel("First Name:");
   	firstnamePanel.add(fnLabel);
   	fnField = new JTextField(10);
   	firstnamePanel.add(fnField);
   	extraPanel.add(firstnamePanel);

   	JPanel agePanel = new JPanel();
   	JLabel agLabel = new JLabel("Age:");
   	agePanel.add(agLabel);
   	agField = new JTextField(4);
   	agePanel.add(agField);
   	extraPanel.add(agePanel);

   	JPanel cityPanel = new JPanel();
   	JLabel ctLabel = new JLabel("City:");
   	cityPanel.add(ctLabel);
   	ctField = new JTextField(10);
   	cityPanel.add(ctField);
   	extraPanel.add(cityPanel);

   	JPanel buttonPanel = new JPanel();
   	insertButton = new JButton("Insert");
   	buttonPanel.add(insertButton);
		extraPanel.add(buttonPanel);
		insertButton.addActionListener(new InsertButtonListener());

   	return extraPanel;
	 }
   
   class InsertButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event) {
		   /* You will have to implement this */
			 if (findEmptyField(insertList)) {
			 	JOptionPane.showMessageDialog(null, "All Fields must be filled!");
			 } else {
				 try {
					 PreparedStatement stmt = queryStmtInsert;
					 stmt.setString(1, lnField.getText().trim());
					 stmt.setString(2, fnField.getText().trim());
					 stmt.setInt(3, Integer.parseInt(agField.getText().trim()));
					 stmt.setString(4, ctField.getText().trim());
					 stmt.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Update successful");
				 } catch (SQLException se) {
					 se.printStackTrace();
				 } catch (NumberFormatException ne) {
					 JOptionPane.showMessageDialog(null, "Invalid age, please enter a number!");
				 }
			 }
			 for (JTextField f : insertList)
			 	f.setText(null);
	   }
   }
   
   class QueryButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event)
       {
		   /* as far as the columns, it is totally acceptable to
		    * get all of the column data ahead of time, so you only
		    * have to do it once, and just reprint the string
		    * in the text area.
		    */
		   
		   /* you want to change things here so that if the text of the 
		    * last name query field is empty, it should query for all rows.
		    * 
		    * For now, if the last name query field is blank, it will execute:
		    * SELECT * FROM People WHERE Last=''
		    * which will give no results
		    */
				 PreparedStatement stmt;
		   try {
			   textQueryArea.setText("");
			   if (isEmpty(lastNameQuery)) {
			   	stmt = queryStmtAll;
				 } else {
			   	stmt = queryStmtLastName;
					 String lastNameText = lastNameQuery.getText();
					 stmt.setString(1, lastNameText);
				 }
			   ResultSet rset = stmt.executeQuery();

				ResultSetMetaData rsmd = rset.getMetaData();
				int numColumns = rsmd.getColumnCount();
				System.out.println("numcolumns is "+ numColumns);
	
				String rowString = "";
				for (int i = 1; i <=numColumns; i++) {
					String s = rsmd.getColumnName(i);
					rowString += s + "\t";
				}
				textQueryArea.setText(rowString + "\n");
				while (rset.next()) {
					rowString = "";
					for (int i=1;i<=numColumns;i++) {
						Object o = rset.getObject(i);
						rowString += o.toString() + "\t";
					}
					rowString += "\n";
					textQueryArea.append(rowString);
				}
				System.out.print("rowString  is  " + rowString);

		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
       }
   }

   private static boolean isEmpty(JTextField f) {
   	return f.getText() == null || f.getText().trim().isEmpty();
	 }

   private static boolean findEmptyField(List<JTextField> list) {
   		for (JTextField f : list) {
				if (isEmpty(f))
					return true;
			}
   		return false;
	 }
    
   public static void main(String[] args)
	{  
	   JFrame frame = new JDBCInterface();
	   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);      
	}
}

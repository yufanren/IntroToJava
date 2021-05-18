import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel;
	WordList wordList;
	JList list;
	private JTextArea wordsBox;
	private JTextField inputField;

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(500, 300);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 180);
		panelForTextFields.setLayout(new GridLayout(1, 1));
		add(panelForTextFields, BorderLayout.CENTER);

		createMenus();

		topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);

		JLabel findLabel = new JLabel("Find:");
		topPanel.add(findLabel);

		final int FIELD_WIDTH = 10;
		inputField = new JTextField(FIELD_WIDTH);
		inputField.addCaretListener(new TypingListener());
		topPanel.add(inputField);

		JButton clearButton = createButton();
		topPanel.add(clearButton);

		wordsBox = new JTextArea();
		wordsBox.setEditable(false);
		JScrollPane sPane = new JScrollPane(wordsBox);
		panelForTextFields.add(sPane);
	}
	
	private void createMenus() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}

		JMenuItem item = new JMenuItem("Open");
		ActionListener listener = new OpenActionListener();
		item.addActionListener(listener);
		menu.add(item);
		menu.addSeparator();
		menu.add(createFileExitItem());
		menuBar.add(menu);
	}

	public JMenuItem createFileExitItem()
	{
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	class TypingListener implements CaretListener {

		@Override
		public void caretUpdate(CaretEvent e) {

			WordFinder.this.find();
		}
	}

	public JButton createButton() {
		JButton button = new JButton("Clear");

		class clearButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent event) {

				inputField.setText(null);
				System.out.println("Button clicked");
			}
		}
		ActionListener listener = new clearButtonListener();
		button.addActionListener(listener);
		return button;
	}
	
	public void fillList(List words) {

		wordsBox.setText(null);
		for (Iterator i = words.iterator(); i.hasNext(); ) {
			wordsBox.append(i.next() + "\n");
		}
		wordsBox.setCaretPosition(0);
	}

	private void find(){

		List searchResult = wordList.find(inputField.getText());

		this.fillList(searchResult);

	}
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					List searchResult = wordList.find(inputField.getText());
					WordFinder.this.fillList(searchResult);

				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}

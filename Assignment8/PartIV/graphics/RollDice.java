package graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class RollDice extends JFrame {

	JLabel resultLabel;
	JPanel topPanel;
	JPanel bottomPanel;
	int[] dice; // record what the current dice rolls are, has 2 spots.
	Random rand = new Random();
	ImagePanel[] diceOne; //dices for the left side panel.
	ImagePanel[] diceTwo; //dices for the right side panel.

	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		prepDices();
		setupPanel();
		setSize(450,400);
		setResizable(false);
		setVisible(true);
	}

	/* set up the JFrame panel*/
	private void setupPanel()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));

		topPanel = new JPanel(new FlowLayout());
		mainPanel.add(topPanel);

		bottomPanel = new JPanel(new GridLayout(3, 1));

		JPanel bottomPanel1 = new JPanel(new FlowLayout());
		JPanel bottomPanel2 = new JPanel(new FlowLayout());

		resultLabel = new JLabel("Result: " + Integer.toString(dice[0] + dice[1]));
		bottomPanel1.add(resultLabel);

		JButton rollButton = createRollButton();
		bottomPanel2.add(rollButton);
		bottomPanel.add(new JPanel());
		bottomPanel.add(bottomPanel1);
		bottomPanel.add(bottomPanel2);
		mainPanel.add(bottomPanel);

		refreshFrame();

		this.add(mainPanel);
	}

	public JButton createRollButton()
	{
		JButton button = new JButton("Roll Dice");

		class RollButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {

				dice[0] = rand.nextInt(6) + 1;
				dice[1] = rand.nextInt(6) + 1;

				refreshFrame();
			}
		}
		ActionListener listener = new RollButtonListener();
		button.addActionListener(listener);
		return button;
	}

	/*Create 6 dices/ImagePanel for each of left and right side of the
	top panel and place in 2 arrays. RollDice load the ImagePanel
	corresponding to the dice roll.
	To simplify things, program respond only to mouse pressed.
	 */
	private void prepDices()
	{
		diceOne = new ImagePanel[6];
		diceTwo = new ImagePanel[6];

		class clickRollDiceListener implements MouseListener {
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e)
			{
				ImagePanel clicked = (ImagePanel) e.getSource();
				int dice = clicked.getDiceRoll();
				if (diceOne[dice - 1] == clicked) {
					RollDice.this.dice[0] = rand.nextInt(6) + 1;
				}
				else if (diceTwo[dice - 1] == clicked) {
					RollDice.this.dice[1] = rand.nextInt(6) + 1;
				}
				refreshFrame();
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		}
		clickRollDiceListener listener = new clickRollDiceListener();

		for (int i = 0; i < 6; i++) {
			diceOne[i] = new ImagePanel("PartIV/die" + Integer.toString(i + 1) + ".png", i + 1);
			diceOne[i].addMouseListener(listener);
			diceTwo[i] = new ImagePanel("PartIV/die" + Integer.toString(i + 1) + ".png", i + 1);
			diceTwo[i].addMouseListener(listener);
		}
		dice = new int[2];
		dice[0] = 1;
		dice[1] = 1;
	}

	/*This is the main program for refreshing the frame
	after dices were rolled and dice[] is updated.
	 */
	private void refreshFrame() {
		resultLabel.setText("Result: " + Integer.toString(dice[0] + dice[1]));
		topPanel.removeAll();
		topPanel.add(diceOne[dice[0] - 1]);
		topPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		topPanel.add(diceTwo[dice[1] - 1]);
		topPanel.revalidate();
		topPanel.repaint();
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	}
}

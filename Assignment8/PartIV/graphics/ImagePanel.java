package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.*;

public class ImagePanel extends JPanel {
	private final Image img;
	private int diceRoll;
	
	public ImagePanel(String img, int dice) {
		this(new ImageIcon(img).getImage());
		diceRoll = dice;
	}
	
	public ImagePanel(Image img) {
		this.img = img;
        Dimension size = new Dimension(img.getWidth(null) , img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public int getDiceRoll() {
		return diceRoll;
	}
}

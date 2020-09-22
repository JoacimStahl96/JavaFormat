package JavaFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class NegativeImage extends JComponent {

	private BufferedImage negativeImage;
	

	public NegativeImage(BufferedImage myImage) {
		this.negativeImage=myImage;
	}

	public Dimension getPreferredSize() {
		if (negativeImage == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(negativeImage.getWidth(null), negativeImage.getHeight(null));
		}
	} 

	public BufferedImage MakeNegativeImage() {
		
		// changes the color of every single pixel in the picture to it's negative form
		for (int x = 0; x < negativeImage.getWidth(); x++) {
			for (int y = 0; y < negativeImage.getHeight(); y++) {
				int rgba = negativeImage.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
				negativeImage.setRGB(x, y, col.getRGB());
			}
		}
		return this.negativeImage;
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(negativeImage, 0, 0, getWidth(), getHeight(), null);
	}

}

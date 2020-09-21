package JavaFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class NegativeImage extends JComponent {

	private BufferedImage negativeImage;
	

	public Dimension getPreferredSize() {
		if (negativeImage == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(negativeImage.getWidth(null), negativeImage.getHeight(null));
		}
	} 

	public BufferedImage NegativeImage(BufferedImage nImage) {
		this.negativeImage = nImage;
	/*	try {
			nImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException i) {

		}  */
		// changes the color of every single pixel in the picture to it's negative form
		for (int x = 0; x < nImage.getWidth(); x++) {
			for (int y = 0; y < nImage.getHeight(); y++) {
				int rgba = nImage.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
				nImage.setRGB(x, y, col.getRGB());
			}
		}
		return nImage;
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(negativeImage, 0, 0, getWidth(), getHeight(), null);
	}

}

package JavaFormat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class Mirror extends JComponent { // haven't begun this function yet
	
	private Image image;
	
	
    public Mirror(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}



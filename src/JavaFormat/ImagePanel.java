package JavaFormat;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class ImagePanel extends JComponent{
	
	private Image image;

    public ImagePanel(Image picture) {
    	this.image = picture;
    }
    public Dimension getPreferredSize() {
        if (image == null) {
             return new Dimension(600,400);
        } else {
           return new Dimension(image.getWidth(null), image.getHeight(null));
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(),getHeight(), null);
    }
    
	

}

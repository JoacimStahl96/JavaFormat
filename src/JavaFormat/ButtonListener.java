package JavaFormat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ButtonListener implements ActionListener {
	
	private BufferedImage negativeImage;
	private ImagePanel image;
	
	
	NegativeImage m = new NegativeImage(negativeImage);
    

	public ButtonListener(NegativeImage negatImage, BufferedImage myImage) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  
	  System.out.println("hii");
	  
	  image =  new ImagePanel(m.MakeNegativeImage());
	  
	  
    }	
	
}
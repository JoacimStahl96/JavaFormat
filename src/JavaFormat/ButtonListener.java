package JavaFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ButtonListener implements ActionListener {
	
	static BufferedImage negativeImage;
	
	NegativeImage image = new NegativeImage();
	
		
	public ButtonListener(NegativeImage image) {
		try {
			negativeImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		} catch (IOException i) {

		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		
     }
}

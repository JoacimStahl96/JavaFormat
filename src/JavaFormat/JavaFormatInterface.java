package JavaFormat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class JavaFormatInterface implements Runnable {

	private JFrame frame;
	
	 
	@Override
	public void run() {
		BufferedImage myImage = null;
		try {                
		        myImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		          
		       } catch (IOException ex) {
		            // handle exception...
		    	   
		       }
		
		frame = new JFrame("JavaFormat picture changer");
		
		frame.setPreferredSize(new Dimension(600, 400));

		
		frame.setContentPane(new ImagePanel(myImage)); // background image

		try {
			createInterface(frame.getContentPane());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//	frame.setContentPane(new NegativeImage()); the modified image, only here to check if it actually works.
 
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void createInterface(Container c) throws IOException {

		BorderLayout layout = new BorderLayout();
		c.setLayout(layout);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		

		JToolBar toolBar = new JToolBar();
		toolBar.addSeparator(new Dimension(50, 0));
		toolBar.setForeground(SystemColor.textHighlight);
		toolBar.setBackground(UIManager.getColor("Button.highlight"));
		toolBar.setBackground(Color.GRAY);
		

		JButton BlacknWhite = new JButton("Black / White");
		BlacknWhite.setBackground(Color.LIGHT_GRAY);
		BlacknWhite.setForeground(Color.WHITE);
		toolBar.add(BlacknWhite);
		toolBar.addSeparator(new Dimension(50, 0));

	//	BufferedImage nImage = ImageIO.read(new File("JavaFormatHaloReach.jpg")); 
		JButton negativeButton = new JButton("Negative");
		ButtonListener negative = new ButtonListener(null);
		negativeButton.addActionListener(negative);
		
		negativeButton.setBackground(Color.LIGHT_GRAY);
		negativeButton.setForeground(Color.WHITE);
		toolBar.add(negativeButton);
		toolBar.addSeparator(new Dimension(50, 0));

		JButton changeSize = new JButton("Change size ");
		changeSize.setBackground(Color.LIGHT_GRAY);
		changeSize.setForeground(Color.WHITE);
		toolBar.add(changeSize);
		toolBar.addSeparator(new Dimension(50, 0));

		JButton reset = new JButton("Reset");
		reset.setBackground(Color.LIGHT_GRAY);
		reset.setForeground(Color.WHITE);
		toolBar.add(reset);
	
		c.add(toolBar, BorderLayout.NORTH);
	}

	public JFrame getjFrame() {
		return frame;
	}

}

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

public class JavaFormatInterface implements Runnable  {

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

		NegativeImage negImg = new NegativeImage(myImage);
	
	//	frame.setContentPane(new ImagePanel(negImg.MakeNegativeImage()));  // the modified image	
		
		frame.setContentPane(new ImagePanel(myImage)); // background image - this shall be fixed after NegativeImage is okay, 1 problem at a time.
		
		createInterface(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}


	private  void createInterface(Container c) { // menu and buttons are created here and actionlistener is connected here as well.
		
		BufferedImage myImage = null;
		try {                
		        myImage = ImageIO.read(new File("JavaFormatHaloReach.jpg"));
		          
		       } catch (IOException ex) {
		              
		       }
		
		NegativeImage negatImage = new NegativeImage(myImage);
		ImagePanel image = new ImagePanel ( myImage);
		image = new ImagePanel(negatImage.MakeNegativeImage());

		BorderLayout layout = new BorderLayout();
		c.setLayout(layout);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		

		JToolBar toolBar = new JToolBar();
		toolBar.addSeparator(new Dimension(50, 0));
		toolBar.setForeground(SystemColor.textHighlight);
		toolBar.setBackground(UIManager.getColor("Button.highlight"));
		toolBar.setBackground(Color.GRAY);
		

		JButton rotate = new JButton("Rotate");
		rotate.setBackground(Color.LIGHT_GRAY);
		rotate.setForeground(Color.WHITE);
		toolBar.add(rotate);
		toolBar.addSeparator(new Dimension(50, 0));
		
		
		JButton negativeButton = new JButton("Negative");
		ButtonListener negative = new ButtonListener(negatImage, myImage);
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
	//	c.add(negatImage);
		
	}

	public JFrame getjFrame() {
		return frame;
	}

}

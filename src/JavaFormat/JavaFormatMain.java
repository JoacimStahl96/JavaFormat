package JavaFormat;

import java.awt.Component;

import javax.swing.SwingUtilities;

public class JavaFormatMain extends Component {

	public static void main(String[] args) {
		
		
		JavaFormatInterface ui = new JavaFormatInterface();
		SwingUtilities.invokeLater(ui);
		
		 

	}

}

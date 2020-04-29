import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		Gameplay g = new Gameplay();
		g.constructMap();

		Mainframe frame = new Mainframe();
		JPanel Blockpanel = new JPanel();
		Blockpanel.setLayout(new GridLayout(8,10));
		for(int i = 0; i < 80; i++) {
			Blockpanel.add(g.getMap()[i/10][i%10]);
		}
		frame.add(Blockpanel,BorderLayout.CENTER);
		
		
		
		
					
	}

}

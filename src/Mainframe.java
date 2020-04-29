import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Mainframe extends JFrame{
	Mainframe(){
		this.setTitle("MineSweeper");
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

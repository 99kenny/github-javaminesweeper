
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Blockchange extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {  //right click(���)
			
			Block b = (Block)e.getSource();	//����� �ȳ���
			b.setFlag();
			
		}
		else {										//left click
			Block b = (Block)e.getSource();
			
		
			if(b.getfirstrclick() == true) {		//ù Ŭ���� ������ 0�� ���� Ŭ���ϵ��� ����
				b.setfirstclick();
				Gameplay.gameStart(b.getI(),b.getJ(),10);
				Gameplay.discoverBlock(b.getI(), b.getJ());
			}
			else {
				if(b.getNum() == 0) {
					Gameplay.discoverBlock(b.getI(), b.getJ());
				}
				else {
					b.showNum();
					if(Block.isgameover == true) {
						JFrame gameover = new JFrame("MineSweeper");
						
						gameover.setSize(250,250);
						Container c = gameover.getContentPane();
						c.setLayout(new BorderLayout());
						c.add(new JLabel("Game Over!",SwingConstants.CENTER),BorderLayout.CENTER);
						gameover.setVisible(true);
					}
				}
				
			}
	
			
		}
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

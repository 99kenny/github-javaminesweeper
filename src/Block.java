
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Block extends JButton{
	private int i,j,num;			//ÁÂÇ¥¿Í Áö·Ú Á¤º¸
	private boolean flag = false;			//±ê¹ß ÂïÇôÀÖ´ÂÁö 
	private boolean isopen = false; 		//ÀÌ¹Ì ¿ÀÇÂÇß´ÂÁö
	private static boolean isfirstclick = true;
	static boolean isgameover = false;
	public Block(int i, int j, int num){
		this.i = i;
		this.j = j;
		this.num = num;
	}
	
	public int getI() {
		return this.i;
	}
	public int getJ() {
		return this.j;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		if(this.i < 0 || this.i > 7 || this.j < 0 || this.j > 9) {
		}
		else {
			this.num = num;
		}
	}
	void setFlag(){
	
		if(this.flag == false) {
			if(this.isopen == false) {
				this.setIcon(new ImageIcon("flag.jpg"));
				this.flag = true;
			}
		}
		else {
			if(this.isopen == false) {
				this.setIcon(new ImageIcon("q.jpg"));
				this.flag = false;
			}
		}
	}

	void showNum() {
		if(this.num == 9) {
			this.setIcon(new ImageIcon("mine.png"));
			this.isopen = true;
			isgameover = true;
		}
		else if(this.num == 1) {
			this.setIcon(new ImageIcon("num1.jpg"));
			this.isopen = true;
		}
		else if(this.num == 2) {
			this.setIcon(new ImageIcon("num2.jpg"));
			this.isopen = true;
		}
		else if(this.num == 3) {
			this.setIcon(new ImageIcon("num3.jpg"));
			this.isopen = true;
		}
		else if(this.num == 4) {
			this.setIcon(new ImageIcon("num4.jpg"));
			this.isopen = true;
		}
		else if(this.num == 5) {
			this.setIcon(new ImageIcon("num5.jpg"));
			this.isopen = true;
		}
		else if(this.num == 6) {
			this.setIcon(new ImageIcon("num6.jpg"));
			this.isopen = true;
		}
		else if(this.num == 7) {
			this.setIcon(new ImageIcon("num7.jpg"));
			this.isopen = true;
		}
		else if(this.num == 8) {
			this.setIcon(new ImageIcon("num8.jpg"));
			this.isopen = true;
		}
		else if(this.num == 0) {
			this.setIcon(new ImageIcon("num0.jpg"));
			this.isopen = true;
		}
		
		
	}
	
	boolean isMine(Block b) {
		if(b.getNum() == 9) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean getfirstrclick() {
		return isfirstclick;
	}
	void setfirstclick() {
		 isfirstclick = false;
	}
	boolean getIsopen() {
		return this.isopen;
	}
}

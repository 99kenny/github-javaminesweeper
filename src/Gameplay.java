import java.util.Vector;

public class Gameplay {
	boolean gameover = false;
	private int minenum;
	private static Block[][] map = new Block[8][10];

	
	void constructMap() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 10; j++) {
				map[i][j] = new Block(i,j,0);						//맵의 모든 칸 0으로 초기화
				map[i][j].addMouseListener(new Blockchange());
			}
		}
	}
	static void gameStart(int a, int b, int minenum) {
		
		while(minenum > 0) {
			int minespot = (int)(Math.random()*80);
			if((map[minespot/10][minespot%10].getNum() != 9) && !(minespot/10 >= a-1 && minespot/10 <= a +1 && minespot%10 >= b-1 && minespot%10 <= b+1) ) {
				(map[minespot/10][minespot%10]).setNum(9);
				minenum--;
				continue;
			}
		}
		
		for(int i = 0; i < 80; i++) {
			int x = i / 10;
			int y = i % 10;
			int cnt = 0;
			if(map[x][y].getNum() == 0) {
				if(mineCheck(x-1,y-1)) {
					cnt++;
				}
				if(mineCheck(x-1,y)) {
					cnt++;
				}
				if(mineCheck(x-1,y+1)) {
					cnt++;
				}
				if(mineCheck(x,y-1)) {
					cnt++;
				}
				if(mineCheck(x,y+1)) {
					cnt++;
				}
				if(mineCheck(x+1,y-1)) {
					cnt++;
				}
				if(mineCheck(x+1,y)) {
					cnt++;
				}
				if(mineCheck(x+1,y+1)) {
					cnt++;
				}
				map[x][y].setNum(cnt);
			}
			
		}
		showMap();
	}
	
	
		 /*
		int[][] map = new int[8][10];
		
		this.map = map;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 10;j++) {
				this.map[i][j] = 0;
			}
		}
		
		for(int i = 0; i < minenum; i++) {
			int minespot = (int)(Math.random()*80);
			this.map[minespot/10][minespot%10] = 9; 			//mine
		}
		
		for(int i = 0; i < 80; i++) {
			int x = i / 10;
			int y = i % 10;
			int cnt = 0;
			if(this.map[x][y] == 0) {
				if(mineCheck(x-1,y-1)) {
					cnt++;
				}
				if(mineCheck(x-1,y)) {
					cnt++;
				}
				if(mineCheck(x-1,y+1)) {
					cnt++;
				}
				if(mineCheck(x,y-1)) {
					cnt++;
				}
				if(mineCheck(x,y+1)) {
					cnt++;
				}
				if(mineCheck(x+1,y-1)) {
					cnt++;
				}
				if(mineCheck(x+1,y)) {
					cnt++;
				}
				if(mineCheck(x+1,y+1)) {
					cnt++;
				}
				this.map[x][y] = cnt;
			}
			
		}
		
	}
	*/
	
	//임시
	static void showMap() {
		for(int i = 0; i < 8; i++) {
			System.out.print("|");
			for(int j = 0; j < 10; j++) {
				System.out.print(map[i][j].getNum()+"|");
			}
			System.out.println();
		}
	}

	static boolean mineCheck(int x, int y) {
		if(x < 0 || x > 7 || y < 0 || y > 9) {
			return false;
		}
		else if(map[x][y].getNum() == 9) {
			return true;
		}
		else {
			return false;
		}
	}

	Block[][] getMap() {
		return this.map;
	}
	
	static void editBlock(int i, int j, int n) {
		if(i - 1 < 0 || i + 1 > 8 || j - 1< 0 || j + 1> 10) {	}
		
		else {
			if(map[i-1][j-1].getNum() != 9) {
				map[i-1][j-1].setNum(map[i][j].getNum() + n);
			}
			if(map[i-1][j].getNum() != 9) {
				map[i-1][j].setNum(map[i][j].getNum() + n);
			}
			if(map[i-1][j+1].getNum() != 9) {
				map[i-1][j+1].setNum(map[i][j].getNum() + n);
			}
			if(map[i][j-1].getNum() != 9) {
				map[i][j-1].setNum(map[i][j].getNum() + n);
			}
			if(map[i][j+1].getNum() != 9) {
				map[i][j+1].setNum(map[i][j].getNum() + n);
			}
			if(map[i-1][j-1].getNum() != 9) {
				map[i-1][j-1].setNum(map[i][j].getNum() + n);
			}
			if(map[i+1][j].getNum() != 9) {
				map[i+1][j].setNum(map[i][j].getNum() + n);
			}
			if(map[i-1][j-1].getNum() != 9) {
				map[i-1][j-1].setNum(map[i][j].getNum() + n);
			}
		}
	}
	static void mineAdd(int i, int j) {
		map[i][j].setNum(9);
	}
	
	static void discoverBlock(int i, int j) {
		map[i][j].showNum();
		
		if(map[i][j].getNum() != 0) {
			
			return;
		}
		else {
			
			if(i - 1 >= 0 && j - 1 >= 0 && !map[i-1][j-1].getIsopen()) {
				discoverBlock(i-1,j-1);
			}
			if(i - 1 >= 0 && j >= 0 && !map[i-1][j].getIsopen()) {
				discoverBlock(i-1,j);
			}
			if(i - 1 >= 0 && j + 1 < 10 && !map[i-1][j+1].getIsopen()) {
				discoverBlock(i-1,j+1);
			}
			if(i >= 0 && j - 1 >= 0 && !map[i][j-1].getIsopen()) {
				discoverBlock(i,j-1);
			}
			if(i >= 0 && j + 1 < 10 && !map[i][j+1].getIsopen()) {
				discoverBlock(i,j+1);
			}
			if(i + 1 < 8 && j - 1 >= 0 && !map[i+1][j-1].getIsopen()) {
				discoverBlock(i+1,j-1);
			}
			if(i + 1 < 8 && j >= 0 && !map[i+1][j].getIsopen()) {
				discoverBlock(i+1,j);
			}
			if(i + 1 < 8 && j + 1 < 10 && !map[i+1][j+1].getIsopen()) {
				discoverBlock(i+1,j+1);
			}
			
		}
		
		
	}
}	

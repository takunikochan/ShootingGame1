
public class OriginalEnemy extends Enemy{
	public OriginalEnemy(double x,double y,double vx,double vy) 
	{
		super(x,y,vx,vy);
		life=5;
	}

	public void draw(MyFrame f) {
	
		// 頭の色（クリーム色）
		f.setColor(255, 253, 215);  // やさしいクリーム
		f.fillOval(x, y, 30, 30);  // 小さな頭

		// ほっぺ
		f.setColor(255, 170, 180);  // ピンク
		f.fillOval(x + 5, y + 15, 5, 5);  // 左ほっぺ
		f.fillOval(x + 20, y + 15, 5, 5);  // 右ほっぺ

		// 目
		f.setColor(0, 0, 0);  // 黒
		f.fillOval(x + 6, y + 8, 5, 7);  // 左目
		f.fillOval(x + 19, y + 8, 5, 7);  // 右目

		// ハイライト
		f.setColor(255, 255, 255);  // 白
		f.fillOval(x + 7, y + 9, 2, 2);  // 左目ハイライト
		f.fillOval(x + 20, y + 9, 2, 2);  // 右目ハイライト

		// 口
		f.setColor(255, 100, 120);  // うっすら赤
		f.fillOval(x + 12, y + 18, 6, 3);  // 小さい口

		// --- マラカス（左） ---
		f.setColor(255, 130, 0);  // オレンジ
		f.fillOval(x - 7, y - 7, 10, 10); 
		f.fillOval(x, y, 5, 5);    

		// --- マラカス（右） ---
		f.fillOval(x + 29, y - 7, 10, 10);  
		f.fillOval(x + 26, y, 5, 5);  
	}
	
	public void move() {
		super.move();
		if(x<GameWorld.player.x) {
			x++;     //自分がﾌﾟﾚｲﾔｰより左なら右に移動
		}
		if(x>GameWorld.player.y) {
			x--;     //自分がﾌﾟﾚｲﾔｰより右なら左に移動
		}
	}
	

	
}

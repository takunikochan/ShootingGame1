
public class OriginalEnemy extends Enemy{
	public OriginalEnemy(double x,double y,double vx,double vy) 
	{
		super(x,y,vx,vy);
		life=5;
	}

	public void draw(MyFrame f) {
		
		// 頭の色（クリーム色）
		f.setColor(255, 253, 215);  // やさしいクリーム
		f.fillOval(100, 100, 30, 30);  // 小さな頭

		// ほっぺ
		f.setColor(255, 170, 180);  // ピンク
		f.fillOval(105, 115, 5, 5);  // 左ほっぺ
		f.fillOval(120, 115, 5, 5);  // 右ほっぺ

		// 目
		f.setColor(0, 0, 0);  // 黒
		f.fillOval(106, 108, 5, 7);  // 左目
		f.fillOval(119, 108, 5, 7);  // 右目

		// ハイライト
		f.setColor(255, 255, 255);  // 白
		f.fillOval(107, 109, 2, 2);  // 左目ハイライト
		f.fillOval(120, 109, 2, 2);  // 右目ハイライト

		// 口
		f.setColor(255, 100, 120);  // うっすら赤
		f.fillOval(112, 118, 6, 3);  // 小さい口
		
		// --- マラカス（左） ---
		f.setColor(255, 130, 0);  // オレンジ
		f.fillOval(88, 88, 10, 10); 
		f.fillOval(95, 95, 6, 6);    

		// --- マラカス（右） ---
		f.fillOval(132, 88, 10, 10);  
		f.fillOval(129, 95, 6, 6);  

		
	}

	
}

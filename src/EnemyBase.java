
public class EnemyBase extends Enemy{
	public EnemyBase(double x,double y,double vx,double vy) {
	       super(x,y,vx,vy);
	       life=20; //耐久性
	       score=10;	
	}
	
	//UFOデザイン
	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillOval(x, y, 32, 32);
		f.setColor(200, 200, 200);
		f.fillOval(x-16, y+8, 64, 16);
	}
	
	
	public void move() {
		super.move();
		
		//敵が右端に来たら反対方向に移動
		if(x>300) vx=-GameWorld.stage;
		if(x<100) vx=GameWorld.stage;
		
		//敵(直進)を出現
		if(Math.random()<0.06) {
			GameWorld.enemies.add(new StraightEnemy(x,y,0,1+GameWorld.stage));
			
		//敵(ランダム)	
		if(Math.random()<0.3) {
			GameWorld.enemies.add(new RandomEnemy(x,y,0,GameWorld.stage));
		}
		
		//敵(縦に加速)
		if(Math.random()<0.2) {
			GameWorld.enemies.add(new DropEnemy(x,y,0,GameWorld.stage));
		}
		
		//敵(ﾌﾟﾚｲﾔｰに移動)
		if(Math.random()<0.02) {
			GameWorld.enemies.add(new CurveEnemy(x,y,0,GameWorld.stage));
		}
		
		//敵(うーたん)	
		if(Math.random()<0.2) {
			GameWorld.enemies.add(new OriginalEnemy(x,y,0,GameWorld.stage));
		}
		
		}
	}
}

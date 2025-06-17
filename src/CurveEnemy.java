
public class CurveEnemy extends Enemy{
	public CurveEnemy(double x, double y, double vx, double vy) 
	{
		super(x,y,vx,vy);
		life=3;
	}
	
	public void draw(MyFrame f) {
		f.setColor(0, 0, 0);
		f.fillOval(x, y, 30, 30);
		f.setColor(255, 255, 255);
		f.fillOval(x+5, y, 20, 30);
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

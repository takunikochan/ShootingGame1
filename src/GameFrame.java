import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player = new Player(100,300,0,0);
		addKeyListener(GameWorld.player);
		GameWorld.playerBullets = new Vector<PlayerBullet>();
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullets();
			sleep(0.03);
		}
	}
	
	//弾を発射するメゾット
	public void movePlayerBullets() {
		int i=0;
		while (i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			
			//弾の縦座標<0で削除
			if(b.y<0) {
				GameWorld.playerBullets.remove(i);
			}
			else {
				i++;
			}
		}
	}

}

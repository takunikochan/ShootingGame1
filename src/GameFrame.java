import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player = new Player(100,300,0,0);
		addKeyListener(GameWorld.player);
		GameWorld.stage=1;
		GameWorld.score=0;
		
		while(true) 
		{
			GameWorld.player.x=100;
			GameWorld.player.y=300;
		
		GameWorld.playerBullets = new Vector<PlayerBullet>();
		GameWorld.enemies = new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100,50,GameWorld.stage,0));
		GameWorld.enterPressed=false;
			while(true) {
			clear();
			drawString("Stage = "+GameWorld.stage, 300,50,15); //面数表示
			drawString("Score = "+GameWorld.score, 300,80,15); 
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullets();
			moveEnemies();
			checkPlayerAndEnemies();
			checkPlayerBulletsAndEnemies();
			
				//敵が全滅したか？
				if(GameWorld.enemies.size()==0) 
				{
					setColor(0,0,0);
					drawString("クリア！",100,200,40);
					if(GameWorld.enterPressed)
					{
						GameWorld.stage++; //クリアしたら次の画面に進む
						break;
					}
				}
				//ﾌﾟﾚｲﾔｰが消えたか？
				else if(GameWorld.player.y<0)
				{
					setColor(0,0,0);
					drawString("ゲームオーバー",50,200,40);
					if(GameWorld.enterPressed)
					{
						GameWorld.stage=1;//ゲームオーバーになったら1面に戻る
						GameWorld.score=0;
						break;
					}
				}
				sleep(0.03);
				}
	    }
	}
	
	//敵を動かす
	public void moveEnemies() {
		for(int i=0 ; i<GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
		//画面外の敵を消す
		int i=0;
		while(i<GameWorld.enemies.size()) {
			Enemy e=GameWorld.enemies.get(i);
			if(e.y>400) 
			{
				GameWorld.enemies.remove(i);
			}
			else 
			{
				i++;
			}
		}
	}
	
	//弾を発射する
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
	
	//当たり判定
	public void checkPlayerAndEnemies() {
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			//ﾌﾟﾚｲﾔｰの大きさを定義
			if(checkHit(GameWorld.player,e)) 
			{
				System.out.println("やられた！");
				GameWorld.player.y=-1000;  //消える
			}
		}
	}
	
	//弾と敵の当たり判定
	public void checkPlayerBulletsAndEnemies() {
		int i=0;
		while(i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.enemies.size()) {
				Enemy e=GameWorld.enemies.get(j);
				if(checkHit(e,b)) 
				{
					System.out.println("あたり！");
					hits++;
					e.life--;
				}
				if(e.life<=0) 
				{
					GameWorld.score+=e.score;
					GameWorld.enemies.remove(j);
				}
					else 
					{
						j++;
				    }
				}
			
			if(hits>0) 
			{
				GameWorld.playerBullets.remove(i);
			}
			else 
			{
				i++;
			}
		}	
	}
	
	public boolean checkHit(Character a,Character b) {
		if (Math.abs(a.x-b.x)<=30 &&
		    Math.abs(a.y-b.y)<=30) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	
	
	
}
	
	


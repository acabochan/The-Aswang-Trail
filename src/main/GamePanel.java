package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.player;
import entity.Entity;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;

	// SCREEN SETTINGS
	public final int originalTileSize = 64; // 64x64tile
	final int scale = 2;

	public final int tileSize = originalTileSize * scale; // 128x128 tile
	public final int maxScreenCol = 22;
	public final int maxScreenRow = 6;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;

	// WORLD SETTINGS
	public final int maxWorldCol = 87;
	public final int maxWorldRow = 7;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//SET BACKGROUND
	private BufferedImage setImage;
	
	// FPS
	int FPS = 60;

	//SYSTEM
	

	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound sound = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI (this);
	Thread gameThread;

	
	// ENTITY AND OBJECT
	public player player = new player(this, keyH);
	public Entity obj[] = new Entity[50];
	public Entity monster[] = new Entity[20];
	ArrayList<Entity> projectileList = new ArrayList<>();
	ArrayList<Entity> entityList = new ArrayList<>();
	
	// GAME STATE
	public int gameState = 1;
	public final int playState = 1;
	public final int pauseState = 2; 
	public final int gameOverState = 3;
	public final int youWinState = 4;
	
	
	// Set Players Default Position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 3;

	public GamePanel() {
		
//		System.out.println("screenHeight" + screenHeight);	
//		System.out.println("screenWidth" + screenWidth);	
//
//
//		System.out.println("game panel");	

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	
	public void splashscreen() {
		try {
			Graphics g = (getGraphics());
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			ui.drawTitleScreen(g2);
			ui.drawText(g2);
			Thread.sleep(6000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setMonster();
		gameState = playState;
		
		
//		System.out.println("setup game");	

		
	}

	public void startGameThread() {
		playMusic(0);
		gameThread = new Thread(this);
		System.out.println("gameThread" + gameThread);	
		gameThread.start();
	}

	@Override
	public void run() {

		System.out.println("run");	

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long timer = 0;
		@SuppressWarnings("unused")
		int drawCount = 0;

		System.out.println("gameThread" + gameThread);	

		while (gameThread != null) {
			
			long currentTime = System.nanoTime();
			//System.out.println("current Time:" + currentTime);

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			//System.out.println("delta" + delta);	
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount ++;

			}
			if (timer >= 1000000000) {
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update() {
		
		if(gameState == playState) {
			
			player.update();
			
			for(int i = 0; i < monster.length; i++) { 
				 if(monster[i] != null) {
					 if(monster[i].alive == true && monster[i].dying == false) {
						 monster[i].update();

					 }
					 if(monster[i].alive == false) {
						 monster[i] = null;

					 }
					
				 }
			}
		}
		 
		if(gameState == pauseState) { 
			
		}
		
		
	}
	
	public void setBackground(Graphics2D g2) {
		  try { 

			  setImage = ImageIO.read(getClass().getResource("/maps/background.png")); 
			  g2.drawImage(setImage, 0, 0, screenWidth, screenHeight, null);
			  } 

		  catch (IOException e) 

		  { 

			  e.printStackTrace(); 
		  }

		  } 

	public void paintComponent(Graphics g) {
		
		

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//DEBUG
//		long drawStart = 0;
//		if(keyH.checkDrawTime == true) {
//			drawStart = System.nanoTime();
//		}
		//System.out.println("GameState" + gameState);
		
		//BACKGROUND
		setBackground(g2);
		
		// TILE
		tileM.draw(g2);

		// ADD ENTITIES TO THE LIST
		entityList.add(player);
	
		  for (int i = 0; i < obj.length; i++) {
			  if (obj[i] != null) {
			  entityList.add(obj[i]); } 
		  }
		
		  // MONSTER 
		  for (int i = 0; i < monster.length; i++) { 
			  if (monster[i] != null) { 
			  entityList.add(monster[i]); 
				  } 
			  } 
		  // SORT 
		  Collections.sort(entityList, new Comparator<Entity>() {
		  
			  public int compare(Entity e1, Entity e2) {
			  
			  int result = Integer.compare(e1.worldY, e2.worldY); 
			  return result; }
		  });
		  
		  //DRAW ENTITIES 
		  for (int i = 0; i < entityList.size(); i++) {
		  entityList.get(i).draw(g2); }
		 
		  
		  //EMPTY ENTITY LIST 
		  entityList.clear();
		  
		// PLAYER
		// player.draw(g2);
//		
		// UI 
		ui.draw(g2);
		
//		System.out.println("GameState" + gameState);
//		System.out.println(gameOverState);

		g2.dispose();
	} 
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	public void stopMusic() {
		
		sound.stop();
	}
	public void playSE(int i) {
		
		sound.setFile(i);
		sound.play();
	}
	
	
	
}
	

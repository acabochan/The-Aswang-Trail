package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import entity.Entity;
import objects.OBJ_Heart;  

public class UI {
	
	GamePanel gp; 
	Graphics2D g2;
	Font maruMonica;
	BufferedImage heart_full, heart_half, heart_blank;
	public boolean messageOn = false; 
	public String message = " "; 
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	private BufferedImage setImage;
	
	public UI (GamePanel gp) { 
		this.gp = gp;
		
		InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
		try {
			maruMonica = Font.createFont(Font.TRUETYPE_FONT,is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void showmessage (String text) {
		
		message = text;
		messageOn = true;
	}

	public void draw(Graphics2D g2) {
		
		this.g2 = g2; 
		g2.setFont(maruMonica);
		g2.setColor(Color.white);
		
		if (gp.gameState == gp.playState) {
			
			
			drawPlayerLife();

		}
		
		if (gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen (g2);
		}
		
		if (gp.gameState == gp.gameOverState) {
			
			drawPlayerLife();
			drawGameOverScreen(g2);
		}
		
		if(gp.gameState == gp.youWinState) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gp.stopMusic();
			drawYouWin(g2);
			drawWin(g2);

		}
		
		// CREAT HUD OBJECT 
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image; 
		heart_half = heart.image2;
		heart_blank = heart.image3;
		
	}
	public void drawPlayerLife() {
		
		
		// DRAW BLANK HEART
		int x = gp.tileSize/2; 
		int y = gp.tileSize/2;
		int i = 0;

		// DRAW MAX LIFE 
		while(i < gp.player.maxLife/2) {
			
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
			//RESET
				x = gp.tileSize/2; 
				y = gp.tileSize/2;
				i = 0;
//		
//			//DRAW CURRENT HEALTH
		while(i < gp.player.life) {
			g2.drawImage(heart_half, x, y, null);
			i++;
			
			if(i < gp.player.life ) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
		
		
	}
	public void drawPauseScreen(Graphics2D g2) {
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,80f));

		String text  = "PAUSED"; 
		int x = getXforCenteredText (text);				
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}

	public void drawGameOverScreen(Graphics2D g2) {
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,80f));

		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		
		text = "Game Over";
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text,  x,  y);
		
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Retry";
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
	
	}	
	
	public void drawYouWin(Graphics2D g2) {
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,80f));

		g2.setColor(Color.black);
		g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		
		text = "YOU WIN!";
		g2.setColor(Color.white);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text,  x,  y);
		
	
	}
	
	public void drawTitleScreen(Graphics2D g2) throws InterruptedException {
		
		
		g2.setColor(Color.black);
		g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

		try {
			//Thread.sleep(3000);		
			setImage = ImageIO.read(getClass().getResource("/maps/TitleScreen.png"));
			g2.drawImage(setImage, 0, 0, 1600, 850, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	} 
	
	public void drawText(Graphics2D g2) throws InterruptedException {		
		
		g2.setFont(maruMonica);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40f));
		g2.setColor(Color.white);
		String text  = "Diwata, your brother has not come back. Lumabas ka at hanapin siya."; 
		int x = getXforCenteredText(text);
		int y = gp.tileSize*4;
		
		g2.drawString(text, x-450, y-200);
	}
	
	

	public void drawWin (Graphics2D g2) {
		
		
		  try { 

			  setImage = ImageIO.read(getClass().getResource("/player/Win.png")); 
			  g2.drawImage(setImage, 704, 320, 128, 128, null);
			  } 

		  catch (IOException e) 

		  { 

			  e.printStackTrace(); 
		  }

	} 
	

	public int getXforCenteredText(String text) {
		
		
		int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x = gp.screenWidth/4 - length/4;
		return x; 

	}
}

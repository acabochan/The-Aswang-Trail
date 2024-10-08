package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

		GamePanel gp;
		
		public BufferedImage Left1, Left2, Left3, Left4, Left5, Left6, Left7, Left8, Right1, Right2, Right3, Right4, Right5, Right6, Right7, Right8, Still1, Still2;
		public BufferedImage PunchL1, PunchL2, PunchL3, PunchL4, PunchL5, PunchL6, PunchL7, PunchL8, PunchR1, PunchR2, PunchR3, PunchR4, PunchR5, PunchR6, PunchR7, PunchR8;
		public Rectangle solidArea = new Rectangle(0, 0, 128, 128);
		public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
		public int solidAreaDefaultX, solidAreaDefaultY;
		public boolean collisionOn = false;
		public BufferedImage image, image2, image3; 
		public int solidDefaultAreaX;
		public int solidDefaultAreaY;

		//STATE 
		public int worldX, worldY;
		public String direction = "still"; 
		public int spriteNum = 1;
		public boolean collision = false;
		public boolean invincible = false;
		boolean attacking = false;
		boolean jumpUp = false;
		boolean jumpDown = false;
		public int landingY;
		public int ceilingY;
		public boolean alive = true;
		public boolean dying = false;
		boolean hpBarOn = false;
		public boolean knockBack = false;

		
		//COUNTER
		public int spriteCounter = 0;
		public int actionLockCounter = 0;
		public int invincibleCounter = 0;
		int standCounter = 0;
		int attackCounter = 0;
		int dyingCounter = 0;
		int hpBarCounter = 0;
		int knockBackCounter = 0;

		//CHARACTER ATTRIBUTES 
		public int type; // 0 = player 1 = monster 2 = boss
		public String name;
		public int speed;
		public int defaultSpeed;
		public int maxLife;
		public int life;
		public int maxAmmo;
		public Projectile projectile;
		public int useCost;
		public int changeDirection1 = 0;
		public int changeDirection2 = 0;
		public int changeDirection3 = 0;
		public int changeDirection4 = 0;
		
			
		public Entity(GamePanel gp) {
			this.gp = gp; 
		}
		
		public void setAction() {}
		
		public void damageReaction() {
			
		}
		
		 public void update() {
			 
		 if(knockBack == true) {
				 
				 gp.cChecker.checkTile(this);
				 gp.cChecker.checkObject(this, false);		 
				 gp.cChecker.checkEntity(this, gp.monster);
								 
				 if(collisionOn == true) {
					 knockBackCounter = 0;
					 knockBack = false;
					 speed = defaultSpeed;
				 }
				 
				 else if(collisionOn == false) {
					 
					 switch(gp.player.direction) {
					 case "up": worldY -= speed; break;
					 case "down": worldY += speed; break;
					 case "left": worldX -= speed; break;
					 case "right": worldX += speed; break;
					 }
				 }

				 knockBackCounter++;
				 if(knockBackCounter == 10) {
					 knockBackCounter = 0;
					 knockBack = false;
					 speed = defaultSpeed;
				 }
				 
		}
		else {
			 setAction();
			 
			 collisionOn = false; 
			 gp.cChecker.checkTile(this);
			 gp.cChecker.checkObject(this, false);		 
			 gp.cChecker.checkEntity(this, gp.monster);
			 boolean contactPlayer = gp.cChecker.checkPlayer(this);
			 
			 if(this.type == 1 && contactPlayer == true) {
				 if(gp.player.invincible == false) {
					 gp.player.life -= 1;
					 gp.player.invincible = true;
				 }
			 }

			 if(this.type == 2 && contactPlayer == true) {
				 if(gp.player.invincible == false) {
					 gp.player.life -= 1;
					 gp.player.invincible = true;
				 }
			 }
			 
			 //IF COLLISION IS FALSE	 
			 if(collisionOn == false) {
				 
				 switch(direction) {
				 case "up": worldY -= speed; break;
				 case "down": worldY += speed; break;
				 case "left": 
					 if (worldX <= 6 * gp.tileSize) {
						 //do not move
					 } else {
							 if (gp.monster[4].name == "Engkanto") {
								 if (worldX <= 78 * gp.tileSize) {  
									 //do not move
								 }
							}
						    
					worldX -= speed;
						    
						    
							 
						
					 }
					 break;
					 case "right": 
					 if (worldX >= 81 * gp.tileSize) {
						 //do not move
					 } else {
						 worldX += speed;  
					 }
					 break;
				 }
			 }
	
		}	 
			 
		 
		 spriteCounter++;
		 if(spriteCounter > 10) {
			 if(spriteNum == 1) {
				 spriteNum = 2;
			 }
			 else if(spriteNum == 2) {
			 		spriteNum = 3;
			 }
			 else if(spriteNum == 3) {
			 		spriteNum = 4;
			 }
			 else if(spriteNum == 4) {
			 		spriteNum = 5;
			 }
			 else if(spriteNum == 5) {
				 spriteNum = 6;
			 }
			 else if(spriteNum == 6) {
				 spriteNum = 7;
			 }
			 else if(spriteNum == 7) {
				 spriteNum = 8;
			 }
			 else if(spriteNum == 8) {
				 spriteNum = 1;
			 }

			 spriteCounter = 0;
	}
		 
		 
			if(invincible == true) {
				invincibleCounter++;
				if(invincibleCounter > 40) {
					invincible = false; 
					invincibleCounter = 0;
				}
			}
		 }
		 
		 
		public void draw(Graphics2D g2) {
			
			BufferedImage image = null;
			int  screenX = worldX - gp.player.worldX + gp.player.screenX;
			int  screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenX &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				

				switch (direction) {
				case "up":
					if (spriteNum == 1) {image = Left1;}
					if (spriteNum == 2) {image = Left2;}
					if (spriteNum == 3) {image = Left3;}
					if (spriteNum == 4) {image = Left4;}
					if (spriteNum == 5) {image = Left5;}
					if (spriteNum == 6) {image = Left6;}
					if (spriteNum == 7) {image = Left7;}
					if (spriteNum == 8) {image = Left8;}

					break;
				case "down":
					if (spriteNum == 1) {image = Right1;}
					if (spriteNum == 2) {image = Right2;}
					if (spriteNum == 3) {image = Right3;}
					if (spriteNum == 4) {image = Right4;}
					if (spriteNum == 5) {image = Right5;}
					if (spriteNum == 6) {image = Right6;}
					if (spriteNum == 7) {image = Right7;}
					if (spriteNum == 8) {image = Right8;}			
					
					break;
				case "right":
					if (spriteNum == 1) {image = Right1;}
					if (spriteNum == 2) {image = Right2;}
					if (spriteNum == 3) {image = Right3;}
					if (spriteNum == 4) {image = Right4;}
					if (spriteNum == 5) {image = Right5;}
					if (spriteNum == 6) {image = Right6;}
					if (spriteNum == 7) {image = Right7;}
					if (spriteNum == 8) {image = Right8;}

					break;
				case "left":
					if (spriteNum == 1) {image = Left1;}
					if (spriteNum == 2) {image = Left2;}
					if (spriteNum == 3) {image = Left3;}
					if (spriteNum == 4) {image = Left4;}
					if (spriteNum == 5) {image = Left5;}
					if (spriteNum == 6) {image = Left6;}
					if (spriteNum == 7) {image = Left7;}
					if (spriteNum == 8) {image = Left8;}
					break;
				default:
					if (spriteNum == 1) {image = Still1;}
					if (spriteNum == 2) {image = Still2;}
					if (spriteNum == 3) {image = Still1;}
					if (spriteNum == 4) {image = Still2;}
					if (spriteNum == 5) {image = Still1;}
					if (spriteNum == 6) {image = Still2;}
					if (spriteNum == 7) {image = Still1;}
					if (spriteNum == 8) {image = Still2;}
					break;
					}
				
				//Monster HP bar 
				
				if(type == 1 && hpBarOn == true) {
					
					double oneScale = (double)gp.tileSize/maxLife;
					double hpBarValue = oneScale*life;		
				
					g2.setColor(new Color(35, 35, 35));
					g2.fillRect(screenX-1, screenY-16, gp.tileSize+2, 12);
					g2.setColor(new Color(255, 0, 30));
					g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);
					
					hpBarCounter++;
					if(hpBarCounter > 600) {
						hpBarCounter = 0;
						hpBarOn = false;
					}
	
				}
				
				if(type == 2 && hpBarOn == true) {
					
					
					double oneScale = (double)gp.tileSize/maxLife;
					double hpBarValue = oneScale*life;		
					
					g2.setColor(new Color(35, 35, 35));
					g2.fillRect(screenX-1, screenY-16, gp.tileSize+2, 12);
					g2.setColor(new Color(255, 0, 30));
					g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);
					
					hpBarCounter++;
					if(hpBarCounter > 600) {
						hpBarCounter = 0;
						hpBarOn = false;
					}
	
				}
				
			
				
				if(invincible == true) {
					hpBarOn = true;
					hpBarCounter = 0;
					g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
					
				}
				if(dying == true) {
					gp.playSE(1);
					dyingAnimation(g2);
				}
				
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

			
			}
		}
		
		public void dyingAnimation(Graphics2D g2) {
			
			dyingCounter++;
			
			int i = 5;
			if(dyingCounter <= i) {changeAlpha(g2,0f);}
			if(dyingCounter > i && dyingCounter <= i*2) {changeAlpha(g2,1f);}
			if(dyingCounter > i*2 && dyingCounter <= i*3) {changeAlpha(g2,0f);}
			if(dyingCounter > i*3 && dyingCounter <= i*4) {changeAlpha(g2,1f);}
			if(dyingCounter > i*4 && dyingCounter <= i*5) {changeAlpha(g2,0f);}
			if(dyingCounter > i*5 && dyingCounter <= i*6) {changeAlpha(g2,1f);}
			if(dyingCounter <= i*6 && dyingCounter <= i*7) {changeAlpha(g2,0f);}
			if(dyingCounter > i*7 && dyingCounter <= i*8) {changeAlpha(g2,1f);}
			if(dyingCounter > i*8) {
				alive = false;
			}

		}
		public void changeAlpha(Graphics2D g2, float alphaValue) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));

			
		}
		
		public BufferedImage setup(String imagePath, int width, int height) {

			UtilityTool UTool = new UtilityTool ();
			BufferedImage image = null;

			try {
				image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = UTool.scaleImage(image, width, height);
	} catch(IOException e) {
		e.printStackTrace();
	}
	return image;
}

}

package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;


public class player extends Entity {

	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	public int velY;
	public int velX;
	

	public player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.keyH = keyH;

		screenX = gp.screenWidth / 2 - (gp.tileSize * 5);
		screenY = gp.screenHeight / 2 + (gp.tileSize);

		solidArea = new Rectangle();
		solidArea.x = 18;
		solidArea.y = 44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 64;
		
		attackArea.width = 64;
		attackArea.height = 64;

		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
	}
	
	
	public void setDefaultValues() {

		maxLife = 10;
		System.out.println("Life " + maxLife);	
		life = maxLife;
		worldX = 896;
		worldY = 640;
		defaultSpeed = 4;
		speed = defaultSpeed;
		direction = "still";
				
	}

	public void getPlayerImage() {
		Left1 = setup("/player/Left1",gp.tileSize,gp.tileSize);
		Left2 = setup("/player/Left2",gp.tileSize,gp.tileSize);
		Left3 = setup("/player/Left3",gp.tileSize,gp.tileSize);
		Left4 = setup("/player/Left4",gp.tileSize,gp.tileSize);
		Right1 = setup("/player/Right1",gp.tileSize,gp.tileSize);
		Right2 = setup("/player/Right2",gp.tileSize,gp.tileSize);
		Right3 = setup("/player/Right3",gp.tileSize,gp.tileSize);
		Right4 = setup("/player/Right4",gp.tileSize,gp.tileSize);
		Still1 = setup("/player/Still1",gp.tileSize,gp.tileSize);
		Still2 = setup("/player/Still2",gp.tileSize,gp.tileSize);
		
	}
	
	public void getPlayerAttackImage() {

		PunchL1 = setup("/player/PunchL1",gp.tileSize,gp.tileSize);
		PunchL2 = setup("/player/PunchL2",gp.tileSize,gp.tileSize);
		PunchL3 = setup("/player/PunchL3",gp.tileSize,gp.tileSize);
		PunchL4 = setup("/player/PunchL4",gp.tileSize,gp.tileSize);
		PunchL5 = setup("/player/PunchL5",gp.tileSize,gp.tileSize);
		PunchL6 = setup("/player/PunchL6",gp.tileSize,gp.tileSize);
		PunchL7 = setup("/player/PunchL7",gp.tileSize,gp.tileSize);
		PunchL8 = setup("/player/PunchL8",gp.tileSize,gp.tileSize);
		PunchR1 = setup("/player/PunchR1",gp.tileSize,gp.tileSize);
		PunchR2 = setup("/player/PunchR2",gp.tileSize,gp.tileSize);
		PunchR3 = setup("/player/PunchR3",gp.tileSize,gp.tileSize);
		PunchR4 = setup("/player/PunchR4",gp.tileSize,gp.tileSize);
		PunchR5 = setup("/player/PunchR5",gp.tileSize,gp.tileSize);
		PunchR6 = setup("/player/PunchR6",gp.tileSize,gp.tileSize);
		PunchR7 = setup("/player/PunchR7",gp.tileSize,gp.tileSize);
		PunchR8 = setup("/player/PunchR8",gp.tileSize,gp.tileSize);
	}

	public void update() {
		

		
		if (keyH.upPressed == true) {			
			direction = "up";
		
		} else if (keyH.downPressed == true) {
			direction = "down";
	
		} else if (keyH.rightPressed == true) {
			direction = "right";

		} else if (keyH.leftPressed == true) {
			direction = "left";
			
		
		} else {
			direction = "";
			
		}
		
		if(keyH.enterPressed == true) {
			gp.playSE(2);			
			attacking = true;
//			System.out.println("attacking " + attacking);	

		}
		
		if(attacking == true) {
			attacking();

			
		}
		
		if(keyH.jumpPressed == true && (worldY >= (450) && worldY <= 660) && jumpUp == false && jumpDown == false) {
			
			jumpUp = true;
			landingY = worldY;
			ceilingY = landingY - (200);
//			System.out.println("attacking " + attacking);	

		}
		
	
		// CHECK TILE COLLISION
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		//CHECK OBJECT COLLISION
		int objectIndex = gp.cChecker.checkObject(this, true);
		contactObject(objectIndex);
		
		// CHECK MONST COLLISION 
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		contactMonster(monsterIndex);

		
		// IF COLLISION IS FALSE PLAYER CAN MOVE
		if(collisionOn == false) {
			 
			 switch(direction) {
			 case "up": worldY -= speed; break;
			 case "down": worldY += speed; break;
			 case "left": 
			 if (worldX <= 6 * gp.tileSize) {
				 //do not move
			 } else {
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
				 		spriteNum = 1;
				 }

				 spriteCounter = 0;
		}
		 
		}
	    else 
	    { 
				standCounter++;
				if(standCounter == 20) {
					spriteNum = 1;
					standCounter = 0;
			   }
			
	    }
		
		
//		if(gp.keyH.shotKeyPressed == true && projectile.alive == false) {
//			
//			projectile.set(worldX, worldY, direction, true, this);
//			
//		}
	
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false; 
				invincibleCounter = 0;
			}
		}
		
		if(life > maxLife) {
			life = maxLife;
		}
		
		if(life <= 0) {
			gp.gameState = gp.gameOverState;
			gp.playSE(3);
		}
		
		if (jumpUp == true || jumpDown == true) {
			
			jumping();
		}
		
		if(gp.monster[4].alive == false) {
			
			gp.gameState = gp.youWinState;
			
		}

		
	}
	
	public void jumping() {
		
		if (jumpUp == true) {
			
			//if (collisionOn == false ) {
			worldY -= 5;
			if(direction == "left") {worldX -= 2;}
			if(direction == "right") {worldX += 2;}
			//}
			
			if (worldY <= ceilingY) {
				
				jumpUp = false;
				jumpDown = true;
				
			}
			
		}
		
		if (jumpDown == true) {
				
				//if (collisionOn == false ) {
				worldY += 5;
				if(direction == "left") {worldX -= 2;}
				if(direction == "right") {worldX += 2;}
			//	}
				
				if (worldY >= landingY) {
					
					jumpUp = false;
					jumpDown = false;
					
				}	
	
		} 
		
	}
	
	public void attacking() {
		if (attacking == true) {
			
				attackCounter++;
				
				if(attackCounter <= 5) {
					spriteNum = 1;
				}
				if(attackCounter > 5 && attackCounter <= 10) {
					spriteNum = 2;
				}
				if(attackCounter > 10 && attackCounter <= 15) {
					spriteNum = 3;
				}
				if(attackCounter > 15 && attackCounter <= 20) {
					spriteNum = 4;
					
					// Save the current position
					int currentWorldX = worldX;
					int currentWorldY = worldY;
					int solidAreaWidth = solidArea.width;
					int solidAreaHeight = solidArea.height;
					
					//Adjust players square
					switch(direction) {
					case "up": worldY -= attackArea.height; break;
					case "down": worldY += attackArea.height; break;
					case "left": worldX -= attackArea.width; break;
					case "right": worldX += attackArea.width; break;
					}
					
					//attack area becomes solid area
					solidArea.width = attackArea.width;
					solidArea.height = attackArea.height;
					
					//check monster collision
					int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
					
					damageMonster(monsterIndex);
					
					worldX = currentWorldX;
					worldY = currentWorldY;
					solidArea.width = solidAreaWidth;
					solidArea.height = solidAreaHeight;

				}
				if(attackCounter > 20 && attackCounter <= 25) {
					spriteNum = 5;
				}
				if(attackCounter > 25 && attackCounter <= 30) {
					spriteNum = 6;
				}
				if(attackCounter > 30 && attackCounter <= 35) {
					spriteNum = 7;
				}
				if(attackCounter > 35 && attackCounter <= 40) {
					spriteNum = 8;
				}
				if(attackCounter > 45 && attackCounter <= 50) {
					spriteNum = 8;
				}
				
//				System.out.println("attack counter " + attackCounter);
				if(attackCounter > 60) {
					
					attacking = false;
					System.out.println("false attacking " + attacking);
					spriteNum = 1;
					attackCounter = 0;
					
				}
		}
		

		
	}
		 
	public void contactMonster(int i) {
		if(i != 999) {	
			
			if(invincible == false && gp.monster[i].dying == false) {
				life -= 1;
				invincible = true;
			}	
		}
	}
	
	public void contactObject(int i) {
		//System.out.println("object index " + i);
		if(i != 999) {	
			
//			landingY = gp.obj[i].landingY + 12;
//			worldY -= gp.obj[i].landingY + 12;
			collisionOn = true;
		}
	}
	
	public void  damageMonster(int i) {
		
		if(i != 999) {
			if(gp.monster[i].invincible == false) {
				
				knockBack(gp.monster[i]);
				
				gp.monster[i].life -= 1;
				gp.monster[i].invincible = true;
				
				if(gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
				}
			}
		}
	}
	
	public void knockBack(Entity entity) {
		
		entity.direction = direction;
		entity.speed += 10;
		entity.knockBack = true;
		
	}
	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if(attacking == false) {
				if(spriteNum == 1) {image = Left1;}
				if(spriteNum == 2) {image = Left2;}
				if(spriteNum == 3) {image = Left3;}
				if (spriteNum == 4) {image = Left4;}
				if (spriteNum == 5) {image = Left1;}
				if(spriteNum == 6) {image = Left2;}
				if(spriteNum == 7) {image = Left3;}
				if (spriteNum == 8) {image = Left4;}
			}
			
			if(attacking == true) {
				if(spriteNum == 1) {image = PunchL1;}
				if(spriteNum == 2) {image = PunchL2;}
				if(spriteNum == 3) {image = PunchL3;}
				if (spriteNum == 4) {image = PunchL4;}
				if (spriteNum == 5) {image = PunchL5;}
				if(spriteNum == 6) {image = PunchL6;}
				if(spriteNum == 7) {image = PunchL7;}
				if (spriteNum == 8) {image = PunchL8;}

			}
			
			break;
		case "down":
			if(attacking == false) {
				if(spriteNum == 1) {image = Right1;}
				if(spriteNum == 2) {image = Right2;}
				if(spriteNum == 3) {image = Right3;}
				if (spriteNum == 4) {image = Right4;}
				if (spriteNum == 5) {image = Right1;}
				if(spriteNum == 6) {image = Right2;}
				if(spriteNum == 7) {image = Right3;}
				if (spriteNum == 8) {image = Right4;}
			}
			
			if(attacking == true) {
				if(spriteNum == 1) {image = PunchR1;}
				if(spriteNum == 2) {image = PunchR2;}
				if(spriteNum == 3) {image = PunchR3;}
				if (spriteNum == 4) {image = PunchR4;}
				if (spriteNum == 5) {image = PunchR5;}
				if(spriteNum == 6) {image = PunchR6;}
				if(spriteNum == 7) {image = PunchR7;}
				if (spriteNum == 8) {image = PunchR8;}

			}

			break;
		case "right":
			if(attacking == false) {
				if(spriteNum == 1) {image = Right1;}
				if(spriteNum == 2) {image = Right2;}
				if(spriteNum == 3) {image = Right3;}
				if (spriteNum == 4) {image = Right4;}
				if (spriteNum == 5) {image = Right1;}
				if(spriteNum == 6) {image = Right2;}
				if(spriteNum == 7) {image = Right3;}
				if (spriteNum == 8) {image = Right4;}
			}
			
			if(attacking == true) {
				if(spriteNum == 1) {image = PunchR1;}
				if(spriteNum == 2) {image = PunchR2;}
				if(spriteNum == 3) {image = PunchR3;}
				if (spriteNum == 4) {image = PunchR4;}
				if (spriteNum == 5) {image = PunchR5;}
				if(spriteNum == 6) {image = PunchR6;}
				if(spriteNum == 7) {image = PunchR7;}
				if (spriteNum == 8) {image = PunchR8;}

			}

			break;
		case "left":
			if(attacking == false) {
				if(spriteNum == 1) {image = Left1;}
				if(spriteNum == 2) {image = Left2;}
				if(spriteNum == 3) {image = Left3;}
				if (spriteNum == 4) {image = Left4;}
				if (spriteNum == 5) {image = Left1;}
				if(spriteNum == 6) {image = Left2;}
				if(spriteNum == 7) {image = Left3;}
				if (spriteNum == 8) {image = Left4;}
			}
			
			if(attacking == true) {
				if(spriteNum == 1) {image = PunchL1;}
				if(spriteNum == 2) {image = PunchL2;}
				if(spriteNum == 3) {image = PunchL3;}
				if (spriteNum == 4) {image = PunchL4;}
				if (spriteNum == 5) {image = PunchL5;}
				if(spriteNum == 6) {image = PunchL6;}
				if(spriteNum == 7) {image = PunchL7;}
				if (spriteNum == 8) {image = PunchL8;}
			}
			break;

		default:
			if(attacking == false) {
				if(spriteNum == 1) {image = Still1;}
				if(spriteNum == 2) {image = Still2;}
				if(spriteNum == 3) {image = Still1;}
				if (spriteNum == 4) {image = Still2;}
				if (spriteNum == 5) {image = Still1;}
				if(spriteNum == 6) {image = Still2;}
				if(spriteNum == 7) {image = Still1;}
				if (spriteNum == 8) {image = Still2;}
		
			}	
			
			if(attacking == true) {
				if(spriteNum == 1) {image = PunchR1;}
				if(spriteNum == 2) {image = PunchR2;}
				if(spriteNum == 3) {image = PunchR3;}
				if (spriteNum == 4) {image = PunchR4;}
				if (spriteNum == 5) {image = PunchR5;}
				if(spriteNum == 6) {image = PunchR6;}
				if(spriteNum == 7) {image = PunchR7;}
				if (spriteNum == 8) {image = PunchR8;}
			}
			break;
		}
		
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			
		}
		g2.drawImage(image, screenX, screenY, null);
		
		//Reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		
		//DEEBUG
//		g2.setFont(new Font("Arial", Font.PLAIN, 26));
//		g2.setColor(Color.white);
//		g2.drawString("Invincible:"+invincibleCounter, 10, 400);

	}
}

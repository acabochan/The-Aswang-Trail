package monster;

import entity.Entity;
import main.GamePanel;

import java.awt.Rectangle;
import java.util.Random;

public class MON_Duwende extends Entity{
	
		GamePanel gp;

		public MON_Duwende(GamePanel gp) {
			super(gp);
			
			this.gp = gp;
			
			type = 1;
			name = "Duwende";
			defaultSpeed = 3;
			speed = defaultSpeed;
			maxLife = 3;
			life = maxLife;
			
			solidArea = new Rectangle();
			solidArea.x = 20;
			solidArea.y = 20;
			solidArea.width = 64;
			solidArea.height = 64;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			getImage();
			
		}
		public void getImage() {
			
			Left1 = setup("/monster/DuwendeLeft1",gp.tileSize,gp.tileSize);
			Left2 = setup("/monster/DuwendeLeft2",gp.tileSize,gp.tileSize);
			Left3 = setup("/monster/DuwendeLeft3",gp.tileSize,gp.tileSize);
			Left4 = setup("/monster/DuwendeLeft4",gp.tileSize,gp.tileSize);
			Left5 = setup("/monster/DuwendeLeft1",gp.tileSize,gp.tileSize);
			Left6 = setup("/monster/DuwendeLeft2",gp.tileSize,gp.tileSize);
			Left7 = setup("/monster/DuwendeLeft3",gp.tileSize,gp.tileSize);
			Left8 = setup("/monster/DuwendeLeft4",gp.tileSize,gp.tileSize);

			Right1 = setup("/monster/DuwendeRight1",gp.tileSize,gp.tileSize);
			Right2 = setup("/monster/DuwendeRight2",gp.tileSize,gp.tileSize);
			Right3 = setup("/monster/DuwendeRight3",gp.tileSize,gp.tileSize);
			Right4 = setup("/monster/DuwendeRight4",gp.tileSize,gp.tileSize);
			Right5 = setup("/monster/DuwendeRight1",gp.tileSize,gp.tileSize);
			Right6 = setup("/monster/DuwendeRight2",gp.tileSize,gp.tileSize);
			Right7 = setup("/monster/DuwendeRight3",gp.tileSize,gp.tileSize);
			Right8 = setup("/monster/DuwendeRight4",gp.tileSize,gp.tileSize);

		}

		public void setAction() {
			int xDistance;
			int yDistance;
			int Distance;
			
			for(int i = 0; i < gp.monster.length; i++) {
				if(gp.monster[i] != null) {
					xDistance = Math.abs(gp.player.worldX - gp.monster[i].worldX);
					yDistance = Math.abs(gp.player.worldY - gp.monster[i].worldY);
					Distance = Math.max(xDistance, yDistance);
					if(gp.monster[i].alive == true && gp.monster[i].dying ==false) {
						if(Distance < 4*gp.tileSize) {
							if(gp.player.worldX > gp.monster[i].worldX && gp.player.worldY > gp.monster[i].worldY) {
								if(changeDirection1 < 30) {
									gp.monster[i].direction = "right";
								}
								else if(changeDirection1 >=45 && changeDirection1 < 90) {
									gp.monster[i].direction = "down";
								}
								else if(changeDirection1 > 90){
									changeDirection1 = 0;
								}
								changeDirection1++;
							}
							else if(gp.player.worldX > gp.monster[i].worldX && gp.player.worldY < gp.monster[i].worldY) {
								if(changeDirection2 < 45) {
									gp.monster[i].direction = "right";
								}
								else if(changeDirection2 >=45 && changeDirection2 < 90) {
									gp.monster[i].direction = "up";
								}
								else if(changeDirection2 > 90){
									changeDirection2 = 0;
								}
								changeDirection2++;
							}
							else if(gp.player.worldX < gp.monster[i].worldX && gp.player.worldY > gp.monster[i].worldY) {
								if(changeDirection3 < 45) {
									gp.monster[i].direction = "left";
								}
								else if(changeDirection3 >=45 && changeDirection3 < 90) {
									gp.monster[i].direction = "down";
								}
								else if(changeDirection3 > 90){
									changeDirection3 = 0;
								}
								changeDirection3++;
							}
							else if(gp.player.worldX < gp.monster[i].worldX && gp.player.worldY < gp.monster[i].worldY) {
								if(changeDirection4 < 45) {
									gp.monster[i].direction = "left";
								}
								else if(changeDirection4 >=45 && changeDirection4 < 90) {
									gp.monster[i].direction = "up";
								}
								else if(changeDirection4 > 90){
									changeDirection4 = 0;
								}
								changeDirection4++;
							}
							else if(gp.player.worldX == gp.monster[i].worldX && gp.player.worldY < gp.monster[i].worldY) {
								gp.monster[i].direction = "up";
							}
							else if(gp.player.worldX == gp.monster[i].worldX && gp.player.worldY > gp.monster[i].worldY) {
								gp.monster[i].direction = "down";
							}
							else if(gp.player.worldX < gp.monster[i].worldX && gp.player.worldY == gp.monster[i].worldY) {
								gp.monster[i].direction = "left";
							}
							else if(gp.player.worldX > gp.monster[i].worldX && gp.player.worldY == gp.monster[i].worldY) {
								gp.monster[i].direction = "right";
							}
							
						}
						else {
							actionLockCounter++;
							
							if(actionLockCounter == 600) {
							
							Random random = new Random();
							int a = random.nextInt(100)+1; //picks up a number from 1 to 100
							
							if(a <= 25) {
								direction = "up";
							}
							else if(a > 25 && a <= 50) {
								direction = "left";
							}
							else if(a > 50 && a <= 75) {
								direction = "down";
							}
							else if(a > 75 && a <= 100) {
								direction = "right";
							}
							actionLockCounter = 0;
							}
						}
					}				
				}
			}	
		}}



package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

	public class TruckR2C2 extends Entity{
			
	public TruckR2C2( GamePanel gp) {
			super(gp);
			
			name = "truckR2C2";
			Still1 = setup("/objects/truckR2C2",gp.tileSize,gp.tileSize);
			collision = false;
			solidArea = new Rectangle();
			solidArea.x = 18;
			solidArea.y = 80;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			solidArea.width = 64;
			solidArea.height = 64;
		}
	}
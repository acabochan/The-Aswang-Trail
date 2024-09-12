package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

	public class TruckR1C3 extends Entity{
			
	public TruckR1C3( GamePanel gp) {
			super(gp);
			
			name = "truckR1C3";
			Still1 = setup("/objects/truckR1C3",gp.tileSize,gp.tileSize);
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
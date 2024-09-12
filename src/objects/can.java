package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class can extends Entity{
		
public can (GamePanel gp) {
		super(gp);
		
		name = "can";
		Still1 = setup("/objects/can",gp.tileSize,gp.tileSize);
		collision = true;
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 64;
		solidArea.height = 128;
		
	}
}

package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class hotdogR1C1 extends Entity{
		
public hotdogR1C1( GamePanel gp) {
		super(gp);
		
		name = "hotdogR1C1";
		Still1 = setup("/objects/hotdogR1C1",gp.tileSize,gp.tileSize);
		collision = false;
		solidArea = new Rectangle();
		solidArea.x = 18;
		solidArea.y = 80;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 44;
	}
}


package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class FishR2C1 extends Entity{
		
public FishR2C1( GamePanel gp) {
		super(gp);
		
		name = "fishR2C1";
		Still1 = setup("/objects/fishR2C1",gp.tileSize,gp.tileSize);
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


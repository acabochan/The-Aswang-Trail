package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class bbq extends Entity{
		
public bbq (GamePanel gp) {
		super(gp);
		
		name = "bbq";
		Still1 = setup("/objects/bbq",gp.tileSize,gp.tileSize);
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

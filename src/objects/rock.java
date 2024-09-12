package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class rock extends Entity{
		
public rock (GamePanel gp) {
		super(gp);
		
		name = "bbq";
		Still1 = setup("/objects/rock",gp.tileSize,gp.tileSize);
		collision = true;
//		solidArea = new Rectangle();
//		solidArea.x = 18;
//		solidArea.y = 80;
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
//		solidArea.width = 24;
//		solidArea.height = 44;
		
	}
}

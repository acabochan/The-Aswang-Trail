package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class tankR1C2 extends Entity{
		
public tankR1C2( GamePanel gp) {
		super(gp);
		
		name = "bubR1C2";
		Still1 = setup("/objects/tankR1C2",gp.tileSize,gp.tileSize);
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

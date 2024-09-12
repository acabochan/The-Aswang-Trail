package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class purpR2C2 extends Entity{
		
public purpR2C2(GamePanel gp) {
		super(gp);
		
		name = "purpR2C2";
		Still1 = setup("/objects/purpR2C2",gp.tileSize,gp.tileSize);
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
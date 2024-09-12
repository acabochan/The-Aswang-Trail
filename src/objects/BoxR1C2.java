package objects;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

	public class BoxR1C2 extends Entity{
			
	public BoxR1C2( GamePanel gp) {
			super(gp);
			
			name = "Box1C2";
			Still1 = setup("/objects/BoxR1C2",gp.tileSize,gp.tileSize);
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
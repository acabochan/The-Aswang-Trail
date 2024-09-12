package objects;

import entity.Entity;
import main.GamePanel;

public class OBJ_Crate extends Entity{
		
public OBJ_Crate( GamePanel gp) {
		super(gp);
		
		name = "crate";
		Still1 = setup("/objects/crate",gp.tileSize,gp.tileSize);
		collision = true;
		solidArea.x = 0;
		solidArea.y = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 128;
		solidArea.height = 128;
	}
}

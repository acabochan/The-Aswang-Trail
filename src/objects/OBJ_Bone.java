package objects;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Bone extends Projectile{
	
	GamePanel gp;

	public OBJ_Bone(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Bone";
		speed = 5;
		maxLife = 80;
		life = maxLife;
//		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
		
	}
	
	public void getImage() {
		Left1 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left2 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left3 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left4 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left5 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left6 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left7 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);
		Left8 = setup("/objects/BoneLeft",gp.tileSize,gp.tileSize);

		Right1 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right2 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right3 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right4 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right5 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right6 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right7 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
		Right8 = setup("/objects/BoneRight",gp.tileSize,gp.tileSize);
	}
	

}

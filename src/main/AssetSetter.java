package main;

import objects.OBJ_Crate;
import objects.ShroomR1C1;
import objects.ShroomR1C2;
import objects.ShroomR1C3;
import objects.ShroomR2C1;
import objects.ShroomR2C2;
import objects.ShroomR2C3;
import objects.bbq;
import objects.bubR1C1;
import objects.bubR1C2;
import objects.bubR2C1;
import objects.bubR2C2;
import objects.can;
import objects.hotdogR1C1;
import objects.hotdogR1C2;
import objects.hotdogR2C1;
import objects.hotdogR2C2;
import objects.purpR1C1;
import objects.purpR1C2;
import objects.purpR2C1;
import objects.purpR2C2;
import objects.rock;
import objects.squidR1C1;
import objects.squidR1C2;
import objects.squidR2C1;
import objects.squidR2C2;
import objects.tankR1C1;
import objects.tankR1C2;
import objects.tankR2C1;
import objects.tankR2C2;
import monster.MON_Ang;
import monster.MON_Cyclops;
import monster.MON_Duwende;
import monster.MON_Engkanto;
import monster.MON_May;
import objects.BoxR1C1;
import objects.BoxR1C2;
import objects.BoxR1C3;
import objects.BoxR2C1;
import objects.BoxR2C2;
import objects.BoxR2C3;
import objects.FishR1C1;
import objects.FishR1C2;
import objects.FishR2C1;
import objects.FishR2C2;

public class AssetSetter {
	
	GamePanel gp; 
	
	public AssetSetter (GamePanel gp) {
		this.gp = gp;

	}
	
	public void setObject () {
		
//		gp.obj[0] = new OBJ_Crate(gp);
//		gp.obj[0].worldX = 6 * gp.tileSize;
//		gp.obj[0].worldY = 5 * gp.tileSize;
		

		
		gp.obj[1] = new FishR1C1(gp);
		gp.obj[1].worldX = 10 * gp.tileSize;
		gp.obj[1].worldY = 3 * gp.tileSize;
		
		gp.obj[2] = new FishR1C2(gp);
		gp.obj[2].worldX = 11 * gp.tileSize;
		gp.obj[2].worldY = 3 * gp.tileSize;
		
		gp.obj[3] = new FishR2C1(gp);
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 4 * gp.tileSize;
		
		gp.obj[4] = new FishR2C2(gp);
		gp.obj[4].worldX = 11 * gp.tileSize;
		gp.obj[4].worldY = 4 * gp.tileSize;
		
		gp.obj[5] = new purpR1C1(gp);
		gp.obj[5].worldX = 6 * gp.tileSize;
		gp.obj[5].worldY = 3 * gp.tileSize;

		gp.obj[6] = new purpR1C2(gp);
		gp.obj[6].worldX = 7 * gp.tileSize;
		gp.obj[6].worldY = 3 * gp.tileSize;

		gp.obj[7] = new purpR2C1(gp);
		gp.obj[7].worldX = 6 * gp.tileSize;
		gp.obj[7].worldY = 4 * gp.tileSize;

		gp.obj[8] = new purpR2C2(gp);
		gp.obj[8].worldX = 7 * gp.tileSize;
		gp.obj[8].worldY = 4 * gp.tileSize;
		
//		gp.obj[9] = new OBJ_Crate(gp);
//		gp.obj[9].worldX = 1 * gp.tileSize;
//		gp.obj[9].worldY = 4 * gp.tileSize;
		
		gp.obj[10] = new ShroomR1C1(gp);
		gp.obj[10].worldX = 13 * gp.tileSize;
		gp.obj[10].worldY =  3* gp.tileSize;
		
		gp.obj[11] = new ShroomR1C2(gp);
		gp.obj[11].worldX = 14 * gp.tileSize;
		gp.obj[11].worldY =  3 * gp.tileSize;

		gp.obj[12] = new ShroomR1C3(gp);
		gp.obj[12].worldX = 15 * gp.tileSize;
		gp.obj[12].worldY =  3 * gp.tileSize;

		gp.obj[13] = new ShroomR2C1(gp);
		gp.obj[13].worldX = 13 * gp.tileSize;
		gp.obj[13].worldY =  4* gp.tileSize;
		
		gp.obj[14] = new ShroomR2C2(gp);
		gp.obj[14].worldX = 14 * gp.tileSize;
		gp.obj[14].worldY =  4 * gp.tileSize;

		gp.obj[15] = new ShroomR2C3(gp);
		gp.obj[15].worldX = 15 * gp.tileSize;
		gp.obj[15].worldY =  4 * gp.tileSize;
//		
//		gp.obj[16] = new TruckR1C1(gp);
//		gp.obj[16].worldX = 18 * gp.tileSize;
//		gp.obj[16].worldY =  4* gp.tileSize;
//		
//		gp.obj[17] = new TruckR1C2(gp);
//		gp.obj[17].worldX = 19 * gp.tileSize;
//		gp.obj[17].worldY =  4 * gp.tileSize;
//
//		gp.obj[18] = new TruckR1C3(gp);
//		gp.obj[18].worldX = 20 * gp.tileSize;
//		gp.obj[18].worldY =  4 * gp.tileSize;
//
//		gp.obj[19] = new TruckR2C1(gp);
//		gp.obj[19].worldX = 18 * gp.tileSize;
//		gp.obj[19].worldY =  5* gp.tileSize;
//		
//		gp.obj[20] = new TruckR2C2(gp);
//		gp.obj[20].worldX = 19 * gp.tileSize;
//		gp.obj[20].worldY =  5 * gp.tileSize;
//
//		gp.obj[21] = new TruckR2C3(gp);
//		gp.obj[21].worldX = 20 * gp.tileSize;
//		gp.obj[21].worldY =  5 * gp.tileSize;
//		
		gp.obj[22] = new bbq(gp);
		gp.obj[22].worldX = 23 * gp.tileSize;
		gp.obj[22].worldY =  4 * gp.tileSize;
		
		gp.obj[23] = new bubR1C1(gp);
		gp.obj[23].worldX = 26 * gp.tileSize;
		gp.obj[23].worldY = 3 * gp.tileSize;
		
		gp.obj[24] = new bubR1C2(gp);
		gp.obj[24].worldX = 27 * gp.tileSize;
		gp.obj[24].worldY = 3 * gp.tileSize;
		
		gp.obj[25] = new bubR2C1(gp);
		gp.obj[25].worldX = 26 * gp.tileSize;
		gp.obj[25].worldY = 4 * gp.tileSize;
		
		gp.obj[26] = new bubR2C2(gp);
		gp.obj[26].worldX = 27 * gp.tileSize;
		gp.obj[26].worldY = 4 * gp.tileSize;
		
		gp.obj[27] = new hotdogR1C1(gp);
		gp.obj[27].worldX = 30 * gp.tileSize;
		gp.obj[27].worldY = 3 * gp.tileSize;
		
		gp.obj[28] = new hotdogR1C2(gp);
		gp.obj[28].worldX = 31 * gp.tileSize;
		gp.obj[28].worldY = 3 * gp.tileSize;
		
		gp.obj[29] = new hotdogR2C1(gp);
		gp.obj[29].worldX = 30 * gp.tileSize;
		gp.obj[29].worldY = 4 * gp.tileSize;
		
		gp.obj[30] = new hotdogR2C2(gp);
		gp.obj[30].worldX = 31 * gp.tileSize;
		gp.obj[30].worldY = 4 * gp.tileSize;
				
		gp.obj[31] = new squidR1C1(gp);
		gp.obj[31].worldX = 39 * gp.tileSize;
		gp.obj[31].worldY = 3 * gp.tileSize;
		
		gp.obj[32] = new squidR1C2(gp);
		gp.obj[32].worldX = 40 * gp.tileSize;
		gp.obj[32].worldY = 3 * gp.tileSize;
		
		gp.obj[33] = new squidR2C1(gp);
		gp.obj[33].worldX = 39 * gp.tileSize;
		gp.obj[33].worldY = 4 * gp.tileSize;
		
		gp.obj[34] = new squidR2C2(gp);
		gp.obj[34].worldX = 40 * gp.tileSize;
		gp.obj[34].worldY = 4 * gp.tileSize;
		
		gp.obj[35] = new BoxR1C1(gp);
		gp.obj[35].worldX = 33 * gp.tileSize;
		gp.obj[35].worldY =  3* gp.tileSize;
		
		gp.obj[36] = new BoxR1C2(gp);
		gp.obj[36].worldX = 34 * gp.tileSize;
		gp.obj[36].worldY =  3 * gp.tileSize;

		gp.obj[37] = new BoxR1C3(gp);
		gp.obj[37].worldX = 35 * gp.tileSize;
		gp.obj[37].worldY =  3 * gp.tileSize;

		gp.obj[38] = new BoxR2C1(gp);
		gp.obj[38].worldX = 33 * gp.tileSize;
		gp.obj[38].worldY =  4* gp.tileSize;
		
		gp.obj[39] = new BoxR2C2(gp);
		gp.obj[39].worldX = 34 * gp.tileSize;
		gp.obj[39].worldY =  4 * gp.tileSize;

		gp.obj[40] = new BoxR2C3(gp);
		gp.obj[40].worldX = 35 * gp.tileSize;
		gp.obj[40].worldY =  4 * gp.tileSize;
		
		gp.obj[41] = new can(gp);
		gp.obj[41].worldX = 36 * gp.tileSize;
		gp.obj[41].worldY =  4 * gp.tileSize;
		
		gp.obj[42] = new tankR1C1(gp);
		gp.obj[42].worldX = 42 * gp.tileSize;
		gp.obj[42].worldY = 3 * gp.tileSize;
		
		gp.obj[43] = new tankR1C2(gp);
		gp.obj[43].worldX = 43 * gp.tileSize;
		gp.obj[43].worldY = 3 * gp.tileSize;
		
		gp.obj[44] = new tankR2C1(gp);
		gp.obj[44].worldX = 42 * gp.tileSize;
		gp.obj[44].worldY = 4 * gp.tileSize;
		
		gp.obj[45] = new tankR2C2(gp);
		gp.obj[45].worldX = 43 * gp.tileSize;
		gp.obj[45].worldY = 4 * gp.tileSize;
		
		gp.obj[46] = new OBJ_Crate(gp);
		gp.obj[46].worldX = 53 * gp.tileSize;
		gp.obj[46].worldY = 4 * gp.tileSize;
		
		gp.obj[47] = new can(gp);
		gp.obj[47].worldX = 25 * gp.tileSize;
		gp.obj[47].worldY = 5 * gp.tileSize;
		
		gp.obj[48] = new can(gp);
		gp.obj[48].worldX = 35 * gp.tileSize;
		gp.obj[48].worldY = 5 * gp.tileSize;
		
		gp.obj[49] = new can(gp);
		gp.obj[49].worldX = 55 * gp.tileSize;
		gp.obj[49].worldY = 5 * gp.tileSize;

		gp.obj[47] = new rock(gp);
		gp.obj[47].worldX = 74 * gp.tileSize;
		gp.obj[47].worldY = 5 * gp.tileSize;

	}
	
	public void setMonster() {
		
		gp.monster[0] = new MON_Duwende(gp);
		gp.monster[0].worldX =gp.tileSize*15;
		gp.monster[0].worldY =gp.tileSize*5;
		
		gp.monster[2] = new MON_Cyclops(gp);
		gp.monster[2].worldX =gp.tileSize*30;
		gp.monster[2].worldY =gp.tileSize*5;
	
		gp.monster[1] = new MON_May(gp);
		gp.monster[1].worldX =gp.tileSize*45;
		gp.monster[1].worldY =gp.tileSize*5;
		
		gp.monster[3] = new MON_Ang(gp);
		gp.monster[3].worldX =gp.tileSize*60;
		gp.monster[3].worldY =gp.tileSize*5;
		
		gp.monster[4] = new MON_Engkanto(gp);
		gp.monster[4].worldX =gp.tileSize*82;
		gp.monster[4].worldY =gp.tileSize*4;




	}
}



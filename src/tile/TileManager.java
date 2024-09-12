package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.io.BufferedReader;
import javax.imageio.ImageIO;
import main.UtilityTool;
import main.GamePanel;

public class TileManager {

	GamePanel gp; 
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[430];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap ("/maps/world01.txt");
	}

	public void getTileImage() {
			
		setup(0,"dirt", true);
		setup(1, "path", false);
		setup(2, "sky", true);
		setup(3, "row-1-column-1", false);
		setup(4, "row-1-column-2", false);
		setup(5, "row-1-column-3", false);
		setup(6, "row-1-column-4", false);
		setup(7, "row-1-column-5", false);
		setup(8, "row-1-column-6", false);
		setup(9, "row-1-column-7", false);
		setup(10, "row-1-column-8", false);
		setup(11, "row-1-column-9", false);
		setup(12, "row-1-column-10", false);
		setup(13, "row-1-column-11", false);
		setup(14, "row-1-column-12", false);
		setup(15, "row-1-column-13", false);
		setup(16, "row-1-column-14", false);
		setup(17, "row-1-column-15", false);
		setup(18, "row-1-column-16", false);
		setup(19, "row-1-column-17", false);
		setup(20, "row-1-column-18", false);
		setup(21, "row-1-column-19", false);
		setup(22, "row-1-column-20", false);
		setup(23, "row-1-column-21", false);
		setup(24, "row-1-column-22", false);
		setup(25, "row-1-column-23", false);
		setup(26, "row-1-column-24", false);
		setup(27, "row-1-column-25", false);
		setup(28, "row-1-column-26", false);
		setup(29, "row-1-column-27", false);
		setup(30, "row-1-column-28", false);
		setup(31, "row-1-column-29", false);
		setup(32, "row-1-column-30", false);
		setup(33, "row-1-column-31", false);
		setup(34, "row-1-column-32", false);
		setup(35, "row-1-column-33", false);
		setup(36, "row-1-column-34", false);
		setup(37, "row-1-column-35", false);
		setup(38, "row-1-column-36", false);
		setup(39, "row-1-column-37", false);
		setup(40, "row-1-column-38", false);
		setup(41, "row-1-column-39", false);
		setup(42, "row-1-column-40", false);
		setup(43, "row-1-column-41", false);
		setup(44, "row-1-column-42", false);
		setup(45, "row-1-column-43", false);
		setup(46, "row-1-column-44", false);
		setup(47, "row-1-column-45", false);
		setup(48, "row-1-column-46", false);
		setup(49, "row-1-column-47", false);
		setup(50, "row-1-column-48", false);
		setup(51, "row-1-column-49", false);
		setup(52, "row-1-column-50", false);
		setup(53, "row-1-column-51", false);
		setup(54, "row-1-column-52", false);
		setup(55, "row-1-column-53", false);
		setup(56, "row-1-column-54", false);
		setup(57, "row-1-column-55", false);
		setup(58, "row-1-column-56", false);
		setup(59, "row-1-column-57", false);
		setup(60, "row-1-column-58", false);
		setup(61, "row-1-column-59", false);
		setup(62, "row-2-column-1", false);
		setup(63, "row-2-column-2", false);
		setup(64, "row-2-column-3", false);
		setup(65, "row-2-column-4", false);
		setup(66, "row-2-column-5", false);
		setup(67, "row-2-column-6", false);
		setup(68, "row-2-column-7", false);
		setup(69, "row-2-column-8", false);
		setup(70, "row-2-column-9", false);
		setup(71, "row-2-column-10", false);
		setup(72, "row-2-column-11", false);
		setup(73, "row-2-column-12", false);
		setup(74, "row-2-column-13", false);
		setup(75, "row-2-column-14", false);
		setup(76, "row-2-column-15", false);
		setup(77, "row-2-column-16", false);
		setup(78, "row-2-column-17", false);
		setup(79, "row-2-column-18", false);
		setup(80, "row-2-column-19", false);
		setup(81, "row-2-column-20", false);
		setup(82, "row-2-column-21", false);
		setup(83, "row-2-column-22", false);
		setup(84, "row-2-column-23", false);
		setup(85, "row-2-column-24", false);
		setup(86, "row-2-column-25", false);
		setup(87, "row-2-column-26", false);
		setup(88, "row-2-column-27", false);
		setup(89, "row-2-column-28", false);
		setup(90, "row-2-column-29", false);
		setup(91, "row-2-column-30", false);
		setup(92, "row-2-column-31", false);
		setup(93, "row-2-column-32", false);
		setup(94, "row-2-column-33", false);
		setup(95, "row-2-column-34", false);
		setup(96, "row-2-column-35", false);
		setup(97, "row-2-column-36", false);
		setup(98, "row-2-column-37", false);
		setup(99, "row-2-column-38", false);
		setup(100, "row-2-column-39", false);
		setup(101, "row-2-column-40", false);
		setup(102, "row-2-column-41", false);
		setup(103, "row-2-column-42", false);
		setup(104, "row-2-column-43", false);
		setup(105, "row-2-column-44", false);
		setup(106, "row-2-column-45", false);
		setup(107, "row-2-column-46", false);
		setup(108, "row-2-column-47", false);
		setup(109, "row-2-column-48", false);
		setup(110, "row-2-column-49", false);
		setup(111, "row-2-column-50", false);
		setup(112, "row-2-column-51", false);
		setup(113, "row-2-column-52", false);
		setup(114, "row-2-column-53", false);
		setup(115, "row-2-column-54", false);
		setup(116, "row-2-column-55", false);
		setup(117, "row-2-column-56", false);
		setup(118, "row-2-column-57", false);
		setup(119, "row-2-column-58", false);
		setup(120, "row-2-column-59", false);
		setup(121, "row-3-column-1", true);
		setup(122, "row-3-column-2", true);
		setup(123, "row-3-column-3", true);
		setup(124, "row-3-column-4", true);
		setup(125, "row-3-column-5", true);
		setup(126, "row-3-column-6", true);
		setup(127, "row-3-column-7", true);
		setup(128, "row-3-column-8", true);
		setup(129, "row-3-column-9", true);
		setup(130, "row-3-column-10", true);
		setup(131, "row-3-column-11", true);
		setup(132, "row-3-column-12", true);
		setup(133, "row-3-column-13", true);
		setup(134, "row-3-column-14", true);
		setup(135, "row-3-column-15", true);
		setup(136, "row-3-column-16", true);
		setup(137, "row-3-column-17", true);
		setup(138, "row-3-column-18", true);
		setup(139, "row-3-column-19", true);
		setup(140, "row-3-column-20", true);
		setup(141, "row-3-column-21", true);
		setup(142, "row-3-column-22", true);
		setup(143, "row-3-column-23", true);
		setup(144, "row-3-column-24", true);
		setup(145, "row-3-column-25", true);
		setup(146, "row-3-column-26", true);
		setup(147, "row-3-column-27", true);
		setup(148, "row-3-column-28", true);
		setup(149, "row-3-column-29", true);
		setup(150, "row-3-column-30", true);
		setup(151, "row-3-column-31", true);
		setup(152, "row-3-column-32", true);
		setup(153, "row-3-column-33", true);
		setup(154, "row-3-column-34", true);
		setup(155, "row-3-column-35", true);
		setup(156, "row-3-column-36", true);
		setup(157, "row-3-column-37", true);
		setup(158, "row-3-column-38", true);
		setup(159, "row-3-column-39", true);
		setup(160, "row-3-column-40", true);
		setup(161, "row-3-column-41", true);
		setup(162, "row-3-column-42", true);
		setup(163, "row-3-column-43", true);
		setup(164, "row-3-column-44", true);
		setup(165, "row-3-column-45", true);
		setup(166, "row-3-column-46", true);
		setup(167, "row-3-column-47", true);
		setup(168, "row-3-column-48", true);
		setup(169, "row-3-column-49", true);
		setup(170, "row-3-column-50", true);
		setup(171, "row-3-column-51", true);
		setup(172, "row-3-column-52", true);
		setup(173, "row-3-column-53", true);
		setup(174, "row-3-column-54", true);
		setup(175, "row-3-column-55", true);
		setup(176, "row-3-column-56", true);
		setup(177, "row-3-column-57", true);
		setup(178, "row-3-column-58", true);
		setup(179, "row-3-column-59", true);
		setup(180, "row-4-column-1", true);
		setup(181, "row-4-column-2", true);
		setup(182, "row-4-column-3", true);
		setup(183, "row-4-column-4", true);
		setup(184, "row-4-column-5", true);
		setup(185, "row-4-column-6", true);
		setup(186, "row-4-column-7", true);
		setup(187, "row-4-column-8", true);
		setup(188, "row-4-column-9", true);
		setup(189, "row-4-column-10", true);
		setup(190, "row-4-column-11", true);
		setup(191, "row-4-column-12", true);
		setup(192, "row-4-column-13", true);
		setup(193, "row-4-column-14", true);
		setup(194, "row-4-column-15", true);
		setup(195, "row-4-column-16", true);
		setup(196, "row-4-column-17", true);
		setup(197, "row-4-column-18", true);
		setup(198, "row-4-column-19", true);
		setup(199, "row-4-column-20", true);
		setup(200, "row-4-column-21", true);
		setup(201, "row-4-column-22", true);
		setup(202, "row-4-column-23", true);
		setup(203, "row-4-column-24", true);
		setup(204, "row-4-column-25", true);
		setup(205, "row-4-column-26", true);
		setup(206, "row-4-column-27", true);
		setup(207, "row-4-column-28", true);
		setup(208, "row-4-column-29", true);
		setup(209, "row-4-column-30", true);
		setup(210, "row-4-column-31", true);
		setup(211, "row-4-column-32", true);
		setup(212, "row-4-column-33", true);
		setup(213, "row-4-column-34", true);
		setup(214, "row-4-column-35", true);
		setup(215, "row-4-column-36", true);
		setup(216, "row-4-column-37", true);
		setup(217, "row-4-column-38", true);
		setup(218, "row-4-column-39", true);
		setup(219, "row-4-column-40", true);
		setup(220, "row-4-column-41", true);
		setup(221, "row-4-column-42", true);
		setup(222, "row-4-column-43", true);
		setup(223, "row-4-column-44", true);
		setup(224, "row-4-column-45", true);
		setup(225, "row-4-column-46", true);
		setup(226, "row-4-column-47", true);
		setup(227, "row-4-column-48", true);
		setup(228, "row-4-column-49", true);
		setup(229, "row-4-column-50", true);
		setup(230, "row-4-column-51", true);
		setup(231, "row-4-column-52", true);
		setup(232, "row-4-column-53", true);
		setup(233, "row-4-column-54", true);
		setup(234, "row-4-column-55", true);
		setup(235, "row-4-column-56", true);
		setup(236, "row-4-column-57", true);
		setup(237, "row-4-column-58", true);
		setup(238, "row-4-column-59", true);
		setup(239, "row-1-column-1 2", true);
		setup(240, "row-1-column-2 2", true);
		setup(241, "row-1-column-3 2", true);
		setup(242, "row-1-column-4 2", true);
		setup(243, "row-1-column-5 2", true);
		setup(244, "row-1-column-6 2", true);
		setup(245, "row-1-column-7 2", true);
		setup(246, "row-1-column-8 2", true);
		setup(247, "row-1-column-9 2", true);
		setup(248, "row-1-column-10 2", true);
		setup(249, "row-1-column-11 2", true);
		setup(250, "row-1-column-12 2", true);
		setup(251, "row-1-column-13 2", true);
		setup(252, "row-1-column-14 2", true);
		setup(253, "row-1-column-15 2", true);
		setup(254, "row-1-column-16 2", true);
		setup(255, "row-1-column-17 2", true);
		setup(256, "row-1-column-18 2", true);
		setup(257, "row-1-column-19 2", true);
		setup(258, "row-1-column-20 2", true);
		setup(259, "row-1-column-21 2", true);
		setup(260, "row-1-column-22 2", true);
		setup(261, "row-1-column-23 2", true);
		setup(262, "row-2-column-1 2", true);
		setup(263, "row-2-column-2 2", true);
		setup(264, "row-2-column-3 2", true);
		setup(265, "row-2-column-4 2", true);
		setup(266, "row-2-column-5 2", true);
		setup(267, "row-2-column-6 2", true);
		setup(268, "row-2-column-7 2", true);
		setup(269, "row-2-column-8 2", true);
		setup(270, "row-2-column-9 2", true);
		setup(271, "row-2-column-10 2", true);
		setup(272, "row-2-column-11 2", true);
		setup(273, "row-2-column-12 2", true);
		setup(274, "row-2-column-13 2", true);
		setup(275, "row-2-column-14 2", true);
		setup(276, "row-2-column-15 2", true);
		setup(277, "row-2-column-16 2", true);
		setup(278, "row-2-column-17 2", true);
		setup(279, "row-2-column-18 2", true);
		setup(280, "row-2-column-19 2", true);
		setup(281, "row-2-column-20 2", true);
		setup(282, "row-2-column-21 2", true);
		setup(283, "row-2-column-22 2", true);
		setup(284, "row-2-column-23 2", true);
		setup(285, "row-3-column-1 2", true);
		setup(286, "row-3-column-2 2", true);
		setup(287, "row-3-column-3 2", true);
		setup(288, "row-3-column-4 2", true);
		setup(289, "row-3-column-5 2", true);
		setup(290, "row-3-column-6 2", true);
		setup(291, "row-3-column-7 2", true);
		setup(292, "row-3-column-8 2", true);
		setup(293, "row-3-column-9 2", true);
		setup(294, "row-3-column-10 2", true);
		setup(295, "row-3-column-11 2", true);
		setup(296, "row-3-column-12 2", true);
		setup(297, "row-3-column-13 2", true);
		setup(298, "row-3-column-14 2", true);
		setup(299, "row-3-column-15 2", true);
		setup(300, "row-3-column-16 2", true);
		setup(301, "row-3-column-17 2", true);
		setup(302, "row-3-column-18 2", true);
		setup(303, "row-3-column-19 2", true);
		setup(304, "row-3-column-20 2", true);
		setup(305, "row-3-column-21 2", true);
		setup(306, "row-3-column-22 2", true);
		setup(307, "row-3-column-23 2", true);
		setup(308, "row-4-column-1 2", true);
		setup(309, "row-4-column-2 2", true);
		setup(310, "row-4-column-3 2", true);
		setup(311, "row-4-column-4 2", true);
		setup(312, "row-4-column-5 2", true);
		setup(313, "row-4-column-6 2", true);
		setup(314, "row-4-column-7 2", true);
		setup(315, "row-4-column-8 2", true);
		setup(316, "row-4-column-9 2", true);
		setup(317, "row-4-column-10 2", true);
		setup(318, "row-4-column-11 2", true);
		setup(319, "row-4-column-12 2", true);
		setup(320, "row-4-column-13 2", true);
		setup(321, "row-4-column-14 2", true);
		setup(322, "row-4-column-15 2", true);
		setup(323, "row-4-column-16 2", true);
		setup(324, "row-4-column-17 2", true);
		setup(325, "row-4-column-18 2", true);
		setup(326, "row-4-column-19 2", true);
		setup(327, "row-4-column-20 2", true);
		setup(328, "row-4-column-21 2", true);
		setup(329, "row-4-column-22 2", true);
		setup(330, "row-4-column-23 2", true);
		setup(331, "row-5-column-1 2", true);
		setup(332, "row-5-column-2 2", true);
		setup(333, "row-5-column-3 2", true);
		setup(334, "row-5-column-4 2", true);
		setup(335, "row-5-column-5 2", true);
		setup(336, "row-5-column-6 2", true);
		setup(337, "row-5-column-7 2", true);
		setup(338, "row-5-column-8 2", true);
		setup(339, "row-5-column-9 2", true);
		setup(340, "row-5-column-10 2", true);
		setup(341, "row-5-column-11 2", true);
		setup(342, "row-5-column-12 2", true);
		setup(343, "row-5-column-13 2", true);
		setup(344, "row-5-column-14 2", true);
		setup(345, "row-5-column-15 2", true);
		setup(346, "row-5-column-16 2", true);
		setup(347, "row-5-column-17 2", true);
		setup(348, "row-5-column-18 2", true);
		setup(349, "row-5-column-19 2", true);
		setup(350, "row-5-column-20 2", true);
		setup(351, "row-5-column-21 2", true);
		setup(352, "row-5-column-22 2", true);
		setup(353, "row-5-column-23 2", true);
		setup(354, "row-6-column-1 2", false);
		setup(355, "row-6-column-2 2", false);
		setup(356, "row-6-column-3 2", false);
		setup(357, "row-6-column-4 2", false);
		setup(358, "row-6-column-5 2", false);
		setup(359, "row-6-column-6 2", false);
		setup(360, "row-6-column-7 2", false);
		setup(361, "row-6-column-8 2", false);
		setup(362, "row-6-column-9 2", false);
		setup(363, "row-6-column-10 2", false);
		setup(364, "row-6-column-11 2", false);
		setup(365, "row-6-column-12 2", false);
		setup(366, "row-6-column-13 2", false);
		setup(367, "row-6-column-14 2", false);
		setup(368, "row-6-column-15 2", false);
		setup(369, "row-6-column-16 2", false);
		setup(370, "row-6-column-17 2", false);
		setup(371, "row-6-column-18 2", false);
		setup(372, "row-6-column-19 2", false);
		setup(373, "row-6-column-20 2", false);
		setup(374, "row-6-column-21 2", false);
		setup(375, "row-6-column-22 2", false);
		setup(376, "row-6-column-23 2", false);
		setup(377, "row-7-column-1 2", true);
		setup(378, "row-7-column-2 2", true);
		setup(379, "row-7-column-3 2", true);
		setup(380, "row-7-column-4 2", true);
		setup(381, "row-7-column-5 2", true);
		setup(382, "row-7-column-6 2", true);
		setup(383, "row-7-column-7 2", true);
		setup(384, "row-7-column-8 2", true);
		setup(385, "row-7-column-9 2", true);
		setup(386, "row-7-column-10 2", true);
		setup(387, "row-7-column-11 2", true);
		setup(388, "row-7-column-12 2", true);
		setup(389, "row-7-column-13 2", true);
		setup(390, "row-7-column-14 2", true);
		setup(391, "row-7-column-15 2", true);
		setup(392, "row-7-column-16 2", true);
		setup(393, "row-7-column-17 2", true);
		setup(394, "row-7-column-18 2", true);
		setup(395, "row-7-column-19 2", true);
		setup(396, "row-7-column-20 2", true);
		setup(397, "row-7-column-21 2", true);
		setup(398, "row-7-column-22 2", true);
		setup(399, "row-7-column-23 2", true);
			}
	
	public void setup (int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
	try {
		tile[index] = new Tile ();
		tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imageName +".png"));
		tile[index].image = uTool.scaleImage (tile[index].image, gp.tileSize, gp.tileSize);
		tile[index].collision = collision;
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	public void loadMap(String filePath) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) { 
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) { 
					
					String numbers[] = line.split(",");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				//	System.out.println("col:" + col + "row:" + row + "value:" + num);	
				}
				if(col == gp.maxWorldCol) {
						col = 0;
						row++;
				}
				
			}
			br.close();
			
			
		}catch(Exception e) {
			e.printStackTrace(); {
		}
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
	int worldCol = 0; 
	int worldRow = 0;

		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int  screenX = worldX - gp.player.worldX + gp.player.screenX;
			int  screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenX &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
			// System.out.println("Map Tile Num:" + tileNum);	
			g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			
			}
			
			worldCol++;
	
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
		
					
			}
			
		}
	}
}

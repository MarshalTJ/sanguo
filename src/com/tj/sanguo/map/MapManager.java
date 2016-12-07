package com.tj.sanguo.map;

import com.tj.sanguo.Position;
import com.tj.sanguo.fight.bandit.BanditsNest;

/**
 *  地图管理器
 * @author Administrator
 *
 */
public class MapManager {
	public static MapManager INSTALL = new MapManager();
	private Position[][] worldMap = new Position[400][400];
	private MapManager() {
		init();
	}
	
	// 初始化世界地图
	private void init() {
		for (int i=0; i<400; i++) {
			for (int j=0; j<400; j++) {
				int temp = (int)(Math.random() * 100);
				if (temp < 5) {
					worldMap[i][j] = new BanditsNest(1);
				}
				else if (temp < 9) {
					worldMap[i][j] = new BanditsNest(2);
				}
				else if (temp < 12) {
					worldMap[i][j] = new BanditsNest(3);
				}
				else if (temp < 15) {
					worldMap[i][j] = new BanditsNest(4);
				}
				else if (temp < 18) {
					worldMap[i][j] = new BanditsNest(5);
				}
				else if (temp < 20) {
					worldMap[i][j] = new BanditsNest(6);
				}
				else if (temp < 22) {
					worldMap[i][j] = new BanditsNest(7);
				}
				else if (temp < 24) {
					worldMap[i][j] = new BanditsNest(8);
				}
				else if (temp < 25) {
					worldMap[i][j] = new BanditsNest(9);
				}
				else if (temp < 33) {
					worldMap[i][j] = new Flatland(3, new Position(i, j));
				}
				else if (temp < 47) {
					worldMap[i][j] = new Flatland(2, new Position(i, j));
				}
				else if (temp < 72) {
					worldMap[i][j] = new Flatland(1, new Position(i, j));
				}
				else if (temp < 100) {
					worldMap[i][j] = new Flatland(0, new Position(i, j));
				}
			}
		}
	}
	
}

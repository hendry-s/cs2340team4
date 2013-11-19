package gfx;

import java.util.Random;

public class Map implements java.io.Serializable{

	int[][] map;
	Random r;
	
	public Map(int option) {
		if (option == 0) {	// default map
			map = new int[][] {
					{0,0,1,0,4,0,3,0,0},
					{0,1,0,0,4,0,0,0,3},
					{3,0,0,0,5,0,0,0,1},
					{0,2,0,0,4,0,2,0,0},
					{0,0,2,0,4,0,0,0,2}
			};	// (Plain0) (M1 1) (M2 2) (M3 3) (River 4) (Town 5)
		} else {	// random map
			r = new Random();
			map = new int[][] {
					{r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5)},
					{r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5)},
					{r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), 5, r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5)},
					{r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5)},
					{r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5), r.nextInt(5)}
			};
		}
	}
	
	public int[][] getMap() {
		return map;
	}
	
	
}

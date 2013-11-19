package gfx;

public class MapMuleMount implements java.io.Serializable {
	
	int[][] mapMuleMount;
	
	public MapMuleMount() {
		mapMuleMount = new int[][] {
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,-1,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0}
			};	// (N/A -1) (Unmounted 0) (Energy 1) (Food 2) (Ore 3)
	}
	
	public void setMapMuleMount(int whichMount, int r, int c) {
		mapMuleMount[r][c] = whichMount;
	}
	
	public void unmount(int r, int c) {
		mapMuleMount[r][c] = 0;
	}
	
	public int[][] getMapMuleMount() {
		return mapMuleMount;
	}
}

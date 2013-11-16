package gfx;

public class MapPossession {

	int[][] mapPossession;
	
	public MapPossession() {
		mapPossession = new int[][] {
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,-1,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0}
			};	// (N/A 0) (Unoccupied 0) (OccupiedByPlayer"n" n)
	}
	
	public void setMapPossession(int player, int r, int c) {
		mapPossession[r][c] = player;
	}
	
	public void unpossess(int r, int c) {
		mapPossession[r][c] = 0;
	}
	
	public int[][] getMapPossession() {
		return mapPossession;
	}
}

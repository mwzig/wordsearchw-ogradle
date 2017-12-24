import java.util.ArrayList;

public class GridLine {

	private String gridCharString;
	private ArrayList<LocCoordinate> locCoordinateList;

	public GridLine(String gridCharString, ArrayList<LocCoordinate> locCoordinateList) {
		this.gridCharString = gridCharString;
		this.locCoordinateList = locCoordinateList;
	}
	public String getGridCharString() {
		return gridCharString;
	}
	public ArrayList<LocCoordinate> getGridLocCoordinateList() {
		return locCoordinateList;
	}
	@Override
	public String toString() {
		return "GridLine [gridCharString=" + gridCharString + ", locCoordinateList=" + locCoordinateList + "]";
	}
}

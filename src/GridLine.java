import java.util.ArrayList;

public class GridLine {

	private String lineString;
	private ArrayList<LocCoordinate> locCoordinateList;

	public GridLine(String gridCharString, ArrayList<LocCoordinate> locCoordinateList) {
		this.lineString = gridCharString;
		this.locCoordinateList = locCoordinateList;
	}
	public String getLineString() {
		return lineString;
	}
	public ArrayList<LocCoordinate> getGridLocCoordinateList() {
		return locCoordinateList;
	}
	@Override
	public String toString() {
		return "GridLine [gridCharString=" + lineString + ", locCoordinateList=" + locCoordinateList + "]";
	}
}

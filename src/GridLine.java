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
	
	public GridLine getReverseLine() {

		ArrayList<LocCoordinate> revLocCoordinateList = new ArrayList<LocCoordinate>();
		String reverseLineString = new StringBuilder(lineString).reverse().toString();
		for (int i = reverseLineString.length(); i >=0  ;i--) {
			revLocCoordinateList.add(locCoordinateList.get(i));
		}
		GridLine reverseGridLine = new GridLine(reverseLineString, revLocCoordinateList);
		return reverseGridLine;
	}
	
	@Override
	public String toString() {
		return "GridLine [gridCharString=" + lineString + ", locCoordinateList=" + locCoordinateList + "]";
	}
}

package moviereservation;

public class Movie {

	private int mID;
	private String name;
	private int year;
	private int length;
	

	public Movie() {
		this.mID = 0;
		this.name = "";
		this.year = 0;
		this.length = 0;
	}
	
	public Movie(int mID, String name, int year, int length) {
		this.mID = mID;
		this.name = name;
		this.year = year;
		this.length = length;
	}
	
	public int getmID() {
		return this.mID;
	}

	public String getName() {
		return this.name;
	}

	public int getYear() {
		return this.year;
	}

	public int getLength() {
		return this.length;
	}

}

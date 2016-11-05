
public class Flashcard {
	
	private String frontSide;
	private String backSide;
	
	public Flashcard (String frontSide, String backSide) {
		this.frontSide = frontSide;
		this.backSide = backSide;
	}	
	
	public String toString()
	{
		return this.frontSide + " " + this.backSide;
	}
}

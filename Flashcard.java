public class Flashcard {
	
	private String word;
	private String definition;
	
	
	public Flashcard (String word, String definition) {
		this.word = word;
		this.definition = definition;
	}	
	
	public String toString()
	{
		return this.word + " " + this.definition;
	}
	
	public String getWord () {
		return word;	
	}
	
	public String getDefinition() {
		return definition;
	}
}
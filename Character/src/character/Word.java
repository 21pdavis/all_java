package character;

public class Word {
	private String word;
	private int wordCount;
	
	public Word() {
		word = "";
		wordCount = 0;
	}
	
	public Word(String w, int wCount) {
		word = w;
		wordCount = wCount;
	}
	
	public void setWord(String w) {
		word = w;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWordCount(int wCount) {
		wordCount = wCount;
	}
	
	public int getWordCount() {
		return wordCount;
	}
	
	public void findWordCount(Word[] words) {
		for(int i = 0; words[i] != null; i++) {
			if(word.equals(words[i].getWord()) == true) {
				wordCount++;
			}
		}
	}
	
	public String toString() {
		String output = "";
		
		output = word + " " + wordCount;
		return output;
	}
}

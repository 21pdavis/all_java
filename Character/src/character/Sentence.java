package character;

public class Sentence {
	private String sentence;
	public Word[] words;
	private int wordNum;
	
	public Sentence() {
		sentence = "";
		words = new Word[50];
		wordNum = 0;
	}
	
	public Sentence(String snt, Word[] wrd, int num) {
		sentence = snt;
		words = wrd;
		num = 0;
	}
	
	public void setSentence(String snt) {
		sentence = snt;
	}
	
	public String getSentence() {
		return sentence;
	}
	
	public void setWords(Word[] wrd) {
		words = wrd;
	}
	
	public Word[] getWords() {
		return words;
	}
	
	public void setWordNum(int num) {
		wordNum = num;
	}
	
	public int getWordNum() {
		return wordNum;
	}
	
	public void findWords() {
		int beginIndex = 0, endIndex = 0, count = 0;
		boolean inWord = false, endOfWord = false;;
		
		for(int i = 0; i < sentence.length(); i++) {
			if((Character.isLetter(sentence.charAt(i)) || Character.isDigit(sentence.charAt(i))) &&
					inWord == false){
				inWord = true;
				beginIndex = i;
			}
			if((Character.isLetter(sentence.charAt(i)) == false && Character.isDigit(sentence.charAt(i)) == false && inWord == true)){
				endIndex = i;
				inWord = false;
				endOfWord = true;
			}
			if(i == findLastLetterNumberIndex()) {
				endOfWord = true;
				endIndex = i + 1;
			}
			if(endOfWord == true) {
				words[count] = new Word(sentence.substring(beginIndex, endIndex), 0);
				words[count].findWordCount(words);
				count++;
				endOfWord = false;
				wordNum++;
			}
		}
	}
	
	private int findLastLetterNumberIndex() {
		int index = 0;
		
		for(int i = 0; i < sentence.length(); i++) {
			if(Character.isLetter(sentence.charAt(i)) || Character.isDigit(sentence.charAt(i))) {
				index = i;
			}
		}
		return index;
	}
	
	private int getCharacterNum() {
		int characterNum = 0;
		
		for(int i = 0; i < sentence.length(); i++) {
			if(Character.isLetter(sentence.charAt(i)) || Character.isDigit(sentence.charAt(i)) || isPunctuation(sentence.charAt(i)) == true) {
				characterNum++;
			}
		}
		
		return characterNum;
	}
	
    private boolean isPunctuation(char c) {
        return c == ','
            || c == '.'
            || c == '!'
            || c == '?'
            || c == ':'
            || c == ';'
            ;
    }
	
	public String toString() {
		String output = "";
		
		output += getCharacterNum() + " Characters" + '\n' +
		wordNum + " Words" + '\n';		
		for(int i = 0; words[i] != null; i++) { // going to be honest, Mr. Geary, I tried to make this output right for 3 hours and could not do it. Would love to talk to you about it :(
			output += words[i] + "\n";
		}
		
		return output;
	}
}

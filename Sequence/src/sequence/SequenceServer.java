package sequence;

public class SequenceServer {
	SequenceObj sequence = new SequenceObj();
	public String findSequences(int[] sequence, int length) {
		String output = "The longest non-decreasing sequence is: " + '\n';
		SequenceObj[] sequences = new SequenceObj[25];
		int lastNum = 0, subSequenceNum = 0;
		int subSequenceLength = 0;
		String subSequence = "";
		
		for(int i = 0; i < length; i++) {
			if(i == 0) {
				subSequenceNum++;
				sequences[subSequenceNum-1] = new SequenceObj();
				subSequenceLength++;
				subSequence += sequence[i] + " ";
				sequences[subSequenceNum-1].setLength(subSequenceLength);
				sequences[subSequenceNum-1].setSequence(subSequence);
				lastNum = sequence[i];
			}
			else if(i > 0) {
				if(sequence[i] >= lastNum) {
					subSequenceLength++;
					subSequence += sequence[i] + " ";
					sequences[subSequenceNum-1].setLength(subSequenceLength);
					sequences[subSequenceNum-1].setSequence(subSequence);
					lastNum = sequence[i];
				}
				else if(sequence[i] < lastNum) {
					subSequenceNum++;
					sequences[subSequenceNum-1] = new SequenceObj();
					subSequenceLength = 1;
					subSequence = sequence[i] + " ";
					sequences[subSequenceNum-1].setLength(subSequenceLength);
					sequences[subSequenceNum-1].setSequence(subSequence);
					lastNum = sequence[i];
					continue;
				}
			}
		}
		output += getLongestSequences(sequences, subSequenceNum);
		return output;
	}
	
	private String getLongestSequences(SequenceObj[] sequences, int subSequenceNum) {
		String longestSequences = "";
		int longestLength = sequences[0].getLength();
		
		if(subSequenceNum == 1) {
			longestLength = sequences[0].getLength();
		}
		if(subSequenceNum > 1) {
			for(int i = 0; i < subSequenceNum; i++) {
				if(i == 0)
					longestLength = sequences[i].getLength();
				else if(i > 0) {
					if(sequences[i].getLength() > sequences[i-1].getLength()) {
						longestLength = sequences[i].getLength();
					}
				}
			}
		}
		for(int i = 0; i < subSequenceNum; i++) {
			if(sequences[i].getLength() == longestLength) {
				longestSequences += sequences[i].getSequence() + '\n';
			}
		}
		
		return longestSequences;
	}
}

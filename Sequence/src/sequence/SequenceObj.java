package sequence;

public class SequenceObj {
	private int length;
	private String sequence;
	
	public SequenceObj() {
		length = 0;
		sequence = "";
	}
	
	public SequenceObj(int sqncCount, int lng, int[] nums, String sqnc) {
		length = lng;
		sequence = sqnc;
	}
	
	public void setLength(int lng) {
		length = lng;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setSequence(String sqnc) {
		sequence = sqnc;
	}
	
	public String getSequence() {
		return sequence;
	}
}

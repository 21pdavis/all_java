package linkys;

public class LinkyListys {
	public static void main(String[] args) {
		ListQueue<Integer> numQueue = new ListQueue<Integer>();
		String keyString = "1 3 4";
		String[] numArray = keyString.split(" ");
		
		for(int i = 0; i < numArray.length; i++) {
			numQueue.enqueue(Integer.parseInt(numArray[i]));
		}
		
		System.out.println(numQueue.toString());
		
//		for(int i = 0; i < keyString.length(); i++) {
//			String numString = "";
//			for(int j = i; keyString.charAt(j) != ' '; j++) {
//				numString += keyString.charAt(j);
//				i = j;
//			}
//			System.out.print(numString);
//		}
	}
}

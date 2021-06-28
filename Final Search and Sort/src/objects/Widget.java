package objects;

public class Widget implements Comparable<Widget>{
	private int productNum, numSold;
	
	public Widget() {
		productNum = 0;
		numSold = 0;
	}
	
	public Widget(int productNum, int numSold) {
		this.productNum = productNum;
		this.numSold = numSold;
	}
	
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	public int getProductNum() {
		return productNum;
	}
	
	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}
	
	public int getNumSold() {
		return numSold;
	}
	
	@Override
	public int compareTo(Widget o) {
		return Integer.compare(numSold, o.getNumSold());
	}
	
	public String toString() {
		return "Product Number: " + productNum + ", Number Sold: " + numSold;
	}
}
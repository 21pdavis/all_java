package classes;

import structures.*;

public class TestConsole {
	public static void main(String[] args) throws TreeIsEmptyException {
		BinaryTree tree = new BinaryTree();
		
		//right rotate
//		tree.addElement(9);
//		tree.addElement(7);
//		tree.addElement(11);
//		tree.addElement(5);
//		tree.addElement(8);
//		tree.addElement(4);
//		tree.addElement(6);
//		System.out.println(tree.toStringPostorder());
//		System.out.println(tree.toStringLevelOrder());
//		System.out.println(tree.size());
		
		//left rotate
//		tree.addElement(9);
//		tree.addElement(7);
//		tree.addElement(11);
//		tree.addElement(10);
//		tree.addElement(13);
//		tree.addElement(12);
//		tree.addElement(14);
//		System.out.println(tree.toStringInorder());
//		System.out.println(tree.toStringLevelOrder());
//		System.out.println(tree.size());

		//leftRight dataset
//		tree.addElement(6);
//		tree.addElement(7);
//		tree.addElement(2);
//		tree.addElement(1);
//		tree.addElement(4);
//		tree.addElement(3);
//		tree.addElement(5);
//		System.out.println(tree.size());
//		System.out.println(tree.toStringInorder());
//		System.out.println(tree.toStringLevelOrder());
		
		//rightLeft dataset
		tree.addElement(9);
		tree.addElement(7);
		tree.addElement(13);
		tree.addElement(11);
		tree.addElement(14);
		tree.addElement(10);
		tree.addElement(12);
		System.out.println(tree.size());
		System.out.println(tree.toStringInorder());
		System.out.println(tree.toStringLevelOrder());
		tree.removeElement(12);
		tree.removeElement(14);
		System.out.println(tree.size());
		System.out.println(tree.toStringInorder());
		System.out.println(tree.toStringLevelOrder());
		tree.printHeight();
		
		//removal dataset
//		tree.addElement(9);
//		tree.addElement(7);
//		tree.addElement(13);
//		tree.addElement(11);
//		tree.addElement(14);
//		tree.addElement(10);
//		tree.addElement(12);
//		tree.addElement(6);
//		tree.addElement(2);
//		tree.addElement(8);
//		tree.addElement(5);
//		tree.addElement(1);
//		System.out.println(tree.size());
//		System.out.println(tree.toStringInorder());
//		System.out.println(tree.toStringLevelOrder());
//		tree.removeElement(13);
//		tree.removeElement(12);
//		tree.removeElement(14);
//		System.out.println(tree.size());
//		System.out.println(tree.toStringInorder());
//		System.out.println(tree.toStringLevelOrder());
//		tree.addElement(4);
//		System.out.println(tree.size());
//		System.out.println(tree.toStringInorder());
//		System.out.println(tree.toStringLevelOrder());
		
//		System.out.println(tree.toStringPreorder());
//		System.out.println(tree.toStringPostorder());
//		System.out.println(tree.toStringLevelOrder());
	}
}

// package index;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class IndexNode {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list;

	IndexNode left;
	IndexNode right;

	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int lineNumber) {
		this.word = word;
		this.list = new ArrayList<>();
		this.list.add(lineNumber);
		occurences = 1;
	}

	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line

	public String toString(IndexNode root) {
		if (root == null) {
			return "";
		}
		String output = "";

		output += toString(root.left);
		output += root.word + " ";
		output += toString(root.right);
		return output;
	}

}

package com.greatlearning.balancetree;
import java.util.*;

class BalanceTree{
	static class Node{
		int nodeData;
		Node leftNode, rightNode;
	};
	
	static Node NewNode(int nodeData)
	{
		
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode=null;
		temp.rightNode=null;
		return temp;
	}
	
	public Node insert (Node root, int key)
	{
		if (root==null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode= insert(root.leftNode,key);
		else
			root.rightNode= insert(root.rightNode, key);
		return root;
	}


	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set)
	{
		if (root==null)
			return false;
		if (findpairUtil(root.leftNode, sum, set))
			return true;
		if(set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found("
			+ (sum - root.nodeData) + ","
			+ root.nodeData + ")");
			return true;
	}
	else
		set.add(root.nodeData);
		return findpairUtil(root.rightNode, sum, set);
	}
	
	public boolean findpairUtil1(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		
		if (findpairUtil(root.leftNode, sum, set))
			return true;
		
		if (set.contains (sum -root.nodeData)) {
				System.out.println("Pair is found ("
						+ (sum - root.nodeData) + ","
						+ root.nodeData + ")");
				return true;
				//set.add(root.nodeData);
		}
		else
			set.add (root.nodeData);
		return findpairUtil(root.rightNode, sum, set);
	}
	
public void findPairWithGivenSum(Node root, int sum){
	HashSet<Integer> set = new HashSet<Integer>();
	
	if (!findpairUtil(root, sum, set)) 
		System.out.print("Pairs do not exist"+"\n");
}
//findpairUtil(root, sum, set);

public static void main(String[] args) {

	Node root = null;

	BalanceTree findSP = new BalanceTree();
	root = findSP.insert(root,40);
	root = findSP.insert(root,20);
	root = findSP.insert(root,60);
	
	int sum = 60;
	findSP.findPairWithGivenSum(root,sum);
}
}
	
	

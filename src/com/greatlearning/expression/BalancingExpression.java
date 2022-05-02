package com.greatlearning.expression;

import java.util.Stack;

public class BalancingExpression {
 
 public static void main(String[] args){
 
 String checkBalancedExpr1=checkBalancedParentesis("([[{}]])"); //Sample Input
 System.out.println("The entered String "+checkBalancedExpr1+" Brackets");
 }
 
 public static String checkBalancedParentesis(String expr)
 {
	 if (expr.isEmpty())
		 return "has Balanced";
 
	 Stack<Character> stack = new Stack<Character>();
	 
	 for (int i = 0; i < expr.length(); i++)
	 {
		 char current = expr.charAt(i);
		 if (current == '{' || current == '(' || current == '[')
		 {
			 stack.push(current);
		 }
		 if (current == '}' || current == ')' || current == ']')
		 {
			 if (stack.isEmpty())
			 return "do not contain Balanced Brackets";
			 char last = stack.peek();
			 if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
			 stack.pop();
			 else 
			 return "do not contain Balanced Brackets";
		 }
	 }
	 return stack.isEmpty()?"has Balanced":"do not contain Balanced Brackets";
 }
 
}

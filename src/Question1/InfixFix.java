package Question1;

import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InfixFix {

	public static void main(String[] args) {
		
		String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		
		
		Stack<String> operands = new Stack<String>();
		Stack<Character> operators = new Stack<Character>();
		
		ArrayList<Character> opsToCheckFor = new ArrayList<Character>();
		opsToCheckFor.add('+');
		opsToCheckFor.add('-');
		opsToCheckFor.add('*');
		
		
		for (char c: input.toCharArray()) {
			if(c == ' ')
				continue;
			
			if(opsToCheckFor.contains(c)) {
				operators.push(c);
			
			} else if(c == ')') {
				
				String v1 = "", v2 = "";
				char op1 = ' ', op2 = ' ';
				
				if(!operands.isEmpty()) {
					v1 = operands.pop();
					v2 = operands.pop();
					
				}
				
				if(!operators.isEmpty()) {
					op1 = operators.pop();
					//op2 = operators.pop();
				}
				
				String operand = "(" + v2 + op1 + v1  + c; //+ op2;
				//correctedInfix += subProblem;
				
				operands.push(operand);
				System.out.println("Sub: " + operand);
				
				
			} 
			else {
				operands.push(String.valueOf(c));
			}
		}
		
	
		
		System.out.println("infx: " +operands.pop());
	}
	
}

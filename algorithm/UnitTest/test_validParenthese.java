package UnitTest;

import validParenthesesWDeletion.*;

import org.junit.Test;

import static org.junit.Assert.*;
public class test_validParenthese {
	Solution sln = new Solution();
	DpSolution dpSln = new DpSolution();
	
	@Test
	public void testOne(){
		assertEquals("(a)()", sln.getValidPair("(a))())"));
		assertEquals("(a)()", dpSln.getValidPair("(a))())"));
	}
	
	@Test
	public void testTwo(){
		assertEquals("()()", sln.getValidPair(")()())"));
		assertEquals("()()", dpSln.getValidPair(")()())"));
	}
	
	@Test
	public void testThree(){
		assertEquals("()(9())", sln.getValidPair("()((9())"));
		assertEquals("()(9())", dpSln.getValidPair("()((9())"));
	}
}

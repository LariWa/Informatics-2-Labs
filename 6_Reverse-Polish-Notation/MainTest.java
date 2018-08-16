import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//@author David Panagiotopulos and Larissa Wagnerberger
public class MainTest {
	private Postfix pfx;
	private Stack<Integer> stack;
	private Stack<Integer> emptyStack;

	@Before
	public void setUp() {
		pfx = new Postfix();
		stack = new Stack<>();
		emptyStack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
	}

	@Test
	public void top() throws StackUnderflow {
		assertEquals(stack.top(), new Integer(3));
	}

	@Test
	public void topEmpty() {
		try {
			assertEquals(emptyStack.top(), new StackUnderflow());
		} catch (StackUnderflow ignored) {
		}
	}

	@Test
	public void pop() throws StackUnderflow {
		stack.pop();
		assertEquals(stack.top(), new Integer(2));
	}

	@Test
	public void popEmpty() {
		try {
			emptyStack.pop();
		} catch (StackUnderflow ignored) {
		}
	}

	@Test
	public void evaluatePfx() throws StackUnderflow, PostfixException {
		assertEquals(pfx.evaluatePfx("12+34^-"), "-78");
	}

	@Test
	public void evaluateWrongOperator() {
		try {
			assertEquals(pfx.evaluatePfx("1 2+3 4^--"), new PostfixException());
			assertEquals(pfx.evaluatePfx("-1 2+3 4^"), new PostfixException());
		} catch (StackUnderflow | PostfixException ignored) {
		}
	}

	@Test
	public void evaluateWrongOperand() {
		try {
			assertEquals(pfx.evaluatePfx("1 2+3 4^"), PostfixException.class);
		} catch (StackUnderflow | PostfixException ignored) {
		}
	}

	@Test
	public void evaluateIfx() throws StackUnderflow, PostfixException, InfixException {
		assertEquals(pfx.evaluatePfx(pfx.infixToPostfix("1+2+(2+2)*2")), "11");
	}

	@Test
	public void evaluateIfxWrongOperator() {
		try {
			assertEquals(pfx.evaluatePfx(pfx.infixToPostfix("1+2+(2+2)**2")), new InfixException());
			assertEquals(pfx.evaluatePfx(pfx.infixToPostfix("+1+2+(2+2)*2")), new InfixException());
			assertEquals(pfx.evaluatePfx(pfx.infixToPostfix("1+2+(2+2)*2+")), new InfixException());
		} catch (StackUnderflow | PostfixException | InfixException ignored) {
		}
	}

	@Test
	public void evaluateIfxWrongOperand() {
		try {
			assertEquals(pfx.evaluatePfx(pfx.infixToPostfix("11+2+(2+2)*2")), new InfixException());
		} catch (StackUnderflow | PostfixException | InfixException ignored) {
		}
	}

}
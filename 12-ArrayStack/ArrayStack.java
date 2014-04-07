import static java.lang.System.out;
import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class ArrayStack<E> {
	private int size = 0;
	private Object[] stack = new Object[10];
	
	public boolean empty() {return size == 0;}
	
	public void ensureCapacity(int c) {stack = Arrays.copyOf(stack, c);}
	
	private void grow() {stack = Arrays.copyOf(stack, (int) (1.5 * size));}
	
	public E peek() {
		if (size == 0) {throw new EmptyStackException();}
		return (E) stack[size - 1];
	}
	
	public E pop() {
		if (size == 0) {throw new EmptyStackException();}
		E top = (E) stack[--size];
		stack[size] = null;
		return top;
	}
	
	public E push(E e) {
		if (size == stack.length) {grow();}
		stack[size++] = e;
		return e;
	}
	
	public String toString() {return Arrays.toString(Arrays.copyOf(stack, size));}
	
	public void trimToSize() {stack = Arrays.copyOf(stack, size);}
	
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(0);
		stack.pop();
		out.println(stack);
		for (int i = 0; i < 15; i++) {stack.push(i);}
		out.println(stack);
		out.println(stack.peek());
		for (int i = 0; i < 15; i++) {out.print(stack.pop() + " ");}
		out.println(stack);
	}
}
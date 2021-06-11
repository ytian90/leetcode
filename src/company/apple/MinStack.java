package company.apple;

import java.util.Stack;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=755331&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // https://courses.cs.vt.edu/~cs3114/Summer12/Notes/JavaGenerics.pdf
    // MinStack<T extends Comparable<T>>
    // <T extends Comparable<? super T> >
    /*
    Wildcards:
The symbol '?' is a wildcard.
A wildcard represents an arbitrary class, and is followed by a restriction.
In this case, the restriction is that the arbitrary class must be a superclass of T.
So, this says that T must extend a base class X which is-a Comparable<X>.
So, T is-a Comparable<X>.
So, T implements the required method and all is well
     */
}

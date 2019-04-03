package linear.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void should_push_successfully_when_stack_is_not_full() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(10);
        int[] inputs = new int[]{1, 2, 3, 4};
        // When
        for (int input : inputs) {
            stack.push(input);
        }
        // Then
        stack.display();
        StringBuilder expected = new StringBuilder();
        for (int i = inputs.length - 1; i >= 0; i--) {
            expected.append(inputs[i]).append("\n");
        }
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_push_failed_when_stack_is_full() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(4);
        int[] inputs = new int[]{1, 2, 3, 4, 5};
        // When
        for (int input : inputs) {
            stack.push(input);
        }
        // Then throw exception
    }

    @Test
    public void should_remove_the_top_elem_when_call_pop_and_stack_is_not_empty() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(10);
        int[] inputs = new int[]{1, 2, 3, 4};

        for (int input : inputs) {
            stack.push(input);
        }
        // When
        int topElem = stack.pop();
        // Then
        stack.display();
        StringBuilder expected = new StringBuilder();
        for (int i = inputs.length - 2; i >= 0; i--) {
            expected.append(inputs[i]).append("\n");
        }
        assertEquals(inputs[inputs.length - 1], topElem);
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test(expected = EmptyStackException.class)
    public void should_throw_exception_when_call_pop_and_stack_is_empty() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(10);
        int[] inputs = new int[]{1, 2, 3, 4};

        for (int input : inputs) {
            stack.push(input);
        }
        // When
        for (int i = 0; i < inputs.length; i++) {
            stack.pop();
        }
        stack.pop();
        // Then throw exception
    }

    @Test
    public void should_show_the_top_elem_without_removing_it_when_call_peek() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(10);
        int[] inputs = new int[]{1, 2, 3, 4};

        for (int input : inputs) {
            stack.push(input);
        }
        // When
        int topElem = stack.peek();
        // Then
        stack.display();
        StringBuilder expected = new StringBuilder();
        for (int i = inputs.length - 1; i >= 0; i--) {
            expected.append(inputs[i]).append("\n");
        }
        assertEquals(inputs[inputs.length - 1], topElem);
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test(expected = EmptyStackException.class)
    public void should_throw_exception_when_call_peek_but_stack_is_empty() {
        // Given
        StackInterface<Integer> stack = new ArrayStack<>(10);
        int[] inputs = new int[]{1, 2, 3, 4};

        for (int input : inputs) {
            stack.push(input);
        }
        // When
        for (int i = 0; i < inputs.length; i++) {
            stack.pop();
        }
        stack.peek();
        // Then throw exception
    }
}

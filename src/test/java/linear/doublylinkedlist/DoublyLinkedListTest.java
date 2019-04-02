package linear.doublylinkedlist;

import linear.ListInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
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
    public void should_add_to_the_tail_when_execute_add_action_in_order() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        // When
        for (int i = 0; i < 3; i++) {
            intList.add(i);
        }
        // Then
        intList.display();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            expected
                    .append("prev:")
                    .append(i == 0 ?
                            "null" : i - 1)
                    .append("\tcurr:")
                    .append(i)
                    .append("\tnext:")
                    .append(i == 2 ?
                            "null" : i + 1)
                    .append("\n");
        }
        assertEquals(expected.toString(), outContent.toString());
        assertEquals(3, intList.getLength());
    }

    @Test
    public void should_display_list_is_empty_when_call_display_method_any_add_action_before() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        // When
        intList.display();
        // Then
        assertEquals("List is EMPTY!\n", outContent.toString());
        assertEquals(0, intList.getLength());
    }

    @Test
    public void should_add_021_when_call_add_to_method() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        // When
        for (int i = 0; i < 2; i++) {
            intList.add(i);
        }
        intList.addTo(1, 2);
        // Then
        intList.display();
        StringBuilder expected = new StringBuilder();
        int[] result = new int[]{0, 2, 1};
        for (int i = 0; i < result.length; i++) {
            expected
                    .append("prev:")
                    .append(i == 0 ?
                            "null" : result[i - 1])
                    .append("\tcurr:")
                    .append(result[i])
                    .append("\tnext:")
                    .append(i == result.length - 1 ?
                            "null" : result[i + 1])
                    .append("\n");
        }
        assertEquals(expected.toString(), outContent.toString());
        assertEquals(3, intList.getLength());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_indexOutOfBoundsException_when_add_to_a_position_bigger_than_length() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        // When
        for (int i = 0; i < 2; i++) {
            intList.add(i);
        }
        intList.addTo(-1, 2);
        // Then throw exception
    }

    @Test
    public void should_remove_the_second_elem_when_call_remove_method_with_param_1() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 2; i++) {
            intList.add(i);
        }
        // When
        int removedElem = intList.remove(1);
        // Then
        assertEquals(1, removedElem);
    }

    @Test
    public void should_remove_the_first_elem_when_call_remove_method_with_param_0() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 2; i++) {
            intList.add(i);
        }
        // When
        int removedElem = intList.remove(0);
        // Then
        assertEquals(0, removedElem);
        assertEquals(1, intList.getLength());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_out_of_bounds_exception_when_remove_non_exist_elem_position() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 2; i++) {
            intList.add(i);
        }
        // When
        intList.remove(2);
        // Then throw exception
    }

    @Test
    public void should_replace_the_second_elem_when_call_replace_method_with_param_1() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            intList.add(i);
        }
        // When
        intList.replace(1, 3);
        intList.display();
        // Then
        StringBuilder expected = new StringBuilder();
        int[] result = new int[]{0, 3, 2};
        for (int i = 0; i < result.length; i++) {
            expected
                    .append("prev:")
                    .append(i == 0 ?
                            "null" : result[i - 1])
                    .append("\tcurr:")
                    .append(result[i])
                    .append("\tnext:")
                    .append(i == result.length - 1 ?
                            "null" : result[i + 1])
                    .append("\n");
        }
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test
    public void should_replace_the_first_elem_when_call_replace_method_with_param_0() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            intList.add(i);
        }
        // When
        intList.replace(0, 3);
        intList.display();
        // Then
        StringBuilder expected = new StringBuilder();
        int[] result = new int[]{3, 1, 2};
        for (int i = 0; i < result.length; i++) {
            expected
                    .append("prev:")
                    .append(i == 0 ?
                            "null" : result[i - 1])
                    .append("\tcurr:")
                    .append(result[i])
                    .append("\tnext:")
                    .append(i == result.length - 1 ?
                            "null" : result[i + 1])
                    .append("\n");
        }
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test
    public void should_return_the_first_elem_data_when_call_get_method() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            intList.add(i);
        }
        // When
        int number = intList.get(0);
        // Then
        assertEquals(0, number);
    }

    @Test
    public void should_return_true_if_list_contains_the_input_elem_otherwise_return_false() {
        // Given
        ListInterface<Integer> intList = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
        // When
        boolean containsNine = intList.contains(9);
        boolean containsEleven = intList.contains(11);
        // Then
        assertTrue("Contains 9:", containsNine);
        assertFalse("Not contains 11:", containsEleven);
    }
}

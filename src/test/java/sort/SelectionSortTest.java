package sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectionSortTest {
    @Test
    public void should_sort_right_when_input_is_out_of_order() {
        // Given
        int[] inputs = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        // When
        SelectionSort.sort(inputs);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Then
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], inputs[i]);
        }
    }

    @Test
    public void should_sort_in_asc_and_swap_5_times_when_input_is_out_of_order() {
        // Given
        int[] inputs = {3, 1, 2, 6, 5, 4};
        // When
        SelectionSort.sort(inputs);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        // Then
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], inputs[i]);
        }
    }
}

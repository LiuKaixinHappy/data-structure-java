package sort;

public class SelectionSort {
    public static void sort(int[] inputs) {
        for (int i = 0; i < inputs.length - 1; i++) {
            int min = inputs[i];
            int minIndex = i;
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[j] < min) {
                    min = inputs[j];
                    minIndex = j;
                }
            }
            if (minIndex == i) {
                continue;
            }
            inputs[i] = inputs[i] ^ inputs[minIndex];
            inputs[minIndex] = inputs[i] ^ inputs[minIndex];
            inputs[i] = inputs[i] ^ inputs[minIndex];
        }
    }
}

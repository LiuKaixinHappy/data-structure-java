package sort;

public class InsertionSort {
    public static void sort(int[] inputs) {
        int move = 0;
        for (int j = 1; j < inputs.length; j++) {
            int tmp = inputs[j];
            int i = j - 1;
            while (i >= 0 && inputs[i] > tmp) {
                move++;
                inputs[i + 1] = inputs[i];
                i--;
            }
            inputs[i + 1] = tmp;
        }
        System.out.printf("move %d times in total\n", move);
    }
}

package sort;


public class BubbleSort {


    public static void sort(int[] inputs) {
        int swap = 0;
        for (int j = 0; j < inputs.length; j++) {
            boolean beSwapped = false;
            for (int i = 0; i < inputs.length - 1 - j; i++) {
                if (inputs[i] > inputs[i + 1]) {
                    swap += 1;
                    inputs[i] = inputs[i] ^ inputs[i + 1];
                    inputs[i + 1] = inputs[i] ^ inputs[i + 1];
                    inputs[i] = inputs[i] ^ inputs[i + 1];
                    beSwapped = true;
                }
            }
            if (!beSwapped) {
                break;
            }
        }
        System.out.printf("swap %d times in total\n", swap);
    }
}

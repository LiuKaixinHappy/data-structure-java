package sort;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSortInternally(arr, 0, arr.length - 1);
    }

    private static void quickSortInternally(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(arr, start, end);
        quickSortInternally(arr, start, mid - 1);
        quickSortInternally(arr, mid + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int divider = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                if (divider == i) {
                    divider++;
                } else {
                    int tmp = arr[i];
                    arr[i] = arr[divider];
                    arr[divider] = tmp;
                    divider++;
                }
            }
        }

        int tmp = arr[divider];
        arr[divider] = pivot;
        arr[end] = tmp;

        return divider;
    }
}

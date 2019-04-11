package sort;

public class MergeSort {
    static void sort(int[] arr) {
        mergeSortInternally(arr, 0, arr.length - 1);
    }

    private static void mergeSortInternally(int[] arr, int start, int end) {
        if (start >= end) {
            return ;
        }
        int mid = (start + end) / 2;
        mergeSortInternally(arr, start, mid);
        mergeSortInternally(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int startTmp = start;
        int midTemp = mid + 1;
        int k = 0;
        int[] arrTemp = new int[end - start + 1];
        while (startTmp <= mid && midTemp <= end) {
            if (arr[startTmp] <= arr[midTemp]) {
                arrTemp[k++] = arr[startTmp++];
            } else {
                arrTemp[k++] = arr[midTemp++];
            }
        }

        int leftStart = startTmp;
        int leftEnd = mid;
        if (midTemp <= end) {
            leftStart = midTemp;
            leftEnd = end;
        }

        while (leftStart <= leftEnd) {
            arrTemp[k++] = arr[leftStart++];
        }

        for (startTmp = 0; startTmp <= end - start; startTmp++) {
            arr[start + startTmp] = arrTemp[startTmp];
        }
    }
}

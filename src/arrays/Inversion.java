package arrays;

import java.util.Arrays;

public class Inversion {

    // https://www.geeksforgeeks.org/counting-inversions/

    public static int merge(int[] arr, int start, int middle, int end) {
        int i = start;
        int j = middle+1;
        int newarr[] = new int[end +1 - start];
        int k = 0;
        int output = 0;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                newarr[k] = arr[i];
                i++;
            } else {
                System.out.println(arr[i] + "----"+ arr[j]);
                System.out.println(middle + "---" + start + "---" + i + "---" + j + "----"+ end);
                newarr[k] = arr[j];
                j++;
                output += 1 + middle - i;
                System.out.println("Count Added: " + (1 + middle - i));
             // output += 1 + (middle - i);
            }
            k++;
        }

        while (i <= middle) {
            newarr[k]  = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            newarr[k]  = arr[j];
            j++;
            k++;
        }

        k =0;
        for (i=start; i <= end; i++) {
            arr[i] = newarr[k++];
        }
        System.out.println("Current Array:" + Arrays.toString(arr));
        return output;
    }

    public static int mergeSort(int[] arr, int start, int end) {
        int output = 0;
        if (start < end) {
            int middle = (start + end) / 2;
            output +=  mergeSort(arr, start, middle);
            output += mergeSort(arr, middle + 1, end);
            output += merge(arr, start, middle, end);
        }
        return output;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 20, 6, 4, 5, 3, 2};
        int out = 0;
        out = mergeSort(arr, 0, arr.length-1);

        System.out.println("OUTPUT");
        for(int a : arr) {
            System.out.println(a);
        }

        System.out.println("OUTPUT="+out);

    }
}

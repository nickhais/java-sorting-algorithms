import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingAlgorithmsStream {

  // Bubble Sort
  // Selection Sort
  // Merge Sort
  // Insertion Sort
  // Quick Sort
  // Heap Sort

    // Bubble Sort using iteration (no direct Stream API equivalent)
    public static int[] bubbleSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Selection Sort using iteration (no direct Stream API equivalent)
    public static int[] selectionSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[minIndex] and arr[i]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // Merge Sort using recursion (no direct Stream API equivalent)
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        return IntStream.concat(Arrays.stream(left), Arrays.stream(right))
                .sorted()
                .toArray();
    }

    // Insertion Sort using iteration (no direct Stream API equivalent)
    public static int[] insertionSort(int[] array) {
        int[] arr = array.clone();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // Quick Sort using recursion (no direct Stream API equivalent)
    public static int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int pivot = array[array.length / 2];
        int[] left = Arrays.stream(array).filter(x -> x < pivot).toArray();
        int[] middle = Arrays.stream(array).filter(x -> x == pivot).toArray();
        int[] right = Arrays.stream(array).filter(x -> x > pivot).toArray();

        return IntStream.concat(
                        IntStream.concat(Arrays.stream(quickSort(left)), Arrays.stream(middle)),
                        Arrays.stream(quickSort(right))
                )
                .toArray();
    }

    // Heap Sort using iteration (no direct Stream API equivalent)
    public static int[] heapSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap arr[0] and arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
        return arr;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(array));

        // Bubble Sort
        System.out.println("Bubble Sorted: " + Arrays.toString(bubbleSort(array)));

        // Selection Sort
        System.out.println("Selection Sorted: " + Arrays.toString(selectionSort(array)));

        // Merge Sort
        System.out.println("Merge Sorted: " + Arrays.toString(mergeSort(array)));

        // Insertion Sort
        System.out.println("Insertion Sorted: " + Arrays.toString(insertionSort(array)));

        // Quick Sort
        System.out.println("Quick Sorted: " + Arrays.toString(quickSort(array)));

        // Heap Sort
        System.out.println("Heap Sorted: " + Arrays.toString(heapSort(array)));
    }
}

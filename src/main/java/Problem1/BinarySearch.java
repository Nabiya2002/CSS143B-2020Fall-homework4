package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }
        return binarySearch(data, target, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (data[mid] == target) {
            return mid;
        }

        if (target > data[mid]) {
            return binarySearch(data, target, mid + 1, end);
        }
        return binarySearch(data, target, start, mid - 1);
    }
}

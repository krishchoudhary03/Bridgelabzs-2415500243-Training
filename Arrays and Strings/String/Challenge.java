
import java.util.Arrays;

public class Challenge {

    static int firstMissingPositive(int[] arr) {
        boolean[] seen = new boolean[arr.length + 1];
        for (int num : arr) {
            if (num > 0 && num <= arr.length)
                seen[num] = true;
        }
        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) return i;
        }
        return arr.length + 1;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(arr));

        Arrays.sort(arr);
        System.out.println("Index of 4: " + binarySearch(arr, 4));
    }
}

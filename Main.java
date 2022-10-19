import java.util.*;

class Main {

  // We are given an array containing ‘n’ distinct numbers taken from the range 0
  // to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
  // find the missing number.

  // Example 1:

  // Input: [4, 0, 3, 1]
  // Output: 2
  // Example 2:

  // Input: [8, 3, 5, 2, 4, 6, 0, 1]
  // Output: 7
  private static int findMissingNumber(int[] arr) {
    int i = 0;
    while (i < arr.length) {
      if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
        Main.swap(arr, i, arr[i]);
      } else {
        i++;
      }
    }
    for (i = 0; i < arr.length; i++) {
      if (arr[i] != i)
        return i;
    }
    return arr.length;
  }

  // We are given an unsorted array containing numbers taken from the range 1 to
  // ‘n’. The array can have duplicates, which means some numbers will be missing.
  // Find all those missing numbers.

  // Example 1:

  // Input: [2, 3, 1, 8, 2, 3, 5, 1]
  // Output: 4, 6, 7
  // Explanation: The array should have all numbers from 1 to 8, due to duplicates
  // 4, 6, and 7 are missing.

  private static List<Integer> findAllMissingNumbers(int[] arr) {
    int i = 0;
    while (i < arr.length) {
      if (arr[i] != arr[arr[i] - 1]) {
        Main.swap(arr, i, arr[i] - 1);
      } else {
        i++;
      }
    }

    List<Integer> missingNumbers = new ArrayList<>();

    for (i = 0; i < arr.length; i++) {
      if (arr[i] != i + 1)
        missingNumbers.add(i + 1);
    }

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  public static void main(String[] args) {
    int[] result = new int[] { 8, 3, 5, 2, 4, 6, 0, 1 };
    System.out.println(Main.findMissingNumber(result));

    int[] result2 = new int[] { 2, 3, 1, 8, 2, 3, 5, 1 };
    System.out.println(Main.findAllMissingNumbers(result2));
  }
}
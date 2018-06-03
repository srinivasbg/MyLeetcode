import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Leetcode: 3Sum Given an array S of n integers, are there elements a, b, c in S such that a + b +
 * c = 0? Find all unique triplets in the array which gives the sum of zero. Note: Elements in a
 * triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not
 * contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1)
 */
public class ThreeSum {

  static void threeSum(int[] a) {
    boolean found = false;
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < a.length - 2; i++) {// need at least 3 elements to find a triplet.
      set.clear(); // clear all j values after each i^th iteration.
      for (int j = i + 1; j < a.length; j++) {
        int sum = -(a[i] + a[j]);
        if (set.contains(sum)) {
          found = true;
          System.out.println("Three sum found: " + a[i] + " " + a[j] + " " + sum);
        } else {
          set.add(a[j]);
        }
      }
    }

    if (!found)
      System.out.println("No solution found.");
  }

  static void threeSum1(int[] a) {
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      if (i != 0 && a[i] == a[i - 1]) {
        continue;
      }
      int j = i + 1, k = a.length - 1;
      while (j < k) {
        int sum = a[i] + a[j] + a[k];
        if (sum == 0) {
          System.out.println("Three sum found: " + a[i] + " " + a[j] + " " + a[k]);
          j++;
          k--;
          while (j < k && a[j - 1] == a[j])
            j++;
          while (j < k && a[k + 1] == a[k])
            k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] test = {-1, 0, 1, 2, -1, -4};
    threeSum(test);
    System.out.println();
    threeSum1(test);
  }

}

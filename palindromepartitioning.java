import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class palindromepartitioning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string for palindrome partitioning:");
        String input = scanner.nextLine();
        List<List<String>> result = partition(input);

        System.out.println("All possible palindrome partitions:");
        for (List<String> partition : result) {
            System.out.println(partition);
        }

        scanner.close();
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    public static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition)); 
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            if (isPalindrome(substring)) {
                currentPartition.add(substring);  
                backtrack(s, end, currentPartition, result); 
                currentPartition.remove(currentPartition.size() - 1); 
            }
        }
    }
    
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

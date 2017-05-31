import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Easy311 {
    static boolean isJolly(int[] digits) {
        int len = digits.length;
        if (digits.length < 2) {
            return false;
        }

        Set<Integer> required = new HashSet<>();
        for (int i = 1; i < len; i++) {
            required.add(i);
        }

        for (int i = 0; i < len - 1; i++) {
            int diff = Math.abs(digits[i] - digits[i+1]);
            required.remove(diff);
        }
        return required.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        String result = isJolly(digits) ? "JOLLY" : "NOT JOLLY";
        System.out.println(result);
    }
}
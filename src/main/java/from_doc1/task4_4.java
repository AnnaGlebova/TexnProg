package from_doc1;

import java.math.BigInteger;
import java.util.Scanner;

public class task4_4 {
    static BigInteger getLCM(BigInteger[] array) {
        BigInteger res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = res.divide(res.gcd(array[i])).multiply(array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int N = scanner.nextInt();
        int [] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        int max_gcd = 1;
        for (int i = 0; i < N - 1; i++) {
            int gcd = 1;
            for (int j = 1; j <= array[i] && j <= array[i+1]; j++) {
                if (array[i] % j == 0 && array[i+1] % j == 0) {
                    gcd = j;
                }
                if (gcd > max_gcd)
                    max_gcd = gcd;
            }
        }
        System.out.println("НОД: " + max_gcd);
        //BigInteger lcm = getLCM(array);
        int lcm = 1;
        System.out.println("НОК: " + lcm);
    }
}

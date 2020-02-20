package from_doc1;

import java.util.Scanner;

public class task3_3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественное A:");
        double a = scanner.nextDouble();
        System.out.println("Введите целое B:");
        int b = scanner.nextInt();
        double res = a;
        for(int i = 0; i<b;  i++) {
            res *= a;
            System.out.println(res);
        }
    }
}

package from_doc1;

import java.util.Scanner;

public class task3_4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественное A:");
        double a = scanner.nextDouble();
        System.out.println("Введите целое N:");
        int n = scanner.nextInt();
        for(int i = 1; i<=n; i++) {
            double res = Math.log(i) / Math.log(a);
            if(Math.abs(Math.round(res) - res) < 0.1)
                System.out.println(i);
        }
    }
}

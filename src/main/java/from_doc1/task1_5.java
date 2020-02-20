package from_doc1;

import java.util.Scanner;

public class task1_5 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три числа: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println(a > 0 ? a * a : a);
        System.out.println(b > 0 ? b * b : b);
        System.out.println(c > 0 ? c * c : c);

    }
}

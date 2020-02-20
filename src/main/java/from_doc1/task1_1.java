package from_doc1;

import java.util.Scanner;

public class task1_1 {
    public static  void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a: ");
        double a = scanner.nextDouble();
        System.out.println("Введите b: ");
        double b = scanner.nextDouble();
        double sum = a * a + b * b;
        double sqr = (a + b) * (a + b);
        if (sum > sqr)
        {
            System.out.println("Сумма квадратов");
        }
        else
        {
            System.out.println("Квадрат суммы");
        }
    }
}

package from_doc1;

import java.util.Scanner;

public class task1_3 {
    public static  void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты точки А:");
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        System.out.println("Введите координаты точки В:");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        double A = Math.sqrt(x0 ^ 2 + y0 ^ 2);
        double B = Math.sqrt(x1 ^ 2 + y1 ^ 2);
        if (A > B)
            System.out.println("Наиболее удалена точка А");
        else
            System.out.println("Наиболее удалена точка В");
    }
}

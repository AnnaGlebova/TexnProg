package from_doc1;

import javax.swing.*;
import java.util.Scanner;

public class task1_4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стороны треугольника: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double max = Math.max( Math.max(a, b), Math.max(a, c));
        double pifagor = 0;
        if(max == a)
            pifagor = b * b + c * c;
        else if (max == b)
            pifagor = a * a + c * c;
        else
            pifagor = a * a + b * b;

        if(max * max == pifagor)
            System.out.println("Треугольник прямоугольный");
        else
            System.out.println("Треугольник не прямоугольный");


    }
}

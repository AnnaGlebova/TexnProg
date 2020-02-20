package from_doc1;

import java.util.Scanner;

public class task1_2 {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зарплату: ");
        double salary = scanner.nextDouble();
        System.out.println("Введите стаж: ");
        double years = scanner.nextDouble();
        if(years >= 2 & years < 5)
        {
            System.out.println("Надбавка - 2%");
            System.out.println("Сумма к выплате - " + salary * 0.02);
        }
        if (years >= 5 & years <= 10)
        {
            System.out.println("Надбавка - 5%");
            System.out.println("Сумма к выплате - " + salary * 0.05);
        }

    }
}

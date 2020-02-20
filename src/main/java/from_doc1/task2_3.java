package from_doc1;

import java.util.Scanner;

public class task2_3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = scanner.nextInt();
        while(n % 2 == 0)
            n /= 2;
        if( n != 1)
            System.out.println("Число НЕ является степенью двойки");
        else
            System.out.println("Число является степенью двойки");

    }
}

package from_doc1;

import java.util.Scanner;

public class task3_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите A и B:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = a; i<=b; i++)
            System.out.println(i);
        System.out.println(b-a+1);
    }
}

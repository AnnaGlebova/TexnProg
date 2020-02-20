package from_doc1;

import java.util.Scanner;

public class task3_2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите A и B:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = b-1; i>a; i--)
            System.out.println(i);
        System.out.println(b-a-1);
    }
}

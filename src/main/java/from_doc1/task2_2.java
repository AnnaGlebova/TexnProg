package from_doc1;

import java.util.Scanner;

public class task2_2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++)
        {
            if(i % 5 == 0)
                System.out.println(i);
        }
    }
}

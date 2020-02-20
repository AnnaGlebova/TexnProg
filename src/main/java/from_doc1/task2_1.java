package from_doc1;

import java.util.Scanner;

public class task2_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++)
        {
            if( i % 5 != 0 & i % 3 == 0)
            {
                int m = i;
                int sum = 0;
                while(m != 0)
                {
                    sum += m % 10;
                    m = m/10;
                }
                if(sum % 5 != 0 & sum % 3 == 0)
                    System.out.println(i);
            }
        }
    }
}

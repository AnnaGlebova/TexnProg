package from_doc1;

import java.util.Scanner;

public class task2_4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = scanner.nextInt();
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        while(n2 + n0 <= n){
            n2=n0+n1;
            n0=n1;
            n1=n2;
            System.out.println(n2);
        }
    }
}

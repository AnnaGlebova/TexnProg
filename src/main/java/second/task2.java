package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементтов:");
        int n = scanner.nextInt();

        System.out.println("Введите элементы:");
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            sum += x;
        }
        System.out.println(sum);
    }
}

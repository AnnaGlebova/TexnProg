package from_doc1;

import java.util.Scanner;

public class task4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Четные числа: ");
        for (int i = 0; i < N; i++)
        {
            if(array[i] % 2 == 0)
                System.out.println(array[i]);
        }
        System.out.println("Нечетные числа: ");
        for (int i = 0; i < N; i++)
        {
            if(array[i] % 2 != 0)
                System.out.println(array[i]);
        }

    }
}

package from_doc1;

import java.util.Scanner;

public class task4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int N = scanner.nextInt();
        System.out.println("Введите числа: ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Делятся на 5 или на 10: ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 5 == 0 || array[i] % 10 == 0)
                System.out.println(array[i]);
        }
    }
}

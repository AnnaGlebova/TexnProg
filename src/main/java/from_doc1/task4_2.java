package from_doc1;

import java.util.Scanner;

public class task4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int N = scanner.nextInt();
        System.out.println("Введите числа: ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Делятся на 3 или на 9: ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 3 == 0 || array[i] % 9 == 0)
                System.out.println(array[i]);
        }
    }
}

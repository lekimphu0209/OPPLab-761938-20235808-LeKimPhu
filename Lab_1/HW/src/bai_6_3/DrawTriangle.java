package bai_6_3;
import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap chieu cao tam giac");
        int n = scanner.nextInt();
        // draw triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}

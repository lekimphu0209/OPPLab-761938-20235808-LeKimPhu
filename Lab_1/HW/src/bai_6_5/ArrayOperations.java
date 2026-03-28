import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();

        double[] a = new double[n];

        // nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextDouble();
        }

        // sắp xếp
        Arrays.sort(a);

        // tính tổng
        double tong = 0;
        for (double x : a) tong += x;

        double tb = tong / n;

        // in kết quả
        System.out.println("\nMảng sau khi sắp xếp: " + Arrays.toString(a));
        System.out.println("Tổng = " + tong);
        System.out.println("Trung bình = " + String.format("%.2f", tb));
        System.out.println("Min = " + a[0]);
        System.out.println("Max = " + a[n - 1]);

        sc.close();
    }
}
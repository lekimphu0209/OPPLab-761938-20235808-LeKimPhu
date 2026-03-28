package bai_6_6;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CỘNG HAI MA TRẬN ===");

        // nhập kích thước
        System.out.print("Nhập số dòng: ");
        int m = sc.nextInt();

        System.out.print("Nhập số cột: ");
        int n = sc.nextInt();

        double[][] A = new double[m][n];
        double[][] B = new double[m][n];
        double[][] C = new double[m][n];

        // nhập ma trận A
        System.out.println("\nNhập ma trận A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextDouble();
            }
        }

        // nhập ma trận B
        System.out.println("\nNhập ma trận B:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = sc.nextDouble();
            }
        }

        // cộng ma trận
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // in kết quả
        System.out.println("\nMa trận A:");
        inMaTran(A);

        System.out.println("\nMa trận B:");
        inMaTran(B);

        System.out.println("\nA + B:");
        inMaTran(C);

        sc.close();
    }

    // hàm in ma trận
    public static void inMaTran(double[][] M) {
        for (double[] hang : M) {
            for (double x : hang) {
                System.out.printf("%6.2f ", x);
            }
            System.out.println();
        }
    }
}
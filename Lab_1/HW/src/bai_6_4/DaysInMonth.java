package bai_6_4;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m, y;

        // ===== Nhập tháng =====
        while (true) {
            System.out.print("Nhập tháng (1-12): ");
            m = scanner.nextInt();

            if (m >= 1 && m <= 12) {
                break;
            } else {
                System.out.println("Tháng không hợp lệ! Nhập lại.");
            }
        }

        // ===== Nhập năm =====
        while (true) {
            System.out.print("Nhập năm (>=0): ");
            y = scanner.nextInt();

            if (y >= 0) {
                break;
            } else {
                System.out.println("Năm không hợp lệ! Nhập lại.");
            }
        }

        // ===== Kiểm tra năm nhuận =====
        boolean namNhuan = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);

        // ===== Tính số ngày =====
        int days;
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = namNhuan ? 29 : 28;
                break;
            default:
                days = 0;
        }

        // ===== In kết quả =====
        System.out.println("Tháng: " + m);
        System.out.println("Năm: " + y);
        System.out.println("Năm nhuận: " + (namNhuan ? "Có" : "Không"));
        System.out.println("Số ngày: " + days);

        scanner.close();
    }
}
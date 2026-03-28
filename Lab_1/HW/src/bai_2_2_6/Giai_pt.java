package bai_2_2_6;
import javax.swing.JOptionPane;

public class Giai_pt {
    public static void main(String[] args){
        String menu = "1. PT bậc 1\n" +
                "2. Hệ PT bậc nhất\n" +
                "3. PT bậc 2";

        String choiceStr = JOptionPane.showInputDialog(null, menu,
                "Giải phương trình", JOptionPane.QUESTION_MESSAGE);

        int choice = Integer.parseInt(choiceStr);

        switch(choice){
            case 1:
                giaiPTBac1();
                break;
            case 2:
                giaiHePT();
                break;
            case 3:
                giaiPTBac2();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Không hợp lệ");
        }
    }

    // PT bậc 1: ax + b = 0
    public static void giaiPTBac1(){
        String strA = JOptionPane.showInputDialog("Nhập a:");
        String strB = JOptionPane.showInputDialog("Nhập b:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        String ketQua;
        if (a == 0) {
            if (b == 0) {
                ketQua = "Vô số nghiệm";
            } else {
                ketQua = "Vô nghiệm";
            }
        } else {
            double x = -b / a;
            ketQua = "Nghiệm: x = " + String.format("%.2f", x);
        }

        JOptionPane.showMessageDialog(null, ketQua, "Kết quả",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Hệ PT bậc nhất 2 ẩn
    public static void giaiHePT(){
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

        double D  = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;

        String kq;
        if (D != 0){
            double x = D1 / D;
            double y = D2 / D;
            kq = String.format("x = %.2f\ny = %.2f", x, y);
        } else {
            if (D1 == 0 && D2 == 0)
                kq = "Vô số nghiệm";
            else
                kq = "Vô nghiệm";
        }

        JOptionPane.showMessageDialog(null, kq);
    }

    // PT bậc 2
    public static void giaiPTBac2(){
        double a = Double.parseDouble(JOptionPane.showInputDialog("a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("c:"));

        String kq;

        if (a == 0){
            if (b == 0){
                if (c == 0) kq = "Vô số nghiệm";
                else kq = "Vô nghiệm";
            } else {
                double x = -c / b;
                kq = "PT bậc 1, x = " + x;
            }
        } else {
            double delta = b*b - 4*a*c;

            if (delta < 0){
                kq = "Vô nghiệm";
            } else if (delta == 0){
                double x = -b/(2*a);
                kq = "Nghiệm kép x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta))/(2*a);
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                kq = "x1 = " + x1 + "\nx2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, kq);
    }
}
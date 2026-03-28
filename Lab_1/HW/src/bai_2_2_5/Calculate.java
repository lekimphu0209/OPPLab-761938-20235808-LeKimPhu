package bai_2_2_5;
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args){
        // nhap
        String strNum1 = JOptionPane.showInputDialog(
             null , "Nhap so thu nhat:","input", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        String strNum2 = JOptionPane.showInputDialog(
                null , "Nhap so thu hai:","input", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        // tinh toan
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;

        String kq;
        if(num2 != 0){
            kq = String.format("%.2f", num1 / num2);
        }else{
            kq = "Khong chia duoc (chia cho 0)";
        }

        // hien thi
        String result = String.format(
                "===== RESULTS =====\n" +
                        "First number: %.2f\n" +
                        "Second number: %.2f\n" +
                        "Sum: %.2f\n" +
                        "Difference: %.2f\n" +
                        "Product: %.2f\n" +
                        "Quotient: %s",
                num1, num2, sum, diff, prod, kq );
        JOptionPane.showMessageDialog(null, result, "Result",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

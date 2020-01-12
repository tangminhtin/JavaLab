package j1.s.p0009;

import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0009 {

    private final Scanner scanner = new Scanner(System.in);

    private int menu() {
        int choice = 0;

        System.out.println("======= Calculator Program =======");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");

        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("Please input number in rage [1,3]");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("You must enter digit only!");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public double inputNum(String msg, String err) {
        double num = 0;
        while (true) {
            try {
                System.out.print(msg);
                num = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.print(err);
                scanner.nextLine();
            }
        }
        return num;
    }

    public String inputOperator() {
        String op = null;
        while (true) {
            System.out.print("Enter Operator: ");
            op = scanner.nextLine();
            if (op.equals("+") || op.equals("-") || op.equals("*")
                    || op.equals("/") || op.equals("^") || op.equals("=")) {
                break;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        }
        return op;
    }

    public static void main(String[] args) {
        J1SP0009 obj = new J1SP0009();
        Calculator calculator = new Calculator();

        while (true) {
            int choice = obj.menu();
            switch (choice) {
                case 1:
                    calculator.normalCalculator(obj);
                    break;
                case 2:
                    calculator.BMICalculator(obj);
                    break;
                case 3:
                    return;
            }
        }
    }
}

package j1.s.p0009;

/**
 *
 * @author tangminhtin
 */
public class Calculator {

    private void result(String msg, double result) {
        System.out.printf("%s %.2f\n", msg, result);
    }

    public void normalCalculator(J1SP0009 obj) {
        double memory = obj.inputNum("Enter number: ", "");

        while (true) {
            String op = obj.inputOperator();
            switch (op) {
                case "+":
                    memory += obj.inputNum("Enter number: ", "");
                    result("Memory: ", memory);
                    break;
                case "-":
                    memory -= obj.inputNum("Enter number: ", "");
                    result("Memory: ", memory);
                    break;
                case "*":
                    memory *= obj.inputNum("Enter number: ", "");
                    result("Memory: ", memory);
                    break;
                case "/":
                    memory /= obj.inputNum("Enter number: ", "");
                    result("Memory: ", memory);
                    break;
                case "^":
                    memory = Math.pow(memory, obj.inputNum("Enter number: ", ""));
                    result("Memory: ", memory);
                    break;
                case "=":
                    result("Memory: ", memory);
                    return;
                default:
                    break;
            }
        }
    }

    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public void BMICalculator(J1SP0009 obj) {
        double weight = obj.inputNum("Enter Weight(kg): ", "BMI is digit \n");
        double height = obj.inputNum("Enter Height(cm): ", "BMI is digit \n");

        double bmi = weight * 10000 / (height * height);
        result("BMI Number: ", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}

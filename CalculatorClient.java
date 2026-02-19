import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) registry.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            System.out.println("1.Add  2.Subtract  3.Multiply  4.Divide");
            System.out.print("Choose operation: ");
            int choice = sc.nextInt();

            double result = 0;

            switch (choice) {
                case 1:
                    result = calc.add(a, b);
                    break;
                case 2:
                    result = calc.subtract(a, b);
                    break;
                case 3:
                    result = calc.multiply(a, b);
                    break;
                case 4:
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(0);
            }

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


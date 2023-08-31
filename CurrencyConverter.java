import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount in Indian Ruppees (INR) : ");
        double inrAmount = scanner.nextDouble();

        double exchangeRate = 0.012; 

        double usdAmount = inrAmount * exchangeRate;

        System.out.println("Equivalent amount in USD: " + usdAmount);

        scanner.close();
    }
}

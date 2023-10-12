import java.util.Scanner;
import java.util.ArrayList;

// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it
        //intializing Variables
        Scanner scan = new Scanner(System.in);
        ArrayList<String> dishes = new ArrayList<String>();
        double price = 0;
        double sum = 0;
        boolean ordering = true;
        double giftCard = 0;


        //Asking for group size and tip percent
        System.out.println("Hello and welcome, how many people are in your group?");
        int people = scan.nextInt();
        scan.nextLine();

        System.out.println("What percent will you be tipping?");
        int tipPercent = scan.nextInt();
        scan.nextLine();


        //Gift card Free style
        System.out.println("Do you have an giftcard at this establishment?");
        String tempStr = scan.nextLine();
        if (tempStr.equals("yes")) {
            System.out.println("Great! How much value does it have or are willing to spend?");
            giftCard = scan.nextDouble();
            scan.nextLine();


        } else if (tempStr.equals("no")) {
            System.out.println("That's fine, lets proceed.");
        }

        //Ordering dishes

        while (ordering == true) {
            System.out.println(" ");
            System.out.println("What is the price of this dish, including cents, please enter '-1' if you are done");
            double tempPrice = scan.nextDouble();
            scan.nextLine();
            if (tempPrice != -1) {
                price = tempPrice;
                sum += price;
                System.out.println("What is the name of the dish?");
                dishes.add(scan.nextLine());
            } else if (tempPrice == -1) {
                System.out.println("Alright, finished ordering dishes.");
                ordering = false;
            } else {
                System.out.println("Please enter an valid price");
            }
        }

        // Printing result

        System.out.println("You ordered: ");
        for (String i : dishes) {
            System.out.println(i);
        }

        //Calculating Bill
        double tip = (sum * (tipPercent / 100));
        double endTotalBill = (double) ((int)((sum - giftCard + tip) * 100))/100;
        System.out.println("The total including tip is: " + (tip + sum));

        if (giftCard != 0) {
            System.out.println("However, since you have an gift card, the total bill be: " + endTotalBill);

        }

        if (people > 1) {
            System.out.println("You individually will be paying: " + (double) ((int)(((endTotalBill / people) * 100)))/100);
        }



    }
}
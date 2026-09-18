import java.util.Scanner;
/* Valerie Kuttler
CMPINF 401--SEC 1200
Ye olde tavern ordering system! */
public class tavern {
    public static void main(String[] args) {
        String continued = "y";
        while(continued.equalsIgnoreCase("y")){
        boolean isPubber = false;
        int numTarts = 0;
        int numPints = 0;
        int numBread = 0;
        // Prices are in pence
        double pint = 60;
        double breadncheese = 120;
        double custTart = 72;
        double custTartDoz = 720;
        double mealDeal = 168;
        String yn;
        String yn2;
        String psp;
        String yn3 = "y";
        Scanner k = new Scanner(System.in);
        System.out.println("Is there a customer to be waited on? (y/n)");
        yn = k.nextLine();
        if (yn.equalsIgnoreCase("n")) {
            System.out.println("Ok goodbye");
            System.exit(0);
        } else {
            System.out.println("Welcome to The Lynx and Newt!");
        }
        System.out.println("Are you a Preferred Pubber? (y/n)");
        yn2 = k.nextLine();
        if (yn2.equalsIgnoreCase("y")) {
            for (int i = 0; i < 2; i++) {
                System.out.print("PASSWORD: ");
                String pw = k.nextLine();
                if (pw.equals("WEASEL")) {
                    isPubber = true;
                    System.out.println(
                        "Congrats, you're in! You will now receive discounted prices."
                    );
                    break;
                } else if (i == 0) {
                    System.out.println("Try again.");
                } else {
                    System.out.println(
                        "Sorry, you are not a pubber. You will not receive the discount."
                    );
                }
            }
        }
        if (isPubber) { //applying discount for pubbers
            pint = 55;
            breadncheese = 90;
            custTartDoz = 660;
            mealDeal = 156;
        }
        System.out.println(
            "Would you like to view the item prices in pence, shillings, or pounds?");
        psp = k.nextLine();
        while (!psp.equalsIgnoreCase("pence")
                && !psp.equalsIgnoreCase("shillings")
                && !psp.equalsIgnoreCase("pounds")) {
            System.out.println("Sorry, I didn't understand. Try again.");
            psp = k.nextLine();
        }
        switch (psp.toLowerCase()) {
            case "pence":
                pMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
            case "shillings":
                sMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
            case "pounds":
                lbMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
        }
        System.out.println();
        System.out.println("NOTE: you can say show subtotal at any time to see your current subtotal.");
        System.out.println("OR say update to update your order.");
        while (yn3.equalsIgnoreCase("y")) {
            System.out.println("So, what would you like to order?");
            String ord = k.nextLine().toLowerCase();
            switch (ord) {
                case "pint":
                case "mead":
                case "pint of mead":
                    System.out.println("How many would you like?");
                    numPints += Integer.parseInt(k.nextLine());
                    break;
                case "bread and cheese":
                    System.out.println("How many would you like?");
                    numBread += Integer.parseInt(k.nextLine());
                    break;
                case "custard":
                case "tart":
                case "custard tart":
                    System.out.println("How many would you like?");
                    numTarts = Integer.parseInt(k.nextLine());
                    break;
                case "meal":
                case "meal deal":
                    System.out.println("How many would you like?");
                    int meals = Integer.parseInt(k.nextLine());
                    /*
                     * A meal deal is one pint + one bread and cheese.
                     * We add the quantities to the order here.
                     */
                    numPints += meals;
                    numBread += meals;
                    break;
                case "show subtotal":
                    System.out.println(
                        "Your current subtotal is "
                        + calculateSubtotal(numPints,numBread,numTarts,pint,breadncheese,custTart,custTartDoz,mealDeal)+ " pence.");
                    break;
                case "update":
                    System.out.println("Your current order is:");
                    System.out.println(numPints + " pints of mead");
                    System.out.println(numBread + " orders of bread and cheese");
                    System.out.println(numTarts + " custard tarts");
                    System.out.println("What would you like to change? (mead/bread/tarts)");
                    String change = k.nextLine();
                    System.out.println("NOTE: This will change the total amount to the new number inputted, not add.");
                        switch (change.toLowerCase()) {
                            case "mead":
                                System.out.print("Amount of pints of mead you would REALLY like: ");
                                numPints = Integer.parseInt(k.nextLine());
                                break;
                            case "bread":
                            System.out.print("Amount of orders of bread and cheese you would REALLY like: ");
                                numBread = Integer.parseInt(k.nextLine());
                                break;
                            case "tarts":
                                System.out.print("Amount of custard tarts you would REALLY like: ");
                                numTarts = Integer.parseInt(k.nextLine());
                                break;
                            default:
                                System.out.println("Sorry, I didn't catch that.");
                                break;
                    }
                    break;
                default:
                    System.out.println("Sorry, I didn't understand that.");
                    continue;
            }
            double subtotal = calculateSubtotal(numPints,numBread,numTarts,pint,breadncheese,custTart,custTartDoz,mealDeal);
            System.out.println("Current subtotal: " + subtotal + " pence");
            System.out.println("Anything else? (y/n)");
            yn3 = k.nextLine();
            /*
             * Allows the customer to type "show subtotal"
             * instead of only y/n.
             */
            while (yn3.equalsIgnoreCase("show subtotal")) {
                subtotal = calculateSubtotal(numPints,numBread,numTarts,pint,breadncheese,custTart,custTartDoz,mealDeal);
                System.out.println("Your current subtotal is "+ subtotal+ " pence.");
                System.out.println("Anything else? (y/n)");
                yn3 = k.nextLine();
            }
        }
            while (yn3.equalsIgnoreCase("update")){
                System.out.println("What would you like to change? (mead/bread/tarts)");
                    String change = k.nextLine();
                    System.out.println("NOTE: This will change the total amount to the new number inputted, not add.");
                        switch (change.toLowerCase()) {
                            case "mead":
                                System.out.print("Amount of pints of mead you would REALLY like: ");
                                numPints = Integer.parseInt(k.nextLine());
                                break;
                            case "bread":
                            System.out.print("Amount of orders of bread and cheese you would REALLY like: ");
                                numBread = Integer.parseInt(k.nextLine());
                                break;
                            case "tarts":
                                System.out.print("Amount of custard tarts you would REALLY like: ");
                                numTarts = Integer.parseInt(k.nextLine());
                                break;
                            default:
                                System.out.println("Sorry, I didn't catch that.");
                                break;
                    }
            }
        double subtotal = calculateSubtotal(numPints,numBread,numTarts,pint,breadncheese,custTart,custTartDoz,mealDeal);
        System.out.println("Your subtotal is " + subtotal + " pence");
        while (subtotal > 0) {
            System.out.println("How would you like to pay? (pence/shillings/pounds)");
            String payType = k.nextLine();
            System.out.print("Insert payment amount: ");
            double payment;
            if (payType.equalsIgnoreCase("pence")) {
                payment = Double.parseDouble(k.nextLine());
                subtotal -= payment;
            } else if (payType.equalsIgnoreCase("shillings")) {
                payment = Double.parseDouble(k.nextLine());
                subtotal -= payment * 12;
            } else if (payType.equalsIgnoreCase("pounds")) {
                payment = Double.parseDouble(k.nextLine());
                subtotal -= payment * 240;
            } else {
                System.out.println("Sorry, I didn't understand that.");
                continue;
            }
            System.out.println("Current balance: " + subtotal + " pence");
        }
        if (subtotal < 0) {
            System.out.println("Your change is "+ (-1 * subtotal)+ " pence");
        }
        System.out.println();
        System.out.println("Would you like to run the program again? (y/n)");
        continued = k.nextLine();
    }
}
//subtotal calculation
    public static double calculateSubtotal(int numPints,int numBread,int numTarts,double pint,double breadncheese,double custTart,double custTartDoz,double mealDeal) {
        /*
         * Pair pints and bread/cheese into meal deals first.
         */
        int convertedMeals = Math.min(numPints, numBread);
        double subtotal = 0;
        subtotal += convertedMeals * mealDeal;
        subtotal += (numPints - convertedMeals) * pint;
        subtotal += (numBread - convertedMeals) * breadncheese;
        /*
         * Buy as many full dozens of tarts as possible,
         * then charge the remaining individual tarts.
         */
        int dozens = numTarts / 12;
        int leftovers = numTarts % 12;
        subtotal += dozens * custTartDoz;
        subtotal += leftovers * custTart;
        return subtotal;
    }
//pence menu
    public static void pMenu(double pint,double breadncheese,double custTart,double custTartDoz,double mealDeal) {
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("PINT OF MEAD: " + pint + " PENCE");
        System.out.println("BREAD AND CHEESE: " + breadncheese + " PENCE");
        System.out.println("CUSTARD TART: " + custTart + " PENCE");
        System.out.println("DOZEN OF CUSTARD TARTS: "+ custTartDoz+ " PENCE");
        System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): "+ mealDeal+ " PENCE");
    }
    //shillings menu
    public static void sMenu(double pint,double breadncheese,double custTart,double custTartDoz,double mealDeal) {
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("PINT OF MEAD: " + pint / 12 + " SHILLINGS");
        System.out.println("BREAD AND CHEESE: "+ breadncheese / 12+ " SHILLINGS");
        System.out.println("CUSTARD TART: "+ custTart / 12 + " SHILLINGS");
        System.out.println("DOZEN OF CUSTARD TARTS: "+ custTartDoz / 12+ " SHILLINGS");
        System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): "+ mealDeal / 12+ " SHILLINGS");
    }
    //pounds menu
    public static void lbMenu(double pint,double breadncheese, double custTart,double custTartDoz,double mealDeal) {
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("PINT OF MEAD: " + pint / 240 + " POUNDS");
        System.out.println("BREAD AND CHEESE: "+ breadncheese / 240+ " POUNDS");
        System.out.println("CUSTARD TART: "+ custTart / 240+ " POUNDS");
        System.out.println("DOZEN OF CUSTARD TARTS: "+ custTartDoz / 240+ " POUNDS" );
        System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): "+ mealDeal / 240 + " POUNDS");
    }
}
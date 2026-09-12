import java.util.Scanner;

/* Valerie Kuttler
CMPINF 401--SEC 1200
Ye olde tavern ordering system! */
public static void main(String[] args) {
    boolean isPubber = false;
    int numTarts = 0, numPints = 0, numBread = 0;
    double pint = 60, breadncheese = 120, custTart = 72, custTartDoz = 720, mealDeal = 168; //initializing menu item prices in pence
    double subtotal = 0;
    String yn, yn2, pw = "j", psp = "j", yn3 = "y", ord = "n";
    Scanner k = new Scanner(System.in);
    System.out.println("Is there a customer to be waited on? (y/n)");
    yn = k.nextLine();
    if(yn.equalsIgnoreCase("n")){
        System.out.println("Ok goodbye");
        System.exit(0); //ends program
    } else {
        System.out.println("Welcome to The Lynx and Newt!");
    }
    System.out.println("Are you a Preferred Pubber? (y/n)");
    yn2 = k.nextLine();
    if (yn2.equalsIgnoreCase("n")) {
        isPubber = false;
    } else {
        for (int i = 0; i<2; i++){
            System.out.print("PASSWORD: ");
            pw = k.nextLine();
                if (pw.equals("WEASEL")){
                    isPubber = true;
                    System.out.println("Congrats, you're in! You will now receive discounted prices.");
                    break;
                } else if (!(pw.equals("WEASEL")) && i==0) {
                    System.out.println("Try again.");
                } else {
                    System.out.println("Sorry, you are not a pubber. You will not receive the discount.");
                }
            }
            } 
    if(isPubber){ //applying discount prices for pubbers
        pint = 55;
        breadncheese = 90;
        custTartDoz = 660;
        mealDeal = 156;
    }
    //1 shilling = 12 pence, 1 pound = 20 shillings = 240 pence
    System.out.println("Would you like to view the item prices in pence, shillings, or pounds?");
    psp = k.nextLine();
        switch (psp.toLowerCase()){
            case "pence":
                pMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
            case "shillings":
                sMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
            case "pounds":
                lbMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
                break;
            default:
                System.out.println("Sorry, I didn't understand. Try again.");
                psp = k.nextLine();
                break;
        }
        System.out.println();
        System.out.println("NOTE: you can say show subtotal at any time to see your current subtotal.");
            while (yn3.equalsIgnoreCase("y")) {
                System.out.println("So, what would you like to order?");
                ord = k.nextLine().toLowerCase();
                    switch (ord) {
                case "pint":
                case "mead":
                case "pint of mead":
                    numPints++;
                    break;
                case "bread and cheese":
                    numBread++;
                    break;
                case "custard":
                case "tart":
                case "custard tart":
                    System.out.println("How many would you like?");
                    numTarts = Integer.parseInt(k.nextLine());
                    if (numTarts % 12 == 0) {
                        subtotal += custTartDoz * (numTarts / 12);
                    }
                    else if (numTarts > 12) {
                        subtotal += (numTarts / 12 * custTartDoz) + (numTarts % 12 * custTart);
                    }
                    else {
                        subtotal += numTarts * custTart;
                    }
                    break;
                case "meal":
                case "meal deal":
                    subtotal += mealDeal;
                    break;
                case "show subtotal":
                    System.out.println("Your current subtotal is " + subtotal + " pence.");
                    break;
                default:
                    System.out.println("Sorry, I didn't understand that.");
                    continue;
            }
            int convertedMeals = Math.min(numPints, numBread);
            subtotal += convertedMeals * mealDeal;
            subtotal += (numPints - convertedMeals) * pint;
            subtotal += (numBread - convertedMeals) * breadncheese; //automatically converts breadandcheese/pints ordered separately into meal deals
            System.out.println("Anything else? (y/n)");
            yn3 = k.nextLine();
                if (yn3.equalsIgnoreCase("show subtotal")){
                    System.out.println("Your current subtotal is "+subtotal+" pence.");
                    System.out.println("Anything else? (y/n)");
                    yn3 = k.nextLine();
                }
}
        System.out.println("Your subtotal is " + subtotal + " pence");
        k.close();
}

public static void pMenu(double pint, double breadncheese, double custTart, double custTartDoz, double mealDeal){
    System.out.println();
    System.out.println("MENU: ");
    System.out.println("PINT OF MEAD: " + pint + " PENCE");
    System.out.println("BREAD AND CHEESE: " + breadncheese + " PENCE");
    System.out.println("CUSTARD TART: " + custTart + " PENCE");
    System.out.println("DOZEN OF CUSTARD TARTS: " + custTartDoz + " PENCE");
    System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): " + mealDeal + " PENCE");
}

public static void sMenu(double pint, double breadncheese, double custTart, double custTartDoz, double mealDeal){
    System.out.println();
    System.out.println("MENU: ");
    System.out.println("PINT OF MEAD: " + pint/12 + " SHILLINGS");
    System.out.println("BREAD AND CHEESE: " + breadncheese/12 + " SHILLINGS");
    System.out.println("CUSTARD TART: " + custTart/12 + " SHILLINGS");
    System.out.println("DOZEN OF CUSTARD TARTS: " + custTartDoz/12 + " SHILLINGS");
    System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): " + mealDeal/12 + " SHILLINGS");
}

public static void lbMenu(double pint, double breadncheese, double custTart, double custTartDoz, double mealDeal){
    System.out.println();
    System.out.println("MENU: ");
    System.out.println("PINT OF MEAD: " + pint/240 + " POUNDS");
    System.out.println("BREAD AND CHEESE: " + breadncheese/240 + " POUNDS");
    System.out.println("CUSTARD TART: " + custTart/240 + " POUNDS");
    System.out.println("DOZEN OF CUSTARD TARTS: " + custTartDoz/240 + " POUNDS");
    System.out.println("MEAL DEAL (Pint of mead + an order of bread and cheese): " + mealDeal/240 + " POUNDS");
}
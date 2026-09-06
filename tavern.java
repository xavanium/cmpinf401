import java.util.Scanner;

/* Valerie Kuttler
CMPINF 401--SEC 1200
Ye olde tavern ordering system! */
public static void main(String[] args) {
    boolean isPubber = false;
    int numTarts = 0;
    double pint = 60, breadncheese = 120, custTart = 72, custTartDoz = 720, mealDeal = 168; //initializing menu item prices in pence
    double subtotal = 0;
    String yn, yn2, pw = "j", psp = "j", yn3 = "y", ord = "n";
    Scanner k = new Scanner(System.in);
    System.out.println("Is there a customer to be waited on? (y/n)");
    yn = k.next();
    if(yn.equalsIgnoreCase("n")){
        System.out.println("Ok goodbye");
        System.exit(0); //ends program
    } else {
        System.out.println("Welcome to The Lynx and Newt!");
    }
    System.out.println("Are you a Preferred Pubber? (y/n)");
    yn2 = k.next();
    if (yn2.equalsIgnoreCase("n")) {
        isPubber = false;
    } else {
        for (int i = 0; i<2; i++){
            System.out.print("PASSWORD: ");
            pw = k.next();
                if (pw.equals("WEASEL")){
                    isPubber = true;
                    System.out.println("Congrats, you're in! You will now receive discounted prices.");
                    break;
                } else if (!(pw.equals("WEASEL"))&& i==0) {
                    System.out.println("Try again.");
                } else {
                    System.out.println("Sorry, you are not a pubber. You will not receive the discount.");
                }
            }
            } 
    if(isPubber){ //applying discount prices for pubbers
        pint = 55;
        breadncheese = 9;
        custTartDoz = 660;
        mealDeal = 156;
    }
    System.out.println("Would you like to view the item prices in pence, shillings, or pounds?");
    psp = k.next();
        if (psp.equalsIgnoreCase("pence")) {
            pMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
        } else if (psp.equalsIgnoreCase("shillings")){
            sMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
        } else if (psp.equalsIgnoreCase("pounds")){
            lbMenu(pint, breadncheese, custTart, custTartDoz, mealDeal);
        } else { 
            System.out.println("What? ");
            System.exit(0); //TODO: fix this somehow idk
        }

        System.out.println();
        System.out.println("So, what would you like to order?");
            while (yn3.equalsIgnoreCase("Y")){
                ord = k.next();
                    switch (ord.toLowerCase()) {
                        case "pint":
                        case "mead":
                        case "pint of mead":
                            subtotal += pint;
                            break; //TODO: finish menu
                    }
                System.out.println("Anything else? (y/n)");
                yn3 = k.next();
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
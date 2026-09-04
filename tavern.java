import java.util.Scanner;
public static void main(String[] args) {
    boolean isPubber = false;
    double pint = 60, breadncheese = 120, custTart = 72, custTartDoz = 720, mealDeal = 168; //initializing menu item prices
    String yn, yn2, pw = "j";
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
                    i = 2;
                    System.out.println("Congrats, you're in! You will now receive discounted prices.");
                }
                else {
                    System.out.println("Try again.");
                    System.out.print("PASSWORD: ");
                    pw = k.next();
                        if (pw.equals("WEASEL")){
                        isPubber = true;
                        i = 2;
                        System.out.println("Congrats, you're in! You will now receive discounted prices.");
                } //TODO: clean this up somehow??
                }
                if (!(pw.equals("WEASEL"))){
                System.out.println("Sorry, you are NOT a pubber.");
                break; //ends loop if customer doesnt get password
            }
            } 
    }
    if(isPubber){ //applying discount prices for pubbers
        pint = 55;
        breadncheese = 9;
        custTartDoz = 660;
        mealDeal = 156;
    }
    k.close(); //closing scanner to "prevent resource leaks"
}
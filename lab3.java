/* Valerie Kuttler
LAB 3 - Dice Rolling
CMPINF401 SEC 1200 */

import java.util.*;
public static void main(String[] args){
    Scanner k = new Scanner(System.in);
    String cont = "yes";
    while (cont.equalsIgnoreCase("yes")){
    System.out.print("Roll the dice this many times: ");
    int timesRolled = k.nextInt();
    Random R = new Random();
    RollDice(timesRolled, R);
    System.out.println("Would you like to continue? (yes/no)");
    cont = k.next();
    }
    k.close();
}

public static void RollDice(int timesRolled, Random R){
        for (int i = 0; i < timesRolled; i++){
            int d1 = R.nextInt(6) + 1;
            int d2 = R.nextInt(6) + 1;
            System.out.println(d1+d2);
        }
    }
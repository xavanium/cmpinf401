/* Valerie Kuttler
LAB 3 - Dice Rolling
CMPINF401 SEC1200 */
import java.util.*;
public static void main(String[] args) {
    Scanner k = new Scanner(System.in);
    String cont = "yes";
    int timesRolled;
    Random R = new Random();
    while (cont.equalsIgnoreCase("yes")) {
        System.out.print("Roll the dice this many times: ");
        timesRolled = k.nextInt();
        RollDice(timesRolled, R);
        System.out.println("Would you like to continue? (yes/no)");
        cont = k.next();
    }
    k.close();
}

public static void RollDice(int timesRolled, Random R) {
    int[] counts = new int[13];
    for (int i = 0; i < timesRolled; i++) {
        int d1 = R.nextInt(6) + 1;
        int d2 = R.nextInt(6) + 1;
        int sum = d1 + d2;
        System.out.println(sum);
        counts[sum]++; // keep track of how many times each possible roll happened
    }
    System.out.println("\nPercentage of each roll:");
    for (int roll = 2; roll <= 12; roll++) {
        double fraction = (double) counts[roll] / timesRolled;
        System.out.println(roll + ": " + fraction*100+"%");
    }
}
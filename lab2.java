/* Valerie Kuttler
Lab 2: Dice Rolling
CMPINF 401--SEC 1200 */
import java.util.*;
public static void main(String[] args){
    Random R = new Random();
    int d1 = R.nextInt(6)+1;
    int d2 = R.nextInt(6) + 1;
    for (int i = 0; i<100; i++){
        System.out.println(d1+d2);
        d1 = R.nextInt(6) + 1;
        d2 = R.nextInt(6)+1;
    }
}
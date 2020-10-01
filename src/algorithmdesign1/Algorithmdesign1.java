/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmdesign1;

import java.util.Scanner;

public class Algorithmdesign1 {

    static int n;

    static int man[][];
    static int woman[][];

    static boolean manReq[][];
    static boolean womanReq[][];

    static boolean allMarried = false;

    static int manex[];
    static int womanex[];

    public static void main(String[] args) {
        //n = 3;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        man = new int[n][n];
        woman = new int[n][n];

        manReq = new boolean[n][n];
        womanReq = new boolean[n][n];

        manex = new int[n];
        womanex = new int[n];

//        int man[][] = startSet(n);
//        int woman[][] = startSet(n);
//        String tomb = input.nextLine();
        //create men and women
        for (int i = 0;
                i < n;
                i++) {
            for (int j = 0; j < n; j++) {
                man[i][j] = input.nextInt()-1;
            }
        }

        //String tomb = input.next();
        //set priorities of each woman
        for (int i = 0;
                i < n;
                i++) {
            for (int j = 0; j < n; j++) {
                woman[i][j] = input.nextInt()-1;
            }
        }

        //show priorities
        for (int i = 0; i < n ; i++) {
            System.out.print("man" + i + "has :");
            for (int j = 0; j < n; j++) {
                System.out.print(man[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0;
                i < n;
                i++) {
            System.out.print("woman" + i + "has :");
            for (int j = 0; j < n; j++) {
                System.out.print(woman[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0;
                i < n;
                i++) {
            // set all as a single person
            manex[i] = -1;
            womanex[i] = -1;
        }

        for (int i = 0;
                i < n;
                i++) {
            for (int j = 0; j < n; j++) {
                manReq[i][j] = false;
                womanReq[i][j] = false;
            }
        }

        //find first single man
        int i = 0;
        while (i < n && !allMarried) {
            if (manex[i] == -1) {
                int j = 0;
                while (j < n) {
                    if (!manReq[i][j]) {
                        boolean doesMarry;
                        doesMarry = manReqWoman(i, man[i][j]);
                        manReq[i][j] = true;
                        if (doesMarry) {
                            getMarry(i, man[i][j]);
                            i = 0;
                            break;
                        }
                        j++;
                    } else {
                        j++;
                    }
                }
            } else {
                i++;
            }
        }

        for (i = 0;
                i < n;
                i++) {
            System.out.println("manex " + i + "woman" + manex[i]);
        }

        for (i = 0;
                i < n;
                i++) {
            System.out.println("womanex " + i + "  man" + (womanex[i]+1));
        }

    }

    public static boolean manReqWoman(int manNumber, int womanNumber) {

        if (womanex[womanNumber] == -1) {
            return true;
        } else {
            int i = 0;
            //check which one is better for this woman (his husband or the man requested)
            while (woman[womanNumber][i] != womanex[womanNumber] && woman[womanNumber][i] != manNumber) {
                i++;
            }
            if (woman[womanNumber][i] == womanex[womanNumber]) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void getMarry(int manNumber, int womanNumber) {
        if (womanex[womanNumber] != -1) { //She had a husband
            manex[womanex[womanNumber]] = -1;
        }
        womanex[womanNumber] = manNumber;
        manex[manNumber] = womanNumber;
        System.out.println("man " + manNumber + " married to woman" + womanNumber);
    }

//    public static int[][] startSet(int n) {
//        Scanner input = new Scanner(System.in);
//
//        int priorities[][] = new int[n][n];
//
//        //create men and women
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                priorities[i][j] = input.nextInt();
//            }
//        }
//
//     
//        return priorities;
//    }
}

package com.company.codechef.longchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class June {
    public static void summerHeat(Scanner s) {
        int t = s.nextInt();

        while (t-- != 0) {
            int x_a = s.nextInt();
            int x_b = s.nextInt();
            int X_a = s.nextInt();
            int X_b = s.nextInt();
            System.out.println((X_a / x_a) + (X_b / x_b));
        }
    }

    public static void bellaCiao(BufferedReader br ) throws IOException {

        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            StringTokenizer st
                    = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int totalQ = 0;
            if(D - d > 0) {
                boolean isOdd = false;
                int n = (D - d) / d;
//                System.out.println("Initial n " + n);
                if((D - d) % 2 != 0)
                {
                    n += 1;
                    isOdd = true;
                }
//                System.out.println("Total n after checking for odd " + n);
                int a1 = d;
//                System.out.println("a1 " + a1);
                int an = a1 + (n - 1) * d;
//                System.out.println("an " + an);
                totalQ = (n * (a1 + an)) / 2;
//                System.out.println("Total Q before checking for odd " + totalQ);
                if(isOdd)
                {
//                    System.out.println("Inside is Odd");
                    totalQ -= (an/d);
                }
//                System.out.println("Total Q after checking for odd " + totalQ);
            }
            System.out.println( (D * P) + (totalQ * Q));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        bellaCiao(br);
    }
}

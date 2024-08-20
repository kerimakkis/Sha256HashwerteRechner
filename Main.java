package org.example;

import java.util.Scanner;

import static java.lang.Math.pow;



public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        System.out.println( "bitte geben Sie eure Passwort werte ein: ");
        String password = scann.nextLine();
        //String password = "password";
        int langeHashwerte=6;
        long hv = rechnungHashwert(password , langeHashwerte);


        System.out.println(hv);


        String sha256Wert = org.apache.commons.codec.digest.DigestUtils.sha256Hex(String.valueOf(hv));
        System.out.println(sha256Wert);

    }

    static long rechnungHashwert (String s, int digits){
        long sum =0,
             mul =1;

        for( int i =0; i<s.length(); i++){
            if (i % 4==0){
                mul=1;
            }else{mul *=64;}


            sum+=(s.charAt(i)*mul);
        }
        long hv = sum;
        if( digits >= 1){
            hv = sum % (long)(Math.pow(10,digits));
        }

        return hv;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;

/**
 *
 * @author Raghad 
 *         
 */
import java.util.*;
import java.io.*;

public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter plain text:");
        String pt = input.nextLine();

        System.out.print("\nEnter key: ");
        int key = input.nextInt();

        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};

        String ct = encrypt(key, pt, alphabets);
        System.out.println("\nEncrypted Message: \n" + ct);

        String ptt = decrypt(key, ct, alphabets);
        System.out.println("\nDecrypted Message: \n" + ptt);

        for (int i = 0; i < ct.length(); i++) {

        }

    }

    public static String encrypt(int key, String pt, char[] alph) {
        String encrypted = "";
        int position = 0;

        pt = pt.toLowerCase();
        for (int i = 0; i < pt.length(); i++) {
            if (pt.charAt(i) >= 'a' && pt.charAt(i) <= 'z') {
                position = (pt.charAt(i) - 97) + key;  // - 97 to initialize ascii numbers to 0
                position = position % 26;
                encrypted += alph[position];
            } else 
                encrypted += pt.charAt(i);
            
        }

        encrypted = encrypted.toUpperCase();
        return encrypted;

    }

    public static String decrypt(int key, String ct, char[] alph) {
        String decrypted = "";
        ct = ct.toLowerCase();
        int position = 0;
        for (int i = 0; i < ct.length(); i++) {
            if (ct.charAt(i) >= 'a' && ct.charAt(i) <= 'z') {
                position = ct.charAt(i) - 97; // find alphabetic position
                position -= (key % 26);  // find a modulus key then substract
                if (position < 0)        // when substracting, the number might go below zero and revert the sequence, 
                                         // thus add 26 to make it mod
                    position += 26;
                decrypted += alph[position];
            } else 
                decrypted += ct.charAt(i);
            

        }

        return decrypted;
    }

}

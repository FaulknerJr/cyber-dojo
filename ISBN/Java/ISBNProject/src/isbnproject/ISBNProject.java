/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class ISBNProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String isbn = JOptionPane.showInputDialog("Enter ISBN number");
        checkISBN(isbn);
    }

    public static void verifyChecksum(String isbn, int size) {
        if (size == 13 || size == 12) {
            int checksumResult = 0, currPos = 0;
            String calculatedISBN = "";
            for (int i = 0; i < size; ++i) {
                if (i % 2 == 0) {
                    currPos = Character.getNumericValue(isbn.charAt(i));
                    calculatedISBN += isbn.charAt(i);
                    checksumResult += currPos * 1;
                } else {
                    currPos = Character.getNumericValue(isbn.charAt(i));
                    calculatedISBN += isbn.charAt(i);
                    checksumResult += currPos * 3;
                }
            }
            checksumResult = (10 - (checksumResult % 10)) % 10;
            String checksum = Integer.toString(checksumResult);
            calculatedISBN += checksum;
            if (calculatedISBN.equals(isbn) || size == 12) {
                System.out.println("ISBN: " + isbn + " is valid.");
                if(size == 12){
                    System.out.println("ISBN with checksum is " + calculatedISBN + ".");
                }
            } else {
                System.out.println("ISBN: " + isbn + " is not valid.");
                System.out.println("Proper ISBN is " + calculatedISBN + ".");
            }
        } else if (size == 10) {
            int checksumResult = 0, currPos = 0;
            String calculatedISBN = "";
            for (int i = 0; i < size - 1; ++i) {
                currPos = Character.getNumericValue(isbn.charAt(i));
                calculatedISBN += isbn.charAt(i);
                checksumResult += currPos * (i + 1);
            }
            checksumResult = checksumResult % 11;
            if (checksumResult == 10) {
                calculatedISBN += "X";
            } else {
                String checkSum = Integer.toString(checksumResult);
                calculatedISBN += checkSum;
            }
            if (calculatedISBN.equalsIgnoreCase(isbn)) {
                System.out.println("ISBN: " + isbn + " is valid.");
            } else {
                System.out.println("ISBN: " + isbn + " is not valid.");
                System.out.println("Proper ISBN is " + calculatedISBN + ".");
            }
        }
    }

    public static void checkISBN(String isbn) {
        boolean correctForm = false;
        int numLetters = 0;
        if (isbn.length() == 10 || isbn.length() == 13) {
            try {
                Long.parseLong(isbn);
                correctForm = true;
            } catch (Exception e) {
                if (isbn.length() == 10 && (isbn.charAt(isbn.length() - 1) == 'x' || isbn.charAt(isbn.length() - 1) == 'X')) {
                    String newISBN = isbn.substring(0, isbn.length() - 1);
                    try {
                        Long.parseLong(newISBN);
                        ++numLetters;
                        correctForm = true;
                    } catch (Exception ex) {
                        System.out.println("This is an invalid ISBN number");
                        System.out.println("Exiting System.");
                        System.exit(0);
                    }
                }
            }
            if (correctForm) {
                if (numLetters == 0) {
                    verifyChecksum(isbn, isbn.length());
                } else if (numLetters == 1) {
                    verifyChecksum(isbn, isbn.length());
                }
            }
        } else if (isbn.length() == 9 || isbn.length() == 12) {
            System.out.println("We will calculate the checksum");
            verifyChecksum(isbn, isbn.length());
        } else {
            System.out.println("This is an invalid ISBN number");
            System.out.println("Exiting System.");
            System.exit(0);
        }
    }

}

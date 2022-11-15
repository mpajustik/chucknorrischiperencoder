package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueLoop = "";

        while(!continueLoop.equals("exit")){
            System.out.println("Please input operation (encode/decode/exit):");
            continueLoop = scanner.nextLine();
            switch (continueLoop){
                case "exit":
                    break;
                case "encode":
                    encode();
                    break;
                case "decode":
                    decode();
                    break;
                default:
                    System.out.println("There is no \'"+continueLoop+"\' operation");
                    break;

            }

        }
        System.out.println("Bye");


    }

    public static void encode(){
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        System.out.println("Input string:");
        char[] charArray = scanner.nextLine().toCharArray();
        System.out.println("\nEncoded string:");
        for (char letter : charArray) {
            inputString += String.format("%7s", Integer.toBinaryString(letter)).replace(" ", "0");
        }
        encryption(inputString);
    }

    public static void decode(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String encodedMessage = sc.nextLine();
        String binaryMessage = "";
        String number = "";
        boolean oneOrZero = true;
        String[] encodedWords = encodedMessage.split(" ");
        if (encodedWords.length >= 8){
            for (int i = 0; i < encodedWords.length; i++) {
                if ( i % 2 == 0) {
                    number = encodedWords[i].equals("00") ? "0" : "1";
                    if (encodedWords[i].equals("00") || encodedWords[i].equals("0")){
                        oneOrZero = true;
                    } else {
                        oneOrZero = false;
                        break;
                    }
                } else {
                    binaryMessage = binaryMessage.concat(number.repeat(encodedWords[i].length()));

                }
            }
            if(binaryMessage.length() % 7 == 0 && oneOrZero){
                System.out.println();
                System.out.println("Decoded string:");

                for (int i = 0; i < binaryMessage.length(); i += 7) {
                    System.out.print((char) Integer.parseInt(binaryMessage.substring( i, i + 7 ), 2));
                }
                System.out.println();
            }else {
                System.out.println("Encoded string is not valid.");
            }
        } else {
            System.out.println("Encoded string is not valid.");
        }

    }

    public static void encryption(String inputString) {
        int i = 0;
        char currentChar;

        while (i < inputString.length()) {
            if (inputString.charAt(i) == '0') {
                System.out.print("00 ");
                currentChar = '0';
            } else {
                System.out.print("0 ");
                currentChar = '1';
            }

            while (inputString.charAt(i) == currentChar) {
                System.out.print("0");
                i++;
                if (i == inputString.length()) break;
            }

            if (i < inputString.length()) System.out.print(" ");
        }
        System.out.println();
    }

}
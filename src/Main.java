import java.util.Scanner;

public class Main {

    static String[] lastdigit = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] allteen = {" ", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] allten = {" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] more = {" ", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        System.out.println("Type Number");
        int number = scan.nextInt();
        String result = underHundred(number);
        String result2 = translatedNumber(number);
        System.out.println(result);
        System.out.println(result2);

    }

    public static String underHundred (int number) {

        String output = " ";

        if (number >= 100) {
            output += lastdigit[number / 100] + " Hundred ";
            number %= 100;
        }

        if (number >= 11 && number <= 19) {
            output += allteen[number - 10] + " ";
        } else if (number >= 20 || number == 10) {
            output += allten[number / 10] + " ";
            number %= 10;
        }
        if (number >= 1 && number <= 9) {
            output += lastdigit[number] + " ";
        }
        return output;
        //////
    }
    public static String translatedNumber (int number) {

        int index = 0;
        String output = "";

        while (number > 0) {
            if (number % 1000 != 0) {
                output = underHundred(number % 1000) + more[index] + " " + output;
            }
            number /= 1000;
            index++;
        }
        return output;
    }
}


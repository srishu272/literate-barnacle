/*
 Write a program which perform multiplication using booth algorithm.
Task:
Ask user to enter two sign numbers.
Convert it into 2's complement representation
Run the booth algorithm
Show the result in 2's complement form
convert the 2's complement representation in sign number.
*/
import java.util.Scanner;
import java.io.*;
class MCO_Practical5
{
    int[] convertInTwosComplement(int n) 
    {
        int[] number = new int[5];
        int index = 4;
        if (n > 0) {
            while (n != 0) {
                number[index--] = n % 2;
                n /= 2;
            }
            return number;
        } else {
            n = 32 + n;
            while (n != 0) 
            {
                number[index--] = n % 2;
                n /= 2;
            }
            return number;
        }
    }
    
    void add(int[] x, int[] y) 
    {
        int carry = 0;
        for (int i = 5; i >= 0; i--) 
        {
            int z = x[i] + y[i] + carry;
            x[i] = z % 2;
            carry = z / 2;
        }
    }

    void arithmeticRightShift(int[] x) 
    {
        for (int i = 10; i >= 1; i--) 
        {
            x[i] = x[i - 1];
        }
    }

    int convertToDecimal(int[] a) 
    {
        int decimal = 0;
        int weight = 1;
        for (int i = 9; i >= 0; i--) 
        {
            decimal += (a[i] * weight);
            weight *= 2;
            if (decimal > 128) 
            {
                decimal = -(512 - decimal);
            }
        }
        return decimal;
    }
    
    public static void main(String[] args) 
    {
        MCO_Practical5 obj = new MCO_Practical5();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number between -15 to 15: ");
        int a = input.nextInt();
        System.out.print("Enter second number between -15 to 15: ");
        int b = input.nextInt();
        int[] BR = obj.convertInTwosComplement(a);
        int[] twosComplementOfBR = obj.convertInTwosComplement(-a);
        int[] QR = obj.convertInTwosComplement(b);
        int[] addRegister = new int[11];
        int[] subRegister = new int[11];
        int[] AC = new int[11];
        for (int i = 0; i < 5; i++) {
            addRegister[i] = BR[i];
            subRegister[i] = twosComplementOfBR[i];
            AC[i + 5] = QR[i];
        }
        
        for (int i = 0; i < 5; i++) 
        {
            if ((AC[9] == 0 && AC[10] == 0)
            || (AC[9] == 1 && AC[10] == 1)) 
            {
                obj.arithmeticRightShift(AC);
            } 
            else if (AC[9] == 0 && AC[10] == 1) 
            {
                obj.add(AC, addRegister);
                obj.arithmeticRightShift(AC);
            } 
            else if (AC[9] == 1 && AC[10] == 0) {
                obj.add(AC, subRegister);
                obj.arithmeticRightShift(AC);
            }
        }
        System.out.println("Answer = " + obj.convertToDecimal(AC));

    }
}

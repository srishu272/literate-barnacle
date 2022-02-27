/*
Write a program to convert a given number system to other number system.
Task:
Ask user to choose one form given number system :Binary, Octal, Decimal,
Hexadecimal.
Ask user to enter a number (number can be float).
Check that number entered for given number system is correct.
If not give the error
If correct then convert entered number in rest of the three number system.
If you can show the conversion then its well and good.
 */
import java.io.*;
import java.util.Scanner;
class MCO_Practical_2
{
    public static String dec_to_binary(double deci)//this method converts decimal number to binary number
    {
        int integral_part = (int)deci;
        double fractional_part = deci - integral_part;
        String b1 = "", b2 = "";
        int rem,rem1,k=4;
        while(integral_part>0)//this loop is for converting the integeral part
        {
            rem = integral_part%2;
            String str = Integer.toString(rem);
            b1=str+b1;
            integral_part = integral_part/2;
        }

        while(k>0)//this loop is for converting the integeral part
        {
            rem1 = (int)(fractional_part*2);
            String str = Integer.toString(rem1);
            b2=b2+str;
            fractional_part = (fractional_part*2) - rem1;
            k--;
        }
        return (b1+'.'+b2);
    }

    public static String dec_to_octal(double deci)//this method converts decimal number to octal number
    {
        int integral_part = (int)deci;
        double fractional_part = deci - integral_part;
        String b1 = "", b2 = "";
        int rem,rem1,k=4;
        while(integral_part>0)//this loop is for converting the integeral part
        {
            rem = integral_part%8;
            String str = Integer.toString(rem);
            b1=str+b1;
            integral_part = integral_part/8;
        }

        while(k>0)//this loop is for converting the integeral part
        {
            rem1 = (int)(fractional_part*8);
            String str = Integer.toString(rem1);
            b2=b2+str;
            fractional_part = (fractional_part*8) - rem1;
            k--;
        }
        return (b1+'.'+b2);
    }

    public static String dec_to_hexa(double deci)//this method converts decimal number to hexadecimal number
    {
        int integral_part = (int)deci;
        double fractional_part = deci - integral_part;
        String b1 = "", b2 = "",str="";
        int rem,rem1,k=4;
        while(integral_part>0)//this loop is for converting the integeral part
        {
            rem = integral_part%16;
            if(rem==10)
                str="A";
            else if(rem==11)
                str="B";
            else if(rem==12)
                str="C";
            else if(rem==13)
                str="D";
            else if(rem==14)
                str="E";
            else if(rem==15)
                str="F";
            else
                str = Integer.toString(rem);

            b1=str+b1;
            integral_part = integral_part/16;
        }

        while(k>0)//this loop is for converting the integeral part
        {
            rem1 = (int)(fractional_part*16);
            if(rem1==10)
                str="A";
            else if(rem1==11)
                str="B";
            else if(rem1==12)
                str="C";
            else if(rem1==13)
                str="D";
            else if(rem1==14)
                str="E";
            else if(rem1==15)
                str="F";
            else
                str = Integer.toString(rem1);

            b2=b2+str;
            fractional_part = (fractional_part*16) - rem1;
            k--;
        }
        return (b1+'.'+b2);
    }

    public static double bin_to_decimal(String bin)//this method converts binary number to decimal
    {
        int index = bin.indexOf(".");
        int j=0,k=-1,integral_part=0;
        double fractional_part=0;
        for(int i =index-1;i>=0;i--)//this loop converts the integral part of the binary number
        {
            int num = bin.charAt(i) - '0';
            double temp = num*(Math.pow(2,j));
            j++;
            integral_part += temp; 
        }

        for(int i=index+1;i<bin.length();i++)//this loop converts the fractional part of the binary number
        {
            int num = bin.charAt(i) - '0';
            double temp = num*(Math.pow(2,k));
            k--;
            fractional_part += temp;
        }
        fractional_part += integral_part;
        return fractional_part;
    }

    public static double octal_to_decimal(String octal)//this method converts octal number to decimal
    {
        int index = octal.indexOf(".");
        int j=0,k=-1,integral_part=0;
        double fractional_part=0;
        for(int i =index-1;i>=0;i--)//this loop converts the integral part of the octal number
        {
            int num = octal.charAt(i) - '0';
            double temp = num*(Math.pow(8,j++));
            integral_part += temp; 
        }

        for(int i=index+1;i<octal.length();i++)//this loop converts the fractional part of the octal number
        {
            int num = octal.charAt(i) - '0';
            double temp = num*(Math.pow(8,k--));
            fractional_part += temp;
        }
        fractional_part += integral_part;
        return fractional_part;        
    }

    public static String hexa_to_binary(String hexa)//this method converts hexadecimal number to binary
    {
        int n = hexa.indexOf(".");
        String s1 = hexa.substring(0,n);
        String s2 = hexa.substring(n+1,hexa.length());
        String str1="",str2="",str="";
        for(int i=n-1;i>=0;i--)//this loop converts the integral part of the hexadecimal number
        {
            char ch = s1.charAt(i);
            if(ch=='0')
                str = "0000";
            else if(ch=='1')
                str = "0001";
            else if(ch=='2')
                str = "0010";
            else if(ch=='3')
                str = "0011";
            else if(ch=='4')
                str = "0100";
            else if(ch=='5')
                str = "0101";
            else if(ch=='6')
                str = "0110";
            else if(ch=='7')
                str = "0111";
            else if(ch=='8')
                str = "1000";
            else if(ch=='9')
                str = "1001";
            else if(ch=='A')
                str = "1010";
            else if(ch=='B')
                str = "1011";
            else if(ch=='C')
                str = "1100";
            else if(ch=='D')
                str = "1101";
            else if(ch=='E')
                str = "1110";
            else if(ch=='F')
                str = "1111";
            str1 = str+str1;
        }

        for(int i=0;i<s2.length();i++)//this loop converts the fractional part of the hexadecimal number
        {
            char ch = s2.charAt(i);
            if(ch=='0')
                str = "0000";
            else if(ch=='1')
                str = "0001";
            else if(ch=='2')
                str = "0010";
            else if(ch=='3')
                str = "0011";
            else if(ch=='4')
                str = "0100";
            else if(ch=='5')
                str = "0101";
            else if(ch=='6')
                str = "0110";
            else if(ch=='7')
                str = "0111";
            else if(ch=='8')
                str = "1000";
            else if(ch=='9')
                str = "1001";
            else if(ch=='A')
                str = "1010";
            else if(ch=='B')
                str = "1011";
            else if(ch=='C')
                str = "1100";
            else if(ch=='D')
                str = "1101";
            else if(ch=='E')
                str = "1110";
            else if(ch=='F')
                str = "1111";
            str2 = str2 +str;
        }
        str = str1+"."+str2;
        return str;
    }

    public static void main(String args[])
    {
        MCO_Practical_2 obj = new MCO_Practical_2();
        Scanner scan = new Scanner(System.in);
        System.out.println("1. CONVERT DECIMAL TO BINARY, OCTAL,HEXADECIMAL \n2. CONVERT BINARY TO DECIMAL,OCTAL,HEXADECIMAL \n3. CONVERT OCTAL TO DECIMAL,BINARY,HEXADECIMAL \n4. CONVERT HEXADECIMAL TO DECIMAL, BINARY,OCTAL \nENTER YOUR CHOICE: ");
        int ch = scan.nextInt();

        switch(ch)
        {
            case 1: //For decimal to other number systems
            {
                System.out.println("ENTER THE DECIMAL NUMBER: ");
                double num = scan.nextDouble();
                System.out.println("BINARY NUMBER "+dec_to_binary(num));
                System.out.println("OCTAL NUMBER "+dec_to_octal(num));
                System.out.println("HEXADECIMAL NUMBER "+dec_to_hexa(num));
                break;
            }

            case 2://For binary to other number systems
            {
                System.out.println("ENTER THE BINARY NUMBER: ");
                String num = scan.next();
                int flag = 0;
                for(int i=0;i<num.length();i++)
                {
                    if((num.charAt(i)!='0') && (num.charAt(i)!='1') && (num.charAt(i)!='.'))
                        flag = 1;                    
                }
                if(flag==0)
                {
                    System.out.println("DECIMAL NUMBER "+bin_to_decimal(num));
                    System.out.println("OCTAL NUMBER "+dec_to_octal(bin_to_decimal(num)));
                    System.out.println("HEXADECIMAL NUMBER "+dec_to_hexa(bin_to_decimal(num)));
                }
                else 
                    System.out.println("INVALID BINARY NUMBER");
                break;
            }

            case 3://For binary to other number systems
            {
                System.out.println("ENTER OCTAL NUMBER: ");
                String num = scan.next();
                int flag = 0;
                for(int i=0;i<num.length();i++)
                {
                    if((num.charAt(i)!='0') && (num.charAt(i)!='1') && (num.charAt(i)!='2') && (num.charAt(i)!='3') && (num.charAt(i)!='4') && (num.charAt(i)!='5') && (num.charAt(i)!='6') && (num.charAt(i)!='7') && (num.charAt(i)!='.'))
                        flag = 1;                    
                }                 

                if(flag==0)
                {
                    System.out.println("DECIMAL NUMBER: "+octal_to_decimal(num));
                    System.out.println("BINARY NUMBER: "+dec_to_binary(octal_to_decimal(num)));
                    System.out.println("HEXADECIMAL NUMBER: "+dec_to_hexa(octal_to_decimal(num)));
                } 
                else
                    System.out.println("INVALID OCTAL NUMBER");
                break;
            }

            case 4://For binary to other number systems
            {
                System.out.println("ENTER HEXADECIMAL NUMBER: ");
                String num = scan.next();
                int flag = 0;
                for(int i=0;i<num.length();i++)
                {
                    
                    if((num.charAt(i)!='0') && (num.charAt(i)!='1') && (num.charAt(i)!='2') && (num.charAt(i)!='3') && (num.charAt(i)!='4') && (num.charAt(i)!='5') && (num.charAt(i)!='6') && (num.charAt(i)!='7') && (num.charAt(i)!='8') && (num.charAt(i)!='9') && (num.charAt(i)!='.') && (num.charAt(i)!='A') && (num.charAt(i)!='B') && (num.charAt(i)!='C') && (num.charAt(i)!='D') && (num.charAt(i)!='E') && (num.charAt(i)!='F'))
                    {
                        flag = 1; 
                    }
                                     
                }
                if(flag==0)
                {
                    System.out.println("DECIMAL NUMBER: "+bin_to_decimal(hexa_to_binary(num)));
                    System.out.println("BINARY NUMBER: "+hexa_to_binary(num));
                    System.out.println("OCTAL NUMBER: "+dec_to_octal(bin_to_decimal(hexa_to_binary(num))));                
                }
                else
                    System.out.println("INVALID HEXADECIMAL NUMBER");
                break;
            }
            default:
            {
                System.out.println("INVALID CHOICE!!");
                break;
            }
        }
        System.out.println("\n\nNAME : SRISHU CHINTAKINDI \nID: 20CE012");
    }
}
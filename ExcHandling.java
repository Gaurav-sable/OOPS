
/*Name :- Gaurav Pramod Sable
 Rollno :- 23339
 Batch :- SE-11
 Problem Statement :- Implement a program to handle Arithmetic exception, Array Index Out of Bounds. The user enters two numbers Num1 and Num2. The division of Num1 and Num2 is displayed. If Num1 and Num2 are not
integers, the program would throw a Number Format Exception. If Num2 were zero, the program would throw an Arithmetic Exception. Display the exception
 */


import java.util.*;

//class to divide two numbers by handling the possible exceptions
class TestExc{
    Scanner sc = new Scanner(System .in);
    int [] arr = new int[2];   //Array to take two integers as input

    //Method to proceed the Division
    public void checkExc(){

        //try and catch blocks to handle exceptions
        try{
            for(int i=0;i<2;i++)   //Takes input of two integers in Array
            {
                System.out.print("\n\t\tEnter Num"+(i+1)+" = ");
                arr[i] = sc.nextInt();
            }
            System.out.println("Entered numbers are :- ");
            for(int i=0;i<2;i++)   //Displays the two Numbers
            {
                System.out.println("\n\t\tNum"+(i+1)+" = "+arr[i]);
            }
            System.out.println("\n"+".".repeat(100));

            //Nested try-catch block
            try{
                int k,m;
                System.out.print("Enter Numerator ro be Num(1 or 2) = ");   //Asks user to choose Numerator to be Num (1 or 2)
                k = sc.nextInt();
                System.out.print("Enter Denominator to be Num (1 or 2) = ");   //Asks user to choose Denominator to be Num (1 or 2);
                m = sc.nextInt();

                //Inner nested Try-catch block
                try{
                    int Div = arr[k-1]/arr[m-1];
                    System.out.println("Answer of Division = "+Div);
                    System.out.println("\n"+".".repeat(100));
                }

                //Catch block to handle the arrithmetic exception of division by zero
                catch(ArithmeticException e1){
                    System.out.println("Err ! CANNOT BE dIVIDED BY ZERO \n"+e1);
                    System.out.println("\n"+".".repeat(100));
                }
            }

            //Handles the exception of ArrayIndexOutOfBounds while choosing the Numerator and Denominator to be Num (1 or 2 )
            catch(ArrayIndexOutOfBoundsException e2){
                System.out.println("Err ! AS THE SIZE OF ARRAY IS ONLY 2 INDEX CANNOT BE GREATER THAN 2 \n "+e2);
                System.out.println("\n"+".".repeat(100));
            }
        }

        //Handles the Exception if the numbers entered are not integers
        catch(InputMismatchException e3){
            sc.next();   //To remove the Input buffer of Scanner
            System.out.println("Err ! ENTERED NUMBERS ARE NOT CORRECT\n "+e3);
            System.out.println("\n"+".".repeat(100));
        }

        //Finally block which is executed either the exception is handled or not
        finally{
            System.out.println("\n\n@EXCEPTIONHANDLING");
            System.out.println("\n"+"_".repeat(100)+"\n\n");
        }
    }
}

//Start of main class 
public class ExcHandling{
    public static void main(String [] args){
        Scanner st = new Scanner(System.in);
        TestExc t = new TestExc();      //Creating the object of the TestExc class 
        int ch;
        do{
            System.out.println("Press\n\t\t1.To Divide\n\t\t0.To Terminate");
            System.out.print("Enter Choice = ");
            ch = st.nextInt();
            if(ch == 1)
            {
                System.out.println("\n"+".".repeat(100));
                System.out.println("Exception will be Handled in Following cases :- \n\t1.If Num1 or Num2 are not Integers\n\t2.If Index of numerator or Denominator is choosen greater than 2\n\t3.If the Denominator is zero");
                System.out.println("\n"+".".repeat(100));
                t.checkExc();
            }
            else{
                System.out.println("Invalid Choice !!!\n"+".".repeat(100));
            }
        }while(ch!=0);
        st.close();
    }
}


/*OUTPUT

Press
                1.To Divide   
                0.To Terminate
Enter Choice = 1

....................................................................................................
Exception will be Handled in Following cases :- 
        1.If Num1 or Num2 are not Integers
        2.If Index of numerator or Denominator is choosen greater than 2
        3.If the Denominator is zero

....................................................................................................

                Enter Num1 = 4

                Enter Num2 = r
Err ! ENTERED NUMBERS ARE NOT CORRECT
 java.util.InputMismatchException

....................................................................................................


@EXCEPTIONHANDLING

____________________________________________________________________________________________________


Press
                1.To Divide
                0.To Terminate
Enter Choice = 1

....................................................................................................
Exception will be Handled in Following cases :-
        1.If Num1 or Num2 are not Integers
        2.If Index of numerator or Denominator is choosen greater than 2
        3.If the Denominator is zero

....................................................................................................

                Enter Num1 = 4

                Enter Num2 = 2
Entered numbers are :- 

                Num1 = 4

                Num2 = 2

....................................................................................................
Enter Numerator ro be Num(1 or 2) = 1
Enter Denominator to be Num (1 or 2) = 4
Err ! AS THE SIZE OF ARRAY IS ONLY 2 INDEX CANNOT BE GREATER THAN 2 
 java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2

....................................................................................................


@EXCEPTIONHANDLING

____________________________________________________________________________________________________


Press
                1.To Divide
                0.To Terminate
Enter Choice = 1

....................................................................................................
Exception will be Handled in Following cases :-
        1.If Num1 or Num2 are not Integers
        2.If Index of numerator or Denominator is choosen greater than 2
        3.If the Denominator is zero

....................................................................................................

                Enter Num1 = 4

                Enter Num2 = 0
Entered numbers are :- 

                Num1 = 4

                Num2 = 0

....................................................................................................
Enter Numerator ro be Num(1 or 2) = 1
Enter Denominator to be Num (1 or 2) = 2
Err ! CANNOT BE dIVIDED BY ZERO 
java.lang.ArithmeticException: / by zero

....................................................................................................


@EXCEPTIONHANDLING

____________________________________________________________________________________________________


Press
                1.To Divide
                0.To Terminate
Enter Choice = 1

....................................................................................................
Exception will be Handled in Following cases :-
        1.If Num1 or Num2 are not Integers
        2.If Index of numerator or Denominator is choosen greater than 2
        3.If the Denominator is zero

....................................................................................................

                Enter Num1 = 4

                Enter Num2 = 2
Entered numbers are :- 

                Num1 = 4

                Num2 = 2

....................................................................................................
Enter Numerator ro be Num(1 or 2) = 1
Enter Denominator to be Num (1 or 2) = 2
Answer of Division = 2

....................................................................................................


@EXCEPTIONHANDLING

____________________________________________________________________________________________________


Press
                1.To Divide
                0.To Terminate
Enter Choice = 0
Invalid Choice !!!
....................................................................................................
PS D:\Practice> 

*/
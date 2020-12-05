/*Derek Chun
 * TY2 CISC 1115
 * Assignment 5
 * Due 10/10/19
 * This program calculates the tax base on income,status and age
 */

import java.io.File;
import java.util.Scanner;
public class tax {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("tax.txt"));
    
    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
      }
    int status;
    Scanner Status = new Scanner(System.in);
    System.out.println("\nWhat is your status? Please enter 1 for single, 2 for married");
    status = Status.nextInt();
  //determines if using the Married() method or Single() method
    if(status == 2)
      Married();
    else if(status == 1)
      Single();
    else
      System.out.println("Please enter a correct number");
  
  }
  public static void Married(){//Method to calculate tax for a married couple
    int age, age2, YearBirth, YearBirth2, CurrentYear;
    double income, tax;
    String message;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("What was the year when you were born?");
    YearBirth = sc.nextInt();
    System.out.println("What was the year when your spouse was born?");
    YearBirth2 = sc.nextInt();
    System.out.println("What is the current year?");
    CurrentYear = sc.nextInt();
    
    age = CurrentYear - YearBirth;
    age2 = CurrentYear - YearBirth2;
    
    if(Age(age) || Age(age2))//If age or age2 is true then there is tax reduction, if both is false then there is no reduction
      System.out.println("You are eligable for Senior tax reduction");
    else
      System.out.println("You are not eligable for Senior tax reduction");
   
    System.out.println("What is your income for the year?");
    income = sc.nextInt();
    
    if(income <=10000 && (Age(age) || Age(age2))){//Income under 10000 and age or age2 is over 60
      tax = (income*0.06);
      tax = tax - (tax*0.1);
      
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      
      System.out.println("Status: Married, Income: $" + income + ", Tax: $" + tax + ", " + message);
     }
    else if(income > 10000 && (Age(age) || Age(age2)) ){//Income is over 10000 and age or age2 is over 60
      tax = ((income - 10000)*0.11 + 600);
      tax = tax - (tax*0.1);
      
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      
      System.out.println("Status: Married, Income: $" + income + ", Tax: $" + tax + ", " + message);
    }
    else if(income <= 10000 && (!Age(age) && !Age(age2)) ){//Income is under 10000 and age and age2 is under 60
      tax = (income*0.06);
      
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      
      System.out.println("Status: Married, Income: $" + income + ", Tax: $" + tax + ", " + message);
     }
    else if(income > 10000 && (!Age(age) && !Age(age2)) ){//Income is over 10000 and age and age2 is under 60
      tax = ((income - 10000)*0.11 + 600);
      
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      
      System.out.println("Status: Married, Income: $" + income + ", Tax: $" + tax + ", " + message);
    }
  }
  public static void Single(){//Method to calculate tax for single status
    int age, YearBirth,CurrentYear;
    double income, tax;
    String message;
    
    Scanner sc = new Scanner(System.in);
    System.out.println("What year when you were born?");
    YearBirth = sc.nextInt();
    System.out.println("What is the current year?");
    CurrentYear = sc.nextInt();
    
    age = CurrentYear - YearBirth;
    
    if(Age(age))
      System.out.println("You are eligable for Senior tax reduction");
    else
      System.out.println("You are not eligable for Senior tax reduction");
    
    System.out.println("What is your income for the year?");
    income = sc.nextInt();
    
    if(income <=10000 && Age(age)){//Income is under 10000 and age is over 60
      tax = (income*0.05);
      tax = tax - (tax*0.1);
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      System.out.println("Status: Single, Income: $" + income + ", Tax: $" + tax + ", " + message);
     }
    else if(income > 10000 && Age(age)){//Income is over 10000 and age is over 60
      tax = ((income - 10000)*0.1 + 500);
      tax = tax - (tax*0.1);
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      System.out.println("Status: Single, Income: $" + income + ", Tax: $" + tax + ", " + message);
    }
    else if(income <= 10000 && !Age(age)){//Income is under 10000 and age is under 60
      tax = (income*0.05);
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      System.out.println("Status: Single, Income: $" + income + ", Tax: $" + tax + ", " + message);
     }
    else if(income > 10000 && !Age(age)){//Income is over 10000 and age is under 60
      tax = ((income - 10000)*0.1 + 500);
      if(tax < 2000)
        message = ("Boo");
      else
        message = ("Yay!");
      System.out.println("Status: Single, Income: $" + income + ", Tax: $" + tax + ", " + message);
    }
    
  }
 
  public static boolean Age(int age){//returns true or false on whether or not age is over 60
   
   if(age >= 60)
    return true;
   else
    return false;
  }
}
/*Output
 * Person 1  
Status: 1 
Birth: 1990 
Year: 2019 
Income:9000 
 
Person 2 
Status: 1 
Birth: 1991 
Year: 2019 
Income:11000 
 
Person 3 
Status: 1 
Birth: 1950 
Year: 2019 
Income: 70000 
 
Person 4 
Status: 1 
Birth: 1951 
Year: 2019 
Income: 8000 

Person 5
Status: 2
Birth: 1976
Income: 9800

Person 6
Status: 2
Birth: 1983
Income: 70000

Person 7
Status: 2
Birth: 1952
Income: 9800

Person 8
Status: 2
Birth: 1953
Income: 45500

What is your status? Please enter 1 for single, 2 for married 
 [DrJava Input Box]
What year when you were born? 
 [DrJava Input Box]
What is the current year? 
 [DrJava Input Box]
You are not eligable for Senior tax reduction 
What is your income for the year? 
 [DrJava Input Box]

Status: Single, Income: $9000.0, Tax: $450.0, Boo

Status: Single, Income: $11000.0, Tax: $600.0, Boo

Status: Single, Income: $70000.0, Tax: $5850.0, Yay!

Status: Single, Income: $8000.0, Tax: $360.0, Boo

What is your status? Please enter 1 for single, 2 for married 
 [DrJava Input Box]
What was the year when you were born? 
 [DrJava Input Box]
What was the year when your spouse was born? 
 [DrJava Input Box]
What is the current year? 
 [DrJava Input Box]
You are not eligable for Senior tax reduction 
What is your income for the year? 
 [DrJava Input Box]

Status: Married, Income: $9800.0, Tax: $588.0, Boo

Status: Married, Income: $70000.0, Tax: $7200.0, Yay! 

Status: Married, Income: $9800.0, Tax: $529.2, Boo

Status: Married, Income: $45500.0, Tax: $4054.5, Yay! 


Trace:
Status = 1
YearBirth = 1990
CurrentYear = 2019
age = 29
income = 9000
tax = 450
message = Boo

Status = 2 
YearBirth = 1978
YearBirth2 = 1953
CurrentYear = 2019
age = 41
age2 = 66
income = 45500
tax = 4505 ->4054.5
message = Yay

HandCheck:
2019 - 1990 = 29
9000* 0.05 = 450

2019 - 1978 = 41
2019- 1953 = 66
45500 - 10000 = 35500
35500 * 0.11 = 3905
3905 + 600 = 4505
4505-(4505*0.1) = 4054.5








*/


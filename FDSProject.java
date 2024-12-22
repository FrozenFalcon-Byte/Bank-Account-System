package com.idk;
import java.util.Scanner;

class Bank{
  float interestRate;
  Bank(float interestRate){
    this.interestRate = interestRate;
  }
}

class Account extends Bank{
  Scanner sc = new Scanner(System.in);
  protected long accountNumber;
  protected String name;
  protected float balance;
  Account(long accountNumber, float balance, String name){
    super(7.25f);
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.name = name;
  }

  public void showBalance(){
    System.out.println("Current Account Balance is: ");
    System.out.println(balance);
  }

  public void withdraw(){
    System.out.println("Enter the amount you want to withdraw: ");
    int amt = sc.nextInt();
    if(amt > balance){
      System.out.println("Insufficient Balance!");
    }
    else{
      System.out.println("Amount withdrawn: " + amt);
      balance -= amt;
      showBalance();
    }

  }
  public void deposit(){
    // System.out.println("Under Construction");
    System.out.println("Enter the amount you want to deposit: ");
    float amt = sc.nextFloat();
    balance += amt;
    System.out.println("Amount Deposited: " + amt);
    showBalance();
  }

  public void menu(){
    int choice = 0;
    while(choice != 6){
      System.out.println("Welocome to <BankName>");
      System.out.println("Name: " + name + "\tAccount number: " + accountNumber);
      System.out.println("Enter the number corresponding to the operation you want to perform: ");
      System.out.println("1.Withdraw\n2.Deposit\n3.Show Balance\n4.Get Mini Statement\n5.Transaction History\n6.Exit");
      choice = sc.nextInt();
      switch(choice){
        case 1 ->  withdraw();
        case 2 ->  deposit();
        case 3 -> showBalance();
        case 6 -> System.out.println("Programm ended.");
        default -> System.out.println("invalid Input");
      }
    }
  }
}



public class FDSProject {
  public static void main(String[] args) {
    Account a = new Account(22310162,6900.00f,"Ajinkya Chavan");
    Account b = new Account(22311654, 10000, "Rashi Khandelwal");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Account number: ");
    int accountNumber = sc.nextInt();
    // sc.close();
    boolean isPinCorrect = false;

    switch(accountNumber){
      case 22310162:
        while(isPinCorrect == false){
          System.out.println("Enter the pin for the account: ");
          long pin = sc.nextLong();
          if(pin == 8494){
            isPinCorrect = true;
            a.menu();
          }
          else{
            System.out.println("Wrong Pin!! Please Try Again..");
          }
        }
        break;
        case 22311654:
        while(isPinCorrect == false){
          System.out.println("Enter the pin for the account: ");
          long pin = sc.nextLong();
          if(pin == 6969){
            isPinCorrect = true;
            b.menu();
          }
          else{
            System.out.println("Wrong Pin!! Please Try Again..");
          }
        }
          break;
        default:
          System.out.println("Invalid Account Number");
          break;
    }

    sc.close();
  }
}


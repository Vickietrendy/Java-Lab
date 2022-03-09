import java.util.Scanner;
import java.util.Date;

/**
 * Write a description of class AccountManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountManager
{
    // the account
    private Account account;
    // reader for reading user input
    private Scanner reader;

    /**
     * Constructor for objects of class AccountManager
     */
    public AccountManager(Account account)
    {
        this.account = account;
        reader = new Scanner(System.in);
    }

    public void start()
    {
        System.out.println("WELCOME TO THE ACCOUNT MANAGER APPLICATION");
        boolean finished = false;

        for(int i=0; i<3; i++)
        {
            // get amount
            System.out.print("Transaction amount to add?\n>");
            String inputAmount = reader.nextLine();
            double amount = Double.parseDouble(inputAmount);

            // get type
            System.out.print("Transaction type?\n>");
            String type = reader.nextLine();

            // get reference
            System.out.println("Transaction reference?");
            String reference = reader.nextLine();
        
            // date is today's date
            Date date = new Date();

           // create transaction and add to account
            Transaction transact5 = new Transaction(amount, type, reference, date);
            account.addTransaction(transact5);

            System.out.println("Transaction added");
            account.displayTransactions();
            
            // display balance
            System.out.println("Balance:" + account.getBalance());
        }
    }

    public static void main(String[] args)
    {
        Customer cust = new Customer("Fernando", "Alonso");
        Account account = new Account(cust, "12345");

        //create AccountManager object and call start method
        AccountManager manage = new AccountManager(account);
        manage.start();
    }
}

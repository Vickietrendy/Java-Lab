/**
 * represents a bank account
 *
 */
public class Account
{
    // the customer
    private Customer customer;
    // the account number
    private String accountNumber;
    // the account balance
    private double balance;
    // the maximum number of transactions
    private final int MAX_TRANSACTIONS = 10;         
    // array to hold transactions
    private Transaction[] transactions;   
    // the number of Transactions in the array                                 
    private int numberOfTransactions;       


    /**
     * assigns values of instance variables
     * @param customer is an object reference to the class Customer
     * @param accountNumber is the customer's account number
     */
    public Account(Customer customer, String accountNumber)
    {
        transactions = new Transaction[MAX_TRANSACTIONS];   
        numberOfTransactions = 0;
        this.customer = customer;
        this.accountNumber = accountNumber;
        balance = 0.0f;
    }
    
    /**
     * returns the account number
     * @return accountNumber returns the account number
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * returns the customer name
     * @return FirstName and LastName returns the customerName
     */
    public String getCustomerName()
    {
        return (customer.getFirstName() + " " + customer.getLastName());
    }

    /**
     * returns the account balance
     * @return balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * returns the number of transactions
     * @return numberOfTransactions
     */
    public int getNumberOfTransactions()
    {
        return numberOfTransactions;
    }
    
    /**
     * prints details of the account and its current transactions
     */
    public void displayTransactions()   
    {
        System.out.format("Account: %s\nCustomer: %s\n",
            accountNumber,this.getCustomerName());

        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];

            System.out.format("%4.2f    %s    %s    %s\n", trans.getAmount(),
                    trans.getType(),
                    trans.getReference(),
                    trans.getDateString());
        }
    }

    /**
     * adds a new Transaction object to the array of contained objects
     * @param newTransaction - shows all the new transactions 
     */
    public void addTransaction(Transaction newTransaction)
    {
        if(numberOfTransactions < MAX_TRANSACTIONS)
        {
            transactions[numberOfTransactions] = newTransaction;
            numberOfTransactions++;
        }
        updateBalance();
    }

    /**
     * assigns the array to get transactions
     * @return transactions
     */
    public Transaction[] getTransactions()
    {
        return transactions;
    }
    
    /**
     * gets the array of contained Transaction objects
     * @param reference shows the reference
     * @return target - exact transaction referenced
     */
    public Transaction getTransaction(String reference)
    {
       Transaction target = null;
       int i = 0;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               target = transactions[i];
               break;
           }
           i++;
       }
       return target;
    }
    
    /**
     * removes a contained Transaction object specified by its reference property.
     * @param reference the values
     */
    public void removeTransaction(String reference)
    {
       int i = 0;
       boolean found = false;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               found = true;
               break;
           }
           i++;
       }
       if(found)
       {
           for(int j=i;j<numberOfTransactions;j++)
           {
               transactions[j] = transactions[j+1];
           }
           transactions[numberOfTransactions]=null;
           numberOfTransactions--;
       }
       updateBalance();
    }

    //updates a contained Balance
    private void updateBalance()
    {
        double total = 0.0;   // total value of all transactions
        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];
            if (trans.getType().equals("CREDIT"))
            {
                total = total + trans.getAmount();
            }
            else if(trans.getType().equals("DEBIT"))
            {
                total = total - trans.getAmount();
            }
        }
        this.balance = total;    // assign total to account balance field
    }
    

    /**
     * returns a string representation of this object
     * @return accountNumber
     */
    public String toString()
    {
        return String.format("Account number: %s, Customer: %s", 
            accountNumber, this.getCustomerName());
    }

}


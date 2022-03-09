import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * represents a transaction
 * 
 */
public class Transaction
{
    // the transaction amount
    private double amount;
    // the transaction type
    private String type;
    // the transaction reference
    private String reference;
    // the transaction date
    private Date date;

    /**
     * Constructor for objects of class Transaction
     */
    public Transaction()
    {
        amount = 0;
        type = "C";
        reference = "default";
        date = new Date();
    }
    
    /**
     * Constructor for objects of class Transaction
     */
    public Transaction(String reference)
    {
        amount = 0;
        type = "C";
        this.reference = reference;
        date = new Date();
    }
    
    /**
     * Constructor for objects of class Transaction
     * 
     * @param amount    the transaction amount
     * @param type      the transaction type         
     * @param reference the transaction reference
     * @param date      the transaction date
     */
    public Transaction(double amount, String type, String reference, Date date)
    {
        this.amount = amount;
        this.type = type;
        this.reference = reference;
        this.date = date;
    }
    
    /**
     * returns the amount
     * 
     * @return  the transaction amount
     */
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * 
     * @return  the transaction type
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * returns the transaction reference
     * 
     * @return  the transaction reference
     */
    public String getReference()
    {
        return reference;
    }
    
    /**
     * returns the transaction date
     * 
     * @return  the transaction date
     */
    public Date getDate()
    {
        return date;
    }
    
    /**
     * returns a string representation of the transaction date
     * 
     * @return  the date string
     */
    public String getDateString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d, yyyy" ); 
        String dateString = formatter.format(date);
        return dateString;
    }
    
     /**
     * returns a string representation of the transaction 
     * 
     * @return  the string representation
     */
    @Override
    public String toString()
    {
        return String.format("Amount: %4.2f, Type: %s, Ref: %s,Date: %s",
            amount, type, reference, this.getDateString());
    }
    
     /**
     * Returns true if this object and the object under test have the
     * same value in the description property. 
     * Modify this method if you want to define equality differently
     *
     * @param o  the object to be tested for equality with this one
     * @return  true or false
     */
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Transaction test = (Transaction) o;
        if (this.reference.compareTo(test.reference) == 0)
            return true;
        else
            return false;
    }
}



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AccountTest
{
    private Customer customer1;
    private Transaction transact1;
    private Transaction transact2;
    private Transaction transact3;
    private Account account1;

    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        customer1 = new Customer("Fernando", "Alonso");
        transact1 = new Transaction(200.00, "CREDIT", "ref1", new java.util.Date());
        transact2 = new Transaction(100.00, "DEBIT", "ref2", new java.util.Date());
        transact3 = new Transaction(300.00, "CREDIT", "ref3", new java.util.Date());
        account1 = new Account(customer1, "12345");
        account1.addTransaction(transact1);
        account1.addTransaction(transact2);
        account1.addTransaction(transact3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testAddTransaction()
    {
        Transaction transact4 = new Transaction(200.00, "CREDIT", "test", new java.util.Date());
        account1.addTransaction(transact4);
        assertEquals(4, account1.getNumberOfTransactions());
        assertEquals(600.00, account1.getBalance(), 0.1);
        assertEquals("test",account1.getTransactions()[3].getReference());
    }
    

    @Test
    public void removeTransaction()
    {
        account1.removeTransaction("ref2");
    }
}




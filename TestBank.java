package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Test Class for the Savings and Checking account classes
 * and their methods.
 */
public class TestBank {

  private SavingsAccount savings;
  private CheckingAccount checking;

  // Set up a savings and checking acct.
  @Before
  public void setUp() {
    savings = new SavingsAccount(100.00);
    checking = new CheckingAccount(100.00);
  }

  // Test the deposit method.
  @Test
  public void testDeposit() {
    savings.deposit(50.00);
    checking.deposit(50.00);
    Assert.assertEquals(150.00, savings.getBalance(), 0.0);
    Assert.assertEquals(150.00, checking.getBalance(), 0.0);

    // Test throwing an exception.
    try {
      savings.deposit(-1.00);
      fail("An exception should have been thrown.");
    } catch (IllegalArgumentException e) { //Test passes.
    }

    try {
      checking.deposit(-1.00);
      fail("An exception should have been thrown.");
    } catch (IllegalArgumentException e) { //Test passes.
    }
  }

  // Tests the withdraw method for savings acct.
  @Test
  public void testWithdraw() {
    boolean savingsResult = savings.withdraw(50.00);
    Assert.assertTrue(savingsResult);
    Assert.assertEquals(50.00, savings.getBalance(), 0.0);

    boolean checkingResult = checking.withdraw(50.00);
    Assert.assertTrue(checkingResult);
    Assert.assertEquals(50.00, checking.getBalance(), 0.0);
  }


  // Test withdrawing more than the account amount.
  @Test
  public void testWithdrawFail() {
    boolean savingsResult = savings.withdraw(101.00);
    Assert.assertFalse(savingsResult);
    Assert.assertEquals(100.00, savings.getBalance(), 0.0);

    boolean checkingResult = checking.withdraw(101.00);
    Assert.assertFalse(checkingResult);
    Assert.assertEquals(100.00, checking.getBalance(), 0.0);
  }

  // Test the monthly maintenence method for savings acct.
  @Test
  public void testSavingsMonthlyMaintenance() {

    SavingsAccount savings2;
    savings2 = new SavingsAccount(500.00);

    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.withdraw(50.00);
    savings2.performMonthlyMaintenance();
    Assert.assertEquals(136.00, savings2.getBalance(), 0.0);
  }

  // Test the monthly maintenence method for the checking acct.
  @Test
  public void testCheckingMonthlyMaintenance() {
    checking.withdraw(50.00);
    checking.performMonthlyMaintenance();
    Assert.assertEquals(45.00, checking.getBalance(), 0.0);
  }

  @Test
  public void testToString() {
    Assert.assertEquals("$100.00", checking.toString());
    Assert.assertEquals("$100.00", savings.toString());
  }
}
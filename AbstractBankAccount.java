package bank;

/**
 * Class Abstract Bank Account implements the bank account interface
 * and related methods.
 */
public abstract class AbstractBankAccount implements bank.IAccount {

  protected double balance;

  protected int withdrawalCounter;

  protected int balanceTracker;

  /**
   * Constructs a bank account object using a specified starter amount.
   * @param starterAmount The starting amount of money in the account.
   */
  public AbstractBankAccount(double starterAmount) {
    this.withdrawalCounter = 0;
    this.balanceTracker = 0;
    if (starterAmount >= 0.01) {
      this.balance = starterAmount;
    }
    else {
      throw new IllegalArgumentException("The" +
              " starter amount must be greater than or equal to one cent.");
    }
  }

  public double getBalance() {

    return this.balance;
  }

  /**
   * Deposits a specified amount into an account.
   * @param amount The amount to be deposited.
   */
  public void deposit(double amount) {
    if (amount < 0.00) {
      throw new IllegalArgumentException("Amount must be positive.");
    }
    this.balance += amount;
  }


  /**
  * Creates a string representation of the balance in an acct.
  * @return A string representation of the balance in an acct.
  */

  public String toString() {

    return String.format("$%.2f", this.balance);
  }
}
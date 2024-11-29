package bank;

/**
 * This interface represents a bank account. It is the super-type for
 * any other type of traditional financial account a bank might offer.
 */

public interface IAccount {

  /**
   * Takes a double representing the amount deposited into the acct.
   * @param amount The amount to be deposited.
   * @throws IllegalArgumentException If amount to deposit is negative.
   */
  void deposit(double amount);

  /**
   * Reduces the account balance by the amount to be withdrawn.
   * @param amount The amount ot withdraw.
   * @return Boolean True if successful transaction.  False otherwise.
   */
  boolean withdraw(double amount);

  /**
   * Checks the account balance and returns as a double.
   * @return The account balance as a double.
   */
  double getBalance();

  /**
   * Charge account fees and reset transaction counters to zero.
   */
  void performMonthlyMaintenance();
}
package bank;
/**
 * This class represents a savings account.  It offers all the operations mandated by the
 * IAccount interface.
 */

public class SavingsAccount extends AbstractBankAccount {

  /**
   * Construct a SavingsAccount object using the given starter amount.
   * @param starterAmount The initial amount of money in the acct.
   */

  public SavingsAccount(double starterAmount) {
    super(starterAmount);
  }

  @Override
  public boolean withdraw(double amount) {

    if (this.balance >= amount && amount > 0) {
      this.balance -= amount;
      this.withdrawalCounter += 1;
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public void performMonthlyMaintenance() {
    if (this.withdrawalCounter > 6) {
      this.balance -= 14;
    }
    this.withdrawalCounter = 0;
  }
}

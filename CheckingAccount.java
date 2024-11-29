package bank;
/**
 * This class represents a checking account.  It offers all the operations mandated by the
 * IAccount interface.
 */

public class CheckingAccount extends AbstractBankAccount {

  /**
   * Construct a CheckingAccount object using the given starter amount.
   * @param starterAmount The initial amount of money in the acct.
   */

  public CheckingAccount(double starterAmount) {
    super(starterAmount);
  }

  @Override
  public boolean withdraw(double amount) {
    if (balance >= amount && amount > 0) {
      balance -= amount;
      if (balance < 100) {
        balanceTracker += 1;
      }
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public void performMonthlyMaintenance() {
    if (this.balanceTracker > 0) {
      balance -= 5;
    }
    this.balanceTracker = 0;
    this.withdrawalCounter = 0;
  }
}


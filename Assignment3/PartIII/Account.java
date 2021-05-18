 
public class Account {

  private static int count = 1;
  private double balance;
  private int id;

  public Account() {
    balance = 0;
    id = count;
    count++;
  }

  public Account(double startingBalance) {
    balance = startingBalance;
    id = count;
    count++;
  }

  public boolean withdraw(double amount) {
    if (balance < amount)
      return false;
    else
      balance -= amount;
    return true;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public int getId() {
    return id;
  }
}

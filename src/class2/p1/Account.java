package class2.p1;

public class Account {

    private int accountNo;

    private String password;

    private int balance;

    public Account(String password, int balance) {
        this.accountNo = 1234;
        this.password = password;
        this.balance = balance;
    }

    // put a validation of my choice
    public int getBalance(String password) {
        if (password == this.password) {
            return balance;
        }
        return -1;
    }

    public int withdrawMoney(String password) {
        return 0;
    }

    public String setPassword(String oldPassword, String newPassword) {
        if (oldPassword == password) {
            this.password = newPassword;
            return "Password updated succesfully";
        }
        else {
            return "Password enter correct original password";
        }
    }
}

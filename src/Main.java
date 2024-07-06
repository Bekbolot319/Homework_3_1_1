
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withdraw(6000);
                System.out.println("Успешно снято 6000 сом. Остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Недостаточно средств на счете. Остаток: " + e.getRemainingAmount());
                try {
                    account.withdraw((int) e.getRemainingAmount());
                    System.out.println("Снята оставшаяся сумма: " + e.getRemainingAmount());
                } catch (LimitException _) {

                }
                break;
            }
        }
    }
}
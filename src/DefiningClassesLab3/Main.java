package DefiningClassesLab3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        Map<Integer, BankAccount> accountsMap = new HashMap<>();
        while(!command.equals("End")){
            String[] tokens = command.split("\\s+");
            String output = null;
            switch(tokens[0]){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountsMap.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    BankAccount bankAccount1 = accountsMap.get(id);
                    output = executeIfNotNull(bankAccount1, b -> {
                        b.deposit(amount);
                        return String.format("Deposited %d to ID%d", amount, id);
                    });
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    int idInterest = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount bankAccount2 = accountsMap.get(idInterest);
                    output = executeIfNotNull(bankAccount2, b -> {
                        double interest = b.getInterest(years);
                        return String.format("%.2f", interest);
                    });
                    break;
            }
            if(output != null){
                System.out.println(output);
            }
            command = sc.nextLine();
        }
    }

    public static String executeIfNotNull(BankAccount bankaccount,
                                          Function<BankAccount, String> function){
        if(bankaccount == null){
            return  "Account does not exist";
        }

        return function.apply(bankaccount);
    }
}

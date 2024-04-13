package views.accountReconcilation;

import models.account.AccountPayable;
import models.account.AccountReceivable;
import models.account.GeneralLedger;
import views.accountReconcilation.services.AccountPayableService;
import views.accountReconcilation.services.AccountReceivableService;
import views.accountReconcilation.services.GeneralLedgerService;
import views.accountReconcilation.services.ReconciliationManager;

import java.util.List;
import java.util.Scanner;

public class AccountReconciliationView {

    AccountPayableService accountPayableService = new AccountPayableService();
    AccountReceivableService accountReceivableService = new AccountReceivableService();

    GeneralLedgerService generalLedgerService = new GeneralLedgerService();


    public void displayReconciliationView(){
        System.out.println("-------------Displaying Account Reconciliation View--------------------");
        //write code to display options to add or view entries of accountPayable and accountReceivable then also view general ledger entries

        System.out.println("1. Add Account Payable Entry");
        System.out.println("2. Add Account Receivable Entry");
        System.out.println("3. View General Ledger Entries");
        System.out.println("4.View Account Payable Entries");
        System.out.println("5.View Account Receivable Entries");
        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter your choice from the Account Reconciliation View menu: ");
            int choice;

            // Validate input to ensure it's an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("------------Adding to Account Payable-----------------");
                        AccountPayable accountPayable = new AccountPayable();

                        System.out.println("Enter account payable description: ");
                        accountPayable.setDescription(scanner.nextLine());

                        System.out.println("Enter account payable amount: ");
                        accountPayable.setAmount(scanner.nextDouble());

                        accountPayableService.saveAccountPayable(accountPayable);

                        break;
                    case 2:
                        System.out.println("------------Adding to Account Receivable-----------------");
                        AccountReceivable accountReceivable = new AccountReceivable();

                        System.out.println("Enter account receivable description: ");
                        accountReceivable.setDescription(scanner.nextLine());

                        System.out.println("Enter account receivable amount: ");
                        accountReceivable.setAmount(scanner.nextDouble());

                        accountReceivableService.saveToAccountsReceivable(accountReceivable);

                        break;
                    case 3:
                        System.out.println("---------------Viewing General Ledger Entries-----------------");

                        List<GeneralLedger> generalLedgerEntries = generalLedgerService.getAllGeneralLedgerEntries();

                        System.out.println("ID\t\tAmount\t\tDescription\t\tReconciled");

                        if (generalLedgerEntries.isEmpty()) {
                            System.out.println("No general ledger entries found.");
                        } else {
                            for (GeneralLedger generalLedgerEntry : generalLedgerEntries) {
                                System.out.println(generalLedgerEntry.getId() + "\t\t" + generalLedgerEntry.getAmount() + "\t\t" + generalLedgerEntry.getDescription() + "\t\t" + generalLedgerEntry.isReconciled());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("----------------Viewing Account Payable Entries-----------------");

                        List<AccountPayable> accountPayableEntries = accountPayableService.getAllAccountPayableEntries();

                        System.out.println("ID\t\tAmount\t\tDescription\t\tReconciled");

                        if (accountPayableEntries.isEmpty()) {
                            System.out.println("No account payable entries found.");
                        } else {
                            for (AccountPayable accountPayableEntry : accountPayableEntries) {
                                System.out.println(accountPayableEntry.getId() + "\t\t" + accountPayableEntry.getAmount() + "\t\t" + accountPayableEntry.getDescription() + "\t\t" + accountPayableEntry.isReconciled());
                            }
                        }

                        System.out.println("Would you like to reconcile an account payable entry? (Y/N)");
                        String reconcileChoice = scanner.nextLine();
                        if (reconcileChoice.equalsIgnoreCase("N")){
                            break;
                        }

                        System.out.println("Enter the ID of the account payable entry you want to reconcile: ");
                        String id = scanner.nextLine();
                        AccountPayable accountPayableToReconcile = accountPayableService.getById(id);
                        reconcileAccountPayable(accountPayableToReconcile);
                        System.out.println("Account payable entry reconciled successfully.");

                        break;
                    case 5:
                        System.out.println("----------------Viewing Account Receivable Entries-----------------");

                        System.out.println("ID\t\tAmount\t\tDescription\t\tReconciled");

                        if (accountReceivableService.getAllAccountReceivableEntries().isEmpty()) {
                            System.out.println("No account receivable entries found.");
                        } else {
                            for (AccountReceivable accountReceivableEntry : accountReceivableService.getAllAccountReceivableEntries().values()) {
                                System.out.println(accountReceivableEntry.getId() + "\t\t" + accountReceivableEntry.getAmount() + "\t\t" + accountReceivableEntry.getDescription() + "\t\t" + accountReceivableEntry.isReconciled());
                            }
                        }

                        System.out.println("Would you like to reconcile an account receivable entry? (Y/N)");
                        reconcileChoice = scanner.nextLine();
                        if (reconcileChoice.equalsIgnoreCase("N")){
                            break;
                        }

                        System.out.println("Enter the ID of the account receivable entry you want to reconcile: ");
                        id = scanner.nextLine();
                        AccountReceivable accountReceivableToReconcile = accountReceivableService.getById(id);
                        reconcileAccountReceivable(accountReceivableToReconcile);
                        System.out.println("Account receivable entry reconciled successfully.");

                        break;
                    case 6:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }

    }

    public void reconcileAccountPayable(AccountPayable accountPayable){
        ReconciliationManager reconciliationManager = new ReconciliationManager();

        reconciliationManager.setReconciliationStrategy(new AccountPayableService());

        reconciliationManager.reconcileAccount(accountPayable);
    }

    public void reconcileAccountReceivable(AccountReceivable accountReceivable){
        ReconciliationManager reconciliationManager = new ReconciliationManager();

        reconciliationManager.setReconciliationStrategy(new AccountReceivableService());

        reconciliationManager.reconcileAccount(accountReceivable);
    }

}

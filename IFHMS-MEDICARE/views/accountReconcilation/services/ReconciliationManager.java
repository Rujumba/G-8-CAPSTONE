package views.accountReconcilation.services;


import views.accountReconcilation.ReconciliationStrategy;

public class ReconciliationManager {
    private ReconciliationStrategy reconciliationStrategy;

    /**
     * Sets the reconciliation strategy
     * either AccountPayableService or AccountReceivableService since they
     * implement the ReconciliationStrategy interface
     */
    public void setReconciliationStrategy(ReconciliationStrategy reconciliationStrategy){
        this.reconciliationStrategy = reconciliationStrategy;
    }

    /**
     * Routes the reconciliation to the appropriate strategy
     */
    public void reconcileAccount(Object obj){
        if (reconciliationStrategy != null){
            reconciliationStrategy.reconcile(obj);
        } else{
            System.out.println("No reconcile strategy set");
        }
    }
}

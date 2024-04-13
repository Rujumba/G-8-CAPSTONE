package repository.accountRepositories;


import models.account.GeneralLedger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralLedgerRepository {
    /**
     * List of general ledger entries
     */
    private List<GeneralLedger> generalLedgerList= new ArrayList<>();;

    /**
     * Adds to a file all the general ledger objects
     */
    public void addGeneralLedger(GeneralLedger generalLedger) {
        String filename = "GeneralLedger2.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(generalLedger);
            System.out.println("GeneralLedger object saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns all general ledger entries for the file and stores them in a list
     */
    public List<GeneralLedger> getAllGeneralLedgerEntries() {

        String filename = "GeneralLedger2.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GeneralLedger generalLedger;
            while ((generalLedger = (GeneralLedger) ois.readObject()) != null) {
                generalLedgerList.add(generalLedger);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return generalLedgerList;
    }

}

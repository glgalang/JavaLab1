package Lab1;
//Lab1.2
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionProcessing {

    final private static Logger logger = Logger.getLogger(TransactionProcessing.class.getName());

    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main (String[] args){
        init();
        //showTransaction();
        for(Transaction action : transactions){
            //anotherShowTransaction(action);
        }

        billChecker();

    }

    public static void init(){
        MoneyTransfer firstMoneyTransfer = new MoneyTransfer();
        MoneyTransfer secondMoneyTransfer = new MoneyTransfer();
        MoneyTransfer thirdMoneyTransfer = new MoneyTransfer();
        MoneyTransfer fourthMoneyTransfer = new MoneyTransfer();
        MoneyTransfer fifthMoneyTransfer = new MoneyTransfer();
        transactions.add(firstMoneyTransfer);
        transactions.add(secondMoneyTransfer);
        transactions.add(thirdMoneyTransfer);
        transactions.add(fourthMoneyTransfer);
        transactions.add(fifthMoneyTransfer);

        Bills firstBill = new Bills();
        Bills secondBill = new Bills();
        Bills thirdBill = new Bills();
        transactions.add(firstBill);
        transactions.add(secondBill);
        transactions.add(thirdBill);

        BuyLoad firstBuyLoad = new BuyLoad();
        BuyLoad secondBuyLoad = new BuyLoad();
        BuyLoad thirdBuyLoad = new BuyLoad();
        BuyLoad fourthBuyLoad = new BuyLoad();
        BuyLoad fifthBuyLoad = new BuyLoad();
        transactions.add(firstBuyLoad);
        transactions.add(secondBuyLoad);
        transactions.add(thirdBuyLoad);
        transactions.add(fourthBuyLoad);
        transactions.add(fifthBuyLoad);

        AddAccountCredit firstAccountCredit = new AddAccountCredit();
        AddAccountCredit secondAccountCredit = new AddAccountCredit();
        transactions.add(firstAccountCredit);
        transactions.add(secondAccountCredit);

        AddGameCredit firstGameCredit = new AddGameCredit();
        AddGameCredit secondGameCredit = new AddGameCredit();
        AddGameCredit thirdGameCredit = new AddGameCredit();
        AddGameCredit fourthGameCredit = new AddGameCredit();
        AddGameCredit fifthGameCredit = new AddGameCredit();
        transactions.add(firstGameCredit);
        transactions.add(secondGameCredit);
        transactions.add(thirdGameCredit);
        transactions.add(fourthGameCredit);
        transactions.add(fifthGameCredit);

    }

    public static void showTransaction(){
        for(Transaction action : transactions){
            logger.log(Level.INFO, "Item : " + action);
        }
        logger.log(Level.INFO, "Size of the transactions arrayList : " + transactions.size());
    }

    public static void anotherShowTransaction (Transaction transaction){
        if(transaction instanceof AddAccountCredit){
            logger.log(Level.INFO, "The transaction is of type AddAccountCredit");
        }
        if(transaction instanceof AddGameCredit){
            logger.log(Level.INFO, "The transaction is of type AddGameCredit");
        }
        if(transaction instanceof Bills){
            logger.log(Level.INFO, "The transaction is of type Bills");
        }
        if(transaction instanceof BuyLoad){
            logger.log(Level.INFO, "The transaction is of type BuyLoad");
        }
        if(transaction instanceof MoneyTransfer){
            logger.log(Level.INFO, "The transaction is of type MoneyTransfer");
        }
    }

    private static void billChecker(){
        ArrayList<Transaction> bills = new ArrayList<>();
        for(Transaction action : transactions){
            if(action instanceof Bills){
                bills.add(action);
            }
        }
        Set<Transaction> uniqueBill = new HashSet<>(bills);

        for(Transaction bill : uniqueBill){
            if(bill instanceof Bills){
                logger.log(Level.INFO, "Unique bill: " + bill);
            }
        }

        logger.log(Level.INFO, "Unique bill count: " + uniqueBill.size());
        logger.log(Level.INFO, "Duplicate bill count: " + (bills.size() - uniqueBill.size()));
    }
}

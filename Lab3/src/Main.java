import com.FurnutureFactory.FactoryPrices;
import com.SaleObserver.*;
import com.PaymentStrategy.*;

public class Main {
    public static void main(String[] args) {
        //two users
        Observer client1 = new Subscriber("John");
        Observer client2 = new Subscriber("Stephen");

        //creating a Subsriber on Factory to be informed about Sales!
        Observable saleInform = new Publisher();
        saleInform.attach(client1);
        saleInform.attach(client2);

        //Notifying users about a sale of 10 %
        saleInform.notifyAllObservers();
        // Includes Chair and Bed objects creationg and final price calculations
        FactoryPrices factory = new FactoryPrices();
        // Setting 10% sale
        factory.SetSale(10);
        // Visitor Objects will calculate the final price with tax included.
        System.out.printf(" The final price is %s with the sale of %s percent! %n ", factory.CalculateChairFinalPrice(50), factory.GetSale());


        // Initiliazing strategy Object and choosing the actual Payment Strategy
        TicketCompany company = new TicketCompany(new Paypal());
        company.pay();
        // Chaning the strategy Object and choosing another Payment Strategy
        company = new TicketCompany(new OfficeTicket());
        company.pay();


    }
}
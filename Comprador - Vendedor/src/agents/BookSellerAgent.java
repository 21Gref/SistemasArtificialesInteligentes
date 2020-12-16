package agents;

import java.util.HashMap;
import behaviours.OfferRequestServer;
import behaviours.PurchaseOrderServer;
import gui.BookSellerGui;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BookSellerAgent extends Agent {

    private BookSellerGui bookSellerGui;
    private HashMap<String, Integer> catalogue;

    protected void setup() {
        catalogue = new HashMap<>();
        
        bookSellerGui = new BookSellerGui(this);
        bookSellerGui.setVisible(true);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("book-selling");
        sd.setName("book-trading");
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        addBehaviour(new OfferRequestServer(this));
        addBehaviour(new PurchaseOrderServer(this));
    }

    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        
        bookSellerGui.dispose();
        
        System.out.println("Seller agent " + getAID().getName() + "terminating");
    }

    public void update(final String title, final int price) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                catalogue.put(title, price);
                System.out.println(title + " inserted with a price of " + price);
            }
        });
    }
    
    public void reload(){
        bookSellerGui.reload();
    }
    
    public HashMap<String, Integer> getCatalogue() {
        return catalogue;
    }
}
package behaviours;

import agents.BookSellerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class PurchaseOrderServer extends CyclicBehaviour {

    BookSellerAgent sellerAgent;

    public PurchaseOrderServer(BookSellerAgent sellerAgent) {
        this.sellerAgent = sellerAgent;
    }

    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
        ACLMessage msg = sellerAgent.receive(mt);

        if (msg != null) {
            String title = msg.getContent();
            ACLMessage reply = msg.createReply();

            Integer price = sellerAgent.getCatalogue().remove(title);
            if (price != null) {
                reply.setPerformative(ACLMessage.INFORM);
                System.out.println(title + " sold to agent " + msg.getSender().getName());
                sellerAgent.reload();
            } else {
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("not-available");
            }
            sellerAgent.send(reply);
        } else {
            block();
        }
    }

}

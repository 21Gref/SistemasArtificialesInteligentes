package agentes;

import jade.core.Agent;
import jade.core.behaviours.*;

public class Agente extends Agent {
    protected void setup() {
        addBehaviour(new comportamiento(this));
    }
}

class comportamiento extends SimpleBehaviour {
    public comportamiento(Agent a) {
        super(a);
    }

    public void action() {
        System.out.println("Hola mundo de los agente.  Agente: " + myAgent.getAID().getName());
    }

    public boolean done() {
        return true;
    }
}
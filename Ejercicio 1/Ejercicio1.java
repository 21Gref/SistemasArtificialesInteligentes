package agentes;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Ejercicio1 extends Agent {
    protected void setup() {
        addBehaviour(new comportamiento1(this));
    }
}

class comportamiento1 extends Behaviour {
    public comportamiento1(Agent agente) {
        super(agente);
    }

    public void action() {
        System.out.println("Hola mundo de los agente.  Agente: " + myAgent.getAID().getName());
    }

    public boolean done() {
        return true;
    }
}
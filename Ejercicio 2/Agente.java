package agentes;

import jade.core.Agent;
import jade.core.behaviours.*;

public class Agente extends Agent {
    protected void setup() {
        addBehaviour(new comportamiento(this));
    }
}

class comportamiento extends SimpleBehaviour {
    
    int contador = 0;
    
    public comportamiento(Agent a) {
        super(a);
    }

    public void action() {
        System.out.println("Número: " + (contador+1));
        contador++;
    }

    public boolean done() {
        return contador >= 100;
    }
}
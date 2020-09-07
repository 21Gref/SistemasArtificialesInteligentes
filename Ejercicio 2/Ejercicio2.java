package agentes;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Ejercicio2 extends Agent {
    protected void setup() {
        addBehaviour(new comportamiento2(this));
    }
}

class comportamiento2 extends Behaviour {    
    int contador = 0;

    comportamiento2(Agent agente) {
        super(agente);
    }
    public void action() {
        System.out.println("Número: " + (contador+1));
        contador++;
    }
    public boolean done() {
        return contador >= 100;
    }
}
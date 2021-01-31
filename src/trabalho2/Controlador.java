package trabalho2;

import java.util.ArrayList;

public class Controlador {
    private ArrayList pedidos;
    private float mediaFIFO;
    private float mediaSCAN;
    private float mediaSSTF;
    private float mediaCSCAN;
    private float mediaCLOOK;
    private int posCabecaLE;
    private int tamanhoDisco;
  
    Controlador(ArrayList pedidos, int posCabecaLE, int tamanhoDisco) {
        this.pedidos = pedidos;
        this.posCabecaLE = posCabecaLE;
        this.tamanhoDisco = tamanhoDisco;
        mediaFIFO = 0;
        mediaSCAN = 0;
        mediaSSTF = 0;
        mediaCSCAN = 0;
        mediaCLOOK = 0;
    }
  
    public void executarSimulacao() {
        mediaFIFO = new FIFO(pedidos, posCabecaLE, tamanhoDisco).executarFIFO();
        mediaSCAN = new SCAN(pedidos, posCabecaLE, tamanhoDisco).executarSCAN();
        mediaCSCAN = new CSCAN(pedidos, posCabecaLE, tamanhoDisco).executarCSCAN();
        /*mediaCLOOK = new CLOOK(pedidos, posCabecaLE, tamanhoDisco).executarCLOOK();*/
        mediaSSTF = new SSTF(pedidos, posCabecaLE, tamanhoDisco).executarSSTF();
    }
  
    public void mostrarResultado() {
        System.out.println("Médias de Deslocamentos");
        System.out.println("-----------------------");
        System.out.println("FIFO: "+mediaFIFO/pedidos.size());
        System.out.println("SCAN: "+mediaSCAN/(pedidos.size()+1));
        System.out.println("SSTF: "+mediaSSTF/pedidos.size());
        System.out.println("CSCAN: "+mediaCSCAN/(pedidos.size()+2));
        /*System.out.println("CLOOCK "+mediaCLOOK/pedidos.size());*/
    }  
}

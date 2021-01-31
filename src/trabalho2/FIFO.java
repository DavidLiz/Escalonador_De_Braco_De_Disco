package trabalho2;

import java.util.ArrayList;

public class FIFO {  
    private ArrayList listaPedidos;
    private int posCabLE;
    private int tamDisco;

    public FIFO(ArrayList listaPedidos, int posCabLE, int tamDisco) {
        this.listaPedidos = listaPedidos;
        this.posCabLE = posCabLE;
        this.tamDisco = tamDisco;
    }

    public float executarFIFO() {
        float media = 0;
        
        // Iniciar simulacao
        for (int i = 0; i < listaPedidos.size(); i++) {
            media += Math.abs(posCabLE - (int)listaPedidos.get(i));
            posCabLE = (int)listaPedidos.get(i);
        }
        return media;
    }  
}

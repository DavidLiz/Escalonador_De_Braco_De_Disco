package trabalho2;

import java.util.ArrayList;
import java.util.Collections;

public class Escalonador {
    
    /*  Valores Esperados  
        FIFO: 80
        SCAN: 26.22
        SSTF: 29.5
        CSCAN: 38.2 
        CLOOCK : 40.25
    */      
    
    private static void carregaDados(ArrayList pedidosAcessos) {
        System.out.println("Ler arquivo texto com os dados");
        pedidosAcessos.add(98);
        pedidosAcessos.add(183);
        pedidosAcessos.add(37);
        pedidosAcessos.add(122);
        pedidosAcessos.add(14);
        pedidosAcessos.add(124);
        pedidosAcessos.add(65);
        pedidosAcessos.add(67);
        Collections.shuffle(pedidosAcessos);
    }

    public static void main(String[] args) {
        System.out.println("Simulador de Escalonador de Braço de Disco");
        
        // Pedidos
        ArrayList pedidosAcessos = new ArrayList();
        carregaDados(pedidosAcessos);
        
        // Controlador
        Controlador controlador = new Controlador(pedidosAcessos, 53, 200);
        controlador.executarSimulacao();
        controlador.mostrarResultado();

    }  
}

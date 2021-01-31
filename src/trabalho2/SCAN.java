package trabalho2;

import java.util.ArrayList;

public class SCAN { 
    private ArrayList listaPedidos;
    private int posCabLE;
    private int tamDisco;
  
    public SCAN(ArrayList listaPedidos, int posCabLE, int tamDisco) {
        this.listaPedidos = listaPedidos;
        this.posCabLE = posCabLE;
        this.tamDisco = tamDisco;
    }
    
    // Ordena, em ordem crescente, a array de pedidos
    private void bubbleSort() {
      int troca;
      for (int i = 0; i < listaPedidos.size(); i++) {
        for (int j = 0; j < listaPedidos.size()-1; j++) {
          if ((int)listaPedidos.get(j) > (int)listaPedidos.get(j+1)) {
            troca = (int)listaPedidos.get(j);
            listaPedidos.set(j, listaPedidos.get(j+1));
            listaPedidos.set(j+1, troca);
          }
        }
      }
    }
  
    // Verifica a posiçao mais próxima a cabeça de leitura
    private int posicaoSaida() {
        int pos = 0;
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (posCabLE <= (int)listaPedidos.get(i)) {
                pos = i;
            }
            else {
                break;
            }
        }    
        return pos;
    }

    public float executarSCAN() {
        float media = 0;
        int posSaida;

        // Executa o algoritmo de ordenação e encontra a posição mais próxima a cabeça de leitura
        bubbleSort();
        posSaida = posicaoSaida();

        // Iniciar simulacao
        // Lado esquerdo
        for (int i = posSaida; i >= 0; i--) {
            media += Math.abs(posCabLE - (int)listaPedidos.get(i));
            posCabLE = (int)listaPedidos.get(i);
        }
        
        // Posiciona a cabeça no início do disco e soma o trajeto percorrido na média 
        media+= Math.abs(posCabLE);
        posCabLE = 0;

        // Lado direito
        for (int i = posSaida+1; i < listaPedidos.size(); i++) {
            media += Math.abs(posCabLE - (int)listaPedidos.get(i));
            posCabLE = (int)listaPedidos.get(i);
        }
        return media;
    }  
}

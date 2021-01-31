package trabalho2;

import java.util.ArrayList;

public class CLOOK {  
    private ArrayList listaPedidos;
    private int posCabLE;
    private int tamDisco;
  
    public CLOOK(ArrayList listaPedidos, int posCabLE, int tamDisco) {
        this.listaPedidos = listaPedidos;
        this.posCabLE = posCabLE;
        this.tamDisco = tamDisco;
    }
  
    // Ordena, em ordem crescente, a array de pedidos
    private void bubbleSort() {
        int troca;
        for (int i = 0; i < listaPedidos.size(); i++){
            for (int j = 0; j < listaPedidos.size()-1; j++){
                if ((int)listaPedidos.get(j) > (int)listaPedidos.get(j+1)){
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
        int valor = 1000;
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (Math.abs(posCabLE-(int)listaPedidos.get(i)) <= valor) {
                valor = Math.abs(posCabLE-(int)listaPedidos.get(i));
                pos = i;
            }
            else {
                break;
            }
        }    
        return pos;
    }
    
    public float executarCLOOK(){
        float media = 0;
        int posSaida;
        
        // Executa o algoritmo de ordenação e encontra a posição mais próxima a cabeça de leitura
        bubbleSort();
        posSaida = posicaoSaida();
        
        // Iniciar simulacao
        // Lado posterior a posição de saída
        for (int i = posSaida; i < listaPedidos.size(); i++) {
            media += Math.abs(posCabLE - (int)listaPedidos.get(i));
            posCabLE = (int)listaPedidos.get(i);
        }
                               
        // Posiciona a cabeça no início da lista de pedidos e soma o trajeto percorrido na média
        media += Math.abs(posCabLE-(int)listaPedidos.get(0));
        posCabLE = (int)listaPedidos.get(0);        
        
        // Lado anterior a posição de saída
        for (int i = 0; i < posSaida; i++) {
            media += Math.abs(posCabLE - (int)listaPedidos.get(i));
            posCabLE = (int)listaPedidos.get(i);
        }
        return media;
    }
}


package trabalho2;

import java.util.ArrayList;

public class SSTF {
    private ArrayList listaPedidos;
    private int posCabLE;
    private int tamDisco;
  
    public SSTF(ArrayList listaPedidos, int posCabLE, int tamDisco) {
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
           
    public float executarSSTF() {  
        int posSaida = posCabLE;       
        int media = 0;
        int index = 0;
        
        // Executa o algoritmo de ordenação
        bubbleSort();
        
        // Iniciar simulacao
        for(int n=0; n<listaPedidos.size();n++){
            int distancia = 10000;
            // Faz a varredura na lista de pedidos
            for(int i=0;i<listaPedidos.size();i++){
                // Verfica a posição mais próxima a cabeça de leitura
                if(Math.abs(posCabLE-(int)listaPedidos.get(i))<distancia){
                    distancia = Math.abs(posCabLE-(int)listaPedidos.get(i)); 
                    posSaida = (int)listaPedidos.get(i); // Guarda o conteúdo da posição mais próxima a cabeça de leitura
                    index = i; // Guarda o index da posição mais próxima a cabeça de leitura
                }
            }
            
            // Após encontrar a posição mais próxima, move a cabeça de leitura para essa posição
            posCabLE = posSaida;
            listaPedidos.set(index, 10000); // Troca o conteudo da posição por um número absurdo para que não seja escolhido mais de uma vez
            media+=distancia; // Soma a distância percorrida na média
        }
        return media;
    }   
}

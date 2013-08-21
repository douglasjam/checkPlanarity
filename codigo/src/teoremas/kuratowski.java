/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teoremas;

import java.util.*;
import checkPlanarity.matrizAdjacencia;

/**
 *
 * @author douglasjam
 */
public class kuratowski {

    public int kuratowski(matrizAdjacencia matriz) {
        ArrayList<String> m = new ArrayList<String>();
        m = matriz.getVertices();
        String[] a = new String[3]; // Para verificar grafo k3,3
        String[] b = new String[3]; // Para verificar grafo k3,3
        int posicaoA = 0, posicaoB = 0;

        for (int i = 0; i < m.size() - 1; i++) { // Verificando k5
            for (int j = 0; j < m.size() - 1;) {
                if (j == i && j + 1 < m.size() - 1) // Se a posição j é igual a posição do vértice q está sendo comparado incrementa
                {
                    j++;
                }
                if (matriz.temLigacao(m.get(i), m.get(j))) // Percorre toda matriz, verificando se o vértice na posição x tem ligação com todos os vértices
                {
                    j++;
                } else {
                    return 0; // Não é k5
                }
            }
        }
        for (int i = 0; i < m.size() - 1; i++) {
            for (int j = 0; j < m.size() - 1; j++) {
                if (matriz.temLigacao(m.get(i), m.get(j)) == false && a.length <= 3) {
                    a[posicaoA] = m.get(i);
                    posicaoA++;
                } else if (b.length <= 3) {
                    b[posicaoB] = m.get(j);
                    posicaoB++;
                }
            }
        }
        return 1;



    }
}

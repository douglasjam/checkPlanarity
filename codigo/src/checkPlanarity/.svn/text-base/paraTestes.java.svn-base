/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkPlanarity;

/**
 *
 * @author douglasjam
 */
public class paraTestes {

    public static void main(String[] args) {

        matrizAdjacencia matriz = new matrizAdjacencia("1 2 3\n7 6 4\n3 1\n4 2");
        String nossaMatriz[][] = matriz.getMatriz();
        matriz.imprimirMatriz();
        
        for (int i = 0; i < (matriz.getNumeroVertices())-1; i++) {
            for (int j = i + 1; j < matriz.getNumeroVertices(); j++) {
                if (nossaMatriz[i][j].equals("1")) {
                    System.out.println("<edge source=\"" + (i + 1) + "\" target=\"" + j + "\"></edge>\n");
                }
            }
        }
    }
}

/*
 *
 * Classe criada por Douglas J.A.M sob a responsabilidade do mesmo
 * que traz metodos uteis como criaçao da matriz a partir de um texto
 * escrito no formado
 * 1 2 3
 * 2 4
 * 1 5
 *
 * sendo que os membros nas mesmas linhas indicam que eles tem ligacoes
 * para criar basta criar um objeto dessa classe e no construtor
 * passar como argumento o arquivo de texto
 */
package checkPlanarity;

import java.util.ArrayList;
import java.util.Collections;

// construtor
public class matrizAdjacencia {

    ArrayList<String> vertices = new ArrayList<String>();
    String matriz[][];

    public matrizAdjacencia(String matrizAdjacencia) {
        contaVertices(matrizAdjacencia);
        criaMatriz();
        preencheMatriz(matrizAdjacencia);
        /*
        System.out.println("A matriz:");
        for (int i = 0; i < vertices.size(); i++) {
        for (int j = 0; j < vertices.size(); j++) {
        System.out.print(matriz[i][j] + " ");
        }
        System.out.println("");
        }

        if (temLigacao("3", "221")) {
        System.out.println("TEM LIGACAO!!");
        }
         */

    }

    public void imprimirMatriz() {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public String [][] getMatriz(){
        return this.matriz;
    }

    public final int getNumeroVertices() {
        return vertices.size();
    }

    public final String getVertice(int position){
        return vertices.get(position);
    }

    public int getNumeroArestas() {
        int numeroVertices = 0;


        for (int i = 0; i < (vertices.size())-1; i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
               if(matriz[i][j].equals("1"))
                   numeroVertices++;
            }
        }
        return numeroVertices;
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public ArrayList<String> getLigacoes(String vertice) {

        int posicaoMestra;
        ArrayList<String> retorno = null;

        if (vertices.contains(vertice)) {
            posicaoMestra = vertices.indexOf(vertice);
            for (int i = 0; i < vertices.size(); i++) {
                if (matriz[posicaoMestra][i].equals("1")) {
                    retorno.add(vertices.get(i));
                }
            }
        }

        return retorno;
    }

    public final boolean temLigacao(String a, String b) {
        boolean retorno = false;
        int posicaoA, posicaoB;

        if (vertices.contains(a)) {
            if (vertices.contains(b)) {
                posicaoA = vertices.indexOf(a);
                posicaoB = vertices.indexOf(b);
                if (matriz[posicaoA][posicaoB].equals("1")) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            }
            return retorno;
        }

        return retorno;
    }

    public final void criaMatriz() {
        matriz = new String[vertices.size()][vertices.size()];
    }

    public final void preencheMatriz(String matrizAdjacencia) {

        // preenchemos incialmente tudo com "0"

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                matriz[i][j] = "0";
            }
        }

        String[] a, b;
        ArrayList<Integer> conexoes = null;

        a = matrizAdjacencia.split("\\n");
        for (int i = 0; i < a.length; i++) {
            b = a[i].split(" ");
            // aqui pegou todos da linha, faremos agora uma super marcacao na matriz
            for (int k = 0; k < b.length; k++) {
                for (int l = 0; l < b.length; l++) {
                    matriz[vertices.indexOf(b[k])][vertices.indexOf(b[l])] = "1";
                }
            }
        }

    }

    public final void contaVertices(String matrizAdjacencia) {
        String[] a, b;

        a = matrizAdjacencia.split("\\n");
        for (int i = 0; i < a.length; i++) {
            b = a[i].trim().split(" ");
            for (int j = 0; j < b.length; j++) {
                if (!vertices.contains(b[j].trim())) {
                    vertices.add(b[j].trim());
                }
            }
        }
        // ordena
        Collections.sort(vertices);
        //System.out.println("A matriz tem " + vertices.size() + " vertices diferentes.");

    }
}
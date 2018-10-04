/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiempo_Metodos;


public class Metodos_Ordenamiento {

    int[] Arreglo_Aleatorio(int tamaño, int min, int max) {
        int[] arreglo = new int[tamaño];
        for (int x = 0; x < tamaño; x++) {
            arreglo[x] = Num_Aleatorio(min, max);
        }
        return arreglo;
    }

    int Num_Aleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo));
    }
    
    
     static void Burbuja(int[] arreglo) {
        int i, j, aux;
        for (i = 0; i < arreglo.length - 1; i++) {
            for (j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j + 1] < arreglo[j]) {
                    aux = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }

    static void M_QuickSort(int[] arreglo, int izquierda, int derecha) {
        int pivote, i, j, auxintercambio;
        pivote = arreglo[izquierda];
        i = izquierda;
        j = derecha;
        while (i < j) {
            while (arreglo[i] <= pivote && i < j) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i < j) {
                auxintercambio = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxintercambio;
            }
        }
        arreglo[izquierda] = arreglo[j];
        arreglo[j] = pivote;
        if (izquierda < j - 1) {
            M_QuickSort(arreglo, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            M_QuickSort(arreglo, j + 1, derecha);
        }
    }

   static void M_Insercion(int[] arreglo) {
        for (int x = 1; x < arreglo.length; x++) {
            int aux = arreglo[x];
            int y;
            for (y = x - 1; (y >= 0) && (arreglo[y] > aux); y--) {
                arreglo[y + 1] = arreglo[y];
            }
            arreglo[y + 1] = aux;
        }
    }

    static void M_Shell(int[] arreglo) {
        int n = arreglo.length;
        int i = n;
        do {
            i = i / 2;
            for (int x = 0; x < i; x++) {
                for (int y = i + x; y < n; y += i) {
                    int j = y;
                    while (j - i >= 0 && arreglo[j] < arreglo[j - i]) {
                        int tmp = arreglo[j];
                        arreglo[j] = arreglo[j - i];
                        arreglo[j - i] = tmp;
                        j -= i;
                    }
                }
            }
        } while (i > 1);
    }

    
}

    
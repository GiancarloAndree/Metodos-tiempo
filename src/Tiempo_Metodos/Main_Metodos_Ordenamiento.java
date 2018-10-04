/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiempo_Metodos;
import javax.swing.*;

public class Main_Metodos_Ordenamiento {
    private static int nRegistros;
    
    public static void main(String[] args) {
      

        boolean errorProceso = CantidadRegistros();
        if (!errorProceso) {
            MensajeDeOrdenamiento();
            Metodos_Ordenamiento datosOrdenamiento = new Metodos_Ordenamiento();
            int[] datosAleatorios = datosOrdenamiento.Arreglo_Aleatorio(nRegistros, 1, 1000000);
            long ejecucionQuickSort = TiempoEjecucionQuickSort(datosAleatorios);
            long ejecucionBurbuja = TiempoEjecucionBurbuja(datosAleatorios);
            long ejecucionShell = TiempoEjecucionShell(datosAleatorios);
            long ejecucionInsercion = TiempoEjecucionInsercion(datosAleatorios);
            String resultado = "|\tMetodo\t|     Tiempo de Ordenamiento\t|\n";
            resultado += "---------------------------------------------------------------------------------\n";
            resultado += "|\tQuickSort\t|\t" + ejecucionQuickSort + " ms\t|\n";
            resultado += "|\tBurbuja\t|\t" + ejecucionBurbuja + " ms\t|\n";
            resultado += "|\tShell\t|\t" + ejecucionShell + " ms\t|\n";
            resultado += "|\tInsercion\t|\t" + ejecucionInsercion + " ms\t|\n";
            JOptionPane.showMessageDialog(null, new JTextArea(resultado), "Resultado", JOptionPane.PLAIN_MESSAGE, null);
        } else {
            MensajeCancelar();
        }
    }

    private static boolean CantidadRegistros() {
        boolean salir = false;
        boolean verificacion = false;
        do {
            String texto = "Cantidad de registros:\n1). 1000\n2). 2000\n3). 5000\n4). 10 000\n5). 40 000\nIngrese una opcion [1-5]:\n";
            String nCantidadRegistro = JOptionPane.showInputDialog(null, texto);
            if (nCantidadRegistro == null) {
                salir = true;
            } else if (nCantidadRegistro.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingresa un opción");
            } else if (EsEntero(nCantidadRegistro)) {
                if (Integer.parseInt(nCantidadRegistro) > 0 && Integer.parseInt(nCantidadRegistro) < 9) {
                    OpcionRegistro(Integer.parseInt(nCantidadRegistro));
                    verificacion = true;
                } else {
                    MensajeRango();
                }
            } else {
                MensajeDatosEnteros();
            }
        } while (!verificacion && !salir);
        return salir;
    }

    private static void OpcionRegistro(int n) {
        switch (n) {
            case 1:
                nRegistros = 1000;
                break;
            case 2:
                nRegistros = 2000;
                break;
            case 3:
                nRegistros = 5000;
                break;
            case 4:
                nRegistros = 10000;
                break;
            case 5:
                nRegistros = 40000;
                break;
            
        }
    }

    private static long TiempoEjecucionShell(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Metodos_Ordenamiento.M_Shell(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionInsercion(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Metodos_Ordenamiento.M_Insercion(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionBurbuja(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Metodos_Ordenamiento.Burbuja(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionQuickSort(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Metodos_Ordenamiento.M_QuickSort(arreglo, 0, arreglo.length - 1);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static boolean EsEntero(String dato) {
        boolean verificacion = true;
        try {
            Integer.parseInt(dato);
        } catch (Exception e) {
            verificacion = false;
        }
        return verificacion;
    }

    private static void MensajeDeOrdenamiento() {
        JOptionPane.showMessageDialog(null, "Se ordenara de acuerdo al registro");
    }

    private static void MensajeDatosEnteros() {
        JOptionPane.showMessageDialog(null, "Digite datos enteros");
    }

    private static void MensajeRango() {
        JOptionPane.showMessageDialog(null, "Ingrese un numero entre [1-5]");
    }

    private static void MensajeCancelar() {
        JOptionPane.showMessageDialog(null, "Haz cancelado el procesor");
    }
}


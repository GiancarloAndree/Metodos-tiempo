/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_Tiempo;

import javax.swing.*;

public class Main_Tiempo_m {

    public static int numero_registro;

    public static void main(String[] args) {

        boolean errorProceso = Cantidad_Registros();
        if (!errorProceso) {
            MensajeDeOrdenamiento();
            Tiempo_M datosOrdenamiento = new Tiempo_M();
            int[] datosAleatorios = datosOrdenamiento.ArregloAleatorio(numero_registro, 1, 10000);
            long ejecucionQuickSort = TiempoEjecucionQuickSort(datosAleatorios);
            long ejecucionBurbuja = TiempoEjecucionBurbuja(datosAleatorios);
            long ejecucionShell = TiempoEjecucionShell(datosAleatorios);
            long ejecucionInsercion = TiempoEjecucionInsercion(datosAleatorios);
            String r = "|\tMetodo\t|     Tiempo de Ordenamiento\t|\n";
            r += "---------------------------------------------------------------------------------\n";
            r += "|\tQuickSort\t|\t" + ejecucionQuickSort + " ms\t|\n";
            r += "|\tBurbuja\t|\t" + ejecucionBurbuja + " ms\t|\n";
            r += "|\tShell\t|\t" + ejecucionShell + " ms\t|\n";
            r += "|\tInsercion\t|\t" + ejecucionInsercion + " ms\t|\n";
            JOptionPane.showMessageDialog(null, new JTextArea(r), "Resultado", JOptionPane.PLAIN_MESSAGE, null);
        } else {
            MensajeCancelar();
        }
    }

    private static boolean Cantidad_Registros() {
        boolean salir = false;
        boolean verificacion = false;
        do {
            String texto = "Cantidad de registros:\n1). 200\n2). 400\n3). 600\n4). 10 000\nIngrese una opcion [1-4]:\n";
            String nCantidadRegistro = JOptionPane.showInputDialog(null, texto);
            if (nCantidadRegistro == null) {
                salir = true;
            } else if (nCantidadRegistro.equals("")) {
                JOptionPane.showMessageDialog(null, "Escoga una opcion");
            } else if (Verificar_entero(nCantidadRegistro)) {
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
                numero_registro = 200;
                break;
            case 2:
                numero_registro = 400;
                break;
            case 3:
                numero_registro = 600;
                break;
            case 4:
                numero_registro = 10000;
                break;

        }
    }

    private static long TiempoEjecucionBurbuja(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Tiempo_M.Burbuja(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionInsercion(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Tiempo_M.Insercion(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionShell(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Tiempo_M.Shell(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionQuickSort(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Tiempo_M.QuickSort(arreglo, 0, arreglo.length - 1);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static boolean Verificar_entero(String dato) {
        boolean verificacion = true;
        try {
            Integer.parseInt(dato);
        } catch (Exception e) {
            verificacion = false;
        }
        return verificacion;
    }

    private static void MensajeDeOrdenamiento() {
        JOptionPane.showMessageDialog(null, "Se comenzará a ordenar los registros.\nEsto puede demorar unos segundos");
    }

    private static void MensajeDatosEnteros() {
        JOptionPane.showMessageDialog(null, "Solo puede ingresar datos enteros!");
    }

    private static void MensajeRango() {
        JOptionPane.showMessageDialog(null, "Ingrese un numero entre [1-8]");
    }

    private static void MensajeCancelar() {
        JOptionPane.showMessageDialog(null, "Acabas de cancelar ...");
    }
}

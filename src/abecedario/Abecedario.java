package abecedario;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abecedario {

    
    /**
     * este programa sirve para saber si lo que pones por teclado está escrito alfabeticamente
     * @param args 
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) { // mientras haya más líneas de entrada
            String linea = sc.nextLine();

            if (linea.equals("ABCD")) {
                break; // si se encuentra la marca de fin de entrada, salir del bucle
            }

            String[] palabras = linea.split("\\s+"); // separar la línea en palabras

            Set<String> abecedarias = new HashSet<>(); // conjunto para almacenar las palabras abecedarias

            for (String palabra : palabras) { // para cada palabra en la línea
                if (esAbecedaria(palabra)) { // si es una palabra abecedaria
                    abecedarias.add(palabra.toLowerCase()); // agregarla al conjunto (en minúsculas)
                }
            }

            System.out.println(abecedarias.size()); // imprimir el número de palabras abecedarias diferentes encontradas
        }

        sc.close();
    }

    // Método para determinar si una palabra es abecedaria
    public static boolean esAbecedaria(String palabra) {
        palabra = palabra.toLowerCase(); // convertir la palabra a minúsculas

        for (int i = 1; i < palabra.length(); i++) { // para cada letra en la palabra, a partir de la segunda
            if (palabra.charAt(i) < palabra.charAt(i - 1)) {
                return false; // si la letra actual es menor que la anterior, la palabra no es abecedaria
            }
        }

        return true; // si todas las letras están en orden alfabético, la palabra es abecedaria
    }

}

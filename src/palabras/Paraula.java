/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palabras;

/**
 *
 * @author AlejandroRodriguezB
 */
public class Paraula {
// Constants públiques

    public static final char blanc = ' ';
    public static final char fiSequencia = '.';
// Constants privades
// Llargària màxima d'una paraula
    private static final int MAXIM = 20;

// ATRIBUTS
    private char[] lletres;
    private int llargaria;

// atribut de classe, per simplificar les operacions de lectura
    private static char lletra = ' ';

// INTERFICIE
// Constructor

    public Paraula() {
        lletres = new char[MAXIM];
        llargaria = 0;
    }
    
// llegir una paraula de la seqüència d'entrada

    public static Paraula llegir() {
        Paraula nova = new Paraula();
        botarBlancs();
        while ((lletra != fiSequencia) && // No ha acabat la seqüència
                (lletra != blanc) && // No ha acabat la paraula
                (nova.llargaria < MAXIM)) { // Hi ha prou espai
            nova.lletres[nova.llargaria++] = lletra;
            lletra = Main.llegirCaracter();
        }
        
// per si la paraula té més de MAXIM lletres
        botarParaula();
        return nova;
    }

// Convertir un objecte Paraula en un String
    public String toString() {
        String msg = "";
        for (int idx = 0; idx < llargaria; idx++) {
            msg += lletres[idx];
        }
        return msg;
    }
// Per comparar amb une altre objecte Paraula

    public boolean esIgualA(Paraula b) {
        boolean iguals = llargaria == b.llargaria;
        for (int idx = 0; (idx < llargaria) && iguals; idx++) {
            iguals = lletres[idx] == b.lletres[idx];
        }
        return iguals;
    }
// Per comparar dos objectes Paraula. És un mètode de classe

    public static boolean iguals(Paraula a, Paraula b) {
// Fa ús del mètode esIgualA definit abans
        return a.esIgualA(b);
    }
// Per determinar si la paraula és buida

    public boolean buida() {
        return llargaria == 0;
    }
// Mètodes que no formen part de la interfície

// llegir el que sigui necessari fins començar la paraula
    public static void botarBlancs() {
        while (lletra == blanc) {
            lletra = Main.llegirCaracter();
        }
    }
// botar-se la resta de caràcters que puguin quedar si la
// paraula és massa llarga.

    public static void botarParaula() {
        while ((lletra != '.') && (lletra != blanc)) {
            lletra = Main.llegirCaracter();
        }
    }


}

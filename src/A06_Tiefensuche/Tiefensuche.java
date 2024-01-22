package A06_Tiefensuche;

import java.util.*;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

    @Override
    /**
     * Sortierkriterium im Baum: L�nge des Films
     */
    protected int compare(Film a, Film b) {

        return Double.compare(a.getL�nge(), b.getL�nge());
    }

    /**
     * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
     *
     * @param node Wurzelknoten des Teilbaums
     * @return Liste der Titel in symmetrischer Reihenfolge
     */
    public List<String> getNodesInOrder(Node<Film> node) {

        List<String> result = new ArrayList<>();
        Stack<Node<Film>> stack = new Stack<>();

        Node<Film> current = node;

        while (stack.isEmpty() == false || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            if (stack.isEmpty() == false) {
                current = stack.pop();
                result.add(current.getValue().getTitel());
                current = current.getRight();
            }

        }
        return result;

    }


    /**
     * Retourniert Titelliste jener Filme, deren L�nge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
     *
     * @param min Minimale L�nge des Spielfilms
     * @param max Maximale L�nge des Spielfilms
     * @return Liste der Filmtitel in Hauptreihenfolge
     */


    public List<String> getMinMaxPreOrder(double min, double max) {
        // Liste zur Speicherung der Ergebnisse
        List<String> result = new ArrayList<>();

        // Initialisierung: Zeiger auf den aktuellen Knoten und ein Stapel (Deque)
        Node<Film> current = root;
        Stack<Node<Film>> stack = new Stack<>();

        // Iteration, solange der aktuelle Knoten nicht null ist oder der Stapel nicht leer ist
        while (current != null || !stack.isEmpty()) {
            // Schleife, um so weit wie m�glich nach links zu gehen
            while (current != null) {
                // �berpr�fe, ob der aktuelle Knoten im Bereich von min bis max liegt
                if (current.getValue().getL�nge() >= min && current.getValue().getL�nge() <= max) {
                    // F�ge den Titel des aktuellen Knotens zur Ergebnisliste hinzu
                    result.add(current.getValue().getTitel());
                }

                // Lege das rechte Kind auf den Stapel, falls vorhanden
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }

                // Setze den aktuellen Knoten auf sein linkes Kind
                current = current.getLeft();
            }

            // Wenn wir nicht weiter nach links gehen k�nnen, betrachte das rechte Kind des aktuellen Knotens
            // und setze den aktuellen Knoten auf das rechte Kind oder hole einen Knoten vom Stapel
            if (!stack.isEmpty()) {
                current = stack.pop();
            }
        }

        // R�ckgabe der Ergebnisliste
        return result;
    }

}

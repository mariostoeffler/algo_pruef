package A06_Tiefensuche;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

    @Override
    /**
     * Sortierkriterium im Baum: Länge des Films
     */
    protected int compare(Film a, Film b) {

        return Double.compare(a.getLänge(), b.getLänge());
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
     * Retourniert Titelliste jener Filme, deren Länge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
     *
     * @param min Minimale Länge des Spielfilms
     * @param max Maximale Länge des Spielfilms
     * @return Liste der Filmtitel in Hauptreihenfolge
     */
    public List<String> getMinMaxPreOrder(double min, double max) {

        return null;
    }

}

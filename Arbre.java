import java.util.LinkedList;
import java.util.Queue;

public class Arbre {

    private Noeud racine;

    public Arbre() {
        this.racine = null;
    }

    public Arbre(Noeud racine) {
        this.racine = racine;
    }

    public void insertion(Noeud nd) {
        if (this.racine == null) {
            this.racine = nd;
            return;
        }
        Queue<Noeud> queue = new LinkedList<>();
        queue.add(racine);
        while (!queue.isEmpty()) {
            Noeud current = queue.poll();
            if (current.getFils_gauche() == null) {
                current.setFils_gauche(nd);
                return;
            }
            if (current.getFils_droit() == null) {
                current.setFils_droit(nd);
                return;
            }
            queue.add(current.getFils_gauche());
            queue.add(current.getFils_droit());
        }
    }

    public void printInOrder() {
        System.out.print("In-order traversal: ");
        printInOrder(racine);
        System.out.println();
    }

    private void printInOrder(Noeud node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getFils_gauche());
        System.out.print(node.getLibelle() + " ");
        printInOrder(node.getFils_droit());
    }


    // utility function to print the binary tree horizontally
    private void printTree(Noeud node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.getFils_droit(), level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getLibelle());
        printTree(node.getFils_gauche(), level + 1);
    }


    // recursive function to get the level of a node in the binary tree
    private int getLevel(Noeud node, char key, int level) {
        if (node == null) {
            return 0;
        }
        if (node.getLibelle() == key) {
            return level;
        }
        int leftLevel = getLevel(node.getFils_gauche(), key, level + 1);
        if (leftLevel != 0) {
            return leftLevel;
        }
        return getLevel(node.getFils_droit(), key, level + 1);
    }

    // wrapper function to call the recursive function
    public int getLevel(char key) {
        return getLevel(racine, key, 1);
    }

    public int Alpha_Beta(Noeud nd, int A, int B) {
        // Si le noeud est une feuille
        if (nd.est_Feuille())
            return nd.getPoid();

        // Sinon, Initialiser Alpha et Beta de nd
        int Alpha = -1000;
        int Beta = 1000;

        // Si c'est un noeud Min
        if (this.getLevel(nd.getLibelle()) % 2 == 0) {
            int Val = Alpha_Beta(nd.getFils_gauche(), A, Math.min(B, Beta));
            Beta = Math.min(Beta, Val);
            // Coupure
            if (A >= Beta) {
                System.out.println("Coupure, Le noeud " + nd.getFils_droit().getLibelle() + " va pas etre traite");
                return Beta;
            }
            Val = Alpha_Beta(nd.getFils_droit(), A, Math.min(B, Beta));
            Beta = Math.min(Beta, Val);
            return Beta;
        }
        // Si c'est un noeud max
        else {
            int Val = Alpha_Beta(nd.getFils_gauche(), Math.max(A, Alpha), B);
            Alpha = Math.max(Alpha, Val);
            // Coupure
            if (Alpha >= B) {
                System.out.println("Coupure, le noeud " + nd.getFils_droit().getLibelle() + " va pas etre traite");
                return Alpha;
            }
            Val = Alpha_Beta(nd.getFils_droit(), Math.max(A, Alpha), B);
            Alpha = Math.max(Alpha, Val);
            return Alpha;
        }
    }


    public static void main(String[] args) {
        Arbre arb = new Arbre(new Noeud('C', 0));
        arb.insertion(new Noeud('D', 0));
        arb.insertion(new Noeud('E', 0));
        arb.insertion(new Noeud('F', 0));
        arb.insertion(new Noeud('G', 0));
        arb.insertion(new Noeud('H', 0));
        arb.insertion(new Noeud('Q', 0));
        arb.insertion(new Noeud('I', 8));
        arb.insertion(new Noeud('K', 7));
        arb.insertion(new Noeud('L', 9));
        arb.insertion(new Noeud('M', 2));
        arb.insertion(new Noeud('O', 4));
        arb.insertion(new Noeud('R', 3));
        arb.insertion(new Noeud('S', 1));
        arb.insertion(new Noeud('T', 5));
        arb.printTree(arb.racine,5);
        //System.out.println(arb.getLevel(arb.racine.getFils_gauche().getFils_gauche().getLibelle()) % 2);
        System.out.println("Poid = " + arb.Alpha_Beta(arb.racine,-1000,1000));

    }
}

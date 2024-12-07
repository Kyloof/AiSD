import java.util.*;

public class Graph {
    int V;
    LinkedList<RecipeEdge>[] productList;
    ArrayList<Integer> finalProducts;
    ArrayList<String> productNames;
    ArrayList<Integer> leftOvers;

    public Graph(int V) {
        this.V = V;
        productList = new LinkedList[V];
        finalProducts = new ArrayList<>(Collections.nCopies(V, 0));
        leftOvers = new ArrayList<>(Collections.nCopies(V,0));
        productNames = new ArrayList<>(Collections.nCopies(V, ""));

        for (int i = 0; i < V; i++) {
            productList[i] = new LinkedList<>();
        }
    }

    void addEdge(int dest, int src, int ratio, String name) {
        productList[dest].add(new RecipeEdge(src, ratio, name));
    }

    void setProductName(int product, String name) {
        productNames.set(product, name);
    }

    void addFinalProduct(int product, int amount) {
        finalProducts.set(product, amount);
    }

    void showGraph() {
        for (int i = 0; i < V; i++) {
            for (RecipeEdge edge : productList[i]) {
                System.out.println(productNames.get(i) + " <- " + productNames.get(edge.src) + " | " + " (ratio: " + edge.ratio + ")");
            }
        }
    }
    void addLeftover(int product, int amount) {
        leftOvers.set(product, amount);
    }
    void calculateInitialProducts() {
        ArrayList<Integer> initialProducts = new ArrayList<>(Collections.nCopies(V, 0));

        // Find the element that is cooked and the amount of it is known
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        //BFS
        for (int i = 0; i < V; i++) {
            if (finalProducts.get(i) > 0) {
                queue.add(i);
                initialProducts.set(i, finalProducts.get(i));
                visited[i] = true;
            }
        }
        //BFS
        // Calculate the required amount to make the pancake
        while (!queue.isEmpty()) {
            int product = queue.poll();

            for (RecipeEdge edge : productList[product]) {
                int requiredAmount = initialProducts.get(product) * edge.ratio;

                if (!visited[edge.src]) {
                    queue.add(edge.src);
                    visited[edge.src] = true;
                }
                // using leftovers calculate the initial state
                initialProducts.set(edge.src, leftOvers.get(edge.src) + requiredAmount);
            }
        }

        System.out.println();
        // Output initial state
        System.out.println("Poczatkowy stan: ");
        for (int i = 0; i < 6; i++) {
            if (!productNames.get(i).isEmpty()) {
                System.out.print(productNames.get(i) + ": " + initialProducts.get(i));
                System.out.println(" MASS");

            }
        }
    }

    public static void main(String[] args) {
        Graph recipe = new Graph(9);

        // Set product names
        recipe.setProductName(1, "mleko");
        recipe.setProductName(2, "jajko");
        recipe.setProductName(3, "jablka");
        recipe.setProductName(4, "cynamon");
        recipe.setProductName(5, "maka");
        recipe.setProductName(6, "ciasto");
        recipe.setProductName(7, "jablka z cynamone");
        recipe.setProductName(8, "nalesniki");

        // Define edges (recipe steps)
        recipe.addEdge(6, 1, 2, "mleko" ); // ciasto <- mleko
        recipe.addEdge(6, 2, 1, "jajko"); // ciasto <- jajko
        recipe.addEdge(6, 5, 5, "maka"); // ciasto <- maka
        recipe.addEdge(7, 3, 1, "jablka"); // jablka z cynamone <- jablka
        recipe.addEdge(7, 4, 1, "cynamon"); // jablka z cynamone <- cynamon
        recipe.addEdge(8, 7, 2, "jablka z cynamonem"); // nalesnik <- jablka z cynamonem
        recipe.addEdge(8, 6, 5, "ciasto"); // nalesnik <- ciasto

        // Add final products
        recipe.addFinalProduct(8, 10); // made 10 nalesniki

        recipe.addLeftover(1, 10); // zostalo 15 mleka
        recipe.addLeftover(2, 2); // zostalo 2 jaja
        recipe.addLeftover(3, 10); // zostalo 10 jablek
        recipe.addLeftover(4, 1); // zostalo 30 cynamonow
        recipe.addLeftover(5, 4); // zostalo 100 maki
        recipe.addLeftover(6, 3); // zostalo 3 ciasta
        recipe.addLeftover(7, 2); // 2 jablka z cynamonem

        // Show graph
        recipe.showGraph();

        // Calculate initial products
        recipe.calculateInitialProducts();
    }
}

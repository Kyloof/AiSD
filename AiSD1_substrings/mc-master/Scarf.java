public class Scarf {


    // n-wiersz, k - ilosc znakow
    public static boolean loop(int n, int k) {
        int m = 2*k-2;
        int v = n % ((2*k)-2) ;
        if (v <= (m/2)) {
            return true;

        } else {

            return false;
        }
    }

    // n - dlugosc szalika k - szerokosc
    public static String[] ScarfForm(int n,int k){
        int size = 2*k+1;
        int m = (n%(2*k-2));
        String[] tab = new String[(size)];
        int middle = (2*k+1)/2;
        if (loop(n,k)){

            for (int i = middle - (m);i<=middle; i++){
                tab[i] = "O";
            }
            for (int i = middle + (m);i>middle; i--){
                tab[i] = "O";
            }
        }
        else{
            int l = 2*k-2;

            for (int i = (-l + (2*m))/2 + 1; i < tab.length - (-l + (2*m))/2 - 1; i++) {
                tab[i] = "O";
            }
        }


        for (int i = 0; i < size; i++){
            if (tab[i]!="O"){
                tab[i]="X";
            }
        }
        return tab;
    }


    public static void drawScarf(int n, int k){
        System.out.print("n: " + n + " k: " + k + "\n");
        for (int i = 1; i<=n; i++){
            ZigZag.drawSpaces(i-1,5);
            if (k!=0) {
                String[] X = ScarfForm(i - 1, k);
                for (int j = 0; j < (2*k+1); j++) {
                    System.out.print(X[j]);
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        drawScarf(10, 3);
    }
}



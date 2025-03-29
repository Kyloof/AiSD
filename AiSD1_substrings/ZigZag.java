public class ZigZag {

    // n-wiersz, l - ilosc znakow
    public static boolean loop(int n, int k) {
        int m = 2*k-2;
        int v = n % ((2*k)-2) ;

        if (v <= (m/2)) {
            return true;
        } else {
            return false;
        }
    }
    // l - dlugosc wiersza
    public static String[] ZigZagForm(int l){
        String[] tab = new String[l];
        for (int i = 0; i < l; i++){
            tab[i] = "X";
        }
        return tab;
    }

    // n - wiersz, l-ile chcemy miec od lewej znakow spacji
    public static void drawSpaces(int n,int l){
        if (loop(n,l)) {
            //tutaj ustawiam spacje rosnąco
            for (int i = 0; i < (n%((2*l)-2)); i++){
                System.out.print(" ");
            }
        }
        else{
            //tutaj ustawiam spacje malejąco
            for (int i = 0; i<l - (n%((2*l)-2)%(l)+2); i++){
                System.out.print(" ");
            }
        }
    }

    public static void drawZigZag(int n, int l){
        System.out.print("n: " + n + " l: " + l + "\n");
        for (int i = 1; i<=n; i++){
            drawSpaces(i-1,5);
            String[] X = ZigZagForm(l);
            for (int j = 0; j < l; j++) {
                System.out.print(X[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        drawZigZag(10, 5);
    }
}

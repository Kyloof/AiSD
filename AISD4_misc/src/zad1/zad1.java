package zad1;

import java.util.ArrayList;

public class zad1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
            System.out.println("Dodano element: " + i + ", rozmiar listy: " + arrayList.size());
        }

        for (int i = 10; i < 20; i++) {
            arrayList.add(i);
            System.out.println("Dodano element: " + i + ", rozmiar listy: " + arrayList.size());
        }
    }
}
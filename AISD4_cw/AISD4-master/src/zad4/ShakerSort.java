package zad4;

import static java.util.Collections.swap;

public class ShakerSort {
    int[] tab;
    int n;
    public ShakerSort(int n, int[] tab){
        this.n = n;
        this.tab = tab;
    }

    public void Sort(){
        boolean isSwitch = false;
        boolean isSorted = false;
        int temp;
        int crt = 0;
        while (!isSorted){
            isSorted=true;
            while (!isSwitch){
                if (tab[crt]>tab[crt+1]){
                    temp = tab[crt];
                    tab[crt] = tab[crt+1];
                    tab[crt+1] = temp;
                    isSorted=false;
                }
                crt+=1;
                if (crt==tab.length-2){
                    isSwitch=true;
                }
            }
            while (isSwitch){
                isSorted=true;
                if (tab[crt]>tab[crt+1]){
                    temp = tab[crt];
                    tab[crt] = tab[crt+1];
                    tab[crt+1] = temp;
                    isSorted=false;
                }
                crt-=1;
                if (crt==0){
                    isSwitch=false;
                }
            }
        }

        }
    public int[] getTab(){
        return tab;
    }

    public static void main(String[] args){
        int[] tab = new int[]{76,71, 5, 57,12,50,20,93,20,55,62,3};

        ShakerSort shakerSort = new ShakerSort(5,tab);
        shakerSort.Sort();
        int[] tabSorted = shakerSort.getTab();
        for (int elem : tabSorted){
            System.out.println(elem);
        }

    }
}

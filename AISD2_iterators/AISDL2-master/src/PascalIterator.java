import java.util.Iterator;

public class PascalIterator implements Iterator<Integer> {
    int N;
    int[] wiersz;
    int index;
    public PascalIterator(int N){
        this.N = N;
        this.wiersz=new int[]{1};
        for (int i = 0; i<=N;i++){
            this.wiersz = NextPascalLine(this.wiersz);
        }
    }

    public static int[] NextPascalLine(int[] currentLine){
        int tabLength = currentLine.length + 1;
        int[] nextLine = new int[tabLength];
        for (int i = 0; i<tabLength; i++){
            if (i==0 || i == tabLength-1){
                nextLine[i] = 1;
            }
            else{
                nextLine[i] = currentLine[i-1] + currentLine[i];
            }
        }
        return nextLine;
    }


    @Override
    public boolean hasNext() {
        return index < wiersz.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return wiersz[index++];
    }
}

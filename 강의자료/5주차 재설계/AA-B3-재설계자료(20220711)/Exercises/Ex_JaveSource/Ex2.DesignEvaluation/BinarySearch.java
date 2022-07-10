import static java.lang.Integer.compare;

public class BinarySearch {
    public int binarySearch (char item, char table[], int n){
        int bot = 0;
        int top = n - 1;
        int mid, cmp;
        while (bot <= top) {
            mid = (bot + top) / 2;
            if (table[mid] == item)
                return mid;
            else if (compare(table[mid], item) < 0)
                top = mid - 1;
            else
                bot = mid + 1;
        }
        return -1; // not found
    }
}

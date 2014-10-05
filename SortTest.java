import java.io.*;
import java.util.Random;

class SortTest {
    /** Sort the array a[] in ascending order
     ** using an insertion sort.
     */
    static void sort(int a[], int size) {
        for (int i = 1; i < size; i++) {
            // a[0..i-1] is sorted
            // insert a[i] in the proper place
            int x = a[i];
            int j;
            for (j = i-1; j >=0; --j) {
                if (a[j] <= x)
                    break;
                a[j+1] = a[j];
            }
            // now a[0..j] are all <= x
            // and a[j+2..i] are > x
            a[j+1] = x;
        }
    }

    /** Test program to test sort */
    public static void main(String argv[]) {
        if (argv.length != 1) {
            System.out.println("usage: sort array-size");
            System.exit(1);
        }
        int size = Integer.parseInt(argv[0]);
        int test[] = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++)
            test[i] = (int)(r.nextFloat() * 100);
        System.out.println("before");
        for (int i = 0; i < size; i++)
            System.out.print(" " + test[i]);
        System.out.println();

        sort(test, size);

        System.out.println("after");
        for (int i = 0; i < size; i++)
            System.out.print(" " + test[i]);
        System.out.println();

        System.exit(0);
    }
}

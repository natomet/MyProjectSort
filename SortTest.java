import java.io.*;

import java.util.Properties;
import java.io.IOException;
import java.util.Enumeration;

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
    	
    	try {
			File file = new File(argv[0]);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			
			
			Enumeration enuKeys = properties.keys();
		    int elem_size = properties.size();
		    int test[] = new int[elem_size];
		    int iter = 0;
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				test[iter]= Integer.parseInt(value);
				iter++;
			}
	
			
		        
		        sort(test, elem_size);
		        
		        
		        System.out.println("Sort result :");
		        for (int i = 0; i < elem_size; i++)
		            System.out.print(" " + test[i]);
		        System.out.println();
		        
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
    	
    	 System.exit(0);
    	 }
    	  
    }

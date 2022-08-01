package codewars;

public class test2 {


        public static void main(String[] args) {
                  int nfoors =3;
            int lenght = nfoors * 2 -1;
            char[] arr = new char[lenght];
            String[] string = new String[nfoors];
            int count = 0;
            for (int i = 0; i < nfoors;i++) {
                for (int j = 0; j < nfoors-i; j++)
                    arr[j] = ' ';
                for (int k = 0; k < (2 * i + 1); k++) {
                    arr[k] = '*';
                }
                string[count] = new String(arr);
                count++;
            }
            for (int i = 0; i < string.length; i++) {
                System.out.println(string[i]);
            }
        }
    }


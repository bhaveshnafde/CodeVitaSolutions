import java.io.*;
import java.util.*;

class LongestCommonPrefix{

  static void KMP(int m, int n,
                  String str2, String str1)
  {
      int pos = 0, len = 0;
      int []p = new int[m + 1];
      int k = 0;

      //p[1] = 0;
      char []ch1 = str1.toCharArray();
      char []ch2 = str2.toCharArray();

      for (int i = 2; i <= n; i++)
      {
          while (k > 0 && ch1[k] != ch1[i - 1])
              k = p[k];
          if (ch1[k] == ch1[i - 1])
              ++k;
          p[i] = k;
      }

      // find out the longest prefix and position
      for (int j = 0, i = 0; i < m; i++)
      {
          while (j > 0 && j < n && ch1[j] != ch2[i])
              j = p[j];
          if (j < n && ch1[j] == ch2[i])
              j++;

          // for new position with longer prefix in str2
          // update pos and len
          if (j > len)
          {
              len = j;
              pos = i - j + 1;
          }
      }

          // print result
          System.out.println(pos);

      }

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int n = str1.length();
        str2 = str2 + str2;
        KMP(2 * n, n, str2, str1);


        w.close();
      }catch(Exception E){
        //System.out.println(E);
      }
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

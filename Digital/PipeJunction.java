import java.io.*;
import java.util.*;

public class PipeJunction{

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int incoming_pipes = in.nextInt();
        int outgoing_pipes = in.nextInt();
        int rust_factor = in.nextInt();

        int arr_incoming_rated[] = new int[incoming_pipes];
        int arr_outgoing_rated[] = new int[incoming_pipes];

        arr_incoming_rated = in.nextIntArray(incoming_pipes);
        arr_outgoing_rated = in.nextIntArray(outgoing_pipes);

        int incoming_pipe_rated_sum = 0;
        int outgoing_pipe_rated_sum = 0;
        int i = 0;

        for(i = 0; i < incoming_pipes; i++) {
            incoming_pipe_rated_sum += arr_incoming_rated[i];
        }

        for(i = 0; i < outgoing_pipes; i++) {
            outgoing_pipe_rated_sum += arr_outgoing_rated[i];
        }

        int incoming_pipes_actual_sum = incoming_pipe_rated_sum - (rust_factor * incoming_pipes);
        int outgoing_pipes_actual_sum = outgoing_pipe_rated_sum - (rust_factor * outgoing_pipes);

        int balance_factor = outgoing_pipes_actual_sum - incoming_pipes_actual_sum;

        if(balance_factor < 0) {
          balance_factor -= rust_factor;
          w.print(balance_factor);
        } else if(balance_factor > 0) {
          balance_factor += rust_factor;
          w.print(balance_factor);
        } else {
          w.print("BALANCED");
        }

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

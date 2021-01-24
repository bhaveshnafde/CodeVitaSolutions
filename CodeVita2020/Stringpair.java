import java.io.*;
import java.util.*;

class Stringpair{

  private static final String EMPTY = "";

  private static final String[] X =
  {
    EMPTY, "one ", "two ", "three ", "four ", "five ", "six ",
    "seven ", "eight ", "nine ", "ten ", "eleven ","twelve ",
    "thirteen ", "fourteen ", "fifteen ", "sixteen ",
    "seventeen ", "eighteen ", "nineteen "
  };

  private static final String[] Y =
  {
    EMPTY, EMPTY, "twenty ", "thirty ", "forty ", "fifty ",
    "sixty ", "seventy ", "eighty ", "ninety "
  };

  // Function to convert single digit or two digit number into words
  private static String convertToDigit(int n, String suffix)
  {
    // if n is zero
    if (n == 0) {
      return EMPTY;
    }

    // split n if it is more than 19
    if (n > 19) {
      return Y[n / 10] + X[n % 10] + suffix;
    }
    else {
      return X[n] + suffix;
    }
  }

  // Function to convert a given number (max 9-digits) into words
  public static String convert(int n)
  {
    // for storing the word representation of given number
    StringBuilder res = new StringBuilder();

    // add digits at ten millions & hundred millions place
    res.append(convertToDigit((n / 1000000000) % 100, "Billion, "));

    // add digits at ten millions & hundred millions place
    res.append(convertToDigit((n / 10000000) % 100, "Crore, "));

    // add digits at hundred thousands & one millions place
    res.append(convertToDigit(((n / 100000) % 100), "Lakh, "));

    // add digits at thousands & tens thousands place
    res.append(convertToDigit(((n / 1000) % 100), "Thousand "));

    // add digit at hundreds place
    res.append(convertToDigit(((n / 100) % 10), "Hundred "));

    if ((n > 100) && (n % 100 != 0)) {
      res.append("and ");
    }

    // add digits at ones & tens place
    res.append(convertToDigit((n % 100), ""));

    return res.toString();
  }



    public static int SumPairs(int[] input, int k){
    Map<Integer, Integer> frequencies = new HashMap<>();
    int pairsCount = 0;

    for(int i=0; i<input.length; i++){
        int value = input[i];
        int complement = k - input[i];

        if(frequencies.containsKey(complement)){
            int freq = frequencies.get(complement) - 1;
            pairsCount++;
            //System.out.println(value + ", " + complement);
            if(freq == 0){
                frequencies.remove(complement);
            }else{
                frequencies.put(complement, freq);
            }
        }else{
            if(frequencies.containsKey(value)){
                frequencies.put(value, frequencies.get(value) + 1);
            }else{
                frequencies.put(value, 1);
            }
        }
    }
    return pairsCount;
}

    static boolean isVowel(char ch)
    {
        ch = Character.toUpperCase(ch);
        return (ch=='A' || ch=='E' || ch=='I' ||
                           ch=='O' || ch=='U');
    }

    // Returns count of vowels in str
    static int countVowels(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (isVowel(str.charAt(i))) // Check for vowel
                ++count;
        return count;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int n = in.nextInt();

        int arr[] = new int[n];

        arr = in.nextIntArray(n);

        int sum = 0;

        for (int i = 0; i < n; i++) {
          if(arr[i] == 100) {
            sum+=2;
          }else {
            String num = convert(arr[i]);
            sum+=countVowels(String.valueOf(num));
            // System.out.println(num+" "+countVowels(String.valueOf(num)));
          }
        }
        // System.out.println(sum);

        int digit = SumPairs(arr,sum);
        if(digit == 0) {
          w.print("zero");
        }else if(digit == 100) {
          w.print("hundred");
        }else if(digit > 100) {
          w.print("greater 100");
        }else {
          w.print(convert(digit));
        }

        w.close();

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

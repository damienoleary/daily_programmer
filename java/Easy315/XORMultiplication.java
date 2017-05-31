public class XORMultiplication {
    private static void XORMultiply(int a, int b) { 
        int bBitLength = (b==0) ? 1 : (int)Math.floor(Math.log(b)/Math.log(2)+1);
        boolean bitIsEnabled = (b&1) == 1;
        int result = (bitIsEnabled) ? a : 0;

        for (int i = 1; i < bBitLength; i++) {
            bitIsEnabled = ((b >> i) & 1) == 1;
            if (bitIsEnabled) {
                result ^= (a << i);
            }
        }
        System.out.printf("%d@%d=%d\n", a, b, result);
    }
    public static void main(String[] args) {
        XORMultiply(1, 2);
        XORMultiply(9, 0);
        XORMultiply(6, 1);
        XORMultiply(3, 3);
        XORMultiply(2, 5);
        XORMultiply(7, 9);
        XORMultiply(13, 11);
        XORMultiply(5, 17);
        XORMultiply(14, 13);
        XORMultiply(19, 1);
        XORMultiply(63, 63);
    }
}
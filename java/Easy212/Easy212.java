public class Easy212 {
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        if (cmd.equals("encode")) {
            System.out.println(encodeToRövarspråket(sc.nextLine()));
        }
        else if (cmd.equals("decode")) {
            System.out.println(decodeRövarspråket(sc.nextLine()));
        }
    }

    public static String encodeToRövarspråket(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (CONSONANTS.indexOf(c) != -1) {
                sb.append('o');
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static String decodeRövarspråket(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (CONSONANTS.indexOf(c) != -1 && i+2 < s.length() &&
                s.charAt(i+1) == 'o' && s.charAt(i+2) == Character.toLowerCase(c)) {
                i += 2;
            }
        }
        return sb.toString();
    }
}
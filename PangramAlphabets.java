import java.util.Scanner;

public class PangramAlphabets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        int mask = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                mask |= (1 << (ch - 'a'));
            }
        }

        int allLetters = (1 << 26) - 1;

        if (mask == allLetters)
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }
}
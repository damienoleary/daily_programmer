import java.util.Scanner;
import java.util.Arrays;

public class Easy296 {
    public static void main(String[] args) {
        TwelveDays days = new TwelveDays(readGifts());
        days.recite();  
    }

    static String[] readGifts() {
        String[] gifts = new String[12];
        Scanner sc = new Scanner(System.in);
        for (int i=1; i <= 12; i++) {
            System.out.print("Gift " + i + ": ");
            gifts[i-1] = sc.nextLine();
        }
        return gifts;
    }
}

class TwelveDays {
    final String[] gifts;
    final static String[] ordinalDays = new String[]{
        "first", "second", "third", "fourth",
        "fifth", "sixth", "seventh", "eight",
        "ninth", "tenth", "eleventh", "twelfth"
    };
    final static String[] numbers = new String[]{
        "a", "two", "three", "four",
        "five", "six", "seven", "eight",
        "nine", "ten", "eleven", "twelve"
    };
    final static String introFormat = 
        "On the %s day of Christmas%nmy true love sent to me:%n";

    TwelveDays(String[] gifts) {
        if (gifts == null || gifts.length < 12) {
            throw new IllegalArgumentException();
        }   
        this.gifts = Arrays.copyOf(gifts, 12);
    }

    void recite() {
        for (int day = 0; day < 12; day++) {
            System.out.printf(introFormat, ordinalDays[day]);
            for (int gift = day; gift >= 1; gift--) {
                System.out.println(numbers[gift] + " " + gifts[gift]);
            }
            if (day > 0) {
                System.out.print("and ");
            }
            System.out.println(numbers[0] + " " + gifts[0] + "\n");
        }   
    }
}
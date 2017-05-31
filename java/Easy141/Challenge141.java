public class Challenge141 {

    private static int tactic1Victories = 0;
    private static int tactic2Victories = 0;
    private static List<PRIZES> doors = new ArrayList<>(3);

    private static enum PRIZES {
        CAR,
        GOAT
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        simulate(sc.nextInt());
        System.out.println(String.format("Tactic 1: %.1f%% winning chance", 
                                        tactic1Victories*100 / (times * 1.0)));
        System.out.println(String.format("Tactic 2: %.1f%% winning chance", 
                                         tactic2Victories*100 / (times * 1.0)));
    }

    private static void simulate(int timesToRun) {
        int playerGuess;
        int openedDoor;
        setup();

        while(timesToRun > 0) {
            reset();

            playerGuess = randomDoor();
            openedDoor = randomDoor();
            while (openedDoor == playerGuess || !containsGoat(openedDoor)) {
                openedDoor = randomDoor();
            }

            if (containsCar(playerGuess))
                tactic1Victories++;
            else
                tactic2Victories++;

            timesToRun--;
        }
    }

    private static void setup() {
        for (int i = 0; i < 3; i++) {
            doors.add(PRIZES.GOAT);
        }
    }

    private static void reset() {
        for (int i = 0; i < 3; i++) {
            doors.set(i, PRIZES.GOAT);
        }
        doors.set(randomDoor(), PRIZES.CAR);
    }

    private static int randomDoor() {
        return (int) (Math.random() * 3);
    }

    private static boolean containsGoat(int door) {
        return doors.get(door).equals(PRIZES.GOAT);
    }

    private static boolean containsCar(int door) {
        return doors.get(door).equals(PRIZES.CAR);
    }
}
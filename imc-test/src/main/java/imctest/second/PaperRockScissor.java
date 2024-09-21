package main.java.imctest.second;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class PaperRockScissor implements Game {

    private static final AtomicBoolean endLoop = new AtomicBoolean(false);

    private final Scanner scanner = new Scanner(System.in);

    private volatile PlayerType winner;

    @Override
    public void start() {
        System.out.println("*** NEW GAME ***");

        while (!endLoop.get()) {

            System.out.println("Enter:: Paper(0), Rock(1), Scissor(2), End(5)");
            int input = scanner.nextInt();

            if (input == 5) end();
            if (input < 0 || input > 2) continue;

            PRSInputState realPlayerStep = getUserState(input);
            PRSInputState computerStep = getComputerNextState();
            play(realPlayerStep, computerStep);
        }
    }

    private void play(PRSInputState realPlayerStep, PRSInputState computerStep) {
        if (realPlayerStep == PRSInputState.Paper && computerStep == PRSInputState.Rock)
            winner = PlayerType.RealPLayer;
        else if (realPlayerStep == PRSInputState.Rock && computerStep == PRSInputState.Scissor)
            winner = PlayerType.RealPLayer;
        else if (realPlayerStep == PRSInputState.Scissor && computerStep == PRSInputState.Paper)
            winner = PlayerType.RealPLayer;
        else if (computerStep == PRSInputState.Paper && realPlayerStep == PRSInputState.Rock)
            winner = PlayerType.Computer;
        else if (computerStep == PRSInputState.Rock && realPlayerStep == PRSInputState.Scissor)
            winner = PlayerType.Computer;
        else if (computerStep == PRSInputState.Scissor && realPlayerStep == PRSInputState.Paper)
            winner = PlayerType.Computer;
        else winner = PlayerType.Nobody;
        System.out.println("[Real Player:" + realPlayerStep + "] [Computer:" + computerStep + "] Winner:" + winner);
    }

    private PRSInputState getComputerNextState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, PRSInputState.values().length);
        return PRSInputState.values()[randomNum];
    }

    private PRSInputState getUserState(int input) {
        return PRSInputState.values()[input];
    }

    @Override
    public void end() {
        System.out.println("*** GAME OVER ***");
        endLoop.set(false);
        scanner.close();
        System.out.println("Last Winner: " + winner);
        System.exit(0);
    }
}

package typinggame;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource {

    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";

    static {
        chars = charArray.toCharArray();
    }

    Random random;
    CharacterEventHandler characterEventHandler;

    public RandomCharacterGenerator() {
        random = new Random();
        characterEventHandler = new CharacterEventHandler();
    }

    public int getPauseTime() {
        return (int) (Math.max(1000, 5000 * random.nextDouble()));
    }

    @Override
    public void addCharacterListener(CharacterListener cl) {
        characterEventHandler.addCharacterListener(cl);
    }

    @Override
    public void removeCharacterListener(CharacterListener cl) {
        characterEventHandler.removeCharacterListener(cl);
    }

    @Override
    public void nextCharacter() {
        characterEventHandler.fireNewCharacter(this, chars[random.nextInt(chars.length)]);
    }

    public void run() {
        for (; ; ) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException ie) {
                return;
            }
        }
    }
}

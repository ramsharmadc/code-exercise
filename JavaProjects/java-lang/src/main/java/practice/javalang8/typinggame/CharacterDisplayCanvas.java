package practice.javalang8.typinggame;

import javax.swing.*;
import java.awt.*;

public class CharacterDisplayCanvas extends JComponent implements CharacterListener {

    protected FontMetrics fm;
    protected char[] tempChar = new char[1];
    protected int fontHeight;

    public CharacterDisplayCanvas() {
        setFont(new Font("Monospaced", Font.BOLD, 18));
        fm = Toolkit.getDefaultToolkit().getFontMetrics(getFont());
        fontHeight = fm.getHeight();
    }

    public CharacterDisplayCanvas(CharacterSource cs) {
        this();
        setCharacterSource(cs);
    }

    public void setCharacterSource(CharacterSource cs) {
        cs.addCharacterListener(this);
    }

    public Dimension preferredSize() {
        return new Dimension(fm.getMaxAscent() + 10, fm.getMaxAdvance() + 10);

    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        tempChar[0] = (char) ce.character;
        repaint();
    }

    protected synchronized void paintedComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tempChar[0] == 0)
            return;
        int charWidth = fm.charWidth((int) tempChar[0]);
        gc.drawChars(tempChar, 0, 1, (d.width - charWidth) / 2, fontHeight);
    }
}

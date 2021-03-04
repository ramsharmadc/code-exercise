package util;

import java.io.File;

public class RenameMyMp3s {

    public static void main(final String[] args) {

        final String location = "";
        final File dir = new File(location);
        final File[] mp3s = dir.listFiles();

        for (final File mp3 : mp3s) {
            System.out.println(mp3);
            mp3.getName();
            mp3.renameTo(new File(
                    location + mp3.getName().substring(mp3.getName().indexOf('-') + 1).trim()));
        }
    }
}

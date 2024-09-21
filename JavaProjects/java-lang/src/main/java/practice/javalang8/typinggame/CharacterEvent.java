package practice.javalang8.typinggame;

public class CharacterEvent {

    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource source, int character) {
        this.source = source;
        this.character = character;
    }
}

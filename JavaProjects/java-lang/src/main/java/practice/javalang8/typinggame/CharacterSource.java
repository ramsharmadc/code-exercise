package practice.javalang8.typinggame;

public interface CharacterSource {

    void addCharacterListener(CharacterListener cl);

    void removeCharacterListener(CharacterListener cl);

    void nextCharacter();
}

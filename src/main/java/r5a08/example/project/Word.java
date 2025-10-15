package r5a08.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Word {
    private String word;

    public Word(String correctWord) {
        this.word = correctWord;
    }

    public Score guess(String attempt) {
        Score score = new Score(word);

        score.assess(0, attempt);

        return score;
    }
}

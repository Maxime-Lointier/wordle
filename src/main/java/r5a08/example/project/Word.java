package r5a08.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Word {
    public ArrayList<String> word;
    public Word(String e) {
        this.word = new ArrayList<>(Arrays.asList(e));    }

    public Letter guess(String attempt) {
        Score score = new Score(word);

        /* Calcule le score pour la lettre d'indice 0
           de la tentative
         */
        return score.assess(0, attempt);

    }
}

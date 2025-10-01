package r5a08.example.project;

import java.util.ArrayList;
import java.util.Objects;

public class Score {
    private final ArrayList<String> word;
    public Score(ArrayList<String> word) {
        this.word = word;
    }

    public Letter assess(int i, String attempt) {
            if (!Objects.equals(word.get(i), attempt)) {
                return Letter.INCORRECT;
            } else {
                return Letter.CORRECT;
            }
        }
    }


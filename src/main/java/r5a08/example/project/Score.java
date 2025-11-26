package r5a08.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Score {

    private final String correct;

    private final Letter[] results;

    public Score(String correct) {
        this.correct=correct;
        this.results = new Letter[correct.length()];
        for (int i = 0; i < correct.length(); i++) {
            results[i] = Letter.INCORRECT;
        }
    }

    public Letter letter(int i) {
        return results[i];
    }

    public void assess(int position, String attempt) {
        VerifyEachCharacter(attempt);

    }

    public void VerifyEachCharacter(String attempt) { //fonction Haut niveau
        for (int i = 0; i < correct.length(); i++) {
            if (attemptIsCorrect(i, attempt) == 1) {
                results[i] = Letter.CORRECT;
            }
        }
        for (int i = 0; i < correct.length(); i++) {
            if (results[i] != Letter.CORRECT) { // ceux qui ne sont Pas déjà CORRECT
                char attemptChar = attempt.charAt(i);

                if (attemptCharacterIsContainedInWord(correct, attemptChar)) {

                    verifyPartCorrectLetter(attempt, attemptChar, i);
                }
                else {
                    results[i] = Letter.INCORRECT;
                }
            }
        }
    }

    private boolean attemptCharacterIsContainedInWord(String correct, char attemptChar) {
        return correct.contains(String.valueOf(attemptChar));
    }

    private void verifyPartCorrectLetter(String attempt, char attemptChar, int i) {
        int availableInTarget = countCharInString(correct, attemptChar);
        int alreadyUsed = countAlreadyUsedChar(attemptChar, i, attempt);

        if (alreadyUsed < availableInTarget) {
            results[i] = Letter.PART_CORRECT;
        } else {
            results[i] = Letter.INCORRECT;
        }
    }

    public int countCharInString(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public int countAlreadyUsedChar(char c, int currentPos, String attempt) {
        int count = 0;
        for (int i = 0; i < currentPos; i++) {
            if (attempt.charAt(i) == c &&
                    (results[i] == Letter.CORRECT || results[i] == Letter.PART_CORRECT)) {
                count++;
            }
        }
        for (int i = currentPos + 1; i < results.length; i++) {
            if (attempt.charAt(i) == c && results[i] == Letter.CORRECT) {
                count++;
            }
        }
        return count;
    }



    public int attemptIsCorrect(int position, String attempt) {
        if (        this.correct.charAt(position) == attempt.charAt(position)){
            return 1;
        }
        else{
            if ((this.correct.charAt(position) != attempt.charAt(position)) && attemptCharacterIsContainedInWord(this.correct, attempt.charAt(position))){
                return -1;

            }
            return 0;
        }
    }

    public Letter[] letters() {
        return results;
    }
}



package r5a08.example.project;

public class Score {

    private final String correct;

    private Letter[] results;

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

    private void VerifyEachCharacter(String attempt) {
        for (int i =0; i < correct.length();i++){
            if (attemptIsCorrect(i, attempt) == 1){
                results[i] = Letter.CORRECT;
            }
            else {
                if (attemptIsCorrect(i,attempt) == -1) {
                    results[i] = Letter.PART_CORRECT;
                }
                else {
                    results[i] = Letter.INCORRECT;
                }
            }
        }
    }

    private int attemptIsCorrect(int position, String attempt) {
        if (        this.correct.charAt(position) == attempt.charAt(position)){
            return 1;
        }
        else{
            if ((this.correct.charAt(position) != attempt.charAt(position)) && this.correct.contains(String.valueOf(attempt.charAt(position)))){
                return -1;

            }
            return 0;
        }
    }

    public Letter[] letters() {
        return results;
    }
}



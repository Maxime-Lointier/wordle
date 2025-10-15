package r5a08.example.project;

public class Score {

    private final String correct;
    private Letter result = Letter.INCORRECT;

    private Letter[] results;

    public Score(String correct) {
        this.correct=correct;
        this.results = new Letter[correct.length()];
        for (int i = 0; i < correct.length(); i++) {
            results[i] = Letter.INCORRECT;
        }
    }

    public Letter letter(int i) {
        return result;
    }

    public void assess(int position, String attempt) {
        if (correct.length() <= 1){
            if (attemptIsCorrect(position, attempt)){
                result = Letter.CORRECT;
            }
        }
        else {

            for (int i =0; i < correct.length();i++){
                if (attemptIsCorrect(i, attempt)){
                    results[i] = Letter.CORRECT;
                    System.out.println(attempt.charAt(i));
                }
                else {
                    results[i] = Letter.INCORRECT; // le plus simple la on prend pas compte des part correcte
                }
            }
        }
    }

    private boolean attemptIsCorrect(int position, String attempt) {
        return this.correct.charAt(position) == attempt.charAt(position);
    }

    public Letter[] letters() {
        return results;
    }
}



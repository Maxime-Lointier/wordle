package r5a08.example.project;

public class Word {
    public String mot;
    public Word(String e) {
        this.mot = e;
    }

    public Letter guess(String b) {


        if (!mot.equals(b)){
            return Letter.valueOf("INCORRECT");
        }
        else {
            return Letter.valueOf("CORRECT");
        }

    }
}

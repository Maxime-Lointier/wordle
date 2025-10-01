package r5a08.example.project;

import org.junit.jupiter.api.Assertions;

public class WordTest {
    public void should_check_one_incorrect_letter(){
        //arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre
        //act
        Letter score = word.guess("B"); // tentative du joueur

        Letter expected = Letter.valueOf("INCORRECT");
        Assertions.assertEquals(expected, score);



    }

}

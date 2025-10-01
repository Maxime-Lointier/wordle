package r5a08.example.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {

    @Test
    public void should_check_one_incorrect_letter(){
        //arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre
        //act
        Letter score = word.guess("B"); // tentative du joueur

        Letter expected = Letter.valueOf("INCORRECT");
        Assertions.assertSame(expected, score);



    }

    @Test
    public void should_check_one_correct_letter(){
        Word word = new Word("E"); // Le mot a déviner fait une lettre
        //act
        Letter score = word.guess("E"); // tentative du joueur


        Letter expected = Letter.valueOf("CORRECT");
        Assertions.assertSame(expected, score);

    }

}

package r5a08.example.project;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static r5a08.example.project.Letter.CORRECT;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("B");
        Letter actual=score.letter(0);
        Letter expected = Letter.INCORRECT;

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("E");
        Letter[] actual=score.letters();
        System.out.println(Arrays.toString(actual));
        Letter[] expected = { Letter.CORRECT};

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Should_check_two_correct_letter(){
        //Arrange
        Word word = new Word("BA");

        //Act
        Score score = word.guess("BA");
        Letter[] actual=score.letters(); //devrait retourner le score de toute les lettres donc le plus  simple serait un tab de [CORRECT,CORRECT]
        Letter[] expected = { Letter.CORRECT, Letter.CORRECT };
        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void Should_check_two_PART_CORRECT_letter(){
        //Arrange
        Word word = new Word("BA");

        //Act
        Score score = word.guess("AB");
        Letter[] actual = score.letters();
        Letter[] expected = { Letter.PART_CORRECT, Letter.PART_CORRECT };
        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void Should_check_complete_correct_word(){
        //Arrange
        Word word = new Word("FLEUR");

        //ACT
        Score score = word.guess("FLEUR");
        Letter[] actual = score.letters();
        Letter[] expected = { Letter.CORRECT, Letter.CORRECT, Letter.CORRECT, Letter.CORRECT, Letter.CORRECT  };
        //Assert
        assertThat(actual).isEqualTo(expected);
    }
}

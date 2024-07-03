package org.example.exo3;

import org.example.exo3.DiceScore;
import org.example.exo3.Ide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
    private DiceScore ds;
    private Ide de = Mockito.mock(Ide.class);

    @Test
    public void TestJeuWhenDesIdentiquesThenReturnFois_2plus_10() {
        //Arrange
        ds = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(4);
        int resultAwait = 18;
        //Act
        int result = ds.getScore();
        //Assert
        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestJeuWhenDes6sThenReturn_30() {
        //Arrange
        ds = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6);
        int resultAwait = 30;
        //Act
        int result = ds.getScore();
        //Assert
        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestJeuWhenDesDifferentsThenReturnPlusHaut() {
        //Arrange
        ds = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6,2);
        int resultAwait = 6;
        //Act
        int result = ds.getScore();
        //Assert
        Assertions.assertEquals(resultAwait, result);
    }
}


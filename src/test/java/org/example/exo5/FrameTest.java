package org.example.exo5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class FrameTest {
    private Frame frame;
    private IGenerateur pin = Mockito.mock(IGenerateur.class);


    @Test
    public void Roll_SimpleFrame_FirstRoll_CheckScore() {
        //Arrange
        frame = new Frame(pin, false);
        Mockito.when(pin.randomPin(10)).thenReturn(3);
        int resultAwait = 3;
        //Act
        int roll = frame.makeFrame();
        //Assert
        Assertions.assertEquals(resultAwait, roll);
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore() {
        frame = new Frame(pin, false);
        Mockito.when(pin.randomPin(10)).thenReturn(3);
        Mockito.when(pin.randomPin(7)).thenReturn(3);
        int scoreAwait = 6;

        int roll1 = frame.makeFrame();
        int roll2 = frame.makeFrame();
        int result = roll1 + roll2;

        Assertions.assertEquals(scoreAwait, result);
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse() {
        frame = new Frame(pin, false);
        Mockito.when(pin.randomPin(10)).thenReturn(10);

        frame.makeRoll();
        boolean result = frame.makeRoll();

        Assertions.assertFalse(result);
    }

    @Test
    public void Roll_SimpleFrame_MoreRolls_ReturnFalse() {
        frame = new Frame(pin, false);
        Mockito.when(pin.randomPin(10)).thenReturn(2);
        Mockito.when(pin.randomPin(8)).thenReturn(3);
        Mockito.when(pin.randomPin(5)).thenReturn(3);

        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        Assertions.assertFalse(result);
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue() {
        frame = new Frame(pin, true);
        Mockito.when(pin.randomPin(10)).thenReturn(10, 5);
        int scoreAwait = 15;

        frame.makeRoll();
        frame.makeRoll();

        int result = frame.getScore();

        Assertions.assertEquals(scoreAwait, result);
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore() {
        frame = new Frame(pin, true);
        Mockito.when(pin.randomPin(10)).thenReturn(10).thenReturn(3).thenReturn(3);

        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        Assertions.assertTrue(result);
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        frame = new Frame(pin, true);
        Mockito.when(pin.randomPin(10)).thenReturn(5, 5, 3);

        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        Assertions.assertTrue(result);
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_CheckScore() {
        frame = new Frame(pin, true);
        Mockito.when(pin.randomPin(10)).thenReturn(5, 5, 3);
        int scoreAwait = 13;

        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();

        int result = frame.getScore();

        Assertions.assertEquals(scoreAwait, result);

    }

    @Test
    public void Roll_LastFrame_FourthRoll_ReturnFalse() {
        frame = new Frame(pin, true);
        Mockito.when(pin.randomPin(10)).thenReturn(3, 2, 3,2);

        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        Assertions.assertFalse(result);
    }

}

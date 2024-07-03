package org.example.exo1;

import org.example.exo1.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GradingCalculatorTest {
    private GradingCalculator grade;

    @ParameterizedTest
    @CsvSource({
            "95,90,'A'",
            "85,90,'B'",
            "65,90,'C'",
            "95,65,'B'",
            "95,55,'F'",
            "65,55,'F'",
            "50,90,'F'",
    })
    public void TestGrade(int score,int attendance,char resultAwait) {
        //Arrange
        grade = new GradingCalculator(score,attendance);
        // Act
        char result = grade.getGrade();
        // Assert
        Assertions.assertEquals(resultAwait, result);
    }


}

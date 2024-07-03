package org.example.exo2;

import org.example.exo2.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FibTest {
    private Fib fib;//attribut Fib qui va permettre de contenir la classe

    @Test
    public void GetFibSeriesWhen_Range_1_thenResultNotNull() {
        int range = 1;
        fib = new Fib( range);
        List<Integer> results;
        //int resultAwait;

        results = fib.getFibSeries();

        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void GetFibSeriesWhen_Range_1_thenResultContains_0() {
        int range = 1;
        fib = new Fib( range);
        List<Integer> results;
        int resultAwait = 0;

        results = fib.getFibSeries();

        Assertions.assertTrue(results.contains(resultAwait));
    }

    @Test
    public void GetFibSeriesWhen_Range_6_thenResultContains_3() {
        int range = 6;
        fib = new Fib( range);
        List<Integer> results;
        int resultAwait = 3;

        results = fib.getFibSeries();

        Assertions.assertTrue(results.contains(resultAwait));
    }

    @Test
    public void GetFibSeriesWhen_Range_6_thenResultSize_6() {
        int range = 6;
        fib = new Fib( range);
        List<Integer> results;
        //int resultAwait;

        results = fib.getFibSeries();

        Assertions.assertEquals(6, results.size());
    }

    @Test
    public void GetFibSeriesWhen_Range_6_thenResultNotIn_4() {
        int range = 6;
        fib = new Fib( range);
        List<Integer> results;
        int resultAwait = 4;

        results = fib.getFibSeries();

        Assertions.assertFalse(results.contains(resultAwait));
    }

    @Test
    public void GetFibSeriesWhen_Range_6_thenResultIn_011235() {
        int range = 6;
        fib = new Fib( range);
        List<Integer> results;
        List<Integer> resultAwait = Arrays.asList(0,1,1,2,3,5);

        results = fib.getFibSeries();

        Assertions.assertFalse(results.contains(resultAwait));
    }

    @Test
    public void GetFibSeriesWhen_Range_6_thenResultSortedAsc() {
        int range = 6;
        fib = new Fib( range);
        List<Integer> results;
        List<Integer> resultAwait = Arrays.asList(0, 1, 1, 2, 3, 5);
        Collections.sort(resultAwait);

        results = fib.getFibSeries();

        Assertions.assertEquals(results, resultAwait);
    }
}

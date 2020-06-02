package com.codecool.tddsaboteur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberAdderTest {

    private NumberAdder numberAdder;

    @BeforeEach
    void setUp() {
        numberAdder = new NumberAdder();
    }

    @Test
    public void smokeTest() {
        assertTrue(true);
    }
}
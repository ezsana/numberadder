package com.codecool.tddsaboteur;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberAdderTest {

    private NumberAdder numberAdder;

    @BeforeEach
    void setUp() {
        numberAdder = new NumberAdder();
    }

    @Test
    void smokeTest() {
        assertNotNull(numberAdder);
    }

    @Test
    void ParameterIsNull() {
        assertThrows(StringEmptyException.class, () -> numberAdder.addNumbers(null));
    }

    @Test
    void ParameterIsEmpty() {
        assertThrows(StringEmptyException.class, () -> numberAdder.addNumbers(""));
    }

    @TestFactory
    Collection<DynamicTest> invalidParameter() {
        return Arrays.asList(DynamicTest.dynamicTest("1,,3", () -> assertThrows(InvalidStringException.class, () -> numberAdder.addNumbers("1,,3"))),
                DynamicTest.dynamicTest("1,3,", () -> assertThrows(InvalidStringException.class, () -> numberAdder.addNumbers("1,3,"))),
                DynamicTest.dynamicTest("1,,,,,,,,3", () -> assertThrows(InvalidStringException.class, () -> numberAdder.addNumbers("1,,,,,,,,3"))),
                DynamicTest.dynamicTest("javascript", () -> assertThrows(InvalidStringException.class, () -> numberAdder.addNumbers("javascript"))),
                DynamicTest.dynamicTest("123AB, 34, -12", () -> assertThrows(InvalidStringException.class, () -> numberAdder.addNumbers("123AB, 34, -12"))));

    }

    @TestFactory
    Collection<DynamicTest> validParameter() {
        return Arrays.asList(DynamicTest.dynamicTest("0,1,2,3", () -> assertEquals(6, numberAdder.addNumbers("0,1,2,3"))),
                DynamicTest.dynamicTest("4", () -> assertEquals(4, numberAdder.addNumbers("4"))),
                DynamicTest.dynamicTest("0, 1, 2", () -> assertEquals(3, numberAdder.addNumbers("0, 1, 2"))),
                DynamicTest.dynamicTest("              3     ", () -> assertEquals(3, numberAdder.addNumbers("              3     "))),
                DynamicTest.dynamicTest("-1,0,  1,   0   , 0", () -> assertEquals(0, numberAdder.addNumbers("-1,0,  1,   0   , 0"))),
                DynamicTest.dynamicTest("1,  2,3,  4", () -> assertEquals(10, numberAdder.addNumbers("1,  2,3,  4"))));

    }
}

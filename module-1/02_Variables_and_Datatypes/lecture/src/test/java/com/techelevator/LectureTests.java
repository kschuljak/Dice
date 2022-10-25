package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 * Test class to verify the results of each exercise. Each
 * test also runs two assertions from `BaseSolution.java` that
 * will check to make sure at least one variable has been declared
 * and that all variables are camelCased.
 */
@TestMethodOrder(value = OrderAnnotation.class)
public class LectureTests extends BaseSolution {

    @Test
    @Order(1)
    public void testSolution1() throws Exception {
        assertEquals(26, iTest.getIntResult());
    }

    @Test
    @Order(2)
    public void testSolution2() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(0.5, dblResult);
    }

    @Test
    @Order(3)
    public void testSolution3() throws Exception {
        assertEquals("TechElevator", iTest.getStringResult());
    }

    @Test
    @Order(4)
    public void testSolution4() throws Exception {
        assertEquals(1, iTest.getIntResult());
    }

    @Test
    @Order(5)
    public void testSolution5() throws Exception {
        assertEquals("Java", iTest.getStringResult());
    }

    @Test
    @Order(6)
    public void testSolution6() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(3.1416, dblResult);
    }

    @Test
    @Order(7)
    public void testSolution7() throws Exception {
        assertTrue(iTest.getStringResult().length() > 0);
    }

    @Test
    @Order(8)
    public void testSolution8() throws Exception {
        int intResult = iTest.getIntResult();
        assertTrue(intResult > 0);
    }

    @Test
    @Order(9)
    public void testSolution9() throws Exception {
        int intResult = iTest.getIntResult();
        assertTrue(intResult > 0);
    }

    @Test
    @Order(10)
    public void testSolution10() throws Exception {
        int intResult = iTest.getIntResult();
        assertEquals(94, intResult);
    }

    @Test
    @Order(11)
    public void testSolution11() throws Exception {
        double result = iTest.getDoubleResult();
        if (result == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }

        assertEquals(12.3 + 32.1, result);
    }

    @Test
    @Order(12)
    public void testSolution12() throws Exception {
        // this tests 12, 13, 14 and 15
        String result = iTest.getStringResult();
        if(result.length() == 0)
        {
            Assertions.fail("Ensure that you use ths String data type and that it has a value.");
        }
        assertTrue(result.contains(" "),"Ensure that you have entered your full name.");
    }

    @Test
    @Order(16)
    public void testSolution16() throws Exception {
        // this tests 16 and 17
        String result = iTest.getStringResult();
        if(result.length() == 0)
        {
            Assertions.fail("Ensure that you use ths String data type and that it has a value.");
        }
        assertEquals("Saw20", result);

    }

    @Test
    @Order(18)
    public void testSolution18() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(2.0, dblResult);
    }

    @Test
    @Order(19)
    public void testSolution19() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(2.7, dblResult);
    }

    @Test
    @Order(20)
    public void testSolution20() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(2.0, dblResult);
    }

    @Test
    @Order(21)
    public void testSolution21() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(2.5, dblResult);
    }

    @Test
    @Order(22)
    public void testSolution22() throws Exception {
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(66.6/100, dblResult);
    }

    @Test
    @Order(23)
    public void testSolution23() throws Exception {
        int result = iTest.getIntResult();
        assertEquals(1, result);
    }

    @Test
    @Order(24)
    public void testSolution24() throws Exception {
        long result = iTest.getLongResult();
        assertEquals(3000000000L, result);
    }

    @Test
    @Order(25)
    public void testSolution25() throws Exception {
        // this tests 25 & 26
        boolean result = iTest.getBooleanResult();
        assertTrue(result);
    }
}

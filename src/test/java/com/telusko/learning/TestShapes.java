package com.telusko.learning;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestShapes {

    Shapes shapes;
    SortingArray sort;

    @BeforeAll
    static void beforeAllRuning() {
        System.out.println("Before all started");
    }

    @BeforeEach
    void init() {
        shapes = new Shapes();
        sort = new SortingArray();
    }

    @Nested
    class testAreaOfShapes{
        //Assert Equals
        @Test
        void testComputeSqureArea() {
            assertEquals(576, shapes.computeSquareArea(24), () -> "Method are not pass");
        }

        //Assert Not Equals
        @Test
        void testComputeSqureArea_NotEqual() {
            assertNotEquals(0, shapes.computeSquareArea(24), () -> "Method are not pass");
        }

        @RepeatedTest(3)
        void testComputeCircleArea(RepetitionInfo info) {
            if(info.getCurrentRepetition() == 1)
                assertEquals(153.86,shapes.computeCircleArea(7), () -> "Method is not pass");
            else if (info.getCurrentRepetition() == 2)
                assertEquals(153.86,shapes.computeCircleArea(7), () -> "Method is not pass");
        }
    }

    @Nested
    class testAssertingMethods{
        //AssertTrue
        @Test
        void test_assertTrue() {
            String name = "Java";
            assertTrue(name.equals("Java"), () -> "Method not Pass");
        }

        //AssertFalse
        @Test
        void test_assertFalse() {
            String name = "Java";
            assertFalse(name.equals("avaJ"), () -> "Method not Pass");
        }

        //Asserting the exception
        @Test
        void test_asserting_exception() {
            assertThrows(NullPointerException.class, () -> sort.sortingArray(null), () -> "Method is not pass");
        }
    }

    @Nested
    class testSortingArray {
        //Testing the performance
        @Test
        void testSortingArray_performance() {
            int []unsorted = {8, 5, 9, 7, 2, 4};
            assertTimeout(Duration.ofMillis(10), () -> sort.sortingArray(unsorted), () -> "Method is not pass");
        }

        @Test
        void test_assumption() {
            assumeTrue(shapes.computeSquareArea(4) == 16);
            System.out.println("Only if this block work assume True == true if not this code working ");
        }
    }





    @AfterEach
    void afterInit() {
        System.out.println("After running");
    }


    @AfterAll
    static void AfterAllRuning() {
        System.out.println("After all clean up");
    }


}
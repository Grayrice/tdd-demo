package com.demo.study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeTest {
    @Test
    void should_return_two_when_one_plus_one() {
        assertEquals(2, 1 + 1);
    }
}

package com.teedjay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DummyTest {

    @Test
    public void alwaysSuccess() {
        assertTrue(true);
    }

    @Test
    public void neverFail() {
        assertFalse(false);
    }

}

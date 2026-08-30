/*
 *
 *  * Copyright (c) 2025-2026 Jay Shah
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.example.letterbox.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlugGeneratorTest {
    @Test
    void distributesSequentialCounterBitsAcrossTheSlug() {
        assertEquals("wonderful-lion-0000000", SlugGenerator.formSlug(1));
        assertEquals("random-tiger-0000000", SlugGenerator.formSlug(2));
        assertEquals("random-lion-0000001", SlugGenerator.formSlug(4));
    }
}

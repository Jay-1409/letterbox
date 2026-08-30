/*
 *
 *  * Copyright (c) 2025-2026 Jay Shah
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.example.letterbox.service;

import com.example.letterbox.entity.SlugList;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

public class SlugGenerator {
    private static final String UID_SLUG_COUNTER_KEY = "codepaste:uid:slug:counter";
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SHORT_ID_LENGTH = 7;
    private static final long MAX_COUNTER = 0xffffffffL;
    private static final int[] WORD_1_BITS = {0, 3, 6, 9, 12, 15, 18};
    private static final int[] WORD_2_BITS = {1, 4, 7, 10, 13, 16, 19};
    private static final int[] SHORT_ID_BITS = {2, 5, 8, 11, 14, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final StringRedisTemplate stringRedisTemplate;

    public SlugGenerator(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String nextId() {
        Long number = stringRedisTemplate.opsForValue().increment(UID_SLUG_COUNTER_KEY);
        if (number == null || number < 0 || number > MAX_COUNTER) {
            throw new IllegalStateException("Slug counter exhausted");
        }
        return formSlug(number.intValue());
    }

    private static int craftNumber(int number, int[] bitPositions) {
        int crafted = 0;
        for (int index = 0; index < bitPositions.length; index++) {
            crafted |= ((number >>> bitPositions[index]) & 1) << index;
        }
        return crafted;
    }

    private static String generateShortId(int mask) {
        StringBuilder shortId = new StringBuilder(SHORT_ID_LENGTH);
        do {
            shortId.append(ALPHABET.charAt(mask % ALPHABET.length()));
            mask /= ALPHABET.length();
        } while (mask > 0);

        return "0".repeat(SHORT_ID_LENGTH - shortId.length()) + shortId.reverse();
    }

    static String formSlug(int number) {
        int word1Index = craftNumber(number, WORD_1_BITS);
        int word2Index = craftNumber(number, WORD_2_BITS);
        int shortIdMask = craftNumber(number, SHORT_ID_BITS);

        String word1 = wordAt(SlugList.ADJECTIVES, SlugList.COLORS, word1Index);
        String word2 = wordAt(SlugList.ANIMALS, SlugList.NOUNS, word2Index);
        return word1 + "-" + word2 + "-" + generateShortId(shortIdMask);
    }

    private static String wordAt(List<String> first, List<String> second, int index) {
        return index < first.size() ? first.get(index) : second.get(index - first.size());
    }
}

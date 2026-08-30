/*
 *
 *  * Copyright (c) 2025-2026 Jay Shah
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.example.letterbox.service.impl;

import com.example.letterbox.service.PasteIdGenerator;
import com.example.letterbox.service.SlugGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(1)
public class slugBaseduidGenerator extends SlugGenerator implements PasteIdGenerator {
    public slugBaseduidGenerator(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }
}

/*
 *
 *  * Copyright (c) 2025-2026 Jay Shah
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.example.letterbox.service.impl;

import com.example.letterbox.service.PasteIdGenerator;
import com.example.letterbox.service.SlugGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "letterbox.id-generator", havingValue = "slug", matchIfMissing = true)
public class slugBaseduidGenerator extends SlugGenerator implements PasteIdGenerator {
    public slugBaseduidGenerator(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }
}

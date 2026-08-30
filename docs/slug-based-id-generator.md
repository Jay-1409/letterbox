# Slug-Based ID Generator

The slug-based generator turns a 32-bit Redis counter into a human-readable ID:

```text
<word-1>-<word-2>-<short-id>
```

Example:

```text
wonderful-lion-0000000
```

## Bit distribution

The counter is divided into two 7-bit word indexes and one 18-bit short ID. Its
bits are interleaved instead of taking three contiguous ranges, so sequential
counters change different parts of the slug early.

Counter bits are numbered from `0`, the least-significant bit, through `31`.

| Slug part | Width | Counter bits |
| --- | ---: | --- |
| Word 1 index | 7 bits | `0, 3, 6, 9, 12, 15, 18` |
| Word 2 index | 7 bits | `1, 4, 7, 10, 13, 16, 19` |
| Short ID | 18 bits | `2, 5, 8, 11, 14, 17, 20-31` |

Each selected counter bit becomes the next bit of its destination value. For
example, counter bit `0` becomes word-1 bit `0`, counter bit `3` becomes
word-1 bit `1`, and so on.

All 32 counter bits are used exactly once. The operation is therefore a fixed,
reversible bit permutation: it changes the visible distribution without losing
information or introducing collisions.

## Generation process

1. Atomically increment `codepaste:uid:slug:counter` in Redis.
2. Distribute the counter bits using the table above.
3. Use the two 7-bit results as indexes into the combined word lists.
4. Encode the 18-bit result with the base-62 alphabet:

   ```text
   0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
   ```

5. Left-pad the encoded short ID with `0` until it is seven characters long.
6. Join the three values with hyphens.

The first few counter values demonstrate the distribution:

| Counter | Generated ID |
| ---: | --- |
| 1 | `wonderful-lion-0000000` |
| 2 | `random-tiger-0000000` |
| 4 | `random-lion-0000001` |

## Word distribution

Each word index has 7 bits and therefore 128 possible values.

| Slug part | Available values |
| --- | ---: |
| Word 1 | 128: 69 adjectives and 59 colors |
| Word 2 | 128: 74 animals and 54 nouns |

## ID capacity

The complete ID contains 32 bits:

```text
7 + 7 + 18 = 32 bits
```

The theoretical number of unique combinations is:

```text
2^7 x 2^7 x 2^18 = 2^32 = 4,294,967,296
```

Redis `INCR` starts at `1`, while the generator accepts counters through
`0xffffffff`. The implementation therefore emits:

```text
4,294,967,295 unique IDs
```

The seven-character short ID does not provide `62^7` combinations because it
encodes only 18 counter bits. It has `2^18 = 262,144` distinct values; leading
zeroes provide a consistent display length.

Across the complete 32-bit space:

- Each word-1 index appears `2^25 = 33,554,432` times.
- Each word-2 index appears `2^25 = 33,554,432` times.
- Each short-ID value appears `2^14 = 16,384` times.
- Each complete three-part combination appears exactly once.

The Redis counter must be persistent and shared by every application replica.
Resetting or replacing it can cause previously generated IDs to be emitted
again.

# 1768 — Merge Strings Alternately

## Problem Link

https://leetcode.com/problems/merge-strings-alternately/

## Difficulty

Easy

## Problem Summary

Merge two strings by alternating their characters, starting with
word1. If one string ends first, append the remaining characters
from the other string in their original order.

## Examples

| word1 | word2 | Output |
|-------|-------|--------|
| "abc" | "pqr" | "apbqcr" |
| "ab" | "pqrs" | "apbqrs" |
| "abcd" | "pq" | "apbqcd" |
| "a" | "z" | "az" |

## Constraints

- Each string contains between 1 and 100 characters.
- Both strings contain only lowercase English letters.

## Approach

Use two indices, i and j, starting at zero, and a StringBuilder
to build the result.

Continue the loop while at least one index is within its string.
At each iteration, append the character from word1 if available,
then the character from word2 if available.

Increment both indices after each iteration. Finally, convert
the StringBuilder to a String.

## Why It Works

Both indices advance one position at a time, preserving the
character order within each string.

Appending from word1 before word2 ensures the required alternating
order while both strings have characters remaining.

Each access has its own bounds check. When one string ends,
only characters from the other are appended. The loop stops
when both strings have been fully processed, so every character
is included exactly once.

## Complexity

Let n be the length of word1 and m be the length of word2.

- Time: O(n + m). The loop runs max(n, m) times and appends
  n + m characters in total. Converting the result to a String
  also takes O(n + m) time.
- Auxiliary space: O(n + m) for the StringBuilder.
  The returned String also contains n + m characters.

## Edge Cases

- Both strings contain one character.
- Both strings have equal lengths.
- word1 is longer than word2.
- word2 is longer than word1.

## What I Learned

- String is immutable; StringBuilder supports appending characters.
- The || operator keeps the loop running while either string
  has characters remaining.
- Independent bounds checks prevent invalid character accesses.
- The number of loop iterations differs from the total number
  of characters appended.

## Submission

Accepted by LeetCode: 108/108 test cases passed.
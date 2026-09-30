# 1071 — Greatest Common Divisor of Strings

## Problem Link

https://leetcode.com/problems/greatest-common-divisor-of-strings/

## Difficulty

Easy

## Problem Summary

Given two strings, find the largest string that can be repeated
one or more times to construct both strings.

If no such common divisor string exists, return an empty string.

## Examples

| str1 | str2 | Output |
|------|------|--------|
| "ABCABC" | "ABC" | "ABC" |
| "ABABAB" | "ABAB" | "AB" |
| "LEET" | "CODE" | "" |
| "AAAAAB" | "AAA" | "" |

## Constraints

- Each string contains between 1 and 1000 characters.
- Both strings contain only uppercase English letters.

## Approach

First, check whether concatenating the strings in different orders
produces the same result.

If `str1 + str2` is different from `str2 + str1`, the strings
cannot be constructed from the same repeating pattern, so return
an empty string.

Otherwise, calculate the greatest common divisor (GCD) of the
two string lengths using the Euclidean algorithm.

The GCD gives the length of the largest possible common divisor
string. Return the first GCD characters of either string using
`substring`.

## Why It Works

If both strings are made by repeating the same base pattern,
concatenating them in either order produces the same string.

Once this compatibility is confirmed, any common divisor string
must have a length that divides both string lengths.

Therefore, the greatest possible length is the GCD of the two
lengths. The prefix of that length is the largest string that
can be repeated to construct both strings.

## Complexity

Let n be the length of `str1` and m be the length of `str2`.

- Time: O(n + m). Comparing the two concatenations requires
  processing n + m characters. The Euclidean algorithm takes
  O(log(min(n, m))) time.
- Auxiliary space: O(n + m), because the concatenated strings
  created for the compatibility check contain n + m characters.

## Edge Cases

- Both strings are identical.
- One string is a repetition of the other.
- Both strings share a smaller repeating pattern.
- The strings have no common repeating pattern.
- Both strings consist of a single character.

## What I Learned

- A common repeating pattern can be detected by comparing
  `str1 + str2` with `str2 + str1`.
- The GCD of the string lengths determines the length of the
  largest possible common divisor.
- The Euclidean algorithm can calculate the GCD recursively.
- `substring(0, x)` returns the first `x` characters of a string.

## Submission

Accepted by LeetCode: 129/129 test cases passed.
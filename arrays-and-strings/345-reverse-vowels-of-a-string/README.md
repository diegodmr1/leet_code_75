# 345. Reverse Vowels of a String

## Problem Link

[LeetCode - 345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)

## Difficulty

Easy

## Problem Summary

Given a string `s`, reverse only its vowels while keeping all other characters in their original positions.

Both uppercase and lowercase vowels are considered vowels.

## Examples

### Example 1

```text
Input: s = "IceCreAm"
Output: "AceCreIm"
```

### Example 2

```text
Input: s = "leetcode"
Output: "leotcede"
```

## Constraints

- `1 <= s.length <= 3 * 10^5`
- `s` consists of printable ASCII characters.

## Approach

Use two pointers:

- `i` starts at the beginning of the string.
- `j` starts at the end of the string.

Since Java strings are immutable, convert the string to a `char[]` so that characters can be swapped directly.

Move `i` to the right until it points to a vowel, and move `j` to the left until it points to a vowel.

When both pointers are positioned at vowels and `i < j`, swap the characters and move both pointers toward the center.

A helper method checks whether a character is a vowel by searching for it in `"aeiouAEIOU"`.

## Why It Works

The left pointer always finds the next vowel that has not been processed from the beginning, while the right pointer finds the next unprocessed vowel from the end.

Swapping these two characters places the corresponding vowels in their reversed positions.

After each swap, both pointers move inward. Repeating this process until the pointers meet ensures that every pair of vowels is reversed while all non-vowel characters remain unchanged.

## Complexity

Let `n` be the length of the string.

- **Time:** `O(n)` — the two pointers only move toward each other, so each character is processed a constant number of times.
- **Space:** `O(n)` — the string is converted to a `char[]` containing `n` characters. The additional variables use constant space.

## Edge Cases

- A string with no vowels.
- A string with only one vowel.
- A string containing only vowels.
- Uppercase and lowercase vowels.
- A string where the vowels are already symmetric.

## What I Learned

- How to use the two-pointer technique to process a sequence from both ends.
- How to avoid unnecessary repeated checks by giving each pointer a specific responsibility.
- Java `String` objects are immutable, so a `char[]` can be used when characters need to be modified in place.
- A `char[]` can be converted back to a string using `new String(characters)`.
- Helper methods can keep operations such as vowel checking and swapping separate from the main algorithm.
- Two sequential pointer movements do not make the algorithm `O(n²)` when each pointer only moves in one direction.
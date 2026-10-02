# 151. Reverse Words in a String

## Problem Link

[LeetCode - 151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

## Difficulty

Medium

## Problem Summary

Given a string `s`, reverse the order of its words.

A word is a sequence of non-space characters. The input may contain leading spaces, trailing spaces, or multiple spaces between words.

The returned string must contain exactly one space between each word and no leading or trailing spaces.

## Examples

### Example 1

```text
Input: s = "the sky is blue"
Output: "blue is sky the"
```

### Example 2

```text
Input: s = "  hello world  "
Output: "world hello"
```

### Example 3

```text
Input: s = "a good   example"
Output: "example good a"
```

## Constraints

- `1 <= s.length <= 10^4`
- `s` contains English letters, digits, and spaces.
- There is at least one word in `s`.

## Approach

Scan the string from right to left using an index `i`.

First, skip any spaces until `i` reaches the last character of a word.

Store `i + 1` as `end`, making it an exclusive index compatible with the range expected by `StringBuilder.append`.

Then continue moving `i` to the left until a space or the beginning of the string is reached. The beginning of the word is therefore `i + 1`, which is stored as `start`.

Append the range `[start, end)` directly from the original string to a `StringBuilder`.

Before appending each word except the first one, append a single space. This guarantees that the result contains exactly one space between words without adding leading or trailing spaces.

Using:

```java
result.append(s, start, end);
```

allows the required range to be appended directly from the original string without first creating a temporary substring.

## Why It Works

Scanning from right to left discovers the words in exactly the order required by the output.

Before processing a word, all spaces are skipped. This handles leading spaces, trailing spaces, and multiple spaces between words.

For each word, `start` points to its first character and `end` points to the position immediately after its last character.

Appending the range `[start, end)` therefore adds exactly that word to the result.

A space is added only when the `StringBuilder` already contains a word. As a result, spaces are inserted only between words and never at the beginning or end of the resulting string.

## Complexity

Let `n` be the length of the string.

- **Time:** `O(n)` — the index only moves from right to left and never moves back over previously processed characters. The multiple loops do not make the algorithm `O(n²)` because each character is processed a constant number of times.
- **Space:** `O(n)` — the `StringBuilder` stores the resulting string, which can contain up to `n` characters. Apart from the output, the algorithm uses only a constant number of index variables.

## Edge Cases

- A string with only one word.
- Leading spaces.
- Trailing spaces.
- Multiple spaces between words.
- Spaces on both sides of the string.
- A word that starts at index `0`.

## What I Learned

- How to analyze space complexity by identifying which structures grow with the input size.
- Multiple loops do not automatically make an algorithm `O(n²)` when the same index only moves in one direction.
- Java `String` objects are immutable, while `StringBuilder` is useful for efficiently constructing a string incrementally.
- `StringBuilder` is appropriate when repeatedly appending content, especially inside loops.
- `substring(start, end)` uses an exclusive `end` index.
- `StringBuilder.append(s, start, end)` can append a range directly from a string without creating a temporary substring.
- Avoiding intermediate structures such as the array created by `split()` can reduce auxiliary memory usage.
- Avoiding unnecessary temporary objects can improve memory efficiency without changing the overall time complexity.
- Scanning a string directly with indices gives more control over spaces and word boundaries than first splitting the entire input.
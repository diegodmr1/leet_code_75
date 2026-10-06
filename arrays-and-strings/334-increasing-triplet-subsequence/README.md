# 334. Increasing Triplet Subsequence

## Problem Link

[LeetCode - 334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)

## Difficulty

Medium

## Problem Summary

Given an integer array `nums`, return `true` if there are three indices `i < j < k` such that `nums[i] < nums[j] < nums[k]`.

Otherwise, return `false`.

The elements must appear in their original order, but they do not need to be adjacent. Equal values do not count as an increase.

## Examples

### Example 1

```text
Input: nums = [1, 2, 3, 4, 5]
Output: true
```

The values `1, 2, 3` form an increasing triplet.

### Example 2

```text
Input: nums = [5, 4, 3, 2, 1]
Output: false
```

No increasing triplet exists.

### Example 3

```text
Input: nums = [2, 1, 5, 0, 4, 6]
Output: true
```

The values `1, 4, 6` form an increasing triplet at indices `1, 4, 5`.

## Constraints

- `1 <= nums.length <= 5 * 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

## Approach

Use a greedy approach with two variables:

- `first` stores the smallest value seen so far.
- `second` tracks the smallest ending value of an increasing pair found so far.

Initialize both variables to `Integer.MAX_VALUE`, using it as an initial upper bound.

Traverse the array once:

- If the current value is less than or equal to `first`, update `first`.
- Otherwise, if the current value is less than or equal to `second`, update `second`.
- Otherwise, return `true`, because the current value completes an increasing triplet.

The second branch is only reached when the current value is greater than `first`, so updating `second` establishes a valid increasing pair.

The final branch is only reached when the current value is greater than both stored values.

Using `<=` handles repeated values without incorrectly treating them as a strict increase.

If the traversal finishes without finding a triplet, return `false`.

## Why It Works

Keeping the smallest first value makes it easier to form an increasing pair with future elements.

Keeping the smallest second value of a valid pair makes it easier to complete an increasing triplet. Any future value greater than a larger second candidate would also be greater than the smaller candidate.

Whenever `second` is updated, a smaller value has already appeared before it.

Updating `first` later does not invalidate that earlier pair. For example, after processing `[2, 5, 1]`, the variables contain `first = 1` and `second = 5`. Although the `1` appears after the `5`, the earlier pair `2, 5` still exists. A following `6` completes the valid triplet `2, 5, 6`.

Therefore, a value greater than `second` proves that an increasing triplet exists in the correct index order.

The algorithm also cannot miss a valid triplet: by the time its second element is processed, the stored first candidate is no greater than its first element. The stored second candidate then becomes, or already is, no greater than its second element. Its third element will therefore complete a triplet.

Initializing `second` to `Integer.MAX_VALUE` cannot produce a false positive, because no Java `int` is greater than that value.

## Complexity

Let `n` be the length of the array.

- **Time:** `O(n)` — the array is traversed once, with a constant number of operations per element.
- **Space:** `O(1)` — only a fixed number of variables is used, regardless of the array size.

## Edge Cases

- An array with fewer than three elements.
- An array containing only equal values.
- An array in strictly decreasing order.
- Repeated values that must not count as a strict increase.
- Negative values.
- Values equal to `Integer.MIN_VALUE` or `Integer.MAX_VALUE`.
- A smaller first candidate appearing after a valid pair has already been found, such as `[2, 5, 1, 6]`.

## What I Learned

- How to replace a nested search with a single traversal by retaining useful information.
- Why smaller candidates make it easier to complete an increasing sequence.
- The stored `first` and `second` do not always represent the same pair, but `second` preserves evidence of an earlier smaller value.
- Returning a boolean does not require storing the actual triplet.
- An `if / else if / else` chain can avoid redundant comparisons because later branches inherit guarantees from earlier conditions.
- Equality must be handled carefully when the problem requires strictly increasing values.
- `Integer.MAX_VALUE` can serve as an initial upper bound without requiring arithmetic that could overflow.
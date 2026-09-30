# 605. Can Place Flowers

## Problem Link

https://leetcode.com/problems/can-place-flowers/

## Difficulty

Easy

## Problem Summary

Given a flowerbed represented by an array of `0`s and `1`s, determine whether `n` new flowers can be planted without placing flowers in adjacent plots.

A `0` represents an empty plot and a `1` represents a plot that already contains a flower.

## Examples

### Example 1

Input:
`flowerbed = [1,0,0,0,1], n = 1`

Output:
`true`

### Example 2

Input:
`flowerbed = [1,0,0,0,1], n = 2`

Output:
`false`

## Constraints

- `1 <= flowerbed.length <= 2 * 10^4`
- `flowerbed[i]` is `0` or `1`.
- There are no two adjacent flowers in the initial `flowerbed`.
- `0 <= n <= flowerbed.length`

## Approach

Traverse the flowerbed from left to right and check whether a flower can be planted at each position.

A flower can be planted when:

- The current plot is empty.
- The plot on the left is empty, or the current plot is the first one.
- The plot on the right is empty, or the current plot is the last one.

When a valid position is found, set it to `1` so that subsequent checks consider the newly planted flower.

Keep track of how many flowers have been planted and return `true` as soon as the required number `n` is reached.

## Why It Works

When a flower is planted, the current position is immediately changed from `0` to `1`. Therefore, when the next position is evaluated, the newly planted flower is already considered.

By checking both neighbors before planting, the algorithm maintains the rule that no two flowers can be adjacent.

The first and last positions are handled by treating the missing neighbor as an available side.

## Complexity

Let `m` be the length of `flowerbed`.

- **Time:** O(m), since the array is traversed at most once.
- **Auxiliary Space:** O(1), since only a constant number of variables are used and the input array itself is modified.

## Edge Cases

- `n` is `0`.
- The flowerbed contains only one plot.
- A flower can be planted at the first plot.
- A flower can be planted at the last plot.
- The flowerbed has available positions, but not enough to plant all `n` flowers.

## What I Learned

- How to handle the first and last elements of an array without accessing invalid indices.
- How short-circuit evaluation with `||` can simplify boundary checks.
- How modifying the input array can preserve state without requiring additional memory.
- How to distinguish O(1) auxiliary space from O(m) space that would be required by an additional array.
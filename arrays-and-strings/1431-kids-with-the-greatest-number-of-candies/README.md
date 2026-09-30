# 1431. Kids With the Greatest Number of Candies

## Problem Link

https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

## Difficulty

Easy

## Problem Summary

Given an array where each element represents the number of candies a kid has, determine whether each kid could have the greatest number of candies after receiving all the extra candies.

Multiple kids can have the greatest number of candies.

## Examples

### Example 1

Input:
`candies = [2,3,5,1,3], extraCandies = 3`

Output:
`[true,true,true,false,true]`

### Example 2

Input:
`candies = [4,2,1,1,2], extraCandies = 1`

Output:
`[true,false,false,false,false]`

## Constraints

- `n == candies.length`
- `2 <= n <= 100`
- `1 <= candies[i] <= 100`
- `1 <= extraCandies <= 50`

## Approach

First, iterate through the `candies` array to find the greatest number of candies currently held by any kid.

Then, iterate through the array again. For each kid, add `extraCandies` to their current number of candies and compare the result with the previously found maximum.

If the new amount is greater than or equal to the maximum, add `true` to the result list. Otherwise, add `false`.

## Why It Works

The maximum value represents the number of candies a kid must reach or exceed to have the greatest number of candies.

For each kid, we independently consider what would happen if all the extra candies were given to that kid. If their resulting amount is at least the original maximum, they can have the greatest number of candies.

Using `>=` is important because multiple kids are allowed to share the greatest number of candies.

## Complexity

Let `n` be the number of kids.

- **Time:** O(n)
  - One traversal finds the maximum.
  - A second traversal builds the result.
  - Therefore, O(n) + O(n) = O(n).

- **Auxiliary Space:** O(n)
  - The returned `List<Boolean>` contains one value for each kid.
  - Apart from the output list, the algorithm uses O(1) additional space.

## Edge Cases

- A kid reaches exactly the current maximum after receiving the extra candies.
- Multiple kids already have the maximum number of candies.
- Only one kid can reach the maximum even after considering the extra candies.

## What I Learned

- How to find the maximum value in an integer array with a linear scan.
- How to build a `List<Boolean>` using `ArrayList`.
- The difference between `array.length` and collection methods in Java.
- Why `>=` is required when ties are allowed.
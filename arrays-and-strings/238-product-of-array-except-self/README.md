# 238. Product of Array Except Self

## Problem Link

[LeetCode - 238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## Difficulty

Medium

## Problem Summary

Given an integer array `nums`, create an array `answer` where `answer[i]` is the product of every element in `nums` except `nums[i]`.

The solution must run in `O(n)` time and cannot use division.

The follow-up asks for `O(1)` extra space, where the output array does not count as extra space.

## Examples

### Example 1

```text
Input: nums = [1, 2, 3, 4]
Output: [24, 12, 8, 6]
```

For example, at index `2`, the value `3` must be excluded:

```text
1 * 2 * 4 = 8
```

### Example 2

```text
Input: nums = [-1, 1, 0, -3, 3]
Output: [0, 0, 9, 0, 0]
```

A zero is important because any product containing it becomes zero. At the position of the zero itself, however, that zero is excluded from the product.

## Constraints

- `2 <= nums.length <= 10^5`
- `-30 <= nums[i] <= 30`
- The product of any prefix or suffix of `nums` fits in a 32-bit integer.
- Every `answer[i]` is guaranteed to fit in a 32-bit integer.

## Initial Approach

My first idea was to use two nested loops.

For every index `i`, I could traverse the entire array again and multiply every element whose index is different from `i`.

Conceptually:

```text
for each index i:
    product = 1

    for each index j:
        if j != i:
            product *= nums[j]

    answer[i] = product
```

This correctly solves the problem, including cases containing zero.

However, for each of the `n` positions, another loop processes approximately `n` elements:

```text
n * n = n²
```

Therefore, this approach takes `O(n²)` time and does not satisfy the required `O(n)` complexity.

The main problem is repeated work: many of the same products are calculated again for different positions.

## Key Observation

For each position, all elements except `nums[i]` can be divided into two groups:

- Elements to the left of `i`.
- Elements to the right of `i`.

For example:

```text
nums = [1, 2, 3, 4]
              ^
             i = 2
```

For index `2`:

```text
Left product:  1 * 2 = 2
Right product: 4     = 4

answer[2] = 2 * 4 = 8
```

So instead of repeatedly calculating "the product of everything except the current element", the problem can be viewed as:

```text
answer[i] = product of elements to the left
          * product of elements to the right
```

This makes it possible to reuse previously calculated products.

## Approach

The solution uses two passes through the array.

### First Pass — Left Products

Start with:

```text
leftProduct = 1
```

The value `1` is used because it is the identity element for multiplication. It represents the product when there are no elements on one side of the current position.

Before including `nums[i]`, store the current `leftProduct` in `answer[i]`.

For:

```text
nums = [1, 2, 3, 4]
```

the first pass builds:

```text
nums:    [1, 2, 3, 4]
answer:  [1, 1, 2, 6]
```

These values mean:

```text
answer[0] = 1           // nothing to the left
answer[1] = 1           // 1
answer[2] = 1 * 2       // 2
answer[3] = 1 * 2 * 3   // 6
```

The important order is:

1. Store `leftProduct` in `answer[i]`.
2. Multiply `leftProduct` by `nums[i]`.

This ensures that `nums[i]` is not included in its own left product, but is available for the next position.

### Second Pass — Right Products

Then traverse the array from right to left.

Start with:

```text
rightProduct = 1
```

At each position, `answer[i]` already contains the product of everything to the left.

Multiply it by `rightProduct`, which represents everything to the right:

```text
answer[i] *= rightProduct
```

Then update:

```text
rightProduct *= nums[i]
```

Again, the order matters: the current element is added to `rightProduct` only after calculating its own answer.

For `[1, 2, 3, 4]`, the process eventually produces:

```text
answer = [24, 12, 8, 6]
```

## Why It Works

During the first pass, `answer[i]` stores the product of every element before index `i`.

During the second pass, `rightProduct` stores the product of every element after index `i`.

Therefore, when the two values are multiplied:

```text
answer[i] = left product * right product
```

the result contains every element in the array except `nums[i]`.

The current element is excluded naturally because it is added to each running product only after its value has been used for the current position.

This also handles zeros without requiring special cases.

## Complexity

Let `n` be the number of elements in `nums`.

- **Time:** `O(n)` — one traversal processes the left products and another processes the right products. Two sequential `O(n)` loops result in `O(n + n) = O(2n) = O(n)`, not `O(n²)`.
- **Extra Space:** `O(1)` — only a fixed number of variables such as `leftProduct`, `rightProduct`, and `length` are used. The `answer` array does not count as extra space according to the problem statement.

## Edge Cases

- An array containing one zero.
- An array containing multiple zeros.
- Negative numbers.
- The minimum allowed array length.
- Values whose products are negative.
- The first element, which has no elements to its left.
- The last element, which has no elements to its right.

## Implementation Details and Pitfalls

### Arrays of `int` start with zero in Java

When creating:

```java
int[] answer = new int[length];
```

Java initializes every position to `0`.

Because of that, doing this before assigning another value would be incorrect:

```java
answer[i] *= leftProduct;
```

A zero multiplied by anything remains zero.

During the first pass, the correct idea is to assign the accumulated left product:

```java
answer[i] = leftProduct;
```

### The current element must be added after using the accumulated product

For the left side:

```text
store leftProduct
then include nums[i]
```

For the right side:

```text
multiply answer[i] by rightProduct
then include nums[i]
```

Updating the accumulator too early would incorrectly include `nums[i]` in its own result.

### Be careful with array boundaries

For an array of length `n`, valid indices are:

```text
0 ... n - 1
```

Starting a reverse loop at `n` would try to access an invalid index and cause an `ArrayIndexOutOfBoundsException`.

### Avoid processing an element twice

If the last position is handled separately before the reverse loop, the loop must continue from `length - 2`.

Otherwise, the last element would be included in its own product.

An alternative implementation could avoid special handling entirely by letting the loop start at `length - 1` with `rightProduct = 1`.

## What I Learned

- A straightforward correct solution can still be useful even when it is not efficient enough. Starting with the `O(n²)` solution helped identify the repeated work that needed to be removed.
- Instead of thinking only about "all elements except the current one", I can split the required information into what appears before and after the current position.
- Prefix and suffix products allow repeated multiplication work to be reused.
- `1` is the identity element of multiplication, which makes it useful when there are no elements to the left or right of a position.
- Running products such as `leftProduct` and `rightProduct` can carry information from one iteration to the next without recalculating previous values.
- The order of operations matters: use the accumulated product first and include the current element afterward so that `nums[i]` is excluded from its own answer.
- Two sequential loops over `n` elements are `O(n)`, because `O(n) + O(n) = O(n)`. Nested loops are what commonly lead to `O(n²)` when each performs `n` iterations.
- Java initializes every element of a new `int[]` to `0`, so assignment and multiplication are not interchangeable when building an array of products.
- Array indices go from `0` to `length - 1`. Starting at `length` causes an out-of-bounds access.
- When manually handling an element outside a loop, I need to make sure the loop does not process that same element again.
- The output array can be reused to store intermediate prefix products. Because the problem does not count the output array as extra space, this allows the solution to achieve `O(1)` extra space.
- Zeros do not require a separate special-case algorithm when using left and right products; the multiplication naturally produces the correct results.
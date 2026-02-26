# TCSS 371 – Machine Organization
## Assignment 1: Data Representation

---

## Purpose

This assignment tests understanding of **data representation concepts** from Chapter 2 of the textbook.

**Student Learning Outcome:** Convert numbers between various bases and use two's complement.

---

## Problems Overview

### 1. Two's Complement Problems *(5 points)*

**a.** What is the greatest magnitude **positive** number representable in **7-bit 2's complement**?
- Binary: _______________
- Decimal: _______________

**b.** What is the greatest magnitude **negative** number representable in **7-bit 2's complement**?
- Binary: _______________
- Decimal: _______________

**c.** The following are **5-bit 2's complement** numbers. Which operations generate **overflow**? Justify by translating operands and results to decimal.
- I. `10111 + 00111`
- II. `10101 – 00101`
- III. `01010 + 00111`

**d.** Convert the following decimal numbers to **hexadecimal 2's complement** representations (hint: convert to binary first):
- I. `114`
- II. `-71`

---

### 2. Unsigned Representation Problems *(2.5 points)*

Add the following unsigned binary numbers. Express the answer in binary and decimal.

- **a.** `00101 + 11011`
- **b.** `01110 + 01101`

---

### 3. Hexadecimal Conversions *(2.5 points)*

For each hex number, provide the value as a **2's complement binary** number and as an **ASCII string**:

| | `x354D5A22` | `x34253549` |
|---|---|---|
| 2's complement (binary) | | |
| ASCII string | | |

---

### 4. IEEE Floating Point *(2.5 points)*

**a.** Write the **decimal equivalent** of the following IEEE floating-point bit pattern:
```
1 1000 0001 0110 1000 0000 0000 0000 000
```

**b.** Write the **IEEE floating-point representation** of:
```
10.625
```

---

### 5. Java Programming *(7.5 points)*

Implement two methods in `Convert.java`:

#### `convert2sCompToDecimal(char[] theBits)`
Accepts an array of characters representing bits in a two's complement number and returns the decimal equivalent.

- Max array length: **16 bits**
- Throws `IllegalArgumentException` if length > 16
- Parameter array must be **unchanged** after the call

#### `convertDecimalTo2sComp(int theDecimal)`
Accepts a decimal integer and returns a `char[]` representing its **16-bit two's complement** equivalent.

- Throws `IllegalArgumentException` if the value cannot be represented in 16 bits

#### Rules & Restrictions
- ❌ Do **NOT** use Java built-in methods that perform the conversion for you
- ❌ Do **NOT** use data structures or `String`/`StringBuilder` as intermediate representations
- ✅ You **may** create private helper methods to reduce redundancy
- ✅ Public method signatures **must not** be changed
- ✅ Add **Javadoc comments** and an `@author` tag for each group member
- ✅ All provided unit tests in `ConvertTest.java` must pass

---

## Files to Submit

| File | Description |
|------|-------------|
| `Assignment1.pdf` / `.doc` / `.docx` | Written answers (must be legible, work shown) |
| `Convert.java` | Completed Java implementation |

> **Note:** Only one group member needs to submit. Ensure submission is before the due date.

---

## Grading Rubric

| Section | Points |
|---|---|
| Two's Complement Problems | 5.0 |
| Unsigned Representation Problems | 2.5 |
| Hexadecimal / ASCII | 2.5 |
| IEEE Floating Point Conversions | 2.5 |
| Java Programming | 7.5 |
| **Total** | **20.0** |

### Java Programming Breakdown
- 3.5 pts per method (correctness + all unit tests pass)
- 0.5 pts for code documentation/comments
- Use of data structures or Strings → point deduction
- Use of built-in conversion methods → at least **-3.75 pts up to no credit**

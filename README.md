# TCSS 371 – Machine Organization
## Assignment 5: LC3 Simulator

---

## Purpose

This assignment tests understanding of **LC3 instructions** by building a simplified LC3 simulator capable of running a subset of LC3 instructions.

**Student Learning Outcomes:**
- Translate between assembly instructions and machine code
- Explain the instruction execution cycle

---

## Group Requirement

> ⚠️ This assignment **must** be submitted as a group project of **no less than three members**.

Be sure to fill in your group members' names in the provided table linked at the top of the Assignment 5 page.

---

## Provided Starter Code

The starter code is provided as an **Eclipse archive file** and includes the following files:

| File | Status | Description |
|------|--------|-------------|
| `BitString.java` | 🚫 Do NOT modify | Core bit manipulation class used throughout the simulation |
| `Simulator.java` | 🚫 Do NOT modify | Contains a sample LC3 program (prints 9 down to 1, then halts) |
| `Computer.java` | ✅ Implement & submit | Main simulator class — implement the required methods |
| `ComputerTest.java` | ✅ Write tests & submit | Unit test class — write tests for your `Computer` implementations |

---

## File Descriptions

### `BitString.java`
The foundation of the simulation. A `BitString` object contains:
- A `char[]` array where each element is `'0'` or `'1'`
- A `length` field tracking how full the array is (0–16)

Many manipulation methods are already provided — **no additional methods need to be written**. Familiarize yourself with the existing API before writing any code.

### `Simulator.java`
Contains a short LC3 test program that:
- Prints the numbers **9 down to 1**
- Halts upon completion

A second test program is also included (currently commented out).

### `Computer.java`
Uses `BitString` objects to represent:
- **Registers** — stored as an array of `BitString` objects
- **Memory locations** — stored as an array of `BitString` objects

To implement each LC3 instruction, you will:
1. Use `BitString` objects to represent registers and intermediate values
2. Use `BitString` class methods to process each step of the instruction

> 💡 **Tip:** Frequently display the `Computer` object during development to verify each instruction behaves correctly. **Remove or comment out all debug display lines before submitting.**

### `ComputerTest.java`
Contains unit tests for the methods you implement in `Computer.java`. Already includes:
- 1 unit test for the `NOT` instruction
- 3 unit tests for the `ADD` instruction

Use these as **templates** when writing tests for the remaining instructions.

---

## Implementation Guidelines

- Become familiar with all existing code **before** writing any new code
- Each LC3 instruction implementation should follow the step-by-step execution cycle
- Use `BitString` methods wherever possible — they are designed to support your implementation
- Write unit tests in `ComputerTest.java` for every method you implement in `Computer.java`
- Clean up all temporary debug/display code before final submission

---

## Files to Submit

| File | Notes |
|------|-------|
| `Computer.java` | Required methods implemented, debug output removed |
| `ComputerTest.java` | Unit tests written for all implemented methods |

> Only one group member needs to submit. Ensure submission is made before the due date.

---

## Grading

**Total: 20 Points**

Grading will be based on correctness of the LC3 instruction implementations and the quality/coverage of your unit tests.

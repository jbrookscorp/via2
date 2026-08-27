# Bracket Validation

A Java implementation of the classic bracket validation algorithm, commonly used as an interview practice problem.

## Problem

Given a string containing only bracket characters (`(`, `)`, `{`, `}`, `[`, `]`), determine whether the brackets are valid. A string is valid when:

- Every opening bracket has a corresponding closing bracket of the same type
- Brackets are closed in the correct order (no interleaving)
- `null` input is considered invalid

**Valid:** `({[]})`, `(){}[]`, `(())`  
**Invalid:** `({)}`, `(]`, `(()`

## Approach

Uses a stack (LIFO) to track unmatched opening brackets as the string is scanned left to right:

1. **Opening bracket** — push onto the stack
2. **Closing bracket** — pop from the stack and verify it matches the expected opener; return `false` if the stack is empty or there is a mismatch
3. **Any other character** — return `false`
4. After the full scan, the string is valid only if the stack is empty (no unmatched openers remain)

**Time complexity:** O(n)  
**Space complexity:** O(n)

## Structure

| File | Description |
|---|---|
| `BracketValidationMain.java` | Core algorithm (`isValid`) with its own `main` entry point |
| `BracketValidationLogger.java` | Alternative entry point that delegates to `BracketValidationMain.isValid` |

## Requirements

- Java 21+
- Maven 3.6+

## Running

```bash
mvn compile exec:java
```

## Testing

```bash
mvn test
```

10 tests covering 5 valid and 5 invalid inputs:

| Input | Expected | Reason |
|---|---|---|
| `({[]})` | valid | Nested, all bracket types |
| `(){}[]` | valid | Sequential, all bracket types |
| `(())` | valid | Nested same type |
| `[{()}]` | valid | Deeply nested, all types |
| `([]{})` | valid | Mixed nesting and sequential |
| `({)}` | invalid | Interleaved brackets |
| `(]` | invalid | Wrong closer type |
| `(()` | invalid | Unclosed opener |
| `)` | invalid | Closer with no opener |
| `null` | invalid | Null input |

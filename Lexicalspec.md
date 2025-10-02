# Grammar
1. BOOLEAN -> ["true", "false", "nil"]
2. NUMBERS -> [0-9]
3. LETTERS -> [a-z, A-Z] 
4. WHITESPACE -> ["\t", "\n", "\r", " "]
5. COMMENTS -> ["//", /*]
# Rules For Identifiers
6. identifier -> LETTER (LETTER | DIGIT)
7. Identifiers are case-sensitive
8. Idenitifiers that match a keyword must be tokenized
# Rules For Literals
9. number_literal -> int_literal
10. int_literal -> digit (digit)
11. digit -> [0-9]
12. string_literal -> " any char except " and newline"
13. char_literal -> 'any single char except ' and newline'
14. boolean_literal -> "true", "false"
15. nil_literal -> "nil"
# Reserved Keywords
16. Reserved Keywords -> "if"|"for"|"else"|"else if"|"return"|"while"| 
"true"|"false"|"nil"|"or"|"function"|"let"|"constant"|"variable"|"enum"|"and"|
"not"
# Reserved Symbolic Operators
17. Arithmetic -> "+" | "-" | "*" | "/" | "%"
18. Comparison -> "==" |  "!=" | "<" | ">" | "<=" | ">="
19. Logial -> "&&" | "||" | "!"
20. Assignment -> "="
21. Other -> "." | "," | ";" | ":" | "(" | ")" | "{" | "}"



# Sample Programs
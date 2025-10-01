# Grammar
1. BOOLEAN -> ["true", "false", "nil"]
2. NUMBERS -> [0-9]
3. LETTERS -> [a-z, A-Z] 
4. WHITESPACE -> ["\t", "\n"]
5. COMMENTS -> ["//", */]
# Rules For Identifiers
6. Identifiers are case-sensitive
7. Idenitifiers that match a keyword must be tokenized
# Rules For Literals
8. number_literal -> int_literal
9. int_literal -> digit (digit)
10. digit -> [0-9]
11. string_literal -> "\'" ... "\'"
12. char_literal -> "''"
13. boolean_literal -> "true", "false"
14. nil_literal -> "nil"
# Reserved Keywords
15. Reserved Keywords -> "if"|"for"|"else"|"else if"|"return"|"while"| 
"true"|"false"|"nil"|"or"|"function"|"let"|"constant"|"variable"|"enum"|"and"|
"not"
# Reserved Symbolic Operators
16. Arithmetic -> "+" | "-" | "*" | "/" | "%"
17. Comparison -> "==" |  "!=" | "<" | ">" | "<=" | ">="
18. Logial -> "&&" | "||" | "!"
19. Assignment -> "="
20. Other -> "." | "," | ";" | ":"
# Sample Programs
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
22. Sample 1 --- 
23. var x = 10;
24. var y = 20;
25. var z = x * y + 5;
26. print z;
27. Sample 2 ---
28. fun add(a, b) {
29. return a + b;
30. }
31. fun main() {
32.    var result = add(5, 7);
33.   print result;
34. }
35. Sample 3 ---
36. var score = 87;
37. if (score > 90) {
38.    print "A";
39. } else if (score > 80) {
40.    print "B";
41. } else {
42.    print "C";
43. }
44. Sample 4 ---
45. var i = 0;
46. while (i < 5) {
47.    print i;
48.    i = i + 1;
49. }
50. Sample 5 ---
51. for (var i = 0; i < 3; i = i + 1) {
52.   print i;
53. }







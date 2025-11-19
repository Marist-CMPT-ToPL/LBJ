# Program 
1. program -> [declaration]
# Declarations
2. var_decl -> ["let" | "constant" | "variable"] identifier [":" type_annotation] ["=" expression] ";"
3. func_decl -> "function" identifier "("list")"
4. struct_decl -> "struct" identifier "{" [ ":" expression] "," "}"
5. enum_decl -> "enum" identifier "{" identifier ["=" expression] "," "}"
6. param_list -> param [ "," param]
7. param -> identifier [ ":"]
8. type_annotation -> identifier
# Expressions
9. expression -> assignment
10. assignment -> or "=" assignment
11. or -> and "||" assignment
12. and -> equality "&&" assignment
13. equality -> comparison "==" "!=" assignment
14. term -> factor "+" | "-" assignment
15. factor -> unary "*" | "/" | "%" assignment 
16. unary -> "!" | "-" assigment 
17. call -> primary ["(" arg_list ")" ] | "[" expression "]" "." identifier
18. arg_list -> expression ( "," expression )*
19. primary -> identifier | "(" expression ")" lambda
20. lambda -> [identifier] "=>" expression
21. literal -> number_literal | string_literal | char_literal | boolean_literal | nil_literal
# Statements
22. statement -> expr_stmt | if_stmt | while_stmt | for_stmt | retrun_stmt | block | break_stmt | continue_stmt
23. expr_stmt -> expression ";"
24. if_stmt -> "if" "(" expression ")" statement ["else" statement]
25. while_stmt -> "while" "(" expression ")" statement
26. for_stmt -> "for" "(" for_init | ";" expression ";" expression ")"
27. for_init -> var_decl_no_semi | expr_stmt_no_semi
28. var_decl_no_semi -> ["let" "variable" "constant"] identifier ":" type_annotation "=" expression
29. expr_stmt_no_semi -> expression
30. return_stmt -> "return" expression ";"
31. break_stmt -> "break" ";"
32. continue_stmt -> "continue" ";"
33. block -> "{" declaration "}"
# Auxiliary Rules
34. identifier -> LETTER [LETTER | DIGIT]
35. number_literal -> int_literal
36. string_literal -> "any char except" and "newline"
37. char_literal -> 'any single char except' and 'newline'
38. boolean_literal -> "true" | "false"
39. nil_literak -> "nil"

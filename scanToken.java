private void scanToken() {
    char c = advance();
    switch (c) {
    case '(' -> addToken(TokenType.LEFT_PAREN);
    case ')' -> addToken(TokenType.RIGHT_PAREN);
    case '{' -> addToken(TokenType.LEFT_BRACE);
    case '}' -> addToken(TokenType.RIGHT_BRACE);
    case ',' -> addToken(TokenType.COMMA);
    case '.' -> addToken(TokenType.DOT);
    case ';' -> addToken(TokenType.SEMICOLON);
    case ':' -> addToken(TokenType.COLON);
    case '+' -> addToken(TokenType.PLUS);
    case '-' -> addToken(TokenType.MINUS);
    case '*' -> addToken(TokenType.STAR);
    case '%' -> addToken(TokenType.PERCENT);
    case '!' -> addToken(match('=') ? TokenType.BANG_EQUAL : TokenType.BANG);
    case '=' -> addToken(TokenType.EQUAL);
    case '<' -> addToken(match('=') ? TokenType.LESS_EQUAL : TokenType.LESS);
    case '>' -> addToken(match('=') ? TokenType.GREATER_EQUAL : TokenType.GREATER);
    case '&' -> { 
        if (match('&')) {
            addToken(TokenType.AND_AND);
        } else {
            addToken(TokenType.ERROR, "Unexpected character '&'. Did you mean '&&'?");
        }
        case '|' -> {
            if (match('|')) {
                addToken(TokenType.OR_OR);
            } else {
                addToken(TokenType.ERROR, "Unexpected character '|'. Did you mean '||'?");
            }
        }
        case '/' -> {
            if (match('/')) {
                while (peek() != '\n' && !isAtEnd()) advance();
            } else if (match('*')) {
                blockComment();
            } else {
                addToken(TokenType.SLASH);
            }
      
            }
        }
        case ' ', '\r', '\t' -> {}
        case '\n' -> line++;
        case '\'' -> charLiteral();
        case '"' -> stringLiteral();
        default -> {
            if (isDigit(c)){
                number();
            } else if (isLetter(c)) {
                identifier();
            } else {
                errorToken("Unexpected character: '" + c + "'");
            }
        }
    }
}
private void blockComment() {
    while (!isAtEnd()) {
        if (ppek() == '*' && peekNext == '/') {
            advance();
            advance();
            return;
        }
        if (peek() == '\n') line++;
        advance();
    }
    errorToken("Unterminated block comment.");
}
private void identifier() {
    while (isLetterOrDigit(peek())) advance();
    String text = source.substring(start, current);
    TokenType type = keywords.get(text);
    if (type == null) type = TokenType.IDENTIFIER;
    addToken(type);
}
private void number() {
    while (isDigit(peek())) advance();
    String lexeme = source.substring(start, current);
    try {
        long value = Long.parseLong(lexeme);
        addToken(TokenType.NUMBER, value);
    } catch (NumberFormatException e) {
        errorToken("Invalid number: " + lexeme);
    }
}
private void stringLiteral() {
    while (peek() != '"' && !isAtEnd()) {
        if (peek() == '\n') line++;
        advance();
    }
    if (isAtEnd()) {
        errorToken("Unterminated string.");
        return;
    }
    advance();
    String value = source.substring(start + 1, current - 1);
    addToken(TokenType.STRING, value);
}
private void charLiteral() {
    if (isAtEnd()) {
        errorToken("Unterminated char literal.");
        return;
    }
    char c = advance();
    if (c == '\\') {
        if (isAtEnd()) {
            errorToken("Unterminated char escape.");
            return;
            char esc = advance();
            if (peek() != '\'') {
                errorToken("Unterminated char literal.");
                return;
                advance();
                addToken(TokenType.CHAR, "\\" + esc);
                return;
            }
            if (peek() != '\'') {
                errorToken("Unterminated char literal.");
                return;
                advance();
                addToken(TokenType.CHAR, "\\" + esc);
            }
        }
    }
}
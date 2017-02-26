/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


/**
 *
 * @author Warisha Munir
 */
public class Lexical {
    public String input;
    public ArrayList<Token> tokens;
    
    private static boolean contains(char[] arr, char targetValue) {
	for(char s: arr){
            if(s == targetValue)
                return true;
	}
	return false;
    }
    private void addToken(String word, int currentLineNo) {
        this.tokens.add(new Token(word, currentLineNo));
    }
    
    public void breakWords(String code) {
        int currentLineNo = 1;
        boolean isString = false;
        
        char[] wordBreaker = {'{','}', '[', ']', '(', ')' ,' ' ,'\n' , '\r', '\t', ';', '\'', '"'};
        for (int i = 0; i < code.length() ; i++){
            char ch = code.charAt(i); // getting current character 
            String temp = "";      
            if (isString) {
                if (ch == '\\') {
                    temp += ch;
                    i++;
                    ch = code.charAt(i);
                    temp += ch;
                    continue;
                }
                else if (ch == '"') {
                    temp += ch;
                    isString = false;
                }
                temp += ch;
            }
            if (Lexical.contains( wordBreaker, ch) && !temp.isEmpty()){
                if (ch == '"') {
                    addToken(temp, currentLineNo);
                    temp += ch;
                    isString = true;
                }
                else if (ch == '\'') {
                    addToken(temp, currentLineNo);
                    temp = "";
                    temp += ch; // add => '
                    i++; // next character
                    ch = code.charAt(i); // pick character at index i;
                    if (ch == '\\') {
                        temp += ch; // add =>  \\
                        ch = code.charAt(++i); // picking next character
                        temp += ch; // adds that character
                        // now ch should be single quote;
                        
                        
                        addToken(temp, currentLineNo);
                        temp = "";
                        continue;
                    }
                }
                else if (ch == '\n') { // if its a new line, add line Number count
                    currentLineNo++;
                }
                addToken(temp, currentLineNo);
                temp = "";
                
            }
        }
        
    }
}

class Token { 
    public String word;
    public int lineNumber;
    public Groups group;
    
    Token(String Word, int LineNumber, Groups Group) {
        this.word = Word;
        this.lineNumber = LineNumber;
        this.group = Group;
    }
    Token(String Word, int LineNumber) {
        this.word = Word;
        this.lineNumber = LineNumber;
    }
    
    void print () {
        System.out.format("(%20s, %10d, %30s)", this.group, this.word);
    }
    
    
}

enum Groups {
    BREAK_KW,
    STRUCTURE_KW,
    COMPLETE_KW,
    VOID_KW,
    RETURN_KW,
    IF_KW,
    ELSE_KW,
    WHILE_KW,
    OPT_KW,
    DEF_KW,
    CHAR_KW,
    INT_KW,
    STRING_KW,
    CONST_KW,
    REPEAT_KW,
    CRACK_KW,
    FLOAT_KW,
    INC_DEC_KW,
    AND_OR_KW,
    NOT_KW,
    ARITHEMATIC_OP,
    LOGICAL_OP,
    ASSIGNMENT_OP,
    RELATIONAL_OP,
    INT_CONST,
    FLOAT_CONST,
    STRING_CONST,
    CHARACTER_CONST,
    IDENTENTIFIER,
    CURLY_BRACKET_OPEN,
    SQUARE_BRACKET_OPEN,
    ROUND_BRACKET_OPEN,
    CURLY_BRACKET_CLOSE,
    SQUARE_BRACKET_CLOSE,
    ROUND_BRACKET_CLOSE
    
}
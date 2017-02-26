/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swk;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

/**
 * /** //word breaker,strings,float,all constants,comments,error@line,
 *
 * @author summy
 */
public class SWK {

    /**
     * @param args the command line arguments
     */
    public static String temp = "";
    public static int l = 1;
    //  public static void main(String[] args) {
    // TODO code application logic here

    //  public static  String temp="";
    //public static  int l=1;
    public static void main(String[] args) throws IOException {
        myNumber = 1;
        // TODO code application logic here
        String kw[] = {"str", "ret", "repeat", "if", "or", "while", "complete", "crack", "sw", "void", "opt", "def", "char", "string", "int", "float", "cons", "con"};
        String incdec[] = {"INC", "DEC"};
        String andor[] = {"AND", "OR"};
        String am[] = {"public", "private", "protected"};
        String n[] = {"NOT"};
        String s[] = {" "};
        String p[] = {":", "<", "/>", ",", "[", "]", "[", "]", ";", "{", "}", "(", ")"};
        String ao[] = {"+=", "-=", "/=", "%=", "*="};
        String addsub[] = {"+", "-"};
        String divmod[] = {"/", "%"};
        String mul[] = {"*"};
        String eq[] = {"="};
        String ro[] = {"JLE", "JGE", "JG", "JL", "JE", "JNE"};

        //String b= "";
        FileInputStream file = new FileInputStream("yo.txt");
        FileOutputStream fout = new FileOutputStream("output.txt");
        Scanner sc = new Scanner(file);
        PrintWriter pw = new PrintWriter(fout);
        String b = "";
        for (int k = 0; sc.hasNextLine(); k++) {
            b = b + sc.nextLine();
            //System.out.println(b);

        }
        //pw.println("helloooooo");
        char ar[];
        ar = b.toCharArray();
        int num = ar.length;
        //System.out.println(num);

        int i = 0;

        while (i <= num) {
            while ((ar[i] != ' ')) {
                /*if(ar[i]=='=')
                 {
                     token(temp);
                     koken("=");
                     continue;
                 }*/
                temp += ar[i];
                i++;
            }
            temp = temp.trim();
            if (temp.matches("[+-]?\\d+$")) {
                pw.println("[" + temp + " " + "," + "integer_constant" + "," + l + "]");
                pw.flush();
            }
            if (temp.matches("[+-]?\\d*[\\.]\\d+$||[+-]?\\d+[\\.]\\d*$")) {
                pw.println("[" + temp + "," + "float_constant" + "," + l + "]");
                pw.flush();
            }
            // '\\' , 'n'
            // '\n'
            if (ar[i] == '\n') //newline
            {
                l++;
                //temp = "\n";
                temp = " ";
            }

            for (int j = 0; j < kw.length; j++) {
                //kw
                if (kw.equals(temp)) {
                    pw.println("[" + temp + " " + "," + "KW" + "," + l + "]");
                    pw.flush();
                    temp = " ";
                }
            }

            //     System.out.println("("+temp+",id)");
            //}
            for (int j = 0; j < incdec.length; j++) //incdec
            {
                if (incdec[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "INC/DEC," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }
            for (int j = 0; j < andor.length; j++) //andor
            {
                if (andor[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "AND/OR," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < am.length; j++) //am
            {
                if (am[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "AM," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < n.length; j++) //not
            {
                if (n[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "NOT," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }
            for (int j = 0; j < s.length; j++) {                                        //spa
                if (s[j].equals(temp)) {
                    temp = temp.trim();
                    temp = "";
                }
            }

            for (int j = 0; j < p.length; j++) //punc
            {
                if (p[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "-," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < ao.length; j++) //ao
            {
                if (ao[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "AO," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < addsub.length; j++) //addsub
            {
                if (addsub[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "add/sub," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < divmod.length; j++) //div
            {
                if (divmod[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "div/mod," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }

            for (int j = 0; j < mul.length; j++) //mul
            {
                if (mul[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "mul," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }
            for (int j = 0; j < ro.length; j++) //ro
            {
                if (ro[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "ro," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }
            for (int j = 0; j < eq.length; j++) //eq
            {
                if (eq[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "equal," + l + "]");
                    pw.flush();
                    temp = "";
                }
            }
            //if(temp.matches("^[a-zA-Z][0-9]*(~?[a-zA-Z0-9]+)*~?[a-zA-Z]$||^[a-zA-Z]([a-zA-Z0-9]+~?)*[a-zA-Z]$||^[a-zA-Z]~[a-zA-Z]$||^[a-zA-Z]$"))  {  //id
            // if(temp.matches("^~[a-zA-Z][a-zA-Z0-9]*~"))           {

            for (int j = 0; j < kw.length; j++) {
                //kw
                if (kw[j].equals(temp)) {
                    pw.println("[" + temp + " " + "," + "KW" + "," + l + "]");
                    pw.flush();
                    temp = " ";
                }
            }
            if ((temp.matches("^[a-zA-Z]\\d*(~?[a-zA-Z0-9]+)*~?[a-zA-Z]$||^[a-zA-Z]([a-zA-Z0-9]+~?)*[a-zA-Z]$||^[a-zA-Z]~[a-zA-Z]$||^[a-zA-Z]$")) && (temp != "")) {
                //pw.println(temp);
                pw.println("[" + temp + " " + "," + "identifier" + "," + l + "]");
                pw.flush();
                temp = "";
            }
            if (temp.matches("\".*\"")) {
                pw.println("[" + temp + " " + ",string_constant," + l + "]");
                pw.flush();
                temp = "";
            }
            if ((temp.matches("\\'.\\'")) && temp != " ") {       //character
                //     System.out.println(temp);         
                pw.println("[" + temp + " " + "," + "char" + "," + l + "]");
                pw.flush();
                temp = "";
//temp="";         
            }
            if (!(temp.matches("\\'.\\'")) && 
                    !(temp.matches("\".*\"")) && 
                    !(temp.matches("^[a-zA-Z]\\d*(~?[a-zA-Z0-9]+)*~?[a-zA-Z]$||^[a-zA-Z]([a-zA-Z0-9]+~?)*[a-zA-Z]$||^[a-zA-Z]~[a-zA-Z]$||^[a-zA-Z]$")) && 
                    !(temp.matches("[+-]?\\d+$")) && 
                    !(temp.matches("[+-]?\\d*[\\.]\\d+$||[+-]?\\d+[\\.]\\d*$")) && 
                    !(temp.equals(" "))) {
                pw.println("Invalid identifier " + l.toString() );
                pw.flush();
                temp = "";
            }
            temp = "";
            i++;

        }
        sc.close();
        pw.close();
    }

}


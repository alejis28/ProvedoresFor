package com.example.DatosProveedores.Helpers;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidarPatron {
        public static boolean evaluarPatron(String regex, String cadenaEvaluar){
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(cadenaEvaluar);
            return matcher.matches() ? true : false;
        }
    }
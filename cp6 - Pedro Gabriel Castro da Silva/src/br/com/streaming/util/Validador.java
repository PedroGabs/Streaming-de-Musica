package br.com.streaming.util;

public class Validador {

    public static boolean emailValido(
        String email
    ) {

        return email != null
            && email.contains("@")
            && email.contains(".");
    }
}
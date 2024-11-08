package utils;

public class FormatterUtils {
    public static String formatCPF(String cpf) {
        // Remove qualquer caractere não numérico, caso o CPF esteja mal formatado
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() == 11) {
            // Formata no padrão 000.000.000-00
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        } else {
            // Retorna o CPF sem formatação se ele não tiver 11 dígitos
            return cpf;
        }
    }
}

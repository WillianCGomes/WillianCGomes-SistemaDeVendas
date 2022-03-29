package util;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

/**
 * Classe responsável por armazenar os métodos de validação de dados
 *
 * @author Willian Carlos Gomes
 * @since 01/04/2021
 * @version 1.0
 */
public class Valida {
    Locale locale = new Locale("pt", "BR");
    // Método para verificar se há apenas texto
    public static boolean isOnlyText(String text) {
        if (text.matches("[A-Z a-z\u00C0-\u00FF]*")) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * método para verificar se o CNPJ foi preenchido
     */
    public static boolean isCnpjVazio(String args) {
        return args.equals(Mascara.cnpjMascara);
    }

    /*
     * método para verificar se o CNPJ informado é valido
     */
    public static boolean isCnpjInvalido(String args) {
        CNPJValidator validador = new CNPJValidator();
        try {
            validador.assertValid(args);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /*
     * método para verificar se o CPF foi preenchido
     */
    public static boolean isCpfVazio(String args) {
        return args.equals(Mascara.cpfMascara);
    }

    /*
     * método para verificar se o CPF informado é valido
     */
    public static boolean isCpfInvalido(String args) {
        CPFValidator validador = new CPFValidator();
        try {
            validador.assertValid(args);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    
    /*
     * método para verificar se o RG foi preenchido
     */
    public static boolean isRgVazio(String args) {
        return args.equals(Mascara.rgMascara);
    }
    
    /*
     * método para verificar se a Inscrição Estadual foi preenchida
     */
    public static boolean isInscricaoEstadualVazio(String args) {
        return args.equals(Mascara.inscricaoEstadualMascara);
    }

    /*
     * método para verificar se a Inscrição Estadual informada é valida
     */
    public static boolean isInscricaoEstadualInvalido(String args) {
        IESaoPauloValidator validador = new IESaoPauloValidator();
        try {
            validador.assertValid(args);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /*
     * método para verificar se a data foi preenchida
     */
    public static boolean isDataVazia(String args) {
        return args.equals(Mascara.dataMascara);
    }

    /*
     * método para verificar se a data é valida
     */
    public static boolean isDataInvalida(String args) {
        String formato = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato).withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(args, dateTimeFormatter);
            return false;
        } catch (DateTimeParseException e) {
            return true;
        }
    }

    /*
     * método para verificar se o cep é valido
     */
    public static boolean isCepVazio(String args) {
        return args.equals(Mascara.cepMascara);
    }

    /*
     * método para verificar se o celular é valido
     */
    public static boolean isCelularVazio(String args) {
        return args.equals(Mascara.celularMascara);
    }

    /*
     * método para verificar se uma String está vazia ou nula
     */
    public static boolean isEmptyOrNull(String args) {
        return (args.trim().equals("") || (args == null));
    }

     /*
     * método para verificar se o campo é ponto flutuante
     */
    public static boolean isDouble(String args) {
        try {
            Double.parseDouble(args);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
     * método para verificar se o campo é inteiro
     */
    public static boolean isInteger(String args) {
        try {
            Integer.parseInt(args);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * método para verificar se um item da combo foi selecionado
     */
    public static boolean isComboInvalida(int index) {
        return index == 0;
    }
    
   
}

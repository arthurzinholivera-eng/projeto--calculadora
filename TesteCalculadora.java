package calculadora;
import calculadora.Calculadora;
/* 
 * @author Arthur Oliveira
 * @version 1.0
 */
public class TesteCalculadora {
    private static int passou = 0;
    private static int falhou = 0;
     
    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        System.out.println("=== TESTES DA CALCULADORA ===");

        testarSoma(c);
        testarSubtracao(c);
        testarMultiplicacao(c);
        testarDivisao(c);
        testarDivisaoPorZero(c);
        testarOperacaoInvalida(c);

        System.out.println("\n=== RESUMO ===");
        System.out.println("Passou: " + passou);
        System.out.println("Falhou: " + falhou);
    }

    private static void testarSoma(Calculadora c) {
        int a = 2, b = 3;
        int esperado = 5;
        int obtido = c.calc(a, b, "+");
        verificar("Soma", a + " + " + b, esperado, obtido);
    }

    private static void testarSubtracao(Calculadora c) {
        int a = 5, b = 3;
        int esperado = 2;
        int obtido = c.calc(a, b, "-");
        verificar("Subtracao", a + " - " + b, esperado, obtido);
    }

    private static void testarMultiplicacao(Calculadora c) {
        int a = 4, b = 3;
        int esperado = 12;
        int obtido = c.calc(a, b, "*");
        verificar("Multiplicacao", a + " * " + b, esperado, obtido);
    }

    private static void testarDivisao(Calculadora c) {
        int a = 10, b = 2;
        int esperado = 5;
        int obtido = c.calc(a, b, "/");
        verificar("Divisao", a + " / " + b, esperado, obtido);
    }

    private static void testarDivisaoPorZero(Calculadora c) {
        try {
            c.calc(10, 0, "/");
            System.out.println("[FALHOU] Divisao por zero — deveria lançar excecao");
            falhou++;
        } catch (ArithmeticException e) {
            System.out.println("[PASSOU] Divisao por zero — excecao capturada: " + e.getMessage());
            passou++;
        }
    }

    private static void testarOperacaoInvalida(Calculadora c) {
        try {
            c.calc(1, 1, "%");
            System.out.println("[FALHOU] Operacao invalida — deveria lançar excecao");
            falhou++;
        } catch (IllegalArgumentException e) {
            System.out.println("[PASSOU] Operacao invalida — excecao capturada: " + e.getMessage());
            passou++;
        }
    }

    /*  
    * @param nome     nome do teste
     * @param entrada  descrição da entrada
     * @param esperado resultado esperado
     * @param obtido   resultado obtido
     */
    
    private static void verificar(String nome, String entrada, int esperado, int obtido) {
        if (esperado == obtido) {
            System.out.println("[PASSOU] " + nome + " | Entrada: " + entrada
                    + " | Esperado: " + esperado + " | Obtido: " + obtido);
            passou++;
        } else {
            System.out.println("[FALHOU] " + nome + " | Entrada: " + entrada
                    + " | Esperado: " + esperado + " | Obtido: " + obtido);
            falhou++;
        }
    }
}
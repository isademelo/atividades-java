import java.util.Scanner;
//1- Crie um programa que solicite ao usuário digitar um número. Se o número for positivo, exiba "Número positivo", caso contrário, exiba "Número negativo".
//2- Peça ao usuário para inserir dois números inteiros. Compare os números e imprima uma mensagem indicando se são iguais, diferentes, o primeiro é maior ou o segundo é maior.
public class AtividadesComplementaresControlandoFluxos {
    public static void main(String[] args){
        DescobrirSeEhNegativoOuPositivo.descobrir();
        CalculadoraGeometrica.calcularGeometria();
        TabuadaDeUmNumero.tabuadaDoNumeroEscolhido();
        VerificarSeEhImparOuPar.verificarSeEhImparOuPar();
        CalcularOFatorialDeUmNumero.calcularOFatorialDeUmNumero();
    }
}

class DescobrirSeEhNegativoOuPositivo {
    public static void descobrir (){
        int numero = 0;
        int num1 = 0;
        int num2 = 0;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo ao analisador de números! Prepare-se para descobrir a natureza do valor digitado.\nDigite um número e iremos verificar se é um número positivo ou negativo: ");
        numero = entrada.nextInt();
        if (numero < 0){
            System.out.println(String.format("O número que você digitou, %d é negativo", numero));
        } else if (numero > 0){
            System.out.println(String.format("O número que você digitou, %d é positivo", numero));
        } else {
            System.out.println("O número digitado é 0");
        }

        //resolução da atividade 2
        System.out.println("Agora insira 2 números inteiros, iremos comparar e indicaremos se eles são iguais, diferentes");
        System.out.println("Insira o primeiro número: ");
        num1 = entrada.nextInt();
        System.out.println("Insira o segundo número: ");
        num2 = entrada.nextInt();

        if (num1 != num2){
            if (num1 > num2) {
                System.out.println(String.format("Os números são diferentes. O número 1 (%d) é maior que o número 2 (%d) ", num1, num2));
            } else {
                System.out.println(String.format("Os números são diferentes. O número 2 (%d) é maior que o número 1 (%d) ", num2, num1));
            }
        } else {
            System.out.println("Os números que você digitou são iguais!");
        }

    }
}

//3- Crie um menu que oferece duas opções ao usuário: "1. Calcular área do quadrado" e "2. Calcular área do círculo". Solicite a escolha do usuário e realize o cálculo da área com base na opção selecionada.
class CalculadoraGeometrica{
    public static void calcularGeometria(){
        Scanner entrada = new Scanner(System.in);
        double pi = 3.14;
        String menu = """
                ==================== MENU ====================
                1 - Cálculo de Áreas
                2 - Cálculo de Volumes
                3 - Sair
                =============================================
                Digite a opção desejada:\s
                """;
        System.out.println(menu);
        byte opcaoMenu = entrada.nextByte();
        byte opcaoSubMenu;
        while (opcaoMenu != 3){
            switch (opcaoMenu){
                case 1:
                    System.out.println("""
                            ============= CÁLCULO DE ÁREAS =============
                            1 - Área do Quadrado
                            2 - Área do Retângulo
                            3 - Área do Triângulo
                            4 - Área do Círculo
                            5 - Área do Trapézio
                            6 - Área do Losango
                            7 - Voltar ao menu anterior
                            ============================================
                            Digite a opção desejada:
                            """);
                    opcaoSubMenu = entrada.nextByte();
                    while (opcaoSubMenu < 1 || opcaoSubMenu > 7){
                        System.out.println("Número inválido, tente novamente: ");
                        opcaoSubMenu = entrada.nextByte();
                    }
                    if (opcaoSubMenu == 1){
                        System.out.println("Você escolheu a opção de calcular a área do quadrado, digite a medida dos lados: ");
                        double lados = entrada.nextDouble();
                        double areaDoQuadrado = lados * lados;
                        System.out.println(String.format("A área do quadrado é: %.2fcm²", areaDoQuadrado));
                    } else if (opcaoSubMenu == 2){
                        System.out.println("Você escolheu a opção de calcular a área do retângulo, digite a medida do primeiro lado: ");
                        double lado1 = entrada.nextDouble();
                        System.out.println("Agora digite a medida do segundo lado: ");
                        double lado2 = entrada.nextDouble();
                        double areaDoRetangulo = lado1 * lado2;
                        System.out.println(String.format("A área do retângulo é: %.2fcm²", areaDoRetangulo));
                    } else if (opcaoSubMenu == 3){
                        System.out.println("Você escolheu a opção de calcular a área do triângulo, digite a medida da base: ");
                        double base = entrada.nextDouble();
                        System.out.println("Agora digite a medida da altura: ");
                        double altura = entrada.nextDouble();
                        double areaDoTriangulo = (base * altura) / 2;
                        System.out.println(String.format("A área do triângulo é: %.2fcm²", areaDoTriangulo));
                    } else if (opcaoSubMenu == 4){
                        System.out.println("Você escolheu a opção de calcular a área do círculo, digite a medida do raio: ");
                        double raio = entrada.nextDouble();
                        double areaDoCirculo = pi * raio * raio;
                        System.out.println(String.format("A área do círculo é %.2fcm²", areaDoCirculo));
                    } else if (opcaoSubMenu == 5){
                        System.out.println("Você escolheu a opção de calcular a área do trapézio, digite a medida da base maior: ");
                        double baseMaior = entrada.nextDouble();
                        System.out.println("Agora digite a medida da base menor: ");
                        double baseMenor = entrada.nextDouble();
                        System.out.println("Agora digite a medida da altura");
                        double altura = entrada.nextDouble();
                        double areaDoTrapezio = (baseMaior + baseMenor) * altura / 2;
                        System.out.println(String.format("A área do trapézio é %.2fcm²", areaDoTrapezio));
                    } else if (opcaoSubMenu == 6){
                        System.out.println("Você escolheu a opção de calcular a área do losango, digite a medida da diagonal maior: ");
                        double diagonalMaior = entrada.nextDouble();
                        System.out.println("Agora digite a diagonal menor: ");
                        double diagonalMenor = entrada.nextDouble();
                        double areaDoLosango = (diagonalMaior*diagonalMenor)/2;
                        System.out.println(String.format("A área do losango é: %.2fcm²", areaDoLosango));
                    } else if (opcaoSubMenu == 7) {
                    System.out.println("Voltando ao menu principal...");
                    }
                    break;

                case 2:
                    System.out.println("""
                            ============= CÁLCULO DE VOLUMES ============
                            1 - Volume do Cubo
                            2 - Volume do Paralelepípedo
                            3 - Volume do Cilindro
                            4 - Volume do Cone
                            5 - Volume da Esfera
                            6 - Voltar ao menu anterior
                            ============================================
                            Digite a opção desejada:
                            """);
                    opcaoSubMenu = entrada.nextByte();
                    while (opcaoSubMenu < 1 || opcaoSubMenu > 6){
                        System.out.println("Número inválido, tente novamente: ");
                        opcaoSubMenu = entrada.nextByte();
                    }
                    if (opcaoSubMenu == 1){
                        System.out.println("Você escolheu a opção de calcular o volume do cubo, digite a medida das arestas: ");
                        double aresta = entrada.nextDouble();
                        double volumeDoCubo = aresta * aresta * aresta;
                        System.out.println(String.format("O volume do cubo é: %.2fcm³", volumeDoCubo));
                    } else if (opcaoSubMenu == 2){
                        System.out.println("Você escolheu a opção de calcular o volume do paralelepípedo, digite a medida do comprimento: ");
                        double comprimento = entrada.nextDouble();
                        System.out.println("Agora digite a medida da largura: ");
                        double largura = entrada.nextDouble();
                        System.out.println("Agora digite a medida da altura: ");
                        double altura = entrada.nextDouble();
                        double volumeDoParalele = comprimento * largura * altura;
                        System.out.println(String.format("O volume do paralelepípedo é: %.2fcm³", volumeDoParalele));
                    } else if (opcaoSubMenu == 3){
                        System.out.println("Você escolheu a opção de calcular o volume do cilindro, digite a medida do raio: ");
                        double raio = entrada.nextDouble();
                        System.out.println("Agora digite o valor da altura do cilíndro: ");
                        double altura = entrada.nextDouble();
                        double volumeDoCilindro = pi * raio * raio * altura;
                        System.out.println(String.format("O volume do cilíndro é: %.2fcm³", volumeDoCilindro));
                    } else if (opcaoSubMenu == 4){
                        System.out.println("Você escolheu a opção de calcular o volume do cone, digite a medida do raio: ");
                        double raio = entrada.nextDouble();
                        System.out.println("Agora digite o valor da altura do cone: ");
                        double altura = entrada.nextDouble();
                        double volumeDoCone = (pi * raio * raio * altura)/3;
                        System.out.println(String.format("O volume do cone é: %.2fcm³", volumeDoCone));
                    } else if (opcaoSubMenu == 5){
                        System.out.println("Você escolheu a opção de calcular o volume da esfera, digite a medida do raio: ");
                        double raio = entrada.nextDouble();
                        double volumeDaEsfera = (pi * raio * raio * raio) * 4/3;
                        System.out.println(String.format("O volume da esfera é: %.2fcm³", volumeDaEsfera));
                    } else if (opcaoSubMenu == 6) {
                        System.out.println("Voltando ao menu principal...");
                    }
                    break;
            }
            System.out.println(menu);
            opcaoMenu = entrada.nextByte();
        }
    }
}

//4- Crie um programa que solicite ao usuário um número e exiba a tabuada desse número de 1 a 10.
class TabuadaDeUmNumero{
    public static void tabuadaDoNumeroEscolhido(){
        System.out.println("""
                ==================== TABUADA ====================
                Digite um número para ver a tabuada de 1 a 10:
                """);
        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();
        System.out.println(String.format("""
                =======================================
                            TABUADA DO %d
                =======================================""", numero));
        for (int i = 1; i <= 10; i++){
           int resultadoTabuada = numero * i;
            System.out.println(String.format("%d X %d = %d", numero, i, resultadoTabuada));
        }
    }
}

//5- Crie um programa que solicite ao usuário a entrada de um número inteiro. Verifique se o número é par ou ímpar e exiba uma mensagem correspondente.
class VerificarSeEhImparOuPar{
    public static void verificarSeEhImparOuPar(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("""
                ==================== DESAFIO 5 ====================
                            VERIFICADOR DE PAR OU ÍMPAR
                ---------------------------------------------------
                Digite um número inteiro: """);
        int numeroEscolhido = entrada.nextInt();
        if (numeroEscolhido % 2 == 0){
            System.out.println("O número é par");
        } else {
            System.out.println("O número é ímpar");
        }
    }
}

//6- Crie um programa que solicite ao usuário um número e calcule o fatorial desse número.

class CalcularOFatorialDeUmNumero{
    public static void calcularOFatorialDeUmNumero(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("""
        ===================================================
                        CÁLCULO DE FATORIAL
        ---------------------------------------------------
        Digite um número inteiro para calcular o fatorial: """);

        int numeroFatorial = entrada.nextInt();

        for (int i = numeroFatorial - 1; i > 1; i--) {
            numeroFatorial *= i;
        }
        System.out.println(String.format("Resultado: %d", numeroFatorial));
    }
}
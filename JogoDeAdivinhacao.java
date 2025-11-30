//Agora é com você! Pratique os conceitos que foram ensinados ao longo dessa aula com o seguinte desafio:
//
//Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que o usuário tente adivinhar o número,
// em até 5 tentativas. A cada tentativa, o programa deve informar se o número digitado pelo usuário é maior ou menor do que o número gerado.
//
//Dicas:
//Para gerar um número aleatório em Java: new Random().nextInt(100);
//Utilize o Scanner para obter os dados do usuário;
//Utilize uma variável para contar as tentativas;
//Utilize um loop para controlar as tentativas;
//Utilize a instrução break; para interromper o loop.

import java.util.Scanner;

public class JogoDeAdivinhacao {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);

        int totalTentativas = 0;
        int palpiteDoUsuario = 0;
        int tentativas = 0;
        int numeroMaximo = 0;
        boolean contemNaLista = false;

        //apenas os prints do codigo que mostram configuração de jogo, e as outras informações são feitas com IA, a lógica da programação foi tudo feito por mim

        System.out.println("""
        ======================== CONFIGURAÇÃO DO JOGO ========================
        
        Escolha o limite máximo para definir a dificuldade do desafio:
        
        🔹 1 a 10  →  MODO FÁCIL
           Intervalo pequeno e maior chance de acerto.
           Tentativas disponíveis: 5
        
        🔸 1 a 50  →  MODO MÉDIO
           Intervalo moderado, exige mais estratégia.
           Tentativas disponíveis: 7
        
        🔺 1 a 100 →  MODO DIFÍCIL
           Intervalo grande, foco total na lógica.
           Tentativas disponíveis: 10
        
        Digite o número máximo desejado (10, 50 ou 100):
        """);
        numeroMaximo = entrada.nextInt();
        entrada.nextLine();

        while (numeroMaximo != 10 && numeroMaximo != 50 && numeroMaximo != 100) {
            System.out.println("Valor inválido! Digite 10, 50 ou 100:");
            numeroMaximo = entrada.nextInt();
            entrada.nextLine();
        }

        int numeroAleatorio = (int) (Math.random()*numeroMaximo)+1;
        switch (numeroMaximo) {
            case 10:
                totalTentativas = 5;
                break;
            case 50:
                totalTentativas = 7;
                break;
            case 100:
                totalTentativas = 10;
                break;
            default:
                totalTentativas = 5;
        }
        int [] historicoChutes = new int[totalTentativas];
        System.out.println(String.format("""
        =======================================
                 JOGO DE ADIVINHAÇÃO 🎲
        =======================================
        Eu pensei em um número entre 1 e %d.
        Você tem %d tentativas para descobrir qual é!
        
        A cada tentativa, eu aviso se o número é
        MAIOR ou MENOR do que o que você digitou.
        
        Boa sorte!
        =======================================
        Digite seu palpite: """, numeroMaximo, totalTentativas));

        palpiteDoUsuario = entrada.nextInt();
        entrada.nextLine();

        while (palpiteDoUsuario > numeroMaximo || palpiteDoUsuario < 1){
            System.out.println(String.format(" Número inválido! O valor deve estar entre 1 e %d. Tente novamente: ", numeroMaximo));
            palpiteDoUsuario = entrada.nextInt();
            entrada.nextLine();
        }

        if (palpiteDoUsuario != numeroAleatorio){
            if ((palpiteDoUsuario > numeroAleatorio)) {
                System.out.println(String.format("DICA: O número aleatório é menor que %d", palpiteDoUsuario));
            } else {
                System.out.println(String.format("DICA: O número aleatório é maior que %d", palpiteDoUsuario));
            }
        }

        historicoChutes[tentativas] = palpiteDoUsuario;
        tentativas ++;

        while (palpiteDoUsuario != numeroAleatorio){
            if (tentativas < totalTentativas) {
                System.out.println(String.format("""
                        Palpite incorreto!
                        Você possui mais %d tentativas
                        Tente novamente... quem sabe agora você acerta?
                        Digite outro número: 
                        """, totalTentativas - tentativas));

                        palpiteDoUsuario = entrada.nextInt();
                        entrada.nextLine();

                        while (palpiteDoUsuario > numeroMaximo || palpiteDoUsuario < 1){
                            System.out.println(String.format(" Número inválido! O valor deve estar entre 1 e %d. Tente novamente: ", numeroMaximo));
                            palpiteDoUsuario = entrada.nextInt();
                            entrada.nextLine();
                        }

                        contemNaLista = false;
                        for (int i = 0; i < tentativas; i++) {
                            if (historicoChutes[i] == palpiteDoUsuario) {
                                contemNaLista = true;
                                break;
                            }
                        }

                        while (contemNaLista) {
                            System.out.println("Você já tentou esse número antes! Digite um palpite diferente:");
                            palpiteDoUsuario = entrada.nextInt();
                            entrada.nextLine();
                            contemNaLista = false;

                            for (int i = 0; i < tentativas; i++) {
                                if (historicoChutes[i] == palpiteDoUsuario) {
                                    contemNaLista = true;
                                    break;
                                }
                            }
                        }

                historicoChutes[tentativas] = palpiteDoUsuario;
                tentativas ++;

                if (palpiteDoUsuario != numeroAleatorio && tentativas < totalTentativas) {
                    if ((palpiteDoUsuario > numeroAleatorio)) {
                        System.out.println(String.format("DICA: O número aleatório é menor que %d", palpiteDoUsuario));
                    } else {
                        System.out.println(String.format("DICA: O número aleatório é maior que %d", palpiteDoUsuario));
                    }
                }

            } else if (palpiteDoUsuario != numeroAleatorio && tentativas == totalTentativas){
                System.out.println("""
                    ===============================
                           FIM DE JOGO 
                    ===============================
                    Suas tentativas acabaram...
                    O número secreto continua um mistério!
                    
                    📜 Histórico de palpites realizados:
                    """);
                break;
            }
        }

        if (palpiteDoUsuario == numeroAleatorio && tentativas == 1){
            System.out.println("Incrível! Você acertou o número logo na primeira tentativa! Parabéns!");
        } else if (palpiteDoUsuario == numeroAleatorio && tentativas <= totalTentativas){
            System.out.println(String.format("INCRÍVEL! Você descobriu o número secreto em %d tentativas!", tentativas));
        }

        for (int i = 0; i < tentativas; i++) {
            System.out.printf("Tentativa %d | Palpite : %d \n", (i+1), historicoChutes[i]);
        }
        entrada.close();
    }
}

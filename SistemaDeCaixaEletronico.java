/*
    DESAFIO – Caixa Eletrônico Simulado

    Crie um programa em Java que simula um caixa eletrônico simples.
    O sistema deve iniciar com saldo igual a R$ 0,00 e permitir que o usuário
    interaja através de um menu com as seguintes opções:

    ===== MENU =====
    1 - Depositar
    2 - Sacar
    3 - Ver saldo
    4 - Ver histórico
    0 - Sair

    REGRAS DO SISTEMA:

    1. Depositar:
       - Usuário informa um valor.
       - Não pode depositar valores negativos.
       - O valor deve ser somado ao saldo.
       - Deve ser registrado no histórico a mensagem:
         "Depósito de R$ X".

    2. Sacar:
       - Usuário informa um valor.
       - Não pode sacar valores negativos.
       - Não pode sacar mais do que o saldo disponível.
       - Se válido, subtrair o valor do saldo.
       - Registrar no histórico:
         "Saque de R$ X".

    3. Ver saldo:
       - Exibir o saldo atual formatado, exemplo:
         "Seu saldo atual é: R$ 125.50".

    4. Ver histórico:
       - Criar um array de Strings com tamanho 50:
            String[] historico = new String[50];
       - Cada operação (depósito ou saque) deve ser gravada
         na próxima posição livre do vetor.
       - Listar todas as operações registradas.
       - Se não houver registros, mostrar:
         "Nenhuma operação registrada."

    OBSERVAÇÕES:
       - Use loops (while) para manter o menu funcionando.
       - Use validação de entrada sempre que necessário.
       - Utilize Scanner para ler os valores do usuário.
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaDeCaixaEletronico {
    public static void main (String [] args){
        DateTimeFormatter tempoFormatado =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String[] historico = new String[50];
        char confirmar;
        double valorDeposito = 0;
        double valorSaque = 0;
        double saldo = 0;
        int posicao = 0;
        int opcaoMenu;
        Scanner lerEntradas = new Scanner (System.in);
        String menu = """
                =====================================
                           CAIXA ELETRÔNICO
                =====================================
                
                Gerencie seu saldo realizando depósitos, saques e consultas.
                Para começar, escolha uma das opções no menu abaixo:
                
                =====================================
                               MENU
                =====================================
                1 - Depositar
                2 - Sacar
                3 - Ver saldo
                4 - Ver histórico
                0 - Sair
                -------------------------------------
                Escolha uma das opções do menu: """;

        System.out.println(menu);
        opcaoMenu = lerEntradas.nextInt();
        lerEntradas.nextLine();

        while (opcaoMenu < 0 || opcaoMenu > 4){
            System.out.println("Opcao inválida, tente novamente");
            opcaoMenu = lerEntradas.nextInt();
            lerEntradas.nextLine();
        }

        while (opcaoMenu != 0) {

            switch (opcaoMenu){
                case 1:
                    String textoDepositar = """
                        ================ DEPÓSITO ================
                        Você escolheu a opção de depósito.
                        Informe o valor que deseja depositar:
                        
                        R$""";
                    System.out.println(textoDepositar);
                    valorDeposito = lerEntradas.nextDouble();
                    while (valorDeposito <= 0){
                        System.out.println("Valor de depósito inválido, o mínimo é R$ 1");
                        valorDeposito = lerEntradas.nextDouble();
                    }
                    System.out.println(String.format("Você vai depositar R$ %.2f. Confirmar depósito? (S/N)", valorDeposito));
                    confirmar = lerEntradas.next().charAt(0);
                    while (confirmar != 'S' && confirmar != 'N' && confirmar != 's' && confirmar != 'n'){
                        System.out.println("Você digitou errado, tente novamente: ");
                        confirmar = lerEntradas.next().charAt(0);
                    }
                    if (confirmar == 'S'  || confirmar == 's') {
                        System.out.println(String.format("Você depositou R$ %.2f na sua conta com êxito", valorDeposito));
                        saldo += valorDeposito;

                        LocalDateTime agora = LocalDateTime.now();
                        String horario = agora.format(tempoFormatado);

                        historico[posicao] = String.format("Depósito de R$ %.2f - Horario: %s", valorDeposito, horario);
                        posicao++;
                    }
                    break;

                case 2:
                    String textoSaque = "";

                    if (saldo == 0){
                        textoSaque = "Seu saldo atual é R$ 0. Faça um depósito para liberar a opção de saque.";
                        System.out.println(textoSaque);
                    } else {
                        textoSaque = """
                        ================ SAQUE ================
                        Você escolheu a opção de saque.
                        Informe o valor que deseja sacar:
                        R$""";
                        System.out.println(textoSaque);
                        valorSaque = lerEntradas.nextDouble();
                        while (valorSaque <= 0 || valorSaque > saldo){
                            System.out.println(String.format("Valor inválido, o limite de saque é de R$ %.2f. Digite novamente o valor do saque: ", saldo));
                            valorSaque = lerEntradas.nextDouble();
                        }
                        System.out.println(String.format("Você vai sacar R$ %.2f. Confirmar saque? (S/N)", valorSaque));
                        confirmar = lerEntradas.next().charAt(0);
                        while (confirmar != 'S' && confirmar != 'N' && confirmar != 's' && confirmar != 'n'){
                            System.out.println("Você digitou errado, tente novamente: ");
                            confirmar = lerEntradas.next().charAt(0);
                        }
                        if (confirmar == 'S'  || confirmar == 's') {
                            System.out.println(String.format("Você sacou R$ %.2f na sua conta com êxito", valorSaque));
                            saldo = saldo - valorSaque;

                            LocalDateTime agora = LocalDateTime.now();
                            String horario = agora.format(tempoFormatado);

                            historico[posicao] = String.format("Saque de R$ %.2f - Horario: %s ", valorSaque, horario);
                            posicao++;
                        }
                    }
                    break;

                case 3:
                    String textoSaldo = """
                        ================ SALDO ================
                        Você escolheu a opção de ver o saldo.
                        Seu saldo atual é: R$ %.2f
                        """.formatted(saldo);
                    System.out.println(textoSaldo);
                    break;

                case 4:
                    String textoHistorico = """
                        ================ HISTÓRICO ================
                        Você escolheu a opção de ver o histórico completo.
                        A operação será salva automaticamente quando você realizar um depósito ou saque.
                        """;
                    if (posicao == 0){
                        System.out.println("Nenhuma operação registrada.");
                    } else {
                        System.out.println(textoHistorico);
                        for (int i = 0; i < posicao; i++) {
                            System.out.println(historico[i]);
                        }
                        System.out.println(String.format("Saldo atual: R$ %.2f", saldo));
                    }
                    break;
            }

            System.out.println(menu);
            opcaoMenu = lerEntradas.nextInt();
            lerEntradas.nextLine();

            while (opcaoMenu < 0 || opcaoMenu > 4){
                System.out.println("Opcao inválida, tente novamente");
                opcaoMenu = lerEntradas.nextInt();
                lerEntradas.nextLine();
            }

        }
        System.out.println("Programa Encerrado!");
        lerEntradas.close();
    }
}

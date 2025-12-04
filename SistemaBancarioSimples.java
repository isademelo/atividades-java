/*
 Desafio: Sistema Bancário Simples

 Este programa simula um sistema bancário básico para um cliente fictício.
 Ele começa com os dados iniciais do cliente (nome, tipo de conta e saldo)
 e exibe um menu com quatro operações possíveis:

 1 - Consultar saldos: mostra o saldo atual da conta.
 2 - Receber valor: permite adicionar um valor ao saldo.
 3 - Transferir valor: permite retirar um valor do saldo,
     desde que haja saldo suficiente.
 4 - Sair: encerra o programa.

 O objetivo deste desafio é treinar:
  - Lógica de programação
  - Manipulação de variáveis
  - Estruturas de decisão (if/else)
  - Estruturas de repetição (loop para manter o menu funcionando)
  - Simulação de operações bancárias reais

*/

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBancarioSimples {

    static Scanner entrada = new Scanner(System.in);
    static String primeiroNomeDaMae = "daiany";
    static String nomeDoAnimalDeEstimacao = "boris";
    static String cidadeQueNasceu = "teresina";
    static boolean podeReceberETransferir = true;
    static int pin = 121314;
    static int senha = 123579;
    static String nome = "Isack de Melo";
    static double saldo = 2500;
    static ArrayList<String> historico = new ArrayList<String>();

    public static void main (String [] args){
        informacoesIniciais();
        menuPrincipal();
    }

    public static void informacoesIniciais (){
        System.out.println(String.format("""
                ***********************
                Dados iniciais do cliente:
                
                Nome: %s
                Tipo conta: Corrente
                Saldo inicial: R$ 2500,00
                ***********************""", nome));
    }

    public static void menuPrincipal(){
        String menuDeEscolha = ("""
                Operações

                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Ver histórico
                5- Informações do usuário
                6- Sair

                Digite a opção desejada:""");

        System.out.println(menuDeEscolha);
        byte opcaoMenu = entrada.nextByte();

        while (opcaoMenu > 6 || opcaoMenu < 1){
        System.out.println("Número Inválido, tente novamente: ");
            opcaoMenu = entrada.nextByte();
        }

        while (opcaoMenu != 6){
            switch (opcaoMenu){
                case 1:
                    consultarSaldo();
                break;

                case 2:
                    receberSaldo();
                break;

                case 3:
                    transferirValor();
                break;

                case 4:
                    verHistoricoDoAplicativo();
                break;

                case 5:
                    informacoesDoUsuario();
                break;
            }

            System.out.println(menuDeEscolha);
            opcaoMenu = entrada.nextByte();

            while (opcaoMenu > 6 || opcaoMenu < 1){
                System.out.println("Número Inválido, tente novamente: ");
                opcaoMenu = entrada.nextByte();
            }
        }
    }

    public static void consultarSaldo(){
        System.out.println(String.format("O seu saldo é de %.2f", saldo));
    }

    public static void receberSaldo(){
        if (podeReceberETransferir){
            String tipoDaOperacao = "Recebimento";

            System.out.println("Informe o valor que você vai receber: ");
            double valorRecebido = entrada.nextDouble();

            while (valorRecebido <= 0){
                System.out.println("Você inseriu um valor abaixo do valor de recebimento, que é de no mínimo de R$ 1. Tente novamente: ");
                valorRecebido = entrada.nextDouble();
            }

            saldo += valorRecebido;
            historico.add(String.format(" %s + R$ %.2f",tipoDaOperacao, valorRecebido));
        } else if (podeReceberETransferir == false){
            printarContaBloqueada();
        }

    }

    public static void transferirValor (){
    if (podeReceberETransferir){
        byte totalDeTentativas = 4;
        String tipoDaOperacao = "Transferência";
        System.out.println("Informe o valor que você vai ser transferido: ");
        double valorTransferido = entrada.nextDouble();
        while (valorTransferido < 1 || valorTransferido > saldo){
            if (valorTransferido > saldo){
                System.out.println(String.format("Você não pode transferir um valor maior que o seu saldo de R$ %s. Tente novamente: ", saldo));
                valorTransferido = entrada.nextDouble();
            } else if (valorTransferido < 1){
                System.out.println("Você inseriu um valor abaixo do valor de transferência, que é de no mínimo de R$ 1. Tente novamente: ");
                valorTransferido = entrada.nextDouble();
            }
        }
        System.out.println("Você tem Certeza que quer transferir esse valor? (S/N)");
        char confirmar = entrada.next().charAt(0);

        while (confirmar != 'S' && confirmar != 'N' && confirmar != 'n' && confirmar != 's'){
            System.out.println("Resposta inválida, tente novamente");
            confirmar = entrada.next().charAt(0);
        }

        if ((confirmar == 'S' || confirmar == 's') && podeReceberETransferir){
            System.out.println("Digite a sua senha do banco de 6 dígitos para efetuar a transferência: ");
            int senhaDigitada = entrada.nextInt();
            if (senhaDigitada == senha){
                saldo -= valorTransferido;
                historico.add(String.format(" %s - R$ %.2f", tipoDaOperacao, valorTransferido));
            } else {
                while (senhaDigitada != senha && podeReceberETransferir){
                    System.out.println(String.format("Senha incorreta, você tem mais %d tentativas. tente novamente: ", totalDeTentativas));
                    totalDeTentativas -= 1;
                    senhaDigitada = entrada.nextInt();
                }
                if (totalDeTentativas == 0){
                    podeReceberETransferir = false;
                    printarContaBloqueada();
                }

                if (senhaDigitada == senha && podeReceberETransferir) {
                    saldo -= valorTransferido;
                    historico.add(String.format(" %s - R$ %.2f", tipoDaOperacao, valorTransferido));
                }
            }

        } else if (confirmar == 'N' || confirmar == 'n'){
            System.out.println("Você negou, a transferência nao foi efetuada");
        }

    } else if (podeReceberETransferir == false){
        printarContaBloqueada();
    }
    }

    public static void verHistoricoDoAplicativo (){
        System.out.println("===== HISTÓRICO DE OPERAÇÕES =====");
        for(String movimentacao : historico){
            System.out.println(String.format(" • %s", movimentacao));
        }
        System.out.println("==================================");
        System.out.println(String.format("Saldo atual: %.2f", saldo));
    }

    public static void informacoesDoUsuario(){
        char confirmar = ' ';
        System.out.println("""
           
            ================================================
                       INFORMAÇÕES DO USUÁRIO
            -----------------------------------------------
            Selecione o que deseja acessar:
            
            1 - Alterar informações da conta
            2 - Alterar senha
            3 - Recuperar Conta
            4 - Acessar Informações da conta
            5 - Voltar ao menu principal
            
            Digite a opção desejada:
            """);
        byte opcaoAcessarInformacoesDoUsuario = entrada.nextByte();

        while (opcaoAcessarInformacoesDoUsuario < 1 || opcaoAcessarInformacoesDoUsuario > 5){
            System.out.println("Número Inválido, tente novamente: ");
            opcaoAcessarInformacoesDoUsuario = entrada.nextByte();
        }

        switch (opcaoAcessarInformacoesDoUsuario){
            case 1:
                System.out.println("""
                        ================ ALTERAR INFORMAÇÕES DA CONTA ================
                        1 - Alterar nome da conta
                        2 - Alterar nome da mãe
                        3 - Alterar nome do animal de estimação
                        4 - Voltar ao menu anterior
                        --------------------------------------------------------------
                        Digite a opção desejada:""");
                byte opcaoAlterarConta = entrada.nextByte();
                entrada.nextLine();
                while ((opcaoAlterarConta < 1  || opcaoAlterarConta > 4) && opcaoAlterarConta != 4){
                    System.out.println("Resposta inválida, tente novamente, ou digite 5 para voltar ao menu principal.");
                    opcaoAlterarConta = entrada.nextByte();
                }

                switch (opcaoAlterarConta){
                    case 1:
                        alterarNomeDaConta();
                        break;

                    case 2:
                        alterarNomeDaMae();
                        break;

                    case 3:
                        alterarNomeDoAnimal();
                        break;
                }
              break;
            case 2:
                System.out.println("""
                    🔐 ALTERAÇÃO DE SENHA
                    -----------------------------------------
                    1) Digite a nova senha: """);

                int novaSenha = entrada.nextInt();
                String tamanho = String.valueOf(novaSenha);

                while (tamanho.length() != 6){
                System.out.println("A sua nova senha não atende aos requisitos, ela deve ter 6 dígitos. Tente novamente: ");
                    novaSenha = entrada.nextInt();
                    tamanho = String.valueOf(novaSenha);
                }

                System.out.println("2) Confirme a nova senha: ");
                int confirmarSenha = entrada.nextInt();
                String tamanhoDaConfirmacaoDaNovaSenha = String.valueOf(confirmarSenha);

                while (tamanhoDaConfirmacaoDaNovaSenha.length() != 6){
                    System.out.println("A sua confirmação de senha não atende aos requisitos, ela deve ter 6 dígitos. Tente novamente: ");
                    confirmarSenha = entrada.nextInt();
                    tamanhoDaConfirmacaoDaNovaSenha = String.valueOf(confirmarSenha);
                }

                while ((confirmarSenha != novaSenha) && confirmarSenha != 4){
                    System.out.println("As senhas nao coincidem, tente novamente ou aperte 4 pra sair: ");
                    confirmarSenha = entrada.nextInt();
                }

                if (confirmarSenha == novaSenha){
                    System.out.println("Você tem certeza que quer confirmar essa alteração? (S/N)");
                    confirmar = entrada.next().charAt(0);
                    while (confirmar != 'S' && confirmar != 'N' && confirmar != 'n' && confirmar != 's'){
                        System.out.println("Resposta inválida, tente novamente");
                        confirmar = entrada.next().charAt(0);
                    }
                    senha = novaSenha;
                    System.out.println("Senha alterada com sucesso!");
                }
                break;

            case 3:

                System.out.println("""
                    ================================================
                                   RECUPERAÇÃO DE CONTA
                    -----------------------------------------------
                    Escolha uma opção de recuperação:
                    
                    1 - Recuperar conta por PIN
                    2 - Recuperar senha por pergunta de segurança
                    3 - Sair
                    
                    Digite a opção desejada: """);

                byte opcaoRecuperarConta = entrada.nextByte();
                    while (opcaoRecuperarConta < 1 || opcaoRecuperarConta > 3){
                        System.out.println("Opção inválida, tente novamente: ");
                        opcaoRecuperarConta = entrada.nextByte();
                    }

                switch (opcaoRecuperarConta){
                    case 1:
                       recuperarContaPorPIN();
                    break;

                    case 2:
                        recuperarContaPorPerguntaDeSeguranca();
                    break;
                }
                break;

            case 4:
                    acessarInformacoesDoUsuario();
                break;
        }
    }

    public static void printarContaBloqueada (){
            System.out.println("Sua conta foi bloqueada! Você excedeu o número máximo de tentativas para acertar sua senha. Acesse a opção 'Informações do usuário', no menu principal e comprove seus dados para você ser liberado para realizar transferências e receber pagamentos");
    }

    public static void recuperarContaPorPIN (){
        byte totalTentativasPIN = 4;
        char confirmarAlteracaoPIN = ' ';
        System.out.println("""
                                ==================== RECUPERAÇÃO DE CONTA ====================
                                                  ACESSO POR PIN DE SEGURANÇA
                                --------------------------------------------------------------
                                Digite seu PIN para recuperar o acesso: """);
        int pinInserido = entrada.nextInt();
        String tamanhoDoPin =  String.valueOf(pinInserido);
        System.out.println(tamanhoDoPin.length());

        if (pinInserido == pin){
            podeReceberETransferir = true;
        } else {
            while (tamanhoDoPin.length() != 6 && pinInserido != 3){
                System.out.println("O PIN que você inseriu não atende aos requisitos, ele deve ter 6 dígitos. Tente novamente. Caso queira sair, digite 3.");
                pinInserido = entrada.nextInt();
                tamanhoDoPin = String.valueOf(pinInserido);
            }

            while (pinInserido != pin && tamanhoDoPin.length() == 6 && pinInserido != 3 && totalTentativasPIN > 0){
                System.out.println("PIN incorreto, tente novamente. Caso queira sair, digite 3. ");
                pinInserido = entrada.nextInt();
                tamanhoDoPin =  String.valueOf(pinInserido);

                totalTentativasPIN -= 1;

                if (totalTentativasPIN == 0){
                    System.out.println("Você quer redefinir seu PIN? (S/N)");
                    confirmarAlteracaoPIN = entrada.next().charAt(0);

                    while (confirmarAlteracaoPIN != 'S' && confirmarAlteracaoPIN!= 'N' && confirmarAlteracaoPIN != 'n' && confirmarAlteracaoPIN != 's'){
                        System.out.println("Resposta inválida, tente novamente");
                        confirmarAlteracaoPIN = entrada.next().charAt(0);
                    }

                    if (confirmarAlteracaoPIN == 'S' || confirmarAlteracaoPIN == 's'){
                        System.out.println("Digite seu novo PIN, ele deve conter 6 dígitos: ");
                        int novoPIN = entrada.nextInt();
                        String tamanhoNovoPIN = String.valueOf(novoPIN);

                        while (tamanhoNovoPIN.length() != 6){
                            System.out.println("PIN inválido, ele deve conter 6 dígitos: ");
                            novoPIN = entrada.nextInt();
                            tamanhoNovoPIN = String.valueOf(novoPIN);
                        }
                        pin = novoPIN;
                        System.out.println("Seu PIN foi alterado com sucesso! Digite o novo PIN que você acabou de escolher: ");
                        pinInserido = entrada.nextInt();
                        tamanhoDoPin = String.valueOf(pinInserido);
                        if (pinInserido == pin) {
                            podeReceberETransferir = true;
                            System.out.println("PIN correto! Sua conta foi liberada para transferências e recebimentos.");
                        }
                    } else {
                        System.out.println("Você nao confirmou a alteração do PIN.");
                    }
                }
            }
        }
    }

    public static void recuperarContaPorPerguntaDeSeguranca (){
        byte acertos = 0;
        System.out.println("""
        ================== RECUPERAÇÃO DE CONTA ==================
                     MÉTODO: PERGUNTAS DE SEGURANÇA
        -----------------------------------------------------------
        Para recuperar sua conta, responda às perguntas abaixo.
        Você precisa acertar pelo menos 2 de 3.
        -----------------------------------------------------------
        1ª PERGUNTA:
        Qual é o nome do seu primeiro animal de estimação?
        """);
        String nomeDoAnimalDeEstimacaoInserido = entrada.next();

        if (nomeDoAnimalDeEstimacaoInserido.equalsIgnoreCase(nomeDoAnimalDeEstimacao)){
            acertos++;
        }

        while (nomeDoAnimalDeEstimacaoInserido.isBlank() || nomeDoAnimalDeEstimacaoInserido.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            nomeDoAnimalDeEstimacaoInserido = entrada.next();
        }

        System.out.println("""
        -----------------------------------------------------------
        2ª PERGUNTA:
        Em que cidade você nasceu? """);
        String cidadeQueNasceuInserida = entrada.next();

        while (cidadeQueNasceuInserida.isBlank() || cidadeQueNasceuInserida.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            cidadeQueNasceuInserida = entrada.next();
        }

        if (cidadeQueNasceuInserida.equalsIgnoreCase(cidadeQueNasceu)){
            acertos++;
        }

        System.out.println("""
        -----------------------------------------------------------
        3ª PERGUNTA:
        Qual é o primeiro nome da sua mãe?
        """);
        String primeiroNomeDoMaeInserida = entrada.next();

        while (primeiroNomeDoMaeInserida.isBlank() || primeiroNomeDoMaeInserida.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            primeiroNomeDoMaeInserida = entrada.next();
        }

        if (primeiroNomeDoMaeInserida.equalsIgnoreCase(primeiroNomeDaMae)){
            acertos++;
        }

        if (acertos >= 2){
            System.out.println("""
            -----------------------------------------------------------
            Perfeito! Você confirmou sua identidade.
            Sua conta foi recuperada com sucesso!
            -----------------------------------------------------------
            """);
            podeReceberETransferir = true;
        } else{
            System.out.println("""
            -----------------------------------------------------------
            Identidade NÃO confirmada.
            Você não acertou respostas suficientes para recuperar a conta.
            -----------------------------------------------------------
            """);
        }
    }

    public static void alterarNomeDaConta (){
        System.out.println("""
        ================= ALTERAR NOME DA CONTA =================
        Digite abaixo o novo nome que deseja para a sua conta:
        ---------------------------------------------------------""");

        String novoNomeDaConta = entrada.nextLine();
        while (novoNomeDaConta.isBlank() || novoNomeDaConta.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            novoNomeDaConta = entrada.nextLine();
        }

        System.out.println("Você tem certeza que quer confirmar essa alteração? (S/N)");
        char confirmarAlteracaoDoNomeDaConta = entrada.next().charAt(0);

        while (confirmarAlteracaoDoNomeDaConta != 'S' && confirmarAlteracaoDoNomeDaConta != 'N' && confirmarAlteracaoDoNomeDaConta != 'n' && confirmarAlteracaoDoNomeDaConta != 's'){
            System.out.println("Resposta inválida, tente novamente");
            confirmarAlteracaoDoNomeDaConta = entrada.next().charAt(0);
        }

        if (confirmarAlteracaoDoNomeDaConta == 'S' ||  confirmarAlteracaoDoNomeDaConta == 's'){
            System.out.println("Digite sua senha de 6 dígitos para realizarmos a alteração, ou digite 5 para voltar ao menu anterior:");
            int inserirSenhaDaConta =  entrada.nextInt();
            String tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);

            while (tamanhoDaSenhaInserida.length() != 6){
                System.out.println("A senha que você inseriu não atende aos requisitos, ela deve ter 6 dígitos. Tente novamente: ");
                inserirSenhaDaConta = entrada.nextInt();
                tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);
            }

            while ((inserirSenhaDaConta != senha) && inserirSenhaDaConta != 4){
                System.out.println("Senha incorreta, tente novamente ou aperte 4 pra sair: ");
                inserirSenhaDaConta = entrada.nextInt();
            }

            if (inserirSenhaDaConta == senha){
                System.out.println("O nome da conta foi alterado com sucesso!");
                nome = novoNomeDaConta;
            }
        } else {
            System.out.println("A alteração não foi feita, por que você nao confirmou a alteração");
        }

    }

    public static void alterarNomeDaMae(){
        System.out.println("""
        ================= ALTERAR PRIMEIRO NOME DA MÃE =================
        Digite abaixo qual nome vai ser o primeiro nome da sua mãe:
        ---------------------------------------------------------""");
        String novoPrimeiroNomeDaMae = entrada.next();

        while (novoPrimeiroNomeDaMae.isBlank() || novoPrimeiroNomeDaMae.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            novoPrimeiroNomeDaMae = entrada.next();
        }

        System.out.println("Você tem certeza que quer confirmar essa alteração? (S/N)");
        char confirmarAlteracaoDoPrimeiroNomeDaMae = entrada.next().charAt(0);

        while (confirmarAlteracaoDoPrimeiroNomeDaMae != 'S' && confirmarAlteracaoDoPrimeiroNomeDaMae != 'N' && confirmarAlteracaoDoPrimeiroNomeDaMae != 'n' && confirmarAlteracaoDoPrimeiroNomeDaMae != 's'){
            System.out.println("Resposta inválida, tente novamente");
            confirmarAlteracaoDoPrimeiroNomeDaMae = entrada.next().charAt(0);
        }

        if (confirmarAlteracaoDoPrimeiroNomeDaMae == 'S' ||  confirmarAlteracaoDoPrimeiroNomeDaMae == 's'){
            System.out.println("Digite sua senha de 6 dígitos para realizarmos a alteração, ou digite 5 para voltar ao menu anterior:");
            int inserirSenhaDaConta =  entrada.nextInt();
            String tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);

            while (tamanhoDaSenhaInserida.length() != 6){
                System.out.println("A senha que você inseriu não atende aos requisitos, ela deve ter 6 dígitos. Tente novamente: ");
                inserirSenhaDaConta = entrada.nextInt();
                tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);
            }

            while ((inserirSenhaDaConta != senha) && inserirSenhaDaConta != 4){
                System.out.println("Senha incorreta, tente novamente ou aperte 4 pra sair: ");
                inserirSenhaDaConta = entrada.nextInt();
            }

            if (inserirSenhaDaConta == senha){
                System.out.println("O primeiro nome da mãe foi alterado com sucesso!");
                primeiroNomeDaMae = novoPrimeiroNomeDaMae;
            }
        } else {
            System.out.println("A alteração não foi feita, por que você nao confirmou a alteração.");
        }
    }

    public static void alterarNomeDoAnimal(){
        System.out.println("""
        ============= ALTERAR NOME DO ANIMAL DE ESTIMAÇÃO ============
        Digite abaixo qual nome vai o nome do seu animal de estimação:
        --------------------------------------------------------------""");
        String novoNomeDoAnimalDeEstimacao = entrada.next();

        while (novoNomeDoAnimalDeEstimacao.isBlank() || novoNomeDoAnimalDeEstimacao.isEmpty()){
            System.out.println("Resposta inválida, tente novamente: ");
            novoNomeDoAnimalDeEstimacao = entrada.next();
        }

        System.out.println("Você tem certeza que quer confirmar essa alteração? (S/N)");
        char confirmarAlteracaoDoNomeDoAnimalDeEstimacao = entrada.next().charAt(0);

        while (confirmarAlteracaoDoNomeDoAnimalDeEstimacao != 'S' && confirmarAlteracaoDoNomeDoAnimalDeEstimacao != 'N' && confirmarAlteracaoDoNomeDoAnimalDeEstimacao != 'n' && confirmarAlteracaoDoNomeDoAnimalDeEstimacao != 's'){
            System.out.println("Resposta inválida, tente novamente");
            confirmarAlteracaoDoNomeDoAnimalDeEstimacao = entrada.next().charAt(0);
        }

        if (confirmarAlteracaoDoNomeDoAnimalDeEstimacao == 'S' ||  confirmarAlteracaoDoNomeDoAnimalDeEstimacao == 's'){
            System.out.println("Digite sua senha de 6 dígitos para realizarmos a alteração, ou digite 5 para voltar ao menu anterior:");
            int inserirSenhaDaConta =  entrada.nextInt();
            String tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);

            while (tamanhoDaSenhaInserida.length() != 6){
                System.out.println("A senha que você inseriu não atende aos requisitos, ela deve ter 6 dígitos. Tente novamente: ");
                inserirSenhaDaConta = entrada.nextInt();
                tamanhoDaSenhaInserida = String.valueOf(inserirSenhaDaConta);
            }

            while ((inserirSenhaDaConta != senha) && inserirSenhaDaConta != 4){
                System.out.println("Senha incorreta, tente novamente ou aperte 4 pra sair: ");
                inserirSenhaDaConta = entrada.nextInt();
            }

            if (inserirSenhaDaConta == senha){
                System.out.println("O nome do seu animal de estimação foi alterado com sucesso!");
                nomeDoAnimalDeEstimacao = novoNomeDoAnimalDeEstimacao;
            }
        } else {
            System.out.println("A alteração não foi feita, por que você nao confirmou a alteração.");
        }
    }

    public static void acessarInformacoesDoUsuario(){
        System.out.println("""
        ================= VISUALIZAR INFORMAÇÕES =================
        Para acessar os dados da conta, confirme sua identidade.
        -----------------------------------------------------------
        Digite sua senha de 6 dígitos para continuar:
        (Ou digite 4 para voltar ao menu anterior) """);
        int inserirSenhaDaConta = entrada.nextInt();

        while ((inserirSenhaDaConta != senha) && inserirSenhaDaConta != 4){
            System.out.println("Senha incorreta, tente novamente ou aperte 4 pra sair: ");
            inserirSenhaDaConta = entrada.nextInt();
        }

        if (inserirSenhaDaConta == senha){
                System.out.println("""
            ------------------ INFORMAÇÕES DA CONTA ------------------
            Nome da conta: %s
            Nome da mãe: %s
            Nome do animal de estimação: %s
            Cidade onde nasceu: %s
            Saldo: R$ %.2f
            -----------------------------------------------------------
            """.formatted(nome, primeiroNomeDaMae, nomeDoAnimalDeEstimacao, cidadeQueNasceu, saldo));
        }
    }
}

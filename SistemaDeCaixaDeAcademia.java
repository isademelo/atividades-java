//Sistema de Caixa de Academia (Plano + Desconto + Bônus)

//Contexto: Uma academia quer um sistema simples em Java para calcular o valor da mensalidade de um aluno.
//Planos:
//1 → Mensal: R$ 120,00
//2 → Trimestral: R$ 330,00
//3 → Semestral: R$ 600,00

//Descontos:
//Se o aluno for estudante (boolean ehEstudante = true/false), ganha 15% de desconto.
//Se o plano for trimestral ou semestral, ganha mais 5% de desconto acumulado.

//Bônus:
//Se o valor final (após os descontos) for acima de R$ 500, imprimir: "Ganhe 1 avaliação física gratuita!".

//O que o programa deve fazer:
//Ter uma variável planoEscolhido.
//Uma variável ehEstudante.
//Calcular o valor final com os descontos.

//Imprimir um resumo com:
//tipo de plano,
//se é estudante ou não,
//valor cheio,
//valor com desconto,
//se ganhou avaliação grátis ou não.

import java.util.Scanner;

public class SistemaDeCaixaDeAcademia {
    public static void main (String [] args){
        Scanner entrada = new Scanner(System.in);
        String jaEhAluno;
        String nomeAluno;
        String ehEstudante;
        String fazerInscricao;
        String temDireito = "";
        String plano = "";
        String cpf;
        int tipoDoPlano = 0;
        int idade;
        double precoPlanoEscolhido = 0 ;
        double precoComDesconto = 0;

        String opcoesDePlanos = """
                        PLANOS:
                        1 → Mensal: R$ 120,00
                        2 → Trimestral: R$ 330,00
                        3 → Semestral: R$ 600,00 
                        """;


        System.out.println("Sistema de gerenciamento de alunos SMART FIT");
        System.out.println("Digite o nome do aluno: ");
        nomeAluno = entrada.nextLine().trim();

        System.out.println("Você ja é aluno da SMART FIT?");
        jaEhAluno = entrada.nextLine().trim();

        System.out.println("Qual a sua idade: ");
        idade = entrada.nextInt();

        System.out.println("Digite o CPF do aluno: ");
        entrada.nextLine();
        cpf = entrada.nextLine();
        cpf = cpf.replace(".", "").replace("-", "");

        while (cpf.length() != 11){
            System.out.println("CPF inválido, digite novamente: ");
            cpf = entrada.nextLine();
            cpf = cpf.replace(".", "").replace("-", "");
        }

        if (jaEhAluno.toLowerCase().equals("sim")){
            System.out.println("Digite qual o plano que você está inscrito: ");
            System.out.println(opcoesDePlanos);
            tipoDoPlano = entrada.nextInt();

            while (tipoDoPlano < 1 || tipoDoPlano > 3){
                System.out.println("Opção inválida! Digite novamente o plano: ");
                tipoDoPlano = entrada.nextInt();
            }
        } else {
            System.out.println("Você quer fazer a incrição na nossa academia?");
            entrada.nextLine();
            fazerInscricao = entrada.nextLine().trim();
            if (fazerInscricao.toLowerCase().equals("sim")){
                System.out.println(opcoesDePlanos);
                tipoDoPlano = entrada.nextInt();
                while (tipoDoPlano < 1 || tipoDoPlano > 3){
                    System.out.println("Opção inválida! Digite novamente qual plano você quer se inscrever: ");
                    tipoDoPlano = entrada.nextInt();
                }
            }
        }
        if (tipoDoPlano == 1){
            System.out.println("Você escolheu o plano Mensal de R$ 120,00.");
            precoPlanoEscolhido = 120.0;
            precoComDesconto = precoPlanoEscolhido;
            plano = "Plano Mensal";

        } else if (tipoDoPlano == 2){
            System.out.println("Você escolheu o plano Trimestral de R$ 330,00.");
            precoPlanoEscolhido = 330.0 ;
            precoComDesconto = precoPlanoEscolhido - (precoPlanoEscolhido * 0.05);
            plano = "Plano Trimestral";

        } else if (tipoDoPlano == 3){
            System.out.println("Você escolheu o plano Semestral de R$ 600,00");
            precoPlanoEscolhido = 600.0;
            precoComDesconto = precoPlanoEscolhido - (precoPlanoEscolhido * 0.05);
            plano = "Plano Semestral";
        }

        System.out.println("Você é estudante?");
        entrada.nextLine();
        ehEstudante = entrada.nextLine().trim();

        if (ehEstudante.toLowerCase().equals("sim")){
            if (tipoDoPlano == 2 || tipoDoPlano == 3){
                precoComDesconto = precoPlanoEscolhido - (precoPlanoEscolhido * 0.20);
            } else {
                precoComDesconto = precoPlanoEscolhido - (precoPlanoEscolhido * 0.15);
            }

        }

        if (precoComDesconto > 500.0){
            temDireito = "Sim";
        } else {
            temDireito = "Não";
        }

        String resumoFinalDoAluno = """
                Resumo final do aluno:
                
                Nome: %s
                Idade: %d
                CPF: %s
                Ja era aluno da academia: %s
                É estudante: %s
                Plano: %s
                Valor integral: %.2f
                Valor com descontos: %.2f
                Tem direito a avaliação gratuita: %s
                """.formatted(nomeAluno, idade, cpf, jaEhAluno, ehEstudante, plano, precoPlanoEscolhido, precoComDesconto, temDireito);
        System.out.println(resumoFinalDoAluno);
    }
}

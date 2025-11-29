//6) DESAFIO – Manipulação de Strings (Fundamentos de String)
//Fundamentos: String, length(), charAt, toUpperCase, toLowerCase, comparação, laços.
//Descrição:
//Criar um “analisador de texto”.
//Regras:
//Ler uma frase completa do usuário (com espaços).
//Exibir:
//Quantos caracteres tem.
//Quantas letras “a” (ou “A”) aparecem.
//A frase toda em maiúsculo.
//A frase toda em minúsculo.
//A frase ao contrário (ex: “java” → “avaj”).
//Perguntar ao usuário uma palavra para buscar na frase:
//Se existir, avisar: “A palavra X foi encontrada!”
//Se não, avisar que não foi encontrada.
//Desafio extra:
//Contar quantas palavras tem na frase.

import java.util.Scanner;
public class DesafioStrings {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String achou = "";
        String buscar = "";
        String frase = "";
        String invertida = "";
        boolean encontrado = false;
        int qtdLetraEscolhida = 0;
        char letraEscolhidaParaAnalisar = ' ';

        System.out.println("Digite alguma frase ou a palavra que você deseja analisar: ");
        frase = input.nextLine();
        System.out.println("Digite uma letra, em seguida iremos dizer a quantidade que essa palavra ou frase tem dela: ");
        letraEscolhidaParaAnalisar = input.next().charAt(0);
        input.nextLine();
        System.out.println(String.format("Você escolheu a letra: %s", letraEscolhidaParaAnalisar));

        char letra = Character.toLowerCase(letraEscolhidaParaAnalisar);
        for (int i = 0; i < frase.length(); i++) {
            if (Character.toLowerCase(frase.charAt(i)) == letra) {
                qtdLetraEscolhida++;
            }
        }

        String semEspacos = frase.replace(" ","");
        int tamanhoDaFrase = 0;

        tamanhoDaFrase = frase.length();
            for (int i = tamanhoDaFrase - 1; i >= 0; i--) {
                invertida += frase.charAt(i);
            }

        String[] palavras = frase.split(" ");
        System.out.println("Agora digite uma palava que você quer procurar na String que você digitou: ");
        buscar = input.nextLine();

        for (int i = 0; i < palavras.length; i++ ){
           if (palavras[i].contains(buscar)){
                encontrado = true;
               break;
           }
        }

        if (encontrado == true){
            achou = (String.format("Palavra '%s' encontrada na String! :D", buscar));
        } else {
            achou = (String.format("A palavra '%s' nao foi encontrada na String:/", buscar));
        }


        String resultado = """
                
                O que você digitou: %s
                Você escolheu a letra: %s
                O tamanho total da String:  %d
                O quantidade de caracteres da String sem contar o espaço: %d
                A String que você escolheu contem: %d letras %s
                A String em maiúsculo: %s
                A String em minúsculo: %s
                A string de tras pra frente:  %s
                %s
                A quantidade de palavras que tem na String: %d
                """.formatted(frase, letraEscolhidaParaAnalisar, frase.length(), semEspacos.length(), qtdLetraEscolhida, letraEscolhidaParaAnalisar, frase.toUpperCase(), frase.toLowerCase(), invertida, achou, palavras.length);
        System.out.println(resultado);

    }
}


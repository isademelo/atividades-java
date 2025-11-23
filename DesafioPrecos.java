public class DesafioPrecos {
    public static void main(String [] args){

//Declare uma variável do tipo double precoProduto e uma variável do tipo int (quantidade).
// Calcule o valor total multiplicando o preço do produto pela quantidade e apresente o resultado em uma mensagem.
        double precoProduto = 19.90;
        int quantidade = 3;
        double total = precoProduto * quantidade;
        System.out.println(String.format("O total da compra deu: R$ %.2f", total));

//Declare uma variável do tipo double valorEmDolares.
// Atribua um valor em dólares a essa variável.
// Considere que o valor de 1 dólar é equivalente a 4.94 reais.
// Realize a conversão do valor em dólares para reais e imprima o resultado formatado.
        double precoEmDolares = 95.8;
        double valorDolarEmReais = 4.94;
        double convercao =  precoEmDolares * valorDolarEmReais;
        System.out.println(String.format("O valor da conversão é de: R$ %.2f", convercao));

//Declare uma variável do tipo double precoOriginal.
// Atribua um valor em reais a essa variável, representando o preço original de um produto.
// Em seguida, declare uma variável do tipo double percentualDesconto e atribua um valor percentual de desconto ao produto (por exemplo, 10 para 10%).
// Calcule o valor do desconto em reais, aplique-o ao preço original e imprima o novo preço com desconto.

        double precoOriginal = 957.50;
        // percentual de 30% de desconto
        double percentualDeDesconto = 0.3;
        double totalComDesconto = precoOriginal - (percentualDeDesconto * precoOriginal);
        System.out.println(String.format("O total com o desconto na compra é de: R$ %.2f", totalComDesconto));
    }
}



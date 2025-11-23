public class Conversor {
    public static void main (String[] args){
        //Agora é com você! Pratique os conceitos que foram ensinados ao longo dessa aula com o seguinte desafio:
        //Escreva um programa que converta uma temperatura em graus Celsius para Fahrenheit. Utilize variáveis para
        //representar os valores das temperaturas e imprima no console o valor convertido de Celsius para Fahrenheit.
        //Dica: A fórmula para converter temperaturas de graus Celsius para Fahrenheit é: (temperatura * 1.8) + 32.
        //Depois de finalizar, testar e conferir que seu programa foi executado com sucesso, crie uma variável inteira
        // para exibir a temperatura em Fahrenheit sem casas decimais. Lembre-se que provavelmente você precisará fazer
        // um casting de valores.

        double temperaturaCelsius = 42;
        double temperaturaFahrenheit = (temperaturaCelsius * 1.8) +32;
        System.out.println(String.format("Temperatura Fahrenheit: %.2f", temperaturaFahrenheit));
        int temperaturaFahrenheitEmInteiro = (int) temperaturaFahrenheit;
        System.out.println(String.format("A temperatura fahrenheit transformada para inteiro é: %d", temperaturaFahrenheitEmInteiro));
    }
}
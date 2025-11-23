public class DesafioExibirMediaDasNotas {
    public static void main (String [] args){

        int nota1 =  11;

        if (nota1 < 0) {
            nota1 = 0;
        } else if (nota1 > 10){
            nota1 = 10;
        }

        double nota2 = 7;

        if (nota2 < 0){
            nota2 = 0;
        } else if (nota2 > 10){
            nota2 = 10;
        }
        double conversao = (double) nota1;

        double media = (conversao + nota2)/2;

        if (media >= 7 && media <= 10){
            System.out.println(String.format("O aluno está aprovado com a média %.2f. PARABENS!!!!", media));
        } else if (media <= 6.9 && media >= 0){
            System.out.println(String.format("O aluno está reprovado com a média %.2f, tem que estudar mais", media));
        }
    }
}
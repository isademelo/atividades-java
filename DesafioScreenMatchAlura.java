public class DesafioScreenMatchAlura {
    public static void main(String[] args) {

        System.out.println("Esse é o Screen Match");
        String nomeDoFilme = "Top Gun Maverick";
        String disponivel;
        int anoDeLancamento = 2020;
        boolean incluidoNoPlano = true;
        String genero = "Ação e aventura";
        String cronologia = "";

        if (incluidoNoPlano) {
            disponivel = "Sim";
        } else {
            disponivel = "Não";
        }

        double notaDosCriticos = 11;

        if (notaDosCriticos > 10){
            notaDosCriticos = 10;
        } else if (notaDosCriticos < 0){
            notaDosCriticos = 0;
        }

        double notaDosInternautas = 10;

        if (notaDosInternautas > 10){
            notaDosInternautas = 10;
        } else if (notaDosInternautas < 0){
            notaDosInternautas = 0;
        }
        double media = (notaDosCriticos + notaDosInternautas)/2;

        if (anoDeLancamento >= 2020){
            cronologia = "Esse filme é um filme recente, ele é dessa década";
        } else if (anoDeLancamento <= 2019 && anoDeLancamento >= 2015){
            cronologia = "Esse filme é um pouco recente, ele é da década passada";
        } else if (anoDeLancamento < 2015 && anoDeLancamento >= 2000){
            cronologia = "Esse filme é antigo";
        } else if (anoDeLancamento < 2000){
            cronologia= "Esse filme é muito antigo";
        }

        int classificacaoEstrelas;
        classificacaoEstrelas = (int) media/2;

        System.out.println(String.format("Nome do filme: %s\nGênero: %s\nAno de lançamento: %d\nEstá disponível: %s\nNota dos críticos: %.2f\nNota dos internautas: %.2f\nNota média do filme: %.2f\nEstrelas: %d\nCronologia: %s", nomeDoFilme, genero
                , anoDeLancamento, disponivel, notaDosCriticos, notaDosInternautas, media, classificacaoEstrelas, cronologia));

        if (media >= 0 && media <= 2.5) {
            System.out.println("Segundo a média de nota desse filme, ele é considerado um filme PÉSSIMO!");
        } else if (media >=  2.6 && media <= 5){
            System.out.println("Segundo a média de nota desse filme, ele é considerado um filme RUIM!");
        } else if (media >= 5.1 && media <= 7.5){
            System.out.println("Segundo a média de nota desse filme, ele é considerado um Filme BOM!");
        } else if (media >= 7.6 && media <= 9.9){
            System.out.println("Segundo a média de nota desse filme, ele é considerado um filme EXELENTE!");
        } else if (media == 10){
            System.out.println("Segundo a média de nota desse filme, ele é considerado um filme PERFEITO!");
        } else {
            System.out.println("Nota inválida");
        }

        String mensagem = """
                
                Obrigado por utilizar este programa!
                Sua confiança é muito importante para nós.
                Esperamos que a experiência tenha sido útil e agradável.
                """;
        System.out.println(mensagem);
    }
}
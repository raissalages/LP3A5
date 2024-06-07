import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(3095631, "Raismenduim", 21, "ADS", 9);
        Aluno aluno2 = new Aluno(3095632, "Sulebs", 22, "ADS", 6);
        Aluno aluno3 = new Aluno(3095633, "Nunu", 20, "ADS", 7);
        Aluno aluno4 = new Aluno(3095634, "PixGoma", 17, "ADS", 4);
        Aluno aluno5 = new Aluno(3095635, "Bleble", 21, "ADS", 5);


        List<Aluno> db = new ArrayList<>();

        db.add(aluno1);
        db.add(aluno2);
        db.add(aluno3);
        db.add(aluno4);
        db.add(aluno5);

        List<String> nomes = db.stream().map(Aluno::getNome).collect(Collectors.toList());
        System.out.println("Nomes: " + nomes);

        List<Aluno> idades = db.stream().filter(x -> x.getIdade() < 18).collect(Collectors.toList());
        System.out.println("Menor que 18: " + idades);

        double mediaIra =  (double) db.stream().mapToLong(Aluno::getIra).sum() / db.stream().count();
        System.out.println("Media IRA geral: " + mediaIra);

        double mediaIdade = db.stream().filter(y -> y.getIra() < 6).mapToLong(Aluno::getIdade).average().orElse(Double.NaN);
        System.out.println("Media idade geral: " + mediaIdade);

    }
}
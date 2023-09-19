import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainLambda {

    // classe per testare stream e lambda
    public static void main(String[] args) {
        String[] parole = { "ciao", "Marco", "java", "PROGRAMMING", "AS Roma", "ASRoma", "computer", "course", "java" };
        List<String> paroleList = Arrays.asList(parole);

        // 1) contare il numero di elementi dell'array
        long count = paroleList.stream().count();
        // 2) contare gli elementi distinti dell'array
        long count_distinct = paroleList.stream().distinct().count();
        System.out.println("Il numero di elementi dell'array è: " + count);
        System.out.println("il numero di elementi distinti dell'array è: " + count_distinct);

        // 3) tornare un nuovo array dove al posto delle stringhe abbiamo la loro lunghezza
        List<Integer> paroleListCount = paroleList.stream().map(s -> s.length()).toList();
        System.out.println(paroleListCount);
        // 4) tornare un nuovo array dove al posto delle stringhe abbiamo la loro lunghezza, a patto che abbiano
        // lunghezza > 5
        List<Integer> paroleCountLongWords = paroleList.stream().map(s -> s.length()).filter(x -> x > 5).toList();
        System.out.println(paroleCountLongWords);

        // 5) tornare un nuovo array dove abbiamo solamente le prime 3 parole in ordine alfabetico
        List<String> firstThreeWords = paroleList.stream().map(s -> s.toLowerCase()).sorted().limit(3).toList();
        System.out.println(firstThreeWords);

        // 6) tornare le prime 3 parole più lunghe
        List<String> longestWords =
                paroleList.stream().sorted((s1,s2) -> Integer.compare(s2.length(), s1.length())).limit(3).toList();
        System.out.println(longestWords);

        // 7) voglio sapere se esista almeno una parola che inizi con la a (sia maiuscola che minuscola)
        boolean startA = paroleList.stream().map(String::toLowerCase).anyMatch(s -> s.startsWith("a"));
        System.out.println(startA);

        // 8) voglio sapere se tutte le stringhe siano lunghe meno di 10
        boolean menDiDieci = paroleList.stream().map(String::length).allMatch(x -> x < 10);
        System.out.println(menDiDieci);

        // 9) voglio sapere se nessuna stringa finisce con la o
        boolean nessunoFinisceConLaO = paroleList.stream().map(String::toLowerCase).noneMatch(s -> s.endsWith("o"));
        System.out.println(nessunoFinisceConLaO);
    }

}

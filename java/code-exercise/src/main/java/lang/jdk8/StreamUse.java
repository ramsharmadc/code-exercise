package lang.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamUse {

    public static void main(String[] args) {
        StreamUse s = new StreamUse();
        s.method();
    }

    public void method() {
        Map<String, List<String>> phonNumbrs = new HashMap<>();
        phonNumbrs.put("Ram", Arrays.asList("0973", "32123", "4334"));
        phonNumbrs.put("Rayon", Arrays.asList("0973", "32123", "4334"));
        phonNumbrs.put("Home", Arrays.asList("0973", "32123", "4334"));
        phonNumbrs.put("Sharma", Arrays.asList("0973", "32123", "4334"));

        Map<String, List<String>> filteredNumbers =
                phonNumbrs.
                        entrySet().
                        stream().
                        filter(x -> x.getKey().contains("R")).
                        collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        filteredNumbers.forEach((k, v) -> {
                    this.method();
                    System.out.print("Numbers of " + k + " :: {");
                    v.forEach(v1 -> System.out.print(v1 + " "));
                    System.out.println("}");
                }
        );

        System.out.println();

        List<Integer> intLIst = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
        intLIst.stream().sorted().forEach(x -> System.out.print(x + " "));
    }
}

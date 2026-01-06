import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> unique = new HashSet<>(N * 2);
        for (int i = 0; i < N; i++) {
            unique.add(br.readLine().trim());
        }

        int need; 
        switch (game) {
            case "Y": need = 1; break;
            case "F": need = 2; break;
            case "O": need = 3; break;
            default:  need = 1;
        }

        int result = unique.size() / need;
        System.out.println(result);
    }
}

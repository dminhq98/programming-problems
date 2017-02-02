import java.util.*;

public class Apaxiaaans {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String name = in.next();
        StringBuilder out = new StringBuilder();
        char lastChar = name.charAt(0);
		out.append(lastChar);
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            
            if (c == lastChar)
                continue;
            else {
                lastChar = c;
                out.append(c);
            }
        }
        
        System.out.println(out.toString());
    }
}

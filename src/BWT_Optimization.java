import java.util.ArrayList;
import java.util.Collections;

public class BWT_Optimization { /// обратное преобразование улучшенное
    public String decompress(String str) {
        ArrayList<BWT_object> perestanovki = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            perestanovki.add(new BWT_object(i, str.charAt(i)));
        }
        Collections.sort(perestanovki);
        StringBuilder strOutput = new StringBuilder();
        System.out.println(perestanovki);
        int n = perestanovki.get(0).num;
        while (n != 0) {

            strOutput.append(perestanovki.get(n).characterl);
            n = perestanovki.get(n).num;
        }
        System.out.println(strOutput);
        return strOutput.toString();
    }

}

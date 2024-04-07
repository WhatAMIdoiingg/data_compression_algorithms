import java.util.*;

public class Arifmetic_code {// double
    public static double Compressed(String input) {//(строка,  таблица с ероятностями символов)
        Map<Character, Double> probabilities = get_rate(input);
        double encodedValue = 0.0;
        double lowerBound = 0.0;
        double upperBound = 1.0;

        for (char c : input.toCharArray()) {
            double count_lowerBound = lowerBound;
            double currentP = probabilities.get(c);

            for (Map.Entry<Character, Double> entry : probabilities.entrySet()) {
                if (entry.getKey() == c) {
                    currentP = entry.getValue();
                    break;
                } else {
                    double t = entry.getValue();
                    count_lowerBound += entry.getValue() * (upperBound - lowerBound);
                }
            }
            upperBound = count_lowerBound + (upperBound - lowerBound) * currentP;
            lowerBound = count_lowerBound;
           //  System.out.println(Arrays.toString(new double[]{lowerBound, upperBound}) + " Symbol = " + c);
            encodedValue = lowerBound;//(lowerBound + upperBound) / 2;
        }
       // System.out.println("Result: " + encodedValue);
        return encodedValue;
    }
    public static void getAlphabet(String str, ArrayList<Character> a) { // для арифметического кодирования
        for (int i = 0; i < str.length(); i++) {
            if (!a.contains(str.charAt(i))) {
                a.add(str.charAt(i));
            }
            Collections.sort(a);
        }
    }

    public static HashMap<Character, Double> get_rate(String str) {
        double Punit = 1.0 / str.length();
        HashMap<Character, Double> charRate = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charRate.containsKey(c)) {
                charRate.put(c, charRate.get(c) + Punit);
            } else {
                charRate.put(c, Punit);
            }
        }
        return charRate;
    }

    public static String decodeStringSection(double encryptionResult, HashMap<Character, Double> probabilityHashMap) {

        List<Double> dList = new ArrayList<>(probabilityHashMap.size() + 1);
        List<Character> keysList = new ArrayList<>(probabilityHashMap.size() + 1);
        int index = 1;
        double ctr = 0.0;
        dList.add(0.0);
        for(Iterator<Map.Entry<Character, Double>> iterator = probabilityHashMap.entrySet().iterator(); iterator.hasNext(); index++) {
            Map.Entry<Character, Double> entry = iterator.next();
            keysList.add(entry.getKey());
            ctr += entry.getValue();
            dList.add(ctr);
        }
        keysList.add(0, keysList.get(1));
        StringBuilder decodeStringBuilder = new StringBuilder();
        double curStart = 0.0;
        double curEnd = 1.0;
        Character currentSymbol = ' ';
        while(currentSymbol != '\n') {
            for(int i = 0; i < dList.size() - 1; ++i) {
                if (dList.get(i) < encryptionResult && encryptionResult < dList.get(i + 1)) {
                    currentSymbol = keysList.get(i + 1);
                    decodeStringBuilder.append(currentSymbol);
                    curStart = dList.get(i);
                    curEnd = dList.get(i + 1);
                    break;
                }
            }

            double curCtr = curStart;
            dList.set(0, curStart);
            dList.set(dList.size() - 1, curEnd);
            int curIdx = 1;

            for(Iterator<Map.Entry<Character, Double>> iterator = probabilityHashMap.entrySet().iterator(); iterator.hasNext(); ++curIdx) {
                Map.Entry<Character, Double> entry = iterator.next();
                curCtr += entry.getValue() * (curEnd - curStart);
                dList.set(curIdx, curCtr);
            }
        }

        return decodeStringBuilder.toString();
    }


}

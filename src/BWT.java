import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BWT {

    public static String bwt(String s) {/// наивная реализация преобразования барроуза- уилл...
        s = s + "$";
        List<String> rotations = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            rotations.add(s);
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }
        Collections.sort(rotations);
        StringBuilder lastColumn = new StringBuilder();
        for (String rotation : rotations) {
            lastColumn.append(rotation.charAt(rotation.length() - 1));
        }
        int originalIndex = rotations.indexOf(s);// начальная строка
        return lastColumn.toString();

    }
    public static String bwt_blocks(String s, int blockSize) {
        BWTFast bwtFast = new BWTFast();
        StringBuilder output = new StringBuilder();
        int blockCount = s.length() / blockSize;
        for (int i = 0; i < blockCount; i++) {
            String block = s.substring(i * blockSize, ((i + 1) * blockSize)+1);
            output.append(bwtFast.getBWT(block));
            if(i == blockCount){

                block = s.substring(i * blockSize, s.length());
                output.append(bwt(block));
            }

        }
       return output.toString();
    }
    public static String bwt_decode(String s) {// наивная реализация декодера bwt
        // Создаем список из последнего столбца
        List<Character> lastColumnList = new ArrayList<>();//Создается пустой список , который будет хранить символы последнего столбца.
        for (char c : s.toCharArray()) {//Перебирает каждый символ в строке lastColumn и добавляет его в lastColumnList
            lastColumnList.add(c);
        }

        // Создается пустой список для хранения всех возможных строк
        List<String> table = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            table.add("");
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                table.set(j, lastColumnList.get(j) + table.get(j));//Для каждой строки в таблице добавляется соответствующий символ из lastColumnList в начало строки.
            }
            Collections.sort(table);// сортировка в лексиграфическом порядке
        }

        // Возвращаем исходную строку ??????
        int index = 0;
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).endsWith("$")) {
                index = i;
                break;
            }
        }

        return table.get(index);
    }
    public static void efficiency_of_bwt(String str) {
        int length_sum = 0;//длина всех последовательностей повторяющихся символов
        int length_tmp = 1;//длина текущей последовательности повторяющихся символов
        int num = 0;//количество последовательностей
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                length_tmp++;
            } else {
                length_sum += length_tmp == 1 ? 0 : length_tmp;
                num += length_tmp == 1 ? 0 : 1;
                length_tmp = 1;
            }
        }
        length_sum += length_tmp == 1 ? 0 : length_tmp;
        num += length_tmp == 1 ? 0 : 1;

        System.out.println("средняя длина последовательности повторяющихся символов " + (length_sum * 1.0 / num));

        System.out.println("эффективность " + (length_sum - 2 * num) * 1.0 / str.length());
    }


    public static void report_bwt_blocks(String s, int blockSize) {
        String bwtBlocks = bwt_blocks(s, blockSize);
        System.out.println("Преобразованный текст: " + bwtBlocks);
        efficiency_of_bwt(bwtBlocks);
    }
    public static ArrayList<Integer> getSufficsIndex(String str) {
        ArrayList<String> suff = getSuffics(str);
        ArrayList<Integer> suffIndex = new ArrayList<>();
        for (String s : suff) {
            suffIndex.add(str.indexOf(s));
        }
        return suffIndex;
    }

    public static ArrayList<String> getSuffics(String str) {
        ArrayList<String> suff = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            suff.add(str.substring(i));
        }
        Collections.sort(suff);
        return suff;
    }

    public static StringBuilder suffBWT(ArrayList<Integer> suff, String str) {
        StringBuilder strOut = new StringBuilder();
        for (Integer integer : suff) {
            int i = integer - 1;
            if (i < 0) {
                i = suff.size() - 1;
            }
            strOut.append(str.charAt(i));
        }
        return strOut;
    }
    public StringBuilder getSuffType(String str){
        StringBuilder strOut=new StringBuilder();

        strOut.append('s');
        for (int i =str.length()-1; i >0 ; i--) {
            if (str.charAt(i)>str.charAt(i-1)){
                strOut.append('s');
            }else if (str.charAt(i)<str.charAt(i-1)){
                strOut.append('l');
            }else {
                strOut.append(strOut.charAt(strOut.length()-1));
            }
        }
        return strOut.reverse();

    }

}

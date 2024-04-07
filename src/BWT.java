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
    public void efficiency_of_bwt(String str) {
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

}

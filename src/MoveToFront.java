

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class MoveToFront {

    public static String compress(String str) {
        // Создаем список для хранения алфавита
        ArrayList<Character> alphabet = new ArrayList<>();
        // Создаем список для хранения индексов символов в алфавите
        ArrayList<Integer> out = new ArrayList<>();
        // Получаем алфавит из строки
        alphabet = (ArrayList<Character>) createAlphabet(str);

        // Проходим по каждому символу в строке
        for (int i = 0; i < str.length(); i++) {
            int j = 0;
            // Ищем индекс символа в алфавите
            while (str.charAt(i) != alphabet.get(j)) {
                j++;
            }
            // Добавляем индекс в список out
            out.add(j);
            // Удаляем символ из алфавита и добавляем его в начало
            alphabet.remove(j);
            alphabet.add(0, str.charAt(i));
        }
        // Создаем StringBuilder для формирования результирующей строки
        StringBuilder result = new StringBuilder();
        // Добавляем размер алфавита в начало строки
        result.append((char) alphabet.size());
        // Сортируем алфавит
        Collections.sort(alphabet);
        // Добавляем символы алфавита в строку
        for (Character character : alphabet) {
            result.append(character);
        }
        // Добавляем индексы символов в строку

        for (int integer : out) {
            result.append((int) integer);

        }
        // Возвращаем сжатую строку
        return result.toString();
    }


    public static String moveToFront_decoder(String str) {
        ArrayList<Character> alphabet = new ArrayList<>();///попробовать +1
        alphabet = createAlphabet(str);

        int alpSize = alphabet.size();

        //System.out.println(alphabet);
        StringBuilder strOut = new StringBuilder();
        int s = str.length();

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i);//?????????????????????
            strOut.append(alphabet.get(n));
            alphabet.add(0, alphabet.get(n));
            alphabet.remove(n + 1);


        }
        return String.valueOf(strOut);
    }

    public static ArrayList<Character> createAlphabet(String input) {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!alphabet.contains(c)) {
                alphabet.add(c);
            }
        }
        Collections.sort(alphabet);
        return alphabet;

    }

}


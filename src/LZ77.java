public class LZ77 {

    public StringBuilder compress(String str) {
        int size = str.length();
        int dictionary = 20000;
        StringBuilder compressed = new StringBuilder(); //для хранения сжатой строки
        StringBuilder memory = new StringBuilder();//для временного хранения данных
        int coded_symb = 0;// количество закодированных символов .
        int type = 0;// типы: нет в словаре, есть в словаре
        for (int i = 0; i < size; i++) {//перебор символов
            int dictionaryStart = 0;
            int dictionaryLeng = 0;

            for (int j = Math.max(0, i - dictionary); j < i; j++) {// нахождение повтора
                if (str.charAt(j) == str.charAt(i)) {//
                    ///
                    int start = j;
                    int tmp = j + 1;//
                    int length = 1;
                    while ((i + length) < size && str.charAt(tmp) == str.charAt(i + length)) {//цикл для нахождения подстроки
                        tmp++;
                        length++;
                    }
                    if (dictionaryLeng < length) {//
                        dictionaryStart = i - start;//смещение: от начала строки до начала найденной подстроки
                        dictionaryLeng = length;//длина подстроки
                    }
                }
            }
            type = type << 1;
            if (dictionaryLeng > 0) {//если она больше предыдущей найденной, то обновляются
                memory.append((char) dictionaryStart);//запись
                memory.append((char) dictionaryLeng);
                type++;
                i += dictionaryLeng - 1;//перенос
            } else {// запись символа без повторений и не подстрок
                memory.append(str.charAt(i));
            }
            coded_symb++;

            if (coded_symb == 8) {
                compressed.append((char) type);//запись
                coded_symb = 0;
                type = 0;
                compressed.append(memory);// добавление в итогувую строку
                memory = new StringBuilder("");

            }
        }
        if (coded_symb != 0) {
            type = type << 8 - coded_symb;//обработкка случая строка не кратна 8, чтобы лишнее не вылезло
            compressed.append((char) type);//запишим типы кодов

            compressed.append(memory);

        }
        return compressed;
    }

    public StringBuilder deсompressLZ(StringBuilder str) {
        StringBuilder str_decomprecced = new StringBuilder(); // Результирующая строка
        int size = str.length(); // Длина входной строки
        boolean end_of_str = false; // Флаг окончания строки
        int j = 0; // Индекс для прохода по строке

        // Проход по строке до тех пор, пока не достигнут конец строки или не обработаны все символы
        while (!end_of_str && j < size) {
            int types = str.charAt(j); // Получение байта, определяющего типы следующих символов
            j++; // Переход к следующему символу

            // Проход по следующим 8 символам (1 байт)
            for (int i = 7; i >= 0 && !end_of_str; i--, j++) {
                if (j < size) {
                    // Проверка, является ли текущий бит обычным символом (0) или ссылкой (1)
                    if ((types & (int) Math.pow(2, i)) == 0) {
                        str_decomprecced.append(str.charAt(j)); // Добавление обычного символа в результат
                    } else {
                        int start = str.charAt(j); // Получение количества символов для повторения
                        j++; // Переход к следующему символу

                        int length = str.charAt(j); // Получение смещения от конца строки

                        // Добавление повторяющихся символов в результат
                        for (int k = 0; k < length; k++) {
                            str_decomprecced.append(str_decomprecced.charAt(str_decomprecced.length() - start));
                        }
                    }
                } else {
                    end_of_str = true; // Установка флага окончания строки
                }
            }
        }

        return str_decomprecced; // Возврат результирующей строки
    }
}



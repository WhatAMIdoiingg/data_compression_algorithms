import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RLE {

    public static String RLE_decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encoded.length(); i += 2) {
            char count = encoded.charAt(i);
            char character = encoded.charAt(i + 1);
            for (int j = 0; j < (int) count; j++) {
                decoded.append(character);
            }
        }
        return decoded.toString();
    }

    public static StringBuilder RLE_all(String str) {
        StringBuilder writer = new StringBuilder();
        int count = 1; // Количество повторений символа
        boolean less = false; // Флаг для обработки случая
        boolean flag = false;
        boolean flag2 = true;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1) && count < 255) {
                count++;
                if (less && flag) {
                    if (count >= 2 && flag2) {
                        writer.append(str.charAt(i));
                        flag2 = false;
                    }
                    count = 2;
                    flag = false;
                }
            } else {
                if (count < 3) {
                    if (less) {
                        writer.append(str.charAt(i));
                        flag = true;
                        flag2 = true;

                    } else {
                        writer.append((char) 0);
                        flag = true;
                        for (int j = 0; j < count; j++) {
                            writer.append(str.charAt(i));
                        }
                        less = true;
                    }
                } else {
                    if (less) {
                        less = false;
                        writer.append((char) 0);
                    }
                    writer.append((char) count);
                    writer.append(str.charAt(i));
                    count = 1;
                }
            }
            if (less && i == str.length() - 1) {
                less = false;
                writer.append((char) 0);
            }
        }

        return writer;
    }

    public static StringBuilder RLE_Coder(StringBuilder str) {
        StringBuilder out = new StringBuilder();
        StringBuilder alone = new StringBuilder();
        int count = 0;
        int i = 0;
        for (i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                if (!alone.isEmpty()) {
                    if (alone.length() > 2) {
                        out.append((char) 0);
                        out.append(alone);
                        out.append((char) 0);
                    } else {
                        for (int j = 0; j < alone.length(); j++) {
                           // out.append(1);
                            out.append((char)1);
                            out.append(alone.charAt(j));
                        }
                    }

                    alone = new StringBuilder();
                }
                if (count == 0) {
                    count++;
                }
                count++;
            } else {
                if (count > 0) {//запись сокращенного фрагмента
                    //out.append(count);
                     out.append((char) count);
                    count = 0;
                    out.append(str.charAt(i));
                } else {//обработка одиночного символа
                    alone.append(str.charAt(i));
                }
            }
        }
        if (count > 0) {//запись сокращенного фрагмента
            //out.append(count);
             out.append((char) count);
            count = 0;
            out.append(str.charAt(i));
        } else {//обработка одиночного символа
            alone.append(str.charAt(i));
            if (alone.length() > 2) {
                out.append((char) 0);
                out.append(alone);
                out.append((char)0);
                alone = new StringBuilder();
            } else {
                for (int j = 0; j < alone.length(); j++) {
                    out.append((char)1);
                    //out.append(1);
                    out.append(alone.charAt(j));
                }
            }
        }
        return out;
    }

    public static StringBuilder Decode_RLE(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++) {
            char currentChar = encoded.charAt(i);
            if (currentChar == 0) {
                // Если встретился символ со значением 0, пропускаем его и копируем следующие символы как есть
                while (i < encoded.length() - 1 && encoded.charAt(i + 1) != 0) {
                    i++;
                    decoded.append(encoded.charAt(i));

                }
                i++;
            } else {
                // Если встретилась цифра, то следующий символ повторяется указанное количество раз
                int repeatCount = (currentChar);
                i++;
                char repeatedChar = encoded.charAt(i);
                for (int j = 0; j < repeatCount; j++) {
                    decoded.append( repeatedChar);

                }
            }
        }
        return decoded;
    }
}

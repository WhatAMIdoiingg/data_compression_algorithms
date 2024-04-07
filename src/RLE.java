import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import java.io.FileWriter;
import java.io.BufferedWriter;
public class RLE {
    private static String Rle_for_grey(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).equals(numbers.get(i - 1))) {
                count++;
            } else {
                sb.append(numbers.get(i - 1)).append(" ").append(count).append(" ");
                count = 1;
            }
        }

        //  последнюю последовательность
        if (!numbers.isEmpty()) {
            sb.append(numbers.get(numbers.size() - 1)).append(" ").append(count);
        }

        return sb.toString().trim();
    }



    private static List<Integer> applyRLEDecompression(String rleCompressed) {
        List<Integer> decompressedNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(rleCompressed);

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                decompressedNumbers.add(number);
            }
        }

        scanner.close();
        return decompressedNumbers;
    }


    public static void RLE_to_file(String inputString, String filePath) {
        String compressedString = RLE(inputString);
        writeToFile(compressedString, filePath);
    }


    private static String RLE(String str1) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int count = 1;
            while (i + 1 < str1.length() && str1.charAt(i + 1) == ch) {
                i++;
                count++;
            }
            if (count > 1) {
                str.append(count + " ");
            }
            str.append(ch + " ");
        }
        return str.toString();
    }

    public static void D_RLE_to_file(String compressedString, String filePath) {
        String decompressedString = RLE_decompress(compressedString);
        writeToFile(decompressedString, filePath);
    }

    private static String RLE_decompress(String compressedString) {
        StringBuilder str = new StringBuilder();
        String[] parts = compressedString.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("\\d+")) {
                int count = Integer.parseInt(parts[i]);
                char ch = parts[i + 1].charAt(0);
                for (int j = 0; j < count; j++) {
                    str.append(ch);
                }
                i++;
            } else {
                str.append(parts[i]);
            }
        }
        return str.toString();
    }

    private static void writeToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

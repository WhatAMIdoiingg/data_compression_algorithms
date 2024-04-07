
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.io.*;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        String file_text = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/text.txt";
        String output = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/LZ.hum";
        String decompressedLZ = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressedLZ.txt";
        String compressedMTF = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/compressedMTF.txt";
        String decompressedMTF = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressedMTF.txt";
        ///
        ///   ПРОВЕРКА ХАФМАНА НА ТЕКСТЕ БОЛЕЕ 1 МБ
        ///
        ///
//      Huffman huffman = new Huffman();

//        try {
//            String content = new String(Files.readAllBytes(Paths.get(file_text)));
//            // вычисляем частоты символов в тексте
//           TreeMap<Character, Integer> f = huffman.count_of_repetitions_of_ch(content);
//            // генерируем список листов дерева
//            ArrayList<Huffman.TreeNode> code_tree = huffman.Code_tree(f);
//            // строим кодовое дерево с помощью алгоритма Хаффмана
//            Huffman.TreeNode tree = huffman.huf(code_tree);
//            // генерация префиксных кодов хаффмана
//            TreeMap<Character, String> codes = huffman.Codes(f, tree);
//            StringBuilder encoded = new StringBuilder();
//            for (int i = 0; i < content.length(); i++) {
//                encoded.append(codes.get(content.charAt(i)));
//            }
//            File file = new File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/text_code.txt");
//            saveToFile(file,f,encoded.toString());
//            TreeMap<Character, Integer> frequencies2 = new TreeMap<>();
//            StringBuilder encoded2 = new StringBuilder();
//            code_tree.clear();
//            // извлечение сжатой информации из файла
//            loadFromFile(file, frequencies2, encoded2);
//            // генерация листов и постоение кодового дерева Хаффмана на основе таблицы частот сжатого файла
//            for(Character c: frequencies2.keySet()) {
//                code_tree.add(new Huffman.TreeNode(c, frequencies2.get(c)));
//            }
//            Huffman.TreeNode tree2 = huffman.huf(code_tree);
//
//            // декодирование обратно исходной информации из сжатой
//            String decoded = huffman.Huffman_decoder(encoded2.toString(), tree2);
//
//            // сохранение в файл декодированной информации
//            Files.write(Paths.get("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressed.txt"), decoded.getBytes());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ///
        ///
        /// LZ77 На тексте более 1 МБ
        ///

//        LZ77 lz77 = new LZ77();
//        String content = new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);
//        StringBuilder a = lz77.compress(content);
//
//        // Сохранение сжатого содержимого в файл
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8)) {
//            writer.write(a.toString());
//        }
//
//        // Распаковка содержимого
//        StringBuilder t = lz77.deсompressLZ(a);
//
//        // Сохранение распакованного содержимого в файл
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressedLZ), StandardCharsets.UTF_8)) {
//            writer.write(t.toString());
//        } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }
//
//


        ///
        ///
        /// MOVE TO FRONT
        ///
        ///
//        String content = new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);
//        String t = MoveToFront.compress(content);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(compressedMTF), StandardCharsets.UTF_8)) {
//            writer.write(t.toString());
//        } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }
//        String t2 = MoveToFront.moveToFront_decoder(t);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressedMTF), StandardCharsets.UTF_8)) {
//            writer.write(t2.toString());
//        } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }
//
//    }
        ///
        ///
        /// ARITHMETIC CODE
        ///
        ///

    }



    private static void saveToFile(File output, Map<Character, Integer> frequencies, String bits) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(output));
            dos.writeInt(frequencies.size());
            for (Character character: frequencies.keySet()) {
                dos.writeChar(character);
                dos.writeInt(frequencies.get(character));
            }
            int compressedSizeBits = bits.length();
            BitArray bitArray = new BitArray(compressedSizeBits);
            for (int i = 0; i < bits.length(); i++) {
                bitArray.set(i, bits.charAt(i) != '0' ? 1 : 0);
            }

            dos.writeInt(compressedSizeBits);
            dos.write(bitArray.bytes, 0, bitArray.getSizeInBytes());
            dos.flush();
            dos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // загрузка сжатой информации и таблицы частот из файла
    private static void loadFromFile(File input, Map<Character, Integer> frequencies, StringBuilder bits) {
        try {
            DataInputStream os = new DataInputStream(new FileInputStream(input));
            int frequencyTableSize = os.readInt();
            for (int i = 0; i < frequencyTableSize; i++) {
                frequencies.put(os.readChar(), os.readInt());
            }
            int dataSizeBits = os.readInt();
            BitArray bitArray = new BitArray(dataSizeBits);
            os.read(bitArray.bytes, 0, bitArray.getSizeInBytes());
            os.close();

            for (int i = 0; i < bitArray.size; i++) {
                bits.append(bitArray.get(i) != 0 ? "1" : 0);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readCompressedStringFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        String compressedString = scanner.nextLine();
        scanner.close();
        return compressedString;
    }


    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public static double calculateEntropy(double[] probabilities) {
        double entropy = 0.0;
        for (double probability : probabilities) {
            if (probability > 0) {
                entropy += probability * Math.log(probability) / Math.log(2);
            }
        }
        return -entropy;
    }




}



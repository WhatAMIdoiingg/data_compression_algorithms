
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
        String enwik7 = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/enwik7.txt";
        String output = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/LZ.hum";
        String decompressedLZ = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressedLZ.txt";
        String compressedMTF = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/compressedMTF.txt";
        String decompressedMTF = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressedMTF.txt";
        String decomprecced_after_LZ_HA = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decomprecced_after_LZ_HA.txt";
        String compressed_BWT_RLE = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/compressed_BWT_RLE.txt";
        String decompressed_BWT_RLE = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressed_BWT_RLE.txt";
        String decompressed_BWT_MTF_HA = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressed_BWT_MTF_HA.txt";
        String decompressed_BWT_MTF_RLE_HA = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/decompressed_BWT_MTF_RLE_HA.txt";
        String compressed_RLE = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/compressed_RLE.txt";
        String pic = "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/compressed_RLE.txt";
        String bw =  "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/pixel.txt";
        String grey= "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/pixel_grey.txt";
        String colour= "C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/colored.txt";
        //подсчет энтропии b jwtyrf
//        String content = new String(Files.readAllBytes(Paths.get(file_text)));
//
//        HashMap<Character,Double> h = Arifmetic_code.get_rate(content);
//        ArrayList<Character> a = Arifmetic_code.getAlphabet(content);
//        int count = content.length();
//        double v = calculateEntropy(h,a);
//        System.out.println(count);
//        System.out.println(v);

        ///
        ///   ПРОВЕРКА ХАФМАНА
        ///
        ///
      //Huffman huffman = new Huffman();

//        try {
//            String content = new String(Files.readAllBytes(Paths.get(colour)));
//            Huffman huffman = new Huffman();
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
//            File file = new File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/pic_ha.txt");
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

///
        ///
        ///
        /// LZ77 + HA
        ///
        ///
//  try {
//        LZ77 lz77 = new LZ77();
//        String content = new String(Files.readAllBytes(Paths.get(colour)), StandardCharsets.UTF_8);
//        StringBuilder a = lz77.compress(content);
//      System.out.println(a);
//      System.out.println("Проверка работы");
//          //  String content = new String(Files.readAllBytes(Paths.get(enwik7)));
//           Huffman huffman = new Huffman();
//            // вычисляем частоты символов в тексте
//           TreeMap<Character, Integer> f = huffman.count_of_repetitions_of_ch(a.toString());
//            // генерируем список листов дерева
//            ArrayList<Huffman.TreeNode> code_tree = huffman.Code_tree(f);
//            // строим кодовое дерево с помощью алгоритма Хаффмана
//            Huffman.TreeNode tree = huffman.huf(code_tree);
//            // генерация префиксных кодов хаффмана
//            TreeMap<Character, String> codes = huffman.Codes(f, tree);
//            StringBuilder encoded = new StringBuilder();
//            for (int i = 0; i < a.length(); i++) {
//                encoded.append(codes.get(a.charAt(i)));
//            }
//            File file = new File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/text_code_enwik7_lz _and_huffman.txt");
//            saveToFile(file,f,encoded.toString());
//      System.out.println(encoded);
//      System.out.println("Проверка работы");
//            // декодирование
//      TreeMap<Character, Integer> frequencies2 = new TreeMap<>();
//      StringBuilder encoded2 = new StringBuilder();
//      code_tree.clear();
//      // извлечение сжатой информации из файла
//      loadFromFile(file, frequencies2, encoded2);
//      // генерация листов и постоение кодового дерева Хаффмана на основе таблицы частот сжатого файла
//      for(Character c: frequencies2.keySet()) {
//          code_tree.add(new Huffman.TreeNode(c, frequencies2.get(c)));
//      }
//      Huffman.TreeNode tree2 = huffman.huf(code_tree);
//
//      // декодирование обратно исходной информации из сжатой
//      String decoded = huffman.Huffman_decoder(encoded2.toString(), tree2);
//      System.out.println(decoded);
//      StringBuilder dec;
//      dec = new StringBuilder(decoded);
//      StringBuilder t = lz77.deсompressLZ(dec);
//
//      // Сохранение распакованного содержимого в файл
//      try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decomprecced_after_LZ_HA), StandardCharsets.UTF_8)) {
//          writer.write(t.toString());
//      } catch(IOException e)
//      {
//          System.out.println("Содержимое StringBuilder не сохранено в файл.");
//          e.printStackTrace();
//      }
//
//  } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }


        ///
        ///
        /// MOVE TO FRONT + RLE
        ///
        ///
//        MTF mtf = new MTF();
//        String content = new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);
//        System.out.println(content);
//        StringBuilder t = MTF.compress(content);
//        System.out.println("после mtf: " + t);
//       // ArrayList<Character> alphabet = (ArrayList<Character>)MoveToFront.createAlphabet(content);
//         StringBuilder c = RLE.RLE_Coder(t);
//
//
//        System.out.println("после mtf+rle" + c);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(compressedMTF), StandardCharsets.UTF_8)) {
//            writer.write(c.toString());
//        } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }
//        StringBuilder c2  = RLE.Decode_RLE(c.toString());
//
//        System.out.println(c2);
//
//        System.out.println("декомпрессия rle: " + c2);
//
//        String t2 = MTF.decompress(c2);
//
//
//        System.out.println("декомпрессия rle+mtf: " + t2);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressedMTF), StandardCharsets.UTF_8)) {
//            writer.write(t2.toString());
//        } catch(IOException e)
//        {
//            System.out.println("Содержимое StringBuilder не сохранено в файл.");
//            e.printStackTrace();
//        }

        // }
        ///
        ///
        /// BWT RLE
        ///
        BWTFast bwtFast = new BWTFast();
          String content = new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);

        String t = String.valueOf(bwtFast.getBWT(content));// реобразовали
        StringBuilder t_s= new StringBuilder();
        t_s.append(t);
      // System.out.println(t);
        String a2 = String.valueOf((RLE.RLE_Coder(t_s))); // применили рле
       //System.out.println(a2);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(compressed_BWT_RLE), StandardCharsets.UTF_8)) {
            writer.write(a2.toString());
        }
        String content2 = new String(Files.readAllBytes(Paths.get(compressed_BWT_RLE)), StandardCharsets.UTF_8);
        String d = String.valueOf(RLE.Decode_RLE(content2));//отмена рле
        //System.out.println(d);
        BWT_Optimization bwt_optimization = new BWT_Optimization();
        String d2 = String.valueOf(bwt_optimization.Decomprecced_optim(d));
        //System.out.println(d2);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressed_BWT_RLE), StandardCharsets.UTF_8)) {
            writer.write(d2.toString());
        }


        ///
        ///
        //// BWT MTF HA
        ////
        ///
//        BWTFast bwtFast = new BWTFast();
//        String content = new String(Files.readAllBytes(Paths.get(enwik7)), StandardCharsets.UTF_8);
//        String c = String.valueOf(bwtFast.getBWT(content));
//
//        String dr =MTF.compress(c).toString();
//
//        Huffman huffman = new Huffman();
//        // вычисляем частоты символов в тексте
//        TreeMap<Character, Integer> f = huffman.count_of_repetitions_of_ch(dr);
//        // генерируем список листов дерева
//        ArrayList<Huffman.TreeNode> code_tree = huffman.Code_tree(f);
//        // строим кодовое дерево с помощью алгоритма Хаффмана
//        Huffman.TreeNode tree = huffman.huf(code_tree);
//        // генерация префиксных кодов хаффмана
//        TreeMap<Character, String> codes = huffman.Codes(f, tree);
//        StringBuilder encoded = new StringBuilder();
//        for (int i = 0; i < dr.length(); i++) {
//            encoded.append(codes.get(dr.charAt(i)));
//        }
//        File file = new File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/text_code_BWT_MTF_HA.txt");
//        saveToFile(file,f,encoded.toString());
//
//        TreeMap<Character, Integer> frequencies2 = new TreeMap<>();
//        StringBuilder encoded2 = new StringBuilder();
//        code_tree.clear();
//        // извлечение сжатой информации из файла
//        loadFromFile(file, frequencies2, encoded2);
//        // генерация листов и постоение кодового дерева Хаффмана на основе таблицы частот сжатого файла
//        for(Character character: frequencies2.keySet()) {
//            code_tree.add(new Huffman.TreeNode(character, frequencies2.get(character)));
//        }
//        Huffman.TreeNode tree2 = huffman.huf(code_tree);
//
//        // декодирование обратно исходной информации из сжатой
//        String decoded = huffman.Huffman_decoder(encoded2.toString(), tree2);
//        String decoded2 = MTF.deCompress(new StringBuilder(decoded));
//        String out = String.valueOf(BWT_Optimization.Decomprecced_optim(decoded2));
//       // System.out.println(out);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressed_BWT_MTF_HA), StandardCharsets.UTF_8)) {
//            writer.write(out);
//        }

        ///
        ///
        //// BWT MTF RLE HA
        ////
        ///
//        MTF mtf = new MTF();
//        BWTFast bwtFast = new BWTFast();
//        String content = new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);
//        String c = String.valueOf(bwtFast.getBWT(content));
//        System.out.println(c);
//        StringBuilder t = (mtf.compress(c));
//       System.out.println(t);
//        String e =  (RLE.RLE_Coder(t)).toString();
//      //  System.out.println(e);
//      //  System.out.println(e);
//        Huffman huffman = new Huffman();
//        // вычисляем частоты символов в тексте
//        TreeMap<Character, Integer> f = huffman.count_of_repetitions_of_ch(e);
//        // генерируем список листов дерева
//        ArrayList<Huffman.TreeNode> code_tree = huffman.Code_tree(f);
//        // строим кодовое дерево с помощью алгоритма Хаффмана
//        Huffman.TreeNode tree = huffman.huf(code_tree);
//        // генерация префиксных кодов хаффмана
//        TreeMap<Character, String> codes = huffman.Codes(f, tree);
//        StringBuilder encoded = new StringBuilder();
//        for (int i = 0; i < e.length(); i++) {
//            encoded.append(codes.get(e.charAt(i)));
//        }
//        File file = new File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/text_code_BWT_MTF_RLE_HA_.txt");
//        saveToFile(file,f,encoded.toString());
//        TreeMap<Character, Integer> frequencies2 = new TreeMap<>();
//        StringBuilder encoded2 = new StringBuilder();
//        code_tree.clear();
//        // извлечение сжатой информации из файла
//        loadFromFile(file, frequencies2, encoded2);
//        // генерация листов и постоение кодового дерева Хаффмана на основе таблицы частот сжатого файла
//        for(Character character: frequencies2.keySet()) {
//            code_tree.add(new Huffman.TreeNode(character, frequencies2.get(character)));
//        }
//        Huffman.TreeNode tree2 = huffman.huf(code_tree);
//        //System.out.println("обратное преобразованеи");
//        // декодирование обратно исходной информации из сжатой
//        String decoded = huffman.Huffman_decoder(encoded2.toString(), tree2);
//      // System.out.println(decoded);
//        StringBuilder decoded2 = (RLE.Decode_RLE(decoded));
//      //  System.out.println(decoded2);
//         String decoded3 = MTF.deCompress(decoded2);
////        System.out.println(decoded3);
//        String out = String.valueOf(BWT_Optimization.Decomprecced_optim(decoded3));
//        System.out.println(out);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(decompressed_BWT_MTF_RLE_HA), StandardCharsets.UTF_8)) {
//            writer.write(out);
//        }

        ///
        ///
        /// RLE
        ///
        ///

//        String content2 = "16aehijklopqrstuwy01421113151587150150900909090909090140150150150150150";//new String(Files.readAllBytes(Paths.get(file_text)), StandardCharsets.UTF_8);
//        String r = String.valueOf(RLE.RLE_Coder(content2));
//        System.out.println(r);
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(compressed_RLE), StandardCharsets.UTF_8)) {
//            writer.write(r);
//      }
//        String rd = String.valueOf(RLE.Decode_RLE(r));
//        System.out.println(rd);


        // Main_for_BWT_RLE();

    }

    public static void Main_for_BWT_RLE() throws IOException {
        List<String> wordList = new ArrayList<>();
        //wordList.add("test.txt");
        wordList.add("10000");
        wordList.add("20000");
        wordList.add("50000");
        wordList.add("100000");
        wordList.add("150000");
        wordList.add("200000");
        wordList.add("300000");
        wordList.add("500000");
        wordList.add("700000");

//        wordList.add("1000.txt");
//        wordList.add("10000.txt");
//        wordList.add("50000.txt");
//        wordList.add("100000.txt");
//        wordList.add("250000.txt");
//        wordList.add("500000.txt");
//        wordList.add("750000.txt");
//        wordList.add("1000000.txt");
//        wordList.add("enwik7.txt");
//        wordList.add("Текст на русском, объёмом не менее 1Мб.txt");

        BWTFast bwt = new BWTFast();
        int countChar = 10000;
        int count = 0;
        int j = 0;
        int[] countC = {10, 100, 500, 1000, 5000, 10000, 20000, 40000, 60000,80000, 100000,200000,400000,600000,800000};
        //for (String word : wordList) {
        for (int m = 0; m < countC.length; m++) {
            countChar = countC[m];
            j = 0;
            count = 0;
            String originString = Open_Read_File("C:/Users/kbelk/OneDrive/Рабочий стол/4 семестр/АиСД/enwik7.txt").toString();
            StringBuilder compressed = new StringBuilder();

            for (int i = 0; i < originString.length() - 1; i++) {
                StringBuilder partString = new StringBuilder();
                while (j < originString.length() && count < countChar) {
                    j++;
                    count++;
                    partString.append(originString.charAt(i));
                    i++;
                }
                i--;
                count = 0;
                compressed = compressed.append(bwt.getBWT(partString.toString()));
                //System.out.print(partString + " ");
            }
            RLE rle = new RLE();
            StringBuilder bwt_rle = RLE.RLE_Coder(compressed);
            // System.out.println("Размер исходной строки " + countChar + ": " + originString.getBytes().length * 8);
            System.out.println("Размер сжатой строки: " + bwt_rle.toString().getBytes().length/1024);
            Write_Close_File("results for BWT+MTF+Huffman.txt", bwt_rle.toString());
        }
    }

    public static StringBuilder Open_Read_File(String nameFile) throws IOException {
        File myFile = new File(nameFile);
        FileInputStream inputStream = new FileInputStream(myFile);
        StringBuilder originString = new StringBuilder();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            originString.append(new String(buffer, 0, bytesRead));
        }
        inputStream.close();
        return originString;
    }
    public static void Write_Close_File(String nameFile, String compressed) throws IOException{
        File inFile = new File(nameFile);
        FileOutputStream outputStream = new FileOutputStream(inFile);
        byte[] bufferDecompressed = compressed.toString().getBytes();
        outputStream.write(bufferDecompressed);
        outputStream.close();
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


    public static double calculateEntropy(HashMap<Character, Double> probabilities, ArrayList<Character> alfabet) {
        double entropy = 0.0;
        for (Character character : alfabet) {
            double probability = probabilities.get(character);
            if (probability > 0) {
                entropy += probability * Math.log(probability) / Math.log(2);
            }
        }
        return -entropy;
    }

    public static String readNCharsFromFile(String fileName, int n) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[n];
            int charsRead = reader.read(buffer, 0, n);
            if (charsRead != -1) {
                return new String(buffer, 0, charsRead);
            } else {
                return "Файл пуст или достигнут конец файла.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении файла.";
        }

    }
}



import java.util.ArrayList;
import java.util.Collections;

public class BWT_Optimization { /// обратное преобразование улучшенное
    public static StringBuilder Decomprecced_optim(String str) {
        ArrayList<BWT_object> map = new ArrayList<>();
        StringBuilder strOutput = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            map.add(new BWT_object(i, str.charAt(i)));
        }
        Collections.sort(map);

        int n = 0;
        for (BWT_object bwtObject : map) {

            if (bwtObject.character == '$') {
                break;
            }
            n++;
        }
        n = map.get(n).getNum();

        for (int i = 0; i < map.size() - 1; i++) {
            strOutput.append(map.get(n).getCharacter());
            n = map.get(n).getNum();
        }

        return strOutput;

    }
//    public StringBuilder decompress(String str) {
//        ArrayList<BWT_object> perestanovki = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            perestanovki.add(new BWT_object(i, str.charAt(i)));
//        }
//        Collections.sort(perestanovki);
//        StringBuilder strOutput = new StringBuilder();
//        //System.out.println(perestanovki);
//        int n = perestanovki.get(0).num;
//        while (n != 0) {
//
//            strOutput.append(perestanovki.get(n).characterl);
//            n = perestanovki.get(n).num;
//        }
//       // System.out.println(strOutput);
//        return strOutput;
//    }
//    public StringBuilder decompressBlocks(String str, int blockSize) {
//        StringBuilder output = new StringBuilder();
//        int blockCount = str.length() / blockSize;
//
//        for (int i = 0; i < blockCount; i++) {
//            String block = str.substring(i * blockSize, ((i + 1) * blockSize)+1);
//            output.append(decompress(block));
//            if(i == blockCount){
//
//                block = str.substring(i * blockSize, str.length());
//                output.append(decompress(block));
//            }
//
//        }
//
//        return output;
//    }

}

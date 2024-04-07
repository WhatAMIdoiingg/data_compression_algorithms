import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Huffman {

//    // для кодирования текста Хаффманом
//    public static class HuffmanResult {
//        public StringBuilder encoded;
//        public TreeNode tree;
//
//        public HuffmanResult(StringBuilder encoded, TreeNode tree) {
//            this.encoded = encoded;
//            this.tree = tree;
//        }
//
//
//    }
//
////    public HuffmanResult Huffman_code(String text) {
////        // вычисляем частоты символов в тексте
////        TreeMap<Character, Integer> f = count_of_repetitions_of_ch(text);
////        // генерируем список листов дерева
////        ArrayList<TreeNode> code_tree = Code_tree(f);
////        // строим кодовое дерево с помощью алгоритма Хаффмана
////        TreeNode tree = huf(code_tree);
////        // генерация префиксных кодов хаффмана
////        TreeMap<Character, String> codes = Codes(f, tree);
////        StringBuilder encoded = new StringBuilder();
////        for (int i = 0; i < text.length(); i++) {
////            encoded.append(codes.get(text.charAt(i)));
////        }
////        return new HuffmanResult(encoded, tree);
////    }

    // Метод для декодирования текста Хаффманом
    public String Huffman_decoder(String encoded, TreeNode tree) {
        StringBuilder decoded = new StringBuilder();
        TreeNode node = tree;
        for (int i = 0; i < encoded.length(); i++) {
            node = encoded.charAt(i) == '0' ? node.left : node.right;
            if (node.content != null) {
                decoded.append(node.content);
                node = tree;
            }
        }
        return decoded.toString();
    }




    //генерация кодов хаффмана
    public TreeMap<Character, String> Codes(TreeMap<Character, Integer> freqMap, TreeNode tree){
        TreeMap<Character, String> codes = new TreeMap<>();
        for(Character c :freqMap.keySet() ){
            codes.put(c,tree.getCode(c,""));

        }
        return codes;
    }

    // количество повторений символа в тексте
    public TreeMap<Character, Integer> count_of_repetitions_of_ch(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            Integer count = freqMap.get(ch);
            freqMap.put(ch, count != null ? count + 1 : 1);
        }
        return freqMap;
    }
// генерация узлов
    public ArrayList<TreeNode> Code_tree(TreeMap<Character, Integer> freqMap) {
        ArrayList<TreeNode> code_tree_node = new ArrayList<>();
        for (Character c : freqMap.keySet()) {
            code_tree_node.add(new TreeNode(c, freqMap.get(c)));
        }
        return code_tree_node;
    }
// класс дерева хаффмана
    public static class TreeNode implements Comparable<TreeNode> {
        Character content;
        int weight;
        TreeNode left;
        TreeNode right;

        public TreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public TreeNode(Character content, int weight, TreeNode left, TreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(TreeNode o) {
            return Integer.compare(o.weight, weight);
        }

        // проход по дереву получение кода
        public String getCode(Character ch, String way) {
            if (content == ch) {
                return  way;
            } else {
                if (left != null) {//рекурсия для левого потомка
                    String path = left.getCode(ch, way + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {//рекурсия для правого потомка
                    String path = right.getCode(ch, way + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }return null;
        }
    }

    public TreeNode huf(ArrayList<TreeNode> code_tree_node){
        while(code_tree_node.size()>1){
            Collections.sort(code_tree_node);
            TreeNode left = code_tree_node.remove(code_tree_node.size()-1);
            TreeNode right = code_tree_node.remove(code_tree_node.size()-1);
            TreeNode parent = new TreeNode(null,right.weight + left.weight, left,right);
            code_tree_node.add(parent);
        }
        return code_tree_node.get(0);
    }
}
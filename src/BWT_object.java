public class BWT_object implements Comparable<BWT_object>{
    int num;
    char characterl;

    public BWT_object(int num, char characterl) {
        this.num = num;
        this.characterl = characterl;
    }

    @Override
    public int compareTo(BWT_object o) {
        return ((int)this.characterl-(int)o.characterl);
    }

    @Override
    public String toString() {
        return "{" +
                 num +""+
                 characterl +
                '}';
    }
}

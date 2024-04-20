public class BWT_object implements Comparable<BWT_object>{
    Integer num;
    Character character;

    public BWT_object(int num, char character) {
        this.num = num;
        this.character = character;
    }

    @Override
    public int compareTo(BWT_object o) {

        return (((int)this.character) - ((int)o.getCharacter()));
    }

    @Override
    public String toString() {
        return  num +" " + character;
    }


    public Integer getNum() {
        return num;
    }
    public Character getCharacter() {
        return character;
    }



}

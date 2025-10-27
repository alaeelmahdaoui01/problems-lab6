package problem3;

public class Document {
    public static int nextRec = 1 ;
    protected int numRec ;
    protected String title ;

    public Document(String title){
        this.title = title  ;
        this.numRec = nextRec++ ;
    }


    @Override
    public String toString() {
        return "Document: " + this.title + ", numRec: " + numRec ;
    }


}

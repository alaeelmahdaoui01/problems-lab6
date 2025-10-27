package problem3;

public class TextBook extends Book{
    public String level ;
    public TextBook(String title , String author, int nbrPages , String level){
        super(title, author, nbrPages);
        this.level = level ;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTextbook's level: "  + this.level;
    }
}

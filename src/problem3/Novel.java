package problem3;

public class Novel extends Book{
    public double price ;

    public Novel(String title , String author, int nbrPages , double price){
        super(title, author, nbrPages);
        this.price = price ;
    }


    @Override
    public String toString() {
        return super.toString() + "\nNovel's price: "  + this.price;
    }
}

package problem3;

public class Magazine extends Document{
    private String month ;
    private int year ;

    public Magazine(String title , String month, int year){
        super(title);
        this.month = month ;
        this.year = year ;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMagazine date: " + this.month + ", " + this.year ;
    }
}

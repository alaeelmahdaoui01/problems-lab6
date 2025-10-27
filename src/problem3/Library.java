package problem3;

import javax.print.Doc;
import java.util.ArrayList;

public class Library {
    private int capacity ;
    private ArrayList<Document> documents ;


    public Library(int capacity){
        documents = new ArrayList<>();
        this.capacity = capacity ;
    }

    // getters and setters

    // a document must belong to exactly one library
    // how ?

    @Override
    public String toString() {
        StringBuilder library =  new StringBuilder("Library: " + capacity);
        library.append("\nDocuments: ");
        for (Document document : documents){
            library.append("\n- ").append(document);
        }
        return library.toString() ;
    }


    public void displayDocuments(){
        System.out.println("Documents: ");
        for (Document doc: documents){
            System.out.println("- " + doc) ;
        }
    }

    public boolean add(Document doc){
        if (documents.contains(doc)){
            return false ;
        }
        else if (documents.size()< capacity) {
            documents.add(doc);
            return true;
        }
        return false ;

    }

    public boolean delete(Document doc){
        if (documents.contains(doc)){
            documents.remove(doc);
            return true ;
        }
        return false ;
    }

    public Document document(int numRec){
        for (Document doc: documents){
            if (doc.numRec == numRec){
                return doc ;
            }
        }
        return null ;
    }

    public void displayAuthors(){
        for (Document doc : documents){
            if (doc.getClass() == Book.class ){
                System.out.println(", "+((Book) doc).getAuthor()) ;  // or .author
            }
        }
    }

}

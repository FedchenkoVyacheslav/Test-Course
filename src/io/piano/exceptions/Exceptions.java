package io.piano.exceptions;
import java.util.*;

public class Exceptions {

    public static void libraryItem(Map <String, String> libraryList, String id){
        String book = libraryList.get(id);
        if (id.equals("00001"))  {
            throw new NullPointerException ("Error! This book removed");
        } else if (book==null) {
            throw new NullPointerException ("Error! You enter a wrong number");
        } else
            System.out.println("Name of the book: " + book);
    }

    public static void main(String[] args) {

        Map<String, String> libraryList = new HashMap<>();
        List<String> books =  new ArrayList<>(Arrays.asList(
                "Carrie",
                "The Shining",
                "Pet Sematary",
                "It",
                "Misery",
                "The Green Mile",
                "11/22/63",
                "Doctor Sleep",
                "Under the Dome"));
        for (int i=0; i<books.size(); i++) {
            libraryList.put("0000" + (i+1), books.get(i));
        }

        libraryList.remove("00001");
        System.out.println("Enter ID of the book (from 00001 to 00009)");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();

        try {
            libraryItem(libraryList, id);
        }
        catch (NullPointerException e) {
            System.out.println("Sorry! No books found for this ID!");
            e.printStackTrace();
        }
        finally {
            System.out.println("Good bye!");
        }
    }
}

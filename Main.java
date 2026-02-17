import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book by ISBN");
            System.out.println("3. Register Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. View All Books");
            System.out.println("7. Sort by Title");
            System.out.println("8. View Overdue Books");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    library.addBook(new Book(isbn, title, author, year));
                    break;

                case 2:
                    System.out.print("Enter ISBN: ");
                    library.searchByISBN(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    library.registerMember(new Member(memberId, name));
                    break;

                case 4:
                    System.out.print("ISBN: ");
                    String bIsbn = sc.nextLine();
                    System.out.print("Member ID: ");
                    String mId = sc.nextLine();
                    library.borrowBook(bIsbn, mId);
                    break;

                case 5:
                    System.out.print("ISBN: ");
                    String rIsbn = sc.nextLine();
                    System.out.print("Member ID: ");
                    String rId = sc.nextLine();
                    library.returnBook(rIsbn, rId);
                    break;

                case 6:
                    library.viewAllBooks();
                    break;

                case 7:
                    library.sortBooksByTitle();
                    break;

                case 8:
                    library.viewOverdueBooks();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}

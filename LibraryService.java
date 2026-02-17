import java.util.*;
import java.time.LocalDate;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private List<BorrowRecord> borrowRecords = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Book already exists.");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book added successfully.");
        }
    }

    // Search by ISBN
    public void searchByISBN(String isbn) {
        Book book = books.get(isbn);
        System.out.println(book != null ? book : "Book not found.");
    }

    // Search by Title
    public void searchByTitle(String title) {
        books.values().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .forEach(System.out::println);
    }

    // Search by Author
    public void searchByAuthor(String author) {
        books.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    // Register Member
    public void registerMember(Member member) {
        if (members.containsKey(member.getMemberId())) {
            System.out.println("Member already exists.");
        } else {
            members.put(member.getMemberId(), member);
            System.out.println("Member registered.");
        }
    }

    // Borrow Book
    public void borrowBook(String isbn, String memberId) {

        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid book or member.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already borrowed.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrow limit reached.");
            return;
        }

        book.setAvailable(false);
        member.getBorrowedBooks().add(book);

        BorrowRecord record = new BorrowRecord(book, member);
        borrowRecords.add(record);

        System.out.println("Book borrowed successfully. Due date: " + record.getDueDate());
    }

    // Return Book
    public void returnBook(String isbn, String memberId) {

        for (BorrowRecord record : borrowRecords) {
            if (record.getBook().getIsbn().equals(isbn)
                    && record.getMember().getMemberId().equals(memberId)
                    && record.getReturnDate() == null) {

                record.returnBook();
                record.getBook().setAvailable(true);
                record.getMember().getBorrowedBooks().remove(record.getBook());

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Borrow record not found.");
    }

    // View All Books
    public void viewAllBooks() {
        books.values().forEach(System.out::println);
    }

    // Sort Books
    public void sortBooksByTitle() {
        books.values().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public void sortBooksByAuthor() {
        books.values().stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .forEach(System.out::println);
    }

    public void sortBooksByYear() {
        books.values().stream()
                .sorted(Comparator.comparing(Book::getYear))
                .forEach(System.out::println);
    }

    // Overdue Books
    public void viewOverdueBooks() {
        borrowRecords.stream()
                .filter(BorrowRecord::isOverdue)
                .forEach(System.out::println);
    }
}


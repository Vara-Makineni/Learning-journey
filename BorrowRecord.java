import java.time.LocalDate;

public class BorrowRecord {

    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14);
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return book.getTitle() + " | Borrowed by: " + member.getName()
                + " | Due: " + dueDate
                + (returnDate != null ? " | Returned: " + returnDate : "");
    }
}


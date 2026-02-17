import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private int borrowLimit = 3;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public int getBorrowLimit() { return borrowLimit; }

    public boolean canBorrow() {
        return borrowedBooks.size() < borrowLimit;
    }

    @Override
    public String toString() {
        return memberId + " | " + name + " | Borrowed: " + borrowedBooks.size();
    }
}

package model;

public class BookDTO {

    private String  bookId;
    private String bookName;
    private String bookAuthor;
    private String rate;
    private String bookTytpe;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBookTytpe() {
        return bookTytpe;
    }

    public void setBookTytpe(String bookTytpe) {
        this.bookTytpe = bookTytpe;
    }

    public BookDTO(String bookId, String bookName, String bookAuthor, String rate, String bookTytpe) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.rate = rate;
        this.bookTytpe = bookTytpe;
    }

    public BookDTO() {
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", rate='" + rate + '\'' +
                ", bookTytpe='" + bookTytpe + '\'' +
                '}';
    }
}

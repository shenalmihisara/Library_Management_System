package model;

import java.time.LocalDate;

public class ReturnBookDTO {

    private String returnBookId;
    private String memberName;
    private String issueBookId;
    private String memberId;
    private String bookId;
    private String bookName;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String returnDate;

    public String getReturnBookId() {
        return returnBookId;
    }

    public void setReturnBookId(String returnBookId) {
        this.returnBookId = returnBookId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIssueBookId() {
        return issueBookId;
    }

    public void setIssueBookId(String issueBookId) {
        this.issueBookId = issueBookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public ReturnBookDTO(String returnBookId, String memberName, String issueBookId, String memberId, String bookId, String bookName, LocalDate issueDate, LocalDate dueDate, String returnDate) {
        this.returnBookId = returnBookId;
        this.memberName = memberName;
        this.issueBookId = issueBookId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public ReturnBookDTO() {
    }

    @Override
    public String toString() {
        return "ReturnBookDTO{" +
                "returnBookId='" + returnBookId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", issueBookId='" + issueBookId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}

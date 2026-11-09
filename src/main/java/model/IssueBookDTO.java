package model;

import java.time.LocalDate;

public class IssueBookDTO {

    private String issuBookId;
    private String memberName;
    private String memberId;
    private String bookName;
    private String bookId;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public String getIssuBookId() {
        return issuBookId;
    }

    public void setIssuBookId(String issuBookId) {
        this.issuBookId = issuBookId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public IssueBookDTO(String issuBookId, String memberName, String memberId, String bookName, String bookId, LocalDate issueDate, LocalDate dueDate) {
        this.issuBookId = issuBookId;
        this.memberName = memberName;
        this.memberId = memberId;
        this.bookName = bookName;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public IssueBookDTO() {
    }

    @Override
    public String toString() {
        return "IssueBookDTO{" +
                "issuBookId='" + issuBookId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookId='" + bookId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
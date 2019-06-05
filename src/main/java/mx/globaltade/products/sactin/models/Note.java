package mx.globaltade.products.sactin.models;

public class Note {

    private String key;

    private String inputDate;

    private String outputDate;

    private String totalAmount;

    private String comments;

    public Note() {
        super();
    }

    public Note(String key, String inputDate, String outputDate, String totalAmount, String comments) {
        this.key = key;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.totalAmount = totalAmount;
        this.comments = comments;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

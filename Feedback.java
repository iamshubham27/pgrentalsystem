package pgrentalsystem;

public class Feedback {
    private String tenantName;
    private int rating; // from 1 to 5
    private String comments;

    public Feedback(String tenantName, int rating, String comments) {
        this.tenantName = tenantName;
        this.rating = rating;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Feedback from " + tenantName + ":\n" +
               "Rating: " + rating + "/5\n" +
               "Comments: " + comments + "\n";
    }
}
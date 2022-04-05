package model;

public class film {
private String title;
private String description;
private int release_year;
private  int length;
private String rating;
private String category;

    public film(String title, String description, int release_year, int length, String rating, String category) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.length = length;
        this.rating = rating;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "film{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", release_year=" + release_year +
                ", length=" + length +
                ", rating='" + rating + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

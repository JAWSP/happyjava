package day16;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private int year;
    private String title;
    private double score;

    public Movie(int year, String title, double score) {
        this.year = year;
        this.title = title;
        this.score = score;
    }

    //이름을 기준으로 비교하기
    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Movie movie)) return false;

        return year == movie.year && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + Objects.hashCode(title);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", title='" + title + '\'' +
                ", score=" + score +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
class RatingComparator implements Comparable<Movie> {

    @Override
    public int compareTo(Movie o1, Movie o2) {
        return Double.compare(o1. getScore(), o2.getScore());
    }

}
 */
public class MovieMain {
    public static void main(String[] args) {
        List<Movie> moives = new ArrayList<>();
        moives.add(new Movie( 2017, "get out",4.3));
        moives.add(new Movie( 2016, "라라랜드",4.0));
        moives.add(new Movie( 2017, "the dark nights ",4.5));

        //Collections.sort(moives);
        for (Movie m : moives) {
            System.out.println(m);
        }

        //만약에 평점으로 비교하고 싶다면
        //이렇게 즉석으로 익명클래스 만들어서 하면 됨
        Collections.sort(moives, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Double.compare(o1.getScore(), o2.getScore());
            }
        });
        System.out.println("랭킹순");
        for (Movie m : moives) {
            System.out.println(m);
        }

    }
}

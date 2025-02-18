package org.example.jpa;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.sql.results.graph.Fetch;

import java.util.List;


@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    //패치는 쿼리를 어떻게 가겨올거냐
    //LAZY는 필요한 얘들만 먼저 가져오고 필요할때 가져온다는뜻
    //EAGER는 한꺼번에 다 가져온다고 한다 -> 얘가 디폴트
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
}

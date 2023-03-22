package blog.demo.search.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String keyword;

    @Version
    private int count;

    @Builder
    public Keyword(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }

    public void keywordUpdate() {
        this.count += 1;
    }
}

package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member") //해주지 않는 경우 클래스 네임이 테이블네임이 된다.
public class Member {

    @Id
    private Long id;

    @Column(name="name")// 해주지 않는 경우 필드명을 따라가게 된다.
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@TableGenerator(name = "MEMBER_SEQ_GENERATOR", table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ" , allocationSize = 1)
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
                    initialValue = 1, allocationSize = 50)//50이 기본값
public class Member {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(name = "name") //db에는 name으로 들아간다.
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) //db에는 enum타입이 없다. enum을 쓸때는 다음과 같은 어노테이션을 사용해준다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)  // TemporalType 안에는 날짜(DATA), 시간(TIME), 날짜시간(TIMESTAMP)가 있다.
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob //긴 컨텐츠를 넣고 싶으면 Lob 어노테이션을 사용한다.
    private String description;

    @Transient //db컬럼으로 사용하지 않는다.(생성 안됌)(메모리에만 사용함)
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

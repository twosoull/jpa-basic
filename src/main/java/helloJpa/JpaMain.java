package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//    <persistence-unit name="hello"> 유닛네임을 넣어주면 된다.

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction ts = entityManager.getTransaction();
        ts.begin(); //트랜잭션을 시작하지 않으면 jpa는 작동하지 않는다.

        try {
            /* 저장
            Member member = new Member();
            member.setId(1L);
            member.setName("ddd");
            entityManager.persist(member);
             */

            /* 조회와 삭제
            Member member = entityManager.find(Member.class, 1L);
            System.out.println("member id = " + member.getId());
            System.out.println("member name = " + member.getName());

            entityManager.remove(member);//db에서 지워진다.
            */

            //변경 감지로 지우지 않아도 됌
            Member member = entityManager.find(Member.class, 1L);
            member.setName("update!");


            ts.commit();
        } catch (Exception e){
            ts.rollback(); //오류일 경우 현재 코드들을 롤백 , 즉 저장하지 않는다.
        } finally {
            entityManager.close(); //언제나 닫아 줘야한다.
        }
        emf.close();


    }
}

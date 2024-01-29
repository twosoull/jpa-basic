package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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

            /*
            // 업데이트는 변경 감지로 persist를 날리지 않아도 됌
            Member member = entityManager.find(Member.class, 1L);
            member.setName("update!"); //변경하는 시점에 트랜잭션을 날리고 커밋이 된다.
            */

            /*

            * */
            // JPQL(객체를 대상으로 한 객체지향 쿼리)로 전체 조회 (객체 대상으로 쿼리를 조회한다)
            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1).setMaxResults(10)
                    .getResultList();//페이징 을 만들 수도 있다.

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            ts.commit();
        } catch (Exception e){
            ts.rollback(); //오류일 경우 현재 코드들을 롤백 , 즉 저장하지 않는다.
        } finally {
            entityManager.close(); //언제나 닫아 줘야한다.
        }
        emf.close();


    }
}

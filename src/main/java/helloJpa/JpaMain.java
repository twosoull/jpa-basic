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

            /*
            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1).setMaxResults(10)
                    .getResultList();//페이징 을 만들 수도 있다.

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }
            */

            /*
            Member member = new Member();
            member.setId(101L);
            member.setName("namename");

            entityManager.persist(member);

            //영속성으로 인해 1차 캐시에서 먼저 찾는다.
            Member member1 = entityManager.find(Member.class, 101L);

            System.out.println("member Id : " + member1.getId());
            System.out.println("member name : " + member1.getName());
            */

            /*
            // 1차캐시에 없으면 db에서 찾고 1차캐시에 넣은 것은 찾는다.
            Member member1 = entityManager.find(Member.class, 101L);
            // 1차에 이미 있으므로 쿼리를 날리지 않는다.
            Member member2 = entityManager.find(Member.class, 101L);

            System.out.println("member1 Id : " + member1.getId());
            System.out.println("member1 name : " + member1.getName());
            System.out.println("member2 Id : " + member2.getId());
            System.out.println("member2 name : " + member2.getName());

            //비교 시에 같은 엔티티로 동일하다.
            System.out.println("result = " + (member1 == member2)); // true
            */

            /*
            Member member1 = new Member(150L, "a");
            Member member2 = new Member(160L, "b");

            entityManager.persist(member1);
            entityManager.persist(member2);

            System.out.println("=======쓰기 지연 sql 저장소 이후======");
             */


/*
            Member member = entityManager.find(Member.class, 150L);
            member.setName("zzzzzz");
*/

            /*
            Member member = new Member(200L, "member200");
            entityManager.persist(member);

            entityManager.flush();//즉시 디비에 쿼리를 날린다.

            System.out.println("======");
            */

 /*           Member member = entityManager.find(Member.class, 150L);
            member.setName("adfadaf");

            entityManager.detach(member); //영속성 컨텐츠에서 제외 시켜버린다. 그러므로 커밋시점에 아무 일도 일어나지 않는다.
*/

            Member member = entityManager.find(Member.class, 150L);
            member.setName("dddd");

            entityManager.clear();

            Member member2 = entityManager.find(Member.class, 150L); // 새로 불러오게 된다.

            ts.commit();
        } catch (Exception e){
            ts.rollback(); //오류일 경우 현재 코드들을 롤백 , 즉 저장하지 않는다.
        } finally {
            entityManager.close(); //언제나 닫아 줘야한다.
        }
        emf.close();


    }
}

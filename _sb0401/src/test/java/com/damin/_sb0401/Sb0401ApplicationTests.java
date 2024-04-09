package com.damin._sb0401;

import com.damin._sb0401.entity.Memo;
import com.damin._sb0401.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0401ApplicationTests {
    @Autowired
    MemoRepository memoRepository;

    @PersistenceContext
    private EntityManager em;

    @Test //쿼리문을 jpa쪽에서 자동으로 만들어준다. Memo는 엔티티 이름
    void emTest2(){
        List<Memo> list= em.createQuery("select m from Memo m where m.mno > 5",Memo.class).getResultList();
        list.stream().forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    @Transactional
    void emInsert() {
        Memo memo = Memo.builder()
                .memoText("이것은 EM 테스트")
                .build();
        em.persist(memo);
    }

    @Test
    void contextLoads() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    @DisplayName("메모 입력")
    void insertMemo() {
        Memo memo = Memo.builder()
                .memoText("메모를 적어주세요")
                .build();
        memoRepository.save(memo);
    }

    @Test
    void insertMemos() {
        IntStream.rangeClosed(1, 10).forEach(i->{
            Memo memo = Memo.builder()
                    .memoText("메모"+i)
                    .build();
            memoRepository.save(memo);
        });
    }

    @Test
    @Transactional
    void selectMemos(){
        Long mno = 1L;
        Memo memo = memoRepository.getOne(mno);
        System.out.println(memo);
    }

}

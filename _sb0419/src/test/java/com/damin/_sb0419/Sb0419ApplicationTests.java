package com.damin._sb0419;

import com.damin._sb0419.entity.Notice;
import com.damin._sb0419.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0419ApplicationTests {

    @Autowired
    NoticeRepository noticeRepository;

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 100).forEach(i->{
            Notice notice = Notice.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .build();
            noticeRepository.save(notice);
        });

        Pageable pageable = PageRequest.of(9,10);
        Page<Notice> result = noticeRepository.findAll(pageable);
        System.out.println(result);
        System.out.println("-----------------------------");
        System.out.println("총 페이지 수:"+result.getTotalPages());
        System.out.println("현재 페이지:"+result.getNumber());
        System.out.println("다음 페이지:"+result.hasNext());
        System.out.println("-----------------------------");
        System.out.println(noticeRepository.selectCount());
        System.out.println("-----------------------------");
    }

    @Test
    public void testFindById() {
        Notice notice = Notice.builder()
                .title("제목")
                .content("내용")
                .regdate(LocalDateTime.now())
                .build();
        noticeRepository.save(notice);
        Optional<Notice> notice1 = noticeRepository.findById(1L);
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println(notice1);
    }

}

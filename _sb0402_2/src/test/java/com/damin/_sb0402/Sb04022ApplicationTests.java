package com.damin._sb0402;

import com.damin._sb0402.entity.MyData;
import com.damin._sb0402.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb04022ApplicationTests {

    @Autowired
    MyDataRepository myDataRepository;

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 10).forEach(i->{
            MyData myData = MyData.builder()
                    .age(20+i)
                    .mail("energy"+i+"@gmail.com")
                    .name("Emily"+i)
                    .memo("메모입니다"+i)
                    .build();
            myDataRepository.save(myData);
        });
    }

    @Test
    void updateMyData() {
        MyData myData = MyData.builder()
                .id(1L)
                .age(27)
                .mail("energy27@gmail.com")
                .name("Emily27")
                .memo("메모입니다27")
                .build();
        myDataRepository.save(myData);
    }

    @Test
    void selectAllMyData() {
        List<MyData> list = myDataRepository.findAll();
        list.stream().forEach(m->{
            System.out.println(m);
        });
//        for (MyData myData : list) {
//            System.out.println(myData);
//        }
    }

    @Test
    void selectOne() {
        Optional<MyData> myData = myDataRepository.findById(100L);
        if(myData.isPresent()) {
            System.out.println(myData.get());
        } else {
            System.out.println("자료 없음");
        }
    }

    @Test
    void deleteOne() {
        myDataRepository.deleteById(10L);
    }

    @Test
    void find2() {
        List<MyData> list = myDataRepository.findByIdBetween(3L, 7L);
        list.stream().forEach(m->{
            System.out.println(m);
        });
//        for (MyData myData : list) {
//            System.out.println(myData);
//        }
    }

    @Test
    void find3() {
        List<MyData> list = myDataRepository.findAll2();
        list.stream().forEach(m->{
            System.out.println(m);
        });
//        for (MyData myData : list) {
//            System.out.println(myData);
//        }
    }
}

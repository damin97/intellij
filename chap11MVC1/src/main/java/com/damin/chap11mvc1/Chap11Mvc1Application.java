package com.damin.chap11mvc1;

import com.damin.chap11mvc1.entity.MemberEntity;
import com.damin.chap11mvc1.entity.QuestionEntity;
import com.damin.chap11mvc1.repository.MemberRepository;
import com.damin.chap11mvc1.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Chap11Mvc1Application {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(Chap11Mvc1Application.class, args);
	}

	@PostConstruct
	private void init() {
		MemberEntity member = MemberEntity.builder()
				.email("damin@korea.com")
				.name("김다민")
				.password("1234")
				.regdate(LocalDateTime.now())
				.build();
		QuestionEntity q1 = new QuestionEntity("당신의 역할은 무엇입니까?",
				Arrays.asList("백엔드", "프론트", "DBA", "웹디자인"));
		questionRepository.save(q1);

		QuestionEntity q2 = new QuestionEntity("많이 사용하는 개발도구는 무엇입니까?",
				Arrays.asList("이클립스", "인텔리J", "서브라임"));
		questionRepository.save(q2);
		QuestionEntity q3 = new QuestionEntity("하고 싶은 말은?");
		questionRepository.save(q3);
	}
}

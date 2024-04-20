package com.damin.shoppingmall;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("DBCP: " + dataSource.getClass()); // 사용하는 DBCP 타입 확인
        log.info("Url: " + connection.getMetaData().getURL());
        log.info("UserName: " + connection.getMetaData().getUserName());
        
     // JdbcTemplate
        jdbcTemplate.execute("INSERT INTO Products "
        		+ "(prod_name, prod_price, prod_detail, prod_img) values ('Aurora Mind Lighting', 6900, '상세설명', '1.jpg')");
        jdbcTemplate.execute("INSERT INTO Products "
        		+ "(prod_name, prod_price, prod_detail, prod_img) values ('Griner Mind Lighting', 7000, '상세설명', '2.jpg')");
        jdbcTemplate.execute("INSERT INTO Products "
        		+ "(prod_name, prod_price, prod_detail, prod_img) values ('Vita Mind Lighting', 8000, '상세설명', '3.jpg')");
        
        jdbcTemplate.execute("INSERT INTO Member "
        		+ "(name, user_id, pw, address, zipcode, year, month, day) values ('김다민', 'damin', 'egosum1!', '서울시 진관2로 90 은평뉴타운 310동 701호', '03310', '1997', '01', '14')");
        jdbcTemplate.execute("INSERT INTO Member "
                + "(name, user_id, pw, address, zipcode, year, month, day) values ('관리자', 'admin', '1234', '서울시 진관2로 90 은평뉴타운 310동 701호', '03310', '1997', '01', '14')");
		
	}

}
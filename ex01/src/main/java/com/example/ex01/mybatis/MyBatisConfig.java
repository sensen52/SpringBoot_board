package com.example.ex01.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration //application context가 이 파일을 설정파일임을 인식시키기 위해쓰는 어노테이션
@RequiredArgsConstructor //생성자 주입
@Slf4j
public class MyBatisConfig {
    //applicationConctext에 직접 설정파일을 넣어주기위해
    private final ApplicationContext applicationContext;

    @ConfigurationProperties(prefix = "spring.datasource.hikari")//어떤 설정이 들어가는지는 aplication.yml에 설정하고 설정한걸 @Configuration으로 연결
    @Bean //메소드 리턴타입이 객체라면 Bean에 등록이 가능하다.
    public HikariConfig hikariConfig() {return new HikariConfig();} 

    @Bean
    public DataSource dataSource() {return new HikariDataSource(hikariConfig());}
    //설정들이 데이터소스안에 들어간다.

    //sqlSessionFactory는 Mybatis설정과 데이터베이스 연결을 관리한다.
    //외부파일에 대한 설정(Mapper, config)
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));

        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();//위에서 만든걸 사용할 수 있도록 객체화
            assert sqlSessionFactory != null;
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        } catch (Exception e) {
             //e.printStackTrace();
            log.error("Exception [Err_Msg]: {}", e.getMessage()); //에러가 발생한 이유
            //log.error("Exception [Err_Location] : {}", e.getStackTrace()[0]); //에러가 발생한 이유
        }
        return null;
    }
}


//결론
//HikariCP 및 DataSource는 데이터베이스 연결을 설정하고 관리하고,
//SqlSessionFactory와 SqlSession은 MyBatis를 사용하여 SQL을 실행하고 관리한다.











package com.example.ex01.mapper;

import com.example.ex01.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void getTimeTest() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void insertTest() {
        ProductVO productVO = new ProductVO();
        productVO.setProductName("고구마");
        productVO.setProductPrice(3000L);
        productVO.setProductStock(100L);

        productMapper.insert(productVO);

        log.info("insert_product:{}", productVO);


    }
    @Test
    public void selectTest(){
        ProductVO productVO = productMapper.select(1L); //1번째 select를 가져와서 productVO에 담겠다.
        log.info(productVO.toString());
        assertThat(productVO.getProductPrice()).isEqualTo(3000L);
    }

    @Test
    public void updateTest(){
        ProductVO productVO = productMapper.select(1L);
        productVO.setProductName("감자");
        productVO.setProductPrice(1300L);
        productVO.setProductStock(200L);

        productMapper.update(productVO);

    }
    @Test
    public void deleteTest(){
       productMapper.delete(1L);

    }

    @Test
    public void selectAllTest(){
        productMapper.selectAll().stream().map(ProductVO::toString).forEach(log::info);
        // 데이터 베이스에서 Product 객체 목록을 검색하고, 각 Product 객체를 문자열로 변환 후 로그에 기록
        // stream : 스트림은 데이터를 처리할 때 루프를 직접 작성하지 않고도 간결한 코드로 데이터 조작 및 처리를 할 수 있게 해주는 Java의 기능

        
        //검증 isIn, isEqualTo,contain 등등.. 검증할 수 있는 요소들이 많다.
        assertThat(productMapper.selectAll().get(0).getProductName()).isEqualTo("감자");
        // assertThat(productMapper.selectAll().get(0).getProductName()).contains("감자"); 문자열검사
        // assertThat(productMapper.select(2L)).isIn(productMapper.selectAll());  왼쪽구문 (2L)이 오른쪽 구문(productMapper.selectAll)안에 있는지 확인
    }
}

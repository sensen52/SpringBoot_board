package com.example.ex01.mapper;

import com.example.ex01.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }
}

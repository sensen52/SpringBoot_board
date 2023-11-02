package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;


    @Test
    public void select(){
        assertThat(boardMapper.select(1L).getBoardTitle()).isEqualTo("테스트 제목1");    }
    @Test
    public void selectTest(){
        assertThat(boardMapper.select(3L).getBoardContent()).isEqualTo("수정된 내용");
    }

    //size:갯수 몇개 있는지
    @Test
    public void selectAllTest(){
        assertThat(boardMapper.selectAll().size()).isEqualTo(3);
    }

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목4");
        boardVO.setBoardWriter("테스트4");
        boardVO.setBoardContent("테스트 내용4");

        boardMapper.insert(boardVO);

        assertThat(boardVO.getBoardId()).isEqualTo(4L);

    }

    @Test
    public void deleteTest() {
        boardMapper.delete(4L);
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(3L);
        boardVO.setBoardContent("수정된 내용");
        boardMapper.update(boardVO);
    }

}















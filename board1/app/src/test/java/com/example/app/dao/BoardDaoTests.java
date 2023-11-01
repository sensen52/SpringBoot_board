package com.example.app.dao;

import com.example.app.domain.dao.BoardDAO;
import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardDaoTests {
    @Autowired
    BoardDAO boardDAO;

    @Test
    public void findByIdTest(){
        assertThat(boardDAO.findById(5L).getBoardContent()).isEqualTo("수정된 내용");
    }

    @Test
    public void findAllTest(){
        assertThat(boardDAO.findAll().size()).isEqualTo(3);
    }

    @Test
    public void saveTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목4");
        boardVO.setBoardWriter("테스트4");
        boardVO.setBoardContent("테스트 내용4");

        boardDAO.save(boardVO);

        assertThat(boardVO.getBoardId()).isEqualTo(5L);
    }

    @Test
    public void deleteTest() {
        boardDAO.delete(5L);
    }

    @Test
    public void setBoardTest(){
        BoardVO boardVO = boardDAO.findById(5L);
        boardVO.setBoardContent("수정된 내용");
        boardDAO.setBoard(boardVO);
    }
}

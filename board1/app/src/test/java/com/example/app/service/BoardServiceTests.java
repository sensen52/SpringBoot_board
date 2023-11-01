package com.example.app.service;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    BoardService boardService;

    @Test
    public void getBoardTest(){
        assertThat(boardService.getBoard(6L).getBoardContent()).isEqualTo("수정된 내용");
    }

    @Test
    public void getListTest(){
        assertThat(boardService.getList().size()).isEqualTo(3);
    }

    @Test
    public void writeTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목4");
        boardVO.setBoardWriter("테스트4");
        boardVO.setBoardContent("테스트 내용4");

        boardService.write(boardVO);

        assertThat(boardVO.getBoardId()).isEqualTo(6L);
    }

    @Test
    public void removeTest() {
        boardService.remove(6L);
    }

    @Test
    public void modifyTest(){
        BoardVO boardVO = boardService.getBoard(6L);
        boardVO.setBoardContent("수정된 내용");
        boardService.modify(boardVO);
    }
}

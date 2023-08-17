package org.zerock.toyproject_drama.service;

import org.zerock.toyproject_drama.domain.TodoVO;
import org.zerock.toyproject_drama.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);

    // 가장 최근에 등록된 TodoVO가 우선적으로 나올 수 있게 추가(Todomapper.xml)
    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);


}

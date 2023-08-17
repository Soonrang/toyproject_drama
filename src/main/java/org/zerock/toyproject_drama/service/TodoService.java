package org.zerock.toyproject_drama.service;

import org.zerock.toyproject_drama.dto.PageRequestDTO;
import org.zerock.toyproject_drama.dto.PageResponseDTO;
import org.zerock.toyproject_drama.dto.TodoDTO;

// TodoMapper와 TodoController 사이에 서비스 계층을 설계해서 적용한다.
// TodoService 인터페이스를 먼저 설계하고 이를 구현한 TodoServiceImpl을 스프링 빈으로 처리
public interface TodoService {

    // 여러개의 파라미터를 받기보다는 TodoDTO로 묶어서 전달 받도록 하였다.
    void register(TodoDTO todoDTO);

    // List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}

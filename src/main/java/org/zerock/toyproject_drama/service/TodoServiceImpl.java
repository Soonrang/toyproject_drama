package org.zerock.toyproject_drama.service;

//TodoService 인터페이스를 구현하는 TodoServiceImpl이다
// 여기에 의존성을 주입하여 데이터베이스 처리를 한다.
// TodoMapper DTO, VO 변환을 처리하는 MdoelMapper주입

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.toyproject_drama.domain.TodoVO;
import org.zerock.toyproject_drama.dto.PageRequestDTO;
import org.zerock.toyproject_drama.dto.PageResponseDTO;
import org.zerock.toyproject_drama.dto.TodoDTO;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {

        log.info(modelMapper);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class );

        log.info(todoVO);

        todoMapper.insert(todoVO);

    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

//    @Override
//    public List<TodoDTO> getAll() {
//
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo -> modelMapper.map(vo, TodoDTO.class))
//                .collect(Collectors.toList());
//
//        return dtoList;
//    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;

    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}

package org.zerock.toyproject_drama.dto;

import lombok.Builder;

import java.util.List;

//제너릭으로 구성, 다른 객체를 이용해서 PageResponseDTO를 구성할 수 있게한다. (게시판, 회원정보 등 페이징 처리시)
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    //시작페이지 번호
    private int start;

    //끝 페이지번호
    private int end;

    //이전 페이지의 존재여부
    private boolean prev;
    //다음 페이지의 존재여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;

        this.end = (int)(Math.ceil(this.page/10.0)) * 10;
        this.start = this.end -9;
        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}



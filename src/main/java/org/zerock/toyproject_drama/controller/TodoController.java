package org.zerock.toyproject_drama.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.toyproject_drama.dto.PageRequestDTO;
import org.zerock.toyproject_drama.dto.TodoDTO;
import org.zerock.toyproject_drama.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
@Log4j2
public class TodoController {
    // 최종적으로 TodoService를 주입, 연동!
    private final TodoService todoService;

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register");
    }

//    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list");
//        model.addAttribute("dtoList", todoService.getAll());
//    }


    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST todo Register");

        if (bindingResult.hasErrors()) {
            log.info("에러가 있어요(hasError)");
            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);
        todoService.register(todoDTO);
        return "redirect:/todo/list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("--------------remove---------------");
        log.info("tno: " + tno);
        todoService.remove(tno);
        return  "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info(("has error"));
            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info((todoDTO));
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){

        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

}
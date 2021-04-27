package com.spring_sandbox.spring_sandbox.dto.model;

import java.util.List;

import com.spring_sandbox.spring_sandbox.dto.interfaces.HttpModelResponse;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class PageModel<T, M> implements HttpModelResponse{
    private Long total;
    private Integer totalPaginas;
    private Integer tamanhoPagina;
    private Integer numeroPagina;
    private List<M> conteudo;

    public void setConteudo(Page<T> page){
        this.total = page.getTotalElements();
        this.totalPaginas = page.getTotalPages();
        this.tamanhoPagina = page.getSize();
        this.numeroPagina = page.getNumber();
    }

    public void setConteudoList(List<M> conteudo) {
        this.conteudo = conteudo;
    }

    protected PageModel(){}
}

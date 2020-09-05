package io.github.wesleyosantos91.backend.apifirst.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class RecursoCriadoEvent extends ApplicationEvent {

    private transient HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }

}
package com.gerensys.controller;

import com.gerensys.model.Pedido;
import com.gerensys.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public ModelAndView pedido() {
        ModelAndView andView = new ModelAndView("cadastro/cadastro-pedido");

        return andView;
    }

    @PostMapping("**/salvarpedido")
    public ModelAndView salvar(Pedido pedido) {

        pedidoRepository.save(pedido);

        ModelAndView andView = new ModelAndView("cadastro/cadastro-pedido"); //cliente irá para pagina de acompanhamento

        return andView;
    }
}

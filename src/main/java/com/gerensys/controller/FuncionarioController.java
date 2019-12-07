package com.gerensys.controller;

import java.util.Optional;

import com.gerensys.model.Funcionario;
import com.gerensys.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/cadastrofuncionarios")
    public ModelAndView cadastro() {
        ModelAndView andView = new ModelAndView("cadastro/cadastro-funcionario");

        return andView;
    }

    @PostMapping("**/salvarfuncionario")
    public ModelAndView salvar(Funcionario funcionario) {

        funcionarioRepository.save(funcionario);

        ModelAndView andView = new ModelAndView("listas/listar-funcionario");
        Iterable<Funcionario> funcAll = funcionarioRepository.findAll();
        andView.addObject("funcionarios", funcAll);

        return andView;
    }

    @GetMapping("/listafuncionarios")
    public ModelAndView funcionarios() {

        ModelAndView andView = new ModelAndView("listas/listar-funcionario");
        Iterable<Funcionario> funcAll = funcionarioRepository.findAll();
        andView.addObject("funcionarios", funcAll);

        return andView;
    }

    @GetMapping("/editarfuncionario/{idfuncionario}")
    public ModelAndView editar(@PathVariable("idfuncionario") Long idfuncionario) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(idfuncionario);
        ModelAndView andView = new ModelAndView("editar/editar-funcionario");
        andView.addObject("objfuncionario", funcionario.get());

        return andView;

    }

    @PostMapping("**/salvaredit")
    public ModelAndView atualiza(Funcionario funcionario) {

        funcionarioRepository.save(funcionario);

        ModelAndView andView = new ModelAndView("listas/listar-funcionario");
        andView.addObject("objfuncionario", new Funcionario());
        Iterable<Funcionario> funcAll = funcionarioRepository.findAll();
        andView.addObject("funcionarios", funcAll);

        return andView;
    }

    @GetMapping("/removerfuncionario/{idfuncionario}")
    public ModelAndView excluir(@PathVariable("idfuncionario") Long idfuncionario) {

        funcionarioRepository.deleteById(idfuncionario);
        ModelAndView andView = new ModelAndView("listas/listar-funcionario");
        Iterable<Funcionario> funcAll = funcionarioRepository.findAll();
        andView.addObject("funcionarios", funcAll);

        return andView;
    }

    @PostMapping("**/pesquisarfuncionario")
    public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) {

        ModelAndView andView = new ModelAndView("listas/listar-funcionario");
        andView.addObject("funcionarios", funcionarioRepository.findFuncionarioByName(nomepesquisa));

        return andView;
    }
    
    @GetMapping("/visualizarfuncionario/{idfuncionario}")
    public ModelAndView detalhes(@PathVariable("idfuncionario") Long idfuncionario) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(idfuncionario);
        ModelAndView andView = new ModelAndView("detalhe/detalhe-funcionario");
        andView.addObject("objfuncionario", funcionario.get());

        return andView;

    }

}

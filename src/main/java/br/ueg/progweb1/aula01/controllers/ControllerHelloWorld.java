package br.ueg.progweb1.aula01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "${api.version}/aula01")
public class ControllerHelloWorld {
    @GetMapping()
    public String HelloWorld(){
        return "Olá mundo";
    }
    @PostMapping(path = "/{nome}")
    public String HelloWorld(@PathVariable(name = "nome") String nome){
        return "Olá "+nome+"!";
    }
    @PostMapping(path = "/body")
    public String HelloWorldBody(@RequestBody String nome){
        return "Olá "+nome+"!";
    }
    @PostMapping(path = "/body2")
    public List<String> HelloWorldBody(@RequestBody List<String> pListNome){
        StringBuilder builder = new StringBuilder();
        List<String> nomeList = Objects.isNull(pListNome) ?
                new ArrayList<>() :
                pListNome ;

//        nomeList.forEach(s -> {
//            builder.append("Olá "+s +" ");
//        });
        List<String> novaLista = new ArrayList<>();
        for (int i = 0; i < nomeList.size(); i++) {
            novaLista.add( "Olá "+ nomeList.get(i));
        }

        //return builder.toString();
        return novaLista;
    }

}

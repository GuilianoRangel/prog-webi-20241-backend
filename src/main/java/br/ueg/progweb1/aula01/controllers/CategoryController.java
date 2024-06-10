package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.mapper.CategoryMapper;
import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.model.dtos.CategoryDTO;
import br.ueg.progweb1.aula01.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/category")
@CrossOrigin()
public class CategoryController extends GenericCRUDController<
        CategoryDTO,
        CategoryDTO,
        CategoryDTO,
        CategoryDTO,
        Category,
        Long,
        CategoryService,
        CategoryMapper
        > {


}

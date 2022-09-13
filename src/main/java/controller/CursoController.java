package controller;

import model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CursoController {
    private List<Curso> cursos;

    @PostConstruct
    public void init(){
        cursos = new ArrayList<>();
        cursos.add(new Curso("Spring",23,"tarde"));
        cursos.add(new Curso("java",333,"tarde"));
        cursos.add(new Curso("mongo",12,"mañana"));
        cursos.add(new Curso("oracle",212,"tarde"));
        cursos.add(new Curso("AI",65,"mañana"));
        cursos.add(new Curso("devops",83,"noche"));
    }

    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso(){
        return new Curso("Java", 100, "mañana");
    }

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursos(){
        return cursos;
    }

    @GetMapping(value = "cursos/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursos(@PathVariable("nombre") String nombre){
        List<Curso> auxList = new ArrayList<>();

        for(Curso c : cursos){
            if(c.getNombre().contains(nombre)){
                auxList.add(c);
            }
        }

        return auxList;
    }

    @DeleteMapping(value = "curso/{nombre}")
    public void eliminarCurso(@PathVariable("nombre") String nombre){
        cursos.removeIf(c -> c.getNombre().equals(nombre));
    }

    @PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> guardarCurso(@RequestBody Curso curso){
        cursos.add(curso);
        return cursos;
    }

    @PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> actualizarCurso(@RequestBody Curso curso){
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNombre().equals(curso.getNombre())){
                cursos.set(i, curso);
                break;
            }
        }

        return cursos;
    }
}

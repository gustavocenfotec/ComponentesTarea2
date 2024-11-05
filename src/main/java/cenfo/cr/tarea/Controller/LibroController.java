package cenfo.cr.tarea.Controller;


import cenfo.cr.tarea.Entity.Libro;
import cenfo.cr.tarea.Service.ILibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private ILibroService libroService;

    Logger logger = LoggerFactory.getLogger(LibroController.class);

    @RequestMapping("/libro")
    public String home(Model model) { return "/libro/index"; }

    @RequestMapping("/libro/listar")
    public String listar(Model model) {
        List<Libro> libros = libroService.getLibros();
        model.addAttribute("libros", libroService.getLibros());
        return "/libro/listar";
    }


    @RequestMapping(value="/libro/insertar", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("libro", new Libro());
        return "/libro/insertar";
    }

    @RequestMapping(value="/libro/insertar", method = RequestMethod.POST)
    public String insertarAction(Libro libro,
                                 BindingResult result, Model model) {
        libroService.saveLibro(libro); return "/libro/index"; }


    @RequestMapping(value = "/libro/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable long id) {
        try {
            Libro libro = libroService.getLibro(id);
            model.addAttribute("libro", libro);
            model.addAttribute("id", libro.getId());
            model.addAttribute("titulo", libro.getTitulo());
            model.addAttribute("autor", libro.getAutor());
            model.addAttribute("fechaPublicacion", libro.getFechaPublicacion());
            model.addAttribute("editorial", libro.getEditorial());
            model.addAttribute("edicion", libro.getEdicion());
            return "/libro/editar";
        } catch (Exception e) {
            logger.error("Can't recover libro from database", e);
            return "notFound";
        }
    }

    @RequestMapping(value = "/libro/editar/{id}", method = RequestMethod.POST)
    public String guardarEdicion(Model model, @PathVariable long id,
                                 Libro editado, BindingResult result) {
        try {
            Libro libro = libroService.getLibro(id);
            libro.setTitulo(editado.getTitulo());
            libro.setAutor(editado.getAutor());
            libro.setFechaPublicacion(editado.getFechaPublicacion());
            libro.setEditorial(editado.getEditorial());
            libro.setEdicion(editado.getEdicion());
            libroService.saveLibro(libro);
            return "/libro/index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value = "/libro/borrar/{id}", method = RequestMethod.GET)
    public String prepararBorrado(Model model, @PathVariable long id) {
        try {
            Libro libro = libroService.getLibro(id);
            model.addAttribute("libro", libro);
            return "/libro/borrar";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }


    @RequestMapping(value = "/libro/borrar/{id}", method = RequestMethod.POST)
    public String ejecutarBorrado(Model model, @PathVariable long id) {
        try {
            libroService.deleteLibro(id);
            return "/libro/index";
        } catch (Exception e) {
            logger.error("No puedo borrar", e);
            return "error";
        }
    }

}

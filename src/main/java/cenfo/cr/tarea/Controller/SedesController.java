package cenfo.cr.tarea.Controller;


import cenfo.cr.tarea.Entity.Sede;

import cenfo.cr.tarea.Service.IRegionService;
import cenfo.cr.tarea.Service.ISedeService;
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
public class SedesController {


    @Autowired
    private ISedeService sedeService;
    @Autowired
    private IRegionService regionService;

    Logger logger = LoggerFactory.getLogger(SedesController.class);

    @RequestMapping("/sede")
    public String home(Model model) { return "/sede/index"; }

    @RequestMapping("/sede/listar")
    public String listar(Model model) {
        List<Sede> sedes = sedeService.getSedes();
        model.addAttribute("sedes", sedeService.getSedes());
        return "/sede/listar";
    }


    @RequestMapping(value="/sede/insertar", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("sede", new Sede());
        model.addAttribute("regiones", regionService.getRegiones());
        return "/sede/insertar";
    }

    @RequestMapping(value="/sede/insertar", method = RequestMethod.POST)
    public String insertarAction(Sede sede,
                                 BindingResult result, Model model) {
        sedeService.saveSede(sede); return "/sede/index"; }


    @RequestMapping(value = "/sede/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable long id) {
        try {
            Sede sede = sedeService.getSede(id);
            model.addAttribute("sede", sede);
            model.addAttribute("id", sede.getId());
            model.addAttribute("nombreSede", sede.getNombreSede());
            model.addAttribute("provincia", sede.getProvincia());
            model.addAttribute("canton", sede.getCanton());
            model.addAttribute("distrito", sede.getDistrito());
            model.addAttribute("fechaApertura", sede.getFechaApertura());
            model.addAttribute("idRegion", sede.getIdRegion());
            model.addAttribute("regiones", regionService.getRegiones());
            return "/sede/editar";
        } catch (Exception e) {
            logger.error("Can't recover Sede from database", e);
            return "notFound";
        }
    }

    @RequestMapping(value = "/sede/editar/{id}", method = RequestMethod.POST)
    public String guardarEdicion(Model model, @PathVariable long id,
                                 Sede editado, BindingResult result) {
        try {
            Sede sede = sedeService.getSede(id);
            sede.setNombreSede(editado.getNombreSede());
            sede.setProvincia(editado.getProvincia());
            sede.setCanton(editado.getCanton());
            sede.setDistrito(editado.getDistrito());
            sede.setFechaApertura(editado.getFechaApertura());
            sede.setIdRegion(editado.getIdRegion());
            sedeService.saveSede(sede);
            return "/sede/index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value = "/sede/borrar/{id}", method = RequestMethod.GET)
    public String prepararBorrado(Model model, @PathVariable long id) {
        try {
            Sede sede = sedeService.getSede(id);
            model.addAttribute("sede", sede);
            return "/sede/borrar";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }


    @RequestMapping(value = "/sede/borrar/{id}", method = RequestMethod.POST)
    public String ejecutarBorrado(Model model, @PathVariable long id) {
        try {
            sedeService.deleteSede(id);
            return "/sede/index";
        } catch (Exception e) {
            logger.error("No puedo borrar", e);
            return "error";
        }
    }
}

package cenfo.cr.tarea.Controller;



import cenfo.cr.tarea.Entity.Region;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @Autowired
    private ISedeService sedeService;

    Logger logger = LoggerFactory.getLogger(RegionController.class);

    @RequestMapping("/region")
    public String home(Model model) { return "/region/index"; }

    @RequestMapping("/region/listar")
    public String listar(Model model) {
        List<Region> regions = regionService.getRegiones();
        model.addAttribute("regiones", regionService.getRegiones());
        return "/region/listar";
    }


    @RequestMapping(value="/region/insertar", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("region", new Region());
        return "/region/insertar";
    }

    @RequestMapping(value="/region/insertar", method = RequestMethod.POST)
    public String insertarAction(Region region,
                                 BindingResult result, Model model) {
        regionService.saveRegion(region); return "/region/index"; }

    @RequestMapping(value="/region/listarSedes/{id}", method = RequestMethod.GET)
    public String listar_productos(Model model, @PathVariable long id) {
        List<Sede> sedes_region = new ArrayList<>();

        for (Sede sede : sedeService.getSedes()) {
            if (sede.getIdRegion() == id) {

                sedes_region.add(sede);
            }
        }

        model.addAttribute("region", regionService.getRegion(id));
        model.addAttribute("sedes", sedes_region);
        return "/region/listarSedes";
    }

}

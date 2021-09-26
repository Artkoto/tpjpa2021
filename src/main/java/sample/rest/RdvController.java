package sample.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.domain.Rdv;
import sample.service.RdvService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Controller
@RequestMapping("/rdv")
public class RdvController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RdvService rdvService;
	
	/**
	 * POST /create  --> Create a new user in the database.
	 */
	@PostMapping("/create-rdv")
	@ResponseBody
	public Rdv create( Rdv rdv) {
		
		rdvService.saveRdv(rdv);
		return rdv; 
	}

	/**
	 * DELETE /delete  --> Delete the user having the passed id.
	 */
	@DeleteMapping("/delete/{rdvId}")
	@ResponseBody
	public void delete(@PathVariable Long rdvId) {
			
		rdvService.deleteRdv(rdvId);
	 
	}

	  /**
	   * GET /get-all  --> Return the list of rdvs
	   *rdvDao
	   */
	  @GetMapping("/rdvs")
	  @ResponseBody
	  public Iterable<Rdv> getAllRdv() {
	    
		return rdvService.getRdvs();
	    
	  }
	  


	  /**
	   * GET /get-all  --> Return the list of appointment
	   *
	   */
	  @GetMapping("/get-rdv/{rdvId}")
	  @ResponseBody
	  public Rdv getById(@PathVariable Long rdvId) {
	    
		return rdvService.getRdv(rdvId).get();
	    
	  }

	/**
     *  GET appointment by title
     * @param title : title of the appointment
     * @return
     */
	@GetMapping("/get-by-title/{title}")
	@ResponseBody
    public Rdv getByTitle(@PathVariable String title)  {
        return rdvService.getByTitle(title);
    }
	  
	  /**
	   * PUT /update  --> Update 
	   * database having the passed id.
	   */

	  @PutMapping("/update/rdv")
	  @ResponseBody
	  public Rdv updateRdv(Rdv rdv) {
	
		rdvService.saveRdv(rdv);
		return rdv;
	  }
	   

}
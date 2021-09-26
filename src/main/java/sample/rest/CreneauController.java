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
import org.springframework.web.bind.annotation.RestController;

import sample.service.CreneauService;
import sample.domain.Creneau;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@RestController
@RequestMapping("/crenel")
public class CreneauController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CreneauService creneauService ;

	/**
	 * POST /create --> Create a new user in the database.
	 */
	@PostMapping("/create-crenel/")
	@ResponseBody
	public Creneau create(Creneau crenel) {

		creneauService.saveCreneau(crenel);
		return crenel;
	}

	/**
	 * DELETE /delete --> Delete the user having the passed id.
	 */
	@DeleteMapping("/delete/{crenelId}")
	@ResponseBody
	public void delete(@PathVariable Long crenelId) {

		creneauService.deleteCreneau(crenelId);

	}

	/**
	 * GET /get-all --> Return the list of crenels
	 *
	 */
	@GetMapping("/get-all-crenels")
	@ResponseBody
	public Iterable<Creneau>  getAllcreneaux() {
		return creneauService.getCreneaux();

	}

	/**
	 * GET /get-all --> Return the list of crenels
	 *
	 */
	@GetMapping("/get-crenel-by-id/{crenelId}")
	@ResponseBody
	public Creneau getById(@PathVariable Long crenelId) {

		return creneauService.getCreneau(crenelId).get();

	}

	/**
	 * PUT /update --> Update database having the passed id.
	 */
	@PutMapping("/update/crenel")
	@ResponseBody
	public Creneau updateCrenel(Creneau creneau) {

		creneauService.saveCreneau(creneau);
		return creneau;
	}

}

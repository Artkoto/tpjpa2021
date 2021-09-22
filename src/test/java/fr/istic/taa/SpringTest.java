package fr.istic.taa;
import fr.istic.taa.model.Client;
import fr.istic.taa.service.CreneauService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import fr.istic.taa.service.RdvService;
import fr.istic.taa.service.UserService;

import fr.istic.taa.repository.UsersRepository;

import fr.istic.taa.model.Creneau;
import fr.istic.taa.model.Prof;
import fr.istic.taa.model.Rdv;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.HashSet;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringTest {
    @Autowired
    public MockMvc mockMvc;
    @Autowired
    UsersRepository userDAO;
    @Autowired
    UserService userService;
    @Autowired
    CreneauService creneauService;
    @Autowired
    RdvService rdvService ;



    @BeforeEach
    void init() {

        try {
            //Alimentation de la bdd
            //Users (PROF, CLIENT, CRENEAU, RDV)
            Prof user01 = new Prof();
                user01.setName("Koa");
                user01.setLastname("Arnaud");
                user01.setEmail("test1@gmail.com");

            Client user02 = new Client();
                user02.setName("Yao");
                user02.setLastname("Parfait");
                user02.setEmail("test2@istic.fr");

            Prof user03 = new Prof();
                user03.setName("Konan");
                user03.setLastname("Ilan");
                user03.setEmail("test3@gmail.com");


            Prof user04 = new Prof();
            user04.setName("Karim");
            user04.setLastname("Ougueur");
            user04.setEmail("futuringenieur@gmail.com");
            //Cerneau
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
            Creneau creneau01 = new Creneau();
                creneau01.setDebut(formater.parse("26-09-2021"));
                creneau01.setFin(formater.parse("26-09-2021"));
            Creneau creneau02 = new Creneau();
                creneau02.setDebut(formater.parse("23-09-2021"));
                creneau02.setFin(formater.parse("24-09-2021"));
            Creneau creneau03 = new Creneau();
                creneau03.setDebut(formater.parse("25-09-2021"));
                creneau03.setFin(formater.parse("27-09-2021"));
            user01.setCreneaux(new  HashSet<Creneau>() {{
                add(creneau01);
                add(creneau03);
            }});
            user03.setCreneaux(new HashSet<Creneau>() {{
                add(creneau02);
                add(creneau03);
            }});

            //les RDV
            Rdv rdv01 = new Rdv();
                rdv01.setTitle("prise d'information");
                rdv01.setCreneau(creneau01);
                rdv01.setProf(user01);
                rdv01.setClient(user02);
            Rdv rdv02 = new Rdv();
                rdv02.setTitle("inscription");
                rdv02.setCreneau(creneau02);
                rdv02.setProf(user03);
                rdv02.setClient(user02);


            creneauService.saveCreneau(creneau01);
            creneauService.saveCreneau(creneau02);
            creneauService.saveCreneau(creneau03);
            userService.saveUser(user01);
            userService.saveUser(user02);
            userService.saveUser(user03);
            rdvService.saveRdv(rdv01);
            rdvService.saveRdv(rdv02);


//            userService.deleteUser(user01.getId());
 //           userService.deleteUser(user02.getId());
//            userService.deleteUser(user03.getId());
//            rdvService.deleteRdv(rdv01.getId());


             userService.modifyUser(user01.getId(), user04);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void contextLoads()  throws Exception {
        mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[1].name", is("Yao")));
    }
}


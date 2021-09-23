/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa;

import sample.domain.*;
import sample.repositories.UserDao;
import sample.service.CreneauService;
import sample.service.RdvService;
import sample.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

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
    UserDao userDAO;
    
    @Autowired
    UserService userService;
    
    @Autowired
    CreneauService creneauService;
    
    @Autowired
    RdvService rdvService ;

    @BeforeEach
    void init() throws Exception{
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
            userService.saveUser(user01);
            userService.saveUser(user02);
            userService.saveUser(user03);
            rdvService.saveRdv(rdv01);
            rdvService.saveRdv(rdv02);

          /*  userService.deleteUser(user01.getId());
            userService.deleteUser(user02.getId());
            userService.deleteUser(user03.getId());*/
            userService.updateUser(user04);
          System.out.println(" getRdvs  : " + rdvService.getRdvs());
        //    System.out.println(" getUser test : " + userDAO.findOne(user01.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("##############################################");
        }
    }

    @Test
    void contextLoads()  throws Exception {
        mockMvc.perform(get("/user/users"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is(" votre Nom")));
    } 
}
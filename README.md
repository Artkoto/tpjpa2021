# partie 3 de tp3 

# Binôme : 
        - Karim Ougueur 
        - Yao Arnaud Akoto


[Topic Springboot TAA ](https://docs.google.com/document/d/1seSUjRonPMPO4lFu6VzCuO4H8U7QB__Oqo1kso6UIY4/edit)



# Installation :


Pour démarrer la base de données avec docker.

```bash
# On démarre un conteneur qui aura comme nom some-mysql et comme mot de passe my-secret-pw
# On exporte le port 3306 sur notre host pour que notre programme Java puisse dialoguer facilement avec la base de données

docker run --name some-mysql  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
```

Pour démarrer phpmyadmin avec docker.

```bash
docker run --name myadmin -d --link some-mysql:db -p 8082:80 phpmyadmin
```


Php myadmin est accessible alors sur http://localhost:8082

Votre base de données est configurable sur localhost sur le port 3306, utilisateur root, password my-secret-pw

Pour redémarrer les containers après un reboot de la machine. Stopper mysql puis.
```bash
docker start some-mysql myadmin 
```

Pour supprimer les containers
```bash
docker stop myadmin some-mysql
docker rm myadmin some-mysql
```


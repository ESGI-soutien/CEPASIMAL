# CEPASIMAL
## PROJET - SPRINT 1
### SUJET
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### NOTIONS
+ Classes
+ Attributs
+ Constructeurs
+ Getters / Setters
+ Types simples / complexes
+ toString()
+ main() et Sortie console System.out()

### OBJECTIFS
Le Sprint 1 doit permettre de poser les bases de l'affrontement. Un joueur doit pouvoir attaquer un autre joueur.

Les joueurs sont caractérisés par un **nom** ainsi que d'une statistique pour leur **nombre de points de vie**. Chaque joueur possède également une **attaque**.

Les attaques sont caractérisées par un **nom** et un **score de dégats**.

Le programme doit pouvoir simuler un tour d'un affrontement entre deux joueurs. Durant un tour, la console doit d'abord afficher les informations relatives **aux deux joueurs** grâce à un **toString()**.

La console doit ensuite afficher les informations relatives à **l'attaque du joueur attaquant**. Dans le contexte du Sprint 1, le joueur attaquant sera **toujours le premier joueur**. Le joueur n'attaque qu'une seule fois.

La console doit ensuite afficher les informations relatives au **second joueur** pour constater la **modification de son nombre de points de vie après l'attaque du premier joueur**.

Le programme se termine à ce moment. Il n'y a **aucune** intervention humaine durant ce programme.

### RESULTATS
![image](https://cdn.discordapp.com/attachments/620180603589099525/1035627703715512440/unknown.png)

Il est possible d'arriver à ce résultat de différentes manières cependant il faut garder en tête que votre but est de trouver **la solution qui couvre le plus grand nombre de cas possibles**.

Par exemple on pourrait tout simplement afficher le contenu de l'image ci-dessus via un unique System.out sans aucune logique de programmation derrière, tel un "Hello World" aux hormones. Cependant cette façon de faire ne couvre qu'un seul cas unique et ne nous intéresse pas ici.

Les valeurs que vous donnez pour le nom des joueurs, des attaques, le nombre de points de vie et le score d'attaque ne sont pas importantes. Il n'est pas nécessaire de recréer à l'identique le résultat de programme de l'image ci-dessus, sauf si cela vous aide bien entendu.

Bon courage ! 🌟
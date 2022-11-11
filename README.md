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

---

# CEPASIMAL
## PROJET - SPRINT 2
### SUJET
Le but de ce projet est de créer un programme simulant un jeu d'affrontement, entre deux joueurs, au tour par tour, style RPG.

### NOTIONS
+ Boucles de contrôles
+ Imports de bibliothèques
+ Listes
+ Entrée console Scanners
+ StringBuilders

### OBJECTIFS
Le Sprint 2 doit permettre à l'utilisateur **d'intéragir** avec le programme jeu via une **interface de commandes**. Le programme de jeu doit permettre de jouer plusieurs tours jusqu'à la fin de la partie. Les actions des joueurs à chaque tour sont désormais déterminées par un choix de l'utilisateur via la console. La méthode utilisée pour choisir est libre mais nous vous recommandons de demander à recevoir le nom de l'action écrit dans la console.

Les joueurs possèdent maintenant une liste d'attaques, la seule contrainte étant que la liste **ne peut pas être vide**. Les caractéristiques d'une attaque restent les mêmes.

Un tour de jeu commence toujours par le rappel de la valeur de points de vie actuelle de chacun des joueurs. Les joueurs agissent ensuite l'un après l'autre. Les joueurs agissent toujours dans le même ordre à chaque tour. Une fois que les deux joueurs ont terminé leur tour, le tour suivant commence et ce, jusqu'à la fin de la partie.

Les actions possibles des joueurs durant un tour sont les suivantes :
+ **Analyser** : la console affiche les informations relatives à l'adversaire du joueur. Cette action **ne mets pas fin au tour du joueur**.
+ **Attaquer** : L'utilisateur doit choisir une attaque à effectuer sur l'adversaire via la console **parmis la liste d'attaque du joueur**. La console doit afficher les informations relatives à l'attaque choisie. Cette action **mets fin au tour du joueur**.
+ **Fuir** : Le joueur abandonne le combat. Cette action **mets fin au tour du joueur ainsi qu'à la partie**.

La partie se termine soit si l'un des deux joueurs fuit ou bien si les points de vie d'un des deux joueurs tombent à 0.

Les valeurs de vos variables ne sont pas importantes. Ce qui compte vraiment, c'est la solidité de votre code et de votre architecture.

Bon courage ! 🌟
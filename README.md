# Test technique Unibet

Bienvenue dans mon résultat au test technique d'Unibet ! Ce dépot représente donc mon test technique pour Unibet. 

## Table des matières

- [Services](#services)
- [Batchs](#batchs)
- [Exécution Générale](#exécution-générale)
- [Améliorations potentielle](#améliorations-potentielle)
- [Dépendances](#dépendances)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Services

### Service GET Events

Le service GET Events permet de récupérer tous les events

### Service GET Event

Le service GET Event via id permet de récupérer un event via son id

### Service POST Bet

Le service permet de POST un bet

### Service PUT Selection

Le service permet de modifier une selection via son id. Le résultat de la sélection modifié sera automatiquement sur result = WON

## Batchs

### Batch PayerLesParis

Le batch permet de payer les paris gagnants. Il vérifier les sélections, puis si une sélection est sur WON il regarde les bets qui avait choisi cette sélection. 
Derrière le batch récupère l'id du customer qui a fait le bet et lui donne un montant d'argent.

## Exécution Générale

Expliquez ici comment exécuter votre projet de manière générale. Incluez des instructions pour le déploiement, la configuration, et le lancement de votre application.

Exemple :

1. Clonez le projet depuis le référentiel Git :

   ```bash
   git clone https://github.com/Bojamin/unibet-test-technique.git
   
2. Mettez vous a la racine src pour lancer la commande 

   ```bash 
   mvn spring-boot:run
   
3. Une fois le projet lancé connectez vous à la BDD en ligne pour voir les différentes tables (les logins sont dans le application.properties)

   http://localhost:8887/h2-console/

4. Derrière installez Insomnia et importer les requêtes qui sont dans le dépot. 

5. Vous pouvez maintenant profitez d'un mini Unibet

## Améliorations potentielle

Pour la suite, voici ce que je compte faire avec un peu plus de temps. 

- Créer les nouveaux cas de tests

- Créer et rendre fonctionnel les erreurs (comme l'erreur 600) liées à Unibet. 

- Réparer le batch d'update des selections qui ne fonctionne pas (ici j'ai plutot créer un service pour un gain de temps et ne pas supprimer ce que vous aviez fait)

- Fermer les bets et selections qui ont déjà étés traitées par mon batch de paiement

- Améliorer toute la documentation, construire un swagger propre (swagger actuel au lancement http://localhost:8887/v2/api-docs)

## Dépendances ajoutées 

- Les dépendances pour les batchs 

- Les dépendances pour les swagger

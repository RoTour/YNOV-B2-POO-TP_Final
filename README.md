# YNOV-B2-POO-TP_Final
From : Robin TOURNE (B2 info)

# IMPORTANT 
Note from the developer:
    - Database fields should be filled in French (especially Residence.Type and Service.name; else the getApartmentsWhitPool and the getApartmentsWithMountain ==> hard coded value to complete the questions)



# Instructions

Projet personnel
Ce projet personnel sera évalué.

Pour cela il faudra créer un projet et placer les sources dans GIT.

Me donner le lien GIT (ou m'inviter sur le projet avec l'adresse : reshad.khoyratty@ynov.com) le plus rapidement possible pour que je puisse suivre l'évolution des développements. Je surveillerai les commit.

Il s'agit d'un projet individuel il ne faut pas travailler à plusieurs, s'il y a des similitudes de code je m'en apercevrais.

Le sujet
Il s'agit de développer un logiciel à destination de sociétés de location d'appartements de vacances.

Les appartements sont regroupés dans une résidence ou bien un village vacances.

Les appartements possèdent un certain nombres de caractéristiques : nombre de couchage, surface, équipement pour bébé, la climatisation.

Un appartement va posséder aussi un tarif de location à la journée et des dates de réservation/disponibilité.

Un Village vacances (ou résidence) va se situer dans un pays (France, Espagne) dans une région, aura une adresse et une position GPS. Il aura des informations sur le type de lieu : mer, océan, montagne. Il possèdera des services: piscine, spa, garderie, wifi.

Une réservation d'appartement pour un client de la société de location pourra être créée pour un appartement sur une période donnée.

Réaliser une conception / un découpage en classe métier afin d'enregistrer toutes les informations en base de données. (5 points)

Réaliser en Java un serveur qui expose une API Rest qui va permettre de créer, lire, mettre à jour et supprimer toutes les entités enregistrées en base. (CRUD : https://fr.wikipedia.org/wiki/CRUD). Il faudra implémenter les couches service, d'accès aux données et le Mapping Objet-Relationnel. (5 points)

Activer Swagger afin de tester l'API Rest.

Compléter l'API Rest afin de retourner les requêtes suivantes :

- tous les Villages Vacances/résidence pour un pays donné (1 point) OK

- tous les appartements pour une région donnée (1 point) OK

- tous les appartements dont la résidence possède une piscine (1 point) OK

- tous les appartements qui sont à la montagne (1 point) OK
  
- tous les appartements qui sont libres entre 2 dates données (1 point) OK

- tous les appartements qui sont libres sur une durée entre 2 dates fournies (Par exemple : je cherche un appartement libre pendant 10j entre le 1er juillet et le 15 aout) (1 point) OK

- une liste de Dto (qui contiendra l'id de l'appartement et le prix) pour tous les appartements qui sont libres entre 2 dates données qui se trouvent à la mer, triés par ordre de prix croissant de prix (1 point) OK

- une liste de Dto (qui contiendra l'id de l'appartement, le nom du Village Vacance et le prix) pour tous les appartements qui sont libres entre 2 dates données qui se trouvent à la mer, dans une région données, avec la piscine, avec au moins 4 couchages, triés par ordre de prix croissant de prix (1 point)

La qualité du code et l'organisation du projet seront évalués (2 points)
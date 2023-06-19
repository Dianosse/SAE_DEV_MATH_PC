# SAE_DEV_MATH_PriodeD
SAE de dev et math de la période D

## Explication :
Ce projet avait pour but de nous faire réaliser des systèmes de stockage de graphes orientés valués. Il y avait aussi pour but de créer et d'optimiser un algorithme de Dijkstra. La phase de test se passait via des graphes donnés et qui avaient pour but de tester l'optimisation de notre code, l'interface IGrpaheTest utilisait des tests qui ne sont plus disponibles actuellement (nous devons laisser cette classe même si elle n'est plus utilisable, car elle est demandée dans le rendu du projet). 

Pour tester le projet, il suffit de télécharger le .zip de ce répertoire et de mettre au même niveau dans l'architecture du projet src, graphes et réponses. Ensuite, il suffit de lancer un test sur la fonction testerTousLesGraphes de la classe DijkstraTest.

### Les classes/interfaces fournies par notre chargé de projet sont : 
- DijkstraTest, DijkstraTools
- Graphe, IGrpahe, IGrpaheConst, IGrpaheTest
- CheminATrouver, GraphDirectoryImporter, GraphImporter, Main

## Groupe :
- LIEVRE Antoine 
- MACABREY Luc
- WANG Félix 
- NURMINEN Lucas


### Les 4 classes ont été réalisées

- GrapheHHAdj : Dijkstra passe pour tous les graphes ayant comme base cette classe.
- GrapheLAdj :  Dijkstra passe pour tous les graphes ayant comme base cette classe.
- GrapheLArcs : Dijkstra va jusqu'aux graphes ayant environ 10 000 sommets.
- GrapheMAdj : Dijkstra va jusuq'aux graphes ayant environ 1 000 sommets.

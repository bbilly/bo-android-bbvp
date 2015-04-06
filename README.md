# Back Office du projet Android Esaip
L'appli Android est disponible <a href="https://github.com/bbilly/Projet-Android-ESAIP">ici</a>

URL pour s'enregistrer et accéder à l'application : <a href="http://dev.baptistebilly.com/bbvp_register/">http://dev.baptistebilly.com/bbvp_register/</a>


<h3>Liste des WS (GET)</h3>
<ul>
  <li>
  /connect/{pseudo}/{password} : renvoie "true" si le pseudo et le password sont corrects
  </li>
  <li>
  /messages : renvoie tous les messages sous forme d'un tableau JSON
  </li>
  <li>
  /envoyer/{pseudo}/{password}/{message} : ajout d'un message
  </li>
</ul>

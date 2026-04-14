# HelloToast – LAB 1
Application Android simple pour s’entraîner avec les composants UI et les événements (clics).
## Objectif:
Le but de ce laboratoire est de créer une application Android simple permettant de :
- Manipuler des composants graphiques (UI)
- Gérer les interactions utilisateur
- Comprendre les événements (clics sur les boutons)
## Description de l’application
L’application contient :
- Un TextView pour afficher un compteur
- Un bouton pour afficher un message Toast
- Un bouton pour incrémenter le compteur
## Fonctionnalités:
- Afficher un message Toast ("HELLOOOOO!!!") lorsque l’utilisateur clique sur le bouton ***TOAST***.
- Incrémenter un compteur affiché à l’écran lorsque l’utilisateur clique sur le bouton ***COUNT***.
## Technologies utilisées:
- Android Studio
- Java
- XML (pour l’interface utilisateur)
- API minimum : 24 (Android 7.0)
## Aperçu de l’application:
<img width="244" height="543" alt="intf2" src="https://github.com/user-attachments/assets/885ba116-9141-4de3-9f8e-48526bb6194e" />

<img width="240" height="546" alt="intf" src="https://github.com/user-attachments/assets/35c6d526-140d-4edd-9ba3-529d6c373d87" />

### Interface de l’application en fonctionnement :
  - Compteur dynamique (ici : 33)
  - Bouton TOAST → affiche un message
  - Bouton COUNT → incrémente le compteur
  -  Message Toast affiché en bas de l’écran
## Structure du projet:
### **res/layout/activity_main.xml** – Interface utilisateur
Ce fichier définit toute l’interface graphique de l’application.
- Structure générale:
  
  - Un **LinearLayout** principal organise les éléments verticalement
  - Un second conteneur interne (**main_panel**) permet de styliser l’interface (fond, bordures, etc.)
- Bouton TOAST:
  <Button android:id="@+id/btn_toast" ... />
  - Placé en haut de l’écran
  - Permet d’afficher un message Toast
  - Style personnalisé avec @drawable/button_top
- Zone centrale (compteur):
  <TextView android:id="@+id/display_value" ... />
  - Affiche la valeur du compteur (initialement 0)
  - Centré dans un conteneur stylisé (counter_frame)
  - Taille de texte élevée pour une meilleure visibilité
- Bouton COUNT:
  <Button android:id="@+id/btn_count" ... />
  - Placé en bas de l’écran
  - Incrémente le compteur
  - Style personnalisé avec @drawable/button_bottom
- Personnalisation:
  - Couleurs définies dans @color/...
  - Arrière-plans personnalisés avec @drawable/...
  - Utilisation de marges, padding et tailles pour améliorer le design
    
### **res/drawable/** – Personnalisation visuelle
Les fichiers dans le dossier drawable/ définissent l’apparence graphique des composants (boutons, conteneurs, etc.) à l’aide de formes XML (shape) et de compositions (layer-list).

- **button_top.xml** et **button_bottom.xml**:

Ces fichiers définissent le style des boutons **TOAST** et **COUNT**.
  
    -- Utilisation d’un layer-list pour superposer plusieurs couches:
      
      - Couche principale :
                - Forme rectangulaire avec dégradé (gradient)
                - Coins arrondis (corners)
                - Bordure (stroke)
        
      - Couche interne :
                - Ajoute un effet visuel (légère transparence + bordure interne)
                - Crée une impression de profondeur / effet glass
                  
    -- Les couleurs du dégradé changent (@color/btn_top_* vs @color/btn_bottom_*) pour distinguer visuellement les deux boutons
        
- **counter_frame.xml**:
  
Définit le cadre autour du compteur.

    -- Structure en layer-list avec deux couches :
    
      - Couche externe :
              - Fond coloré (solid)
              - Bordure épaisse (stroke)
              - Coins arrondis
              
      - Couche interne :
              - Bordure plus fine et décalée
              - Effet visuel de double contour
              
=> Permet de mettre en valeur la zone du compteur au centre de l’écran.

- **main_panel.xml**:
  
Définit le conteneur principal de l’interface.

    -- Forme simple (shape) rectangulaire
    -- Fond uniforme (solid)
    -- Coins arrondis pour un design moderne
    -- Bordure (stroke) pour délimiter le contenu
    -- padding interne pour espacer les éléments

=> Sert de cadre global pour organiser visuellement toute l’interface.

### **res/values/** – Ressources globales
- **colors.xml**:

Ce fichier centralise toutes les couleurs utilisées dans l’application afin de garantir une cohérence visuelle et de faciliter la maintenance.

    -- Arrière-plan général:
      - screen_bg : couleur de fond principale de l’écran
      - panel_bg : fond du conteneur principal (main_panel)
      - panel_stroke : bordure du conteneur
    
    -- Zone du compteur:
      - counter_bg : fond du cadre du compteur
      - counter_stroke : bordure externe
      - counter_text : couleur du texte affiché
    
    -- Boutons:
      - btn_top_start, btn_top_end : dégradé du bouton TOAST
      - btn_bottom_start, btn_bottom_end : dégradé du bouton COUNT
      - button_stroke : bordure commune des boutons
      - button_text : couleur du texte des boutons
      
### **java/ma/ens/hellotoast/MainActivity.java** - Logique de l’application
Ce fichier est l’activité principale lancée au démarrage de l’application.
Elle initialise l’interface, récupère les composants graphiques et définit les actions associées aux boutons.

      -- Initialisation:
        La méthode onCreate() est appelée au démarrage de l’activité.
          - L’interface est chargée avec setContentView(R.layout.activity_main)
          - Les composants sont récupérés avec findViewById() :
            - display_value → affiche le compteur
            - btn_toast → déclenche le message Toast
            - btn_count → incrémente le compteur
            
      -- Gestion du compteur:
        - Une variable mCurrentValue stocke la valeur du compteur (initialisée à 0)
        - Une méthode dédiée incrementScore() est utilisée pour :
          - incrémenter la valeur
          - mettre à jour l’affichage avec setText()

      -- Affichage du Toast: 
        - Un écouteur d’événement (setOnClickListener) est associé au bouton TOAST.
        - Lors du clic :
          - un message temporaire "HELLOOOOO!!!" est créé avec Toast.makeText(...)
          - il est affiché brièvement à l’écran avec Toast.makeText(...).show()
## Conclusion:
Ce projet illustre les concepts fondamentaux du développement Android :

  - séparation entre interface (XML) et logique (Java)
  - gestion des événements utilisateur
  - mise à jour dynamique de l’interface

Il met également en évidence l’utilisation des ressources (drawable, values) pour créer une interface personnalisée et maintenable.

Ce laboratoire constitue une base solide pour aborder des fonctionnalités plus avancées dans le développement mobile.

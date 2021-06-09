package Apps;

import moteurJeu.*;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.InterruptedException;
import java.lang.Thread;
import java.util.ArrayList;

public class JeuZ implements Jeu {

    /**
     * un jeu connait un aventurier, une liste de monstres, un labyrinthe et un
     * boolean actionEnCours pour limiter le nombre de deplacements par seconde
     */
    private Personnage aventurier;
    private Labyrinthe labyrinthe;
    private boolean actionEnCours;
    private ArrayList<Monstre> listDeMonstres;

    /**
     * constructeur parametre qui permet de creer un jeu
     * 
     * @param p = personnage qui sera l aventurier du jeu ce constructeur lance une
     *          erreur si le personnage donne n est pas instancie
     * @param l = le labyrinthe dans lequel evolue les personnages et les monstres
     */
    public JeuZ(Personnage p, Labyrinthe l) {
        if (p != null) {
            this.aventurier = p;
        } else {
            throw new Error("Un jeu DOIT connaitre un personnage");
        }
        if (l != null) {
            this.labyrinthe = l;
        } else {
            throw new Error("Un jeu DOIT connaitre un labyrinthe");
        }
        actionEnCours = false;
        listDeMonstres = new ArrayList<Monstre>();
        listDeMonstres.add(new Troll(14, 5));
        listDeMonstres.add(new Troll(1, 18));
    }

    /**
     * methode qui permet de faire evoluer le personnage et les monstres
     * 
     * @param commande = direction du deplacement pour le personnage
     */
    public void evoluer(Commande commande) {

        if (!actionEnCours) {
            this.deplacerMonstres();
            actionEnCours = true;

            // si on tente de prendre une arme, on va essayer de prendre une arme sur la
            // case actuelle
            if (commande.prendreArme) {
                this.tentePrendreArme(this.aventurier.getX(), this.aventurier.getY());
            }

            // si on tente d attaquer, on va essayer d attaquer les entites a portee
            if (commande.attaquer) {
                this.tenteAttaquePerso();
            }

            // si le perso c est bien deplace on gere les pieges
            if (this.deplacerPerso(commande)) {

                // on recupere les coordonnees actuelles du personnage
                this.arriveSurUnPiege(this.aventurier);
            }
            TimerTask timerTask = new CooldownAction();
            Timer timer = new Timer(true);
            timer.schedule(timerTask, 0);
        }
    }

    public void deplacerMonstres() {

        for (int i = 0; i < listDeMonstres.size(); i++) {
            int x = (int) Math.ceil(Math.random() * 4);

            // on recupere les coordonnees de l aventurier
            int xMonstre = listDeMonstres.get(i).getX();
            int yMonstre = listDeMonstres.get(i).getY();

            int xPerso = this.aventurier.getX();
            int yPerso = this.aventurier.getY();

            // on verifie que l aventurier puisse bien aller a la case souhaitee
            if (x == 1) {
                if (xMonstre > 0 && this.labyrinthe.estAccessible(xMonstre - 1, yMonstre)
                        && ((xMonstre - 1 != xPerso || yMonstre != yPerso))) {
                    listDeMonstres.get(i).deplacer(-1, 0);
                }
            } else if (x == 2) {
                if (xMonstre < this.labyrinthe.getTailleX() - 1 && this.labyrinthe.estAccessible(xMonstre + 1, yMonstre)
                        && ((xMonstre + 1 != xPerso || yMonstre != yPerso))) {
                    listDeMonstres.get(i).deplacer(1, 0);
                }
            } else if (x == 3) {
                if (yMonstre > 0 && this.labyrinthe.estAccessible(xMonstre, yMonstre - 1)
                        && ((xMonstre != xPerso || yMonstre - 1 != yPerso))) {
                    listDeMonstres.get(i).deplacer(0, -1);
                }
            } else if (x == 4) {
                if (yMonstre < this.labyrinthe.getTailleY() - 1 && this.labyrinthe.estAccessible(xMonstre, yMonstre + 1)
                        && ((xMonstre != xPerso || yMonstre + 1 != yPerso))) {
                    listDeMonstres.get(i).deplacer(0, 1);
                }
            } else {
                ;
            }
        }
    }

    /**
     * methode qui permet de deplacer le personnage
     * 
     * @param commande = commande utilisateur
     * @return vrai que si le deplacement a eu lieu
     */
    public boolean deplacerPerso(Commande commande) {

        boolean res = false;

        // on recupere les coordonnees de l aventurier
        int xPerso = this.aventurier.getX();
        int yPerso = this.aventurier.getY();

        // on verifie que l aventurier puisse bien aller a la case souhaitee
        boolean ok = true;
        if (commande.gauche) {
            if (xPerso > 0 && this.labyrinthe.estAccessible(xPerso - 1, yPerso)) {
                for (int i = 0; i < listDeMonstres.size(); i++) {
                    if ((xPerso - 1 != listDeMonstres.get(i).getX() || yPerso != listDeMonstres.get(i).getY()))
                        ok = false;
                }
                if (ok)
                    this.aventurier.deplacer(-1, 0);
            }
        } else if (commande.droite) {
            if (xPerso < this.labyrinthe.getTailleX() - 1 && this.labyrinthe.estAccessible(xPerso + 1, yPerso)) {
                for (int i = 0; i < listDeMonstres.size(); i++) {
                    if ((xPerso + 1 != listDeMonstres.get(i).getX() || yPerso != listDeMonstres.get(i).getY()))
                        ok = false;
                }
                if (ok)
                    this.aventurier.deplacer(1, 0);
            }
        } else if (commande.haut) {
            if (yPerso > 0 && this.labyrinthe.estAccessible(xPerso, yPerso - 1)) {
                for (int i = 0; i < listDeMonstres.size(); i++) {
                    if ((xPerso != listDeMonstres.get(i).getX() || yPerso - 1 != listDeMonstres.get(i).getY()))
                        ok = false;
                }
                if (ok)
                    this.aventurier.deplacer(0, -1);
            }
        } else if (commande.bas) {
            if (yPerso < this.labyrinthe.getTailleY() - 1 && this.labyrinthe.estAccessible(xPerso, yPerso + 1)) {
                for (int i = 0; i < listDeMonstres.size(); i++) {
                    if ((xPerso != listDeMonstres.get(i).getX() || yPerso + 1 != listDeMonstres.get(i).getY()))
                        ok = false;
                }
                if (ok)
                    this.aventurier.deplacer(0, 1);
            }
        }

        // on verifie que le deplacement a bien eu lieu
        if (xPerso != this.aventurier.getX() || yPerso != this.aventurier.getY()) {
            res = true;
        }

        return (res);
    }

    /**
     * getDistance retourne la distance entre un monstre et le joueur
     * 
     * @param monstre
     * @return
     */
    public int getDistance(Monstre monstre) {
        int distanceX = this.xPerso - monstre.getX();
        if (distanceX < 0) {
            distanceX = -(distanceX);
        }
        int distanceY = (this.yPerso - monstre.getY());
        if (distanceY < 0) {
            distanceY = -(distanceY);
        }
        int distance = (distanceX + distanceY);
        return (distance);
    }

    /**
     * methode qui permet de tenter de prendre une arme par le joueur
     * 
     * @param x = abscisse de la case sur la quelle on tente de prendre une arme
     * 
     * @param y = ordonnee de la case sur la quelle on tente de prendre une arme
     */
    public void tentePrendreArme(int x, int y) {
        // on essaye de prendre une arme sur la case du labyrinthe
        this.aventurier.prendreArme(this.labyrinthe.getArmeCase(x, y));

    }

    /**
     * methode qui permet d attaquer les entite proches du personnage
     */
    public void tenteAttaquePerso() {
        // on essaye d attaquer les entites proches
        for (int i = 0; i < this.listDeMonstres.size(); i++) {
            if (this.aventurier.estDistant(this.listDeMonstres.get(i) <= this.aventurier.getPortee())) {
                this.aventurier.attaquer(this.listDeMonstres.get(i));
            }
        }
    }

    /**
     * methode qui permet de savoir si une entite arrive sur un piege
     * 
     * @param e = entite a verifier
     */
    public void arriveSurUnPiege(Entite e) {

        // on recupere les coordonnees de l entite
        int xEntite = e.getX();
        int yEntite = e.getY();

        // on regarde si la case est un piege
        if (this.labyrinthe.estUnPiege(xEntite, yEntite)) {
            // si c est le cas l entite prend des degats
            e.prendreDegats(3);
        }

    }

    /**
     * methode qui permet de savoir si le jeu est fini le jeu s arrete si le
     * personnage meurt
     * 
     * @return vrai que si le jeu est fini
     */
    public boolean etreFini() {
        return (this.aventurier.etreMort());
    }

    /**
     * getter aventurier du jeu
     * 
     * @return aventurier du jeu
     */
    public Personnage getAventurier() {
        return (this.aventurier);
    }

    /**
     * getter labyrinthe
     * 
     * @return
     */
    public Labyrinthe getLabyrinthe() {
        return (this.labyrinthe);
    }

    public ArrayList<Monstre> getListeMonstre() {
        return listDeMonstres;
    }

    class CooldownAction extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            actionEnCours = false;
        }
    }
}
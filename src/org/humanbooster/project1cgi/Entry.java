package org.humanbooster.project1cgi;

import org.humanbooster.project1cgi.model.*;
import org.humanbooster.project1cgi.model.cars_manager.Car;
import org.humanbooster.project1cgi.model.cars_manager.Parking;
import org.humanbooster.project1cgi.model.enumerations.Dessert;
import org.humanbooster.project1cgi.model.enumerations.Drink;
import org.humanbooster.project1cgi.model.enumerations.MainCourse;
import org.humanbooster.project1cgi.model.enumerations.Order;
import org.humanbooster.project1cgi.model.heritage.Animal;
import org.humanbooster.project1cgi.model.heritage.Cheval;
import org.humanbooster.project1cgi.model.heritage.Tigre;
import org.humanbooster.project1cgi.model.printer_repartition.Computer;
import org.humanbooster.project1cgi.model.printer_repartition.Printer;
import org.humanbooster.project1cgi.model.printer_repartition.Repartitor;

import java.util.*;
import java.util.stream.Collectors;

public class Entry {

    public static void main(String[] args) {

        testAnimaux();

    }

    public static void testAnimaux() {

        Animal a = new Animal();
        Cheval c = new Cheval();
        Tigre t = new Tigre();

        a.manger();
        c.manger();
        t.manger();

    }

    public static void resto() {
        Order order1 = new Order("#123", Drink.COKE, MainCourse.BEEF, Dessert.ICECREAM);
        Order order2 = new Order("#456", Drink.BEER, MainCourse.CHICKEN, Dessert.CHOCOSNACK);

        System.out.println(order1);
        System.out.println(order1.totalPrice());
        System.out.println(order2);
        System.out.println(order2.totalPrice());
    }

    public static void testPrinterRepartition() {
        Repartitor repartitor = Repartitor.getInstance();
        repartitor.addPrinter(new Printer("HP 6650"));
        repartitor.addPrinter(new Printer("Epson 3150"));
        repartitor.addPrinter(new Printer("Canon 5050"));

        Computer c1 = new Computer("Poste 1");
        Computer c2 = new Computer("Poste 2");
        Computer c3 = new Computer("Poste 3");

        c1.print();
        c3.print();
        c2.print();
        c2.print();
        c2.print();
        c3.print();
        c1.print();
        c2.print();
        c3.print();
        c3.print();
        c1.print();
        c1.print();
        c2.print();
        c3.print();
    }

    public static void testCarsManager() {
        Car c1 = new Car("BA-123-AB", "Citroën", 100);
        Car c2 = new Car("AB-321-BA", "Citroën", 80);
        Car c3 = new Car("AA-111-AA", "Peugeot", 70);

        Parking park = new Parking("Jeanne d'Arc", "Toulouse", "Place Jeanne d'Arc");

        park.add(c1);
        park.add(c2);
        park.add(c3);

        System.out.println(park);
        System.out.println(Car.compare(c1, c2));
        System.out.println(park.countByBrand("Peugeot"));
    }

    public static void testStream() {
        List<ComputerOld> ordis = Arrays.asList(new ComputerOld(3, "HP"), new ComputerOld(5, "PB"), new ComputerOld(4, "HP"));
        List<ComputerOld> listModif = ordis.stream().filter(v -> v.getModel().equals("HP"))
                                                 .map(v -> new ComputerOld(v.getFrequency() * 1000, v.getModel()))
                                                 .collect(Collectors.toList());

        for (ComputerOld computer : listModif) {
            System.out.println(computer);
        }
    }

    public static void orcsTeam() {

        HashMap<Orc, ArrayList<Orc>> teams = new HashMap<>();

        Orc chef1 = new Orc("Lourk", 70, 18);
        Orc chef2 = new Orc("Jarkil", 65, 20);

        teams.put(chef1, new ArrayList<>(Arrays.asList(new Orc("a1", 50, 12), new Orc("b1", 50, 12), new Orc("c1", 50, 12))));
        teams.put(chef2, new ArrayList<>(Arrays.asList(new Orc("a2", 50, 12), new Orc("b2", 50, 12), new Orc("c2", 50, 12))));

//        int i = 0;
//        for (Map.Entry<Orc, ArrayList<Orc>> orcTeam : teams.entrySet()) {
//            i++;
//            System.out.println("Equipe " + i + " :");
//            System.out.println("Chef : " + orcTeam.getKey().getName());
//            System.out.println("Membres :");
//            for (Orc orc : orcTeam.getValue()) {
//                System.out.println("- " + orc.getName());
//            }
//        }

        int i = 0;
        for (Orc chef : teams.keySet()) {
            i++;
            System.out.println("Equipe " + i + " :");
            System.out.println("Chef : " + chef.getName());
            System.out.println("Membres :");
            for (Orc orc : teams.get(chef)) {
                System.out.println("- " + orc.getName());
            }
        }

    }

    public static void carSet() {
        HashSet<CarOld> set = new HashSet<>();

        set.add(new CarOld("Rouge", "Citroën", "C3"));
        set.add(new CarOld("Blanc", "Citroën", "Berlingo"));
        set.add(new CarOld("Bleu", "Citroën", "Berlingo"));
        set.add(new CarOld("Vert", "Peugeot", "208"));

        for (CarOld car : set) {
            System.out.println(car);
        }
    }

    public static void orcsList() {
        Scanner sc = new Scanner(System.in);

        boolean quitter = false;
        int choice = 0;

        ArrayList<Orc> list = new ArrayList<>();

        list.add(new Orc("Gourk", 50, 10));
        list.add(new Orc("Padac", 50, 12));
        list.add(new Orc("Molaf", 60, 15));

        while (!quitter) {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addOrc(list, sc);
                    break;
                case 2:
                    deleteOrc(list, sc);
                    break;
                case 3:
                    totalStrength(list);
                    break;
                case 4:
                    displayOrcs(list);
                    break;
                case 5:
                    quitter = true;
                    break;
                default:
                    System.out.println("Choix non valide.");
            }
        }

        System.out.println("Merci. Au revoir.");
    }

    public static void displayMenu() {
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 : Ajouter un Orc");
        System.out.println("2 : Supprimer un Orc");
        System.out.println("3 : Afficher la force totale");
        System.out.println("4 : Lister les Orcs");
        System.out.println("5 : Quitter");
    }

    public static void addOrc(ArrayList<Orc> list, Scanner sc) {
        String name;
        int health;
        int force;
        System.out.print("Nom : ");
        name = sc.nextLine();
        System.out.print("Points de vie : ");
        health = sc.nextInt();
        sc.nextLine();
        System.out.print("Force : ");
        force = sc.nextInt();
        sc.nextLine();

        Orc orc = new Orc(name, health, force);
        list.add(orc);
    }

    public static void deleteOrc(ArrayList<Orc> list, Scanner sc) {
        System.out.println("Quel Orc voulez-vous supprimer ? (Taper son nom)");
        for (Orc orc : list) {
            System.out.println("- " + orc.getName());
        }
        System.out.print("Nom de l'Orc à supprimer : ");

        String name;
        name = sc.nextLine();

//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            Orc orc = (Orc) it.next();
//            if (orc.getName().equalsIgnoreCase(name)) {
//                it.remove();
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                list.remove(i);
                i--;
            }
        }

        System.out.println(name + " supprimé, il reste " + list.size() + " Orcs.");
    }

    public static void totalStrength(ArrayList<Orc> list) {
        int strength = 0;
        for (Orc orc : list) {
            strength += orc.getForce();
        }
        System.out.println("Force cumulée : " + strength);
    }

    public static void displayOrcs(ArrayList<Orc> list) {
        for (Orc orc : list) {
            System.out.println(orc);
        }
    }

    public static void testOrcs() {
        Orc grugct = new Orc("Grugct", 50, 5);
        Orc jeanJacques = new Orc("Jean-Jacques", 60, 10);

        grugct.attack(jeanJacques);
        System.out.println(jeanJacques);

        jeanJacques.attack(grugct);
        System.out.println(grugct);
    }

    public static void testAjoutAge() {
        Person p1 = new Person("François");
        p1.name = "François";
        p1.age = 30;

        p1.addToAge(7);
        p1.afficheDetails();
        System.out.println(p1.getStatus());
        System.out.println(p1);
    }

    public static void compPrixVelos() {
        Bike b1 = new Bike("Levo", 26);
        b1.color = "red";
        b1.size = 26;
        b1.price = 1300;

        Bike b2 = new Bike("Kenevo", 26);
        b2.color = "black";
        b2.size = 26;
        b2.price = 800;

        b1.comparePrice(b2);
    }

    public static void affichagePersonne() {
        Person p1 = new Person("François");
        p1.name = "François";
        p1.age = 30;
        p1.afficheDetails();
    }

    public static void affichageVelo() {
        Bike b1 = new Bike("Levo", 26);
        b1.color = "red";
        b1.size = 26;
        b1.affiche();
    }

    public static void test(int param1, int param2) {
        System.out.println(param1 + param2);
    }

    public static void highestNumberGame() {
        Scanner scanner = new Scanner(System.in);

        int nb = 0;

        for (int i = 0; i < 6; i++) {
            System.out.print("Donnez un nombre : ");
            int nbUser = scanner.nextInt();
            scanner.nextLine();

            if (nb < nbUser || i == 0) {
                nb = nbUser;
            }
        }

        System.out.println("Le plus grand des nombres donnés est : " + nb + ".");
    }

    public static void guessNumberGame() {

        Random rand = new Random();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Nombre max ?");
            int nbMax = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Génération d'une valeur entre 1 et " + nbMax + ".");
            int no = rand.nextInt(nbMax) + 1;

            int nbEntre = 0;
            int tentatives = 0;

            while (nbEntre != no) {
                System.out.print("Devinez le nombre : ");
                nbEntre = scanner.nextInt();
                scanner.nextLine();

                tentatives++;

                if (nbEntre < no) {
                    System.out.println("Trop petit.");
                } else if (nbEntre > no) {
                    System.out.println("Trop grand.");
                } else {
                    System.out.println("Gagné !");
                }
            }

            System.out.println("Vous avez gagné en " + tentatives + " tentatives.");

            System.out.println("Continuer ?");

            if (scanner.nextLine().equals("n")) {
                break;
            }
        }

    }

    public static int nbCarac(String s) {
        return s.length();
    }

    public static int addition(int nb1, int nb2) {
        return nb1 + nb2;
    }

    public static int soustraction(int nb1, int nb2) {
        return nb1 - nb2;
    }

    public static int multiplication(int nb1, int nb2) {
        return nb1 * nb2;
    }

    public static int division(int nb1, int nb2) {
        return nb1 / nb2;
    }

    public static void calcul() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Veuillez choisir votre opération : ");
            String ope = scan.nextLine();

            System.out.print("Tapez le premier nombre : ");
            int nb1 = Integer.parseInt(scan.nextLine());

            System.out.print("Tapez le deuxième nombre : ");
            int nb2 = Integer.parseInt(scan.nextLine());

            switch (ope) {
                case "+", "add" -> System.out.println(addition(nb1, nb2));
                case "-", "moins" -> System.out.println(soustraction(nb1, nb2));
                case "*", "mult" -> System.out.println(multiplication(nb1, nb2));
                case "/", "div" -> System.out.println(division(nb1, nb2));
                default -> System.out.println("Opération invalide.");
            }

            System.out.println("Continuer ?");
            if (scan.nextLine().equals("n")) {
                break;
            }
        }
    }

    public static void affiche() {
        System.out.println("Bonjour");
    }

    public static void affiche(String text) {
        System.out.println(text);
    }

    public static void affiche(int num, String text) {
        System.out.println(text + " " + num);
    }

    public static void affiche(String text, int num) {
        System.out.println(text + " " + num);
    }

    public static String retourne(String text) {
        return text;
    }

    public static void testTableau() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Taille du tableau : ");
        int taille = sc.nextInt();
        sc.nextLine();

        int[] tab = new int[taille];

        for (int i = 0; i < taille; i++) {
            System.out.print("Valeur à l'indice " + i + " : ");
            tab[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();

        System.out.print("Votre tableau : ");
        for (int i : tab) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void tableauNotes() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de notes : ");
        int taille = sc.nextInt();
        sc.nextLine();

        int[] tab = new int[taille];

        for (int i = 0; i < taille; i++) {
            System.out.print("Note " + (i + 1) + " : ");
            tab[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();

        System.out.print("Moyenne : ");
        double total = 0;
        for (int i : tab) {
            total += i;
        }
        System.out.println(total / taille);
    }

    public static void doublonTableau(int tab[]) {
        int result[] = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            int count = 0;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] == tab[i]) {
                    count++;
                }
            }
            if (count > 0) {
                result[i] = tab[i];
            } else {
                result[i] = 0;
            }
        }

        System.out.println("Tableau des doublons : ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static void pendu(String s) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pendu !");
        System.out.println();


        while (s.contains(" ")) {

            int nbAttempts = 6;

            char word[] = s.substring(0, s.indexOf(" ")).toLowerCase().toCharArray();
            s = s.substring(s.indexOf(" ") + 1);

            for (int i = 0; i < word.length; i++) {
                System.out.print("_");
            }

            boolean[] answers = new boolean[word.length];
            int nbTrouve = 0;

            while (nbAttempts > 0 && nbTrouve < word.length) {

                System.out.println();

                System.out.println("Donnez une lettre (nombre d'essais restants : " + nbAttempts + ")");
                char lettre = sc.nextLine().charAt(0);
                boolean trouve = false;
                for (int i = 0; i < word.length; i++) {
                    if (word[i] == lettre) {
                        answers[i] = true;
                        trouve = true;
                        nbTrouve++;
                    }
                }

                if (!trouve) {
                    nbAttempts--;
                    System.out.println("Faux !");
                }

                for (int i = 0; i < answers.length; i++) {
                    if (answers[i]) {
                        System.out.print(word[i]);
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.println();
            }

            System.out.println();

            if (nbAttempts > 0) {
                System.out.println("Vous avez gagné ! Bravo !");
            } else {
                System.out.println("Vous avez perdu. Retentez votre chance.");
            }

        }
    }

    public static void decouverteClasses() {
        Bike b1 = new Bike("Commencal", 26);
        b1.size = 26;
        b1.color = "red";
        b1.model = "Commencal";

        Bike b2 = new Bike("Giant", 29);
        b2.size = 29;
        b2.color = "blue";
        b2.model = "Giant";

        System.out.println(b1.size);
        System.out.println(b1.color);
        System.out.println(b1.model);

        System.out.println(b2.size);
        System.out.println(b2.color);
        System.out.println(b2.model);

        Person p1 = new Person("François");
        p1.name = "François";
        p1.age = 30;

        Person p2 = new Person("François");
        p2 = null;

        System.out.println(p1.name);
        System.out.println(p1.age);

        System.out.println(p2.age);
    }

//    public static void premieresManip() {
//        System.out.println("Hello world!");
//        for (int i = 0 ; i < 10 ; i++) {
//            System.out.println("boucle");
//        }
//
//        System.out.println("Quel est votre nom ?");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        System.out.println("Merci, et votre âge ?");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Bonjour " + name + " ! Vous avez " + age + " ans.");
//
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//
//        if (name.equals("Chuck")) {
//            System.out.println("Yeah!");
//        } else {
//            System.out.println("Bleah!");
//        }
//
//        test(15, 16);
//
//        System.out.println("Quel est votre âge ?");
//        Scanner sc = new Scanner(System.in);
//        String age = sc.nextLine();
//        int ageNum = Integer.parseInt(age);
//        ageNum++;
//        System.out.println("Dans un an, vous aurez " + ageNum + " ans.");
//
//        int age = scanner.nextInt();
//        scanner.nextLine();
//
//        switch(age) {
//            case 60:
//                System.out.println("Retraite");
//                break;
//            case 20:
//                System.out.println("Jeunot");
//                break;
//            default:
//                System.out.println("L'âge n'est qu'un nombre.");
//        }
//
//        if (age >= 12 && age <= 27) {
//            System.out.println("Réduction jeune");
//        } else if (age >= 60) {
//            System.out.println("Réduction senior");
//        } else {
//            System.out.println("Pas de réduction");
//        }
//
//        boolean continuer = true;
//
//        while (continuer) {
//            System.out.println("Choisissez une couleur : vert, jaune, rouge");
//            String couleur = scanner.nextLine();
//
//            if (couleur.equals("vert")) {
//                System.out.println("La traduction en anglais de " + couleur + " est green.");
//            } else if (couleur.equals("jaune")) {
//                System.out.println("La traduction en anglais de " + couleur + " est yellow.");
//            } else if (couleur.equals("rouge")) {
//                System.out.println("La traduction en anglais de " + couleur + " est red.");
//            } else {
//                System.out.println("Je ne sais pas traduire le mot \"" + couleur + "\".");
//            }
//
//            System.out.println("Continuer ?");
//            continuer = scanner.nextLine().equals("y");
//        }
//
//        boolean continuer = true;
//
//        while (continuer) {
//            System.out.println("Choisissez une couleur : vert, jaune, rouge");
//            String couleur = scanner.nextLine();
//
//            switch(couleur) {
//                case "vert":
//                    System.out.println("La traduction en anglais de " + couleur + " est green.");
//                    break;
//                case "jaune":
//                    System.out.println("La traduction en anglais de " + couleur + " est yellow.");
//                    break;
//                case "rouge":
//                    System.out.println("La traduction en anglais de " + couleur + " est red.");
//                    break;
//                default:
//                    System.out.println("Je ne sais pas traduire le mot \"" + couleur + "\".");
//            }
//
//            System.out.println("Continuer ?");
//            continuer = scanner.nextLine().equals("y");
//
//        }
//
//        Scanner scanner = new Scanner(System.in);
//
//        int num = scanner.nextInt();
//        scanner.nextLine();
//
//        String test = num >= 18 ? "majeur" : "mineur";
//
//        System.out.println(test);
//
//        for (int i = 10 ; i > 0 ; i--) {
//            System.out.println(i);
//        }
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Début de la boucle.");
//            String s = scanner.nextLine();
//
//            if (s.equals("c")) {
//                System.out.println("Prochaine itération");
//                continue;
//            } else if (s.equals("e")) {
//                System.out.println("Sortie de la boucle");
//                break;
//            } else {
//                System.out.println("On continue.");
//            }
//
//            System.out.println("Fin de la boucle.");
//        }
//
//        System.out.println("Fin du programme.");
//
//        Scanner scanner = new Scanner(System.in);
//
//        Random rand = new Random();
//
//        for (int i = 0 ; i < 10 ; i++) {
//            System.out.println(rand.nextInt(10));
//        }
//
//        Random rand = new Random();
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Nombre max ?");
//            int nbMax = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Génération d'une valeur entre 1 et " + nbMax + ".");
//            int no = rand.nextInt(nbMax) + 1;
//
//            int nbEntre = 0;
//            int tentatives = 0;
//
//            while (nbEntre != no) {
//                System.out.print("Devinez le nombre : ");
//                nbEntre = scanner.nextInt();
//                scanner.nextLine();
//
//                tentatives++;
//
//                if (nbEntre < no) {
//                    System.out.println("Trop petit.");
//                } else if (nbEntre > no) {
//                    System.out.println("Trop grand.");
//                } else {
//                    System.out.println("Gagné !");
//                }
//            }
//
//            System.out.println("Vous avez gagné en " + tentatives + " tentatives.");
//
//            System.out.println("Continuer ?");
//
//            if (scanner.nextLine().equals("n")) {
//                break;
//            }
//        }
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Donnez un nombre : ");
//        int nb = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.print("Donnez un nombre : ");
//            int nbUser = scanner.nextInt();
//            scanner.nextLine();
//
//            if (nb < nbUser) {
//                nb = nbUser;
//            }
//        }
//
//        System.out.println("Le plus grand des nombres donnés est : " + nb + ".");
//
//        highestNumberGame();
//        guessNumberGame();
//
//        int val = addition(5, 13);
//        System.out.println(val);
//
//        System.out.println(nbCarac("Salut les amis !"));
//
//        calcul();
//
//        String test = "Je m'appelle Bertrand.";
//
//        System.out.println(test.substring(1, 6));
//
//        affiche();
//        affiche("Hello");
//        affiche("toto", 1);
//        affiche(1, "toto");
//
//        String texte = retourne("Yiiihaa !");
//        System.out.println(texte);
//
//        int[] liste = new int[11];
//
//        for (int i = 0; i < liste.length; i++) {
//            liste[i] = i * 2;
//        }
//
//        for (int i = 0; i < liste.length; i++) {
//            System.out.println(liste[i]);
//        }
//
//        System.out.println();
//
//        int tab[] = {21, 15, 30};
//
//        for (int i = 0; i < tab.length; i++) {
//            System.out.println(tab[i]);
//        }
//
//        for (int i : tab) {
//            System.out.println(i);
//        }
//
//        testTableau();
//
//        tableauNotes();
//
//        Random rand = new Random();
//
//        int tab[] = new int[10];
//
//        for (int i = 0; i < tab.length; i++) {
//            tab[i] = rand.nextInt(10) + 1;
//        }
//
//        doublonTableau(tab);
//
//        pendu("Motorhead test Bertrand ");
//    }

}

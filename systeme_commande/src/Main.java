import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Product product = new Product("Coca", 3.99);
        ArrayList<Product> commande = new ArrayList<>();
        commande.add(product);
        int choix = 0;

        while(choix != 5){

            System.out.println("********************");
            System.out.println("Magasin !");
            System.out.println("********************");

            System.out.println("Ajouter un produit ? (1)");
            System.out.println("Afficher tout les produits ? (2) ");
            System.out.println("Total de la commande (3) ");
            System.out.println("Supprimer un produit ? (4)");
            System.out.println("Quitter (5) ");

            System.out.print("Votre choix ? (1-5) : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix){
                case 1 -> {
                    System.out.print("Quel article voulez-vous ajoutez ? : ");
                    String nom = scanner.nextLine().toLowerCase();
                    System.out.print("Quel est sont prix ? : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    commande.add(new Product(nom, prix));
                    System.out.println("Article ajouter !");
                }
                case 2 ->{
                    if(commande.isEmpty()){
                        System.out.println("Votre Panier est vide !");
                    }else{
                        for(Product product1 : commande){
                            System.out.println("Vous avez dans votre panier : " + product1.getNom() + " " + " $ " + product1.getPrix());
                        }
                    }
                }
                case 3 ->{
                    if(commande.isEmpty()){
                        System.out.println("Votre panier est vide, votre Total est donc nul...");
                    }else{
                        double total = 0;
                        for(Product product1 : commande){
                            total = total + product1.getPrix();
                        }
                        System.out.println("Votre panier est :" + " $ " + total);
                    }
                }
                case 4 -> {
                    if (commande.isEmpty()) {
                        System.out.println("Votre panier est vide, rien à supprimer !");
                    } else {
                        System.out.print("Entrez le nom du produit à supprimer : ");
                        String nomASupprimer = scanner.nextLine().toLowerCase();
                        boolean removed = false;

                        for (int i = 0; i < commande.size(); i++) {
                            if (commande.get(i).getNom().equalsIgnoreCase(nomASupprimer)) {
                                commande.remove(i);
                                System.out.println("Produit supprimé : " + nomASupprimer);
                                removed = true;
                                break;
                            }
                        }

                        if (!removed) {
                            System.out.println("Produit introuvable dans le panier !");
                        }
                    }
                }
                case 5 ->
                {
                    System.out.println("Au revoir");
                    scanner.close();
                }
                    default -> System.out.println("Numéro invalide !!");
            }

        }

    }
}

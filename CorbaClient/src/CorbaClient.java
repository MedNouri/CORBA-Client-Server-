import MiniProjetApp. * ;
import org.omg.CosNaming. * ;
import org.omg.CORBA. * ;
import java.util. * ;

public class CorbaClient {

    public static void AfficherMenu() {
        System.out.println("-------------------------");
        System.out.println("1 - Conversion Km/h en M /s");
        System.out.println("2 - Conversion de degrés C° en F°");
        System.out.println("3 - Conversion des degrés de F° en C°");
        System.out.println("-----------------------------------");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            MiniProjet addobj = MiniProjetHelper.narrow(ncRef.resolve_str("ABC"));

            Scanner scanner = new Scanner(System. in );
            for (;;) {
                AfficherMenu();
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Veuillez entrer une valeur (Km/h):");
                        Double kilometers = 0.0;
                        try {
                            kilometers = scanner.nextDouble();
                        } catch(Exception i) {
                            System.out.println(" la valeur doit être un entier ");
                        }
                        double r = addobj.kmh_to_m(kilometers);
                        System.out.println("The result : " + r + " Miles");
                        break;
                    case 2:
                        System.out.println("Veuillez entrer une valeur (celsius):");
                        try {

                            Double celsius = scanner.nextDouble();
                            double f = addobj.celsius_to_fahrenheit(celsius);
                            System.out.println("The result : " + f + " F°");
                        } catch(NumberFormatException ex) {
                            System.out.println(" la valeur doit être un entier ");
                        }
                        break;
                    case 3:
                        System.out.println("Veuillez entrer une valeur (fahrenheit):");
                        try {
                            Double fahrenheit = scanner.nextDouble();
                            double c = addobj.celsius_to_fahrenheit(fahrenheit);
                            System.out.println("The result : " + c + " C°");
                        } catch(NumberFormatException ex) {
                            System.out.println(" la valeur doit être un entier ");
                        }

                        break;

                    default:
                        System.out.println("Choix invalide:");
                }
            }
        }
        catch(Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }

    }

}

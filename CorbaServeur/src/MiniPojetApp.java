import MiniProjetApp. * ;
import org.omg.CORBA. * ;

class MiniPojetApp extends MiniProjetPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implement kmh_to_m() method
    @Override
    public double kmh_to_m(double kilometers) {
        return kilometers / 1.6;
    }

    // implement celsius_to_fahrenheit() method
    @Override
    public double celsius_to_fahrenheit(double celsius) {
        return ((9 * celsius) / 5) + 32;
    }

    // implement fahrenheit_to_celsius() method
    @Override
    public double fahrenheit_to_celsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }
}

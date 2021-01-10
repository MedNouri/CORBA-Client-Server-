import MiniProjetApp. * ;
import org.omg.CosNaming. * ;
import org.omg.CORBA. * ;
import org.omg.PortableServer. * ;
import org.omg.PortableServer.POA;

public class CorbaServer {
    public static void main(String args[]) {
        try {
            // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            MiniPojetApp addobj = new MiniPojetApp();
            addobj.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
            MiniProjet href = MiniProjetHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("ABC");
            ncRef.rebind(path, href);

            System.out.println("Corba Server ready and waiting ...");

            // wait for invocations from corba clients
            for (;;) {
                orb.run();
            }
        }

        catch(Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Corba Server Exiting ...");

    }
}

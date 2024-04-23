import entity.Clients;
import entity.Masters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repo.ClientsRepozitory;


public class FunctionsBD {
    private static final Logger log= LogManager.getLogger(FunctionsBD.class);
    public static void ClientsOut(Clients clients){
        log.info(clients.getId() + " " + clients.getName() + " " + clients.getSurname());
    }
    public static void MastersOut(Masters masters){
        log.info(masters.getId() + " " + masters.getName() + " " + masters.getSurname());
    }
}

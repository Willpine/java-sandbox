package polimorfismo.interfaces62;

import polimorfismo.GenericDAO;

public class ArquivoDAOImpl implements GenericDAO {

    @Override
    public void save() {
        System.out.println("Salvando no arquivo.");
    }
    
}

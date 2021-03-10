package polimorfismo;

import polimorfismo.interfaces62.ArquivoDAOImpl;

public class DAOMain {
    public static void main(String[] args) {
        // Com a interface, precisamos apenas mudar o nome
        // da classe para direcionar o objeto à implementação certa.

        // ArquivoDAOImpl arquivoDAO = new ArquivoDAOImpl();

    //  Interface          |        Implementação que eu quero
        GenericDAO arquivoDAO = new ArquivoDAOImpl();
        arquivoDAO.save();
    }
}

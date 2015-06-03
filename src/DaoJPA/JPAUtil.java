/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fabiano
 */
public class JPAUtil {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("trabPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    
}

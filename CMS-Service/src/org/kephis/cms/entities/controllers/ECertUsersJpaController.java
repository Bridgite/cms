
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.kephis.cms.entities.ECertRoles;
import org.kephis.cms.entities.ECertUsers;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;

/**
 *
 * @author bobby
 */
public class ECertUsersJpaController implements Serializable {

    public ECertUsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertUsers ECertUsers) {
        if (ECertUsers.getECertRoleCollection() == null) {
            ECertUsers.setECertRoleCollection(new ArrayList<ECertRoles>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ECertRoles> attachedECertRoleCollection = new ArrayList<ECertRoles>();
            for (ECertRoles ECertRoleCollectionECertRolesToAttach : ECertUsers.getECertRoleCollection()) {
                ECertRoleCollectionECertRolesToAttach = em.getReference(ECertRoleCollectionECertRolesToAttach.getClass(), ECertRoleCollectionECertRolesToAttach.getId());
                attachedECertRoleCollection.add(ECertRoleCollectionECertRolesToAttach);
            }
            ECertUsers.setECertRoleCollection(attachedECertRoleCollection);
            em.persist(ECertUsers);
            for (ECertRoles ECertRoleCollectionECertRoles : ECertUsers.getECertRoleCollection()) {
                ECertRoleCollectionECertRoles.getECertUsersCollection().add(ECertUsers);
                ECertRoleCollectionECertRoles = em.merge(ECertRoleCollectionECertRoles);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECertUsers ECertUsers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertUsers persistentECertUsers = em.find(ECertUsers.class, ECertUsers.getId());
            Collection<ECertRoles> ECertRoleCollectionOld = persistentECertUsers.getECertRoleCollection();
            Collection<ECertRoles> ECertRoleCollectionNew = ECertUsers.getECertRoleCollection();
            Collection<ECertRoles> attachedECertRoleCollectionNew = new ArrayList<ECertRoles>();
            for (ECertRoles ECertRoleCollectionNewECertRolesToAttach : ECertRoleCollectionNew) {
                ECertRoleCollectionNewECertRolesToAttach = em.getReference(ECertRoleCollectionNewECertRolesToAttach.getClass(), ECertRoleCollectionNewECertRolesToAttach.getId());
                attachedECertRoleCollectionNew.add(ECertRoleCollectionNewECertRolesToAttach);
            }
            ECertRoleCollectionNew = attachedECertRoleCollectionNew;
            ECertUsers.setECertRoleCollection(ECertRoleCollectionNew);
            ECertUsers = em.merge(ECertUsers);
            for (ECertRoles ECertRoleCollectionOldECertRoles : ECertRoleCollectionOld) {
                if (!ECertRoleCollectionNew.contains(ECertRoleCollectionOldECertRoles)) {
                    ECertRoleCollectionOldECertRoles.getECertUsersCollection().remove(ECertUsers);
                    ECertRoleCollectionOldECertRoles = em.merge(ECertRoleCollectionOldECertRoles);
                }
            }
            for (ECertRoles ECertRoleCollectionNewECertRoles : ECertRoleCollectionNew) {
                if (!ECertRoleCollectionOld.contains(ECertRoleCollectionNewECertRoles)) {
                    ECertRoleCollectionNewECertRoles.getECertUsersCollection().add(ECertUsers);
                    ECertRoleCollectionNewECertRoles = em.merge(ECertRoleCollectionNewECertRoles);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ECertUsers.getId();
                if (findECertUsers(id) == null) {
                    throw new NonexistentEntityException("The eCertUsers with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertUsers ECertUsers;
            try {
                ECertUsers = em.getReference(ECertUsers.class, id);
                ECertUsers.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertUsers with id " + id + " no longer exists.", enfe);
            }
            Collection<ECertRoles> ECertRoleCollection = ECertUsers.getECertRoleCollection();
            for (ECertRoles ECertRoleCollectionECertRoles : ECertRoleCollection) {
                ECertRoleCollectionECertRoles.getECertUsersCollection().remove(ECertUsers);
                ECertRoleCollectionECertRoles = em.merge(ECertRoleCollectionECertRoles);
            }
            em.remove(ECertUsers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ECertUsers> findECertUsersEntities() {
        return findECertUsersEntities(true, -1, -1);
    }

    public List<ECertUsers> findECertUsersEntities(int maxResults, int firstResult) {
        return findECertUsersEntities(false, maxResults, firstResult);
    }

    private List<ECertUsers> findECertUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECertUsers.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ECertUsers findECertUsers(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertUsers.class, id);
        } finally {
            em.close();
        }
    }

    public int getECertUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertUsers> rt = cq.from(ECertUsers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.kephis.cms.entities.ECertRoles;
import org.kephis.cms.entities.ECertUsers;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.controllers.exceptions.PreexistingEntityException;
import org.kephis.cms.entities.controllers.exceptions.RollbackFailureException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
**
 *
 * @author bkimutai
 *
public class ECertUsersJpaController implements Serializable {

    public ECertUsersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    public ECertUsersJpaController(EntityManagerFactory emf) {
          this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertUsers ECertUsers) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try { 
            
            em = getEntityManager();
            em.getTransaction().begin();
            ECertRoles roleROLEID = ECertUsers.getRoleROLEID();
            if (roleROLEID != null) {
                roleROLEID = em.getReference(roleROLEID.getClass(), roleROLEID.getRoleid());
                ECertUsers.setRoleROLEID(roleROLEID);
            }
            em.persist(ECertUsers);
            if (roleROLEID != null) {
                roleROLEID.getECertUsersCollection().add(ECertUsers);
                roleROLEID = em.merge(roleROLEID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findECertUsers(ECertUsers.getUserid()) != null) {
                throw new PreexistingEntityException("ECertUsers " + ECertUsers + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECertUsers ECertUsers) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            
            em = getEntityManager();
            em.getTransaction().begin();
            ECertUsers persistentECertUsers = em.find(ECertUsers.class, ECertUsers.getUserid());
            ECertRoles roleROLEIDOld = persistentECertUsers.getRoleROLEID();
            ECertRoles roleROLEIDNew = ECertUsers.getRoleROLEID();
            if (roleROLEIDNew != null) {
                roleROLEIDNew = em.getReference(roleROLEIDNew.getClass(), roleROLEIDNew.getRoleid());
                ECertUsers.setRoleROLEID(roleROLEIDNew);
            }
            ECertUsers = em.merge(ECertUsers);
            if (roleROLEIDOld != null && !roleROLEIDOld.equals(roleROLEIDNew)) {
                roleROLEIDOld.getECertUsersCollection().remove(ECertUsers);
                roleROLEIDOld = em.merge(roleROLEIDOld);
            }
            if (roleROLEIDNew != null && !roleROLEIDNew.equals(roleROLEIDOld)) {
                roleROLEIDNew.getECertUsersCollection().add(ECertUsers);
                roleROLEIDNew = em.merge(roleROLEIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ECertUsers.getUserid();
                if (findECertUsers(id) == null) {
                    throw new NonexistentEntityException("The eCertUsers with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
             
            em = getEntityManager();
            em.getTransaction().begin();
            ECertUsers ECertUsers;
            try {
                ECertUsers = em.getReference(ECertUsers.class, id);
                ECertUsers.getUserid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertUsers with id " + id + " no longer exists.", enfe);
            }
            ECertRoles roleROLEID = ECertUsers.getRoleROLEID();
            if (roleROLEID != null) {
                roleROLEID.getECertUsersCollection().remove(ECertUsers);
                roleROLEID = em.merge(roleROLEID);
            }
            em.remove(ECertUsers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ECertUsers> findECertUsersEntities() {
        return findECertUsersEntities(true, -1, -1);
    }

    public List<ECertUsers> findECertUsersEntities(int maxResults, int firstResult) {
        return findECertUsersEntities(false, maxResults, firstResult);
    }

    private List<ECertUsers> findECertUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECertUsers.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ECertUsers findECertUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertUsers.class, id);
        } finally {
            em.close();
        }
    }

    public int getECertUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertUsers> rt = cq.from(ECertUsers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
**/
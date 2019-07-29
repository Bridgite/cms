/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.kephis.cms.entities.ECertUsers;
import java.util.ArrayList;
import java.util.Collection;
import org.kephis.cms.entities.ECertAuthorisation;
import org.kephis.cms.entities.ECertRoles;
import org.kephis.cms.entities.controllers.exceptions.IllegalOrphanException;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.controllers.exceptions.PreexistingEntityException;
import org.kephis.cms.entities.controllers.exceptions.RollbackFailureException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author bkimutai
 *
public class ECertRolesJpaController implements Serializable {

    public ECertRolesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertRoles ECertRoles) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (ECertRoles.getECertUsersCollection() == null) {
            ECertRoles.setECertUsersCollection(new ArrayList<ECertUsers>());
        }
        if (ECertRoles.getECertAuthorisationCollection() == null) {
            ECertRoles.setECertAuthorisationCollection(new ArrayList<ECertAuthorisation>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<ECertUsers> attachedECertUsersCollection = new ArrayList<ECertUsers>();
            for (ECertUsers ECertUsersCollectionECertUsersToAttach : ECertRoles.getECertUsersCollection()) {
                ECertUsersCollectionECertUsersToAttach = em.getReference(ECertUsersCollectionECertUsersToAttach.getClass(), ECertUsersCollectionECertUsersToAttach.getUserid());
                attachedECertUsersCollection.add(ECertUsersCollectionECertUsersToAttach);
            }
            ECertRoles.setECertUsersCollection(attachedECertUsersCollection);
            Collection<ECertAuthorisation> attachedECertAuthorisationCollection = new ArrayList<ECertAuthorisation>();
            for (ECertAuthorisation ECertAuthorisationCollectionECertAuthorisationToAttach : ECertRoles.getECertAuthorisationCollection()) {
                ECertAuthorisationCollectionECertAuthorisationToAttach = em.getReference(ECertAuthorisationCollectionECertAuthorisationToAttach.getClass(), ECertAuthorisationCollectionECertAuthorisationToAttach.getAuthorisationid());
                attachedECertAuthorisationCollection.add(ECertAuthorisationCollectionECertAuthorisationToAttach);
            }
            ECertRoles.setECertAuthorisationCollection(attachedECertAuthorisationCollection);
            em.persist(ECertRoles);
            for (ECertUsers ECertUsersCollectionECertUsers : ECertRoles.getECertUsersCollection()) {
                ECertRoles oldRoleROLEIDOfECertUsersCollectionECertUsers = ECertUsersCollectionECertUsers.getRoleROLEID();
                ECertUsersCollectionECertUsers.setRoleROLEID(ECertRoles);
                ECertUsersCollectionECertUsers = em.merge(ECertUsersCollectionECertUsers);
                if (oldRoleROLEIDOfECertUsersCollectionECertUsers != null) {
                    oldRoleROLEIDOfECertUsersCollectionECertUsers.getECertUsersCollection().remove(ECertUsersCollectionECertUsers);
                    oldRoleROLEIDOfECertUsersCollectionECertUsers = em.merge(oldRoleROLEIDOfECertUsersCollectionECertUsers);
                }
            }
            for (ECertAuthorisation ECertAuthorisationCollectionECertAuthorisation : ECertRoles.getECertAuthorisationCollection()) {
                ECertRoles oldRoleROLEIDOfECertAuthorisationCollectionECertAuthorisation = ECertAuthorisationCollectionECertAuthorisation.getRoleROLEID();
                ECertAuthorisationCollectionECertAuthorisation.setRoleROLEID(ECertRoles);
                ECertAuthorisationCollectionECertAuthorisation = em.merge(ECertAuthorisationCollectionECertAuthorisation);
                if (oldRoleROLEIDOfECertAuthorisationCollectionECertAuthorisation != null) {
                    oldRoleROLEIDOfECertAuthorisationCollectionECertAuthorisation.getECertAuthorisationCollection().remove(ECertAuthorisationCollectionECertAuthorisation);
                    oldRoleROLEIDOfECertAuthorisationCollectionECertAuthorisation = em.merge(oldRoleROLEIDOfECertAuthorisationCollectionECertAuthorisation);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findECertRoles(ECertRoles.getRoleid()) != null) {
                throw new PreexistingEntityException("ECertRoles " + ECertRoles + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECertRoles ECertRoles) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ECertRoles persistentECertRoles = em.find(ECertRoles.class, ECertRoles.getRoleid());
            Collection<ECertUsers> ECertUsersCollectionOld = persistentECertRoles.getECertUsersCollection();
            Collection<ECertUsers> ECertUsersCollectionNew = ECertRoles.getECertUsersCollection();
            Collection<ECertAuthorisation> ECertAuthorisationCollectionOld = persistentECertRoles.getECertAuthorisationCollection();
            Collection<ECertAuthorisation> ECertAuthorisationCollectionNew = ECertRoles.getECertAuthorisationCollection();
            List<String> illegalOrphanMessages = null;
            for (ECertUsers ECertUsersCollectionOldECertUsers : ECertUsersCollectionOld) {
                if (!ECertUsersCollectionNew.contains(ECertUsersCollectionOldECertUsers)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ECertUsers " + ECertUsersCollectionOldECertUsers + " since its roleROLEID field is not nullable.");
                }
            }
            for (ECertAuthorisation ECertAuthorisationCollectionOldECertAuthorisation : ECertAuthorisationCollectionOld) {
                if (!ECertAuthorisationCollectionNew.contains(ECertAuthorisationCollectionOldECertAuthorisation)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ECertAuthorisation " + ECertAuthorisationCollectionOldECertAuthorisation + " since its roleROLEID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ECertUsers> attachedECertUsersCollectionNew = new ArrayList<ECertUsers>();
            for (ECertUsers ECertUsersCollectionNewECertUsersToAttach : ECertUsersCollectionNew) {
                ECertUsersCollectionNewECertUsersToAttach = em.getReference(ECertUsersCollectionNewECertUsersToAttach.getClass(), ECertUsersCollectionNewECertUsersToAttach.getUserid());
                attachedECertUsersCollectionNew.add(ECertUsersCollectionNewECertUsersToAttach);
            }
            ECertUsersCollectionNew = attachedECertUsersCollectionNew;
            ECertRoles.setECertUsersCollection(ECertUsersCollectionNew);
            Collection<ECertAuthorisation> attachedECertAuthorisationCollectionNew = new ArrayList<ECertAuthorisation>();
            for (ECertAuthorisation ECertAuthorisationCollectionNewECertAuthorisationToAttach : ECertAuthorisationCollectionNew) {
                ECertAuthorisationCollectionNewECertAuthorisationToAttach = em.getReference(ECertAuthorisationCollectionNewECertAuthorisationToAttach.getClass(), ECertAuthorisationCollectionNewECertAuthorisationToAttach.getAuthorisationid());
                attachedECertAuthorisationCollectionNew.add(ECertAuthorisationCollectionNewECertAuthorisationToAttach);
            }
            ECertAuthorisationCollectionNew = attachedECertAuthorisationCollectionNew;
            ECertRoles.setECertAuthorisationCollection(ECertAuthorisationCollectionNew);
            ECertRoles = em.merge(ECertRoles);
            for (ECertUsers ECertUsersCollectionNewECertUsers : ECertUsersCollectionNew) {
                if (!ECertUsersCollectionOld.contains(ECertUsersCollectionNewECertUsers)) {
                    ECertRoles oldRoleROLEIDOfECertUsersCollectionNewECertUsers = ECertUsersCollectionNewECertUsers.getRoleROLEID();
                    ECertUsersCollectionNewECertUsers.setRoleROLEID(ECertRoles);
                    ECertUsersCollectionNewECertUsers = em.merge(ECertUsersCollectionNewECertUsers);
                    if (oldRoleROLEIDOfECertUsersCollectionNewECertUsers != null && !oldRoleROLEIDOfECertUsersCollectionNewECertUsers.equals(ECertRoles)) {
                        oldRoleROLEIDOfECertUsersCollectionNewECertUsers.getECertUsersCollection().remove(ECertUsersCollectionNewECertUsers);
                        oldRoleROLEIDOfECertUsersCollectionNewECertUsers = em.merge(oldRoleROLEIDOfECertUsersCollectionNewECertUsers);
                    }
                }
            }
            for (ECertAuthorisation ECertAuthorisationCollectionNewECertAuthorisation : ECertAuthorisationCollectionNew) {
                if (!ECertAuthorisationCollectionOld.contains(ECertAuthorisationCollectionNewECertAuthorisation)) {
                    ECertRoles oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation = ECertAuthorisationCollectionNewECertAuthorisation.getRoleROLEID();
                    ECertAuthorisationCollectionNewECertAuthorisation.setRoleROLEID(ECertRoles);
                    ECertAuthorisationCollectionNewECertAuthorisation = em.merge(ECertAuthorisationCollectionNewECertAuthorisation);
                    if (oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation != null && !oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation.equals(ECertRoles)) {
                        oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation.getECertAuthorisationCollection().remove(ECertAuthorisationCollectionNewECertAuthorisation);
                        oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation = em.merge(oldRoleROLEIDOfECertAuthorisationCollectionNewECertAuthorisation);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ECertRoles.getRoleid();
                if (findECertRoles(id) == null) {
                    throw new NonexistentEntityException("The eCertRoles with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ECertRoles ECertRoles;
            try {
                ECertRoles = em.getReference(ECertRoles.class, id);
                ECertRoles.getRoleid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertRoles with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ECertUsers> ECertUsersCollectionOrphanCheck = ECertRoles.getECertUsersCollection();
            for (ECertUsers ECertUsersCollectionOrphanCheckECertUsers : ECertUsersCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ECertRoles (" + ECertRoles + ") cannot be destroyed since the ECertUsers " + ECertUsersCollectionOrphanCheckECertUsers + " in its ECertUsersCollection field has a non-nullable roleROLEID field.");
            }
            Collection<ECertAuthorisation> ECertAuthorisationCollectionOrphanCheck = ECertRoles.getECertAuthorisationCollection();
            for (ECertAuthorisation ECertAuthorisationCollectionOrphanCheckECertAuthorisation : ECertAuthorisationCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ECertRoles (" + ECertRoles + ") cannot be destroyed since the ECertAuthorisation " + ECertAuthorisationCollectionOrphanCheckECertAuthorisation + " in its ECertAuthorisationCollection field has a non-nullable roleROLEID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ECertRoles);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
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

    public List<ECertRoles> findECertRolesEntities() {
        return findECertRolesEntities(true, -1, -1);
    }

    public List<ECertRoles> findECertRolesEntities(int maxResults, int firstResult) {
        return findECertRolesEntities(false, maxResults, firstResult);
    }

    private List<ECertRoles> findECertRolesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECertRoles.class));
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

    public ECertRoles findECertRoles(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertRoles.class, id);
        } finally {
            em.close();
        }
    }

    public int getECertRolesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertRoles> rt = cq.from(ECertRoles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
**/
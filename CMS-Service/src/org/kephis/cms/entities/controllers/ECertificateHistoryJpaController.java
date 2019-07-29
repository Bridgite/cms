/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities.controllers;

import org.kephis.cms.entities.ECertificateHistory;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.controllers.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author bkimutai
 */
public class ECertificateHistoryJpaController implements Serializable {

    public ECertificateHistoryJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
     public ECertificateHistoryJpaController(EntityManagerFactory emf) {

        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertificateHistory ECertificateHistory) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(ECertificateHistory);
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

    public void edit(ECertificateHistory ECertificateHistory) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ECertificateHistory = em.merge(ECertificateHistory);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ECertificateHistory.getCertHisId();
                if (findECertificateHistory(id) == null) {
                    throw new NonexistentEntityException("The eCertificateHistory with id " + id + " no longer exists.");
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
            utx.begin();
            em = getEntityManager();
            ECertificateHistory ECertificateHistory;
            try {
                ECertificateHistory = em.getReference(ECertificateHistory.class, id);
                ECertificateHistory.getCertHisId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertificateHistory with id " + id + " no longer exists.", enfe);
            }
            em.remove(ECertificateHistory);
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

    public List<ECertificateHistory> findECertificateHistoryEntities() {
        return findECertificateHistoryEntities(true, -1, -1);
    }

    public List<ECertificateHistory> findECertificateHistoryEntities(int maxResults, int firstResult) {
        return findECertificateHistoryEntities(false, maxResults, firstResult);
    }

    private List<ECertificateHistory> findECertificateHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECertificateHistory.class));
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

    public ECertificateHistory findECertificateHistory(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertificateHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getECertificateHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertificateHistory> rt = cq.from(ECertificateHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

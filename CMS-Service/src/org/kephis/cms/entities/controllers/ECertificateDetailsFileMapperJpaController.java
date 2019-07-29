/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
**/
package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.kephis.cms.entities.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.exceptions.PreexistingEntityException; 
import org.kephis.cms.entities.ECertificateDetails;
 
public class ECertificateDetailsFileMapperJpaController implements Serializable {

    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public ECertificateDetailsFileMapperJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ECertificateDetailsFileMapperJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertificateDetails ECertificate) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ECertificate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findECertificate(ECertificate.getCertFile()) != null) {
                throw new PreexistingEntityException("ECertificate " + ECertificate + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECertificateDetails ECertificate) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertificate = em.merge(ECertificate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ECertificate.getCertFile();
                if (findECertificate(id) == null) {
                    throw new NonexistentEntityException("The eCertificate with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertificateDetails ECertificate;
            try {
                ECertificate = em.getReference(ECertificateDetails.class, id);
                ECertificate.getCertFile();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertificate with id " + id + " no longer exists.", enfe);
            }
            em.remove(ECertificate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ECertificateDetails> findECertificateEntities() {
        return findECertificateEntities(true, -1, -1);
    }

    public List<ECertificateDetails> findECertificateEntities(int maxResults, int firstResult) {
        return findECertificateEntities(false, maxResults, firstResult);
    }

    private List<ECertificateDetails> findECertificateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECertificateDetails.class));
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

    public ECertificateDetails findECertificate(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertificateDetails.class, id);
        } finally {
            em.close();
        }
    }

    public boolean isECertificate(String id) {
        EntityManager em = getEntityManager();
        try {
            if ((em.find(ECertificateDetails.class, id).toString().isEmpty())) {
                return false;
            }
            return true;
        } finally {
            em.close();
        }
    }

    public int getECertificateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertificateDetails> rt = cq.from(ECertificateDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
 
    public String[] findECertificateEntitiesByDate(String date_from, String date_to) {
        List<ECertificateDetails> results;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pp = new ParsePosition(0);
        ParsePosition pp1 = new ParsePosition(0);
        Date temp_frmDateOfIssue = dateFormat.parse(date_from, pp);
        Date temp_toDateOfIssue = dateFormat.parse(date_to, pp1);
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ECertificateDetails.findByDateOfIssue").
                setParameter(1, temp_frmDateOfIssue, TemporalType.DATE).
                setParameter(2, temp_toDateOfIssue, TemporalType.DATE);
        results = query.getResultList();
        String[] result = new String[query.getResultList().size()];
        int i = 0;
        for (ECertificateDetails eCertificate : results) {
            result[i] = eCertificate.getCertNo();
            i++;
        }
        return result;

    }
        private int getTotalPage(int maxresults, int pagesize) {
        if (maxresults == 0 || maxresults <= 0) {
            return 0;
        }
        final int totalSize = maxresults;
        return ((totalSize - 1) / pagesize) + 1;
    }
}

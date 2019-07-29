/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.kephis.cms.entities.EPhytoDetails;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.controllers.exceptions.PreexistingEntityException;

/**
 *
 * @author kim
 */
public class EPhytoDetailsJpaController implements Serializable {

    public EPhytoDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<EPhytoDetails> getEPhytoDetails(String CertificateNo) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("EPhytoDetails.findByDocumentNr").
                setParameter("documentNr", CertificateNo);
        query.setHint("eclipselink.read-only", "true");
        final List<EPhytoDetails>  results = query.getResultList();

        return results;

    }

    public List<EPhytoDetails> findEPhytoDetailsEntities() {
        return findEPhytoDetailsEntities(true, -1, -1);
    }

    public List<EPhytoDetails> findEPhytoDetailsEntities(int maxResults, int firstResult) {
        return findEPhytoDetailsEntities(false, maxResults, firstResult);
    }

    private List<EPhytoDetails> findEPhytoDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EPhytoDetails.class));
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

    public EPhytoDetails findEPhytoDetails(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EPhytoDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getEPhytoDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EPhytoDetails> rt = cq.from(EPhytoDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities.controllers;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.kephis.cms.file.controllers.ECertFileReader;
import org.kephis.cms.entities.ECertificateDetails;
import org.kephis.cms.entities.ECertificateHistory;
import org.kephis.cms.entities.controllers.exceptions.IllegalOrphanException;
//import org.kephis.cms.entities.ECertificateList;
import org.kephis.cms.entities.controllers.exceptions.NonexistentEntityException;
import org.kephis.cms.entities.controllers.exceptions.PreexistingEntityException;
import org.kephis.cms.entities.controllers.exceptions.RollbackFailureException;
import org.kephis.cms.utilities.UtilityClass;

/**
 *
 * @author kim
 */
public class ECertificateDetailsJpaController implements Serializable {

    public ECertificateDetailsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    public ECertificateDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;
    UtilityClass util = new UtilityClass();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECertificateDetails ECertificateDetails) throws PreexistingEntityException, Exception {
        if (ECertificateDetails.getECertStatusHistoryCollection() == null) {
            ECertificateDetails.setECertStatusHistoryCollection(new ArrayList<ECertificateHistory>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ECertificateHistory> attachedECertStatusHistoryCollection = new ArrayList<ECertificateHistory>();
            for (ECertificateHistory ECertStatusHistoryCollectionECertStatusHistoryToAttach : ECertificateDetails.getECertStatusHistoryCollection()) {
                ECertStatusHistoryCollectionECertStatusHistoryToAttach = em.getReference(ECertStatusHistoryCollectionECertStatusHistoryToAttach.getClass(), ECertStatusHistoryCollectionECertStatusHistoryToAttach.getCertHisId());
                attachedECertStatusHistoryCollection.add(ECertStatusHistoryCollectionECertStatusHistoryToAttach);
            }
            ECertificateDetails.setECertStatusHistoryCollection(attachedECertStatusHistoryCollection);
            em.persist(ECertificateDetails);
            for (ECertificateHistory ECertStatusHistoryCollectionECertStatusHistory : ECertificateDetails.getECertStatusHistoryCollection()) {
                ECertificateDetails oldECertificateDetailsIdOfECertStatusHistoryCollectionECertStatusHistory = ECertStatusHistoryCollectionECertStatusHistory.getEcertDetailsId();
                ECertStatusHistoryCollectionECertStatusHistory.setEcertDetailsId(ECertificateDetails);
                ECertStatusHistoryCollectionECertStatusHistory = em.merge(ECertStatusHistoryCollectionECertStatusHistory);
                if (oldECertificateDetailsIdOfECertStatusHistoryCollectionECertStatusHistory != null) {
                    oldECertificateDetailsIdOfECertStatusHistoryCollectionECertStatusHistory.getECertStatusHistoryCollection().remove(ECertStatusHistoryCollectionECertStatusHistory);
                    oldECertificateDetailsIdOfECertStatusHistoryCollectionECertStatusHistory = em.merge(oldECertificateDetailsIdOfECertStatusHistoryCollectionECertStatusHistory);
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findECertificateDetails(ECertificateDetails.getId()) != null) {
                throw new PreexistingEntityException("ECertificateDetails " + ECertificateDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECertificateDetails ECertificateDetails) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertificateDetails persistentECertificateDetails = em.find(ECertificateDetails.class, ECertificateDetails.getId());
            Collection<ECertificateHistory> ECertStatusHistoryCollectionOld = persistentECertificateDetails.getECertStatusHistoryCollection();
            Collection<ECertificateHistory> ECertStatusHistoryCollectionNew = ECertificateDetails.getECertStatusHistoryCollection();
            List<String> illegalOrphanMessages = null;
            for (ECertificateHistory ECertStatusHistoryCollectionOldECertStatusHistory : ECertStatusHistoryCollectionOld) {
                if (!ECertStatusHistoryCollectionNew.contains(ECertStatusHistoryCollectionOldECertStatusHistory)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ECertStatusHistory " + ECertStatusHistoryCollectionOldECertStatusHistory + " since its ECertificateDetailsId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ECertificateHistory> attachedECertStatusHistoryCollectionNew = new ArrayList<ECertificateHistory>();
            for (ECertificateHistory ECertStatusHistoryCollectionNewECertStatusHistoryToAttach : ECertStatusHistoryCollectionNew) {
                ECertStatusHistoryCollectionNewECertStatusHistoryToAttach = em.getReference(ECertStatusHistoryCollectionNewECertStatusHistoryToAttach.getClass(), ECertStatusHistoryCollectionNewECertStatusHistoryToAttach.getCertHisId());
                attachedECertStatusHistoryCollectionNew.add(ECertStatusHistoryCollectionNewECertStatusHistoryToAttach);
            }
            ECertStatusHistoryCollectionNew = attachedECertStatusHistoryCollectionNew;
            ECertificateDetails.setECertStatusHistoryCollection(ECertStatusHistoryCollectionNew);
            ECertificateDetails = em.merge(ECertificateDetails);
            for (ECertificateHistory ECertStatusHistoryCollectionNewECertStatusHistory : ECertStatusHistoryCollectionNew) {
                if (!ECertStatusHistoryCollectionOld.contains(ECertStatusHistoryCollectionNewECertStatusHistory)) {
                    ECertificateDetails oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory = ECertStatusHistoryCollectionNewECertStatusHistory.getEcertDetailsId();
                    ECertStatusHistoryCollectionNewECertStatusHistory.setEcertDetailsId(ECertificateDetails);
                    ECertStatusHistoryCollectionNewECertStatusHistory = em.merge(ECertStatusHistoryCollectionNewECertStatusHistory);
                    if (oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory != null && !oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory.equals(ECertificateDetails)) {
                        oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory.getECertStatusHistoryCollection().remove(ECertStatusHistoryCollectionNewECertStatusHistory);
                        oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory = em.merge(oldECertificateDetailsIdOfECertStatusHistoryCollectionNewECertStatusHistory);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ECertificateDetails.getId();
                if (findECertificateDetails(id) == null) {
                    throw new NonexistentEntityException("The ECertificateDetails with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECertificateDetails ECertificateDetails;
            try {
                ECertificateDetails = em.getReference(ECertificateDetails.class, id);
                ECertificateDetails.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECertificateDetails with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ECertificateHistory> ECertStatusHistoryCollectionOrphanCheck = ECertificateDetails.getECertStatusHistoryCollection();
            for (ECertificateHistory ECertStatusHistoryCollectionOrphanCheckECertStatusHistory : ECertStatusHistoryCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ECertificateDetails (" + ECertificateDetails + ") cannot be destroyed since the ECertStatusHistory " + ECertStatusHistoryCollectionOrphanCheckECertStatusHistory + " in its ECertStatusHistoryCollection field has a non-nullable ECertificateDetailsId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ECertificateDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ECertificateDetails> findECertificateDetailsEntities() {
        return findECertificateDetailsEntities(true, -1, -1);
    }

    public List<ECertificateDetails> findECertificateDetailsEntities(int maxResults, int firstResult) {
        return findECertificateDetailsEntities(false, maxResults, firstResult);
    }

    private List<ECertificateDetails> findECertificateDetailsEntities(boolean all, int maxResults, int firstResult) {
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

    public ECertificateDetails findECertificateDetails(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECertificateDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getECertificateDetailsCount() {
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

    /**
     * public void create(ECertificateDetails ECertificateDetails) throws
     * PreexistingEntityException, Exception { EntityManager em = null; try { em
     * = getEntityManager(); em.getTransaction().begin();
     *
     * em.persist(ECertificateDetails); em.getTransaction().commit(); } catch
     * (Exception ex) { if
     * (findECertificateDetails(ECertificateDetails.getCertFile()) != null) {
     * throw new PreexistingEntityException("ECertificateDetails " +
     * ECertificateDetails + " already exists.", ex); } throw ex; } finally { if
     * (em != null) { em.close(); } } }
     *
     * public void edit(ECertificateDetails ECertificateDetails) throws
     * NonexistentEntityException, Exception { EntityManager em = null; try { em
     * = getEntityManager(); em.getTransaction().begin(); ECertificateDetails =
     * em.merge(ECertificateDetails); em.getTransaction().commit(); } catch
     * (Exception ex) { String msg = ex.getLocalizedMessage(); if (msg == null
     * || msg.length() == 0) { String id = ECertificateDetails.getCertFile(); if
     * (findECertificateDetails(id) == null) { throw new
     * NonexistentEntityException("The eCertificateDetails with id " + id + " no
     * longer exists."); } } throw ex; } finally { if (em != null) { em.close();
     * } } }
     *
     * public void destroy(String id) throws NonexistentEntityException {
     * EntityManager em = null; try { em = getEntityManager();
     * em.getTransaction().begin(); ECertificateDetails ECertificateDetails; try
     * { ECertificateDetails = em.getReference(ECertificateDetails.class, id);
     * ECertificateDetails.getCertFile(); } catch (EntityNotFoundException enfe)
     * { throw new NonexistentEntityException("The ECertificateDetails with id "
     * + id + " no longer exists.", enfe); } em.remove(ECertificateDetails);
     * em.getTransaction().commit(); } finally { if (em != null) { em.close(); }
     * } }
*
     */
    public List<ECertificateDetails> findECertificateListEntities() {
        return findECertificateListEntities(true, -1, -1);
    }

    public List<ECertificateDetails> findECertificateListEntities(int maxResults, int firstResult) {
        return findECertificateListEntities(false, maxResults, firstResult);
    }

    private List<ECertificateDetails> findECertificateListEntities(boolean all, int maxResults, int firstResult) {
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

    public ECertificateDetails findECertificateDetails(String id) {
        EntityManager em = getEntityManager();
        try {
            ECertificateDetails result = new ECertificateDetails();

            Query query = em.createNamedQuery("ECertificateDetails.findByCertFile").
                    setParameter("certFile", id);
            return (ECertificateDetails) query.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            //Logger.getLogger(ECertificateDetailsJpaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            em.close();
        }
    }

    public Long findECertificateDetailsId(String id) {
        EntityManager em = getEntityManager();
        try {
            ECertificateDetails result = new ECertificateDetails();

            Query query = em.createNamedQuery("ECertificateDetails.findByCertFile").
                    setParameter("certFile", id);
            return ((ECertificateDetails) query.getSingleResult()).getId();
        } catch (javax.persistence.NoResultException ex) {
            Logger.getLogger(ECertificateDetailsJpaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            em.close();
        }
    }

    public boolean UpdateECertificatesStatus(String certNo, String Reason, int Status) {
        boolean isSucessfull = false;
        ECertificateDetails result = new ECertificateDetails();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ECertificateDetails.findByCertNo").
                setParameter("certNo", certNo);
        result = (ECertificateDetails) query.getSingleResult();
        ECertificateHistory eCertificateHistory;
        eCertificateHistory = new ECertificateHistory(getECertificateHistoryCount() + 1);
        eCertificateHistory.setEcertDetailsId(result);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pp = new ParsePosition(0);
        Date d = sdf.parse(sdf.format(cal.getTime()), pp);
        eCertificateHistory.setStatusDate(d);
        eCertificateHistory.setReason(Reason);
       // System.err.println(" status "+result.getCertStatus());
        if (result.getCertStatus().contentEquals("ACCEPTED") || result.getCertStatus().contentEquals("REJECTED")) {
          //  System.err.println(" status "+result.getCertStatus());
            return true;
        }

        if (Status == 1) {
            eCertificateHistory.setCertStatus("ACCEPTED");
            result.setCertStatus("ACCEPTED");
        } else if (Status == 2) {
            eCertificateHistory.setCertStatus("REQUEST_REPLACEMENT");
            result.setCertStatus("REQUEST_REPLACEMENT");
        } else if (Status == 3) {
            eCertificateHistory.setCertStatus("REJECTED");
            result.setCertStatus("REQUEST_REPLACEMENT");
        } else if (Status == 4) {
            eCertificateHistory.setCertStatus("ACKNOWLEDGED");
            result.setCertStatus("ACKNOWLEDGED");

        }
        try {
            create(eCertificateHistory);
            isSucessfull = true;
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ECertificateHistoryJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ECertificateHistoryJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        result.setStatusDate(d);
        try {
            edit(result);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ECertificateDetailsJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ECertificateDetailsJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ECertificateDetailsJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSucessfull;
    }

    //Find export certificates details by update date
    public String[] findECertificateEntitiesByDate(int page, String date_from, String date_to, String country) {
        List<ECertificateDetails> results;
        //System.out.print(date_from);
        // System.out.print(date_to);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pp = new ParsePosition(0);
        ParsePosition pp1 = new ParsePosition(0);
        Date temp_frmDateOfIssue = dateFormat.parse(date_from.toString(), pp);
        Date temp_toDateOfIssue = dateFormat.parse(date_to.toString(), pp1);
        EntityManager em = getEntityManager();
        int maxcerts = ((Long) em.createNamedQuery("ECertificateDetails.findByDatesOfIssueCount").
                setParameter(1, temp_frmDateOfIssue, TemporalType.DATE).
                setParameter(2, temp_toDateOfIssue, TemporalType.DATE).
                setParameter(3, country).getSingleResult()).intValue();

        int totalpages = getTotalPage(maxcerts, 50);
        int firstresult = 0;
        if (totalpages == 0) {
            firstresult = 0;
        }
        if (page >= totalpages) {
            firstresult = (totalpages * 50) - 50;
        } else {
            firstresult = page * 50;
        }

        if (maxcerts == 0) {
            String[] result = {"No Certificates returned "};

            System.err.println(result + " " + util.getCurrentTime());
            return result;

        }
        Query query = em.createNamedQuery("ECertificateDetails.findByDatesOfIssue").
                setParameter(1, temp_frmDateOfIssue, TemporalType.DATE).
                setParameter(2, temp_toDateOfIssue, TemporalType.DATE).
                setParameter(3, country).
                setFirstResult(firstresult).
                setMaxResults(50);
        query.setHint("eclipselink.read-only", "true");
        results = query.getResultList();
        String[] result = new String[50];
        int i = 0;
        for (Iterator<ECertificateDetails> it = results.iterator(); it.hasNext();) {
            ECertificateDetails eCertificate = it.next();
            if (!eCertificate.getCertNo().isEmpty()) {
                result[i] = eCertificate.getCertNo();
            }
            i++;
        }

        if (i < 50) {
            result[i] = "END of " + totalpages + " pages";
        }

        int count = 0;
        for (int j = 0; j < result.length; j++) {
            //System.out.print("v1 " + result[j]);
            if (result[j] != null) {
                count++;
            }
        }
        String[] rresult = new String[count];

        for (int j = 0; j < rresult.length; j++) {
            rresult[j] = result[j];
        }
        System.err.println(rresult.length + " " + util.getCurrentTime());
        return rresult;
    }

    public String[] findECertificateEntitiesByDateAndStatus(int page, String date_from, String date_to, String status, String country) {

        List<ECertificateDetails> results;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pp = new ParsePosition(0);
        ParsePosition pp1 = new ParsePosition(0);
        Date temp_frmDateOfIssue = dateFormat.parse(date_from.toString(), pp);
        Date temp_toDateOfIssue = dateFormat.parse(date_to.toString(), pp1);
        EntityManager em = getEntityManager();
        int maxcerts = ((Long) em.createNamedQuery("ECertificateDetails.findByDatesOfIssueCountAndStatus").
                setParameter(1, status).
                setParameter(2, temp_frmDateOfIssue, TemporalType.DATE).
                setParameter(3, temp_toDateOfIssue, TemporalType.DATE).
                setParameter(4, country).getSingleResult()).intValue();
        // System.out.println("this is " + country);
        int totalpages = getTotalPage(maxcerts, 50);
        int firstresult = 0;
        if (page >= totalpages) {
            firstresult = (totalpages * 50) - 50;
        } else {
            firstresult = page * 50;

        }
        if (totalpages == 0) {
            firstresult = 0;
        }
        Query query = em.createNamedQuery("ECertificateDetails.findByDatesOfIssueAndStatus").
                setParameter(1, status).
                setParameter(2, temp_frmDateOfIssue, TemporalType.DATE).
                setParameter(3, temp_toDateOfIssue, TemporalType.DATE).
                setParameter(4, country).
                setFirstResult(firstresult).//page parameter//
                setMaxResults(50);
        query.setHint("eclipselink.read-only", "true");
        results = query.getResultList();
        String[] result = new String[50];
        int i = 0;

        for (Iterator<ECertificateDetails> it = results.iterator(); it.hasNext();) {

            ECertificateDetails ECertificateDetails = it.next();
            if (!ECertificateDetails.getCertNo().isEmpty()) {
                result[i] = ECertificateDetails.getCertNo();

            }
            i++;
        }
        if (i < 50) {
            result[i] = "END of " + totalpages + " pages";
        }
        int count = 0;
        for (int j = 0; j < result.length; j++) {
            if (result[j] != null) {
                count++;
            }
        }
        String[] rresult = new String[count];

        for (int j = 0; j < rresult.length; j++) {
            rresult[j] = result[j];
        }

        System.err.println(country + " " + rresult.length + " " + util.getCurrentTime());
        return rresult;

    }

    public void create(ECertificateHistory ECertificateHistory) throws RollbackFailureException, Exception {
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateHistoryJpaController ecert = new ECertificateHistoryJpaController(emf2);
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ECertificateHistory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(""+ex);
            if (ecert.findECertificateHistory(ECertificateHistory.getCertHisId()) != null) {
                throw new PreexistingEntityException("ECertificate " + ECertificateHistory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public int getECertificateListCount() {
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

    private int getTotalPage(int maxresults, int pagesize) {
        if (maxresults == 0 || maxresults <= 0) {
            return 0;
        }
        final int totalSize = maxresults;
        return ((totalSize - 1) / pagesize) + 1;
    }

    public Long getECertificateHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECertificateHistory> rt = cq.from(ECertificateHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult());
        } finally {
            em.close();
        }
    }

    // Get official certificate xml
    public byte[] getECertificateXml(String certNo) {
        //USE FILE PATH
        //update table before request 
        ECertificateDetails result;
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ECertificateDetails.findByCertNo").
                setParameter("certNo", certNo);
        result = (ECertificateDetails) query.getSingleResult();
        ECertFileReader xmlFile = new ECertFileReader(result.getXmlCertFilePath());
        return xmlFile.getFileContents(result.getXmlCertFilePath()).getBytes();
    }

    public byte[] getSignedECertificateXml(String certNo) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ECertificateDetails.findByCertNo").setParameter("certNo", certNo);
        ECertificateDetails result = (ECertificateDetails) query.getSingleResult();
        ECertFileReader xmlFile = new ECertFileReader(result.getSignedXmlCertFilePath());
        return xmlFile.getFileContents(result.getSignedXmlCertFilePath()).getBytes();
    }
    //Get multiple official certificate xml

    public List getMultECertificateXml(String certsNos) {
        List byt = new ArrayList();
        List results = new ArrayList();
        String delimiters = "[,]";
        String arr[] = certsNos.split(delimiters);
        byte str[] = null;
        Query query = null;
        //System.out.println((new StringBuilder()).append("CERD").append(arr.length).toString());
        int i;
        for (i = 0; i < arr.length; i++) {
            EntityManager em = getEntityManager();
            em.clear();
            query = em.createNamedQuery("ECertificateDetails.findByCertNo").setParameter("certNo", arr[i].toString().trim());

            ECertificateDetails ecrt = (ECertificateDetails) query.getSingleResult();

            results.add(ecrt);
        }

        //System.out.print((new StringBuilder()).append("O333333UTPUT").append(results.size()).toString());
        i = 0;
        for (Iterator it = results.iterator(); it.hasNext();) {
            ECertificateDetails eCertificate = (ECertificateDetails) it.next();
            ECertFileReader xmlFile = new ECertFileReader(eCertificate.getSignedXmlCertFilePath());
            str = xmlFile.getFileContents(eCertificate.getSignedXmlCertFilePath()).getBytes();

            byt.add(i, str);
            i++;
        }

        return byt;
    }

}

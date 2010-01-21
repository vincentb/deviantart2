/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iut;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vincentb
 */
public class CategoryHelper {

    Session session = null;

    public CategoryHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getFirstLevelCategories() {
        List<Category> categoryList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Category where parent_id is null");
            categoryList = (List<Category>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List getSecondLevelCategories(int parentId){
                List<Category> categories = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Category where parent_id ="+parentId);
            categories = (List<Category>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return categories;
    }
}

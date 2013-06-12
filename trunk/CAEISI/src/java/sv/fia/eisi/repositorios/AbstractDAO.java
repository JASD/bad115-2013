/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

/**
 *
 * @author antonio
 */
public abstract class AbstractDAO<T> {

    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract String create(T entity);

    public abstract String edit(T entity);

    public abstract String delete(T entity);

    public abstract T find(Object id);
}

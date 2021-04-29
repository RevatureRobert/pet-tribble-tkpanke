package dao;

import java.util.List;

/**
 * Provides generic methods for dao.
 *
 * @param <T>
 */
public interface GenericDao <T> {
	List<T> getList();
	T getById(int id);
	void insert(T t);
	void update(T t);
	void delete(T t);
}

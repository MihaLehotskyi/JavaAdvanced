package ua.lviv.lgs.shared;

import java.util.List;

public interface AbstractCRUD <T> {
	T create(T obj);
	T update(T obj);
	void delete(Integer id);
	T read(Integer id);
	List<T> readall();
}

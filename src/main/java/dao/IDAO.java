package dao;

import java.util.List;

public interface IDAO <T,K> {
	
	String login="root";
	String password="";
	String chemin="jdbc:mysql://localhost:3306/hopital?characterEncoding=utf8";	
	
	
	public T findById(K id);
	public List<T> findAll();
	public T save(T d);
	public void delete(T d);
	
}

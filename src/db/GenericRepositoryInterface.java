package db;

import java.util.List;
import com.scoremgm.model.MemberVo;

public interface GenericRepositoryInterface<T> {
	int  insert(T entity);
	int  update(T entity);
	T find(String id);
	int getCount();
	List<T> findAll();
	int remove(String no);
	void close(); // 부모에서 구현이되어있으면 굳이 안해도 됨
}
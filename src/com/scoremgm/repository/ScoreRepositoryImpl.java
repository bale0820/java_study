package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository {

	List<Member> storage = new ArrayList<Member>();

	@Override
	public Member find(String no) {
		no = "2025-"+no;
		Member member = null;
		if (no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
		}
		return member;
		
////		
//				//forEach는 메소드 호출이므로 스택에 새로운 블록으로 생성되어 실행됨!!
//				//실행중이던 find 중지하고 forEach로 주도권이 넘어오므로 find의 member는 삭제됨
//				storage.forEach(m -> { 
//					if(m.getNo().equals(no)) member = m; //람다식은 내부에서 외부 지역 변수는 '읽기만' 가능하다고 정해져 있어요.
//				});

		
	}
	
	@Override
	public void remove(String no) {
//		int searchIdx = -1;
//		for(int i=0;i<storage.size();i++) {
//			if(storage.get(i).getNo().equals(no)) {
//				searchIdx = i;
//			}
//		}
		no = "2025-"+no;
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext()) {
			Member m = ie.next();
			if(m.getNo().equals(no)) {
				ie.remove();
				break;
			}
		}
		
	}
	
	public void update(Member member) {
		int idx = -1;
		for(int i=0;i<storage.size();i++) {
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo())) {
				idx = i;
				break;
			}
		}
		storage.set(idx, member);
	}
	

	@Override
	public List<Member> findAll() {
		return storage;
	}

	@Override
	public int getCount() {
		return storage.size();
	}

	@Override
	public boolean insert(Member member) {
		if (member == null)
			return false;
		return storage.add(member);
	}

}

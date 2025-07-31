package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.MemberVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn 
			implements GenericRepositoryInterface<MemberVo> {

	public ScoreRepositoryImpl() { super();}
	
	
	
	
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into score_member(name,department,kor,eng,math,mdate)
					values(?,?,?,?,?,now())
				""";
		try {
		getPreparedStatement(sql);
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getDepartment());
		pstmt.setInt(3, member.getKor());
		pstmt.setInt(4, member.getEng());
		pstmt.setInt(5, member.getMath());
		rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return rows;
	}

	@Override
	public MemberVo find(String mid) {
		MemberVo member = null;
		String sql = """
				select mid , name, department,kor,eng,math,mdate
				from score_member
				where mid = ?
				
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVo();
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setDepartment(rs.getString(3));
				member.setKor(rs.getInt(4));
				member.setEng(rs.getInt(5));
				member.setMath(rs.getInt(6));
				member.setMdate(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
//		
//////		
////				//forEach는 메소드 호출이므로 스택에 새로운 블록으로 생성되어 실행됨!!
////				//실행중이던 find 중지하고 forEach로 주도권이 넘어오므로 find의 member는 삭제됨
////				storage.forEach(m -> { 
////					if(m.getNo().equals(no)) member = m; //람다식은 내부에서 외부 지역 변수는 '읽기만' 가능하다고 정해져 있어요.
////				});
//
//		
//	}
//	
//	@Override
//	public void remove(String no) {
////		int searchIdx = -1;
////		for(int i=0;i<storage.size();i++) {
////			if(storage.get(i).getNo().equals(no)) {
////				searchIdx = i;
////			}
////		}
//		no = "2025-"+no;
//		Iterator<MemberVo> ie = storage.iterator();
//		while(ie.hasNext()) {
//			MemberVo m = ie.next();
//			if(m.getNo().equals(no)) {
//				ie.remove();
//				break;
//			}
//		}
//		
//	}
//	
//	public void update(MemberVo member) {
//		int idx = -1;
//		for(int i=0;i<storage.size();i++) {
//			MemberVo m = storage.get(i);
//			if(m.getNo().equals(member.getNo())) {
//				idx = i;
//				break;
//			}
//		}
//		storage.set(idx, member);
//	}
//	
//
	@Override
	public List<MemberVo> findAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select row_number() over(),
				mid,name,department,kor,eng,math,mdate 
				from score_member
				
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setRno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setName(rs.getString(3));
				member.setDepartment(rs.getString(4));
				member.setKor(rs.getInt(5));
				member.setEng(rs.getInt(6));
				member.setMath(rs.getInt(7));
				member.setMdate(rs.getString(8));
				
				list.add(member);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount() {
		int rows = 0;
		String sql = "select count(*) from score_member";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return rows;
	}


}

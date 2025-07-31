package member;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;
//PreparedStatement에서 setString 사용의 장점
//PreparedStatement는 파라미터 바인딩을 통해 SQL 쿼리와 사용자 입력을 명확히 분리하기 때문에, 사용자 입력이 SQL 코드로 해석되지 않도록 자동으로 처리합니다. 이를 통해 SQL 인젝션을 방어할 수 있습니다. 예를 들어:
//예시 (안전한 PreparedStatement 사용):
public class MemberDao extends DBConn implements GenericInterface<MemberVo>{ //MemberDao는 스프링으로 가면 repository가 된다

	
	
	public MemberDao() { super(); }
	
	
	
	
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true 임, 바로 적용됨!!
	/**
	 * 데이터 검색
	 */
	@Override
	public List<MemberVo> search(String name) {
		List<MemberVo>  list = new ArrayList<MemberVo>(); //내부적으로 기본 10개
		String sql = """
					select 
							member_id,
							name,
							email,
							created_at 
							from member 
							where name = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));;
				list.add(memberVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	
		
		
	}
	
	
	/**
	 * 데이터 검색
	 */
	@Override
	public MemberVo search(int memberId) {
		MemberVo member = new MemberVo();
		String sql = 
				"select member_id, name, email, created_at"
				+" from member where member_id = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	

	
	
	
	
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberId) {
		int rows = 0;
		String sql = """
				delete from member where member_id = ?
				""";
		
		try {
		getPreparedStatement(sql);
		pstmt.setInt(1, memberId);
		rows = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
	
	/**
	 * 데이터 수정
	 */
	@Override
	public int update(MemberVo memberVo) {
		int rows = 0;
		String sql = """
				update member
					set name = ?,
						email = ?
					where member_id = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2,memberVo.getEmail());
			pstmt.setInt(3,memberVo.getMemberId());
			rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return rows;
	}
	
	
	/**
	 * 데이터 추가
	 * @param memberVo
	 */
	@Override
	public List<MemberVo> listAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select member_id, name, email, left(created_at,10) from member
				
				
				""";
		
		try {
			getPreparedStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				
				list.add(member);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into member(name,email,created_at)
					values(?,?,now())
				""";
		
		try {
		 getPreparedStatement(sql);
		 pstmt.setString(1, member.getName());
		 pstmt.setString(2, member.getEmail());
		 
		 rows = pstmt.executeUpdate();
		 
		 if(rows != 0) {
			 System.out.println("추가 성공");
		 }
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
		
	}
	
	
	
	
	
}

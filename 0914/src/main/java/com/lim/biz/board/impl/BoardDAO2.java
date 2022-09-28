package com.lim.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lim.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String sql_selectOne="SELECT * FROM BOARD WHERE BID=?";
	final String sql_selectAll="SELECT * FROM BOARD ORDER BY BID DESC";
	final String sql_insert="INSERT INTO BOARD(BID,TITLE,WRITER,CONTENT,FILENAME) VALUES((SELECT NVL(MAX(BID),0)+1 FROM BOARD),?,?,?,?)";
	final String sql_update="UPDATE BOARD SET TITLE=?,CONTENT=?,FILENAME=? WHERE BID=?";
	final String sql_delete="DELETE BOARD WHERE BID=?";
	final String sql_selectAll_T="SELECT * FROM BOARD  WHERE TITLE LIKE '%'||?||'%'  ORDER BY BID ASC";
	final String sql_selectAll_W="SELECT * FROM BOARD  WHERE WRITER LIKE '%'||?||'%' ORDER BY BID ASC";
	void insertBoard(BoardVO vo) {
		jdbcTemplate.update(sql_insert,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFilename());
	}
	void updateBoard(BoardVO vo) {
		jdbcTemplate.update(sql_update,vo.getTitle(),vo.getContent(),vo.getFilename(),vo.getBid());
	}
	void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(sql_delete,vo.getBid());
	}
	BoardVO selectOneBoard(BoardVO vo) {
		Object[] args= {vo.getBid()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new BoardRowMapper());
	}
	List<BoardVO> selectAllBoard(BoardVO vo) {
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchContent()==null) {
			vo.setSearchContent("");
		}
		if(vo.getSearchCondition().equals("WRITER")) {
				Object[] args= {vo.getSearchContent()};
			return  jdbcTemplate.query(sql_selectAll_W,args,new BoardRowMapper());
		}
		
		Object[] args= {vo.getSearchContent()};
		return  jdbcTemplate.query(sql_selectAll_T,args,new BoardRowMapper());
	}
}
class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		BoardVO data=new BoardVO();
		data.setBid(rs.getInt("BID"));
		data.setContent(rs.getString("CONTENT"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		data.setCnt(rs.getInt("CNT"));
		data.setRegdate(rs.getString("REGDATE"));
		data.setFilename(rs.getString("FILENAME"));

		return data;

	}

}


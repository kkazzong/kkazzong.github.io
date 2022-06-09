package com.kkaboard.api.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractDAO {
	@Autowired
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;
     
    protected void printQueryId(String queryId) {
        //if (log.isDebugEnabled())
        //{
            log.info("ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ Query ID \t: " + queryId);
        //}
    }
    
    public Object insert(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.insert(queryId, params);
    }
 
    public Object update(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.update(queryId, params);
    }
 
    public Object delete(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.delete(queryId, params);
    }
     
    public Object selectOne(String queryId){
        printQueryId(queryId);
        return sqlSession.selectOne(queryId);
    }
 
    public Object selectOne(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }
 
    public List<?> selectList(String queryId){
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }
 
    public List<?> selectList(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectList(queryId,params);
    }
    
    @SuppressWarnings("unchecked")
	public Map<String, Object> selectPagingList(int resOnePageCnt, String queryId, Object params) {

		printQueryId(queryId);

		Map<String, Object> map = (Map<String, Object>) params;

		final int onePageCnt = resOnePageCnt;
		final int pageGroupSize = 5;

		int currentPage = 1;

		int startRow = (currentPage - 1) * onePageCnt + 1;
		int endRow = currentPage * onePageCnt;
		int count = 1;
		int number = 0;

		// �޾ƿ� ����¡ ��
		if (map.containsKey("page")) {
			if (map.get("page") == null) {
				currentPage = 1;
			} else {
				currentPage = Integer.valueOf(map.get("page").toString());
			}
		}

		startRow = (currentPage - 1) * onePageCnt + 1;
		endRow = currentPage * onePageCnt;

		List<Map<String, Object>> list = null;
		map.put("START", startRow);
		map.put("END", endRow);

		try {
			list = (List<Map<String, Object>>) selectList(queryId, map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (list.size() > 0) {

			count = Integer.parseInt(list.get(0).get("TOTAL_COUNT").toString());
			int maxPage = (count + (onePageCnt - 1)) / onePageCnt; // ������ ������

			if (endRow > count) {
				endRow = count;
			}

			params = map;
			number = count - (currentPage - 1) * onePageCnt;

			int pageGroupCount = count / (onePageCnt * pageGroupSize)
					+ (count % (onePageCnt * pageGroupSize) == 0 ? 0 : 1);
			int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);

			int pageCount = count / onePageCnt + (count % onePageCnt == 0 ? 0 : 1);
			int startPage = pageGroupSize * (numPageGroup - 1) + 1;
			int endPage = startPage + pageGroupSize - 1;

			if (pageGroupCount == numPageGroup) {
				endPage = maxPage;
			}

			Map<String, Object> pagingData = new HashMap<String, Object>();

			pagingData.put("pageCount", pageCount);
			pagingData.put("startPage", startPage);
			pagingData.put("endPage", endPage);

			pagingData.put("currentPage", currentPage);
			pagingData.put("startRow", startRow);
			pagingData.put("endRow", endRow);
			pagingData.put("count", count);
			pagingData.put("onePageCnt", onePageCnt);
			pagingData.put("number", number);
			pagingData.put("pageGroupSize", pageGroupSize);
			pagingData.put("numPageGroup", numPageGroup);
			pagingData.put("pageGroupCount", pageGroupCount);
			pagingData.put("maxPage", maxPage);

			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("list", list);
			returnMap.put("pagingData", pagingData);
			return returnMap;
		} else {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("list", null);

			Map<String, Object> pagingData = new HashMap<String, Object>();

			pagingData.put("startPage", 1);
			pagingData.put("endPage", 1);
			pagingData.put("currentPage", 1);
			returnMap.put("pagingData", pagingData);
			return returnMap;
		}

	}
}

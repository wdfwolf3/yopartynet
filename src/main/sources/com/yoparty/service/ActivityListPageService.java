package com.yoparty.service;

import com.yoparty.mapper.ActivityMapper;
import com.yoparty.page.ActivityListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/3/24.
 */
@Service
public class ActivityListPageService {
    @Autowired
    private ActivityMapper activityMapper;

    private ActivityListPage page;
    private int pageSize;
    private int pageNow;
    private String sort = "ASC";
    private String column;
    private String keyword;
    private String searchType;
    private String type1;
    private String type2;
    private String type3;
    private int startIndex;

    public List<ActivityAjax> getActivityList(HttpServletRequest request) {
        initParameter(request);
        return select();
    }

    public void initParameter(HttpServletRequest request) {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
        pageNow = Integer.parseInt(request.getParameter("pageNow"));
        startIndex = (pageNow - 1) * pageSize;
        sort = request.getParameter("sort");
        if (!"prior_status".equals(request.getParameter("column"))) {
            column = request.getParameter("column");
        } else {
            column = "id";
        }
        if ("".equals(request.getParameter("eventInfoFormMap.keyword"))) {
            keyword = null;
        } else {
            keyword = "%" + request.getParameter("eventInfoFormMap.keyword") + "%";
        }
        if ("0".equals(request.getParameter("eventInfoFormMap.searchType"))) {
            searchType = "title";
        } else {
            searchType = "leader_name";
        }
        if (request.getParameter("eventInfoFormMap.type0") != null) {
            type1 = null;
            type2 = null;
            type3 = null;
        }
        if (request.getParameter("eventInfoFormMap.type1") != null) {
            switch (Integer.parseInt(request.getParameter("eventInfoFormMap.type1"))) {
                case 1:
                    type1 = "脱单";
                    break;
                case 2:
                    type1 = "纯玩";
                    break;
            }
        }
        if (request.getParameter("eventInfoFormMap.type2") != null) {
            switch (Integer.parseInt(request.getParameter("eventInfoFormMap.type2"))) {
                case 1:
                    type2 = "休闲";
                    break;
                case 2:
                    type2 = "轻量";
                    break;
                case 3:
                    type2 = "专业";
                    break;
            }
        }
        if (request.getParameter("eventInfoFormMap.type3") != null) {
            switch (Integer.parseInt(request.getParameter("eventInfoFormMap.type3"))) {
                case 1:
                    type3 = "1日活动";
                    break;
                case 2:
                    type3 = "2日活动";
                    break;
                case 3:
                    type3 = "3日活动";
                    break;
                case 5:
                    type3 = "5日活动";
                    break;
                case 7:
                    type3 = "7日活动";
                    break;
            }
        }
    }

    public List<ActivityAjax> select() {
        page = new ActivityListPage();
        page.setPageSize(pageSize);
        page.setPageNow(pageNow);
        page.setSort(sort);
        page.setColumn(column);
        page.setKeyword(keyword);
        page.setSearchType(searchType);
        page.setType1(type1);
        page.setType2(type2);
        page.setType3(type3);
        page.setStartIndex(startIndex);
        return activityMapper.select(page);
    }

    public ActivityListPage getPage() {
        return page;
    }

    public void setPage(ActivityListPage page) {
        this.page = page;
    }
}

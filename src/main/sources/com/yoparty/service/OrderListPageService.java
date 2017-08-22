package com.yoparty.service;

import com.yoparty.mapper.SignupUserMapper;
import com.yoparty.page.OrderListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/4/5.
 */
@Service
public class OrderListPageService implements Serializable {
    @Autowired
    private SignupUserMapper signupUserMapper;

    private OrderListPage page;

    public List<OrderAjax> getActivityList(HttpServletRequest request, Integer userId) {
        initParameter(request, userId);
        return select();
    }

    public void initParameter(HttpServletRequest request, Integer userId) {
        page = new OrderListPage();
        page.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        page.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        if (request.getParameter("eventOrderFormMap.status") != null) {
            page.setStatus(Integer.parseInt(request.getParameter("eventOrderFormMap.status")));
        }
        page.setStartIndex((page.getPageNow() - 1) * page.getPageSize());
        page.setUserId(userId);
    }

    public List<OrderAjax> select() {
        List<OrderAjax> orderAjaxList = signupUserMapper.select(page);
        if (orderAjaxList == null) {

        } else {
            page.setRowCount(orderAjaxList.size());
        }
        return orderAjaxList;
    }

    public OrderListPage getPage() {
        return page;
    }

    public void setPage(OrderListPage page) {
        this.page = page;
    }
}

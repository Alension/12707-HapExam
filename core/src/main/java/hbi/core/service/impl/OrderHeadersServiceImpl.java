package hbi.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.dto.HeaderQueryVo;
import hbi.core.dto.OrderHeaders;
import hbi.core.dto.OrdersExcel;
import hbi.core.mapper.OrderHeadersMapper;
import hbi.core.service.OrderHeadersService;
import hbi.core.util.Excel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 2016/12/15.
 */
@Service
@Transactional
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements OrderHeadersService {
    @Autowired
    private OrderHeadersMapper orderHeadersMapper;
    @Override
    public List<OrderHeaders> getAllOrders(IRequest IRequest, HeaderQueryVo headerQueryVo,int page,int pagesize
    ) {
        PageHelper.startPage(page,pagesize);
        List<OrderHeaders>  list= orderHeadersMapper.getAllOrder(headerQueryVo);

        return list;
    }

    @Override
    public String excelExport(List<String> header, List<OrderHeaders> list) throws IllegalAccessException {
        List<OrdersExcel> list1=new ArrayList<>();
        for(OrderHeaders order:list){
            OrdersExcel excel=new OrdersExcel();
            excel.setOrderNumber(order.getOrderNumber());
            excel.setCompanyName(order.getCompanys().getCompanyName());
            excel.setCustomerName(order.getCustomers().getCustomerName());
            excel.setOrderDate(order.getOrderDate());
            excel.setItemDescription(order.getItems().getItemDescription());
            excel.setOrderPrice(order.getOrderPrice());
            excel.setOrderdQuantity(order.getOrderLines().getOrderdQuantity());
            excel.setUnitSellingPrice(order.getOrderLines().getUnitSellingPrice());
            excel.setOrderStatus(order.getOrderStatus());
            excel.setItemCode(order.getItems().getItemCode());
            list1.add(excel);
        }

        return Excel.Export(header,list1);
    }

    @Override
    public int insertOrder(OrderHeaders orderHeaders) {
        return orderHeadersMapper.insert(orderHeaders);
    }
}

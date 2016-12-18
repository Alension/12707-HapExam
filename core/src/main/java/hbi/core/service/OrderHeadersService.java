package hbi.core.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.dto.HeaderQueryVo;
import hbi.core.dto.OrderHeaders;
import hbi.core.dto.OrdersExcel;

import java.util.List;

/**
 * Created by Alen on 2016/12/15.
 */
public interface OrderHeadersService extends IBaseService<OrderHeaders>, ProxySelf<OrderHeadersService> {
    List<OrderHeaders> getAllOrders(IRequest IRequest, HeaderQueryVo headerQueryVo,int page,int pagesize);

    String excelExport(List<String> header,List<OrderHeaders> list) throws IllegalAccessException;

    int insertOrder(OrderHeaders orderHeaders);

}

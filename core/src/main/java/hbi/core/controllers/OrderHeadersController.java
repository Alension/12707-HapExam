package hbi.core.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.dto.HeaderQueryVo;
import hbi.core.dto.OrderHeaders;
import hbi.core.dto.OrdersExcel;
import hbi.core.service.OrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 2016/12/15.
 */
@Controller
@RequestMapping("/order")
public class OrderHeadersController extends BaseController {
    @Autowired
    private OrderHeadersService orderHeadersService;

    @RequestMapping("/query")
    @ResponseBody
    public List<OrderHeaders> getAll(HttpServletRequest request,  HeaderQueryVo headerQueryVo,
                                     @RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int pagesize) {
       IRequest iRequest= createRequestContext(request);

       return  orderHeadersService.getAllOrders(iRequest,headerQueryVo,page,pagesize);
    }

    @RequestMapping("/update")
    @ResponseBody
    public int OrderHeaderUpdate(HttpServletRequest request,@RequestBody OrderHeaders orderHeaders){

        return  orderHeadersService.insertOrder(orderHeaders);
    }

    @RequestMapping("/excel")
    @ResponseBody
    public String OrderExcel(@RequestBody List<OrderHeaders> list) throws IllegalAccessException {
        List<String> header=new ArrayList<>();
        header.add("销售订单号");
        header.add("公司名称");
        header.add("客户名称");
        header.add("订单日期");
        header.add("订单状态");
        header.add("物料编码");
        header.add("物料描述");
        header.add("数量");
        header.add("销售单价");
        header.add("金额");
        return orderHeadersService.excelExport(header,list);
    }
}

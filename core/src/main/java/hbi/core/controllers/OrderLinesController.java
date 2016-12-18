package hbi.core.controllers;

import com.hand.hap.system.dto.ResponseData;
import hbi.core.dto.OrderHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alen on 2016/12/17.
 */
@Controller
public class OrderLinesController {
    @RequestMapping("/line/new")
    public void newOrder(HttpServletRequest request,HttpServletResponse response,Integer headerId) throws ServletException, IOException {
        request.setAttribute("headerId",headerId);
        request.getRequestDispatcher("/order_detail.html").forward(request,response);
    }

    @RequestMapping("/line/query")
    @ResponseBody
    public OrderHeaders queryOrder(Integer headerId){
        OrderHeaders orderHeaders=null;
            if (headerId==null){
                return orderHeaders;
            }else{

            }
        return orderHeaders;
    }

    @RequestMapping("/line/update")
    public void updateOrder(){

    }
}

package hbi.core.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.dto.HeaderQueryVo;
import hbi.core.dto.OrderHeaders;

import java.util.List;

/**
 * Created by Alen on 2016/12/15.
 */
public interface OrderHeadersMapper extends Mapper<OrderHeaders>{
    List<OrderHeaders> getAllOrder(HeaderQueryVo headerQueryVo);
}

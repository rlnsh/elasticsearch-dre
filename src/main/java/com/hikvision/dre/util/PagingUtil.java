package com.hikvision.dre.util;

import com.hikvision.dre.bean.es.query.response.ESQueryResponseBean;
import com.hikvision.dre.common.app.AppPagingRequest;
import com.hikvision.dre.common.app.AppPagingResponse;
import com.hikvision.dre.common.app.PageProp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Map;

/**
 * 分页公共方法
 * Created by wangdd on 2018/8/1.
 */
public class PagingUtil {

    /**
     * 将Map转换成Bean
     *
     * @param clazz
     * @param map
     * @param field  需要格式化的字段 可以传空
     * @param format 格式 默认（yyyy-MM-dd HH:mm:ss）
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Class<T> clazz, Map<String, Object> map, String[] field, String format) {
        if (format == null || format.trim().length() == 0) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        String finalFormat = format;
        PropertyEditorSupport dateProp = new PropertyEditorSupport() {
            @Override
            public void setValue(Object value) {
                super.setValue(DateUtils.format((Date) value, finalFormat));
            }
        };
        if (!BeanUtils.isSimpleValueType(clazz)) {
            DataBinder binder = new DataBinder(BeanUtils.instantiateClass(clazz));
            binder.setAutoGrowNestedPaths(true);// 设置点分法访问 "属性对象.属性"
            binder.registerCustomEditor(String.class, "expireTime", dateProp);
            binder.registerCustomEditor(String.class, "createTime", dateProp);
            binder.registerCustomEditor(String.class, "modifyTime", dateProp);
            binder.registerCustomEditor(String.class, "receiveTime", dateProp);
            binder.registerCustomEditor(String.class, "completeTime", dateProp);
            binder.registerCustomEditor(String.class, "birthDay", dateProp);
            binder.registerCustomEditor(String.class, "startDate", dateProp);
            binder.registerCustomEditor(String.class, "endDate", dateProp);
            binder.registerCustomEditor(String.class, "cancelDate", dateProp);
            binder.registerCustomEditor(String.class, "refundDate", dateProp);
            if (field != null && field.length > 0) {
                for (int i = 0; i < field.length; i++) {
                    binder.registerCustomEditor(String.class, field[i], dateProp);
                }

            }
            binder.bind(new MutablePropertyValues(map));
            return (T) binder.getTarget();
        }
        return null;
    }

    /**
     * 更新入参
     * @param request
     */
    public static void updatePageRequest(AppPagingRequest request) {
        request.setFrom((long) (request.getPageIndex() * request.getPageSize()));
        request.setSize(request.getPageSize());
    }

    /**
     * 封装分页信息
     *
     * @param resp
     * @param request
     * @param bean
     */
    public static void updatePageProp(AppPagingResponse resp, AppPagingRequest request, ESQueryResponseBean bean) {
        PageProp prop = new PageProp();
        prop.setFrom(request.getFrom());
        prop.setPageSize(request.getPageSize());
        prop.setPageIndex(request.getFrom() / request.getSize());
        long jdCount = bean.getHits().getTotal() != null ? bean.getHits().getTotal() : 0;
        prop.setPageCount(jdCount % request.getSize() == 0 ? jdCount / request.getSize() : jdCount / request.getSize() + 1);
        prop.setTotal(jdCount);
        resp.setPageProp(prop);
    }


}

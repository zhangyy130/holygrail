package pub.avalon.holygrail.response.views;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import pub.avalon.holygrail.response.beans.JsonResultInfo;
import pub.avalon.beans.Limit;
import pub.avalon.holygrail.response.beans.ResultInfo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 白超
 * @date 2018/6/3
 */
public class JsonView extends LinkedHashMap<String, Object> implements DataView {

    @Override
    public ResultInfo getResultInfo() {
        Map map = (Map) this.get(MessageView.RESULT_INFO_PARAM);
        if (map == null) {
            return null;
        }
        JsonResultInfo resultInfo = new JsonResultInfo();
        resultInfo.putAll(map);
        return resultInfo;
    }

    public <T> T getRecord(Class<T> clazz) {
        Object obj = this.get(ModelView.RECORD_KEY);
        if (obj == null) {
            return null;
        }
        return TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance());
    }

    public <K, V> Map<K, V> getRecords() {
        return (Map<K, V>) this.get(ModelView.RECORDS_KEY);
    }

    public <T> T getRecords(Class<T> clazz) {
        Object obj = this.get(ModelView.RECORD_KEY);
        if (obj == null) {
            return null;
        }
        return TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance());
    }

    public <T> ArrayList<T> getRows(Class<T> clazz) {
        ArrayList<T> rows = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) this.get(LimitDataView.ROWS_KEY);
        if (jsonArray == null) {
            return rows;
        }
        for (Object obj : jsonArray) {
            rows.add(TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance()));
        }
        return rows;
    }

    public <T> ArrayList<T> getRows(Class<T> clazz, Function<T, T> formatter) {
        ArrayList<T> rows = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) this.get(LimitDataView.ROWS_KEY);
        if (jsonArray == null) {
            return rows;
        }
        for (Object obj : jsonArray) {
            rows.add(formatter.apply(TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance())));
        }
        return rows;
    }

    public <T extends Limit> T getLimit(Class<T> clazz) {
        Object obj = this.get(PageView.LIMIT_KEY);
        if (obj == null) {
            return null;
        }
        return TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance());
    }
}

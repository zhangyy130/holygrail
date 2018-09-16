package pub.avalon.beans;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 时间
 *
 * @author 白超
 * @date 2018/8/24
 */
public interface Time {

    String TIME_SIMPLE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd
     */
    static String localDateNow() {
        return LocalDate.now().toString();
    }

    /**
     * 获取当前时间
     *
     * @return HH:mm:ss.SSSZ
     */
    static String localTimeNow() {
        return LocalTime.now().toString();
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-ddTHH:mm:ss.SSSZ
     */
    static String localDateTimeNow() {
        return LocalDateTime.now().toString();
    }

    /**
     * 获取时间戳
     *
     * @return 毫秒级时间戳
     */
    static long timeStamp() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 获取当前简化字符串时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    static String localDateTimeNowSimple() {
        return Time.localDateNow() + " " + Time.localTimeNow().substring(0, 8);
    }

    /**
     * 时间戳转为简化版字符串时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     */
    static String timeStampToSimpleString(long timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_SIMPLE_FORMATTER);
        return dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
    }

    /**
     * 简化字符串时间转时间戳
     *
     * @param timeStr
     * @return
     */
    static long simpleStringToTimeStamp(String timeStr) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern(TIME_SIMPLE_FORMATTER);
        LocalDateTime parse = LocalDateTime.parse(timeStr, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
package com.avalon.holygrail.db.model;

import com.avalon.holygrail.db.norm.ColumnType;
import com.avalon.holygrail.db.norm.IndexMethod;
import com.avalon.holygrail.db.norm.IndexType;

import java.util.Objects;

/**
 * 数据库列
 *
 * @author 白超
 * @date 2018/2/8
 */
public abstract class AbstractColumn {

    /**
     * 列名
     */
    protected String name;

    /**
     * 列类型
     */
    protected ColumnType columnType;

    /**
     * 长度
     */
    protected int length = 1;

    /**
     * 小数长度
     */
    protected int decimalLength;

    /**
     * 主键
     */
    protected boolean primaryKey;

    /**
     * 自增长
     */
    protected boolean autoIncrement;

    /**
     * 自增长开始值
     */
    protected int autoIncrementStartValue = 0;

    /**
     * 无符号
     * 表示全为正数,如: -128~127 => 0~255
     */
    protected boolean unsigned;

    /**
     * 填充零
     */
    protected boolean zerofill;

    /**
     * 非空
     */
    protected boolean notNull;

    /**
     * 默认值
     */
    protected String defaultValue;

    /**
     * 注释
     */
    protected String comment;

    /**
     * 是否使用索引
     */
    protected boolean useIndex;

    /**
     * 索引名称
     */
    protected String indexName;

    /**
     * 索引类型
     */
    protected IndexType indexType;

    /**
     * 索引方法
     */
    protected IndexMethod indexMethod;

    /**
     * 索引注释
     */
    protected String indexComment;

    public AbstractColumn() {
    }

    public AbstractColumn(String name, ColumnType columnType, int length) {
        this.name = name;
        this.columnType = columnType;
        this.length = length;
    }

    public AbstractColumn(String name, ColumnType columnType, int length, String comment) {
        this.name = name;
        this.columnType = columnType;
        this.length = length;
        this.comment = comment;
    }

    abstract public boolean isPrimaryKey();

    abstract public String getName();

    abstract public ColumnType getColumnType();

    abstract public int getLength();

    abstract public int getDecimalLength();

    abstract public int getAutoIncrementStartValue();

    abstract public boolean isUnsigned();

    abstract public boolean isZerofill();

    abstract public boolean isNotNull();

    abstract public String getDefaultValue();

    abstract public String getComment();

    abstract public boolean isUseIndex();

    abstract public String getIndexName();

    abstract public IndexType getIndexType();

    abstract public IndexMethod getIndexMethod();

    abstract public String getIndexComment();

    abstract public String buildColumnCreateSql();

    public void setPrimaryKey(boolean primaryKey) {
        if (primaryKey) {
            this.setNotNull(true);
        }
        this.primaryKey = primaryKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDecimalLength(int decimalLength) {
        this.decimalLength = decimalLength;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public void setUnsigned(boolean unsigned) {
        this.unsigned = unsigned;
    }

    public void setZerofill(boolean zerofill) {
        this.zerofill = zerofill;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUseIndex(boolean useIndex) {
        this.useIndex = useIndex;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public void setIndexType(IndexType indexType) {
        this.indexType = indexType;
    }

    public void setIndexMethod(IndexMethod indexMethod) {
        this.indexMethod = indexMethod;
    }

    public void setIndexComment(String indexComment) {
        this.indexComment = indexComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractColumn column = (AbstractColumn) o;
        return Objects.equals(name, column.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
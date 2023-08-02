package com.test.queryPasing;

import lombok.Data;

@Data
public class SelectDTO {
    private String tableName;
    private String column;
    private String where;
    private String orderBy;
    private String groupBy;
    

}

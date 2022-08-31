package com.elite.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 文件类型
 */
@Getter
@AllArgsConstructor
public enum FileTypeEnum {
    CSV("CSV","CSV文件"),
    XLS("XLS","XLS文件"),
    XLSX("XLSX","XLSX文件"),
    TXT("TXT","TXT文件");
    private String fileType;
    private String fileName;
}

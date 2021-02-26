package com.test.myDemo.util;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author liang.gu
 * @date 2021/2/5
 */
public class FileTest {

    private static final int FILE_ENTRY_LIMIT = 1000;

    private static final String FILE_EXTENSION = ".xlsx";

    /*** 放款文件名称*/
    private static final DateTimeFormatter DISBURSEMENT_FILE_NAME = DateTimeFormatter.ofPattern("'disbursement_file_'yyyyMMdd");

    /*** 放款feedback文件名称*/
    private static final DateTimeFormatter FEEDBACK_DISBURSEMENT_FILE_NAME = DateTimeFormatter.ofPattern("'Report_disbursement_file_'yyyyMMdd");

    /*** 放款文件目录*/
    private static final DateTimeFormatter FILE_DIRECTORY = DateTimeFormatter.ofPattern("'Folder 'yyyy'/Folder Disbursement file/folder 'MMMM'/folder 'yyyyMMdd'/'", Locale.ENGLISH);

    /*** KTP文件目录*/
    private static final DateTimeFormatter FILE_KTP_DIRECTORY = DateTimeFormatter.ofPattern("'Folder 'yyyy'/Folder KTP file/folder 'MMMM'/folder 'yyyyMMdd'/'", Locale.ENGLISH);


    public static void main(String[] args) {
        FileTest.buildFile("test");
    }

    public static File buildFile( String fileName) {
        File tmpFile = null;
        try {
            tmpFile = File.createTempFile(fileName, null);
            System.out.println(tmpFile.getParent());
            File file = new File(tmpFile.getParent(), fileName);
            tmpFile.renameTo(file);
            return file;
        } catch (Exception ex) {
            System.out.println("${fileName} for CIMB disbursement build fail");
        }
        return null;
    }


}

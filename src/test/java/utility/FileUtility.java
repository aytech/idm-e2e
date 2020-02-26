package utility;

import configuration.Configuration;

import java.io.File;
import java.io.FileNotFoundException;

import static configuration.AppConstants.*;

public class FileUtility {
    private static String fileNamePDF;

    public static String getFileNamePDF() {
        return fileNamePDF;
    }

    public static void setFileNamePDF(String fileNamePDF) {
        FileUtility.fileNamePDF = fileNamePDF;
    }

    public static String getFileNamePrimary() throws IllegalAccessException {
        String path = Configuration.getProperty(IDM_FILENAME_PRIMARY);
        return path.substring(path.lastIndexOf(File.separator) + 1);
    }

    public static String getDownloadedFilePath(String fileName) throws IllegalAccessException {
        return String.format("%s%s%s", Configuration.getProperty(DOWNLOAD_PATH), File.separator, fileName);
    }

    public static void waitForFileToDownload(String filePath) throws InterruptedException, FileNotFoundException {
        File handler;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(DEFAULT_TIMEOUT);
            handler = new File(filePath);
            if (handler.exists()) {
                return;
            }
        }
        throw new FileNotFoundException(String.format("File %s not found", filePath));
    }

    public static void removeDownloadedFile(String fileName) throws IllegalAccessException {
        File file = new File(getDownloadedFilePath(fileName));
        if (file.exists() && file.delete()) {
            System.out.println(String.format("File %s was removed.", fileName));
        }
    }
}

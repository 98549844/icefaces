/*
package com.icefaces.bean;

*/
/**
 * @Classname: FileEntryBean
 * @Date: 2022/8/2
 * @Author: kalam_au
 * @Description:
 *//*



import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings(value = "deprecation")
@ManagedBean(name = FileEntryBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class FileEntryBean implements Serializable {

    public static final String BEAN_NAME = "fileEntry";

    public String getBeanName() {
        return BEAN_NAME;
    }

    private List<UploadedFile> fileData = new ArrayList<UploadedFile>();
    private String totalFiles;
    private String totalSize;

    public void sampleListener(FileEntryEvent e) {
        FileEntry fe = (FileEntry) e.getComponent();
        FileEntryResults results = fe.getResults();
        File parent = null;

        for (FileEntryResults.FileInfo i : results.getFiles()) {
            fileData.add(new UploadedFile(i.getFileName(), i.getSize() + " bytes", i.getContentType(), i.isSaved() ? null : ("File was not saved because: " + i.getStatus().getFacesMessage(FacesContext.getCurrentInstance(), fe, i).getSummary())));

            if (i.isSaved()) {
                File file = i.getFile();
                if (file != null) {
                    parent = file.getParentFile();
                }
            }
        }

        if (parent != null) {
            long dirSize = 0;
            int fileCount = 0;
            for (File file : parent.listFiles()) {
                fileCount++;
                dirSize += file.length();
            }
            totalFiles = "Total Files in Upload Directory: " + fileCount;
            totalSize = "Total Size of Files In Directory: " + dirSize + " bytes";
        }
    }

    public List getFileData() {
        return fileData;
    }

    public String getTotalFiles() {
        return totalFiles;
    }

    public String getTotalSize() {
        return totalSize;
    }


    public static class UploadedFile implements Serializable {
        private static final long serialVersionUID = 4803879439245875558L;
        private String name;
        private String size;
        private String contentType;
        private String info;

        UploadedFile(String name, String size, String contentType, String info) {
            this.name = name;
            this.size = size;
            this.contentType = contentType;
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

        public String getContentType() {
            return contentType;
        }

        public String getInfo() {
            return info;
        }
    }
}
*/

package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.ServletPath;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class UploadImageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UploadImageCommand.class);
    private static final String UPLOAD_DIR = "uploads";
    private static final String SLASH = "/";
    private static final String BLANK = "";
    private static final String EXTENSION_SEPARATOR = ".";
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 5 * 5;
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        String uploadPath = defineUploadPath(request);
        List<FileItem> items;
        File file = new File(uploadPath);
        DiskFileItemFactory factory = new DiskFileItemFactory(FILE_SIZE_THRESHOLD, file);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        Iterator<FileItem> iterator;
        try {
            items = upload.parseRequest(request);
            iterator = items.iterator();
            if (iterator.hasNext()) {
                FileItem fileItem = iterator.next();
                String localPath = saveItem(fileItem, request);
                service.updateUserImage(user.getAccount().getId(), localPath);
                user.setImageName(localPath);
            }
        } catch (FileUploadException | ServiceException e) {
            LOGGER.error(e);
        }
        return ProjectPage.PERSONAL_DATA.getServletCommand();
    }

    private String defineUploadPath(HttpServletRequest request) {
        String applicationDir = request.getServletContext().getRealPath(BLANK);
        String uploadPath = applicationDir + UPLOAD_DIR + File.separator;
        File fileSaveDir = new File(uploadPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        return uploadPath;
    }

    private String saveItem(FileItem fileItem, HttpServletRequest request) {
        String uploadPath = defineUploadPath(request);
        String uploadName = generateName(fileItem.getName());
        File uploadedFile = new File(uploadPath + uploadName);
        String contextPath;
        try {
            String itemName = fileItem.getName();
            fileItem.write(uploadedFile);
            LOGGER.info("File {} was successfully uploaded!", itemName);
            contextPath = SLASH + UPLOAD_DIR + SLASH + uploadName;
        } catch (Exception e) {
            LOGGER.info("Unable to save file!", e);
            contextPath = null;
        }
        return contextPath;
    }

    private String generateName(String realName) {
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString();
        int index = realName.lastIndexOf(EXTENSION_SEPARATOR);
        String extension = realName.substring(index);
        return name + extension;
    }
}

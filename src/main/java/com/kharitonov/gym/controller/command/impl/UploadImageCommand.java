package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
        File file = new File(uploadPath);
        DiskFileItemFactory factory = new DiskFileItemFactory(FILE_SIZE_THRESHOLD, file);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        String page;
        try {
            FileItem fileItem = upload.parseRequest(request).get(0);
            String localPath = saveItem(fileItem, request);
            if (service.updateUserImage(user.getAccount().getId(), localPath)) {
                user.setImageName(localPath);
                page = PagePath.PERSONAL_DATA.getServletCommand();
            } else {
                page = PagePath.ERROR_404.getDirectUrl();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
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

    private String saveItem(FileItem fileItem, HttpServletRequest request) throws Exception {
        String uploadPath = defineUploadPath(request);
        String uploadName = generateName(fileItem.getName());
        File uploadedFile = new File(uploadPath + uploadName);
        String itemName = fileItem.getName();
        fileItem.write(uploadedFile);
        LOGGER.info("File {} was successfully uploaded!", itemName);
        return SLASH + UPLOAD_DIR + SLASH + uploadName;
    }

    private String generateName(String realName) {
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString();
        int index = realName.lastIndexOf(EXTENSION_SEPARATOR);
        String extension = realName.substring(index);
        return name + extension;
    }
}

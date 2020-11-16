package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ContextParameterName;
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

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * This command allows the user to upload and save new profile image
 */
public class UploadImageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UploadImageCommand.class);
    private static final String SLASH = "/";
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
                page = PagePath.PERSONAL_DATA.getServletPath();
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
        ServletContext context = request.getServletContext();
        String uploadPath = context.getInitParameter(ContextParameterName.UPLOAD_SOURCE);
        return uploadPath;
    }

    private String saveItem(FileItem fileItem, HttpServletRequest request) throws Exception {
        String itemName = fileItem.getName();
        String uploadName = generateName(itemName);
        String uploadPath = defineUploadPath(request);
        File uploadedFile = new File(uploadPath + uploadName);
        ServletContext context = request.getServletContext();
        String uploadAppPath = context.getInitParameter(ContextParameterName.UPLOAD_DESTINATION);
        File appFile =
                new File(request.getServletContext().getRealPath(SLASH) + uploadAppPath + SLASH + uploadName);
        fileItem.write(uploadedFile);
        fileItem.write(appFile);
        LOGGER.info("File {} was successfully uploaded!", itemName);
        return uploadAppPath + uploadName;
    }

    private String generateName(String realName) {
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString();
        int index = realName.lastIndexOf(EXTENSION_SEPARATOR);
        String extension = realName.substring(index);
        return name + extension;
    }
}

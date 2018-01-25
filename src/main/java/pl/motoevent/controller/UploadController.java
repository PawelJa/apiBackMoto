package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.motoevent.entity.User;
import pl.motoevent.repository.UserRepository;
import pl.motoevent.security.UserPrincipal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
@RequestMapping("/file")
public class UploadController {

    @Autowired
    private UserRepository userRepository;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/magda/IdeaProjects/apiBackMoto/src/main/resources/views/images/uploaded/avatar_";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@AuthenticationPrincipal UserPrincipal principal,
                                   @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/user/add_file/uploadStatus.jsp";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            String username = principal.getUsername();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            User user = userRepository.findByUsername(username);
            user.setAvatar(UPLOADED_FOLDER + file.getOriginalFilename());
            userRepository.save(user);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/user/menu/menu.html";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "/user/add_file/uploadStatus";
    }

}
package app.controller;

import app.entity.SessionInfo;
import app.repository.SessionInfoRepository;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@RequestMapping("/")
@Controller
public class TableController {

    @Autowired
    SessionInfoRepository sesRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String MainPage(Model model) {
        model.addAttribute("sessions", sesRepo.findAll());
        return "main";
    }

    @PostMapping
    public String addSes(
            @RequestParam("file") MultipartFile file,
        Model model) throws IOException {
        File result = null;
        if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String resultFilename = file.getOriginalFilename();
                result = new File(uploadPath + "/" + resultFilename);
                file.transferTo(result);
                ArrayList<SessionInfo> s = new ArrayList<>();

                Deserializer deserializer = CsvIOFactory.createFactory(SessionInfo.class).createDeserializer();
                BufferedReader reader = new BufferedReader(new FileReader(result));
                reader.readLine();
                deserializer.open(reader);
                while (deserializer.hasNext()) {
                    SessionInfo p = deserializer.next();
                    s.add(p);
                }
                sesRepo.saveAll(s);
                deserializer.close(true);
        }
        return "redirect:/";
    }

    @GetMapping ("usedforms")
    public String usedforms(Model model){
        HashSet<String> users = sesRepo.findSsoid();
        List<Map> result = new ArrayList<>();
        for (String user : users){
            HashSet<String> forms = sesRepo.findForms(user);
            String formsRes = "";
            for (String form: forms) formsRes+= form + "; ";
            Map<String,String> map = new HashMap<>();
            map.put("user", user);
            map.put("forms", formsRes);
            result.add(map);
        }
        model.addAttribute("usedforms", result);
        return "usedforms";
    }

    @GetMapping ("top5")
    public String top5(Model model) {
        HashSet<String> forms = sesRepo.findGrp();
        HashMap<Integer, String> top = new HashMap<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for (String form: forms){
            int count = sesRepo.countGrp(form);
            top.put(count,form);
            counts.add(count);
        }
        List <Map> top5 = new ArrayList<Map>();
        for (int i = 0; i<5 ; i++ ){
           Integer max =  Collections.max(counts);
           Map<String,String> map = new HashMap<>();
           map.put("grp", top.get(max));
           map.put("count", String.valueOf(max));
           counts.remove(max);
           top5.add(map);
        }
        model.addAttribute("top5",top5);
        return "top5";
    }

    @GetMapping ("notfinished")
    public String notfinished(Model model){
        List<SessionInfo> s = sesRepo.findBySubtypeNot("send");
        model.addAttribute("sessions", s);
        return "notfinished";
    }
}
